-- 3) Create the database schema for the users realm db.

-- for security reasons: we remove everything we do not need.
DROP SCHEMA IF EXISTS public CASCADE;

-- Create the application schema, owner is the superuser.
DROP SCHEMA IF EXISTS gfapp CASCADE;
CREATE SCHEMA gfapp
  AUTHORIZATION postgres
;
GRANT USAGE ON SCHEMA gfapp TO gfrealm_user
;

-- Install the pgcrypto extension, for better password hashing. 
-- ATTENTION: You must connect to the gfrealm database as superuser,
-- i.e., as user "postgres"!

-- Create pgcrypt extension, if not already created.
DROP EXTENSION IF EXISTS pgcrypto;
CREATE EXTENSION IF NOT EXISTS pgcrypto SCHEMA gfapp;



DROP TABLE IF EXISTS gfapp.users CASCADE;
CREATE TABLE gfapp.users (
  user_id        SERIAL NOT NULL PRIMARY KEY,
  user_name      VARCHAR(64) UNIQUE,
  user_pwd       VARCHAR(64),
  user_active    BOOLEAN DEFAULT TRUE
)
;
COMMENT ON TABLE gfapp.users IS 'The users of the realm.'
;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE gfapp.users TO gfrealm_user
;

-- Preferrable, if you can use freestyle user and role queries: 
-- INSERT INTO gfapp.users (user_name, user_pwd) VALUES 
-- ('jack', gfapp.crypt('changeme', gfapp.gen_salt('bf'))),
-- ('jim', gfapp.crypt('changeme', gfapp.gen_salt('bf')))
-- ;
-- If you have to ressort to SHA256
INSERT INTO gfapp.users (user_name, user_pwd) VALUES 
('jack', encode( gfapp.digest('changeme', 'sha256'), 'HEX')),
('jim', encode( gfapp.digest('changeme', 'sha256'), 'HEX'))
;

DROP TABLE IF EXISTS gfapp.roles CASCADE;
CREATE TABLE gfapp.roles (
  role_id        SERIAL NOT NULL PRIMARY KEY,
  role_name      VARCHAR(64) UNIQUE
)
;
COMMENT ON TABLE gfapp.roles IS 'The roles that are defined in the realm.'
;
-- Example: 
INSERT INTO gfapp.roles (role_name) VALUES 
('admins'),
('users')
;

DROP TABLE IF EXISTS gfapp.roles2users CASCADE;
CREATE TABLE gfapp.roles2users (
  roles2users_user_id  INTEGER NOT NULL
                       REFERENCES gfapp.users (user_id)
                       ON DELETE CASCADE,
  roles2users_role_id  INTEGER NOT NULL
                       REFERENCES gfapp.roles (role_id)
                       ON DELETE CASCADE
)
;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE gfapp.roles2users TO gfrealm_user
;
COMMENT ON TABLE gfapp.roles2users IS 'Which role is granted to whom? This table stores the granted roles per user.'
;
-- Example
INSERT INTO gfapp.roles2users (roles2users_user_id, roles2users_role_id) VALUES 
(1, 1),
(2, 2)
;

CREATE OR REPLACE VIEW gfapp.v_users2roles AS 
SELECT user_name, role_name 
  FROM gfapp.users
  JOIN gfapp.roles2users ON user_id = roles2users_user_id
  JOIN gfapp.roles ON role_id = roles2users_role_id
 WHERE user_active = TRUE 
;
GRANT SELECT ON TABLE gfapp.v_users2roles TO gfrealm_user
;
COMMENT ON VIEW gfapp.v_users2roles IS 'User names and role names, for authentication.'
;