-- COUNT() : 모든 행 리턴
SELECT COUNT(*) FROM emp; -- 15
SELECT COUNT(-1) FROM emp;  -- 15

-- 그룹함수는 NULL 값을 건너뛴다.
SELECT COUNT(MGR) FROM emp; -- 14 
SELECT COUNT(COMM) FROM emp; -- 5

-- emp 테이블에서 부서 종류의 개수를 검색...COUNT()
SELECT COUNT(deptno) FROM emp; -- 15
SELECT COUNT(ALL(deptno)) FROM emp; -- 15
SELECT COUNT(DISTINCT(deptno)) FROM emp; -- 3
-- DISTINCT를 지정하면 함수는 중복되지 않는 값만 검토하고,
-- ALL을 지정하면 중복 값을 포함한 값을 검토한다.
-- 기본값은 ALL이므로 지정할 필요가 없다.

-- (92페이지 예제 1)
SELECT MIN(ename), MAX(ename), MIN(hiredate), MAX(hiredate)
FROM emp; -- ADAMS, WARD, 1980-12-17, 1983-01-12

-- (92페이지 예제 2)
SELECT AVG(sal), MAX(sal), MIN(sal), SUM(sal)
FROM emp
WHERE job='SALESMAN'; -- 1400, 1600, 1250, 5600

-- SELECT COUNT(ALL(deptno)) FROM emp;
-- emp 테이블에서 총인원, 보너스 받는 인원수를 검색
SELECT COUNT(*) 총인원, COUNT(comm) "보너스 받는 인원", AVG(comm) "보너스 평균1", ROUND(AVG(NVL(comm, 0))) "보너스 평균2"
FROM emp; -- 15, 5, 640, 213

SELECT comm FROM emp;

-- GROUP BY절 :: 그룹을 세분화 시키는 기능
-- SELECT 절(projection)에서 그룹 함수에 적용되지 않은 컬럼(deptno)은 반드시 GROUP BY절 뒤에 명시되어야 한다.
-- SELECT deptno, AVG(sal) FROM emp;
-- 1) 원래는 그룹 하나
SELECT ROUND(AVG(sal)) FROM emp;
-- 2) 지금은 세 그룹
SELECT deptno, AVG(sal)
FROM emp
GROUP BY deptno;
-- 3) 정렬
-- ORDER BY 1 : deptno 오름차순
-- ORDER BY 2 : deptno 내림차순
SELECT deptno, AVG(sal)
FROM emp
GROUP BY deptno
ORDER BY 1;
-- 4) Alias :: GROUP BY절 뒤에 Alias 사용 못 함
--SELECT deptno DName, ROUND(AVG(sal)) AvgSalary
--FROM emp
-- GROUP BY DName -- 오류 : 
--ORDER BY DName;
-- 4') Alias :: ORDER BY절 뒤에는 Alias 사용 가능
SELECT deptno DName, ROUND(AVG(sal)) AvgSalary
FROM emp
GROUP BY deptno
ORDER BY AvgSalary;

-- (95페이지 예제 2) 각 부서별로 인원수, 급여의 평균, 최저 급여, 최고 급여, 급여의 합을 구하여 급여의 합이 많은 순으로 출력
SELECT deptno, count(*), avg(sal), min(sal), max(sal), sum(sal)
FROM emp
GROUP BY deptno
ORDER BY sum(sal) desc;

-- (96페이지 예제 3) 업무별로 업무, 인원수, 급여의 평균, 급여의 합을 조회
SELECT job, count(*), trunc(avg(sal)), sum(sal)
FROM emp
GROUP BY job;

-- (96페이지 예제 4) 업무와 부서 기준으로 그룹항 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 조회
SELECT job, deptno, count(*), avg(sal), sum(sal)
FROM emp
GROUP BY job, deptno;

