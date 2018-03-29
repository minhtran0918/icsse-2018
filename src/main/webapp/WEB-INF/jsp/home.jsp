<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<div class="main_content floatleft">
	<div class="single_left_coloum_wrapper">
		<!-- Content is here -->
		<c:choose>
			<c:when test="${mode == 'MODE_PAGE'}">
				<h2 id="read-news" class="title">${document.name }</h2>
				<c:if test="${not empty sessionScope.us }">
					<div style="text-align:right"><a href="update-news?id=${document.id}"><h2 class="glyphicon glyphicon-pencil"> Update</h2></a></div>
				</c:if>
				<blockquote>${document.content }</blockquote>
				<p style="text-align:right"><i>Time: ${document.date}</i></p>
			</c:when>
			<c:when test="${mode == 'MODE_NEWS'}">
				<div class="container">
			<div class="row">
				<div class="content">
					<ul class="child">
					
					
					
					<c:forEach items="${news }" var="n">
					
							<div class="panel panel-default">
						<div class="panel-body">
						<div class="col-md-2 col-sm-2 col-xs-12">
						<a href="page?id=${n.id }#read-news"><img src="${n.image }" class="img-thumbnail" alt="Responsive image"></img></a>
						</div>
						<div class="col-md-7 col-sm-7 col-xs-12">
							<a href="page?id=${n.id }#read-news">
							<h5><span style="color: blue">${n.name }</span></h5>
							<h6><i>Time: ${n.date }</i></h6>
							</a>
						</div>
						</div>
						</div>
					
					</c:forEach>
					</ul>
					</div>
					</div>
					</div>
					
			</c:when>
		</c:choose>
		<!-- end -->
	</div>
</div>
<%@ include file="sidebar.jsp"%>
<%@ include file="footer.jsp"%>