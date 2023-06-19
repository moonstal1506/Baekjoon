-- 코드를 입력하세요
SELECT MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE, "%Y-%m-%d") REVIEW_DATE
from MEMBER_PROFILE m
join REST_REVIEW r
on m.MEMBER_ID=r.MEMBER_ID
where r.MEMBER_ID = (
    SELECT MEMBER_ID
    from REST_REVIEW
    group by MEMBER_ID
    order by count(*) desc
    limit 1
    )
order by REVIEW_DATE, REVIEW_TEXT;
