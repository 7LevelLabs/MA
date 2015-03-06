package ua.ll7.slot7.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.model.EMailTask;
import ua.ll7.slot7.ma.repository.IEMailTaskRepository;
import ua.ll7.slot7.ma.service.IEMailTaskService;

/**
 * MA
 * Velichko A.
 * 24.02.15 14:24
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class EMailTaskServiceImpl implements IEMailTaskService {

  @Autowired
  private IEMailTaskRepository repository;

  @Override
  public void save(EMailTask toSave) {
    repository.save(toSave);
  }
}
