-- 코드를 작성해주세요
select count(*) FISH_COUNT, b.FISH_NAME FISH_NAME
from FISH_INFO a
inner join FISH_NAME_INFO b
on a.FISH_TYPE = b.FISH_TYPE
group by b.FISH_NAME
order by FISH_COUNT desc
