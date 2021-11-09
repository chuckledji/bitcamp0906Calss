-- 2021.11.05
-- procedure
-- Book테이블에 한 개의 투플을 삽입하는 프로시저
create or replace procedure InsertBook(
    -- 매개변수 선언
    myBookId in number,
    myBookName in varchar2,
    myPublisher  in varchar2,
    myPrice in number
)
as
begin -- 코드 실행 시작
    -- 핵심처리 코드
    -- 매개변수로 받은 데이터를 이용해서 데이터 삽입.
    insert into book (bookid, bookname, publisher, price) 
    values (myBookId, myBookName, myPublisher, myPrice);
end -- 코드 실행 종료
;