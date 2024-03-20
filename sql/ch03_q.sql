-- q03-1
SELECT 고객회사명,
CONCAT('**', RIGHT(고객회사명, 3)) AS 고객회사명2,
전화번호,
REPLACE(REPLACE(전화번호, '(', ''), ')', '-') AS 전화번호2
FROM 고객;

-- q03-2
SELECT *,
TRUNCATE((주문수량 * 단가), -1) AS 주문금액,
TRUNCATE((주문수량 * 단가 * 할인율), -1) AS 할인금액,
TRUNCATE(((주문수량 * 단가) - (주문수량 * 단가 * 할인율)), -1) AS 실주문금액
FROM 주문세부;

-- q03-3
SELECT 이름, 생일, 
YEAR(CURDATE()) - YEAR(생일) AS 만나이,
입사일,
DATEDIFF(CURDATE(), 입사일) AS 입사일수,
ADDDATE(입사일, 500) AS 500일후 
FROM 사원;

-- q03-4
SELECT 담당자명, 고객회사명, 도시,
IF(RIGHT(도시, 3) = '특별시' OR RIGHT(도시, 3) = '광역시', '대도시', '도시') AS 도시구분, 
마일리지,
CASE
    WHEN 마일리지 >= 100000 THEN 'VVIP고객'
    WHEN 마일리지 >= 10000 THEN 'VIP고객'
    ELSE '일반고객'
END AS 마일리지구분
FROM 고객;

-- q03-5
SELECT 주문번호, 고객번호, 주문일,
YEAR(주문일) AS 주문년도,
QUARTER(주문일) AS 주문분기,
MONTH(주문일) AS 주문월,
DAY(주문일) AS 주문일,
WEEKDAY(주문일) AS 주문요일,
CONCAT(SUBSTR('일월화수목금토', DAYOFWEEK(주문일), 1), '요일') AS 한글요일
FROM 주문;

-- q03-6
SELECT *,
DATEDIFF(발송일, 요청일) AS 지연일수
FROM 주문
WHERE DATEDIFF(발송일, 요청일) >= 7;

-- q03-7 
SELECT 담당자명
FROM 고객
WHERE 담당자명 LIKE '%정%';

-- q03-8
SELECT 주문일
FROM 주문
WHERE QUARTER(주문일) = 2;

-- q03-9
SELECT 제품번호, 제품명, 재고,
CASE 
	WHEN 재고 >= 100 THEN '과다재고'
	WHEN 재고 >= 10 THEN '적정'
	ELSE '재고부족' 
END AS '재고구분'
FROM 제품;

-- q03-10
SELECT 이름, 부서번호, 직위, 입사일,
DATEDIFF(CURDATE(), 입사일) AS 입사일수,
TIMESTAMPDIFF(MONTH, 입사일, CURDATE()) AS 입사개월수
FROM 사원;