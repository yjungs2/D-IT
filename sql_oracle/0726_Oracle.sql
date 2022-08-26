-- 0726
-- <<< ���� �� �Լ� >>>

-- << �����Լ� >>
-- substr(���ڿ�, ���� ��ġ, ����) : ������ ��ġ���� ������ ���̸�ŭ�� ���ڿ��� ����
-- emp ���̺��� ���� �߿��� SALESMAN ������ SALES�� ��µǵ��� ���ڿ� ����
SELECT DISTINCT(SUBSTR('SALESMAN', 1, 5)) FROM emp;

-- emp ���̺��� �μ���ȣ�� 10�� �μ��� ����� �Ի��� �� ���� �����ؼ� ���
-- ��� �̸�, ����, �μ���ȣ, "�Ի��� ��" ���÷��� �ϼ���.
SELECT ename, job, deptno, SUBSTR(hiredate, 4, 2) "�Ի��� ��"
FROM emp
WHERE deptno = 10;

-- ���� �����ϸ� defalut�� ���� ������ ���
-- ���̺��� �ʿ������ FROM �����ϸ� ���� ���Ƿ� FROM dual ���
SELECT SUBSTR('HelloWorld', 6) FROM dual;
SELECT SUBSTR('HelloWorld', 6, 3) FROM dual; -- Wor
SELECT SUBSTR('HelloWorld', -4, 2) FROM dual; -- or
SELECT SUBSTR('HelloWorld', -1, 1) FROM dual; -- d

--  upper() : ��� �빮�ڷ�
SELECT empno, ename, deptno
FROM emp
WHERE ename=UPPER('scott');
-- lower() : ��� �ҹ��ڷ�
SELECT empno, ename, deptno
FROM emp
WHERE LOWER(ename)='scott';

-- initcap() : ���ڿ� �ܾ��� ù ���ڴ� �빮��, �������� �ҹ��ڷ� ����
-- emp ���̺��� blake��� ����� �����ȣ, �μ���ȣ, �̸��� ���.
-- �̶� ù��° �̸��� �빮�ڰ� ��µǵ���
SELECT empno, INITCAP(ename), deptno
FROM emp
WHERE Lower(ename)='blake';

-- INSTR(��� ���ڿ�, ã�� ���ڿ�, ���� ��ġ, �� ��°(���� ����, default=1))
-- ����� �̸� ������ 6��° ö�ڰ� 'R'�� ����� �̸��� �˻�
SELECT ename FROM emp WHERE INSTR(ename, 'R')=6; -- 00000R

-- emp ���̺��� ����� �̸��� 'S'�� ������ ����� �̸�, ����, �Ի����� ���
-- SUBSTR(), INSTR(), LIKE �� ���� ����� �̿��ؼ� �������� �ۼ�
-- (1) substr
SELECT ename, job, hiredate
FROM emp
WHERE SUBSTR(ename, -1) = 'S';
-- (2) like
SELECT ename, job, hiredate
FROM emp
WHERE ename LIKE '%S';
-- (3) instr
SELECT ename, job, hiredate
FROM emp
WHERE INSTR(ename, 'S', -1)=length(ename);

-- SCOTT -> T�� ���� �� �� -> 'TT'
SELECT ename FROM emp WHERE INSTR(ename, 'TT')=4;

-- concat(s1, s2) : �� ���ڿ��� ����
SELECT empno, ename, job, CONCAT(empno, ename) ename, 
CONCAT(ename, empno) e_empno, CONCAT(ename, job) e_job
FROM emp;

-- lpad(), rpad()
SELECT LPAD('abc', 6, '*') FROM dual; -- ***abc
SELECT RPAD('abc', 6, '*') FROM dual; -- abc***

-- ltrim(), rtrim(), trim()
SELECT LTRIM('aaababaaa', 'aa') FROM dual; -- babaaa
SELECT LTRIM('aaababaaa', 'a') FROM dual; -- babaaa
SELECT RTRIM('aaababaaa', 'a') FROM dual; -- aaabab
-- SELECT TRIM('aaababaaa', 'a') FROM dual; -- �� ��
SELECT TRIM('a' from 'aaababaaa') FROM dual; -- bab
-- TRIM�� ���� ������ ������ �� �ַ� ���ȴ�
SELECT TRIM('   bab   ') FROM dual; -- bab
SELECT TRIM('   ba b   ') FROM dual; -- ba b : ��� ���� ���Ŵ� �Ұ����ϴ�.

-- ��� ������ �����Ϸ��� ��� �ؾ��ұ�? REPLACE ����Ѵ�.
SELECT REPLACE('   ba b   ', ' ', '') FROM dual; -- bab

-- (60������ ���� 5) REPLACE �Լ��� ����Ͽ� ��� �̸��� SC���ڿ��� *?�� �����ؼ� ��ȸ
SELECT ename, REPLACE(ename, 'SC', '*?')
FROM emp;

-- << ���� �Լ� >>
-- round()
-- �Ҽ��� 2��° �ڸ����� ��� / �ݿø��� 3��° �ڸ����� �̷����
SELECT ROUND(45.926, 2) FROM dual; -- 45.93
SELECT ROUND(45.926) FROM dual; -- �Ʒ��� ������ ���, default�� 0�̴�.
SELECT ROUND(45.926, 0) FROM dual; -- 46
SELECT ROUND(45.926, -1) FROM dual; -- 50
SELECT ROUND(45.926, -2) FROM dual; -- 0

