DROP INDEX PK_member;

/* 회원 */
DROP TABLE member 
	CASCADE CONSTRAINTS;

/* 회원 */
CREATE TABLE member (
	memid number(6) NOT NULL, /* 회원번호 */
	userid VARCHAR2(40) NOT NULL, /* 아이디 */
	name VARCHAR2(50) NOT NULL, /* 이름 */
	password VARCHAR2(40) NOT NULL, /* 비밀번호 */
	address VARCHAR2(255) NOT NULL, /* 주소 */
	phone VARCHAR2(30) NOT NULL, /* 전화번호 */
	email VARCHAR2(40) /* 이메일 */
);

COMMENT ON TABLE member IS '회원';

COMMENT ON COLUMN member.memid IS '회원번호';

COMMENT ON COLUMN member.userid IS '아이디';

COMMENT ON COLUMN member.name IS '이름';

COMMENT ON COLUMN member.password IS '비밀번호';

COMMENT ON COLUMN member.address IS '주소';

COMMENT ON COLUMN member.phone IS '전화번호';

COMMENT ON COLUMN member.email IS '이메일';

CREATE UNIQUE INDEX PK_member
	ON member (
		memid ASC
	);

ALTER TABLE member
	ADD
		CONSTRAINT PK_member
		PRIMARY KEY (
			memid
		);
        

--관리자 정보(회원번호 0 임의로 정함)
insert into member values(0, 'kingmanager', 'manager', 'kingM1', '서울특별시 강남구 비트캠프', '010-0101-1010', 'jkmanager@gmail.com');  


--시퀀스생성
create sequence mem_seq
start with 1
minvalue 1
increment by 1
;


