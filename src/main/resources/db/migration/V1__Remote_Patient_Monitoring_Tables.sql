CREATE TABLE patient(
    id  SERIAL PRIMARY KEY ,
    name VARCHAR(100) NOT NULL,
    age INTEGER NOT NULL,
    gender VARCHAR(50) NOT NULL
);
CREATE TABLE doctor(
    id  SERIAL PRIMARY KEY ,
    name VARCHAR(100) NOT NULL,
    specialization VARCHAR(100) NOT NULL
);
CREATE TABLE doctor_patient(
    doctor_id  INTEGER NOT NULL,
    patient_id INTEGER NOT NULL,
    PRIMARY KEY(doctor_id,patient_id),
    FOREIGN KEY(doctor_id) REFERENCES doctor(id) ON DELETE CASCADE,
    FOREIGN KEY(patient_id) REFERENCES patient(id) ON DELETE CASCADE
);