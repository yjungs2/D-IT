-- COUNT() : ��� �� ����
SELECT COUNT(*) FROM emp; -- 15
SELECT COUNT(-1) FROM emp;  -- 15

-- �׷��Լ��� NULL ���� �ǳʶڴ�.
SELECT COUNT(MGR) FROM emp; -- 14 
SELECT COUNT(COMM) FROM emp; -- 5

-- emp ���̺��� �μ� ������ ������ �˻�...COUNT()
SELECT COUNT(deptno) FROM emp; -- 15
SELECT COUNT(ALL(deptno)) FROM emp; -- 15
SELECT COUNT(DISTINCT(deptno)) FROM emp; -- 3
-- DISTINCT�� �����ϸ� �Լ��� �ߺ����� �ʴ� ���� �����ϰ�,
-- ALL�� �����ϸ� �ߺ� ���� ������ ���� �����Ѵ�.
-- �⺻���� ALL�̹Ƿ� ������ �ʿ䰡 ����.

-- (92������ ���� 1)
SELECT MIN(ename), MAX(ename), MIN(hiredate), MAX(hiredate)
FROM emp; -- ADAMS, WARD, 1980-12-17, 1983-01-12

-- (92������ ���� 2)
SELECT AVG(sal), MAX(sal), MIN(sal), SUM(sal)
FROM emp
WHERE job='SALESMAN'; -- 1400, 1600, 1250, 5600

-- SELECT COUNT(ALL(deptno)) FROM emp;
-- emp ���̺��� ���ο�, ���ʽ� �޴� �ο����� �˻�
SELECT COUNT(*) ���ο�, COUNT(comm) "���ʽ� �޴� �ο�", AVG(comm) "���ʽ� ���1", ROUND(AVG(NVL(comm, 0))) "���ʽ� ���2"
FROM emp; -- 15, 5, 640, 213

SELECT comm FROM emp;

-- GROUP BY�� :: �׷��� ����ȭ ��Ű�� ���
-- SELECT ��(projection)���� �׷� �Լ��� ������� ���� �÷�(deptno)�� �ݵ�� GROUP BY�� �ڿ� ��õǾ�� �Ѵ�.
-- SELECT deptno, AVG(sal) FROM emp;
-- 1) ������ �׷� �ϳ�
SELECT ROUND(AVG(sal)) FROM emp;
-- 2) ������ �� �׷�
SELECT deptno, AVG(sal)
FROM emp
GROUP BY deptno;
-- 3) ����
-- ORDER BY 1 : deptno ��������
-- ORDER BY 2 : deptno ��������
SELECT deptno, AVG(sal)
FROM emp
GROUP BY deptno
ORDER BY 1;
-- 4) Alias :: GROUP BY�� �ڿ� Alias ��� �� ��
--SELECT deptno DName, ROUND(AVG(sal)) AvgSalary
--FROM emp
-- GROUP BY DName -- ���� : 
--ORDER BY DName;
-- 4') Alias :: ORDER BY�� �ڿ��� Alias ��� ����
SELECT deptno DName, ROUND(AVG(sal)) AvgSalary
FROM emp
GROUP BY deptno
ORDER BY AvgSalary;

-- (95������ ���� 2) �� �μ����� �ο���, �޿��� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���Ͽ� �޿��� ���� ���� ������ ���
SELECT deptno, count(*), avg(sal), min(sal), max(sal), sum(sal)
FROM emp
GROUP BY deptno
ORDER BY sum(sal) desc;

-- (96������ ���� 3) �������� ����, �ο���, �޿��� ���, �޿��� ���� ��ȸ
SELECT job, count(*), trunc(avg(sal)), sum(sal)
FROM emp
GROUP BY job;

-- (96������ ���� 4) ������ �μ� �������� �׷��� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ��ȸ
SELECT job, deptno, count(*), avg(sal), sum(sal)
FROM emp
GROUP BY job, deptno;

-- emp ���̺��� �� �μ��� ��� �޿��� ���ϴµ� �� �߿��� ��� �޿��� 2000�޷� �̻��� ����� ��� �޿��� �˻�
SELECT deptno, avg(sal) "��� �޿�"
FROM emp
WHERE avg(sal) >= 2000 -- ����
GROUP BY deptno;
-- WHERE �������� �׷� �Լ� ����� �� ����.
-- ���� ���� : FROM -> WHERE -> GROUP BY -> HAVING -> SELECT(Projection) -> ORDER BY
SELECT deptno, avg(sal) "��� �޿�"
FROM emp
GROUP BY deptno
HAVING avg(sal) >= 2000;

