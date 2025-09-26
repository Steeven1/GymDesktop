

--autentication
CREATE TABLE rol(
  id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);


CREATE TABLE employee(
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  salary INT
);

CREATE TABLE employee_rol(
  rol_id INT, --fk
  employee_id INT --fk 
);

CREATE TABLE action(
  id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE rol_action(
  rol_id INT, --fk
  action_id INT --fk
);

CREATE TABLE resource(
  id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE resource_action(
  resource_id INT, --fk
  action_id INT    --fk
);



--temp 
CREATE TABLE membership(
  id SERIAL PRIMARY KEY,    
  name VARCHAR(50),
  price BIGINT, 
  duration BIGINT, --(DURATION ON DAYS)
  started_at DATE,
  finished_at DATE,
  created_at DATE  
);

--clients
CREATE TABLE client(
  id SERIAL PRIMARY KEY
  name VARCHAR(100),
  membership_id BIGINT --foreign key
);

ALTER TABLE client ADD FOREIGN KEY (membership_id) REFERENCES membership(id);

--stock
CREATE TABLE brand(
    id SERIAL PRIMARY KEY,    
    name VARCHAR(50)
);

CREATE TABLE product(
    id SERIAL PRIMARY KEY,    
    name VARCHAR(50),
    qty BIGINT,
    price BIGINT,
    brand_id INT, --fk
    FOREIGN KEY(brand_id) REFERENCES brand(id)
);


--finances

CREATE TABLE service(
  id UUID PRIMARY KEY,
  name VARCHAR(100),
);

CREATE TABLE billing(
  id SERIAL PRIMARY KEY,
  client_id BIGINT, -- foreign key
  balance BIGINT,
  creared_at DATE,
  FOREIGN KEY (client) REFERENCES client(id)
);


CREATE TABLE billing_item(
  id SERIAL PRIMARY KEY,
  cost BIGINT,
  qty BIGINT,
  billing_id, --fk
  price BIGINT,
  total_price BIGINT,
  item_id INT --fk, id of product or service
);










