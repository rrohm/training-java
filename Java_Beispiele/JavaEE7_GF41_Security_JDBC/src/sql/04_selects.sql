-- Check pgcrypto functions - since installed into the schema, 
-- they need to be called as schema functions.

-- Generate "a grain of salt". Run several times and compare the results: 
SELECT gfapp.gen_salt('bf');
-- Generate a salted(!) password hash. Run several times and compare the results: 
SELECT gfapp.crypt('new password', gfapp.gen_salt('md5'));

-- Shows the users - with different hashes for the same password, thanks to the salt :-)
SELECT * FROM gfapp.users;

-- Returns true for matching passwords:
SELECT (user_pwd = gfapp.crypt('changeme', user_pwd)) AS pwd_match FROM gfapp.users
;

-- Returns the (unique) user whose password matches. 
-- In live situations, we would never SELECT *, since this would deliver the password, too.
SELECT user_id, user_name 
  FROM gfapp.users 
 WHERE user_name = 'jack' AND user_pwd = gfapp.crypt('changeme', user_pwd)
;

SELECT user_name, role_name FROM gfapp.v_users2roles
;