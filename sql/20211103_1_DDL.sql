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


------------------------------------------------------------------------

--제약조건확인
desc dept;
insert into dept (deptno, dname, loc) --실행 시 제약조건에 위배되었다는 내용이 출력된다.
       values(null,'test', 'SEOUL');


--제약사항의 정의 : 컬럼레벨과 테이블레벨에서 정의 가능
--컬럼레벨 : 컬럼정의 바로 뒤에 제약사항을 정의
--사원 테이블과 유사한 구조의 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된
--EMP02 테이블을 생성하되
--EMPNO와 EMPNAME 컬럼에 NOT NULL 제약 조건 설정
drop table emp02;
create table emp02(
    empno number(4) not null unique,
    ename VARCHAR2(20) not null,
    job VARCHAR(20),
    deptno number(2)    
);
desc emp02;
insert into emp02 values (10,'test',null,null); --empno와 ename은 null허용X
select * from emp02;

--사원 테이블과 유사한 구조의 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 
--EMP03 테이블을 생성하되 사원번호를 유일키로 지정합시다.
drop table emp03;
create table emp03(
        empno number(4) constraint uq_emp03_empno unique , --emp03테이블의 empno컬럼의 제약조건이름
        ename VARCHAR(20) not null,
        job VARCHAR(9),
        deptno number(3)
        );
select * from emp03;
insert into emp03 values (1000,'test','manager',40);
insert into emp03 values (1000,'test2','manager',40);


--------------------------------------------------------------------------
--기본키 제약조건
drop table emp04;
create table emp04(
        empno number(4) constraint emp04_empno_pk primary key , --constraint emp04_empno_pk)생략가능
        ename VARCHAR(20) not null,
        job VARCHAR(9),
        deptno number(3)
        );
desc emp04;
select * from emp04;
insert into emp04 values (1000,'test','manager',40);
insert into emp04 values (1000,'test2','manager',40); --pk설정으로 unique제약조건실행
insert into emp04 values (null,'test2','manager',40); --pk설정으로 null제약조건실행


-------------------------------------------------------------------------
--참조무결성
--외래키 제약조건
drop table emp05;
create table emp05(
        empno number(4) constraint emp05_empno_pk primary key , 
        ename VARCHAR(20) not null,
        job VARCHAR(9),
        deptno number(3) constraint emp05_deptno_fk REFERENCES dept(deptno) --dept테이블의 deptno를 참조한다는 외래키이름
        );
desc emp05;
select * from emp05;
insert into emp05 values (1000,'test','manager',20);
insert into emp05 values (1000,'test2','manager',40); 
insert into emp05 values (4000,'test2','manager',60); --dept테이블의 deptno에 없는 부서번호로 오류


--------------------------------------------------------------------------
--체크제약
drop table emp06;
create table emp06(
        empno number(4) constraint emp06_empno_pk primary key , 
        ename VARCHAR(20) not null,
        job VARCHAR(9),
        --sal number(7,2) constraint emp06_sal_ck check(sal >= 500 and sal <= 5000),
        sal number(7,2) constraint emp06_sal_ck check(sal between 500 and 5000),
        --gender char(1) constraint emp06_gender_ck check(gender = 'M' or gender ='F'),
        gender char(1) constraint emp06_gender_ck check(gender in('M','F')),    --체크제약조건
        deptno number(3) constraint emp06_deptno_fk REFERENCES dept(deptno) 
        );
desc emp06;
select * from emp06;
insert into emp06 values (1000,'test','manager',3000,'M',20);
insert into emp06 values (1000,'test','manager',200,'M',20); --salck오류
insert into emp06 values (1000,'test','manager',3000,'T',20); --genderck오류


--------------------------------------------------------------------------
--default 디폴트
drop table dept01;

create table dept01(
    deptno number(2),
    dname varchar2(20),
    loc VARCHAR(20) default 'SEOUL',    --아무값도 넣지 않을때 자동으로 나오는 값을 설정한다.
    regdate date default sysdate
);
select * from dept01;
insert into dept01(deptno,dname) values (10, 'test'); --이렇게 삽입도 가능
insert into dept01(deptno,dname, loc) values (10, 'test','서울');
insert into dept01(deptno,dname, loc, regate) values (10, 'test','서울', null);
----------------------------------------------------------------------------
--테이블레벨에서 제약조건
--컬럼 정의후 제약조건정의
--컬럼레벨에서 해야하는 것 -> not null, default
drop table emp07;
create table emp07(
    empno number(4), --기본키
    ename VARCHAR(20) not null,
    sal number(7,2) check (sal between 300 and 9000),
    deptno number(2),
    ------------------
    --제약조건정의
    constraint emp07_empno_pk primary key( empno),
    constraint emp07_empno_fk foreign key (deptno) references dept(deptno)
    );
