-- q06-1
SELECT 부서명
FROM 부서
WHERE 부서번호 = (SELECT 부서번호 FROM 사원 WHERE 이름 = '배재용');

-- q06-2
SELECT *
FROM 제품
WHERE 제품명 IN (SELECT 제품.`제품명` FROM 제품
					 LEFT JOIN 주문세부
					 ON 제품.`제품번호` = 주문세부.`제품번호`
					 GROUP BY 제품.`제품명`
					 HAVING SUM(주문세부.`주문수량`) IS NULL);
					 
-- q06-3
SELECT 고객.`담당자명`, 고객.`고객회사명`, 
주문건수, 최초주문일, 최종주문일
FROM 고객,
(
SELECT 고객번호, COUNT(고객번호) AS 주문건수,
MIN(주문일) AS 최초주문일,
MAX(주문일) AS 최종주문일
FROM 주문
GROUP BY 고객번호
) AS 주문관련
WHERE 고객.`고객번호` = 주문관련.고객번호
;

-- q06-4
SELECT 제품명 
FROM 제품
WHERE 단가 = (SELECT MAX(단가) FROM 제품);

-- q06-5
SELECT SUM(주문수량) AS 주문수량합
FROM 주문세부
WHERE 제품번호 = (SELECT 제품번호
						FROM 제품
						WHERE 단가 = (SELECT MAX(단가) FROM 제품));				
						
-- q06-6
SELECT SUM(주문수량) AS 아이스크림주문수량합 
FROM 주문세부
WHERE 제품번호 IN (SELECT 제품번호
						 FROM 제품
						 WHERE 제품명 LIKE ('%아이스크림%'));

-- q06-7
SELECT YEAR(주문일) AS 주문년도, 
COUNT(*) AS 주문건수
FROM 주문
WHERE 고객번호 IN (SELECT 고객번호
						 FROM 고객
						 WHERE 도시 = '서울특별시')
GROUP BY YEAR(주문일);
