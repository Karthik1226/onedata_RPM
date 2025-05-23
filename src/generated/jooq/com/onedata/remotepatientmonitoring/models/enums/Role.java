/*
 * This file is generated by jOOQ.
 */
package com.onedata.remotepatientmonitoring.models.enums;


import com.onedata.remotepatientmonitoring.models.Public;

import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum Role implements EnumType {

    admin("admin"),

    patient("patient"),

    doctor("doctor");

    private final String literal;

    private Role(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return getSchema().getCatalog();
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public String getName() {
        return "role";
    }

    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Lookup a value of this EnumType by its literal. Returns
     * <code>null</code>, if no such value could be found, see {@link
     * EnumType#lookupLiteral(Class, String)}.
     */
    public static Role lookupLiteral(String literal) {
        return EnumType.lookupLiteral(Role.class, literal);
    }
}
