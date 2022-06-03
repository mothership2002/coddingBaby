SELECT * FROM TB_CLASS;
SELECT * FROM tb_class_professor;
SELECT * FROM TB_DEPARTMENT;
SELECT * FROM TB_GRADE;
SELECT * FROM tb_professor;
SELECT * FROM TB_STUDENT;

-- 1
SELECT DEPARTMENT_NAME "학과 명",CATEGORY "계열" FROM TB_DEPARTMENT;

-- 2
SELECT DEPARTMENT_NAME ||'의 정원은 '|| CAPACITY ||'명 입니다' 
FROM TB_DEPARTMENT;

-- 3 국어국문 여 휴학

SELECT STUDENT_NAME
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO) 
WHERE SUBSTR(STUDENT_SSN,INSTR(STUDENT_SSN,'-')+1,1) = '2'
AND ABSENCE_YN = 'Y'
AND DEPARTMENT_NO = '001';

-- 4 학번 추적
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO IN('A513079','A513090','A513091','A513110','A513119')
ORDER BY STUDENT_NAME DESC;

-- 5 입학정원 학과이름 계열
SELECT DEPARTMENT_NAME, CATEGORY
FROM TB_DEPARTMENT
WHERE CAPACITY >=20 AND CAPACITY < 30; 

-- 6 총장 - 소속학과없음
SELECT PROFESSOR_NAME
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;

-- 7 전산상 오류 학과 미지정 확인
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE DEPARTMENT_NO IS NULL;

-- 8 선수과목 여부 확인
SELECT CLASS_NO
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

-- 9 카테고리 검색 -- DISTINCT
SELECT DISTINCT CATEGORY
FROM TB_DEPARTMENT;

-- 10 02학번 전주 거주 휴학x 학번 이름 주민번호
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE ENTRANCE_DATE BETWEEN '20020101' AND '20021231'
AND ABSENCE_YN = 'N'
AND STUDENT_ADDRESS LIKE '%전주시%';

-- SELECT 완







SELECT * FROM TB_CLASS;
SELECT * FROM tb_class_professor;
SELECT * FROM TB_DEPARTMENT;
SELECT * FROM TB_GRADE;
SELECT * FROM tb_professor;
SELECT * FROM TB_STUDENT;

-- 1 영문학과 002 학번 이름 입학연도 오름차순 
SELECT STUDENT_NO 학번, STUDENT_NAME 이름,ENTRANCE_DATE 입학년도
FROM TB_STUDENT
WHERE DEPARTMENT_NO = '002';

-- 2 교수 3자 아닌 사람 -LENGTH != CONUT
SELECT PROFESSOR_NAME,PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE LENGTH(PROFESSOR_NAME) != 3;

-- 3 교수 이름 나이 -TO_CHAR -TO_DATE 
SELECT PROFESSOR_NAME,TRUNC((SYSDATE - TO_DATE(SUBSTR(PROFESSOR_SSN,1,INSTR(PROFESSOR_SSN,'-')-1)+19000000))/365.25) 나이
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN,INSTR(professor_ssn,'-')+1,1) = 1
ORDER BY 나이 ASC;

-- 4 교수 '이름'만 출력
SELECT SUBSTR(PROFESSOR_NAME,2)
FROM TB_PROFESSOR;

-- 5 재수생 - 어렵다 
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE MONTHS_BETWEEN(ENTRANCE_DATE,TO_DATE(SUBSTR(STUDENT_SSN,1,INSTR(STUDENT_SSN,'-')-1),'RRMMDD'))/12 > 19.17;

-- 6 2020 12 25
SELECT TO_CHAR(TO_DATE(20201225),'DAY') FROM DUAL;

-- 7
SELECT TO_DATE('99/10/11','YY/MM/DD'),TO_DATE('49/10/11','YY/MM/DD') FROM DUAL;

-- 8 2000> 학번
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE SUBSTR(STUDENT_NO,1,1) != 'A';

-- 9 A517178 한아름 학점총합 
SELECT ROUND(AVG(POINT),1)
FROM TB_GRADE
JOIN tb_student USING (STUDENT_NO)
WHERE STUDENT_NO = 'A517178';

-- 10 학과 번호 학생수 -GROUP BY
SELECT DEPARTMENT_NO,COUNT(*)
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;

