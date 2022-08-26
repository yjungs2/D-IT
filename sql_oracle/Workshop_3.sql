--#################### ������ �Լ� �ǽ� ###################
-- 1) �̸��� 'adams' �� ������ �޿��� �Ի����� ��ȸ�Ͻÿ�.
SELECT ename, sal, hiredate
FROM emp
WHERE lower(ename)='adams';

-- 2) 'Adams�� �Ի����� 95/11/02 �̰�, �޿��� 3000 �Դϴ�.' �̷� ������ ���� ������ ��ȸ�Ͻÿ�.
SELECT (ename||'�� �Ի����� '||hiredate||' �̰�, �޿��� '||sal||' �Դϴ�.') "���� ����"
FROM emp;

-- 3) �̸��� 5���� ������ �������� �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
SELECT ename, sal, hiredate
FROM emp
WHERE length(ename) <= 5;

-- 4) 1987 �⵵�� �Ի��� ������ �̸�, �Ի����� ��ȸ�Ͻÿ�.
SELECT ename, hiredate
FROM emp
WHERE SUBSTR(hiredate, 1, 2)=87;

-- 5) 7�� �̻� ��� �ټ��� �������� �̸�, �Ի���, �޿�, �ٹ������� ��ȸ�Ͻÿ�.
SELECT ename, hiredate, sal, TRUNC((sysdate - to_date(hiredate, 'RR/MM/DD'))/365) "�ٹ�����"
FROM emp
WHERE TRUNC((sysdate - to_date(hiredate, 'RR/MM/DD'))/365) >= 7;


-- ##################  �׷� �Լ� �ǽ� ######################
-- 1)  30�� �μ� ������ ���(�Ҽ�2�ڸ����� ����, �Ҽ��� ���ڸ��� ǥ��), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT TRUNC(avg(sal), 1) "������ ���", max(sal) "�ְ� ����", min(sal) "���� ����", count(*) "�ο���"
FROM emp
WHERE deptno=30;

-- 2) �� �μ��� �޿��� ���(�ݿø�, �����κи� ǥ��ǵ���), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT deptno "�μ���ȣ", ROUND(avg(sal)) "�޿��� ���", max(sal) "�ְ� �޿�", min(sal) "���� �޿�", count(*) "�ο���"
FROM emp
GROUP BY deptno;

-- 3) �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ,������, �ο����� ����϶�.
SELECT deptno, job, count(*)
FROM emp
GROUP BY deptno, job
ORDER BY deptno;

-- 4) ���� ������ �ϴ� ����� ���� 2�� �̻��� ������ �ο�����  ����϶�.
SELECT job, count(*)
FROM emp
GROUP BY job
HAVING count(*) >= 2;

-- 5) �� �μ��� ��� ����(�Ҽ����� ����), ��ü ����, �ְ� ����, ���� ������ ���Ͽ� ��� ������ ���� ������ ����϶�. 
SELECT deptno, TRUNC(avg(sal)) "��� ����", sum(sal) "��ü ����", max(sal) "�ְ� ����", min(sal) "���� ����"
FROM emp
GROUP BY deptno
ORDER BY TRUNC(avg(sal)) desc;

-- 6) �� �μ��� ���� ������ �ϴ� ����� �޿��� �հ踦 ���Ͽ� �μ���ȣ,������, �޿��հ踦 ����϶�.
-- ��, �μ��� �޿��հ赵 ���� ����϶�.
SELECT deptno, job, sum(sal)
FROM emp
GROUP BY ROLLUP(deptno, job);

-- 7) �� �μ��� �ο����� ��ȸ�ϵ� �ο����� 5�� �̻��� �μ��� ��µǵ��� �Ͻÿ�.
SELECT deptno , count(*) 
FROM  emp 
GROUP BY deptno
HAVING count(*) >= 5;

-- 8)  �� �μ��� �ִ�޿��� �ּұ޿��� ��ȸ�Ͻÿ�.
-- ��, �ִ�޿��� �ּұ޿��� ���� �μ��� ������ �Ѹ��� ���ɼ��� ���� ������ ��ȸ������� ���ܽ�Ų��.
SELECT deptno, max(sal), min(sal)
FROM emp
GROUP BY deptno
HAVING max(sal)!=min(sal);

--10) �μ��� 10, 20, 30 ���� ������ �߿��� �޿��� 2500 �̻� 5000 ���ϸ� �޴� �������� ������� �μ��� ��� �޿��� ��ȸ�Ͻÿ�.
-- ��, ��ձ޿��� 2000 �̻��� �μ��� ��µǾ�� �ϸ�, ��°���� ��ձ޿��� ���� �μ� ���� ��µǵ��� �ؾ� �Ѵ�.
SELECT deptno, avg(sal)
FROM (SELECT * FROM emp WHERE sal BETWEEN 2500 AND 5000)
GROUP BY deptno
HAVING avg(sal)>=2000
ORDER BY avg(sal) DESC;