<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Credentials</title>
<link rel="stylesheet" href="<spring:url value="/resources/css/buttons.css"/>"/>
<script src="<spring:url value="/resources/js/jquery.min.js"/>"/>
<script type="text/javascript" src="<spring:url value="/resources/js/buttons.js"/>"/>
<link href="<spring:url value="/resources/css/font-awesome.css"/>" rel="stylesheet">
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-theme.min.css"/>">
<script src="<spring:url value="/resources/js/jquery.min.js"/>"></script>
<link rel="stylesheet" href="https://www.google.com/fonts#QuickUsePlace:quickUse/Family:Lobster" type="text/css">
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/nik.css"/>"/>
<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
<style type="text/css">
    .bs-example{
    	margin: 20px;
    }
</style>
</head>

<% if (session.getAttribute("name")==null){
	%><center><h1>You need to be Logged in to visit Credentials page..<br/>Redirecting to Login Page..<br/>Please wait...! <h1></center>
	<script>
	  setTimeout(function() {
	      document.location = "<spring:url value="/login"/>";
	  }, 3000); // 
	</script>
	<%
}
else
{
%>
<body>
<script src="<spring:url value="/resources/js/clipboard.min.js"/>"></script>
<script>
    var clipboard = new Clipboard('.button');

    clipboard.on('success', function(e) {
        console.log(e);
    });

    clipboard.on('error', function(e) {
        console.log(e);
    });
    
    </script>
    <script type="text/javascript" language="javascript">
    function RunFile() {
    WshShell = new ActiveXObject("WScript.Shell");
    WshShell.Run("\\galaxy\Open Source\Putty\PUTTY.exe", 1, false);
    }
</script>
<jsp:include page="logoutheader.jsp"/>
<center><h1><b><u>Credentials Page</u></b></h1></center>
<div class="bs-example">
<h3><u>Common</u></h3>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Row</th>
                <th>Name</th>
                <th>Url</th>
                <th>UserName</th>
                <th>Copy Username</th>
                <th>Password</th>
                <th>Copy Password</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>GitHub</td>
                <td><a href="${github_url}" target="_blank"> ${github_url}</a></td>
                <td id="gitu">${github_username}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#gitu"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
                <td id ="git">${github_password}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#git"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
            </tr>
            <tr>
                <td>2</td>
                <td>Confluence</td>
                <td><a href="${confluenceurl}" target="_blank">${confluenceurl}</a></td>
                <td id="confu">${confluence_username}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#confu"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
                <td id="conf">${confluence_password}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#conf"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
            </tr>
            <tr>
                <td>3</td>
                <td>Jira</td>
                <td><a href="${jira_url}" target="_blank">${jira_url}</a></td>
                <td id="jirau">${jira_username}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#jirau"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
                <td id="jira">${jira_password}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#jira"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
            </tr>
              </tbody>
    </table>
    
    <!--  staging Credentials -->
    <h3><u>Staging</u></h3>
   <h6 style="float: left"><b>FrontEnd Staging Log Location</b> : /var/log/panda/web.log</h6><h6 style="float: right"><b>BackEnd Staging Log Location</b> : /var/log/panda/panda.log</h6></p>  

    <table class="table table-hover">
        <thead>
            <tr>
                <th>Row</th>
                <th>Name</th>
                <th>Url</th>
                <th>UserName</th>
                <th>Copy Username</th>
                <th>Password</th>
                <th>Copy Password</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>Staging Jbpm Console</td>
                <td><a href="${jbpm_url}" target="_blank">${jbpm_url}</a></td>
                <td id="jbpmu">${jbpm_username}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#jbpmu"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
                <td id="jbpm">${jbpm_password}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#jbpm"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
            </tr>
            <tr>
                <td>2</td>
                <td>Staging CS Tool</td>
                <td><a href="${cs_url}" target="_blank">${cs_url}</a></td>
                <td id="csu">${cs_username}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#csu"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
                <td id="cs">${cs_password}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#cs"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
            </tr>
            <tr>
                <td>3</td>
                <td>Staging Support Console</td>
                <td><a href="${sup_url}" target="_blank">${sup_url}</a></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td>4</td>
                <td>Staging Konakart</td>
                <td><a href="${konakart_url}" target="_blank">${konakart_url}</a></td>
                <td id="konau">${konakart_username}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#konau"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
                <td id="kona">${konakart_password}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#kona"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
            </tr>
            <tr>
                <td>5</td>
                <td>Staging Portal DB</td>
                <td>${portal_db_ip}</td>
                <td id="portu">${portal_db_username}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#portu"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
                <td id="port">${portal_db_password}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#port"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
            </tr>
             <tr>
                <td>6</td>
                <td>Staging Konakart DB</td>
                <td>${konakart_db_url}</td>
                <td id="kdbu">${konakart_db_username}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#kdbu"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
                <td id="kdb">${konakart_db_password}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#kdb"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
            </tr>
            <tr>
                <td>7</td>
                <td>Staging Jpbm DB</td>
                <td>${jbpm_db_url}</td>
                <td id="jdbu">${jbpm_db_username}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#jdbu"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
                <td id="jdb">${jbpm_db_password}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#jdb"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
            </tr>
            <tr>
                <td>8</td>
                <td>Staging Database Server</td>
                <td>${db_server_url}</td>
                <td id="sdbu">${db_server_username}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#sdbu"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
                <td id="sdb">${db_server_password}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#sdb"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
            </tr>
            <tr>
                <td>9</td>
                <td>Staging Batch Server</td>
                <td>${bs_url}</td>
                <td id="sbsu">${bs_username}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#sbsu"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
                <td id="sbs">${bs_password}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#sbs"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
            </tr>
            <tr>
                <td>10</td>
                <td>Staging FrontEnd Server</td>
                <td>${fe_url}</td>
                <td id="sfsu">${fe_username}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#sfsu"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
                <td id="sfs">${fe_password}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#sfs"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
            </tr>
           <tr>
                <td>11</td>
                <td>Staging BackEnd Server</td>
                <td>${be_url}</td>
                <td id="sbesu">${be_username}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#sbesu"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
                <td id="sbes">${be_password}</td>
                <td><center><button class="button button-3d button-box button-tiny" data-clipboard-action="copy" data-clipboard-target="#sbes"><i class="fa fa-thumbs-up">Copy</i></button></center></td>
            </tr>
            
              </tbody>
    </table>
       
            <!-- Prod Credentials -->
            
            
      
</div>
</body>
</html>
<%} %>                               		