-- 11 지도교수X
SELECT COUNT(*)
FROM TB_STUDENT
WHERE coach_professor_no IS NULL;

-- 12 학번 A112113 년도별 평점 
SELECT SUBSTR(TERM_NO,1,4),ROUND(AVG(POINT),1)
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4)
ORDER BY SUBSTR(TERM_NO,1,4);

-- 13 학과별 휴학수 -DECODE 어렵네
SELECT DEPARTMENT_NO,SUM(DECODE(ABSENCE_YN,'Y',1,0))
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;

--14 동명이인 -HAVING
SELECT STUDENT_NAME, COUNT(STUDENT_NAME)
FROM TB_STUDENT
GROUP BY STUDENT_NAME
HAVING COUNT(STUDENT_NAME)>1
ORDER BY STUDENT_NAME;

--15
--SELECT SUBSTR(TERM_NO,1,4) 년도,SUBSTR(TERM_NO,5)학기,POINT
SELECT SUBSTR(TERM_NO,1,4),SUBSTR(TERM_NO,5), ROUND(AVG(POINT),1)
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY ROLLUP(SUBSTR(TERM_NO,1,4),SUBSTR(TERM_NO,5))
ORDER BY SUBSTR(TERM_NO,1,4);


--2번 완



SELECT * FROM TB_CLASS;
SELECT * FROM tb_class_professor;
SELECT * FROM TB_DEPARTMENT;
SELECT * FROM TB_GRADE;
SELECT * FROM tb_professor;
SELECT * FROM TB_STUDENT;

-- 1 학생 이름 주소 오름
SELECT STUDENT_NAME "학생 이름",STUDENT_ADDRESS 주소지
FROM TB_STUDENT
ORDER BY STUDENT_NAME;

-- 2 휴학중인 학생이름 주민번호
SELECT STUDENT_NAME,STUDENT_SSN
FROM TB_STUDENT
WHERE ABSENCE_YN = 'Y';

-- 3 주소지 강원도 경기도 1900년대 학번 
-- 이름 학번 주소 오름차순 
SELECT STUDENT_NAME 학생이름, STUDENT_NO 학번,STUDENT_ADDRESS "거주지 주소"
FROM TB_STUDENT
WHERE STUDENT_NO LIKE '%9______'
AND (STUDENT_ADDRESS LIKE '%경기도%'
OR STUDENT_ADDRESS LIKE '%강원도%')
ORDER BY STUDENT_NAME
;


-- 4 법학과 교수 중 나이 내림

SELECT PROFESSOR_NAME,PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO FROM TB_DEPARTMENT
                       WHERE DEPARTMENT_NAME = '법학과')
ORDER BY PROFESSOR_SSN;


-- 5 2004 2학기 C3118100 과목 학점 조회
-- 학점 디센딩 IF 학점 같으면 학번 낮은 순 
SELECT STUDENT_NO,POINT
FROM TB_GRADE
WHERE CLASS_NO = 'C3118100'
AND TERM_NO = '200402'
ORDER BY POINT DESC;
--학번 낮다 기준은 뭐지


-- 6 학생번호 이름 학과이름 이름오름차
SELECT STUDENT_NO,STUDENT_NAME,DEPARTMENT_NAME
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
ORDER BY STUDENT_NAME;


-- 7 과목이름 과목의학과이름
SELECT CLASS_NAME,DEPARTMENT_NAME
FROM TB_CLASS
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO);

-- 8 과목별 교수 
SELECT CLASS_NAME,PROFESSOR_NAME
FROM TB_CLASS
JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_PROFESSOR USING(PROFESSOR_NO);

-- 9 인문사회 과목별 교수
SELECT CLASS_NAME,PROFESSOR_NAME
FROM TB_CLASS C
JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_PROFESSOR USING(PROFESSOR_NO)
WHERE C.DEPARTMENT_NO IN (SELECT DEPARTMENT_NO
                         FROM TB_DEPARTMENT
                         WHERE CATEGORY = '인문사회')
ORDER BY CLASS_NO;

-- 10 음악 학과 학생 평점 
-- 학번 학생이름 전체 평점
SELECT STUDENT_NO,STUDENT_NAME,ROUND(AVG(POINT),1) 평균
FROM TB_STUDENT
JOIN TB_GRADE USING (STUDENT_NO)
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_DEPARTMENT
                       WHERE DEPARTMENT_NAME = '음악학과')
