

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
CREATE TABLE duration(
  id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE membership(
  id SERIAL PRIMARY KEY,    
  name VARCHAR(50),
  price BIGINT, 
  duration_id BIGINT, --FK  
  month INT,
  week INT,
  days INT,
  hour_start TIME,
  hour_end TIME,
  created_at DATETIME,
  FOREIGN KEY (duration_id) REFERENCES duration(id)  
);

CREATE TABLE state_class(
  id SERIAL PRIMARY KEY,    
  name VARCHAR(50)
);

CREATE TABLE class(
  id SERIAL PRIMARY KEY,    
  name VARCHAR(50),
  description VARCHAR(100),
  quote INT,
  state_class_id INT, --fk
  monday VARCHAR(50),
  tuesday VARCHAR(50),
  wednesday VARCHAR(50),
  thursday VARCHAR(50),
  friday VARCHAR(50),
  saturday VARCHAR(50),
  sunday VARCHAR(50),
  hour_start TIME,
  hour_end TIME,
  created_at DATETIME  
);

--clients
CREATE TABLE client(
  id SERIAL PRIMARY KEY
  name VARCHAR(100),
  ci CHAR(10)
);

CREATE TABLE class_client(
  class_id INT, --fk
  client_id INT, --fk
  FOREIGN KEY (client_id) REFERENCES client(id),
  FOREIGN KEY (class_id) REFERENCES class(id)
);

CREATE TABLE membership_client(
  membership_id INT,
  client_id INT,
  FOREIGN KEY (client_id) REFERENCES client(id),
  FOREIGN KEY (membership_id) REFERENCES membership(id)
);

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
    created_at DATETIME,
);


--billing

CREATE TABLE service(
  id UUID PRIMARY KEY,
  name VARCHAR(100),
);

CREATE TABLE billing(
  id SERIAL PRIMARY KEY,
  client_id BIGINT, -- foreign key
  total_amount BIGINT,
  created_at DATETIME,
  FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE item_type(
  id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);


CREATE TABLE billing_item(
  id SERIAL PRIMARY KEY,
  billing_id INT, --fk
  item_id INT, --fk, id of product or service
  item_type_id INT, --fk 
  qty BIGINT,
  price BIGINT,
  total_line BIGINT,
  created_at DATETIME,
  FOREIGN KEY (billing_id) REFERENCES billing(id)
  FOREIGN KEY (item_id) REFERENCES product(id)
  FOREIGN KEY (item_id) REFERENCES service(id)
  FOREIGN KEY (item_type_id) REFERENCES item_type(id)
);

--shopping
CREATE TABLE provider(
  id SERIAL PRIMARY KEY,    
  name VARCHAR(50),
  ruc CHAR(10),
  address VARCHAR(100),
  telephone VARCHAR(100),
  movil CHAR(10),
  email VARCHAR(100),
  created_at DATETIME
);

CREATE TABLE shopping(
  id SERIAL PRIMARY KEY,
  provider_id BIGINT, -- foreign key
  total_amount BIGINT,
  created_at DATETIME,
  FOREIGN KEY (provider_id) REFERENCES provider(id)
);

CREATE TABLE shopping_item(
  id SERIAL PRIMARY KEY,
  shopping_id INT, --fk
  item_id INT, --fk, id of product or service
  qty BIGINT,
  price BIGINT,
  total_line BIGINT,
  created_at DATETIME,
  FOREIGN KEY (shopping_id) REFERENCES shopping(id)
  FOREIGN KEY (item_id) REFERENCES product(id)
  FOREIGN KEY (item_id) REFERENCES service(id)
);