-- emp 테이블에서 각 부서별 평균 급여를 구하는데 그 중에서 평균 급여가 2000달러 이상인 사원의 평균 급여를 검색
SELECT deptno, avg(sal) "평균 급여"
FROM emp
WHERE avg(sal) >= 2000 -- 오류
GROUP BY deptno;
-- WHERE 절에서는 그룹 함수 사용할 수 없다.
-- 실행 순서 : FROM -> WHERE -> GROUP BY -> HAVING -> SELECT(Projection) -> ORDER BY
SELECT deptno, avg(sal) "평균 급여"
FROM emp
GROUP BY deptno
HAVING avg(sal) >= 2000;

-- HAVING
-- GROUP BY -> HAVING 권장
-- (98페이지 예제 1) 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 조회
SELECT deptno, count(*), sum(sal)
FROM emp
GROUP BY deptno
HAVING count(*) > 4;

-- (98페이지 예제 2) emp 테이블에서 급여가 최대 2900 이상인 부서에 대해서 부서번호, 평균 급여, 급여의 합을 조회
SELECT deptno, avg(sal), sum(sal)
FROM emp
GROUP BY deptno
HAVING max(sal) > 2900;

-- (98페이지 예제 3)
SELECT job, avg(sal), sum(sal)
FROM emp
HAVING avg(sal) >= 3000
GROUP BY job;

-- (99페이지 예제 5)
SELECT deptno, avg(sal)
FROM emp
WHERE job='CLERK'
GROUP BY deptno
HAVING avg(sal) > 1000;

-- (99페이지 예제 7) 부서 급여 합계 중 최대값을 조회
SELECT max(sum(sal))
FROM emp
GROUP BY deptno;

-- 입사년도별 인원수를 출력...입사년도, 인원수를 알리아스 지정
SELECT SUBSTR(hiredate, 1, 2) 입사년도, count(*) 인원수
FROM emp
GROUP BY SUBSTR(hiredate, 1, 2);

-- (100페이지 예제 8) 20번 부서에서 가장 먼저 입사한 사원을 검색
--SELECT ename, hiredate
--FROM emp
--WHERE deptno = 20
--HAVING min(hiredate); -- 오류
--SELECT deptno, min(to_char(hiredate, 'RR/MM/DD'))
--FROM emp
--GROUP BY deptno
--HAVING min(); -- 코드 찾기...

-- ROLLUP
-- 소그룹 간의 합계를 계산하는 기능
-- GROUP BY 절로 묶인 각자의 소그룹 합계와 전체 합계 모두를 구하는 기능

-- (102페이지 예제 1) 부서별 인원수, 급여합 조회시 ROLLUP을 사용해 총 집계를 조회
SELECT deptno, count(*), sum(sal)
FROM emp
GROUP BY ROLLUP(deptno);

SELECT deptno, job, sum(sal)
FROM emp
GROUP BY deptno, job;

-- ROLLUP 인수 순서 중요
-- (102페이지 예제 2)
SELECT deptno, job, sum(sal)
FROM emp
GROUP BY ROLLUP(deptno, job); -- deptno 기준 -> job 열에 null 생김
-- (102페이지 예제 3)
SELECT deptno, job, sum(sal)
FROM emp
GROUP BY ROLLUP(job, deptno); -- job 기준 -> deptno 열에 null 생김

--============================================

-- <<JOIN>>
SELECT * FROM emp;
SELECT * FROM dept;

-- 1) 카테시안 결과 출력 (조인 조건을 안 줬다)
-- 14*4 = 56 단순히 곱해서 결과 출력
SELECT * FROM emp, dept; -- 56라인 출력 / 14라인

-- 2) EQUI JOIN (조인 조건을 지정)
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno; -- 14라인
-- 컬럼명을 직접 명시, 불필요한 컬럼명이 노출되지 않도록

