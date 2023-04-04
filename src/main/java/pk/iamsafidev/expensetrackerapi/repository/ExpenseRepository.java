package pk.iamsafidev.expensetrackerapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.iamsafidev.expensetrackerapi.entity.Expense;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    //SELECT * from tbl_expenses where category=?
    public Page<Expense> findByCategory(String category, Pageable pageable);

}
