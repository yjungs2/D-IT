SELECT * FROM emp;
-- 비교연산자 page 34
/*
emp 테이블에서 sal가 2500~3500 사이에 들어있는 사원의 이름과 sal을 검색
*/
SELECT ename, sal FROM emp WHERE sal>=2500 and sal<=3500;
SELECT ename, sal FROM emp WHERE sal BETWEEN 2500 AND 3500; -- between lower and higher

-- IN 연산자
-- emp 테이블에서 사원번호가 7369이거나 7521이거나 7782인 사원을 검색
-- 1step
SELECT * FROM emp WHERE empno=7369;
SELECT * FROM emp WHERE empno=7521;
SELECT * FROM emp WHERE empno=7782;
-- 2step
SELECT * FROM emp WHERE empno=7369 or empno=7521 or empno=7782;
-- 3step
SELECT * FROM emp WHERE empno IN(7369, 7521, 7782);

-- emp 테이블에서 사원번호가 7369가 아니고 7521도 아니고 7782도 아닌 사원을 검색
-- 2step
SELECT * FROM emp WHERE empno!=7369 and empno<>7521 and empno^=7782;
-- 3step
SELECT * FROM emp WHERE empno NOT IN(7369, 7521, 7782);

-- 와일드 카드(%, _)와 like 연산자
-- emp테이블에서 S로 이름이 시작되는 사원을 검색...그 사람의 job도 검색
SELECT ename, job FROM emp WHERE ename LIKE 'S%';
-- emp테이블에서 사원의 이름에 S가 포함되어진 사원의 이름과 job을 검색
SELECT ename, job FROM emp WHERE ename LIKE '%S%';
-- emp테이블에서 사원의 이름 중에서 2번째 이름이 M인 사원을 검색
SELECT ename, job FROM emp WHERE ename LIKE '_M%';
-- emp테이블에서 사원의 입사년도가 80년도인 사원을 검색
SELECT ename FROM emp WHERE hiredate LIKE '80%';
