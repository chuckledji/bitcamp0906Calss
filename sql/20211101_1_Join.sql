--2021.11.01


--<<JOIN>>
--스키마의 결합, 행은 집합의 한 연산.
--컬럼의 개수가 늘어난다! 행은 행X행의 결과가 생성
--의미있는 데이터를 만들기 위해서 컬럼의 비교 연산이 필요하다.

--Cross Join : 단순히 테이블을 붙이는 조인
--             컬럼을 붙이고, 행(데이터)은 집합의 합 연산(카티즌 곱) -> 전체 행 => (R1 행의 개수) 곱하기 (R2의 행의 개수)
--             emp테이블과 dept테이블의 join > 14*4 = 56개 행

--Cross Join문
--select * from 테이블1 * 테이블2 ...
select *
 from emp, dept;

select *
 from emp, dept
 order by dept.deptno; --(dept테이블에 있는 deptno를 사용한다는 뜻)
 
 
--Equi Join : 특정 컬럼의 값들을 비교해서 같은 결과 행만 추출
select *
 from emp, dept
where emp.deptno = dept.deptno; 

--SCOTT 사원의 부서이름 출력
select ename, emp.deptno, dept.dname
from emp, dept
where emp.deptno = dept.deptno 
      and ename = 'SCOTT';
      
--별칭부여하기
select ename, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno 
      and ename = 'SCOTT';

--NOT-Equi Join : 특정테이블      
select *
from salgrade;

select e.ename, e.sal, s.grade, s.losal, s.hisal
from emp e, salgrade s
where e.sal>=s.losal and e.sal <=s.hisal
order by e.empno
;

--Self Join : 나 자신을 참조해서 붙이는 조인
select *
from emp e, emp m;

select e.ename, e.mgr, m.empno, m. ename
from emp e, emp m
where e.mgr = m.empno
order by e.mgr
;
--결과의 행의 개수가 13 : (mgr = null)->무조건 false로 계산
--Outer Join
select e.ename, e.mgr, m.empno, m. ename
from emp e, emp m
where e.mgr = m.empno(+)    --표현하려는 쪽의 반대뽁에 (+)를 붙여준다. (우리는 null값을 표현하려고하는중)
order by e.mgr
;

select e.ename as eName, nvl(m.ename ,'관리자없음')as manager
from emp e, emp m
where e.mgr = m.empno(+)    --표현하려는 쪽의 반대뽁에 (+)를 붙여준다. (우리는 null값을 표현하려고하는중)
order by e.mgr
;


--ANSI Join
--(cross join)
select * 
from emp, dept;

select *
from emp cross join dept;

--ANSI Inner Join
--select * 
--from t1 inner t2'
--on 칼럼의 비교 조건(Join의 비교_
--SCOTT사원의 사원정보와 부서정보를 innder join을 이용해 출력

select *
from emp inner join dept
on emp.deptno = dept.deptno
where emp.ename = 'SCOTT'
;

select *
from emp join dept
on emp.deptno = dept.deptno
where emp.ename = 'SCOTT'
;

--using 이용 (공통 컬럼이 있을 경우)
select *
from emp e join dept d
-- on e.deptno = d.deptno;
using (deptno)
;
--natural join 이용 (공통 컬럼이 있을 경우)
select * 
--from emp inner join dept
--on emp.deptno = dept.deptno
from emp natural join dept
;

-- ANSI Outer Join : 한쪽테이블에 데이터가 존재하지 않아 출력되지 않을 때 사용
-- from R1 [Left | Right | Full] outer join R2
-- 사원이름과 상관의 이름을 출력
select e.ename, m.ename
from emp e left outer join emp m
on e.mgr = m.empno
;

--테이블 세개 조인
--주문내역(고객정보,  책의정보, 구매정보)
--주문고객의이름과 책의이름 구매날짜와 구매금액을 출력
select c.name, b.bookname, o.orderdate, o.saleprice
from book b, customer c, orders o
where o.custid = c.custid and o.bookid = b.bookid
;


