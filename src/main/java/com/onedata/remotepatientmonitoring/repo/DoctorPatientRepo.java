package com.onedata.remotepatientmonitoring.repo;


import com.onedata.remotepatientmonitoring.models.tables.pojos.Doctor;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Patient;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.onedata.remotepatientmonitoring.models.Tables.*;


@Repository
public class DoctorPatientRepo {
    @Autowired
    private DSLContext dsl;

    public void assignDoctorToPatient(Integer doctorId,Integer patientId){
        dsl.insertInto(DOCTOR_PATIENT)
                .set(DOCTOR_PATIENT.DOCTOR_ID,doctorId)
                .set(DOCTOR_PATIENT.PATIENT_ID,patientId)
                .onConflictDoNothing()
                .execute();
    }
    public void removeDoctorFromPatient(Integer doctorId,Integer patientId){
        dsl.deleteFrom(DOCTOR_PATIENT)
                .where(DOCTOR_PATIENT.DOCTOR_ID.eq(doctorId))
                .and(DOCTOR_PATIENT.PATIENT_ID.eq(patientId))
                .execute();
    }
    public List<Doctor> getDoctorsByPatientId(Integer patientId){
        return dsl.select()
                .from(DOCTOR)
                .join(DOCTOR_PATIENT)
                .on(DOCTOR.ID.eq(DOCTOR_PATIENT.DOCTOR_ID))
                .where(DOCTOR_PATIENT.PATIENT_ID.eq(patientId))
                .fetchInto(Doctor.class);
    }
    public List<Patient> getPatientsByDoctorId(Integer doctorId){
        return dsl.select()
                .from(PATIENT)
                .join(DOCTOR_PATIENT)
                .on(PATIENT.ID.eq(DOCTOR_PATIENT.PATIENT_ID))
                .where(DOCTOR_PATIENT.DOCTOR_ID.eq(doctorId))
                .fetchInto(Patient.class);
    }
}
