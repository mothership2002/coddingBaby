DROP TABLE TB_CLASS;
DROP TABLE TB_DEPARTMENT;

ALTER TABLE TB_CLASS DROP COLUMN PREATTENDING_CLASS_NO;

COMMIT;

CREATE TABLE TB_STUDENTS(
    STUDENT_NO CHAR(7) PRIMARY KEY,
    STUDENT_NAME VARCHAR2(20) NOT NULL,
    STUDENT_SSN CHAR(14) NOT NULL,
    STUDENT_PHN VARCHAR2(14) NOT NULL,
    STUDENT_EMAIL VARCHAR2(30),
    STUDENT_DEPT VARCHAR2(5),
    STUDENT_ADR VARCHAR2(100),
    STUDENT_GRD CHAR(1)
    );
    
ALTER TABLE TB_STUDENTS MODIFY (STUDENT_DEPT VARCHAR2(10));
ALTER TABLE TB_STUDENTS DROP COLUMN STUDENT_DEPT;

CREATE TABLE TB_PROFESSOR(
    PRO_NO VARCHAR2(4) NOT NULL,
    PRO_NAME VARCHAR2(20) NOT NULL,
    PRO_SSN CHAR(14) NOT NULL,
    PRO_PHN VARCHAR2(14) NOT NULL,
    PRO_EMAIL VARCHAR2(30) NOT NULL,
    PRO_DEPT VARCHAR2(5) NOT NULL
);
ALTER TABLE TB_PROFESSOR MODIFY (PRO_DEPT VARCHAR2(10));
ALTER TABLE TB_DEPARTMENT MODIFY (DEPARTMENT_NO NUMBER(3));
ALTER TABLE TB_STUDENTS ADD (ADMISSION DATE NOT NULL);
ALTER TABLE TB_PROFESSOR ADD CONSTRAINT PK_PRO_NO PRIMARY KEY(PRO_NO);

CREATE TABLE TB_GRADE(
    CLASS_NO VARCHAR2(10) REFERENCES TB_CLASS (CLASS_NO),
    CLS_STDNO CHAR(7) REFERENCES TB_STUDENTS (STUDENT_NO),    
    CLS_GRADE NUMBER(2,1) NOT NULL
);

COMMIT;
--
    
select * from all_constraints
where table_name = 'tb_department';