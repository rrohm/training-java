-- 1) Create database user for the JDBC realm database
--    Run this script as superuser, i.e., as user postgres.

-- If the users alread exists:  
--DROP OWNED BY gfrealm_user CASCADE;
--DROP ROLE IF EXISTS gfrealm_user;

CREATE ROLE gfrealm_user LOGIN
  PASSWORD 'changeme'
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION
;
