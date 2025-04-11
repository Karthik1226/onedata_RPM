/*
 * This file is generated by jOOQ.
 */
package com.onedata.remotepatientmonitoring.models.tables;


import com.onedata.remotepatientmonitoring.models.Keys;
import com.onedata.remotepatientmonitoring.models.Public;
import com.onedata.remotepatientmonitoring.models.tables.DoctorPatient.DoctorPatientPath;
import com.onedata.remotepatientmonitoring.models.tables.Patient.PatientPath;
import com.onedata.remotepatientmonitoring.models.tables.records.DoctorRecord;

import java.util.Collection;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Doctor extends TableImpl<DoctorRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.doctor</code>
     */
    public static final Doctor DOCTOR = new Doctor();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DoctorRecord> getRecordType() {
        return DoctorRecord.class;
    }

    /**
     * The column <code>public.doctor.id</code>.
     */
    public final TableField<DoctorRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.doctor.name</code>.
     */
    public final TableField<DoctorRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.doctor.specialization</code>.
     */
    public final TableField<DoctorRecord, String> SPECIALIZATION = createField(DSL.name("specialization"), SQLDataType.VARCHAR(100).nullable(false), this, "");

    private Doctor(Name alias, Table<DoctorRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Doctor(Name alias, Table<DoctorRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.doctor</code> table reference
     */
    public Doctor(String alias) {
        this(DSL.name(alias), DOCTOR);
    }

    /**
     * Create an aliased <code>public.doctor</code> table reference
     */
    public Doctor(Name alias) {
        this(alias, DOCTOR);
    }

    /**
     * Create a <code>public.doctor</code> table reference
     */
    public Doctor() {
        this(DSL.name("doctor"), null);
    }

    public <O extends Record> Doctor(Table<O> path, ForeignKey<O, DoctorRecord> childPath, InverseForeignKey<O, DoctorRecord> parentPath) {
        super(path, childPath, parentPath, DOCTOR);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class DoctorPath extends Doctor implements Path<DoctorRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> DoctorPath(Table<O> path, ForeignKey<O, DoctorRecord> childPath, InverseForeignKey<O, DoctorRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private DoctorPath(Name alias, Table<DoctorRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public DoctorPath as(String alias) {
            return new DoctorPath(DSL.name(alias), this);
        }

        @Override
        public DoctorPath as(Name alias) {
            return new DoctorPath(alias, this);
        }

        @Override
        public DoctorPath as(Table<?> alias) {
            return new DoctorPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<DoctorRecord, Integer> getIdentity() {
        return (Identity<DoctorRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<DoctorRecord> getPrimaryKey() {
        return Keys.DOCTOR_PKEY;
    }

    private transient DoctorPatientPath _doctorPatient;

    /**
     * Get the implicit to-many join path to the
     * <code>public.doctor_patient</code> table
     */
    public DoctorPatientPath doctorPatient() {
        if (_doctorPatient == null)
            _doctorPatient = new DoctorPatientPath(this, null, Keys.DOCTOR_PATIENT__DOCTOR_PATIENT_DOCTOR_ID_FKEY.getInverseKey());

        return _doctorPatient;
    }

    /**
     * Get the implicit many-to-many join path to the
     * <code>public.patient</code> table
     */
    public PatientPath patient() {
        return doctorPatient().patient();
    }

    @Override
    public Doctor as(String alias) {
        return new Doctor(DSL.name(alias), this);
    }

    @Override
    public Doctor as(Name alias) {
        return new Doctor(alias, this);
    }

    @Override
    public Doctor as(Table<?> alias) {
        return new Doctor(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Doctor rename(String name) {
        return new Doctor(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Doctor rename(Name name) {
        return new Doctor(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Doctor rename(Table<?> name) {
        return new Doctor(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Doctor where(Condition condition) {
        return new Doctor(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Doctor where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Doctor where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Doctor where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Doctor where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Doctor where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Doctor where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Doctor where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Doctor whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Doctor whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
