-- 글자 길이
SELECT CHAR_LENGTH('HELLO'),  -- 글자 길이
LENGTH('HELLO'),  -- 글자 바이트수 
CHAR_LENGTH('한글'),  -- 글자 길이
LENGTH('한글');  -- 글자 바이트수

-- 문자열 연결
SELECT CONCAT('DREAMS', 'COME', 'TRUE');

-- 구분자 이용한 문자열 연결
SELECT CONCAT_WS('-', '2024', '3', '19');

-- 문자열 일부 가져오기
SELECT LEFT('SQL 완전정복', 3);
SELECT RIGHT('SQL 완전정복', 4);
SELECT SUBSTR('SQL 완전정복', 2, 5);
SELECT SUBSTR('SQL 완전정복', 2);

-- 문자열 제거후 가져오기
-- 2번쨰 구분자 이후를 지우고 가져온다.
SELECT SUBSTRING_INDEX('서울시 동작구 흑석로', ' ', 2);  
-- 뒤에서부터 2번쨰 구분자 이전을 지우고 가져온다.
SELECT SUBSTRING_INDEX('서울시 동작구 흑석로', ' ', -2);  

-- 자리수 채움 문자
SELECT LPAD('SQL', 10, '#');
SELECT RPAD('SQL', 5, '*'); 

-- 공백 제거
SELECT LENGTH(LTRIM('  SQL  '));
SELECT LENGTH(RTRIM('  SQL  '));
SELECT LENGTH(TRIM('  SQL  '));

-- 특정문자 제거
SELECT TRIM(BOTH 'abc' FROM 'abcSQLLababc');
SELECT TRIM(LEADING 'abc' FROM 'abcSQLLababc');
SELECT TRIM(TRAILING 'abc' FROM 'abcSQLLababc');

-- 문자열 선택
-- SQL 인덱스는 1부터 시작! 
SELECT FIELD('JAVA', 'SQL', 'JAVA', 'C');
SELECT FIND_IN_SET('JAVA', 'SQL,JAVA,C'); 
SELECT INSTR('네 인생을 살아라', '인생');
SELECT LOCATE('인생', '네 인생을 살아라');
SELECT ELT(2, 'SQL', 'JAVA', 'C'); 

-- 문자열 중복
SELECT REPEAT('*', 5);
SELECT CONCAT(REPEAT('*', 5), 'star');

-- 문자열 치환 
SELECT REPLACE('010.123.4567', '.', '-');

-- 문자열 거꾸로
SELECT REVERSE('OLLEH');

-- 소수점 관련 함수들
SELECT CEILING(123.56);
SELECT FLOOR(123.56);
SELECT ROUND(123.56); -- 소수점 첫째자리 반올림 
SELECT ROUND(123.56, 1); -- 소수점 둘째자리 반올림 
SELECT ROUND(123.56, 2); -- 소수점 셋째자리 반올림 
SELECT ROUND(123.56, -1); -- 일의 자리에서 반올림 
SELECT ROUND(123.56, -2); -- 십의 자리에서 반올림 
SELECT TRUNCATE(123.56, 1); -- 소수점 둘째자리에서 버림
SELECT TRUNCATE(123.56, -1); -- 일의 자리에서 버림 

-- 부호
SELECT SIGN(-120); -- -1로 변환
SELECT SIGN(120); -- 1로 변환

-- 나누기 함수
SELECT MOD(203, 4);
SELECT 203 % 4;
SELECT 203 MOD 4;

-- 제곱승
SELECT POWER(2, 3); -- 2의 3승

-- 제곱근
SELECT SQRT(16); -- 16의 제곱근

-- 랜덤값
SELECT RAND();
SELECT RAND(100);
SELECT ROUND(RAND() * 100); -- 0~100
SELECT ROUND(RAND() * 100) + 1; -- 1~100