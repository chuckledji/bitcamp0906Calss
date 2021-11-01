desc dual;
select* from dual;
--함수 : 단일행 함수, 집합함수

--단일행 함수: 숫자, 문자, 날짜, 변환

--숫자함수
select abs(-15.5) from dual;         --
select FLOOR(35.7) "Floor"FROM DUAL; --정수만나온다
select round(15.693,1) from dual;    --반올림해서
select round(15.693,-1) from dual;   --10의자리로반올림
select trunc(15.6789) from dual;     --절삭
select trunc(15.6789,2) from dual; 
select trunc(15.6789,-1) from dual; 
select mod(10,2) from dual;          --나누고의 나머지

--문자함수
select LOWER('MR. SCOTT MCMILLAN') "Lowercase" from dual;
select ename , lower(ename) from emp;             --행단위로 lower함수 처리
select concat('저는', '손흥민입니다') from dual;    --두개의 문자를 붙여줌
select ename || 'is a ' from emp;
select concat('나의 이름은 ', ename) from emp;
select LPAD('Page', 15,'*') from dual;          --***********Page
select RPAD('Page', 15,'*') from dual;          --Page***********
select rpad('001111-3',14, '*') from dual;
select SUBSTR('ABCDEFG',3,4) from dual;
select substr(hiredate, 1, 2) from emp;

select rpad(substr('001212-3001234',1,8),14,'*') from dual;
select rpad(subst(name, 1,2),5,'*') from customer;
select * from customer;

select ltrim('     =from=     ') from dual;     --왼쪽여백자름
select rtrim('     =from=     ') from dual;     --오른쪽여백자름

select trim('+' from'+++++from+++++') as a from dual;--특정문자를 전부 자름
select trim(' ' from'    +++++from+++++') as a from dual;

select REPLACE('JACK and JUE','J','BL') from dual;
select replace('000-0000-0000', '-', '') from dual;


--날짜함수
select sysdate from dual;                  --현재날짜
select sysdate+10 from dual;               -- +10일
select add_months(sysdate , 10) from dual; --월을 더해줌
select last_day(sysdate) from dual;        --해당 월의 마지막일자


--변환함수
--날짜 > 문자 to_char(원본, 패턴)


--숫자 > 문자 to_char(원본, 패턴)
select to_char(sysdate,'YYYY.MM day dy AM PM HH HH24:MI:ss')from dual;
--2021.10.29 13:00
select to_char(sysdate, 'YYYY.MM.DD HH24:MI') from dual;
select hiredate, to_char(hiredate, 'YYYY.MM.DD')from emp;

select to_char(100000, '0000000')from dual;
select to_char(100000000, '9999999')from dual; --오류
select to_char(1000000.123, '9,999,999.999')from dual; 

select sal, to_char(sal*1200, 'L9,999,999') from emp;


--문자 > 날짜 to_date(원본, 패턴)
select to_date('2021.10.29.', 'yyyy.MM.DD.') from dual;

-- 2021.01.01~오늘
select trunc(sysdate - to_date('2021.01.01','YYYY-MM_DD'))from dual;

--문자 > 숫자 to_number(원본, 패턴)
select to_number('100,000','9,999,999')+100000 from dual;


--switch case와 유사한 decode함수
--emp테이블에서 사원이름, 부서번호 부서이름출ㄺ
select * from dept;

select ename, deptno,
    decode(deptno,
        10,'ACCONT',
        20, 'RESEARCH',
        30, 'SALSES',
        40, 'OPERATION'
        ) as dename
from emp;

--직급에따라 급여 인상
-- 'ANALYST' 5%
--'SALESMAN 10
--MANAGER 15
--CLERK 20
select ename, job, sal,
    decode(job, 
        'ANALYST' , sal*1.05,
        'SALESMAN', sal*1.1,
        'MANAGER', sal*1.15,
        'CLERK', sal *1.2
    )as upsal
from emp;


--case when then : if else if 와 유사하다 > 조건식을 = 이외의 비교 연산을 할 수 있다.
select ename, sal,
    case 
        when sal >= 3000 then sal*1.3
        when sal < 3000 then sal*1.5
    end as upsal  
from emp;

------------------------------------------
--집함함수(그룹함수)
--하나의 행의 컬럼이 대상이 아니고, 행 그룹의 컬럼들(집합)이 대상이다
----------------------------------------
select
    to_char(sum(sal)*1200, 'L999,999,999') as "월 급여 총액",
    to_char(round(avg(sal)*1200), 'L999,999,999') as "월급여 평균",
    count(*)as "총사원 수",          --전체 행의 개수반환
    count(comm) as "커미션 등록수",
    sum(comm) as "커미션 합",        --null은 집계에 반영되지 않는다.
    avg(comm) as"커미션평균",
    max(sal) as"가장 높은 급여",
    min(sal) as"가장 낮은 급여"
from emp
;

--상원들의 업무의 개수
select count(distinct job) from emp;

--------------------------------------------------------
select sum( sal)
from emp
where deptno=10
;
select sum( sal)
from emp
where deptno=20
;
select sum( sal)
from emp
where deptno=30
;

select * from emp order by deptno;

--group by  특정 멀럼으로 그룹핑 -> 그룹내의 평균이나 합과 같은 집합 함수를 이용할 수 있다.
-- 부서번호를 기준으로 그룹핑 -> 급여의 총합, 평균, 최대, 최소, 사원의수, 커미션평균, 커미션총합
select deptno, 
    count(*) as "사원수",
    sum(sal) as"급여총합",
    trunc(avg(sal))as"급여평균",
    max(sal) as"최대급여",
    min(sal) as"최소급여",
    count(*) as"커미션대상자수",
    nvl(sum(comm),0) as"커미션총합",
    nvl(avg(comm),0) as"커미션평균"
from emp
where deptno != 20
group by deptno
--having avg(sal) >=2000
having max(sal) > 2900
order by deptno
;