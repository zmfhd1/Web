select * from member;


create table member(
memberid varchar2(30) constraint member_id_pk primary key,
password number(5),
membername varchar2(30),
email varchar2(20) constraint member_email_ck check(email like '%@%')
);

insert into member values('mamber1', 1111, '박회원', 'park@mul.com');
insert into member values('mamber2', 2222, '김회원', 'kim@campus.com');

insert into member values('mamber3', 3333, '최회원', 'park@mul.com');
insert into member values('mamber4', 4444, '이회원', 'kim@campus.com');
insert into member values('mamber5', 5555, '나회원', 'park@mul.com');
