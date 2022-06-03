--DDL(DATA DEFINITION LANGUAGE) 
-- CREATE ALTER DROP

-- ALTER
-- 컬럼 - 추가 수정 제거 이름변경
-- 제약조건 - 추가 제거 이름변경

-- 테이블 수정
-- ALTER TABLE 테이블명 ADD||MODIFY||DROP 수정할 내용

-------------------------------------------------------------------------------
-- 제약조건 추가
-- ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건이름] 제약조건(컬럼) [REFERENCES 테이블(컬럼)]

-- 제약조건 삭제
-- ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건이름;

CREATE TABLE DEPT_COPY AS
SELECT * FROM DEPARTMENT;

SELECT * FROM ALL_CONSTRAINTS
WHERE TABLE_NAME = 'DEPT_COPY';

-- DEPT_COPY PK 추가
ALTER TABLE DEPT_COPY ADD CONSTRAINT PK_DEPT_CODE PRIMARY KEY (DEPT_ID);

-- DEPT_COPY TITLE UNIQUE
ALTER TABLE DEPT_COPY ADD CONSTRAINT DEPT_TITLE_U UNIQUE(DEPT_TITLE);

-- DEPT_COPY CHECK
ALTER TABLE DEPT_COPY ADD CONSTRAINT LOCATION_ID_CHK CHECK(LOCATION_ID IN ('L1','L2','L3','L4','L5'));

-- DEPT_COPY NOT NULL
ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE NOT NULL;

----------------------------------------------------------------

SELECT * FROM ALL_CONSTRAINTS
WHERE TABLE_NAME = 'DEPT_COPY';

--DROP
ALTER TABLE DEPT_COPY DROP CONSTRAINT DEPT_TITLE_U;

--ALTER TABLE DEPT_COPY DROP CONSTRAINT SYS_C008409;
ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE CONSTRAINT SYS_C008410 NULL;

ALTER TABLE DEPT_COPY DROP CONSTRAINT LOCATION_ID_CHK;

ALTER TABLE DPET_COPY DROP CONSTRAINT PK_DEPT_CODE;

--------------------------------------------------------------------------------
-- 컬럼 추가/수정/삭제
SELECT * FROM DEPT_COPY;

-- 추가
-- ALTER TALBE 테이블명 ADD(컬럼명 데이터타입 [DEFAULT 값]);
ALTER TABLE DEPT_COPY ADD (CNAME VARCHAR2(20));
ALTER TABLE DEPT_COPY ADD (LNAME VARCHAR2(30) DEFAULT '한국');
ALTER TABLE DEPT_COPY ADD (CNAME2 CHAR(9) DEFAULT '고구려');

-- 수정
-- ALTER TABLE 테이블명 MODIFY 컬럼명 데이터타입;
-- ALTER TABLE 테이블명 MODIFY 컬럼명 DEFAULT 값;
-- * 데이터 타입 수정 시 컬럼에 저장된 데이터 크기 보다 커야함 
ALTER TABLE DEPT_COPY MODIFY DEPT_ID VARCHAR2(3);
ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE VARCHAR2(10);
-- 일부값이 10바이트 이상이라 수정불가
ALTER TABLE DEPT_COPY MODIFY LNAME DEFAULT '대한민국';
-- 기본값 수정 했어도 기존값은 유지됨
UPDATE DEPT_COPY SET LNAME = DEFAULT;
ROLLBACK;
COMMIT;
SELECT * FROM DEPT_COPY;

-- 삭제
-- ALTER TABLE 테이블명 DROP 컬럼명;
-- ALTER TABLE 테이블명 DROP COLUMN (컬럼명);
-- * 최소 한 개 이상의 열을 갖고 있는 테이블만 가능
ALTER TABLE DEPT_COPY DROP COLUMN CNAME2;
ALTER TABLE DEPT_COPY DROP (CNAME);
ALTER TABLE DEPT_COPY DROP (LNAME);

SELECT * FROM DEPT_COPY;

ALTER TABLE DEPT_COPY DROP COLUMN DEPT_TITLE;
ALTER TABLE DEPT_COPY DROP COLUMN LOCATION_ID;
ALTER TABLE DEPT_COPY DROP COLUMN DEPT_ID;

CREATE TABLE TB1(
    TB1_PK NUMBER PRIMARY KEY,
    TB1_COL NUMBER
    );
    
CREATE TABLE TB2(
    TB2_PK NUMBER PRIMARY KEY,
    TB2_COL NUMBER REFERENCES TB1
    );

DROP TABLE DEPT_COPY;

DROP TABLE TB2;
DROP TABLE TB1;

-- CASCADE CONSTRAINT 사용
DROP TABLE TB1 CASCADE CONSTRAINTS;
DROP TABLE TB2 ;
-------------------------------------------------------------------------------

-- 4. 컬럼 제약조건 테이블 이름 변경
CREATE TABLE DEPT_COPY
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY;

ALTER TABLE DEPT_COPY ADD CONSTRAINT FK_DCOPY PRIMARY KEY (DEPT_ID); -- 프라이머리 키 생성

SELECT * FROM ALL_CONSTRAINTS
WHERE TABLE_NAME = 'DEPT_COPY'; -- SYS_C008423

ALTER TABLE DEPT_COPY DROP CONSTRAINT SYS_C008423;

ALTER TABLE DEPT_COPY RENAME COLUMN DEPT_TITLE TO DEPT_NAME; -- 열 이름 바꾸기
SELECT * FROM DEPT_COPY;

ALTER TABLE DEPT_COPY RENAME CONSTRAINT FK_DCOPY TO PK_DCOPY;

ALTER TABLE DEPT_COPY RENAME TO DELETE_SOON;

SELECT * FROM DELETE_SOON;

DROP TABLE DELETE_SOON;