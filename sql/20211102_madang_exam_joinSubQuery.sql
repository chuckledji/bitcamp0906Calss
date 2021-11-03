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
select bookname, price, price-saleprice as pricegap
from book




