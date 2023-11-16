package pk.iamsafidev.expensetrackerapi.service;

import pk.iamsafidev.expensetrackerapi.entity.UserRoles;

import java.util.Optional;

public interface UserRoleService {

    UserRoles saveUserRoleDetails(UserRoles userRoles);

    public Optional<UserRoles> findByUserRole(String userRole);

}
