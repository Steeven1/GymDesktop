
CREATE TABLE employee(
  id serial PRIMARY KEY,
  name VARCHAR(100),
  salary INT,
  job_id INT
);


ALTER TABLE employee ADD FOREIGN KEY(department_id) REFERENCES department(department_id);

--autentication
CREATE TABLE job(
  id serial PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE action(
  id serial PRIMARY KEY,
  name VARCHAR(100)
);


CREATE TABLE policy(
  id serial PRIMARY KEY,
  
);

--clients
CREATE TABLE client(
  id SERIAL PRIMARY KEY
  name VARCHAR(100),
  membership BIGINT --foreign key
);

--temp 
CREATE TABLE membership(
    id SERIAL PRIMARY KEY,    
    name VARCHAR(50),
    price BIGINT, 
    duration BIGINT, --(DURATION ON DAYS)
    started DATE,
    finished DATE,
    created_at DATE
);

CREATE TABLE type_transaction(
  id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE concept_transaction(
  id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE transaction(
  id SERIAL PRIMARY KEY,
  balance BIGINT,
  type_transaction BIGINT , --foreign key
  concept_transaction BIGINT, --foreign key
  created_at DATE,
  observations TEXT(200)

  FOREIGN KEY(type_transaction) REFERENCES type_transaction(id)
  FOREIGN KEY(concept_transaction) REFERENCES concept_transaction(id)
);




