-- q05-1
SELECT 제품.`제품명`, 
SUM(주문세부.`주문수량`) AS 주문수량합, 
SUM(주문세부.`단가` * 주문세부.`주문수량`) AS 주문금액합
FROM 제품
INNER JOIN 주문세부 
ON 제품.`제품번호` = 주문세부.`제품번호`
GROUP BY 제품.`제품명`;

-- q05-2
SELECT YEAR(주문.`주문일`),
제품.`제품명`,
SUM(주문세부.`주문수량`)
FROM 주문 
INNER JOIN 주문세부 
ON 주문세부.`주문번호` = 주문.`주문번호`
INNER JOIN 제품
ON 주문세부.`제품번호` = 제품.`제품번호`
WHERE 제품.`제품명` LIKE '%아이스크림%'
GROUP BY YEAR(주문.`주문일`), 제품.`제품명`;

-- q05-3
SELECT 제품.`제품명`,
SUM(주문세부.`주문수량`) AS 주문수량합
FROM 제품
LEFT JOIN 주문세부
ON 제품.`제품번호` = 주문세부.`제품번호`
GROUP BY 제품.`제품명`;

-- q05-4
SELECT 고객.`고객번호`, 고객.`고객회사명`, 고객.`담당자명`,
마일리지등급.`등급명`, 고객.`마일리지`
FROM 고객
JOIN 마일리지등급
WHERE 마일리지등급.`등급명` = 'A'
AND 고객.`마일리지` BETWEEN 마일리지등급.`하한마일리지` AND 마일리지등급.`상한마일리지`;

-- q05-5
SELECT 마일리지등급.`등급명`, 
COUNT(고객.`고객번호`) AS 등급별고객수
FROM 마일리지등급
JOIN 고객 
WHERE 고객.`마일리지` BETWEEN 마일리지등급.`하한마일리지` AND 마일리지등급.`상한마일리지`
GROUP BY 마일리지등급.`등급명`
ORDER BY 마일리지등급.`등급명`;

-- q05-6
SELECT 주문.`주문번호`, 고객.*
FROM 고객
INNER JOIN 주문
ON 고객.`고객번호` = 주문.`고객번호`
WHERE 주문.`주문번호` = 'H0249';

-- q05-7
SELECT 주문.`주문일`, 고객.*
FROM 주문
INNER JOIN 고객
ON 주문.`고객번호` = 고객.`고객번호`
WHERE 주문.`주문일` = '2020-04-09';

-- q05-8
SELECT 고객.`도시`,
SUM(주문세부.`주문수량` * 주문세부.`단가`) AS 주문금액합
FROM 주문
INNER JOIN 주문세부
ON 주문.`주문번호` = 주문세부.`주문번호`
INNER JOIN 고객
ON 주문.`고객번호` = 고객.`고객번호`
GROUP BY 고객.`도시`
ORDER BY 주문금액합 DESC
LIMIT 5;