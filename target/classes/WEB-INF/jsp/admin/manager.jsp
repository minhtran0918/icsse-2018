<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    
    
    <title>News Manager | Home</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
     <link href="static/css/style.css" rel="stylesheet">
     <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
     
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body onload="set_editor_content()">
	<script type="text/javascript"	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">	</script>
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav">
					<li class="nav-item "><a href="/">HOME</a></li>
					<li class="nav-item"><a href="new-news">ADD NEWS</a></li>
					<li class="nav-item"><a href="manager">ALL NEWS</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode == 'MODE_TASKS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>All News</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								
								<th>Thumbnail</th>
								<th>Title</th>
								<th>Date</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="document" items="${documents}">
								<tr>
									<td><img src="${document.image}" style="height:50px;width:auto;"></td>
									<td>${document.name}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${document.date}"/></td>
									<td><a href="update-news?id=${document.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="delete-news?id=${document.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_NEW'}">
			<div class="container text-center">
				<h3>Add News</h3>
				<hr>
				
					<div class="container">
					<div class="float-left"><textarea class="tinymce" id="tiny"></textarea></div>
					<div class="float-right"><iframe  src="upload" style="width:270px"><p>Trình duyệt không hỗ trợ</p></iframe></div>
				</div>
				
				
				<br/>
				<form class="form-horizontal" method="POST" action="save-news" onsubmit="return get_editor_content()">
					<input type="hidden" name="groupnewsid" value="1"/>
					
					<div class="form-group">
						<label class="control-label col-md-3">Title</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name"/>
						</div>				
					</div>
					<textarea style="display:none;" id="html" name="content"></textarea>
					<div class="form-group">
						<label class="control-label col-md-3">Image</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="image"/>
						</div>				
					</div>
							
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save"/>
					</div>
				</form>
				
				<script>
		function set_editor_content(){
			tinymce.get('tiny').setContent(document.getElementById('html').value);
		}
		function get_editor_content() {
			$('#html').val(tinyMCE.get('tiny').getContent());
			return true;
		}
		</script>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Update Post</h3>
				<hr>
				<div class="container">
					<div class="float-left"><textarea class="tinymce" id="tiny"></textarea></div>
					<div class="float-right"><iframe  src="upload" style="width:270px"><p>Trình duyệt không hỗ trợ</p></iframe></div>
				</div>
				<br/>
				<form class="form-horizontal" method="POST" action="save-news" onsubmit="return get_editor_content()">
					<input type="hidden" name="id" value="${document.id}"/>
					<input type="hidden" name="groupnewsid" value="${document.groupnewsid}"/>
					<div class="form-group">
						<label class="control-label col-md-3">Title</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name" value="${document.name}"/>
						</div>				
					</div>
					<textarea style="display:none;" id="html" name="content">${document.content}</textarea>
					<div class="form-group">
						<label class="control-label col-md-3">Image</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="image" value="${document.image}"/>
						</div>				
					</div>
							
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save"/>
					</div>
				</form>
				
				<script>
		function set_editor_content(){
			tinymce.get('tiny').setContent(document.getElementById('html').value);
		}
		function get_editor_content() {
			$('#html').val(tinyMCE.get('tiny').getContent());
			return true;
		}
		</script>
			</div>
		</c:when>		
	</c:choose>

	<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="plugin/tinymce/tinymce.min.js"></script>
	<script type="text/javascript" src="plugin/tinymce/init-tinymce.js"></script>
</body>
</html>