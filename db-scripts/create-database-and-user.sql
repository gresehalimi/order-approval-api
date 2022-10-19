CREATE DATABASE IF NOT EXISTS order_approval_api;
CREATE USER 'order_approval_api'@'%' IDENTIFIED BY 'order_approval_api';
GRANT ALL PRIVILEGES ON order_approval_api.* to 'order_approval_api'@'%';
FLUSH PRIVILEGES;