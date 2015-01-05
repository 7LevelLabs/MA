package ua.ll7.slot7.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.model.CategoryForTheUser;
import ua.ll7.slot7.ma.model.Expense;
import ua.ll7.slot7.ma.repository.IExpenseDao;
import ua.ll7.slot7.ma.service.IExpenseService;

import java.util.List;

/**
 * MA
 * Velichko A.
 * 26.12.14 14:17
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ExpenseServiceImpl implements IExpenseService {

	@Autowired
	private IExpenseDao dao;

	@Override
	public void save(Expense toSave) {
		dao.save(toSave);
	}

	@Override
	public List<Expense> findByCategoryPageable(CategoryForTheUser categoryForTheUser, int pageNumber, int pageSize) {
		return dao.findByCategoryForTheUser(categoryForTheUser, new PageRequest((pageNumber - 1), pageSize));
	}
}
