package com.onedata.remotepatientmonitoring.repo;

import com.onedata.remotepatientmonitoring.models.tables.pojos.Doctor;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.onedata.remotepatientmonitoring.models.Tables.DOCTOR;


public class DoctorRepo {
    @Autowired
    private DSLContext dsl;

    public List<Doctor> findAllDoctors(){
        return dsl.selectFrom(DOCTOR)
                .fetchInto(Doctor.class);
    }
    public Doctor findDoctorsByID(Integer id){
        return dsl.selectFrom(DOCTOR)
                .where(DOCTOR.ID.eq(id))
                .fetchOneInto(Doctor.class);
    }
    public Doctor createDoctor(Doctor doctor){
        return dsl.insertInto(DOCTOR)
                .set(dsl.newRecord(DOCTOR,doctor))
                .returning()
                .fetchOne()
                .into(Doctor.class);
    }
    public void deleteDoctorById(Integer id){
        dsl.deleteFrom(DOCTOR)
                .where(DOCTOR.ID.eq(id))
                .execute();
    }
    public Doctor updateDoctor(Doctor doctor,Integer id) {
        return dsl.update(DOCTOR)
                .set(DOCTOR.NAME, doctor.getName())
                .set(DOCTOR.SPECIALIZATION, doctor.getSpecialization())
                .where(DOCTOR.ID.eq(id))
                .returning()
                .fetchOne()
                .into(Doctor.class);
    }
}
