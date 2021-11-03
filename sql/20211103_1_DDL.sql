--20211103
--테이블만들기

--DDL : 데이터 정의어, 객체생성, 수정, 삭제의 명령어

--테이블 생성 : create table
--테이블 수정 : alter table
--테이블 삭제 : drop table

--create table 테이블명(
--      컬럼이름 데이터_타입(size) 제약조건정의(컬럼 레벨정의),
--      ... ,
--      제약조건정의(테이블 수준정의)
--      );

--테이블생성
--부서테이블과 유사한 테이블을 정의
create table dept_test(
    deptno number (2,0),
    dname VARCHAR2(20),
    loc VARCHAR2(20)
);


--테이블삭제
drop table dept_test;

--사원테이블과 유사한구조의 사원번호, 사원이름, 급여 3개컬럼의 테이블 생성
desc emp;

create table emp01(
     EMPNO  NUMBER(4),    
     ENAME  VARCHAR2(10),
     sal NUMBER(7,2) 
);


--테이블복사
--서브쿼리를 이용 : 기존테이블의 구조와 튜플을 복사
--컬럼의 정의만 복사, 제약조건은 복사되지 않는다.
create table emp02
as 
select * from emp
;

select * from emp02; --복사한테이블 확인

--원하는 컬럼만 복사
create table emp03
as 
select empno, ename from emp;

desc emp03;

--원하는 데이터만 복사
create table emp04
as 
select * from emp where deptno =10; --where절에 원하는 데이터의 조건을 제시, 
                                    --원하는 행만 복사된다.

desc emp04;
select * from emp04;

--구조만 복사
select * from emp where 1=0;

create table emp05
as
select * from emp where 1=0;    --where절에 항상 거짓이 되는 조건을 넣으면
                                --로우를 얻을 수 없게 되어 구조만 복사가 된다.
desc emp05;
select * from emp05;


--테이블구조의 변경 : alter table
--컬럼추가 : alter table (테이블이름)add(컬럼정의);

desc emp01;
--EMP01 테이블에 문자 타입의 직급(JOB) 칼럼을 추가
alter table emp01
add(job VARCHAR2(9))
;
select * from emp01;

alter table emp01 
add(
    hiredate date,
    deptno number(2)
);

--컬럼수정 : alter table (테이블이름)modify(컬럼정의);
--직급(JOB) 칼럼을 최대 30글자까지 저장할 수 있게 변경
alter table emp01
modify (job VARCHAR2(30) not null)  --제약조건까지 걸었다,
;

--컬럼삭제 : alter table (테이블이름)drop column 컬럼이름
-- EMP01 테이블의 직급 칼럼을 삭제
alter table emp01
drop column job;

--테이블제거 : drop table (테이블이름);

--테이블 로우제거 : truncate table(테이블이름);
--emp02테이블의 모든 데이터를 삭제
select * from emp02;
truncate table emp02;    --삭제와 동시에 commit : 바로 물리적인 반역(저장)

--테이블 이름변경 : rename (구테이블이름) to (신테이블이름)
rename emp02 to test;


--제약조건확인
desc dept;
insert into dept (deptno, dname, loc) --실행 시 제약조건에 위배되었다는 내용이 출력된다.
       values(null,'test', 'SEOUL');


