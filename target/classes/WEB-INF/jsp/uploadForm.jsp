<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form method="POST" enctype="multipart/form-data" action="/upload">
			<table>
				<tr><td><input type="file" name="file" /></td></tr>
				<tr><td><input type="submit" value="Upload" /></td></tr>
			</table>
		</form>
	</center>

	<br />
        <input id="sc" class="js-copytext" type="text" value="${link }"/>
		<button class="js-copybtn" style="vertical-align:top;">Copy</button>
	<script>
    	function copy() {
	      document.querySelector('.js-copytext').select();	  
	        if(document.execCommand('copy'))
	        	{
	        		alert("Copied "+ document.getElementById("sc").value);
	        	}
	    }
    	

	    document.querySelector('.js-copybtn').addEventListener('click',copy );    
    </script>
</body>
</html>