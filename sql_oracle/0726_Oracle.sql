-- 0726
-- <<< 단일 행 함수 >>>

-- << 문자함수 >>
-- substr(문자열, 시작 위치, 길이) : 지정한 위치에서 지정한 길이만큼의 문자열을 추출
-- emp 테이블에서 업무 중에서 SALESMAN 업무를 SALES만 출력되도록 문자열 추출
SELECT DISTINCT(SUBSTR('SALESMAN', 1, 5)) FROM emp;

-- emp 테이블에서 부서번호가 10번 부서인 사원의 입사일 중 월만 추출해서 출력
-- 사원 이름, 업무, 부서번호, "입사한 월" 디스플레이 하세요.
SELECT ename, job, deptno, SUBSTR(hiredate, 4, 2) "입사한 월"
FROM emp
WHERE deptno = 10;

-- 길이 생략하면 defalut로 문자 끝까지 출력
-- 테이블이 필요없지만 FROM 생략하면 오류 나므로 FROM dual 사용
SELECT SUBSTR('HelloWorld', 6) FROM dual;
SELECT SUBSTR('HelloWorld', 6, 3) FROM dual; -- Wor
SELECT SUBSTR('HelloWorld', -4, 2) FROM dual; -- or
SELECT SUBSTR('HelloWorld', -1, 1) FROM dual; -- d

--  upper() : 모두 대문자로
SELECT empno, ename, deptno
FROM emp
WHERE ename=UPPER('scott');
-- lower() : 모두 소문자로
SELECT empno, ename, deptno
FROM emp
WHERE LOWER(ename)='scott';

-- initcap() : 문자열 단어의 첫 문자는 대문자, 나머지는 소문자로 변경
-- emp 테이블에서 blake라는 사람의 사원번호, 부서번호, 이름을 출력.
-- 이때 첫번째 이름이 대문자가 출력되도록
SELECT empno, INITCAP(ename), deptno
FROM emp
WHERE Lower(ename)='blake';

-- INSTR(대상 문자열, 찾는 문자열, 시작 위치, 몇 번째(생략 가능, default=1))
-- 사원의 이름 마지막 6번째 철자가 'R'인 사원의 이름을 검색
SELECT ename FROM emp WHERE INSTR(ename, 'R')=6; -- 00000R

-- emp 테이블에서 사원의 이름이 'S'로 끝나는 사원의 이름, 업무, 입사일을 출력
-- SUBSTR(), INSTR(), LIKE 세 가지 방법을 이용해서 쿼리문을 작성
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

-- SCOTT -> T는 적용 안 됨 -> 'TT'
SELECT ename FROM emp WHERE INSTR(ename, 'TT')=4;

-- concat(s1, s2) : 두 문자열을 연결
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
-- SELECT TRIM('aaababaaa', 'a') FROM dual; -- 안 됨
SELECT TRIM('a' from 'aaababaaa') FROM dual; -- bab
-- TRIM은 양쪽 공백을 제거할 때 주로 사용된다
SELECT TRIM('   bab   ') FROM dual; -- bab
SELECT TRIM('   ba b   ') FROM dual; -- ba b : 가운데 공백 제거는 불가능하다.

-- 가운데 공백을 제거하려면 어떻게 해야할까? REPLACE 사용한다.
SELECT REPLACE('   ba b   ', ' ', '') FROM dual; -- bab

-- (60페이지 예제 5) REPLACE 함수를 사용하여 사원 이름에 SC문자열을 *?로 변경해서 조회
SELECT ename, REPLACE(ename, 'SC', '*?')
FROM emp;

-- << 숫자 함수 >>
-- round()
-- 소수점 2번째 자리까지 출력 / 반올림은 3번째 자리에서 이루어짐
SELECT ROUND(45.926, 2) FROM dual; -- 45.93
SELECT ROUND(45.926) FROM dual; -- 아래와 동일한 결과, default는 0이다.
SELECT ROUND(45.926, 0) FROM dual; -- 46
SELECT ROUND(45.926, -1) FROM dual; -- 50
SELECT ROUND(45.926, -2) FROM dual; -- 0

-- trunc()
-- 해당 소수점 자리에서 버림
SELECT TRUNC(45.926, 2) FROM dual; -- 45.92
SELECT TRUNC(45.926) FROM dual; -- 45, defualt는 0이다.
SELECT TRUNC(45.926, -1) FROM dual; -- 40
SELECT TRUNC(45.926, -2) FROM dual; -- 0

