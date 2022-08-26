-- ### equi join ###
-- 1.  emp�� dept Table�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿���  ����϶�.
SELECT e.deptno, d.dname, e.ename, e.sal
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- 2.  �̸��� ��SMITH���� ����� �μ����� ����϶�.
SELECT e.ename, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e.ename = 'SMITH';

--  ### Non Equi join ###
--3. �����ȣ, �̸� ,����, �޿�, �޿��� ���, ���� ��, ���� ���� ����϶�.
SELECT e.empno, e.ename, e.job, e.sal, s.grade, s.losal, s.hisal
FROM emp e, salgrade s
WHERE e.sal >= s.losal AND e.sal <= s.hisal;

-- ### outer join ###
-- 4.  dept Table�� �ִ� ��� �μ��� ����ϰ�, emp Table�� �ִ� DATA�� JOIN�Ͽ�
-- ��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ��� �϶�.
SELECT e.ename, d.deptno, d.dname, e.sal
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;

-- ###self join###
-- 5.  emp Table�� �ִ� empno�� mgr�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�.
-- ��SMTH�� �Ŵ����� FORD�̴١�
SELECT (e.ename||'�� �Ŵ����� '||m.ename||'�̴�')
FROM emp e, emp m
WHERE e.mgr = m.empno(+);

-- ### join �ǽ� ###
-- 1. �����ڰ� 7698�� ����� �̸�, �����ȣ, �����ڹ�ȣ, �����ڸ��� ����϶�.
SELECT e.ename, e.empno, e.mgr, m.ename
FROM emp e, emp m
WHERE e.mgr = m.empno
AND e.empno=7698;

-- 2. ������ MANAGER�̰ų� CLERK�� ����� �����ȣ, �̸�, �޿�, ����, �μ���
SELECT e.empno, e.ename, e.sal, e.job, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND job in ('MANAGER', 'CLERK');

-- ### SubQuery ###
-- 1.  ��SMITH'�� ������ ���� ����� �̸�, �μ���, �޿�, ������  ����϶�.
SELECT e.ename, d.dname, e.sal, e.job
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND job = (SELECT job FROM emp WHERE ename='SMITH');

-- 2.  ��JONES���� �����ִ� �μ��� ��� ����� �����ȣ, �̸�, �Ի���, �޿��� ����϶�.
SELECT deptno, empno, ename, hiredate, sal
FROM emp
WHERE deptno = (SELECT deptno FROM emp WHERE ename='JONES');

-- 3.  ��ü ����� ��ձ޿����� �޿��� ���� ����� �����ȣ, �̸�, �μ���, �Ի���, ����, �޿��� ����϶�.
SELECT e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND sal > (SELECT avg(sal) FROM emp);

-- 4. 10�� �μ��� ���� ���� �ϴ� ����� �����ȣ, �̸�, �μ���, ����, �޿��� �޿��� ���� ������ ����϶�.
SELECT e.empno, e.ename, d.dname, d.loc, e.sal
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND job IN (SELECT job FROM emp WHERE deptno = 10)
ORDER BY e.sal desc;

-- 5. 10�� �μ� �߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, �̸�, �μ���, �Ի���, ������ ����϶�.
SELECT e.deptno, e.empno, e.ename, d.dname, e.hiredate, d.loc
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND job NOT IN (SELECT job FROM emp WHERE deptno = 30)
AND e.deptno=10;

--6. ��KING���̳� ��JAMES'�� �޿��� ���� ����� �����ȣ, �̸�, �޿��� ����϶�.
SELECT empno, ename, sal
FROM emp
WHERE sal IN (SELECT sal FROM emp WHERE ename IN ('KING', 'JAMES'));

-- 7. �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ,�̸�, �޿��� ����϶�.
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT max(sal) FROM emp WHERE deptno=30);
