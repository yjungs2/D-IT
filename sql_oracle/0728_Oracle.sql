-- 0728
-- <<��������>>
-- CLARK ������� �� ���� �޿��� �޴� ����� �˻�
-- 1)
SELECT sal FROM emp WHERE ename='CLARK'; -- 2450
SELECT ename, sal FROM emp WHERE sal>2450;
-- 2)
-- ���������� �ݵ�� ()�� ������� �Ѵ�. () ���� �ذ�
SELECT ename, sal FROM emp WHERE sal>(SELECT sal FROM emp WHERE ename='CLARK');
-- 2450 ����(��Į��) : one row, one column ��(���� ��)

-- (157������ ���� 1) 7566�� ������� �޿��� ���� �޴� ����� �̸�, �޿��� ��ȸ
SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE empno=7566);

--(157������ ���� 2) emp...�����ȣ�� 7521�� ����� ������ ���� �޿��� 7934�� ������� ���� �����
-- �����ȣ, �̸�, ������, �Ի�����, �޿��� ��ȸ
SELECT empno, ename, job, hiredate, sal
FROM emp
WHERE job=(SELECT job FROM emp WHERE empno=7521)
AND sal>(SELECT sal FROM emp WHERE empno=7934);

-- (157������ ���� 3) emp...�޿��� ���� ���� �޴� ����� �̸�, �μ���ȣ, �޿�, �Ի����� ��ȸ
SELECT ename, deptno, sal, hiredate
FROM emp
WHERE sal = (SELECT max(sal) FROM emp);

-- (158������ ���� 4) emp ���̺��� �޿��� ��պ��� ���� ����� �����ȣ, �̸�, ������, �޿�, �μ���ȣ�� ���
SELECT empno, ename, job, sal, deptno
FROM emp
WHERE sal < (SELECT avg(sal) FROM emp);

-- (158������ ���� 5) emp ���̺��� ����� �޿��� 20�� �μ��� �ּ� �޿����� ���� �μ��� ��ȸ
SELECT deptno, min(sal)
FROM emp
GROUP BY deptno
HAVING min(sal) > (SELECT min(sal) FROM emp WHERE deptno=20);

-- emp ���̺��� �޿��� ���� ���� �޴� ��� 3���� �˻�
SELECT ename, job, sal FROM (SELECT * FROM emp ORDER BY sal) WHERE rownum<=3;

-- ���� �� ���� ����
/*
sal < ANY : �ִ밪���� ���� sal
sal > ANY : �ּҰ����� ū sal
sal = ANY : IN�� ����

sal < ALL : �ּҰ����� ���� sal
sal > ALL : �ִ밪���� ū sal
*/

-- (160������ ���� 2) ������ SALESMAN�� �ּ� �� �� �̻��� ������� �޿��� ���� �޴� ����� �̸�, �޿�, ������ ��ȸ 
SELECT ename, sal, job
FROM emp
WHERE job!='SALESMAN'
AND sal > ANY(SELECT sal FROM emp WHERE job='SALESMAN');

-- (160������ ���� 3) ������ SALESMAN�� ��� ������� �޿��� ���� �޴� ����� �̸�, �޿�, ����, �Ի���, �μ���ȣ�� ��ȸ
SELECT ename, sal, job, hiredate, deptno
FROM emp
WHERE job!='SALESMAN'
AND sal > ALL(SELECT sal FROM emp WHERE job='SALESMAN');


-- ���� �� ���� ����
-- FORD, BLAKE�� ������ �� �μ��� ���� ����� ���� ��ȸ
-- (162������ ���� 1) NON-PAIRWISE
SELECT ename, mgr, deptno
FROM emp
WHERE mgr IN (SELECT mgr FROM emp WHERE ename IN ('FORD', 'BLAKE'))
AND deptno IN (SELECT deptno FROM emp WHERE ename IN ('FORD', 'BLAKE'))
AND ename NOT IN ('FORD', 'BLAKE');
-- (163������ ���� 2) PAIRWISE
SELECT ename, mgr, deptno
FROM emp
WHERE (mgr, deptno) IN (SELECT mgr, deptno FROM emp WHERE ename IN ('FORD', 'BLAKE'))
AND ename NOT IN ('FORD', 'BLAKE');