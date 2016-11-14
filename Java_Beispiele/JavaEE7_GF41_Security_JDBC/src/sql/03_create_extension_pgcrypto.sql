-- Install the pgcrypto extension, for better password hashing. 
-- ATTENTION: You must connect to the gfrealm database as superuser,
-- i.e., as user "postgres"!

-- Create pgcrypt extension, if not already created.
DROP EXTENSION IF EXISTS pgcrypto;
CREATE EXTENSION IF NOT EXISTS pgcrypto;

GRANT EXECUTE ON FUNCTION gfapp.crypt(TEXT) TO gfrealm_user;

SELECT  gfapp.crypt('new password', gfapp.gen_salt('md5'));