-- 0728
-- <<서브쿼리>>
-- CLARK 사원보다 더 많은 급여를 받는 사원을 검색
-- 1)
SELECT sal FROM emp WHERE ename='CLARK'; -- 2450
SELECT ename, sal FROM emp WHERE sal>2450;
-- 2)
-- 서브쿼리는 반드시 ()로 써아져야 한다. () 먼저 해결
SELECT ename, sal FROM emp WHERE sal>(SELECT sal FROM emp WHERE ename='CLARK');
-- 2450 리턴(스칼라값) : one row, one column 값(단일 행)

-- (157페이지 예제 1) 7566번 사원보다 급여를 많이 받는 사원의 이름, 급여를 조회
SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE empno=7566);

--(157페이지 예제 2) emp...사원번호가 7521인 사원과 업무가 같고 급여가 7934인 사원보다 많은 사원의
-- 사원번호, 이름, 담당업무, 입사일자, 급여를 조회
SELECT empno, ename, job, hiredate, sal
FROM emp
WHERE job=(SELECT job FROM emp WHERE empno=7521)
AND sal>(SELECT sal FROM emp WHERE empno=7934);

-- (157페이지 에제 3) emp...급여를 제일 많이 받는 사원의 이름, 부서번호, 급여, 입사일을 조회
SELECT ename, deptno, sal, hiredate
FROM emp
WHERE sal = (SELECT max(sal) FROM emp);

-- (158페이지 예제 4) emp 테이블에서 급여의 평균보다 적은 사원의 사원번호, 이름, 담당업무, 급여, 부서번호를 출력
SELECT empno, ename, job, sal, deptno
FROM emp
WHERE sal < (SELECT avg(sal) FROM emp);

-- (158페이지 예제 5) emp 테이블에서 사원의 급여가 20번 부서의 최소 급여보다 많은 부서를 조회
SELECT deptno, min(sal)
FROM emp
GROUP BY deptno
HAVING min(sal) > (SELECT min(sal) FROM emp WHERE deptno=20);

-- emp 테이블에서 급여를 가장 적게 받는 사원 3명을 검색
SELECT ename, job, sal FROM (SELECT * FROM emp ORDER BY sal) WHERE rownum<=3;

-- 다중 행 서브 쿼리
/*
sal < ANY : 최대값보다 작은 sal
sal > ANY : 최소값보다 큰 sal
sal = ANY : IN과 동일

sal < ALL : 최소값보다 작은 sal
sal > ALL : 최대값보다 큰 sal
*/

-- (160페이지 예제 2) 업무가 SALESMAN인 최소 한 명 이상의 사원보다 급여를 많이 받는 사원의 이름, 급여, 업무를 조회 
SELECT ename, sal, job
FROM emp
WHERE job!='SALESMAN'
AND sal > ANY(SELECT sal FROM emp WHERE job='SALESMAN');

-- (160페이지 예제 3) 업무가 SALESMAN인 모든 사원보다 급여를 많이 받는 사원의 이름, 급여, 업무, 입사일, 부서번호를 조회
SELECT ename, sal, job, hiredate, deptno
FROM emp
WHERE job!='SALESMAN'
AND sal > ALL(SELECT sal FROM emp WHERE job='SALESMAN');


-- 다중 열 서브 쿼리
-- FORD, BLAKE와 관리자 및 부서가 같은 사원의 정보 조회
-- (162페이지 예제 1) NON-PAIRWISE
SELECT ename, mgr, deptno
FROM emp
WHERE mgr IN (SELECT mgr FROM emp WHERE ename IN ('FORD', 'BLAKE'))
AND deptno IN (SELECT deptno FROM emp WHERE ename IN ('FORD', 'BLAKE'))
AND ename NOT IN ('FORD', 'BLAKE');
-- (163페이지 예제 2) PAIRWISE
SELECT ename, mgr, deptno
FROM emp
WHERE (mgr, deptno) IN (SELECT mgr, deptno FROM emp WHERE ename IN ('FORD', 'BLAKE'))
AND ename NOT IN ('FORD', 'BLAKE');