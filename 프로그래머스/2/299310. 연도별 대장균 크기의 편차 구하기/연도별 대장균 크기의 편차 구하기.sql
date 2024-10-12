select year(A.DIFFERENTIATION_DATE) as YEAR, (B.SIZE - A.SIZE_OF_COLONY) as YEAR_DEV, A.ID
from ECOLI_DATA as A
left join (select year(DIFFERENTIATION_DATE) as YEAR, max(SIZE_OF_COLONY) as SIZE
        from ECOLI_DATA
        group by year(DIFFERENTIATION_DATE)) as B
on year(A.DIFFERENTIATION_DATE) = B.YEAR
order by YEAR, YEAR_DEV