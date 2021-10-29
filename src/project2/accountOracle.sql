--계좌정보 테이블
create table banking_tb(
    acc_index number primary key,
    acc_id varchar2(100),
    cust_name varchar2(50) not null,
    acc_money number not null
);

desc banking_tb;
drop table banking_tb;

--시퀀스 생성
create sequence seq_banking
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;
    
drop sequence seq_banking;


commit;

