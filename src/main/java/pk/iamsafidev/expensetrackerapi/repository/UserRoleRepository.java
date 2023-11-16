package pk.iamsafidev.expensetrackerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.iamsafidev.expensetrackerapi.entity.UserRoles;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoles, Integer> {
    Optional<UserRoles> findByRoleName(String roleName);
}