-- HAVING
-- GROUP BY -> HAVING ����
-- (98������ ���� 1) �μ� �ο��� 4���� ���� �μ��� �μ���ȣ, �ο���, �޿��� ���� ��ȸ
SELECT deptno, count(*), sum(sal)
FROM emp
GROUP BY deptno
HAVING count(*) > 4;

-- (98������ ���� 2) emp ���̺��� �޿��� �ִ� 2900 �̻��� �μ��� ���ؼ� �μ���ȣ, ��� �޿�, �޿��� ���� ��ȸ
SELECT deptno, avg(sal), sum(sal)
FROM emp
GROUP BY deptno
HAVING max(sal) > 2900;

-- (98������ ���� 3)
SELECT job, avg(sal), sum(sal)
FROM emp
HAVING avg(sal) >= 3000
GROUP BY job;

-- (99������ ���� 5)
SELECT deptno, avg(sal)
FROM emp
WHERE job='CLERK'
GROUP BY deptno
HAVING avg(sal) > 1000;

-- (99������ ���� 7) �μ� �޿� �հ� �� �ִ밪�� ��ȸ
SELECT max(sum(sal))
FROM emp
GROUP BY deptno;

-- �Ի�⵵�� �ο����� ���...�Ի�⵵, �ο����� �˸��ƽ� ����
SELECT SUBSTR(hiredate, 1, 2) �Ի�⵵, count(*) �ο���
FROM emp
GROUP BY SUBSTR(hiredate, 1, 2);

-- (100������ ���� 8) 20�� �μ����� ���� ���� �Ի��� ����� �˻�
--SELECT ename, hiredate
--FROM emp
--WHERE deptno = 20
--HAVING min(hiredate); -- ����
--SELECT deptno, min(to_char(hiredate, 'RR/MM/DD'))
--FROM emp
--GROUP BY deptno
--HAVING min(); -- �ڵ� ã��...

-- ROLLUP
-- �ұ׷� ���� �հ踦 ����ϴ� ���
-- GROUP BY ���� ���� ������ �ұ׷� �հ�� ��ü �հ� ��θ� ���ϴ� ���

-- (102������ ���� 1) �μ��� �ο���, �޿��� ��ȸ�� ROLLUP�� ����� �� ���踦 ��ȸ
SELECT deptno, count(*), sum(sal)
FROM emp
GROUP BY ROLLUP(deptno);

SELECT deptno, job, sum(sal)
FROM emp
GROUP BY deptno, job;

-- ROLLUP �μ� ���� �߿�
-- (102������ ���� 2)
SELECT deptno, job, sum(sal)
FROM emp
GROUP BY ROLLUP(deptno, job); -- deptno ���� -> job ���� null ����
-- (102������ ���� 3)
SELECT deptno, job, sum(sal)
FROM emp
GROUP BY ROLLUP(job, deptno); -- job ���� -> deptno ���� null ����

--============================================

-- <<JOIN>>
SELECT * FROM emp;
SELECT * FROM dept;

-- 1) ī�׽þ� ��� ��� (���� ������ �� ���)
-- 14*4 = 56 �ܼ��� ���ؼ� ��� ���
SELECT * FROM emp, dept; -- 56���� ��� / 14����

-- 2) EQUI JOIN (���� ������ ����)
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno; -- 14����
-- �÷����� ���� ���, ���ʿ��� �÷����� ������� �ʵ���

-- 3) ���� ������ ���� + �÷����� ��ü������ ���
-- ���� : deptno "column ambiguously defined" -> ���� ������ ����
SELECT empno, ename, deptno, dname, loc
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- 4) ���� ������ ���� + �÷����� ��ü������ ��� + �÷��� �տ� ���̺��� ����
SELECT emp.empno, emp.ename, emp.deptno, dept.dname, dept.loc
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- 5) ���� ������ ���� + �÷����� ��ü������ ��� + �÷��� �տ� ���̺��� ���� + ���̺� �˸��ƽ�(Alias)
SELECT e.empno, e.ename, e.deptno, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- ����̸�, �޿�, �μ���ȣ, �μ���ġ�� ���. ��, �޿��� 2000�޷� �̻��̰� 30�� �μ��� ���ؼ��� ���
SELECT e.empno, e.sal, e.deptno, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno -- ���� ����
AND e.sal>=2000 AND e.deptno = 30; -- ������ ����

