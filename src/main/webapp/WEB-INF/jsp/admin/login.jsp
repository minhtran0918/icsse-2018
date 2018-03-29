<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>ICSSE 2018</title>
  <!-- Source-->
  <link href="static/css/bootstrap.min.css" rel="stylesheet">
  <link href="static/fonts/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="static/css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header text-center">
		<h4 class="text-center">Welcome back!</h4>
		
      </div>
      <div class="card-body">
        <form method="post" action="login">
          <div class="form-group">
            <label for="usernameInput">Username</label>
            <input class="form-control" id="usernameInput" name="username" type="text" placeholder="Enter UserName">
          </div>
          <div class="form-group">
            <label for="passwordInput">Password</label>
            <input class="form-control" id="passwordInput" name="password" type="password" placeholder="Password">
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember Password</label>
            </div>
          </div>
          <input type="submit" value="LOGIN" class="btn btn-success btn-block">
          
        </form>
        <div class="text-center">
        	<a class="d-block small mt-3" href="/">Back</a>
        
          <a class="d-block small" href="#">Sign up</a>
          
          <a class="d-block small" href="#">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
	<!-- Bootstrap core JavaScript-->
	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script src="static/js/jquery-easing/jquery.easing.min.js"></script>
</body>
</html>
