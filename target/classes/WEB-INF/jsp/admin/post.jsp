<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="static/css/sb-admin.css" rel="stylesheet">
<!-- <link href="static/css/font-awesome.min.css" rel="stylesheet"> -->
<!-- JavaScript-->
<script src="static/js/jquery.min.js"></script>
<script src="static/js/bootstrap.bundle.min.js"></script>
<script src="static/js/sb-admin.min.js"></script>
<script src="static/js/jquery-easing/jquery.easing.min.js"></script>
<script src="static/ckeditor/ckeditor.js"></script>
<title>ICSSE Dashbroad</title>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="/">ICSSE 2018 - Group 4</a>
		<!-- Menu -->
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
				<!-- Menu 1 -->
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Dashboard"><a class="nav-link" href="/"> <i
						class="fa fa-tachometer"></i> <span class="nav-link-text">Dashboard</span>
				</a></li>
				<!-- Menu 2 -->
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Posts"><a class="nav-link nav-link-collapse collapsed"
					data-toggle="collapse" href="#collapseComponents"
					data-parent="#exampleAccordion"> <i class="	fa fa-newspaper-o"></i>
						<span class="nav-link-text">Posts</span>
				</a>
					<ul class="sidenav-second-level collapse" id="collapseComponents">
						<li><a href="write-post"><i class="fa fa-pencil-square-o"></i>
								Write post</a></li>
						<li><a href="update-post"><i class="fa fa-refresh"></i>
								Edit post</a></li>
					</ul></li>
				<!-- Menu 3 -->
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Example Pages"><a
					class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
					href="#collapseExamplePages" data-parent="#exampleAccordion"> <i
						class="fa fa-user-o"></i> <span class="nav-link-text">Account</span>
				</a>
					<ul class="sidenav-second-level collapse" id="collapseExamplePages">
						<li><a href="login.html"><i class="fa fa-info-circle"></i>
								Information</a></li>
						<li><a href="register.html"><i
								class="fa fa-pencil-square-o"></i> Change password</a></li>
					</ul></li>
				<!-- Menu 4 -->
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Link"><a class="nav-link" data-toggle="modal"
					data-target="#exampleModal"> <i class="fa fa-sign-out"></i> <span
						class="nav-link-text">Log out</span>
				</a></li>
			</ul>
			<!-- Collapse menu group -->
			<ul class="navbar-nav sidenav-toggler">
				<li class="nav-item"><a class="nav-link text-center"
					id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
				</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>Logout
				</a></li>
			</ul>
		</div>
		<!-- End menu -->
	</nav>
	<!-- End navigation -->
	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
				<li class="breadcrumb-item active">Post</li>
				<li class="breadcrumb-item active">Write post</li>
			</ol>
			<div class="container">
				<div class="row">
					<label for="userInput">Username</label> <input class="form-control"
						id="userInput" type="text" aria-describedby="usernameHelp"
						placeholder="Enter username">
				</div>
				<br/>
				<div class="row">
					<div class="col-lg-12 nopadding">
						<textarea name="editor" id="editor" rows="10" cols="80"></textarea>
						<script>
							CKEDITOR.replace('editor');
						</script>
					</div>
				</div>
			</div>
		</div>
		<!-- /.container-fluid-->


		<!-- /.content-wrapper-->
		<footer class="sticky-footer">
			<div class="container">
				<div class="text-center">
					<small>03 - 2018</small>
				</div>
			</div>
		</footer>
		<!-- Logout Modal-->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Log out?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">X</span>
						</button>
					</div>
					<div class="modal-body">See you later !</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="login.html">Logout</a>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
