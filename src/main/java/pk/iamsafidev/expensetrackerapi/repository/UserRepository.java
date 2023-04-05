package pk.iamsafidev.expensetrackerapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.iamsafidev.expensetrackerapi.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
