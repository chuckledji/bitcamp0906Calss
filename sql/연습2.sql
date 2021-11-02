--practice

--43. 사원 번호가 7788인 사원과 
--    담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.
select ename, job
from emp
where job = (select job from emp where empno =7788); 


--44. 사원번호가 7499인 사원보다 
--    급여가 많은 사원을 표시하시오. 사원이름과 감당 업무
select ename, job
from emp
where sal > (select sal from emp where empno=7499);

--45. 최소급여를 받는 사원의 
--    이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
select ename, job, sal
from emp
where sal <= all(select sal from emp);  --모든 급여보다 작거나 같다면 최소

--46. 평균급여가 가장 적은 직급의 
--    직급 이름과 직급의 평균을 구하시오.
select avg(sal)
from emp
group by job;

select min(avg)
from (select avg(sal)as avg
    from emp
    group by job)
 ;

select job, avg(sal)
from emp
group by job
having avg(sal) = (
    select min(avg)
    from (
        select avg(sal) as avg
        from emp
        group by job
        )        
    )
;

--47. 각 부서의 최소 급여를 받는 
--    사원의 이름, 급여, 부서번호를 표시하시오.

--각 부서의 최소 급여
select min(sal) from emp where deptno = 10;

select ename, sal, deptno
from emp e
where e.sal = (select min(sal) from emp e2 where e.deptno =e2.deptno);


--48. 담당업무가 ANALYST 인 사원보다
--    급여가 적으면서 업무가 ANALYST가 아닌 
--    사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오.

--담당업무'ANALYST'인 사원의 급여
select sal from emp where job = 'ANALYST';

select empno, ename, job, sal
from emp 
where sal < all(select sal from emp where job = 'ANALYST')
      and job<>'ANALYST'
order by empno;

--49. 부하직원이 없는 사원의 이름을 표시하시오.

--매니저번호가 = 자신의사원번호
select ename
from emp e
where e.empno <> (select m.mgr from emp);