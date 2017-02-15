<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="title" content="ScoopThemes">
    <meta name="ROBOTS" content="Bootstrap 3 Themes, Responsive Themes, Bootstrap 3 Responsive, Wordpress Themes, Clean Themes, Modern Themes, Flat Themes, Flat UI, UI Design, UX Design, Web design, responsive bootstrap, Jquery Plugins, Free Plugins, Premium Bootstrap themes, Bootstrap 3, Premium Web Templates, Bootstrap Templates, Bootstrap Responsive Templates, Admin, Dashboard, Admin Templates, Admin Responsive, Admin responsive themes">
    <meta name="description" content="Solutions For Web Developers Form ( Web Templates, Web Themes, Jquery Plugins, UX Design.. ) Whatever They Need.">
    <meta name="abstract" content="Solutions For Web Developers Form ( Web Templates, Web Themes, Jquery Plugins, UX Design.. ) Whatever They Need.">
   
    <meta name="author" content="www.scoopthemes.com">
    <meta name="publisher" content="www.scoopthemes.com">
    <meta name="copyright" content="www.scoopthemes.com">
    <meta name="revisit-after" content="2 days">
    <link rel="shortcut icon" href="<spring:url value="/resources/commingsoon/img/favicon.png"/>">
    
    
    <!-- Buttons core css -->
  <link rel="stylesheet" href="<spring:url value="/resources/css/buttons.css"/>">
 
  <!-- Only needed if you want support for dropdown menus -->
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script type="text/javascript" src="<spring:url value="/resources/js/buttons.js"/>"></script>
 
  <!-- Only needed if you want font icons -->
  <link href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.css" rel="stylesheet">
    

    <title>Website Coming Soon</title>

    <!-- Bootstrap -->
    <link href="<spring:url value="/resources/commingsoon/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<spring:url value="/resources/commingsoon/css/font-awesome.css"/>" rel="stylesheet">
    <link href="<spring:url value="/resources/commingsoon/css/bootstrap-theme.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="<spring:url value="/resources/commingsoon/css/animations.css"/>">

    <!-- siimple style -->
    <link href="<spring:url value="/resources/commingsoon/css/style.css"/>" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    <div class="cloud floating">
        <img src="<spring:url value="/resources/commingsoon/img/cloud.png"/>" alt="Nikhil">
    </div>

    <div class="cloud pos1 fliped floating">
        <img src="<spring:url value="/resources/commingsoon/img/cloud.png"/>" alt="Nikhil">
    </div>

    <div class="cloud pos2 floating">
        <img src="<spring:url value="/resources/commingsoon/img/cloud.png"/>" alt="Nikhil">
    </div>

    <div class="cloud pos3 fliped floating">
        <img src="<spring:url value="/resources/commingsoon/img/cloud.png"/>" alt="Nikhil">
    </div>


    <div id="wrapper">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-12 col-lg-12">
					<h2> Online Examination </h2>
                    <br/>
                    <br/>
                    <h2 class="subtitle">We're working hard to launch our website and we'll be ready very soon</h2>
                    <br/>
             
                    <form class="form-inline validate signup" role="form" action="/controllers/websiteisdown.html" method="post">
                        <div class="form-group">
                            <input type="email" class="form-control" name="email" id="exampleInputEmail1" placeholder="Enter your email address">
                        </div>
                        &nbsp;
                         <button class="button button-3d button-pill button-primary button-small"><i class="fa fa-thumbs-up"></i></button>
                        <!-- <input type="submit" name="subscribe" value="Get notified!" class="btn btn-theme"/> -->
                    </form>
                    <br/>
                </div>
                <div class="col-sm-12 align-center">
                    <ul class="social-network social-circle">
                        <li><a href="#" class="icoFacebook" title="Facebook"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li><a href="#" class="icoTwitter" title="Twitter"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li><a href="https://github.com/Nikhil024" class="icoGit" title="Github"><i class="fa fa-github"></i></a>
                        </li>
                        <li><a href="#" class="icoLinkedin" title="Linkedin"><i class="fa fa-linkedin"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-lg-offset-3">
                    <p class="copyright">Copyright &copy; 2016 - <a href="#">Online Examination Team</a>
                    </p>
                </div>
            </div>
        </div>
    </div>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="http://downloads.mailchimp.com/js/jquery.form-n-validate.js"></script>
    <script>
        
$(document).ready( function () {
    $('#wrapper').height($(document).height());
    // I only have one form on the page but you can be more specific if need be.
    var $form = $('form');

    if ( $form.length > 0 ) {
        $('form input[type="submit"]').bind('click', function ( event ) {
            if ( event ) event.preventDefault();
            // validate_input() is a validation function I wrote, you'll have to substitute this with your own.
            if ( $form.validate() ) { register($form); }
        });
    }
});

    </script>

</body>

</html>
