package ua.ll7.slot7.ma.service;

import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.Expense;

import java.util.List;

/**
 * MA
 * Velichko A.
 * 26.12.14 14:14
 */
public interface IExpenseService {

  public void save(Expense toSave);

  public List<Expense> findByCategoryPageable(CategoryForTheUser categoryForTheUser, int pageNumber, int pageSize);

}
