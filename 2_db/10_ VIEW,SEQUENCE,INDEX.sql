/* VIEW
    - SELECT문의 실행 결과를 저장하는 객체   
    논리적 가상테이블
    
    복잡한 SELECT문을 쉽게 재사용
    테이블의 실제 값을 숨길 수 있음
    
    가상의 테이블 ALTER 사용불가
    VIEW를 이용한 DML 가능한 경우가 있지만
    제약이 존재해 조회용으로만 사용
   
   
    [VIEW 생성 방법]
    CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰이름 [(alias[,alias]...]
    AS subquery
    [WITH CHECK OPTION]
    [WITH READ ONLY];

-- 1) OR REPLACE 옵션 : 기존에 동일한 뷰 이름이 존재하는 경우 덮어쓰고, 
--                      존재하지 않으면 새로 생성.
-- 2) FORCE / NOFORCE 옵션
--      FORCE : 서브쿼리에 사용된 테이블이 존재하지 않아도 뷰 생성
--      NOFORCE : 서브쿼리에 사용된 테이블이 존재해야만 뷰 생성(기본값)
-- 3) WITH CHECK OPTION 옵션 : 옵션을 설정한 컬럼의 값을 수정 불가능하게 함.
-- 4) WITH READ ONLY 옵션 : 뷰에 대해 조회만 가능(DML 수행 불가)

*/

SELECT EMP_ID,EMP_NAME,DEPT_TITLE,JOB_NAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);

CREATE VIEW V_EMP
AS SELECT EMP_ID,EMP_NAME,DEPT_TITLE,JOB_NAME
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN JOB USING(JOB_CODE);

-- ORA-01031 :  권한 불충분
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
GRANT CREATE VIEW TO LDH;

-- OR REPLACE

CREATE OR REPLACE VIEW V_EMP
AS SELECT EMP_ID 사번 ,EMP_NAME 이름 ,DEPT_TITLE 부서명 ,JOB_NAME 직책
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN JOB USING(JOB_CODE);

SELECT * FROM V_EMP
WHERE 직책 = '대리';

--------------------------------------------------------------------------------
CREATE TABLE DEPT_COPY2
AS SELECT * FROM DEPARTMENT;

CREATE VIEW V_DCOPY2
AS SELECT DEPT_ID,LOCATION_ID
FROM DEPT_COPY2;

SELECT * FROM V_DCOPY2;

INSERT INTO V_DCOPY2
VALUES('D0','L3');

SELECT * FROM DEPT_COPY2;

UPDATE DEPT_COPY2 SET DEPT_TITLE = '뭐지'
WHERE DEPT_TITLE IS NULL;

DELETE FROM DEPT_COPY2
WHERE DEPT_ID = 'D0';
ROLLBACK;

SELECT * FROM DEPT_COPY2;
SELECT * FROM V_DCOPY2;

-- 뷰로 DML할 경우, 원본데이터에 저장해버림
-- 널 제약조건 삽입
ALTER TABLE DEPT_COPY2 MODIFY DEPT_TITLE NOT NULL;

-- INSERT 수행
INSERT INTO V_DCOPY2 VALUES('D0','L5');
--ORA-01400 NOT NULL 제약조건
--VIEW는 원본에 영향을 주므로 미포함 컬럼엔 NULL 값을 부여

-------------------------------------------------------------------------------
-- WITH READ ONLY
CREATE OR REPLACE VIEW V_DCOPY2
AS SELECT DEPT_ID,LOCATION_ID FROM DEPARTMENT
WITH READ ONLY;

INSERT INTO V_DCOPY2 VALUES ('D0','L5');
-- 읽기 전용 뷰 설정
SELECT * FROM V_DCOPY2;

-------------------------------------------------------------------------------
-- SEQUENCE
-- 순차적 번호 자동 삽입
/*  [작성법]
  CREATE SEQUENCE 시퀀스이름
  [START WITH 숫자] -- 처음 발생시킬 시작값 지정, 생략하면 자동 1이 기본
  [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
  [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27승, -1)
  [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26승)
  [CYCLE | NOCYCLE] -- 값 순환 여부 지정
  [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트

-- 시퀀스의 캐시 메모리는 할당된 크기만큼 미리 다음 값들을 생성해 저장해둠
-- --> 시퀀스 호출 시 미리 저장되어진 값들을 가져와 반환하므로 
--     매번 시퀀스를 생성해서 반환하는 것보다 DB속도가 향상됨.
*/

