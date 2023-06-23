-- 코드를 입력하세요
SELECT distinct c.CAR_ID,c.CAR_TYPE, round(DAILY_FEE*30*(100-DISCOUNT_RATE)/100) FEE
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
on c.CAR_ID=h.CAR_ID
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
on c.CAR_TYPE=p.CAR_TYPE
where c.CAR_TYPE in ("세단", "SUV")
and (c.CAR_ID not in (
    SELECT distinct CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where "2022-11" between date_format(START_DATE,"%Y-%m") and date_format(END_DATE,"%Y-%m")))
and DURATION_TYPE="30일 이상"
and DAILY_FEE*30*(100-DISCOUNT_RATE)/100 between 500000 and 2000000
order by FEE desc, c.CAR_TYPE, c.CAR_ID desc
    