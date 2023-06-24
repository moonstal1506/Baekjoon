SELECT HISTORY_ID, 
       round(DAILY_FEE*DURATION*(100-IFNULL(DISCOUNT_RATE,0))/100) FEE
from (select HISTORY_ID, c.CAR_TYPE, DAILY_FEE,
      datediff(END_DATE,START_DATE)+1 DURATION,
      CASE 
        WHEN datediff(END_DATE,START_DATE) + 1 >= 90 THEN '90일 이상'
        WHEN datediff(END_DATE,START_DATE) + 1 >= 30 THEN '30일 이상'
        WHEN datediff(END_DATE,START_DATE) + 1 >= 7 THEN '7일 이상'
        ELSE '7일 미만' 
    END AS DURATION_TYPE
      from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
      join CAR_RENTAL_COMPANY_CAR c
      on h.CAR_ID=c.CAR_ID
     ) h
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
on p.DURATION_TYPE=h.DURATION_TYPE and p.CAR_TYPE=h.CAR_TYPE
where h.CAR_TYPE="트럭" #여기에 p로 써서 틀렸음
order by FEE desc, HISTORY_ID desc