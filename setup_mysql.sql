create database greetapp;
create user 'greetuser' identified by 'pass@123';
grant all privileges on `greetapp`.* to 'greetuser'@'%';
flush privileges;
