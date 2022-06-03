-- 함수 : 컬럼 값을 읽어서 연산한 결과

-- 단일행 (SINGLE ROW)

-- 그룹 (GROUP)

------------------------------------------------------------------------------

-- LENGTH (문자열 || 컬럼)

SELECT LENGTH('HELLO WORLD') FROM DUAL;

SELECT EMAIL,LENGTH(EMAIL)
FROM EMPLOYEE
WHERE LENGTH(EMAIL) = 12;

-------------------------------------------------------------------------------

-- INSTR('문자열' | 컬럼명, '찾을문자', [찾을 위치 시작위치, [순번]])
-- 지정한 위치부터 지정한 순번째로 검색되는 문자의 시작 위치를 반환

SELECT INSTR('AABAACAABBAA','B') "인덱스" FROM DUAL;

SELECT INSTR('AABAACAABBAA','B',5) "인덱스" FROM DUAL;

-- 사원명 이메일 에메일중 @

SELECT EMP_NAME, EMAIL,
INSTR(EMAIL,'@') "엣 위치"
FROM EMPLOYEE;

-------------------------------------------------------------------------------

-- SUBSTR('문자열' | 컬럼명, 잘라내기 시작할 위치 [, 잘라낼 길이]  )
-- 컬럼이나 문자열에서 지정한 위치부터 지정된 길이만큼 문자열을 잘라내서 반환
--> 잘라낼 길이 생략 시 끝까지 잘라냄

SELECT EMP_NAME,EMAIL,SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1) ID
FROM EMPLOYEE
ORDER BY ID;

-------------------------------------------------------------------------------
-- TRIM([옵션] '문자열' | 컬럼명 [FROM '문자열'|컬럼명]  )
-- 주어진 컬럼이나 문자열의 앞, 뒤, 양쪽에 있는 지정된 문자를 제거
--> (보통 양쪽 공백 제거에 많이 사용)

-- 옵션 :  LEADING(앞쪽), TRAILING(뒤쪽), BOTH(양쪽, 기본값)

SELECT '     KH      ',TRIM('     KH     ') FROM DUAL;

SELECT '     K H     ',TRIM('     K H     ') FROM DUAL;

SELECT '-----KH-----',TRIM('-'FROM'-----KH-----') FROM DUAL;

SELECT '-----KH-----',TRIM(LEADING'-'FROM'-----KH-----') FROM DUAL;

SELECT '-----KH-----',TRIM(TRAILING'-'FROM'-----KH-----') FROM DUAL;

-----------------------------------------------------------------------------

--ABS(숫자 | 컬럼명) : 절대 값
SELECT ABS(10),ABS(-10) FROM DUAL;

--MOD(숫자 | 컬럼명, 숫자 | 컬럼명): 나머지 값 변환

--사원 월급 100 나머지
SELECT EMP_NAME,SALARY,MOD(SALARY,1000000) 나머지
FROM EMPLOYEE
ORDER BY 나머지 DESC;

--ROUND (숫자 |컬럼명 [,소수점])
SELECT ROUND(123.4567,3)
FROM DUAL;

SELECT ROUND(123.4567,-1)
FROM DUAL;

-------------------------------------------------------------------------------

--CEIL(숫자|컬럼명)      올림
--FLOOR(숫자|컬럼명)     내림

SELECT 123.5, CEIL(123.5),FLOOR(1234.5) FROM DUAL;

--TRUNC(숫자|컬럼명[,위치]) : 특정 위치 아래 버림
SELECT TRUNC(12345.6789,-1)
FROM DUAL;

SELECT ROUND(-123.855)
FROM DUAL;

------------------------------------------------------------------------------
--날짜관련

--SYSDATE
SELECT SYSDATE FROM DUAL;

--SYSTIMESTAMP 

SELECT SYSTIMESTAMP FROM DUAL;

-- MONTHS_BETWEEN

SELECT ROUND( MONTHS_BETWEEN(SYSDATE,'2022/02/21') )||'개월' 수강기간
FROM DUAL;

