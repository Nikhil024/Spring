<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="Header.jsp"></jsp:include>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.css"
	rel="stylesheet" />	
	
	<link
	href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.min.css"
	rel="stylesheet" />	
	
	
	
<script
		src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.common.js">
		</script>
		
		
		<script
		src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.common.min.js">
		</script>
		
		<script
		src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.js">
		</script>
		
		<script
		src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.min.css">
		</script>
		
		
		<script
		src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.min.js">
		</script>
		<!-- <script>
		function showSwal(type){
	    	if(type == 'basic'){
	    		swal.queue([{
	    			  title: 'Your public IP',
	    			  confirmButtonText: 'Show my public IP',
	    			  text:
	    			    'Your public IP will be received ' +
	    			    'via AJAX request',
	    			  showLoaderOnConfirm: true,
	    			  preConfirm: function () {
	    			    return new Promise(function (resolve) {
	    			      $.get('https://api.ipify.org?format=json')
	    			        .done(function (data) {
	    			          swal.insertQueueStep(data.ip)
	    			          resolve()
	    			        })
	    			    })
	    			  }
	    			}])

	    	}else if(type == 'password-notification'){
	    		swal({
	    			  title: 'Your\'e password shold be as follows',
	    			  html: $('<div>')
	    			    .addClass('some-class')
	    			    .text('jQuery is everywhere.'),
	    			  animation: false,
	    			  customClass: 'animated tada'
	    			})

	    	}else if(type == 'photo-upload'){
	    		swal({
	    			  title: 'Select a photo',
	    			  text: "and upload as profile pic",
	    			  type: 'question',
	    			  showCancelButton: true,
	    			  confirmButtonColor: '#3085d6',
	    			  cancelButtonColor: '#d33',
	    			  confirmButtonText: 'Yes, Browse',
	    			  cancelButtonText: 'No, cancel!',
	    			  confirmButtonClass: 'btn btn-success',
	    			  cancelButtonClass: 'btn btn-danger',
	    			  buttonsStyling: false
	    			}).then(function () {
	    				swal({
	    					  title: 'Select image',
	    					  input: 'file',
	    					  inputAttributes: {
	    					    accept: 'image/*'
	    					  }
	    					}).then(function(){
	    			               window.location.href = 'savefiles.html';
	    			           })
	    			}, function (dismiss) {
	    			  // dismiss can be 'cancel', 'overlay',
	    			  // 'close', and 'timer'
	    			  if (dismiss === 'cancel') {
	    			    swal(
	    			      'Cancelled',
	    			      'Good to hear! :)',
	    			      'error'
	    			    )
	    			  }
	    			})

	    	}else if(type == 'success-message'){
	        	swal("Good job!", "You clicked the button!", "success")

	    	}else if(type == 'warning-message-and-confirmation'){
	        	swal({  title: "Are you sure?",
	            	    text: "You will not be able to recover this imaginary file!",
	            	    type: "warning",
	                    showCancelButton: true,
	                    confirmButtonClass: "btn btn-info btn-fill",
	                    confirmButtonText: "Yes, delete it!",
	                    cancelButtonClass: "btn btn-danger btn-fill",
	                    closeOnConfirm: false,
	                },function(){
	                    swal("Deleted!", "Your imaginary file has been deleted.", "success");
	                });

	    	}else if(type == 'warning-message-and-cancel'){
	        	swal({  title: "Are you sure?",
	            	    text: "You will not be able to recover this imaginary file!",
	            	    type: "warning",
	            	    showCancelButton: true,
	            	    confirmButtonText: "Yes, delete it!",
	            	    cancelButtonText: "No, cancel plx!",
	            	    closeOnConfirm: false,
	            	    closeOnCancel: false
	                },function(isConfirm){
	                    if (isConfirm){
	                        swal("Deleted!", "Your imaginary file has been deleted.", "success");
	                    }else{
	                        swal("Cancelled", "Your imaginary file is safe :)", "error");
	                    }
	                });

	    	}else if(type == 'custom-html'){
	        	swal({  title: 'HTML example',
	                    html:
	                        'You can use <b>bold text</b>, ' +
	                        '<a href="http://github.com">links</a> ' +
	                        'and other HTML tags'
	                });

	    	}else if(type == 'auto-close'){
	        	swal({ title: "Auto close alert!",
	            	   text: "I will close in 2 seconds.",
	            	   timer: 2000,
	            	   showConfirmButton: false
	                });
	    	} else if(type == 'input-field'){
	            swal({
	                  title: 'Input something',
	                  html: '<p><input id="input-field" class="form-control">',
	                  showCancelButton: true,
	                  closeOnConfirm: false,
	                  allowOutsideClick: false
	                },
	                function() {
	                  swal({
	                    html:
	                      'You entered: <strong>' +
	                      $('#input-field').val() +
	                      '</strong>'
	                  });
	                })
	        }
		}
		</script> -->
