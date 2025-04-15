CREATE TABLE device(
    id  SERIAL PRIMARY KEY ,
    serial_number VARCHAR(100) NOT NULL UNIQUE,
    assigned_patient_id INTEGER UNIQUE,
    FOREIGN KEY(assigned_patient_id) REFERENCES patient(id)
);