-- 코드를 입력하세요
SELECT truncate(PRICE,-4) PRICE_GROUP, count(PRODUCT_ID) PRODUCTS
from PRODUCT
group by PRICE_GROUP
order by PRICE_GROUP;