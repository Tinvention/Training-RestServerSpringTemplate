
-- Think well what are you doing here

-- Connect as admin/root/postgres ( superuser ) to execute these instructions

-- Webapp db and user
CREATE USER "restAppTemplateDbUser" WITH PASSWORD 'restAppTemplate';
CREATE DATABASE "restAppTemplate" WITH ENCODING='UTF8' OWNER="restAppTemplateDbUser";


-- Testing db and user
CREATE USER "restAppTemplateDbTestUser" WITH PASSWORD 'restAppTemplateTest' ;
CREATE DATABASE "restAppTemplateTest" WITH ENCODING='UTF8' OWNER="restAppTemplateDbTestUser" ;

