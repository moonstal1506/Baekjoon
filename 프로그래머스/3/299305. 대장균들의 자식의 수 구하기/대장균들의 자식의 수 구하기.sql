select ID, ifnull(CHILD_COUNT,0) CHILD_COUNT
from ECOLI_DATA a
left join (select PARENT_ID, count(*) CHILD_COUNT from ECOLI_DATA
      group by PARENT_ID) b
on a.ID = b.PARENT_ID
order by ID

      