-- 3) 조인 조건을 지정 + 컬럼명을 구체적으로 명시
-- 에러 : deptno "column ambiguously defined" -> 성능 저하의 원인
SELECT empno, ename, deptno, dname, loc
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- 4) 조인 조건을 지정 + 컬럼명을 구체적으로 명시 + 컬럼명 앞에 테이블을 지정
SELECT emp.empno, emp.ename, emp.deptno, dept.dname, dept.loc
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- 5) 조인 조건을 지정 + 컬럼명을 구체적으로 명시 + 컬럼명 앞에 테이블을 지정 + 테이블 알리아스(Alias)
SELECT e.empno, e.ename, e.deptno, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- 사원이름, 급여, 부서번호, 부서위치를 출력. 단, 급여가 2000달러 이상이고 30번 부서에 한해서만 출력
SELECT e.empno, e.sal, e.deptno, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno -- 조인 조건
AND e.sal>=2000 AND e.deptno = 30; -- 비조인 조건

-- (121페이지 예제 1) emp 테이블 사번, 이름, 급여, 급여 grade를 조회
SELECT e.empno, e.ename, e.sal, s.grade, s.losal, s.hisal
FROM emp e, salgrade s
WHERE e.sal >=s.losal AND e.sal <= s.hisal;


-- OUTER JOIN
-- A, B 테이블을 조인할 경우, 조건에 맞지 않는 데이터도 표시하고 싶을 때 outer join을 사용
-- 기본적인 조인 방식은 INNER(공통적인 컬럼 값만 표시하는 방법)

-- e.deptno : 10, 20, 30 / d.deptno : 10, 20, 30, 40
-- 1) OUTER JOIN
SELECT e.ename, e.deptno "부서번호1" , d.deptno "부서번호2", d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno; -- 데이터가 없는 쪽에 (+)를 붙임

-- 2) RIGHT JOIN
SELECT e.ename, e.deptno "부서번호1" , d.deptno "부서번호2", d.dname
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno; -- 데이터가 있는 쪽을 기준으로 삼는다

-- (123페이지 예제 1) dept 테이블에 있는 모든 자료를 사원번호, 이름, 업무, emp 테이블의 부서번호, dept 테이블의 부서번호, 부서명을 출력
SELECT e.empno, e.ename, e.job, e.deptno, d.deptno, d.dname
FROM dept d, emp e
WHERE d.deptno = e.deptno(+);

-- (124페이지 예제 5) 급여를 2000보다 많이 받는 사원들의 이름, 급여, 부서번호, 부서명 조회 결과에느 모든 부서테이블 기준 outer 조인
SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND e.sal > 2000;

-- (125페이지 예제 6)
SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND e.sal(+) > 2000;

-- LEFT OUTER JOIN
SELECT (e.ename||'의 매니저는 '||m.ename||'입니다') INFO -- 연결 연산자 ||
FROM emp e, emp m
WHERE e.mgr = m.empno; -- 14행

SELECT (e.ename||'의 매니저는 '||m.ename||'입니다') INFO -- 연결 연산자 ||
FROM emp e, emp m
WHERE e.mgr = m.empno(+); -- 15행 / KING까지 출력

SELECT (e.ename||'의 매니저는 '||m.ename||'입니다') INFO -- 연결 연산자 ||
FROM emp e LEFT OUTER JOIN emp m
ON e.mgr = m.empno(+);

-- FULL OUTER JOIN
-- 두 테이블 모두 한가지씩 이상의 부족한 데이터를 가지고 잇는 경우
CREATE TABLE outera (sawonid number(3)); -- 30이 없음
CREATE TABLE outerb (sawonid number(3)); -- 40이 없음

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
 1. 특정 사원의 상사 이름을 검색
 2. 먼저 특정 사원을 EMP 테이블에서 검색...BLAKE
 3. BLAKE에 대한 상사번호를 검색...7839
 --------------------m----------------------
 4. 7839에 해당하는 사원번호를 검색
 5. 해당 사원번호의 이름을 검색
*/
SELECT * FROM (SELECT empno, ename, mgr FROM emp) e,
(SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;

SELECT e.empno, e.ename 사원이름, m.ename 상사이름
FROM emp e, emp m
WHERE e.mgr = m.empno
AND e.ename = 'BLAKE';