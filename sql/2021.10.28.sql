--2021.10.28

--로그인한 사용자가 보유하고 있는 테이블 정보를 가지고 있는 메타데이터 테이블
select * from tab;

--describe : 테이블의 구조 확인
desc dept;

select * from emp;
select * from dept;
select loc, deptno, dname from dept;
select * from book;
select * from customer;
select * from orders;
select orderid, custid ,saleprice from orders;


--사칙연산 : Select 구문에서 컬럼의 산술연산이 가능
--결과- sal과 sal+100의 컬럼이 생성
select sal, sal+100, sal-100, sal*12, sal/2
from emp;
select * from emp;
--우리 회사의 사원들의 이름과 월 급여 연봉을 리스트로 출력
select ename, sal, sal*12
from emp
;

--null : 아직 정해지지 않은 값(있는것도 아니고 없는 것도 아니다). 연산의 결과 = null
--연봉에 + comm, 주의! comm의 값 중에는 null이 존재
select ename, sal, sal*12, comm, sal*12+comm
from emp
;

--nvl함수 : null값을 치환
--nvl(컬럼명, 치환할 데이터) => 컬럼의 값 중, null 값은 치환 값으로 출력
select comm, nvl(comm,100)
from emp
;
--nvl함수를 이용해서 결과 값 도출
select ename, sal, sal*12, comm, sal*12+comm, 
       comm, nvl(comm,0), sal*12+nvl(comm,0)
from emp
;

--별칭쓰기 as : 별칭을 이용해서 컬럼이름사용 ""사용
select ename as"사원이름", sal as"월급여", sal*12+nvl(comm,0) as"연봉"
from emp
;
select ename 이름, sal sal, sal*12+nvl(comm,0) salOfYear
from emp
;

--||연산자 : 문자열을 연결
select ename || ' is a ' || job msg
from emp
;

--distinct : 중복되는 것을 한번씩만 출력
--사원들이 소속된 부서번호출력
select distinct deptno
from emp;
--중복제거
select distinct publisher 
from book;
--2컬럼의 중복제거
select distinct deptno, job
from emp;

----------------------------------------------------------

select *            --출력하고자 하는 컬럼
from emp            --출력하고자 하는 테이블
WHERE sal >=3000    --출력하고자 하는 조건 : 비교연산 또는 논리연산 (행을 찾을 조건)
;

--비교연산자
--10번 부서의 소속된  ->행을 검색할 조건
--사원의 리스트출력
select*
from emp
where deptno=10
;

--문자열비교 : 문자에''사용
--이름이 FORD인 사원의 : 행
--사원번호(EMPNO)과 사원이름(ENAME)과 급여(SAL)을 출력 : 컬럼
select empno, ename, sal
from emp
where ename='FORD'
;
--키워드(대소문자구별X)
--데이터값(대소문자구별O)

--날짜비교 : 날짜에''사용
--82년 이후 입사자
select*
from emp
where hiredate >= '82/01/01'
;

--AND연산자
--10번 부서 소속인 사원들 중에서    =AND
--직급이 MANAGER인 사람을 검색하여 
--사원명, 부서번호, 직급을 출력
select ename, deptno, job
from emp
where deptno=10 and job='MANAGER'
;

--OR연산자
--10번 부서에 소속된 사원이거나    =OR
--직급이 MANAGER인 사람을 검색하여 
--사원명, 부서번호, 직급을 출력
select ename, deptno, job
from emp
where deptno=10 or job='MANAGER'
;

--NOT연산자
--부서번호가 10번이 아닌 사원의    =NOT
--사원이름, 부서번호, 직급을 출력
select ename, deptno, job
from emp
where not deptno=10
--where deptno<>10
--where deptno!=10
;

--BETWEEN연산자 : 이상,이하
--2000에서 3000사이의 급여를 받는 사원 ->조건
select *
from emp
where sal between 2000 and 3000
--where sal >= 2000 and sal <= 3000
;

--1987년에 입사한 사원을 출력
select*
from emp
where hiredate between '87/01/01' and '87/12/31'
;

--IN연산자
--커미션이 300 이거나 500 이거나 1400 인 사원을 검색 =OR->IN연산자사용
select*
from emp
where comm in(300,500,1400)
--where comm=300 or comm=500 or comm=1400
;

--LIKE 패턴검색 : %사용
--F로 시작하는 이름을 가진 사원 검색
select *
FROM emp
where ename like 'F%'
;
--A를 포함하는 이름을 가진 사원 검색
select*
from emp
where ename like '%A%'
;
--N으로 끝나는 이름을 가진 사원 검색
select*
from emp
where ename like '%N'
;

--LIKE 패턴검색 : _사용
--이름에 두번쨰 글자가 A인 사원 검색
select*
from emp
where ename like '_A%'
;
--이름에 세번쨰 글자가 A인 사원 검색
--where ename like '__A%'

--NOT LIKE연산자 : 포함하지않는
select*
from emp
where ename NOT like '%A%'
;

--IS NULL / IS NOT NULL
--커미션을 받지않는 사원 출력
select*
from emp
where comm is null
;
--커미션을 받는 사원 출력
select*
from emp
where comm is not null and comm != 0
;

--정렬 : order by절
--order by 컬럼명 ASC / DESC
--급여 컬럼을 기준으로 오름차순으로 정렬
select *
from emp
order by sal asc
;
--사원이름순
select *
from emp
order by ename desc
;
--입사일순
select *
from emp
order by hiredate, sal desc
;