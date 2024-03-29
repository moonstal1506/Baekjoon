-- 코드를 입력하세요
SELECT YEAR(SALES_DATE) YEAR, MONTH(SALES_DATE) MONTH, GENDER, 
count(distinct u.USER_ID) USERS
from USER_INFO u
join ONLINE_SALE o
on u.USER_ID=o.USER_ID
where GENDER is not null
group by YEAR,MONTH,GENDER
order by YEAR,MONTH,GENDER