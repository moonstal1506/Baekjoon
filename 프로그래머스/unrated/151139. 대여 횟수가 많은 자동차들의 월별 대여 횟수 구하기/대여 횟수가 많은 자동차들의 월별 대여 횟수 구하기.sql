-- 코드를 입력하세요
SELECT month(START_DATE) MONTH, CAR_ID, count(*) RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where CAR_ID in 
    (select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE (DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10')
    group by CAR_ID
    having count(CAR_ID)>=5)
    and (DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10')
group by MONTH, CAR_ID
order by MONTH, CAR_ID desc
