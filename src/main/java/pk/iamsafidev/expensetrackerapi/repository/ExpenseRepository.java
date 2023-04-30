package pk.iamsafidev.expensetrackerapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.iamsafidev.expensetrackerapi.entity.Expense;

import java.util.Date;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    //SELECT * from tbl_expenses where category=?
    public Page<Expense> findByCategory(String category, Pageable pageable);

    //SELECT * from tbl_expenses where name LIKE '%keyword'
    public Page<Expense> findByNameContaining(String keyword, Pageable pageable);

    //SELECT * from tbl_expenses where date BETWEEN 'startDate' AND 'endDate'
    public Page<Expense> findByDateBetween(Date startDate, Date endDate, Pageable pageable);

    Page<Expense> findByUserId(Long userId,Pageable page);
}
