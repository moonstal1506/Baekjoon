select a.EMP_NO, EMP_NAME, 
(case when SCORE >=96 then 'S'
      when SCORE >=90 then 'A'
      when SCORE >=80 then 'B'
      else 'C' 
end) GRADE, 
(case when SCORE >=96 then SAL*0.2
      when SCORE >=90 then SAL*0.15
      when SCORE >=80 then SAL*0.1
      else 0
end) BONUS
from HR_EMPLOYEES a
join (select EMP_NO, avg(SCORE) SCORE 
    from HR_GRADE 
    group by EMP_NO)
    as b
on a.EMP_NO = b.EMP_NO
order by EMP_NO