DROP INDEX PK_delivery;

/* 배달정보 */
DROP TABLE delivery 
	CASCADE CONSTRAINTS;

/* 배달정보 */
CREATE TABLE delivery (
	adressnum number(6) NOT NULL, /* 주소번호 */
	dname VARCHAR2(50) default 'N' NOT NULL, /* 이름 */
	daddr VARCHAR2(255) default 'N' NOT NULL, /* 주소 */
	dphn VARCHAR2(30) default 'N' NOT NULL /* 전화번호*/
);

desc delivery;

COMMENT ON TABLE delivery IS '배달정보';

COMMENT ON COLUMN delivery.adressnum IS '주소번호';

COMMENT ON COLUMN delivery.dname IS '이름';

COMMENT ON COLUMN delivery.daddr IS '주소';

COMMENT ON COLUMN delivery.dphn IS '전화번호';

CREATE UNIQUE INDEX PK_delivery
	ON delivery (
		adressnum ASC
	);

ALTER TABLE delivery
	ADD
		CONSTRAINT PK_delivery
		PRIMARY KEY (
			adressnum
		);

delete from delivery;
        


drop sequence del_seq;
--시퀀스생성
create sequence del_seq
start with 1
minvalue 1
increment by 1
;

