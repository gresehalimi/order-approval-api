/*!40014 SET FOREIGN_KEY_CHECKS = 0 */;

USE order_approval_api;

CREATE TABLE order_approval (
    id INT NOT NULL AUTO_INCREMENT,
    order_id INT NOT NULL,
    customer_name VARCHAR(250) NOT NULL,
    customer_phone VARCHAR(250) NOT NULL,
    customer_email VARCHAR(250) NOT NULL,
    products MEDIUMTEXT NOT NULL,
    installation_address MEDIUMTEXT NOT NULL,
    date_time_installation TIMESTAMP NOT NULL,
    state varchar(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    agent_name varchar(50) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE agent (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL,
    city VARCHAR(50) NOT NULL,
    country CHAR(2) NOT NULL,
    availability VARCHAR(150) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (name)
);

/*!40014 SET FOREIGN_KEY_CHECKS = 1 */;
