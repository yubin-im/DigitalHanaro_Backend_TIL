-- sns-db.sql

-- 1. DB 연결
USE mydb;

DROP TABLE sns_user;

CREATE TABLE sns_user(
    id      BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(255) NOT NULL, -- 닉네임(별명)
    email   VARCHAR(255) NOT NULL, -- 이메일(계정)
    picture VARCHAR(255) NOT NULL, -- 프로필이미지 경로
    user_role   VARCHAR(255) DEFAULT 'ROLE_USER',
    created_date  DATE DEFAULT (current_date),
    modified_date DATE DEFAULT (current_date)
);

INSERT INTO sns_user VALUES (0, 'hong', 'hong@gmail.com', '', 'ROLE_USER', default, default );
INSERT INTO sns_user VALUES (0, 'tom', 'tom@gmail.com', '', 'ROLE_USER', default, default );

SELECT * FROM sns_user;

-- commit;