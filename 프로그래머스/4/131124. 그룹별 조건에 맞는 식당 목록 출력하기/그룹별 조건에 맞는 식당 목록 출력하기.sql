SELECT s.member_name, f.review_text, DATE_FORMAT(f.review_date,"%Y-%m-%d") review_date
from rest_review f
join member_profile s
on f.member_id = s.member_id
WHERE f.member_id = (
    SELECT member_id
    FROM rest_review
    GROUP BY member_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
)
order by f.review_date asc, f.review_text asc;