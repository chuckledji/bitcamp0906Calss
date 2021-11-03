--20211103_exam
--DDL생성하기

create table phoneInfo_basic (
    idx number(6) primary key,
    fr_name VARCHAR2(20) not null,
    fr_phonenumber VARCHAR2(20) not null,
    fr_email VARCHAR2(20),
    fr_address VARCHAR2(20),
    fr_regdate date default sysdate);
 
desc phoneInfo_basic;
select * from phoneInfo_basic;
drop table phoneInfo_basic;    
  
  
  
create table phoneInfo_univ (
    idx number(6) primary key,
    fr_u_major VARCHAR2(20) default 'N' not null,
    fr_u_year NUMBER(1) default 1 not null constraint phU_year_ck check(fr_u_year between 1 and 4),
    fr_ref NUMBER(6) not null constraint phU_ref_fk REFERENCES phoneInfo_basic(idx)
);
desc phoneInfo_univ;
select * from phoneInfo_univ;
drop table phoneInfo_univ;
    
    
    
create table phoneInfo_com(
    idx NUMBER(6) PRIMARY KEY,
    fr_c_company VARCHAR2(20) default 'N' not null,
    fr_ref NUMBER(6) not null constraint phC_ref_fk REFERENCES phoneInfo_basic(idx)
);
desc phoneInfo_com;  
select * from phoneInfo_com;
drop table phoneInfo_com;