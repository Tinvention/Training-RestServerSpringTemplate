
-- Think well what are you doing here

-- Connect as admin/root/postgres ( superuser ) to execute these instructions

-- Webapp db and user

CREATE USER "testDbUsername" WITH PASSWORD 'testDbPwd';
CREATE DATABASE "testAppDB" WITH ENCODING='UTF8' OWNER="testDbUsername";
