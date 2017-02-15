<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%
   String result;
   
   String to = "nikhil.iy@gmail.com";

   
   String from = "48flowanalysis@gmail.com";

   
   String host = "localhost";

   
   Properties properties = System.getProperties();

  
   properties.setProperty("mail.smtp.host", host);

   
   Session mailSession = Session.getDefaultInstance(properties);

   try{
      
      MimeMessage message = new MimeMessage(mailSession);
      
      message.setFrom(new InternetAddress(from));
     
      message.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(to));
      
      message.setSubject("This is the Subject Line!");
      
      message.setText("This is actual message");
      
      Transport.send(message);
      result = "Sent message successfully....";
   }catch (MessagingException mex) {
      mex.printStackTrace();
      result = "Error: unable to send message....";
   }
%>
<html>
<head>
<title>Send Email using JSP</title>
</head>
<body>
<center>
<h1>Send Email using JSP</h1>
</center>
<p align="center">
<% 
   out.println("Result: " + result + "\n");
%>
</p>
</body>
</html>