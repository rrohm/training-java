-- 2) Create database for the Glassfish realm

-- If the database already exists, we might want to clean up first: 
--DROP DATABASE IF EXISTS gfrealm;

-- Create the db with the appropriate user ... not with the superuser ;-)
CREATE DATABASE gfrealm
  WITH OWNER = gfrealm_user
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'de_DE.UTF-8'
       LC_CTYPE = 'de_DE.UTF-8'
       CONNECTION LIMIT = -1
;

-- The comment statement must be run in a separate cycle, 
-- since postgres does not allow more than one statement in a query that creates a database
-- (for security reasons).
-- If you run the script with PgAdmin, uncomment the next statement, 
-- select the statement text with the mouse and hit F5
-- or click on the green arrow, one by one.
--COMMENT ON DATABASE gfrealm IS 'Database for the users realm of the Glassfish Security example';