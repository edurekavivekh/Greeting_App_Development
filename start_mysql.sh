docker run -d --name database -p 3306:3306 -e MYSQL_ROOT_PASSWORD=pass@123 -d mysql:latest
sleep 60s
mysql -u'root' -p'pass@123' -h 127.0.0.1 < setup_mysql.sql