CREATE TABLE EMPLOYEE_COPY4
AS SELECT EMP_ID, EMP_NAME FROM EMPLOYEE;

ALTER TABLE EMPLOYEE_COPY4 ADD CONSTRAINT EMPCOPY_PK PRIMARY KEY(EMP_ID);

SELECT * FROM EMPLOYEE_COPY4;

SELECT * FROM ALL_CONSTRAINTS
WHERE TABLE_NAME = 'EMPLOYEE_COPY4';

CREATE SEQUENCE SEQ_EMP_ID
INCREMENT BY 5
START WITH 223 ;

-- 사용방법
-- 1) 시퀀스명.NEXTVAL : 다음 시퀀스 번호
-- 2) 시퀀스명.CURRVAL : 현재 시퀀스 번호
-- NEXTVAL 미호출 시 CURRVAL에 값이 없으므로 호출불가 
-- > NEXTVAL 호출후 호출시 값이 저장되어있으므로 호출가능

SELECT SEQ_EMP_ID.NEXTVAL FROM DUAL;
SELECT SEQ_EMP_ID.CURRVAL FROM DUAL;
--228

SELECT * FROM EMPLOYEE_COPY4;

INSERT INTO EMPLOYEE_COPY4 VALUES
(SEQ_EMP_ID.NEXTVAL ,'홍길동');
INSERT INTO EMPLOYEE_COPY4 VALUES
(SEQ_EMP_ID.NEXTVAL ,'고길동');
INSERT INTO EMPLOYEE_COPY4 VALUES
(SEQ_EMP_ID.NEXTVAL ,'장길산');
-- 듀얼테이블로 다음 시퀀스 호출시 현재 시퀀스의 값이 변동 
-- >테이블생성에 시퀀스로 적용됨 
ROLLBACK;

-- 변경
/* ALTER SEQUENCE 시퀀스명
  [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
  [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27승, -1)
  [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26승)
  [CYCLE | NOCYCLE] -- 값 순환 여부 지정
  [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트
시퀀스 잘못 활용시
삭제 후 재생성
*/   
ALTER SEQUENCE SEQ_EMP_ID
INCREMENT BY 1;

SELECT SEQ_EMP_ID.NEXTVAL FROM DUAL;
SELECT SEQ_EMP_ID.CURRVAL FROM DUAL;

DROP SEQUENCE SEQ_EMP_ID;
DROP VIEW V_DCOPY2;
-------------------------------------------------------------------------------
/*  INDEX
    SELECT의 처리를 위해 색인을 생성하는 객체
    
    인덱스 내부 구조는 B*트리 형성
    
    --인덱스 생성 방법--

    [작성법]
    CREATE [UNIQUE] INDEX 인덱스명
    ON 테이블명 (컬럼명, 컬럼명, ... | 함수명, 함수계산식);
    
    -- 인덱스가 자동으로 생성되는 경우
    --> PK 또는 UNIQUE 제약조건이 설정되는 경우
    
*/
SELECT * FROM EMPLOYEE_COPY4;
CREATE INDEX INDEX_ECOPY4
ON EMPLOYEE_COPY4(EMP_NAME);

ALTER INDEX INDEX_ECOPY4 RENAME TO ECOPY4_NAME_INDEX;

/*
SELECT TABLE_NAME, INDEX_NAME, COLUMN_NAME
FROM ALL_IND_COLUMNS
WHERE TABLE_NAME = '테이블명'
*/
SELECT EMPLOYEE_COPY4, ECOPY4_NAME_INDEX, EMP_NAME
FROM ALL_IND_COLUMNS
WHERE TABLE_NAME = 'EMPLOYEE_COPY4';

SELECT * FROM EMPLOYEE_COPY4
WHERE EMP_NAME != '0';

CREATE TABLE TB_IDX_TEST(
    TEST_NO NUMBER PRIMARY KEY,
    TEST_ID VARCHAR2(20) NOT NULL
);

SELECT * FROM TB_IDX_TEST;

BEGIN
    FOR I IN 1..1000000
    LOOP
        INSERT INTO TB_IDX_TEST VALUES(I,'TEST'||I);
    END LOOP;
     
    COMMIT;
END;
/

SELECT COUNT(*) FROM TB_IDX_TEST;

SELECT * FROM TB_IDX_TEST
WHERE TEST_ID = 'TEST203748';

SELECT * FROM TB_IDX_TEST
WHERE TEST_NO = '80293';

DROP TABLE TB_IDX_TEST;
DROP INDEX ECOPY4_NAME_INDEX;

