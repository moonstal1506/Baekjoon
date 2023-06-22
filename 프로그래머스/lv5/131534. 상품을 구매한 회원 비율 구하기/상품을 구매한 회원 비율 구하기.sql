-- 코드를 입력하세요
SELECT year(SALES_DATE) YEAR, 
       month(SALES_DATE) MONTH, 
       count(distinct u.USER_ID) PUCHASED_USERS, 
       round((count(distinct u.USER_ID)/
             (select count(distinct USER_ID)
             from USER_INFO 
             where year(JOINED)="2021")),1) PUCHASED_RATIO
from USER_INFO u
join ONLINE_SALE o
on u.USER_ID=o.USER_ID
where year(JOINED)="2021"
group by YEAR, MONTH
order by YEAR, MONTH
