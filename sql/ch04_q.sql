-- q04-1
SELECT COUNT(도시),
COUNT(DISTINCT 도시)
FROM 고객;

-- q04-2
SELECT YEAR(주문일) AS 주문년도,
COUNT(*) AS 주문건수
FROM 주문
GROUP BY YEAR(주문일);

-- q04-3
SELECT YEAR(주문일) AS 주문년도,
QUARTER(주문일) AS 분기,
COUNT(*) AS 주문건수
FROM 주문
GROUP BY YEAR(주문일), QUARTER(주문일); 

-- q04-4
SELECT MONTH(주문일) AS 주문월,
COUNT(*)
FROM 주문
WHERE 요청일 < 발송일
GROUP BY MONTH(주문일)
ORDER BY MONTH(주문일);

-- q04-5
SELECT 제품명, 재고 AS 재고합
FROM 제품
WHERE 제품명 LIKE '%아이스크림%'
GROUP BY 제품명;

-- q04-6
SELECT IF(마일리지>=50000, 'VIP고객', '일반고객') AS 고객구분,
COUNT(*) AS 고객수,
AVG(마일리지) AS 평균마일리지 
FROM 고객
GROUP BY 고객구분;

-- q04-7
SELECT SUM(주문수량) AS 주문수량합,
SUM(단가*주문수량) AS 주문금액합
FROM 주문세부;

-- q04-8
SELECT 주문번호, 제품번호,
SUM(단가*주문수량) AS 주문금액합
FROM 주문세부
GROUP BY 주문번호, 제품번호
ORDER BY 주문번호;

-- q04-9
SELECT 고객번호,
COUNT(*) AS 주문건수 
FROM 주문
WHERE YEAR(주문일) = 2021
GROUP BY 고객번호
ORDER BY 주문건수 DESC
LIMIT 3;

-- q04-10
SELECT 직위,
COUNT(이름) AS 직위별사원수,
이름 AS 사원이름
FROM 사원
GROUP BY 직위;