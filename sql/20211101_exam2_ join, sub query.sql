--2021.11.01_exam2_ join & sub query


--2 마당서점의 운영자와 경영자가 요구하는다음질문에대해SQL 문을작성하시오.
--(8) 주문하지않은 고객의이름(부속질의사용)
--내부쿼리 : (주문하지않은)orders에 없고 customer에 있는 custid
--외부쿼리 : custid로 검색한 고객의이름
select orders.custid from orders where orders.custid = customer.custid;




--(9) 주문금액의총액과 주문의평균금액
select sum(saleprice)as"total", avg(saleprice)as"avgsalePrice"
from orders;

--(10) 고객의이름과 고객별구매액
select custid,
        (select name from customer c where o.custid=c.custid)as name, 
        sum(saleprice)
from orders o
group by custid
;

--(11) 고객의이름과 고객이구매한도서목록
select c.name, b.bookname 
from book b, orders o, customer c
where b.bookid = o.bookid 
      and c.custid = o.custid
order by c.name
;

--(12) 도서의가격(Book 테이블)과 판매가격(Orders 테이블)의차이가가장많은 주문
--select *
--from orders o, book b
--where (b.price - o.saleprice) = max(b.price - o.saleprice)
--;

--(13) 도서의판매액평균보다 자신의구매액평균이 더높은고객의이름
select c.name
from customer c, orders o
where  avg(o.saleprice)<(select o.saleprice from orders where c.custid = o.custid)
;








