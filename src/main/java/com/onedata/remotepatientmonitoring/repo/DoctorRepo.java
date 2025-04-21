package com.onedata.remotepatientmonitoring.repo;

import com.onedata.remotepatientmonitoring.models.tables.pojos.Doctor;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.onedata.remotepatientmonitoring.models.Tables.DOCTOR;

@Repository
public class DoctorRepo {
    @Autowired
    private DSLContext dsl;

    public String getCurrentUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public List<Doctor> findAllDoctors(){
        return dsl.selectFrom(DOCTOR)
                .fetchInto(Doctor.class);
    }
    public Doctor findDoctorsByID(Integer id){
        return dsl.selectFrom(DOCTOR)
                .where(DOCTOR.ID.eq(id))
                .fetchOneInto(Doctor.class);
    }
    public void createDoctor(Doctor doctor){
         dsl.insertInto(DOCTOR)
                .set(dsl.newRecord(DOCTOR,doctor))
                .returning()
                .fetchOne()
                .into(Doctor.class);
    }
    public int deleteDoctorById(Integer id){
        return dsl.deleteFrom(DOCTOR)
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
