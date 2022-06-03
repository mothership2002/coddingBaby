/* SELECT (DML 또는 DQL) : 조회

- 데이터를 조회하면 조건에 맞는 행이 출력 
 이때, 조회된 행들의 집합을 "RESULT SET"이라고 칭함.
 
 - RESULT SET : 0개 이상의 행이 포함 가능
  왜 0개? 조건이 맞는 행이 없을 수도 있기 때문;

*/

-- EMPLOYEE 테이블에서 모든 사원의 정보를 조회
-- '*' : 
SELECT * FROM EMPLOYEE;
 
 -- SELECT 컬럼명(열) FROM 테이블명;
            
 SELECT emp_name FROM employee;
 
 -- SELECT 컬럼명, 컬럼명, ... FROM 테이블명;
 -- EMPLOYEE 테이블에서 모든 사원의 사번, 이름, 전화번호 조회
 
 SELECT emp_id,emp_name,phone from employee;
 
 -- EMPLOYEE 테이블에서 모든 사원의 사번,이름,이메일,입사일 조회
 
 SELECT EMP_ID,EMP_NAME,EMAIL,HIRE_DATE FROM EMPLOYEE;
 
 -- DEPARTMENT 테이블에 있는 모든 행 조회
 
 SELECT * FROM DEPARTMENT;
 
 
 ----------------------------------------------------------------------------
 -- <컬럼(열) 값 산술 연산>
 -- 컬럼값 : 테이블의 한 칸 (== 한 셀)에 작성된 값(DATA)
 
 -- SELECT문 작성 시 컬럼명에 산술 연산을 작성하면
 -- 조회되는 결과 컬럼 값에 산술 연산이 반영됨
 
 -- EMPLOYEE 테이블에서 모든 사원의 사번,이름,급여,급여+100만 을 조회
 
 SELECT EMP_ID,EMP_NAME,SALARY,SALARY+1000000 FROM employee;
 
 -- EMPLOYEE TABLE에서 모든 사원의 이름, 급여, 연봉을 조회
 
 SELECT EMP_NAME,SALARY,SALARY*12 FROM employee;
 
 -------------------------------------------------------------------------------
 
 -- (중요) <오늘 날짜 조회>
 SELECT SYSDATE FROM DUAL;
 
 /* SYSDATE : 시스템상의 현재 날짜
 -- (년,월,일,시,분,초 까지 단위 저장이 가능하지만, 
    디벨로퍼의 날짜 표기 방법이 년 월 일 로 지정 되어있음.
    도구 - 환경설정 - NLS - YYYY-MM-DD HH24:MI:SS */
    
 -- DUAL (DUMMY TABLE) : 임시 또는 단순 조회 테이블
 
 -- DB는 날짜 DATA의 연산이 가능 (+,-) (일 단위)
 SELECT SYSDATE, SYSDATE+1, SYSDATE -1 FROM DUAL;
 
 -- EMPLOYEE TABLE 에서 이름, 입사일, 오늘까지 근무한 날짜
 SELECT EMP_NAME, HIRE_DATE, (SYSDATE - HIRE_DATE)/365 FROM EMPLOYEE;
 
 ------------------------------------------------------------------------------
 
 -- 컬럼 별칭 지정
 
 -- SELECT 조회 결과의 집합인 RESULT SET에 컬럼명 지정
/*
 ) 컬럼명 AS 별칭 : 띄어쓰기x 특수문자x  문자만 사용 가능
 ) 컬럼명 별칭 : 1)번에서 AS 생략
 ) 컬럼명 AS "별칭" : 띄어쓰기 특수문자 사용 가능
 ) 컬럼명 "별칭" : 3)번에서 AS 생략
*/

-- EMPLOYEE TABLE -> 사번, 이름 , 급여(원), 근무 일수 

SELECT EMP_ID AS 사번,
       EMP_NAME 직원명,
       SALARY AS "급여(원)",
       SYSDATE-HIRE_DATE "근무 일수" 
       FROM EMPLOYEE;
       
-------------------------------------------------------------------------------

-- 리터럴 : 값 자체

-- DB에서의 리터럴 : 임의로 지정한 값을 기존 테이블에 존재하는 값 처럼 사용
--> 리터럴 표기법 ''(홑따옴표)

