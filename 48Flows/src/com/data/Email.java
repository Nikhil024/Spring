package com.data;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
 
 public static void sendemailverf(String to,int id,String name,String subject){
  Properties props = new Properties();
  props.put("mail.smtp.host", "smtp.gmail.com");
  props.put("mail.smtp.socketFactory.port", "465");
  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.port", "465");
  Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
  
  protected PasswordAuthentication getPasswordAuthentication() {
  
   return new PasswordAuthentication("48flowanalysis@gmail.com","48Months");
  }
   
  });
  try {
   MimeMessage message = new MimeMessage(session);
   message.setFrom(new InternetAddress("48flowanalysis@gmail.com"));
   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
   //message.setSubject("Hello "+name);
   message.setSubject(subject);
   message.setContent(
		   "<!DOCTYPE html>\n"
				   +"<html lang='en' class='no-js'>\n"
				   	+"<head>\n"
				   		+"<meta charset='UTF-8'/>\n"
				   		+"<meta http-equiv='X-UA-Compatible' content='IE=edge'> \n"
				   		+"<meta name='viewport' content='width=device-width, initial-scale=1'> \n"
				   		+"<title>Welcome</title>\n"
				   		+"<meta name='description' content='Examples for creative website header animations using Canvas and JavaScript'/>\n"
				   		+"<meta name='keywords' content='header, canvas, animated, creative, inspiration, javascript'/>\n"
				   		+"<meta name='author' content='Codrops'/>\n"
				   		+"<link rel='shortcut icon' href='../favicon.ico'>\n"
				   		+"<link rel='stylesheet' type='text/css' href='css/normalize.css' />\n"
				   		+"<link rel='stylesheet' type='text/css' href='css/demo.css'/>\n"
				   		+"<link rel='stylesheet' type='text/css' href='css/component.css'/>\n"
				   		+"<link href='http://fonts.googleapis.com/css?family=Raleway:200,400,800' rel='stylesheet' type='text/css'>\n"
				   	+"</head>\n"
				   	+"<body>\n"
				   		+"<div class='container demo-1'>\n"
				   			+"<div class='content'>\n"
				   				+"<div id='large-header' class='large-header'>\n"
				   					+"<canvas id='demo-canvas'></canvas>\n"

				   					+"<h1 class='main-title'><span class='thin'> Welcome to </span> 48Flow Analaysis<br/><span class='thin'>Please click </span><a href='http://172.30.55.7:1234/48Flows/email/verification/"+id+"'>here</a><span class='thin'> to verify Your email </span></h1>\n"
				   				+"</div>\n"
				   		+"</div>\n"
				   		
				   		+"<script src='js/TweenLite.min.js'></script>\n"
				   		+"<script src='js/EasePack.min.js'></script>\n"
				   		+"<script src='js/rAF.js'></script>\n"
				   		+"<script src='js/demo-1.js'></script>\n"
				   		
				   	+"</body>\n"
				   +"</html>",
          "text/html");
   Transport.send(message);
  
   System.out.println("mail sent succesfully");
  }catch(Exception e) {
	  e.printStackTrace();
   
  }
 }

 
 
 public static void sendemail(String to,String subject,String name){
	  Properties props = new Properties();
	  props.put("mail.smtp.host", "smtp.gmail.com");
	  props.put("mail.smtp.socketFactory.port", "465");
	  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	  props.put("mail.smtp.auth", "true");
	  props.put("mail.smtp.port", "465");
	  Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
	  
	  protected PasswordAuthentication getPasswordAuthentication() {
	  
	   return new PasswordAuthentication("48flowanalysis@gmail.com","48Months");
	  }
	   
	  });
	  try {
	   MimeMessage message = new MimeMessage(session);
	   message.setFrom(new InternetAddress("48flowanalysis@gmail.com"));
	   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	   message.setSubject(subject);
	   message.setContent("<!doctype html>"+
			   "<html>"+
			   "<head>"+
			   "<meta charset='utf-8'>"+
			   "<title></title>"+
			   "</head>"+
			   "<body style='font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; background-color:#f0f2ea; margin:0; padding:0; color:#333333;'>"+
			   "<table width='100%' bgcolor='#f0f2ea' cellpadding='0' cellspacing='0' border='0'>"+
			   "    <tbody>"+
			   "        <tr>"+
			   "            <td style='padding:40px 0;'>"+
			   "                <!-- begin main block -->"+
			   "                <table cellpadding='0' cellspacing='0' width='608' border='0' align='center'>"+
			   "                    <tbody>"+
			   "                        <tr>"+
			   "                            <td>"+
			   "                                <a href='http://pixelbuddha.net/' style='display:block; width:407px; height:100px; margin:0 auto 30px;'>"+
			   "                                    <img src='http://cl.ly/image/1r3y0x190q0r/logo.png' width='407' height='100' alt='Nikhil' style='display:block; border:0; margin:0;'>"+
			   "                                </a>"+
			   "                                 <p style='margin:0 0 36px; text-align:center; font-size:14px; line-height:20px; text-transform:uppercase; color:#626658;'>"+
								    "Hi "+name+"<br/>"+
                                    "Welcome to 48Flows<br/>"+
								    "We will inform you once the Site is up..!"+
                                "</p>"+
			   "                                <!-- begin wrapper -->"+
			   "                                <table cellpadding='0' cellspacing='0' border='0' width='100%'>"+
			   "                                    <tbody>"+
			   "                                        <tr>"+
			   "                                            <td width='8' height='4' colspan='2' style='background:url(http://demo.artlance.ru/email/shadow-top-left.png) no-repeat 100% 100%;'><p style='margin:0; font-size:1px; line-height:1px;'>&nbsp;</p></td>"+
			   "                                            <td height='4' style='background:url(http://demo.artlance.ru/email/shadow-top-center.png) repeat-x 0 100%;'><p style='margin:0; font-size:1px; line-height:1px;'>&nbsp;</p></td>"+
			   "                                            <td width='8' height='4' colspan='2' style='background:url(http://demo.artlance.ru/email/shadow-top-right.png) no-repeat 0 100%;'><p style='margin:0; font-size:1px; line-height:1px;'>&nbsp;</p></td>"+
			   "                                        </tr>"+
			   "                                        <tr>"+
			   "                                            <td width='4' height='4' style='background:url(http://demo.artlance.ru/email/shadow-left-top.png) no-repeat 100% 0;'><p style='margin:0; font-size:1px; line-height:1px;'>&nbsp;</p></td>"+
			   "                                            <td colspan='3' rowspan='3' bgcolor='#FFFFFF' style='padding:0 0 30px;'>"+
			   "                                                <!-- begin content -->"+
			   "                                                <img src='http://cl.ly/image/1n1x3x0C3U00/header.jpg' width='600' height='400' alt='summer‘s coming trimm your sheeps' style='display:block; border:0; margin:0 0 44px; background:#eeeeee;'>"+
			   "                                                <!-- /end articles -->"+
			   "                                                <p style='margin:0; border-top:2px solid #e5e5e5; font-size:5px; line-height:5px; margin:0 30px 29px;'>&nbsp;</p>"+
			   "                                                <!-- end content --> "+
			   "                                            </td>"+
			   "                                            <td width='4' height='4' style='background:url(http://demo.artlance.ru/email/shadow-right-top.png) no-repeat 0 0;'><p style='margin:0; font-size:1px; line-height:1px;'>&nbsp;</p></td>"+
			   "                                        </tr>"+
			   "                                        <tr>"+
			   "                                            <td width='4' style='background:url(http://demo.artlance.ru/email/shadow-left-center.png) repeat-y 100% 0;'><p style='margin:0; font-size:1px; line-height:1px;'>&nbsp;</p></td>"+
			   "                                            <td width='4' style='background:url(http://demo.artlance.ru/email/shadow-right-center.png) repeat-y 0 0;'><p style='margin:0; font-size:1px; line-height:1px;'>&nbsp;</p></td>"+
			   "                                        </tr>"+
			   "                                        <tr> "+
			   "                                            <td width='4' height='4' style='background:url(http://demo.artlance.ru/email/shadow-left-bottom.png) repeat-y 100% 100%;'><p style='margin:0; font-size:1px; line-height:1px;'>&nbsp;</p></td>"+
			   "                                            <td width='4' height='4' style='background:url(http://demo.artlance.ru/email/shadow-right-bottom.png) repeat-y 0 100%;'><p style='margin:0; font-size:1px; line-height:1px;'>&nbsp;</p></td>"+
			   "                                        </tr>"+
			   "                                        <tr>"+
			   "                                            <td width='4' height='4' style='background:url(http://demo.artlance.ru/email/shadow-bottom-corner-left.png) no-repeat 100% 0;'><p style='margin:0; font-size:1px; line-height:1px;'>&nbsp;</p></td>"+
			   "                                            <td width='4' height='4' style='background:url(http://demo.artlance.ru/email/shadow-bottom-left.png) no-repeat 100% 0;'><p style='margin:0; font-size:1px; line-height:1px;'>&nbsp;</p></td>"+
			   "                                            <td height='4' style='background:url(http://demo.artlance.ru/email/shadow-bottom-center.png) repeat-x 0 0;'><p style='margin:0; font-size:1px; line-height:1px;'>&nbsp;</p></td>"+
			   "                                            <td width='4' height='4' style='background:url(http://demo.artlance.ru/email/shadow-bottom-right.png) no-repeat 0 0;'><p style='margin:0; font-size:1px; line-height:1px;'>&nbsp;</p></td>"+
			   "                                            <td width='4' height='4' style='background:url(http://demo.artlance.ru/email/shadow-bottom-corner-right.png) no-repeat 0 0;'><p style='margin:0; font-size:1px; line-height:1px;'>&nbsp;</p></td>"+
			   "                                        </tr>"+
			   "                                    </tbody>"+
			   "                                </table>"+
			   "                                <!-- end wrapper-->"+
			   "                                <p style='margin:0; padding:34px 0 0; text-align:center; font-size:11px; line-height:13px; color:#333333;'>"+
			   "                                    Don‘t want to recieve further emails? You can unsibscribe <a href='#' style='color:#333333; text-decoration:underline;'>here</a>"+
			   "                                </p>"+
			   "                            </td>"+
			   "                        </tr>"+
			   "                    </tbody>"+
			   "                </table>"+
			   "                <!-- end main block -->"+
			   "            </td>"+
			   "        </tr>"+
			   "    </tbody>"+
			   "</table>"+
			   "</body>"+
			   "</html>", "text/html");
			   
	   Transport.send(message);
	  
	   System.out.println("mail sent succesfully");
	  }catch(Exception e) {
		  e.printStackTrace();
	   
	  }
	 }
 
 
 
}


/*class demo{
	public static void main(String args[]){
		Email.sendemail("nikhil_mohandas@thbs.com", "hello","Ashok");
	}
}*/