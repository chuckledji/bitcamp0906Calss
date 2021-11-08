--ncs SQL응용

create table Book(
bookid Number(2) primary key,
bookname VARCHAR2(40),
publisher VARCHAR2(40),
price number(8)
);

create table book_log (
    bookid_l number,
    bookname_l varchar2(40),
    publisher_l varchar2(40),
    price_l number
);

--1.)동일한 도서가 있는지 점검한 후 삽입하는 프로시저(BookInsertOrUpdate)를 작성하시오

--2.)판매된 도서에 대한 이익을 계산하는 함수(fnc_Icom)를 작성
----이익금 : 가격 >= 30000, 10% or 가격<30000 5%
create or replace function fnc_Icom(price number)
RETURN int 
is
    myInterest number;
begin
    if price >= 30000 then
    myInterest := price*0.1;
    else
    myInterest := price*0.05;
    end if;
    return myInterest;
end;

--3.)새로운 도서를 삽입한 후 자동으로 Book_log테이블에 삽입한 내용을 기록하는 트리거를 작성
