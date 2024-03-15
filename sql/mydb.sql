-- database 생성
create database if not exists mydb; 
use mydb;

-- 테이블 생성 
create table member (
	memberno int(11) not null auto_increment primary key,
    id varchar(50),
    name varchar(50)
);

-- 테이블 구조 확인
DESC member;

-- 레코드 추가
insert into member (id, name) values ('hong', '홍길동');
insert into member (id, name) values ('tom', '톰아저씨');
insert into member (id, name) values ('sony', '손흥민');
insert into member (id, name) values ('mask', '머스크');

-- 조회
select * from member;

-- 레코드 수정
update member set id='lee', name='미스터리' where memberno=1;

-- 레코드 삭제
delete from member where memberno=1;

