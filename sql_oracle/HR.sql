SELECT * FROM emp;
-- �񱳿����� page 34
/*
emp ���̺��� sal�� 2500~3500 ���̿� ����ִ� ����� �̸��� sal�� �˻�
*/
SELECT ename, sal FROM emp WHERE sal>=2500 and sal<=3500;
SELECT ename, sal FROM emp WHERE sal BETWEEN 2500 AND 3500; -- between lower and higher

-- IN ������
-- emp ���̺��� �����ȣ�� 7369�̰ų� 7521�̰ų� 7782�� ����� �˻�
-- 1step
SELECT * FROM emp WHERE empno=7369;
SELECT * FROM emp WHERE empno=7521;
SELECT * FROM emp WHERE empno=7782;
-- 2step
SELECT * FROM emp WHERE empno=7369 or empno=7521 or empno=7782;
-- 3step
SELECT * FROM emp WHERE empno IN(7369, 7521, 7782);

-- emp ���̺��� �����ȣ�� 7369�� �ƴϰ� 7521�� �ƴϰ� 7782�� �ƴ� ����� �˻�
-- 2step
SELECT * FROM emp WHERE empno!=7369 and empno<>7521 and empno^=7782;
-- 3step
SELECT * FROM emp WHERE empno NOT IN(7369, 7521, 7782);

-- ���ϵ� ī��(%, _)�� like ������
-- emp���̺��� S�� �̸��� ���۵Ǵ� ����� �˻�...�� ����� job�� �˻�
SELECT ename, job FROM emp WHERE ename LIKE 'S%';
-- emp���̺��� ����� �̸��� S�� ���ԵǾ��� ����� �̸��� job�� �˻�
SELECT ename, job FROM emp WHERE ename LIKE '%S%';
-- emp���̺��� ����� �̸� �߿��� 2��° �̸��� M�� ����� �˻�
SELECT ename, job FROM emp WHERE ename LIKE '_M%';
-- emp���̺��� ����� �Ի�⵵�� 80�⵵�� ����� �˻�
SELECT ename FROM emp WHERE hiredate LIKE '80%';
