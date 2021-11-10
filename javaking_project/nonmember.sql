DROP INDEX PK_nonmember;

/* 비회원 */
DROP TABLE nonmember 
	CASCADE CONSTRAINTS;

/* 비회원 */
CREATE TABLE nonmember (
	nmemid number(6) NOT NULL, /* 비회원번호 */
	name VARCHAR2(50) NOT NULL, /* 이름 */
	phone VARCHAR2(30) NOT NULL, /* 전화번호 */
	address VARCHAR2(255) NOT NULL /* 주소 */
);

COMMENT ON TABLE nonmember IS '비회원';

COMMENT ON COLUMN nonmember.nmemid IS '비회원번호';

COMMENT ON COLUMN nonmember.name IS '이름';

COMMENT ON COLUMN nonmember.phone IS '전화번호';

COMMENT ON COLUMN nonmember.address IS '주소';

CREATE UNIQUE INDEX PK_nonmember
	ON nonmember (
		nmemid ASC
	);

ALTER TABLE nonmember
	ADD
		CONSTRAINT PK_nonmember
		PRIMARY KEY (
			nmemid
		);
        
desc nonmember;

drop sequence mem_seq;
--시퀀스생성
create sequence nonmem_seq
start with 1
minvalue 1
increment by 1
;