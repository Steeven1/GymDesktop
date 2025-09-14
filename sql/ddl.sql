CREATE TABLE employee(
  id INT PRIMARY KEY,
  name VARCHAR(100),
  salary INT,
  job_id INT
);


ALTER TABLE employee ADD FOREIGN KEY(department_id) REFERENCES department(department_id);

CREATE TABLE job(
  id INT,
  name VARCHAR(100)
);

CREATE TABLE action(
  id INT,
  name VARCHAR(100)
);


CREATE TABLE policy(
  id INT PRIMARY KEY,
  
);
