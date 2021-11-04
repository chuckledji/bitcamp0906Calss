
--20211104
--DML생성

--1. phoneInfo_basic 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
select * from phoneInfo_basic;
--정보입력
insert into phoneInfo_basic (idx, fr_name, fr_phonenumber, fr_email, fr_address, fr_regdate)
VALUES (1, '김일일', '010-0000-1111', '가땡땡@naver.com', '서울시','');
insert into phoneInfo_basic
VALUES (2, '박이이', '010-0000-2222', '박땡땡@naver.com', '인천시',sysdate);
insert into phoneInfo_basic
VALUES (3, '이삼삼', '010-0000-3333', '', '',sysdate);
insert into phoneInfo_basic
VALUES (4, '최사사', '010-0000-4444', '', '청주시',sysdate);
insert into phoneInfo_basic
VALUES (5, '정오오', '010-0000-5555', '오땡땡@gmail.com', '광양시','2021-08-05');
insert into phoneInfo_basic
VALUES (6, '서육육', '010-0000-6666', '육땡땡@gmail.com', '파주시','2021-11-08');

--정보수정
update phoneInfo_basic 
set fr_phonenumber = '010-1111-1111';
rollback;

update phoneInfo_basic 
set fr_phonenumber = '010-1111-1111'
where fr_name = '김일일';

update phoneInfo_basic      --여러 컬럼 바꾸기
set fr_phonenumber='010-2222-2222', fr_regdate = '2015-05-05'
where idx =2;

update phoneinfo_basic      --서브쿼리이용해서 바꾸기
set fr_address = (select fr_address from phoneinfo_basic where idx=2)
where fr_address is null;

update phoneinfo_basic      --서브쿼리이용해서 여러 컬럼 바꾸기
set (fr_address, fr_regdate) = (select fr_address, fr_regdate from phoneinfo_basic where idx=3)
where idx=1;

--정보삭제
delete from phoneinfo_basic where fr_email is null;
delete from phoneinfo_basic --서브쿼리이용해서 삭제
where idx=(select idx from phoneinfo_basic where fr_regdate < '2021-01-01');

select * from phoneInfo_basic; --남은정보확인



--2. phoneinfo_univ 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
select * from phoneinfo_univ;

--정보입력
insert INTO phoneinfo_univ VALUES (1, '사회학과', 3,1);
insert INTO phoneinfo_univ VALUES (2, default, default,5);

--정보수정
update phoneinfo_univ set fr_u_major='경제학과', fr_u_year =4 where fr_u_major = 'N';

--정보삭제
delete from phoneinfo_univ where fr_ref = 5;

--3. phoneinfo_com 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
select * from phoneinfo_com;

--정보입력
insert INTO phoneinfo_com VALUES (1, '네이버', 1);
insert INTO phoneinfo_com VALUES (2, default, 6);

--정보수정
update phoneinfo_com set fr_c_company='일리' where fr_c_company = 'N';

--정보삭제
delete from phoneinfo_com where fr_ref = 6;