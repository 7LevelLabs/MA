package ua.ll7.slot7.ma.util.email.impl;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;
import ua.ll7.slot7.ma.util.email.IMailBodyProcessor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * MA
 * Velichko A.
 * 22.01.15 12:58
 */
@Component
public class MailBodyProcessorImpl implements IMailBodyProcessor {

  private VelocityEngine velocityEngine;

  @Value("${emails.registering.token}")
  private String templateRegisteringProcessToken;

  @Value("${emails.welcome}")
  private String templateWelcome;

  @Value("${template.encoding}")
  private String emailEncoding;

  @Override
  public String userRegisteringProcessToken(String nick, String email, String token, Date periodBegin, Date periodEnd) {
    String mailBody;

    Map<String, Object> model = new HashMap<>();

    model.put("nick", nick);
    model.put("email", email);
    model.put("token", token);
    model.put("token_exp_time", periodEnd.toString());

    mailBody = VelocityEngineUtils.mergeTemplateIntoString(
           velocityEngine, templateRegisteringProcessToken, emailEncoding, model);

    return mailBody;
  }

  @Override
  public String userWelcomeAboard(String nick, String email) {
    String mailBody;

    Map<String, Object> model = new HashMap<>();

    model.put("nick", nick);
    model.put("email", email);

    mailBody = VelocityEngineUtils.mergeTemplateIntoString(
           velocityEngine, templateWelcome, emailEncoding, model);

    return mailBody;
  }

  public void setVelocityEngine(VelocityEngine velocityEngine) {
    this.velocityEngine = velocityEngine;
  }
}