</head>
<body>

	<div class="wrapper">
		<div class="sidebar" data-color="orange"
			data-image="<spring:url value="/resources/img/${bgimagename}"/>">
			<!--

            Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
            Tip 2: you can also add an image using data-image tag

        -->


			<div class="sidebar-wrapper">

				<div class="user">
				<a onclick="showSwal('photo-upload')">
					<div class="photo">
								
						<c:if test="${nopicture == 'YES'}">
							<img
								src="<spring:url value="/resources/img/${userprofileimage}"/>" />
						</c:if>

						<c:if test="${picture == 'YES'}">
							<img
								src="<spring:url value="/images/profilePicture/${userprofileimage}"/>" />
						</c:if>



					</div>
					</a>
					<div class="info">
						<a data-toggle="collapse" href="#collapseExample"
							class="collapsed"> ${username} <b class="caret"></b>
						</a>
						<div class="collapse" id="collapseExample">
							<ul class="nav">
								<li><a href="#">My Profile</a></li>
								<li><a href="#">Edit Profile</a></li>
								<li><a href="#">Settings</a></li>
							</ul>
						</div>
					</div>
				</div>

				<ul class="nav">
					<li><a href="../dashboard.html"> <i class="pe-7s-graph"></i>
							<p>Dashboard</p>
					</a></li>
					<li><a data-toggle="collapse" href="#componentsExamples">
							<i class="pe-7s-plugin"></i>
							<p>
								Components <b class="caret"></b>
							</p>
					</a>
						<div class="collapse" id="componentsExamples">
							<ul class="nav">
								<li><a href="../components/buttons.html">Buttons</a></li>
								<li><a href="../components/grid.html">Grid System</a></li>
								<li><a href="../components/icons.html">Icons</a></li>
								<li><a href="../components/notifications.html">Notifications</a></li>
								<li><a href="../components/panels.html">Panels</a></li>
								<li><a href="../components/sweet-alert.html">Sweet
										Alert</a></li>
								<li><a href="../components/typography.html">Typography</a></li>
							</ul>
						</div></li>

					<li><a data-toggle="collapse" href="#formsExamples"> <i
							class="pe-7s-note2"></i>
							<p>
								Forms <b class="caret"></b>
							</p>
					</a>
						<div class="collapse" id="formsExamples">
							<ul class="nav">
								<li><a href="../forms/regular.html">Regular Forms</a></li>
								<li><a href="../forms/extended.html">Extended Forms</a></li>
								<li><a href="../forms/validation.html">Validation Forms</a></li>
								<li><a href="../forms/wizard.html">Wizard</a></li>
							</ul>
						</div></li>

					<li><a data-toggle="collapse" href="#tablesExamples"> <i
							class="pe-7s-news-paper"></i>
							<p>
								Tables <b class="caret"></b>
							</p>
					</a>
						<div class="collapse" id="tablesExamples">
							<ul class="nav">
								<li><a href="../tables/regular.html">Regular Tables</a></li>
								<li><a href="../tables/extended.html">Extended Tables</a></li>
								<li><a href="../tables/bootstrap-table.html">Bootstrap
										Table</a></li>
								<li><a href="../tables/datatables.net.html">DataTables.net</a></li>
							</ul>
						</div></li>

					<li><a data-toggle="collapse" href="#mapsExamples"> <i
							class="pe-7s-map-marker"></i>
							<p>
								Maps <b class="caret"></b>
							</p>
					</a>
						<div class="collapse" id="mapsExamples">
							<ul class="nav">
								<li><a href="../maps/google.html">Google Maps</a></li>
								<li><a href="../maps/vector.html">Vector Maps</a></li>
								<li><a href="../maps/fullscreen.html">Full Screen Map</a></li>
							</ul>
						</div></li>

					<li><a href="../charts.html"> <i class="pe-7s-graph1"></i>
							<p>Charts</p>
					</a></li>

					<li><a href="../calendar.html"> <i class="pe-7s-date"></i>
							<p>Calendar</p>
					</a></li>

					<li class="active"><a data-toggle="collapse"
						href="#pagesExamples" area-expanded="true"> <i
							class="pe-7s-gift"></i>
							<p>
								Pages <b class="caret"></b>
							</p>
					</a>
						<div class="collapse in" id="pagesExamples">
							<ul class="nav">
								<li><a href="login.html">Login Page</a></li>
								<li><a href="register.html">Register Page</a></li>
								<li><a href="lock.html">Lock Screen Page</a></li>
								<li class="active"><a href="user.html">User Page</a></li>
								<li><a href="#">More coming soon...</a></li>
							</ul>
						</div></li>
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-minimize">
						<button id="minimizeSidebar"
							class="btn btn-warning btn-fill btn-round btn-icon">
							<i class="fa fa-ellipsis-v visible-on-sidebar-regular"></i> <i
								class="fa fa-navicon visible-on-sidebar-mini"></i>
						</button>
					</div>
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Dashboard</a>
					</div>
					<div class="collapse navbar-collapse">

						<form class="navbar-form navbar-left navbar-search-form"
							role="search">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-search"></i></span>
								<input type="text" value="" class="form-control"
									placeholder="Search...">
							</div>
						</form>

						<ul class="nav navbar-nav navbar-right">
							<li><a href="../charts.html"> <i
									class="fa fa-line-chart"></i>
									<p>Stats</p>
							</a></li>

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-gavel"></i>
									<p class="hidden-md hidden-lg">
										Actions <b class="caret"></b>
									</p>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">Create New Post</a></li>
									<li><a href="#">Manage Something</a></li>
									<li><a href="#">Do Nothing</a></li>
									<li><a href="#">Submit to live</a></li>
									<li class="divider"></li>
									<li><a href="#">Another Action</a></li>
								</ul></li>

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <span
									class="notification">5</span>
									<p class="hidden-md hidden-lg">
										Notifications <b class="caret"></b>
									</p>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">Notification 1</a></li>
									<li><a href="#">Notification 2</a></li>
									<li><a href="#">Notification 3</a></li>
									<li><a href="#">Notification 4</a></li>
									<li><a href="#">Another notification</a></li>
								</ul></li>

							<li class="dropdown dropdown-with-icons"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown"> <i
									class="fa fa-list"></i>
									<p class="hidden-md hidden-lg">
										More <b class="caret"></b>
									</p>
							</a>
								<ul class="dropdown-menu dropdown-with-icons">
									<li><a href="#"> <i class="pe-7s-mail"></i> Messages
									</a></li>
									<li><a href="#"> <i class="pe-7s-help1"></i> Help
											Center
									</a></li>
									<li><a href="#"> <i class="pe-7s-tools"></i> Settings
									</a></li>
									<li class="divider"></li>
									<li><a href="#"> <i class="pe-7s-lock"></i> Lock
											Screen
									</a></li>
									<li><a href="#" class="text-danger"> <i
											class="pe-7s-close-circle"></i> Log out
									</a></li>
								</ul></li>

						</ul>
					</div>
				</div>
			</nav>







			<div class="swal2-container swal2-fade swal2-shown"
				style="overflow-y: auto;">
				<div role="dialog" aria-labelledby="modalTitleId"
					aria-describedby="modalContentId" class="swal2-modal swal2-show"
					tabindex="-1"
					style="width: 500px; padding: 20px; background: rgb(255, 255, 255); display: block; min-height: 219px;">
					<ul class="swal2-progresssteps" style="display: none;"></ul>
					<div class="swal2-icon swal2-error" style="display: none;">
						<span class="x-mark"><span class="line left"></span><span
							class="line right"></span></span>
					</div>
					<div class="swal2-icon swal2-question" style="display: none;">?</div>
					<div class="swal2-icon swal2-warning" style="display: none;">!</div>
					<div class="swal2-icon swal2-info" style="display: none;">i</div>
					<div class="swal2-icon swal2-success" style="display: none;">
						<span class="line tip"></span> <span class="line long"></span>
						<div class="placeholder"></div>
						<div class="fix"></div>
					</div>
					<img class="swal2-image" style="display: none;">
					<h2 class="swal2-title" id="modalTitleId">Select image</h2>
					<div id="modalContentId" class="swal2-content"
						style="display: none;">and upload as profile pic</div>
					<input style="display: none;" accept="image/*" class="swal2-input"><input
						type="file" style="display: block;" accept="image/*"
						class="swal2-file" placeholder="">
					<div class="swal2-range" style="display: none;">
						<output></output>
						<input type="range" accept="image/*">
					</div>
					<select style="display: none;" accept="image/*"
						class="swal2-select"></select>
					<div class="swal2-radio" style="display: none;"></div>
					<label for="swal2-checkbox" class="swal2-checkbox"
						style="display: none;"><input type="checkbox"
						accept="image/*"></label>
					<textarea style="display: none;" accept="image/*"
						class="swal2-textarea"></textarea>
					<div class="swal2-validationerror" style="display: none;"></div>
					<hr class="swal2-spacer" style="display: block;">
					<a href="https://www.google.com">
					<button type="submit" role="button" tabindex="0"
						class="swal2-confirm swal2-styled"
						style="background-color: rgb(48, 133, 214); border-left-color: rgb(48, 133, 214); border-right-color: rgb(48, 133, 214);">OK</button>
					</a>
					<button type="button" role="button" tabindex="0"
						class="swal2-cancel swal2-styled"
						style="display: none; background-color: rgb(170, 170, 170);">Cancel</button>
					<span class="swal2-close" style="display: none;">×</span>
				</div>
			</div>












			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-4">
							<div class="card card-user">
								<div class="image">
									<img
										src="<spring:url value="/resources/img/full-screen-image-3.jpg"/>"
										alt="..." />
								</div>
								<div class="content">
									<div class="author">
										<a href="#"> <c:if test="${nopicture == 'YES'}">
												<img class="avatar border-gray"
													src="<spring:url value="/resources/img/${userprofileimage}"/>" />
											</c:if> <c:if test="${picture == 'YES'}">
												<img class="avatar border-gray"
													src="<spring:url value="/images/profilePicture/${userprofileimage}"/>" />
											</c:if>


											<h4 class="title">${username}<br /> <small>michael24</small>
											</h4>
										</a>
									</div>
									<p class="description text-center">
										"Lamborghini Mercy <br> Your chick she so thirsty <br>
										I'm in that two seat Lambo"
									</p>
								</div>
								<hr>
								<div class="text-center">
									<button href="#" class="btn btn-simple">
										<i class="fa fa-facebook-square"></i>
									</button>
									<button href="#" class="btn btn-simple">
										<i class="fa fa-twitter"></i>
									</button>
									<button href="#" class="btn btn-simple">
										<i class="fa fa-google-plus-square"></i>
									</button>

								</div>
							</div>
						</div>
						<div class="col-md-8">
							<div class="card">
								<div class="header">
									<h4 class="title">Edit Profile</h4>
								</div>
								<div class="content">
									<form>
										<div class="row">
											<div class="col-md-5">
												<div class="form-group">
													<label>Company (disabled)</label> <input type="text"
														class="form-control" disabled placeholder="Company"
														value="Creative Code Inc.">
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label>Username</label> <input type="text"
														class="form-control" placeholder="Username"
														value="michael23">
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label for="exampleInputEmail1">Email address</label> <input
														type="email" class="form-control" placeholder="Email">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label>First Name</label> <input type="text"
														class="form-control" placeholder="Company" value="Mike">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Last Name</label> <input type="text"
														class="form-control" placeholder="Last Name"
														value="Andrew">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Address</label> <input type="text"
														class="form-control" placeholder="Home Address"
														value="Bld Mihail Kogalniceanu, nr. 8 Bl 1, Sc 1, Ap 09">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>City</label> <input type="text" class="form-control"
														placeholder="City" value="Mike">
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Country</label> <input type="text"
														class="form-control" placeholder="Country" value="Andrew">
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Postal Code</label> <input type="number"
														class="form-control" placeholder="ZIP Code">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>About Me</label>
													<textarea rows="5" class="form-control"
														placeholder="Here can be your description" value="Mike">Lamborghini Mercy, Your chick she so thirsty, I'm in that two seat Lambo.</textarea>
												</div>
											</div>
										</div>

										<button type="submit" class="btn btn-info btn-fill pull-right">Update
											Profile</button>
										<div class="clearfix"></div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
