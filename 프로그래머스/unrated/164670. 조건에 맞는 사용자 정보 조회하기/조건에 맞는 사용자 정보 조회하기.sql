-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, concat(CITY," ",STREET_ADDRESS1," ",STREET_ADDRESS2 ) 전체주소, 
concat(left(TLNO,3),"-",mid(TLNO,4,4),"-",right(TLNO,4)) 전화번호
from USED_GOODS_BOARD a
join USED_GOODS_USER b
on a.WRITER_ID = b.USER_ID
group by USER_ID
having count(WRITER_ID) >= 3
order by USER_ID desc;