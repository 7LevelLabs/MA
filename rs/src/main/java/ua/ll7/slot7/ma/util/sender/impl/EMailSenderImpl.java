package ua.ll7.slot7.ma.util.sender.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.util.sender.ISender;

import java.util.List;

/**
 * MA
 * Velichko A.
 * 27.12.14 12:42
 */
@Component
@Scope("prototype")
public class EMailSenderImpl implements ISender {

  private final static Logger LOGGER = Logger.getLogger(EMailSenderImpl.class);

  private MailSender mailWorker;

  private String sender;

  private List<String> emailsToInform;

  @Override
  public void send(String subject, String content) {
    try {
      SimpleMailMessage mailMessage = new SimpleMailMessage();
      mailMessage.setFrom(sender);
      mailMessage.setText(content);
      mailMessage.setTo(emailsToInform.toArray(new String[emailsToInform.size()]));
      mailWorker.send(mailMessage);
    } catch (MailException e) {
      LOGGER.error("EMailSenderImpl.send can't send message due to: " + e.getMessage());
    }
  }

  public void setMailWorker(MailSender mailWorker) {
    this.mailWorker = mailWorker;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public void setEmailsToInform(List<String> emailsToInform) {
    this.emailsToInform = emailsToInform;
  }
}
