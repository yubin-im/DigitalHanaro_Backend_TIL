USE mydb;

-- 회원가입 테이블 만들기
DROP TABLE member;
CREATE TABLE member (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	user_id VARCHAR(255) NOT NULL,
	user_pw VARCHAR(255) NOT NULL,
	user_name VARCHAR(255),
	user_role VARCHAR(255) DEFAULT 'ROLE_USER',
	join_date DATE DEFAULT (CURRENT_DATE)
);
DESC member;

-- 데이터 추가하기
INSERT INTO member(user_id, user_pw, user_name, user_role, join_date) VALUES ("1", 'hong', '1234', 'ROLE_USER', '2024-01-01');
INSERT INTO member(user_id, user_pw, user_name, user_role, join_date) VALUES ("2", 'tom', '1234', 'ROLE_USER', '2024-02-01');
INSERT INTO member(user_id, user_pw, user_name, user_role, join_date) VALUES ("3", 'admin', '1234', 'ROLE_ADMIN', '2024-03-01');

SELECT * FROM member;