--사원 이름 입사일 SYSDATE 근무개월 근무 햇수
SELECT EMP_NAME,HIRE_DATE,
CEIL(MONTHS_BETWEEN(SYSDATE,HIRE_DATE))||'개월' "근무 연속",
CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)/12)|| '년차' "근무 햇수"
FROM EMPLOYEE;

-------------------------------------------------------------------------------
--ADD MONTH(날짜 , 숫자)

SELECT ADD_MONTHS(SYSDATE,4) + 7 종강날짜 FROM DUAL;

--LAST_DAY(날) 
SELECT LAST_DAY('2020/2/1') FROM DUAL;

-------------------------------------------------------------------------------
-- EXTRACT : 년, 월, 일 정보를 추출하여 리턴
-- EXTRACT(YEAR FROM 날짜) : 년도만 추출
-- EXTRACT(MONTH FROM 날짜) : 월만 추출
-- EXTRACT(DAY FROM 날짜) : 일만 추출

SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;

-- 이름 입사 년도 월 일
SELECT EMP_NAME,
    EXTRACT(YEAR FROM HIRE_DATE) "입사 년도",
    EXTRACT(MONTH FROM HIRE_DATE) "입사 월",
    EXTRACT(DAY FROM HIRE_DATE) "입사 일"
FROM EMPLOYEE

WHERE EXTRACT(MONTH FROM HIRE_DATE) = 1;

-------------------------------------------------------------------------------

--형변환 함수
--문자열 , 숫자 ,날짜

--TO_CHAR(날짜,[포멧]) 둘다 날짜 변환
--TO_CHAR(숫자,[포멧])
--9 적용 시 , 숫자 한칸을 의미, 우측정렬
--0 적용 시 , 빈칸 0 , 우측정렬

SELECT TO_CHAR(1234,'99999') FROM DUAL;
SELECT TO_CHAR(1234,'00000') FROM DUAL;

SELECT TO_CHAR(12345123,'999,999,999') FROM DUAL;
--L:현재 DB에 설정된 나라의 화폐 기호
SELECT TO_CHAR(12345123,'L999,999,999') FROM DUAL;
SELECT TO_CHAR(12345123,'$999,999,999') FROM DUAL;

-- 급여 표기
SELECT EMP_NAME,TO_CHAR(SALARY,'L999,999,999') "월 급여"
FROM EMPLOYEE
ORDER BY "월 급여" DESC;

--날짜
--DAY ,DY
--YYYY YY
--RRRR년도 RR
SELECT SYSDATE,TO_CHAR(SYSDATE,'DY PM HH:MI:SS') FROM DUAL;

SELECT EMP_NAME 직원명,TO_CHAR(HIRE_DATE,'YY-MM-DD') 입사일
FROM EMPLOYEE;

-- 직원들의 입사일을 '2017년 12월 06일 (수)' 형식으로 출력
SELECT EMP_NAME,TO_CHAR(HIRE_DATE,'YYYY"년" MM"월" DD"일" (DY)') 입사일
FROM EMPLOYEE
ORDER BY 입사일;

--------------------------------------------------------------------------------
SELECT '2022-03-22',TO_DATE('2022-03-22') FROM DUAL;

SELECT TO_DATE('20100103') FROM DUAL;
SELECT TO_DATE(20101210) FROM DUAL;

SELECT TO_DATE('041030 143000','YYMMDD HH24MISS') FROM DUAL;

SELECT TO_CHAR(TO_DATE('041030 143000','YYMMDD HH24MISS'),'YYYY/MM/DD HH24"시"MI"분"') FROM DUAL;

--생년월일 조회 -Y R의 차이
SELECT EMP_NAME,
    TO_DATE(SUBSTR(EMP_NO,1,INSTR(EMP_NO,'-')-1),'RRMMDD')
FROM EMPLOYEE;

SELECT TO_DATE('490115','RRMMDD') FROM DUAL;
--YY - 2000 이상
--RR - 50미만 2000 50이상 1900

