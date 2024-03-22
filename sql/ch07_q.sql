-- q07-1
INSERT INTO 제품 VALUES(95, '망고베리 아이스크림', '400g', 800, 30);
SELECT * FROM 제품;

-- q07-2
INSERT INTO 제품(제품번호, 제품명, 단가) VALUES(96, '눈꽃빙수맛 아이스크림', 2000);
SELECT * FROM 제품;

-- q07-3
UPDATE 제품 SET 재고 = 30
WHERE 제품번호 = 96;
SELECT * FROM 제품;

-- q07-4
DELETE 부서
FROM 부서
LEFT JOIN 사원 ON 부서.부서번호 = 사원.부서번호
WHERE 사원.사원번호 IS NULL;
SELECT * FROM 부서;

-- q07-5
INSERT INTO 고객(고객번호, 담당자명, 고객회사명, 도시) VALUES('ZZZAA', '한동욱', '자유트레이딩', '서울특별시');
SELECT * FROM 고객;

-- q07-6
UPDATE 고객 SET 도시='부산광역시', 마일리지=100, 담당자직위='대표이사'
WHERE 고객번호='ZZZAA';
SELECT * FROM 고객;

-- q07-7
UPDATE 고객 AS c
JOIN (SELECT ROUND(AVG(마일리지)) AS 평균마일리지
		FROM 고객
		WHERE 담당자직위='대표 이사'
		GROUP BY 담당자직위) AS 평균 
SET c.마일리지= 평균.평균마일리지
WHERE c.고객번호='ZZZAA';
SELECT * FROM 고객;

-- q07-8
INSERT INTO 사원(사원번호, 이름, 직위)
VALUES ('E15', '이석진', '수습사원')
ON DUPLICATE KEY UPDATE
사원번호='E15';
SELECT * FROM 사원;

-- q07-9
DELETE FROM 고객
WHERE 고객번호='ZZZAA';
SELECT * FROM 고객;

-- q07-10
DELETE FROM 사원
WHERE 사원번호='E15';
SELECT * FROM 사원;