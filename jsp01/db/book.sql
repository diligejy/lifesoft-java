drop table book;

create table book(
id number not null, -- 도서코드
title varchar2(50), -- 도서이름
author varchar2(20), -- 저자
price number default 0, --단가
qty number default 0, --수량
primary key(id)
);

--자료입력
insert into book (id, title, author, price, qty) 
values( (select nvl( max(id)+1, 1) from book), 'OS', 'Wiley', 30700, 50);

insert into book(id, title, author, price, qty)
values( (select nvl( max(id)+1, 1) from book), 'Java', 'OReily', 35000, 10);

insert into book(id, title, author, price, qty)
values( (select nvl( max(id)+1, 1) from book), 'C++', '영진', 45000, 20);

insert into book(id, title, author, price, qty)
values( (select nvl( max(id)+1, 1) from book), 'Oracle', '한빛', 40000, 25);

--입력자료 확인
select * from book;
select title, price from book;

commit