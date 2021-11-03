--마당문제
--20211102
--join & sub query


--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.

--(5) 박지성이구매한도서의 출판사수
--구매자>박지성>박지성의custid >orders에서 찾음 >해당하는 custid가 구매한 bookid
--orders의 bookid와 book의 bookid일치하면 publisher구함
select bookid
from customer c, orders o
where c.custid = o.custid
      and name = '박지성';

select count(publisher)
from book
where bookid in (select bookid
                from customer c, orders o
                where c.custid = o.custid
                and name = '박지성');
                
select count(publisher)
from customer c, book b, orders o
where o.custid = c.custid and b.bookid=o.bookid and c.name ='박지성';


-- (6) 박지성이 구매한 도서의 
--  이름, 가격, 정가와 판매가격의 차이
select b.bookname, b.price, b.price-o.saleprice as pricegap
from book b, orders o, customer c
where c.name = '박지성' and c.custid=o.custid and b.bookid = o.bookid
;

select b.bookname, b.price, b.price-o.saleprice as pricegap
from book b, orders o
where b.bookid = o.bookid and o.custid = (select custid from customer where name='박지성');


-- (7) 박지성이 구매하지 않은 도서의 이름
-- 도서의 이름 출력
-- 박지성이 구매한 도서의 id
select bookid 
from orders o, customer c
where o.custid = c.custid and c.name ='박지성';

select bookname from book
where bookid not in (select bookid 
                     from orders o, customer c
                     where o.custid = c.custid and c.name ='박지성');



-- 2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.

-- (8) 주문하지 않은 고객의 이름(부속질의사용)
select name from customer where custid not in (select custid from orders);

select name
from orders o, customer c
where o.custid(+)=c.custid   --나타내려고하는 쪽의 반대쪽
      and o.orderid is null; --주문아이디가 빈


--(9) 주문금액의 총액과 주문의 평균금액
select sum(saleprice), avg(saleprice)
from orders;


--(10) 고객의 이름과 고객별 구매액
select name, sum(saleprice)
from orders o, customer c
where c.custid = o.custid
group by name;


-- (11) 고객의 이름과 고객이 구매한도서 목록
select name, bookname
from orders o, customer c, book b
where c.custid = o.custid and o.bookid = b.bookid
order by name
;

-- (12) 도서의가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문번호
--차이가 가장 많은 가격
select max(b.price-o.saleprice)
from book b, orders o
where b.bookid = o.bookid;

select o.orderid, b.price-o.saleprice
from book b, orders o
where b.bookid = o.bookid and
      b.price-o.saleprice = (select max(b.price-o.saleprice)
                             from book b, orders o
                             where b.bookid = o.bookid);


-- (13) 도서의 판매액 평균 보다 
--      자신의 구매액 평균이 더 높은 고객의 이름
select avg(saleprice) from orders;

select avg(sum(saleprice)
from orders o, customer c
where c.custid = o.custid;


























