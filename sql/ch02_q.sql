-- q02-1
SELECT *
FROM 고객
WHERE 도시 LIKE '서울%'
AND 마일리지 BETWEEN 15000 AND 20000;

-- q02-2
SELECT DISTINCT 지역, 도시
FROM 고객
ORDER BY 지역, 도시;

-- q02-3
SELECT *
FROM 고객
WHERE 도시 IN ('춘천시', '과천시', '광명시')
AND (담당자직위 LIKE '%이사' OR 담당자직위 LIKE '%사원'); 

-- q02-4
SELECT *
FROM 고객
WHERE 도시 NOT LIKE '%광역시' AND 도시 NOT LIKE '%특별시'
ORDER BY 마일리지 DESC
LIMIT 3;

-- q02-5
SELECT *
FROM 고객
WHERE 담당자직위 <> '대포이사';

-- q02-6
SELECT *
FROM 제품
WHERE 제품명 LIKE '%주스%';

-- q02-7
SELECT *
FROM 제품
WHERE 제품명 LIKE '%주스%'
AND 단가 BETWEEN 5000 AND 10000;

-- q02-8
SELECT *
FROM 제품
WHERE 제품번호 IN (1, 2, 4, 7, 11, 20);

-- q02-9
SELECT 제품번호, 제품명, 단가, 재고, 
(단가 * 재고) AS '재고금액'
FROM 제품
ORDER BY (단가 * 재고) DESC
LIMIT 10;
