USE 세계무역;

-- ex02-1
SELECT * FROM 고객;

-- 출력되는 행의 개수
SELECT COUNT(*) FROM 고객;

-- ex02-2
SELECT 고객번호, 담당자명, 고객회사명, 마일리지 AS "포인트"
, ROUND(마일리지 * 1.1) AS "10%인상된 마일리지"
FROM 고객;

-- ex02-3
SELECT 고객번호, 담당자명, 마일리지
FROM 고객
WHERE 마일리지 >= 100000;

-- ex02-4
SELECT 고객번호, 담당자명, 도시, 마일리지 AS "포인트"
FROM 고객
WHERE 도시 = "서울특별시"
ORDER BY 마일리지 DESC;

-- ex02-5
SELECT *
FROM 고객
LIMIT 3;

-- ex02-6
SELECT *
FROM 고객
ORDER BY 마일리지 DESC
LIMIT 3;

-- ex02-7
SELECT DISTINCT 도시
FROM 고객;

-- ex02-8
SELECT 23 + 5 AS 더하기,
23 - 5 AS 나누기,
23 * 5 AS 곱하기,
23 / 5 AS 나누기,
23 % 5 AS 나머지1,
23 DIV 5 AS 정수나누기,
23 MOD 5 AS 나머지2; 

-- ex02-9
SELECT 23 >= 5,
23 <= 5,
23 > 23,
23 < 23,
23 = 23,
23 != 23,
23 <> 23;

-- ex02-10
SELECT *
FROM 고객
WHERE 담당자직위 != "대표 이사";

-- ex02-11
SELECT *
FROM 고객
WHERE 도시 = "부산광역시" AND 마일리지 < 1000;

-- ex02-12
SELECT 고객번호, 담당자명, 마일리지, 도시
FROM 고객
WHERE 도시 = "부산광역시" OR 마일리지 < 1000
ORDER BY 고객번호;

-- ex02-13
UPDATE 고객
SET 지역 = NULL
WHERE 지역 = "";

SELECT * 
FROM 고객
WHERE 지역 IS NULL; 

-- ex02-14
SELECT 고객번호, 담당자명, 담당자직위
FROM 고객
WHERE 담당자직위 IN ('영업 과장', '마케팅 과장');

-- ex02-15
SELECT 담당자명, 마일리지
FROM 고객
WHERE 마일리지 BETWEEN 100000 AND 200000;

-- ex02-16
SELECT *
FROM 고객
WHERE 도시 LIKE '%광역시' 
AND (고객번호 LIKE '_C%' OR 고객번호 LIKE '__C%');