-- trunc()
-- �ش� �Ҽ��� �ڸ����� ����
SELECT TRUNC(45.926, 2) FROM dual; -- 45.92
SELECT TRUNC(45.926) FROM dual; -- 45, defualt�� 0�̴�.
SELECT TRUNC(45.926, -1) FROM dual; -- 40
SELECT TRUNC(45.926, -2) FROM dual; -- 0

-- (64������ ���� 4) emp ���̺��� �޿��� 30���� ���� �������� ���Ͽ� ���
SELECT sal, MOD(sal, 30)
FROM emp;

-- << ��¥ �Լ� >>
/*
��¥ + ���� = ��¥
��¥ - ���� = ��¥
��¥ - ��¥ = �Ⱓ (����)
��¥ + ��¥ = �Ⱓ (����)
*/
-- sysdate : �����ͺ��̽� ������ ���� ��¥ �� �ð��� ��ȯ�ϴ� ��¥ �Լ�
SELECT sysdate FROM dual; -- 22/07/26
-- ���÷κ��� 100�� ��
SELECT sysdate+100 FROM dual; -- 22/11/03
-- ���� ��¥
SELECT sysdate-1 FROM dual; -- 22/07/25
-- to_date : ���ڸ� ��¥�� ��ȯ
SELECT sysdate - to_date('2022-07-18', 'YYYY-MM-DD') FROM dual; -- 8.45506944444444444444444444444444444444 �ð�����
SELECT trunc(abs(to_date('2022-07-18', 'YYYY-MM-DD')-sysdate)) FROM dual; -- 8 / �Լ� ��ø
-- �������� ���ݱ��� ��ƿ� �ϻ��� ���ϼ���
SELECT trunc(abs(to_date('1998-08-30', 'YYYY-MM-DD')-sysdate)) FROM dual; -- 8731

-- (66������ ���� 2) emp ���̺��� ��������� �ٹ��ϼ��� �� �� �� ���ΰ��� ��ȸ
SELECT hiredate FROM emp; -- hiredate�� 1900���, sysdate�� 2000���� ������ ��µ�
SELECT trunc((sysdate-hiredate)/7, 0) "�ٹ� �� ��", round(mod(sysdate-hiredate, 7), 0) "�ٹ� �� ��"
FROM emp;

-- months_between(D1, D2) : D1, D2 �� ��¥ ���� ��� ���� ��
-- (69������ ���� 1) emp ���̺��� 10�� �μ����� ��������� �ٹ� ������ ����Ͽ� ��ȸ
SELECT ename, TRUNC(MONTHS_BETWEEN(sysdate, TO_DATE(hiredate,'RR/MM/DD'))) "�ٹ�����"
FROM emp WHERE deptno = 10 ORDER BY hiredate ASC;

-- add_months(D1, N) : D1 ��¥�� N���� ����
-- (70������ ���� 2) emp ���̺��� 10�� �μ����� �Ի� ���ڷκ��� 5������ ���� �� ��¥�� ����Ͽ� ���
SELECT ename, hiredate, sysdate, add_months(hiredate, 5) "�Ի� �� 5���� ��¥"
FROM emp
WHERE deptno=10;

-- << ��ȯ �Լ� >>
-- 1. �Ͻ��� ��ȯ : ��ȯ �Լ� ���̵� ��� ������ �ڵ����� ��ȯ��
-- 2. ����� ��ȯ : �ڵ����� ��ȯ���� ���� ���� ������� ��ȯ �Լ� ���
-- to_char(��¥, format), to_number, to_date

-- (74������ ���� 2) ���� ��¥�� 1�� �� ���° ������ ��ȸ�Ѵ�.
-- (��, 1�� 1�Ϻ��� ù° �Ͽ��ϱ����� 1������ �Ѵ�.) (TO_CHAR)
SELECT TO_CHAR(sysdate, 'WW"��"') "N����" FROM dual;

-- (75������ ���� 3) emp ���̺��� 20�� �μ� �� �Ի� ���ڸ� '1998�� 1�� 1��'�� ���·� ���
SELECT ename, hiredate, to_char(to_date(hiredate, 'RR/MM/DD'), 'YYYY"��" MM"��" DD"��"') "�Ի� ����"
FROM emp
WHERE deptno = 20;

-- (75������ ���� 5) '201407'�̶�� ����� ǥ���ϴ� ���ڰ����� 15���� ���� ����� ���ڷ� ǥ��
SELECT TO_CHAR(ADD_MONTHS(TO_DATE('201407', 'YYYYMM'), 15), 'YYYYMM') "15���� ��"
FROM dual; -- 201510

-- (76������ ���� 7) �� ������� �̸�, �Ի���, �Ի��Ϸκ��� ���� �� ��� �� ù��° �Ͽ����� ��¥�� �⵵ 4�ڸ�/�� 2�ڸ�/���� ���·� �������� ��ȸ
SELECT ename, hiredate, TO_CHAR(NEXT_DAY(ADD_MONTHS(TO_DATE(hiredate, 'RR/MM/DD'), 6), '�Ͽ���'), 'YYYY/MM/DD') "6���� �� ù �Ͽ���"
FROM emp;

