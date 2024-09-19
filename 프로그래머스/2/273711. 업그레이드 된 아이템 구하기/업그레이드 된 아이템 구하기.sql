select a.ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO a
join (select ITEM_ID 
        from ITEM_TREE a
        where PARENT_ITEM_ID in (select distinct(ITEM_ID)
                                 from ITEM_INFO 
                                 where RARITY = 'RARE')) b 
on a.ITEM_ID = b.ITEM_ID
order by ITEM_ID desc


