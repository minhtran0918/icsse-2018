<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ICSSE 2018</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css"
	href="static/index/assets/font/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/index/assets/font/font.css" />
<link rel="stylesheet" type="text/css"
	href="static/index/assets/css/bootstrap.min.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="static/index/assets/css/style.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="static/index/assets/css/responsive.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="static/index/assets/css/jquery.bxslider.css" media="screen" />
</head>
<body>
	<div class="body_wrapper">
		<div class="center">
			<div class="header_area">
				<div class="logo floatleft">
					<a href="#"><img src="static/images/logo.jpg" alt="" /></a><br />
					<br />
				</div>

			</div>
			<div class="main_menu_area">
				<ul class="nav navbar-nav">
					<li><a href="/">home</a></li>
					<li><a href="page?id=2#read-news">program</a></li>
					<li><a href="page?id=3#read-news">publication</a></li>
					<li><a href="page?id=4#read-news">keynote speakers</a></li>
					<li><a href="page?id=5#read-news">gallery</a></li>
					<li><a href="page?id=6#read-news">contact</a></li>
					<li><a href="page?id=7#read-news">about</a></li>
				
				</ul>
				<ul class="nav navbar-nav navbar-right">
			      <c:if test="${empty sessionScope.us }">
			      <li><a href="login">Login</a></li>
			      </c:if>
			      <c:if test="${not empty sessionScope.us }">
			      <li><a href="manager">Mananger</a></li>
			      <li><a href="logout">Logout</a></li>
			      </c:if>
			    </ul>
			</div>
			<div class="slider_area">
				<div class="slider">
					<ul class="bxslider">
						<li><img src="static/images/background1.jpg" alt=""
							title="HCMUTE" /></li>
						<li><img src="static/images/background2.jpg" alt=""
							title="HCMUTE" /></li>
						<li><img src="static/images/background3.jpg" alt=""
							title="ICSSE 2018" /></li>
					</ul>
				</div>
			</div>
			<div class="content_area">