--------------------------------------------------------------------------------

--숫자 형 변환

SELECT TO_NUMBER('1,000,000','9,999,999') + 10 FROM DUAL;

SELECT EMP_NAME,BONUS,NVL2(BONUS,0.8,0.3)
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 사원명, 입사일-오늘, 오늘-입사일 조회
-- 단, 입사일-오늘의 별칭은 "근무일수1", 
-- 오늘-입사일의 별칭은 "근무일수2"로 하고
-- 모두 정수(내림)처리, 양수가 되도록 처리
SELECT EMP_NAME, ABS(FLOOR(HIRE_DATE-SYSDATE))AS 근무일수1,
FLOOR(SYSDATE-HIRE_DATE) 근무일수2
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 사번이 홀수인 직원들의 정보 모두 조회
SELECT * FROM EMPLOYEE
WHERE MOD(EMP_ID,2)=1;
-- 모든정보 조회?  : *

-- EMPLOYEE 테이블에서 근무 년수가 20년 이상인 직원 정보 조회
SELECT * FROM EMPLOYEE
WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE)/12 >=20
ORDER BY MONTHS_BETWEEN(SYSDATE, HIRE_DATE)/12 DESC;
--EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM HIRE_DATE) "근무 년수"

-- EMPLOYEE 테이블에서
-- 직원명과 주민번호를 조회
-- 단, 주민번호 9번째 자리부터 끝까지는 '*'문자로 채움
-- 예 : 홍길동 771120-1******
SELECT EMP_NAME,SUBSTR(EMP_NO,1,INSTR(EMP_NO,'-')+1)||'******' "주민번호"
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서
-- 직원명, 직급코드, 연봉(원) 조회
-- 단, 연봉은 보너스가 적용된 1년치 급여 + ￦57,000,000 으로 표시 )
SELECT EMP_NAME,DEPT_CODE,
TO_CHAR((SALARY*12)+(12*SALARY*NVL(BONUS,0)),'L999,999,999') AS "총 연봉(원)", 
TO_CHAR(12*SALARY*NVL(BONUS,0),'L999,999,999') 성과금,
TO_CHAR(SALARY*12,'L999,999,999') "연봉"
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서
-- 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원의 
-- 사번 사원명 부서코드 입사일 조회
SELECT EMP_ID,EMP_NAME,DEPT_CODE,HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE IN('D5','D9')
AND HIRE_DATE BETWEEN '2004-01-01'AND '2004-12-31' ;
--이건 모르겠네 맞는 듯?

SELECT EMP_NAME,HIRE_DATE,DEPT_CODE
FROM EMPLOYEE
ORDER BY HIRE_DATE DESC;

-- EMPLOYEE 테이블에서
-- 직원명, 입사일, 입사한 달의 근무일수 조회
-- 단, 입사한 날도 근무일수에 포함해서 +1 할 것
SELECT EMP_NAME 직원명 ,HIRE_DATE 입사일,
    (EXTRACT(DAY FROM LAST_DAY(HIRE_DATE))-EXTRACT(DAY FROM HIRE_DATE) + 1)
    "입사한 달의 근무일수" 
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서
-- 직원명, 부서코드, 생년월일, 나이 조회
-- 단, 생년월일은 주민번호에서 추출해서, 
-- ㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
-- 나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산.
-- (년도만을 이용한 나이 구하기,   만 나이 구하기 둘다 시도해보세요!)
SELECT EMP_NAME,DEPT_CODE,
    TO_CHAR(TO_DATE(SUBSTR(EMP_NO,1,INSTR(EMP_NO,'-')-1),'RR MM DD '),'RR"년"MM"월"DD"일"') 생년월일
    ,CEIL((SYSDATE - TO_DATE(SUBSTR(EMP_NO,1,INSTR(EMP_NO,'-')-1),'RRMMDD'))/365) +1 나이
    ,TRUNC((SYSDATE - TO_DATE(SUBSTR(EMP_NO,1,INSTR(EMP_NO,'-')-1),'RRMMDD'))/365) "만 나이"
