/*
    관리자 계정 : 데이터베이스의 생성과 관리를 담당
                EX) SYS,SYSTEM
                
    사용자 계정 : 질의 갱신 보고서 작성 등 작업 수행 계정

-- DCL : 권한관련 언어
GRANT : 권한 부여
REVOKE : 권한 회수

1) 시스템 권한 : BD접속, 객체 생성 권한

CRETAE SESSION   : 데이터베이스 접속 권한
CREATE TABLE     : 테이블 생성 권한
CREATE VIEW      : 뷰 생성 권한
CREATE SEQUENCE  : 시퀀스 생성 권한
CREATE PROCEDURE : 함수(프로시져) 생성 권한
CREATE USER      : 사용자(계정) 생성 권한
DROP USER        : 사용자(계정) 삭제 권한
DROP ANY TABLE   : 임의 테이블 삭제 권한

2) 객체 권한 : 특정 객체를 조작

SELECT TABLE, VIEW, SEQUENCE
INSERT TABLE, VIEW
UPDATE TABLE, VIEW
DELETE TABLE, VIEW
ALTER TABLE, SEQUENCE
REFERENCES TABLE
INDEX TABLE
EXECUTE PROCEDURE

*/
--0. 형식변환
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

--1. 관리자 계정통한 사용자 계정 생성
CREATE USER ldh_sample IDENTIFIED BY sample1234;
-- ora-01045 : CREATE SESSION 을 갖지 않아 로그인 디나이

--2. 권한 부여
GRANT CREATE SESSION TO ldh_sample;

--3. 샘플로 접속
CREATE TABLE TB_TEST(
    TEST_PK NUMBER PRIMARY KEY,
    TEST_CONTENT VARCHAR2(100)
);
--ORA-01031: 권한이 불충분합니다
--4. 권한 부여 --크리에이트 테이블은 리소스에 포함되어잇음
GRANT CREATE TABLE TO ldh_sample;
--4-1 공간할당
ALTER USER ldh_sample DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;
--5. 테이블 생성
CREATE TABLE TB_TEST(
    TEST_PK NUMBER PRIMARY KEY,
    TEST_CONTENT VARCHAR2(100)
);
------------------------------------------------------------------------------
--ROLE : 권한 묶음
--CONNECT : DB 접속 권한
SELECT * FROM ROLE_SYS_PRIVS
WHERE ROLE = 'CONNECT';
-- 관리자 계정으로
--RESOURCE : DB 사용을 위한 객체 생성 권한 
SELECT * FROM ROLE_SYS_PRIVS
WHERE ROLE = 'RESOURCE';

GRANT connect,RESOURCE TO ldh_sample;

-------------------------------------------------------------------------------
-- 객체 권환
-- EMPLOYEE 조회 권한 부여
SELECT * FROM EMPLOYEE;
SELECT * FROM LDH.EMPLOYEE;
-- 테이블 없음
-- 타계정에 조회 권한 부여
GRANT SELECT ON EMPLOYEE TO ldh_sample;
-- 권한 확인
SELECT * FROM EMPLOYEE; --EMPLOYEE 테이블이 없기 때문
SELECT * FROM LDH.EMPLOYEE;
-- 권한 회수
REVOKE SELECT ON EMPLOYEE FROM ldh_sample;
