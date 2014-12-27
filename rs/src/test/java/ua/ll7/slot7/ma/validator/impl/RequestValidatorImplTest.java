package ua.ll7.slot7.ma.validator.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot7.ma.data.request.UserRegisterRequest;
import ua.ll7.slot7.ma.exception.AppValidationException;
import ua.ll7.slot7.ma.validator.IRequestValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigIT.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class RequestValidatorImplTest {

  @Autowired
  private IRequestValidator requestValidator;

  @Test(expected = AppValidationException.class)
  public void testValidateInvalidRequest() throws Exception {

    UserRegisterRequest request = new UserRegisterRequest();
    request.setData1("");
    request.setData2("");

    requestValidator.validate(request);

  }
}