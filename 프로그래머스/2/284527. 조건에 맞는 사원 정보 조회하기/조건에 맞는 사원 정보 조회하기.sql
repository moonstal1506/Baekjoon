select sum(SCORE) SCORE, a.EMP_NO, EMP_NAME, POSITION, EMAIL
from HR_EMPLOYEES a
join HR_GRADE b
on a.EMP_NO = b.EMP_NO
group by b.EMP_NO
order by SCORE desc
limit 1;
