
-- Think well what are you doing here

-- Connect as admin/root/postgres ( superuser ) to execute these instructions

-- Webapp db and user
CREATE USER "mainTestDbUsername" WITH PASSWORD 'mainDbTestPwd';
CREATE DATABASE "mainTestDB" WITH ENCODING='UTF8' OWNER="mainDbTestUsername";

