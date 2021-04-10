package com.kchotel.auth;

import java.util.Optional;

public interface ApplicationUserDao {

    public Optional<ApplicationUser> SelectApplicationUserByUsername(String username);
}
