-- 코드를 입력하세요
SELECT i.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(avg(REVIEW_SCORE),2) SCORE
from REST_INFO i
join REST_REVIEW r
on i.REST_ID = r.REST_ID
where ADDRESS like '서울%'
group by REST_ID
order by SCORE desc, FAVORITES desc

