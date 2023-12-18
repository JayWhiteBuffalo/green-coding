--Part 1
-- Column Name    Data Type
-- --------------------------------
-- id             int
-- employer       int
-- name           VARCHAR(50)
-- skills         VARCHAR(255)
-- employer_id    int
--Part 2
SELECT name FROM employer WHERE location = "St. Louis City";

--Part 3
DROP TABLE job;
--Part 4
SELECT * FROM skill
LEFT JOIN job_skills ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC;