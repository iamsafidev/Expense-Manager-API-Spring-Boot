package pk.iamsafidev.expensetrackerapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.iamsafidev.expensetrackerapi.entity.UserRoles;
import pk.iamsafidev.expensetrackerapi.repository.UserRoleRepository;
import pk.iamsafidev.expensetrackerapi.service.UserRoleService;

import java.util.Optional;

@Service
public class UserRoleImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRoles saveUserRoleDetails(UserRoles userRoles) {
        return userRoleRepository.save(userRoles);
    }
    @Override
    public Optional<UserRoles> findByUserRole(String userRole){
        return userRoleRepository.findByRoleName(userRole);
    }
}