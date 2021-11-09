--NCS SQL활용

--1)
--전화번호 부(테이블이름 : Contact)

--기본정보(not null)
--대리키 : 일련번호 -> pidx기본키로 설정
--이름, 전화번호, 주소, 이메일
--주소값과 이메일은 입력이 없을 때 기본값입력

--친구의 타입(카테고리): univ, com, cafe세가지 값만 저장가능

--선택정보
--전공,학년
--회사이름,부서이름,직급
--모임이름,닉네임


CREATE TABLE Contact(
    idx number(6) constraint contact_idx_PK primary key,
    c_name VARCHAR2(20) not null,
    c_phonenumber VARCHAR2(20) not null,
    c_address VARCHAR2(20) default 'N' not null,
    c_email VARCHAR2(20) default 'N' not null
);

create table Contact_Univ(
    idx number(6),
    c_u_major varchar2(20),
    c_u_year number(1) default 1 not null check(c_u_year between 1 and 4),
    c_u_ref number(6) not null,
    constraint univ_ref_FK FOREIGN KEY(c_u_ref) REFERENCES Contact (idx) 
    );
    
    
create table Contact_com(
    idx number(6),
    c_c_compname varchar2(20),
    c_c_deptname varchar2(20),
    c_c_job varchar2(20),
    c_c_ref number(6) not null,
    constraint com_ref_FK FOREIGN KEY(c_c_ref) REFERENCES Contact (idx) );

create table Contact_cafe(
    c_cf_groupname varchar2(20),
    c_cf_nickname varchar2(20),
    c_cf_ref number(6) not null,
    constraint cafe_ref_FK FOREIGN KEY(c_cf_ref) REFERENCES Contact (idx) );
    
    
--2.) DEPT테이블에 데이터를 삽입하는 SQL을 작성하시오. 입력데이터는 임의로 작성하시오.
insert into dept values( 70, 'exam', 'SEOUL');

--3.)dept테이블에 위에서 삽입한 데이터의 dname, loc데이터를 변경하는 sql을 작성
update dept 
set dname = 'exam2', loc='INCHEON'
where deptno = 70;

select * from dept;

--4.)dept테이블에 위에서 삽입한 데이터를 deotno컬럼의 값을 기반으로 삭제하는 sql
delete from dept where deptno = 70;
select * from dept;

--5.)사용자가 보유한 테이블목록을 확인하는 sql
select * from tab;

--6.)emp테이블의 구조를 확인하는 sql
desc emp;

--7.)사용자가 정의한 제약조건들을 확인하는 sql
----아래 요구사항에 맞도록 고급sql문작성
--7.1-emp테이블의 ename컬럼에 인덱스를 생성하는 sql / 인덱스이름:emp_index
create index emp_index on emp(ename);


--7.2-emp테이블과 dept테이블을 조인하는 sql 기반 view객체생성 / view이름: emp_view
drop view emp_view;
create or replace view emp_view
as 
select * from emp natural join dept;

select* from emp_view;
--7.3-emp테이블에서 모든 사원의 부서번호를 이름이 'SCOTT'인 사원의 부서번호롤 변경하는 sql
update emp 
set deptno = (select deptno from emp where ename = 'SCOTT');

