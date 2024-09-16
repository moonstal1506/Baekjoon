-- 코드를 작성해주세요
select count(*) FISH_COUNT
from FISH_INFO a
join FISH_NAME_INFO b 
on a.FISH_TYPE = b.FISH_TYPE
where FISH_NAME in ('BASS','SNAPPER')