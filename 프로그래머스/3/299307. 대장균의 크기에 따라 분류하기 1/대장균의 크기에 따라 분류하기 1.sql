select ID, case when SIZE_OF_COLONY >1000 then "HIGH" 
                when SIZE_OF_COLONY >100 then "MEDIUM"
                else "LOW" end SIZE
                from ECOLI_DATA
                order by ID