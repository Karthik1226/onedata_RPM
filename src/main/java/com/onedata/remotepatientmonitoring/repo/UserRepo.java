package com.onedata.remotepatientmonitoring.repo;

import com.onedata.remotepatientmonitoring.dto.user.UserResponse;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Users;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.onedata.remotepatientmonitoring.models.tables.Users.USERS;

@Repository
public class UserRepo {

    @Autowired
    private DSLContext dsl;

    public Users findByUsername(String username) {
        return dsl.selectFrom(USERS)
                .where(USERS.USERNAME.eq(username))
                .fetchOneInto(Users.class);
    }

    public Users save(Users users) {
        return dsl.insertInto(USERS)
                .set(USERS.USERNAME, users.getUsername())
                .set(USERS.PASSWORD, users.getPassword())
                .set(USERS.ROLES, users.getRoles())
                .returning()
                .fetchOne()
                .into(Users.class);

    }
}