-- (64페이지 예제 4) emp 테이블에서 급여를 30으로 나눈 나머지를 구하여 출력
SELECT sal, MOD(sal, 30)
FROM emp;

-- << 날짜 함수 >>
/*
날짜 + 숫자 = 날짜
날짜 - 숫자 = 날짜
날짜 - 날짜 = 기간 (숫자)
날짜 + 날짜 = 기간 (숫자)
*/
-- sysdate : 데이터베이스 서버의 현재 날짜 및 시간을 반환하는 날짜 함수
SELECT sysdate FROM dual; -- 22/07/26
-- 오늘로부터 100일 뒤
SELECT sysdate+100 FROM dual; -- 22/11/03
-- 어제 날짜
SELECT sysdate-1 FROM dual; -- 22/07/25
-- to_date : 문자를 날짜로 변환
SELECT sysdate - to_date('2022-07-18', 'YYYY-MM-DD') FROM dual; -- 8.45506944444444444444444444444444444444 시간까지
SELECT trunc(abs(to_date('2022-07-18', 'YYYY-MM-DD')-sysdate)) FROM dual; -- 8 / 함수 중첩
-- 여러분이 지금까지 살아온 일생을 구하세요
SELECT trunc(abs(to_date('1998-08-30', 'YYYY-MM-DD')-sysdate)) FROM dual; -- 8731

-- (66페이지 예제 2) emp 테이블에서 현재까지의 근무일수가 몇 주 몇 일인가를 조회
SELECT hiredate FROM emp; -- hiredate는 1900년대, sysdate는 2000년대라 음수가 출력됨
SELECT trunc((sysdate-hiredate)/7, 0) "근무 주 수", round(mod(sysdate-hiredate, 7), 0) "근무 일 수"
FROM emp;

-- months_between(D1, D2) : D1, D2 두 날짜 간의 경과 개월 수
-- (69페이지 예제 1) emp 테이블에서 10번 부서원의 현재까지의 근무 월수를 계산하여 조회
SELECT ename, TRUNC(MONTHS_BETWEEN(sysdate, TO_DATE(hiredate,'RR/MM/DD'))) "근무개월"
FROM emp WHERE deptno = 10 ORDER BY hiredate ASC;

-- add_months(D1, N) : D1 날짜에 N개월 더함
-- (70페이지 예제 2) emp 테이블에서 10번 부서원의 입사 일자로부터 5개월이 지난 후 날짜를 계산하여 출력
SELECT ename, hiredate, sysdate, add_months(hiredate, 5) "입사 후 5개월 날짜"
FROM emp
WHERE deptno=10;

-- << 변환 함수 >>
-- 1. 암시적 변환 : 변환 함수 없이도 어느 정도는 자동으로 변환됨
-- 2. 명시적 변환 : 자동으로 변환되지 않을 때는 명시적인 변환 함수 사용
-- to_char(날짜, format), to_number, to_date

-- (74페이지 예제 2) 오늘 날짜가 1년 중 몇번째 주인지 조회한다.
-- (단, 1월 1일부터 첫째 일요일까지를 1주차로 한다.) (TO_CHAR)
SELECT TO_CHAR(sysdate, 'WW"주"') "N주차" FROM dual;

-- (75페이지 예제 3) emp 테이블에서 20번 부서 중 입사 일자를 '1998년 1월 1일'의 형태로 출력
SELECT ename, hiredate, to_char(to_date(hiredate, 'RR/MM/DD'), 'YYYY"년" MM"월" DD"일"') "입사 일자"
FROM emp
WHERE deptno = 20;

-- (75페이지 예제 5) '201407'이라는 년월을 표시하는 문자값에서 15개월 후의 년월을 문자로 표시
SELECT TO_CHAR(ADD_MONTHS(TO_DATE('201407', 'YYYYMM'), 15), 'YYYYMM') "15개월 후"
FROM dual; -- 201510

-- (76페이지 예제 7) 각 사원들의 이름, 입사일, 입사일로부터 여섯 달 경과 후 첫번째 일요일의 날짜를 년도 4자리/월 2자리/일자 형태로 나오도록 조회
SELECT ename, hiredate, TO_CHAR(NEXT_DAY(ADD_MONTHS(TO_DATE(hiredate, 'RR/MM/DD'), 6), '일요일'), 'YYYY/MM/DD') "6개월 후 첫 일요일"
FROM emp;