GROUP BY STUDENT_NO,STUDENT_NAME
;

-- 11 A313047 학과 이름 지도교수
SELECT DEPARTMENT_NAME "학과 이름",STUDENT_NAME "학생 이름",PROFESSOR_NAME "지도 교수"
FROM TB_STUDENT
NATURAL JOIN TB_DEPARTMENT
JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
WHERE STUDENT_NO = 'A313047';

-- 12 07 인간관계론 수강 
SELECT STUDENT_NAME, TERM_NO
FROM TB_STUDENT
NATURAL JOIN TB_GRADE
WHERE CLASS_NO = (SELECT CLASS_NO
                  FROM TB_CLASS
                  WHERE CLASS_NAME = '인간관계론')
AND TERM_NO LIKE '2007%';

-- 13 예체능 계열 과목중 과목 담당교수를 한명도 배정 받지 못한 과목을 찾아
--    그 과목이름과 학과 이름 출력
SELECT CLASS_NAME,DEPARTMENT_NAME
FROM TB_CLASS C
NATURAL JOIN TB_DEPARTMENT
WHERE CATEGORY = '예체능'
AND C.CLASS_NO NOT IN (SELECT P.CLASS_NO
                       FROM TB_CLASS_PROFESSOR P);

-- 14 서반아어학과 학생 지도교수 
-- 학생이름과 지도교수 이름  NULL 지도교수 미지정
-- 고학번순 

SELECT STUDENT_NAME "학생 이름",NVL(PROFESSOR_NAME,'지도교수 미지정') "지도교수"
FROM TB_STUDENT S
LEFT JOIN TB_PROFESSOR ON (PROFESSOR_NO = COACH_PROFESSOR_NO)
WHERE S.DEPARTMENT_NO =(SELECT J.DEPARTMENT_NO
                        FROM TB_DEPARTMENT J
                        WHERE J.DEPARTMENT_NAME = '서반아어학과'); 
                        
-- 15 재학생 평점 4.0이상 
SELECT STUDENT_NO,STUDENT_NAME,DEPARTMENT_NAME,ROUND(AVG(POINT),2)
FROM TB_STUDENT
NATURAL JOIN TB_GRADE
NATURAL JOIN TB_DEPARTMENT
WHERE ABSENCE_YN = 'N'
GROUP BY STUDENT_NO,STUDENT_NAME,DEPARTMENT_NAME
HAVING AVG(POINT) >= 4.0;

-- 16 환경조경학과 전공과목 과목평균점수
SELECT CLASS_NO,CLASS_NAME,ROUND(AVG(POINT),2)
FROM TB_CLASS
NATURAL JOIN TB_GRADE
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_DEPARTMENT
                       WHERE DEPARTMENT_NAME = '환경조경학과')
AND CLASS_TYPE LIKE '전공%'                       
GROUP BY CLASS_NO,CLASS_NAME;                       

-- 17 최경희 같은 과 학생
-- 이름 주소 
SELECT STUDENT_NAME,STUDENT_ADDRESS
FROM TB_STUDENT
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_STUDENT
                       WHERE STUDENT_NAME = '최경희')
                ;       
                       
-- 18 국어국문학과 총 평점 상위 한명
SELECT STUDENT_NO,STUDENT_NAME
FROM (SELECT STUDENT_NO,STUDENT_NAME,AVG(POINT)
      FROM TB_STUDENT
      NATURAL JOIN TB_GRADE
      NATURAL JOIN TB_DEPARTMENT
      WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                             FROM TB_DEPARTMENT
                             WHERE DEPARTMENT_NAME = '국어국문학과')
      GROUP BY STUDENT_NO,STUDENT_NAME
      ORDER BY AVG(POINT) DESC)
WHERE ROWNUM < 2;

-- 19 환경조경학과 속한 과 전공과목 평점
SELECT DEPARTMENT_NAME,ROUND(AVG(POINT),1)
FROM TB_DEPARTMENT
NATURAL JOIN TB_CLASS
NATURAL JOIN TB_GRADE
WHERE CATEGORY = (SELECT CATEGORY
                  FROM TB_DEPARTMENT
                  WHERE DEPARTMENT_NAME = '환경조경학과')
GROUP BY DEPARTMENT_NAME;