SELECT EMP_NAME,SALARY,'원' AS 단위 FROM employee;

--------------------------------------------------------------------------------

-- DISTINCT : 조회 시 컬럼에 포함된 중복 값을 한 번만 표시할 때 사용   
SELECT EMP_NAME,DEPT_CODE FROM employee;

/* *주의
-- DISTINCT는 SELECT문에 단 한번만 작성 가능
-- DISTINCT는 SELECT문 가장 앞에 작성
*/

--EMPLOYEE TABLE 안에 저장된 직원들이 속한 부서 코드 종류 조회
SELECT DISTINCT DEPT_CODE FROM employee;

-------------------------------------------------------------------------------

-- where 절
-- table 에서 조건을 충족하는 값을 가진 행만 조회하고자 할 때 사용

-- 비교연산자 : > < = <> !

-- EMPLOYEE 테이블에서 급여가 3M원 초과인 직원의 
-- 사번 이름 급여 부서코드 

SELECT EMP_ID,EMP_NAME,SALARY,DEPT_CODE 
FROM EMPLOYEE
WHERE SALARY > 3000000;


-- EMPLOYEE 부서코드가 'D9'직원의 사번 이름 부서코드 전화번호

SELECT EMP_ID, EMP_NAME, DEPT_CODE, PHONE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-------------------------------------------------------------------------------

-- 논리 연산자

-- EMPLOYEE 테이블에서 급여가 200만 이상
-- 부서코드 'D6'인 직원
-- 이름 급여 부서코드

SELECT EMP_NAME, SALARY, DEPT_CODE 
FROM EMPLOYEE
WHERE SALARY >= 2000000 
AND DEPT_CODE = 'D6';

-- 급여 300이상, 500이하 직원
-- 사번 이름 급여 

SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY>=3000000
AND SALARY<=5000000;

-- 부서코드 'D6' OR 'D9'
-- 사번 이름 부서코드

SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM employee
WHERE dept_code = 'D6'
OR dept_code = 'D9';

-------------------------------------------------------------------------------

-- BETWEEN A AND B : A~B

SELECT EMP_ID, EMP_NAME, SALARY
FROM employee
WHERE SALARY
BETWEEN 3000000 AND 5000000;

--NOT BETWEEN

SELECT EMP_ID, EMP_NAME, SALARY
FROM employee
WHERE SALARY
NOT BETWEEN 3000000 AND 5000000;

-- BETWEEN 이용한 날짜 비교
-- 입사일 900101 ~ 991231 
-- 사번

SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM employee
WHERE HIRE_DATE
BETWEEN '1990/01/01' AND '1999/12/31';

-- 날짜를 어떻게 수 로 이해했지?
-- 날짜를 문자열 형식으로 작성시 DB가 알아서 날짜타입으로 자동 형 변환

-------------------------------------------------------------------------------

--LIKE : 비교하려는 값이 특정한 패턴을 만족 하면 조회

--WHERE 컬럼 LIKE '패턴' 
--WILDE CARD: % _

/* 1) A% 문자열이 A로 시작하는 값
   2) %A 문자열이 A로 끝나는 값
   3) %A% 문자열이 A가 포함 되어있는 값
*/

/* 1) A_ : A 뒤에 한글자
   2) ___A : A 앞에 세 글자
*/

-- EMPLOYEE 성이 '전' 사번 이름 조회

SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

-- EMPLOYEE 이름에 '하' 포함 사번 이름 조회

SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

--전화번호 010 시작 사번 이름 전화번호

SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '010%';

SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';



-- 이메일 _ 3

SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___$_%' ESCAPE '$' ;

--ESCAPE OPTION



-- 연습문제
-- 1. EMPLOYEE 테이블에서 이름 끝이 '연'으로 끝나는 사원의 이름 조회

SELECT EMP_NAME 
FROM employee
WHERE EMP_NAME LIKE '%연';

-- 2. EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를 조회

SELECT EMP_NAME,PHONE
FROM employee
WHERE PHONE NOT LIKE '010%';

-- 3. EMPLOYEE 테이블에서 메일주소 '_'의 앞이 4자 이면서 DEPT_CODE가 D9 또는 D6이고
--    고용일이 90/01/01 ~ 00/12/01이고, 급여가 270만 이상인 사원의 전체를 조회