FROM EMPLOYEE;


---------------------------------------------------------------------------------
--선택함수
-- 여러가지 경우에 따라 결과 선택

-- DECODE(계산식 | 컬럼명, 조건값1, 선택값1, 조건값2, 선택값2.....,default)
-- 비교하고자 하는 값 또는 컬럼이 조건식과 같으면 결과 값 반환
-- 일치하는 값을 확인(자바의 SWITCH와 비슷함)

SELECT EMP_NAME,DECODE(SUBSTR(EMP_NO,8,1),'1','남성','2','여성') 성별
FROM EMPLOYEE;

-- 직원의 급여를 인상하고자 한다
-- 직급코드가 J7인 직원은 급여의 10%를 인상하고
-- 직급코드가 J6인 직원은 급여의 15%를 인상하고
-- 직급코드가 J5인 직원은 급여의 20%를 인상하며
-- 그 외 직급의 직원은 급여의 5%만 인상한다.
-- 직원 테이블에서 직원명, 직급코드, 급여, 인상급여(위 조건)을 조회하세

SELECT EMP_NAME,JOB_CODE,SALARY,
    DECODE(JOB_CODE, 'J7',SALARY*1.1,
                     'J6',SALARY*1.15,
                     'J5',SALARY*1.2,
                     SALARY*1.05) 인상급여
FROM employee;

-- CASE WHEN 조건식 THEN 결과값
--      WHEN 조건식 THEN 결과값
--      ELSE 결과값
-- END
-- 비교하고자 하는 값 또는 컬럼이 조건식과 같으면 결과 값 반환
-- 조건은 범위 값 가능
SELECT EMP_NAME,
    CASE
        WHEN SUBSTR(EMP_NO,8,1) = 1 OR SUBSTR(EMP_NO,8,1) = 3 THEN '남성'
        ELSE '여성'
    END 성별
FROM employee;

-- EMPLOYEE 테이블에서 사번, 사원명, 급여를 조회
-- 급여가 500만원 이상이면 '고급'
-- 급여가 300~500만원이면 '중급'
-- 그 미만은 '초급'으로 출력처리하고 별칭은 '구분'으로 한다.
-- 부서코드가 'D6'인 직원만 조회
-- 직급코드 오름차순 정렬

SELECT EMP_ID,EMP_NAME,SALARY,
    CASE
        WHEN SALARY>=5000000 THEN '고급'
        WHEN SALARY>=3000000 THEN '중급'
        ELSE '초급'
    END 기술등급
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6'
ORDER BY JOB_CODE ASC;

-------------------------------------------------------------------------------
--그룹함수
--하나 이상의 행을 그룹으로 묶어 연산, 하나의 결과로 반환

-- SUM(컬럼)
SELECT SUM(SALARY)
FROM employee;

--부서코드 D9 급여합
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

SELECT ROUND(AVG(SALARY))
FROM EMPLOYEE;

--MIN,MAX 타입제한 없음
--대/소 , 과거/미래, 글자 순서
SELECT MIN(SALARY),MIN(EMAIL),MIN(HIRE_DATE)
FROM EMPLOYEE;

SELECT MAX(SALARY),MAX(HIRE_DATE),MAX(EMAIL)
FROM EMPLOYEE
WHERE EMP_ID !=200;

-- * COUNT(* | 컬럼명) : 행 개수를 헤아려서 리턴
-- COUNT([DISTINCT] 컬럼명) : 중복을 제거한 행 개수를 헤아려서 리턴
-- COUNT(*) : NULL을 포함한 전체 행 개수를 리턴
-- COUNT(컬럼명) : NULL을 제외한 실제 값이 기록된 행 개수를 리턴함
SELECT COUNT(DEPT_CODE)
FROM EMPLOYEE;

SELECT COUNT(*)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL;

SELECT COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE ;

-- 남자 직원
SELECT COUNT(EMP_NO)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) = 1;


