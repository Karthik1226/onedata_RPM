/*
 * This file is generated by jOOQ.
 */
package com.onedata.remotepatientmonitoring.models.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DoctorPatient implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer doctorId;
    private Integer patientId;

    public DoctorPatient() {}

    public DoctorPatient(DoctorPatient value) {
        this.doctorId = value.doctorId;
        this.patientId = value.patientId;
    }

    public DoctorPatient(
        Integer doctorId,
        Integer patientId
    ) {
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    /**
     * Getter for <code>public.doctor_patient.doctor_id</code>.
     */
    public Integer getDoctorId() {
        return this.doctorId;
    }

    /**
     * Setter for <code>public.doctor_patient.doctor_id</code>.
     */
    public DoctorPatient setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    /**
     * Getter for <code>public.doctor_patient.patient_id</code>.
     */
    public Integer getPatientId() {
        return this.patientId;
    }

    /**
     * Setter for <code>public.doctor_patient.patient_id</code>.
     */
    public DoctorPatient setPatientId(Integer patientId) {
        this.patientId = patientId;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final DoctorPatient other = (DoctorPatient) obj;
        if (this.doctorId == null) {
            if (other.doctorId != null)
                return false;
        }
        else if (!this.doctorId.equals(other.doctorId))
            return false;
        if (this.patientId == null) {
            if (other.patientId != null)
                return false;
        }
        else if (!this.patientId.equals(other.patientId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.doctorId == null) ? 0 : this.doctorId.hashCode());
        result = prime * result + ((this.patientId == null) ? 0 : this.patientId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DoctorPatient (");

        sb.append(doctorId);
        sb.append(", ").append(patientId);

        sb.append(")");
        return sb.toString();
    }
}