SELECT EMP_NAME, DEPT_CODE, EMAIL, HIRE_DATE, salary
FROM employee
WHERE HIRE_DATE BETWEEN '1990/01/01' AND '2000/12/01'
AND SALARY >= 2700000 
--AND DEPT_CODE IN ('D6','D9')
AND (DEPT_CODE = 'D9' OR DEPT_CODE = 'D6')
AND EMAIL LIKE '____$_%' ESCAPE '$';


--다시봐야할듯


-- 연산자 우선순위
/*
1. 산술연산자
2. 연결연산자
3. 비교연산자
4. IS NULL / IS NOT NULL, LIKE, IN / NOT IN
5. BETWEEN AND / NOT BETWEEN AND
6. NOT(논리연산자)
7. AND(논리연산자)
8. OR(논리연산자)
*/
--------------------------------------------------------------------------------

/* IN 연산자 
- 비교하려는 값과 목록에 작성된 값 중 일치하는 것이 있을 경우 조회하는 연산자

---> OR 연산 중복 사용효과

[작성법] 
컬럼명 IN (1,2,3,....)
*/

--부서코드 D1 D6 D9
-- 사번 이름 부서코드

SELECT EMP_ID,EMP_NAME,DEPT_CODE
FROM employee
WHERE DEPT_CODE IN ('D1','D6','D9');

-- 사번 200 205 210

SELECT EMP_ID,EMP_NAME
FROM employee
WHERE EMP_ID IN (200,205,210);


SELECT EMP_ID,EMP_NAME
FROM employee
WHERE EMP_ID NOT IN (200,205,210);

--------------------------------------------------------------------------------

--연결연산자(||)
-- 여러 값을 하나의 컬럼 값으로 연결하는 연산자
--(자바의 문자열 + 이어쓰기 효과)

SELECT EMP_NAME|| '의 급여는' ||' '|| SALARY||'원 입니다.' "직원 급여"
FROM employee;

--------------------------------------------------------------------------------

/* NULL 처리 연산자 

-- JAVA에서 NULL : 참조하는 객체가 없다
-- DB에서 NULL : 컬럼 값이 없다.

1) IS NULL : 값이 NULL일 경우

2) IS NOT NULL : NULL이 아닌 경우

*/

SELECT EMP_ID,EMP_NAME,PHONE
FROM employee
WHERE PHONE IS NULL ;


SELECT EMP_ID,EMP_NAME,BONUS
FROM employee
WHERE BONUS IS NOT NULL;

-------------------------------------------------------------------------------

/*  ORDER BY 
- SELECT의 조회 결과 (RESULT SET)의 정렬

- SELECT문 마지막에 해석
SELECT  3
FROM    1
WHERE   2
ORDER BY 컬럼명 | (별칭) | 컬럼순서 [정렬 방식] [NULLS FIRST | LAST] 

*/

-- 급여 오름차순 이름 급여
SELECT EMP_NAME,SALARY
FROM employee
ORDER BY salary ASC; --ASCENDING

SELECT EMP_NAME,SALARY
FROM employee
ORDER BY salary DESC; --DESCENDING


--급여 200이상 사원 오름차순

SELECT EMP_NAME, SALARY
FROM employee
WHERE salary >= 2000000
ORDER BY salary ; -- ASC 생략가능


-- 이름
SELECT EMP_NAME
FROM employee
ORDER BY EMP_NAME;

SELECT EMP_NAME, HIRE_DATE
FROM employee
ORDER BY 2 DESC;

SELECT EMP_NAME, SALARY*12 AS "연봉"
FROM EMPLOYEE
--WHERE SALARY*12 >= 50000000
ORDER BY 연봉 DESC;

--BONUS ASC
SELECT EMP_NAME,BONUS
FROM employee
--ORDER BY BONUS DESC; -- NULL값은 내림차순이 DEFAULT
ORDER BY BONUS NULLS FIRST ;

-- ASCENDING - NULLS LAST
-- DESCENDING - NULLS FIRST 

-- 부서코드 오름차순 후
-- 부서별 급여 내림차순
-- 정렬 중첩
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM employee
ORDER BY DEPT_CODE, SALARY DESC;