-- (121������ ���� 1) emp ���̺� ���, �̸�, �޿�, �޿� grade�� ��ȸ
SELECT e.empno, e.ename, e.sal, s.grade, s.losal, s.hisal
FROM emp e, salgrade s
WHERE e.sal >=s.losal AND e.sal <= s.hisal;


-- OUTER JOIN
-- A, B ���̺��� ������ ���, ���ǿ� ���� �ʴ� �����͵� ǥ���ϰ� ���� �� outer join�� ���
-- �⺻���� ���� ����� INNER(�������� �÷� ���� ǥ���ϴ� ���)

-- e.deptno : 10, 20, 30 / d.deptno : 10, 20, 30, 40
-- 1) OUTER JOIN
SELECT e.ename, e.deptno "�μ���ȣ1" , d.deptno "�μ���ȣ2", d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno; -- �����Ͱ� ���� �ʿ� (+)�� ����

-- 2) RIGHT JOIN
SELECT e.ename, e.deptno "�μ���ȣ1" , d.deptno "�μ���ȣ2", d.dname
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno; -- �����Ͱ� �ִ� ���� �������� ��´�

-- (123������ ���� 1) dept ���̺� �ִ� ��� �ڷḦ �����ȣ, �̸�, ����, emp ���̺��� �μ���ȣ, dept ���̺��� �μ���ȣ, �μ����� ���
SELECT e.empno, e.ename, e.job, e.deptno, d.deptno, d.dname
FROM dept d, emp e
WHERE d.deptno = e.deptno(+);

-- (124������ ���� 5) �޿��� 2000���� ���� �޴� ������� �̸�, �޿�, �μ���ȣ, �μ��� ��ȸ ������� ��� �μ����̺� ���� outer ����
SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND e.sal > 2000;

-- (125������ ���� 6)
SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND e.sal(+) > 2000;

-- LEFT OUTER JOIN
SELECT (e.ename||'�� �Ŵ����� '||m.ename||'�Դϴ�') INFO -- ���� ������ ||
FROM emp e, emp m
WHERE e.mgr = m.empno; -- 14��

SELECT (e.ename||'�� �Ŵ����� '||m.ename||'�Դϴ�') INFO -- ���� ������ ||
FROM emp e, emp m
WHERE e.mgr = m.empno(+); -- 15�� / KING���� ���

SELECT (e.ename||'�� �Ŵ����� '||m.ename||'�Դϴ�') INFO -- ���� ������ ||
FROM emp e LEFT OUTER JOIN emp m
ON e.mgr = m.empno(+);

-- FULL OUTER JOIN
-- �� ���̺� ��� �Ѱ����� �̻��� ������ �����͸� ������ �մ� ���
CREATE TABLE outera (sawonid number(3)); -- 30�� ����
CREATE TABLE outerb (sawonid number(3)); -- 40�� ����

INSERT INTO outera VALUES(10);
INSERT INTO outera VALUES(20);
INSERT INTO outera VALUES(40);

INSERT INTO outerb VALUES(10);
INSERT INTO outerb VALUES(20);
INSERT INTO outerb VALUES(30);

SELECT sawonid FROM outera FULL OUTER JOIN outerb USING(sawonid);


-- << SELF JOIN >>
/*
 --------------------e----------------------
 1. Ư�� ����� ��� �̸��� �˻�
 2. ���� Ư�� ����� EMP ���̺��� �˻�...BLAKE
 3. BLAKE�� ���� ����ȣ�� �˻�...7839
 --------------------m----------------------
 4. 7839�� �ش��ϴ� �����ȣ�� �˻�
 5. �ش� �����ȣ�� �̸��� �˻�
*/
SELECT * FROM (SELECT empno, ename, mgr FROM emp) e,
(SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;

SELECT e.empno, e.ename ����̸�, m.ename ����̸�
FROM emp e, emp m
WHERE e.mgr = m.empno
AND e.ename = 'BLAKE';