[CMD]
sqlplus conn as sysdba
create user mvc identified by mvc;
grant connect, resource mvc;

CREATE TABLE JSPMVC(
	SID NUMBER PRIMARY KEY,
	TITLE NVARCHAR2(200) NOT NULL,
	CONTENT NVARCHAR2(2000)
);

CREATE SEQUENCE JSPMVC_SEQ;
