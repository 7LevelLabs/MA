package ua.ll7.slot7.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ll7.slot7.ma.model.Expense;

/**
 * @author Alex Velichko
 *         09.06.14 : 17:37
 */

/**
 * Expense-specific DAO-staff
 */
public interface IExpenseDao extends JpaRepository<Expense, Long> {

}
