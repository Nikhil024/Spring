package com.thbs.data;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.thbs.Beans.SendEmailBean;

public class Email {
 
 public static void sendemailverf(final SendEmailBean se){
  Properties props = new Properties();
  props.put("mail.smtp.host", se.getSmtphost());
  props.put("mail.smtp.socketFactory.port", se.getPortnumber());
  props.put("mail.smtp.socketFactory.class", se.getSocketfactoryclass());
  props.put("mail.smtp.auth", se.getSmtpauth());
  props.put("mail.smtp.port", se.getPortnumber());
  Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
  
  protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
  
   return new javax.mail.PasswordAuthentication(se.getFrom(),se.getPassword());
  }
   
  });
  try {
   MimeMessage message = new MimeMessage(session);
   message.setFrom(new InternetAddress(se.getFrom()));
   message.addRecipient(Message.RecipientType.TO, new InternetAddress(se.getTo()));
   message.setSubject(se.getSubject());
   message.setContent(se.getContent(),"text/html");
   Transport.send(message);
  
   System.out.println("mail sent succesfully");
  }catch(Exception e) {
	  e.printStackTrace();
   
  }
 }
}