SQL> connect gudyna/gudyna as sysdba;
Connected.
SQL> GRANT create session TO gudyna;

Grant succeeded.

SQL> GRANT create table TO gudyna;

Grant succeeded.

CREATE USER gudyna IDENTIFIED BY gudyna;

connect gudyna/gudyna as sysdba;
GRANT create view TO gudyna;
GRANT create any trigger TO gudyna;
GRANT create any procedure TO gudyna;
GRANT create sequence TO gudyna;
GRANT create synonym TO gudyna;
GRANT UNLIMITED TABLESPACE TO gudyna;

create table personal_info
( id number NOT NULL,
  name varchar2(20) NOT NULL,
  surname varchar2(20) NOT NULL,
  CONSTRAINT personal_info_pk PRIMARY KEY (id)
);

create table users
(
id number NOT NULL,
nickname varchar2(25) NOT NULL,
type varchar2(2) NOT NULL,
room_number number,
arrival_date date,
personal_info_id number UNIQUE,
CONSTRAINT users_pk PRIMARY KEY (id),
  CONSTRAINT fk_personal_info
    FOREIGN KEY (personal_info_id)
    REFERENCES personal_info(id)
);
   
create table hardware
(
id number NOT NULL,
name varchar2(20) NOT NULL,
release_year number,
user_id number,
CONSTRAINT fk_user
    FOREIGN KEY (user_id)
    REFERENCES users(id)
);

CREATE SEQUENCE users_seq
 START WITH     1000
 INCREMENT BY   1;
 
 CREATE SEQUENCE personal_info_seq
 START WITH     1000
 INCREMENT BY   1;
 
 CREATE SEQUENCE hardware_seq
 START WITH     1000
 INCREMENT BY   1;

insert into personal_info values (1, 'Nastya', 'Hudyna');
insert into personal_info values (2, 'Mark', 'Smith');
insert into users values (1, 'Nastassya', 'E', 404, TO_DATE('2014/06/01', 'yyyy/mm/dd'), 1);
insert into users values (2, 'Markusha', 'U', null, null, 2);
insert into hardware values(1, 'EPBYMINW4308', 2012, 1);
insert into hardware values(2, 'EPBYMINW4309', 2012, 2);
insert into hardware values(3, 'EPB123', 2012, 2);


    

