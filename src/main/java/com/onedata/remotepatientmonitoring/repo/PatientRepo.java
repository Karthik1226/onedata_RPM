package com.onedata.remotepatientmonitoring.repo;

import com.onedata.remotepatientmonitoring.models.tables.pojos.Patient;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.onedata.remotepatientmonitoring.models.Tables.PATIENT;

@Repository
public class PatientRepo {

    @Autowired
    private DSLContext dsl;

    public List<Patient> findAllPatients(){
        return dsl.selectFrom(PATIENT)
                .fetchInto(Patient.class);
    }
    public Patient findPatientsByID(Integer id){
        return dsl.selectFrom(PATIENT)
                .where(PATIENT.ID.eq(id))
                .fetchOneInto(Patient.class);
    }
    public Patient createPatients(Patient patient){
        return dsl.insertInto(PATIENT)
                .set(dsl.newRecord(PATIENT,patient))
                .returning()
                .fetchOne()
                .into(Patient.class);
    }
    public void deletePatientById(Integer id){
        dsl.deleteFrom(PATIENT)
                .where(PATIENT.ID.eq(id))
                .execute();
    }
    public Patient updatePatients(Patient patient, Integer id){
        return dsl.update(PATIENT)
                .set(PATIENT.NAME, patient.getName())
                .set(PATIENT.AGE,patient.getAge())
                .set(PATIENT.GENDER,patient.getGender())
                .where(PATIENT.ID.eq(id))
                .returning()
                .fetchOne()
                .into(Patient.class);
    }
}
