--20211103 DML



--DML : 입력, 수정, 삭제

--테스트 테이블 생성(구조만)
drop table dept01;

create table dept01
as 
select * from dept where 1=0;


--데이터의 입력 : insert into (테이블명) (컬럼명,...) values (data,...);
--입력하고자하는 컬럼의 개수와 입력데이터의 개수는 일치
--             컬럼의 도메인, 입력데이터의 타입이 일치
--             컬럼의 제약중에 not null인 컬럼 생략 X
insert into dept01 (deptno, dname, loc) 
             values(10, 'DEV', 'SEOUL'); --값의 순서일치, 타입일치, 개수일치

insert into dept01 (dname, loc) 
             values('DEV', 'SEOUL');    --not null인 컬럼 생략 =>오류
             
 insert into dept01                     --순서대로 모든값 입력할경우
             values(10,'DEV', 'SEOUL'); --컬럼명 생략하고 값만 넣어도 가능

insert into dept01 (deptno, dname, loc) 
             values(10, 'DEV', null);   --명시적으로 null값을 넣을경우
             
insert into dept01 (deptno, dname, loc) 
             values(10, 'DEV', '');     --''공백으로 null값을 넣는다.
             
insert into dept01 (dname, loc) 
             values('DEV', 'SEOUL');    --암시적으로 (컬럼을)생략하여 null값을 나타내는 경우
             
select * from dept01;


--------------------------------------------------------------------------
--서브쿼리를 이용한 데이터입력

drop table dept02;

create table dept02 
as 
select * from dept where 1=2;

select * from dept02;

--서브쿼리로 데이터를 입력
insert into dept02 select * from dept;  
insert into dept02 select * from dept02;  

