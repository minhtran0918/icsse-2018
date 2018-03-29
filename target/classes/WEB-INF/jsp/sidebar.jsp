<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="sidebar floatright">
	<div class="single_sidebar">
		<div class="popular">
			<h2 class="title">Last news</h2>
			<ul>
				<c:forEach var="n" items="${news}" begin="0" end="5">
					<li>
						<a href="page?id=${n.id }#read-news">
						<div class="single_popular">
							<p>${n.name } </p>
							<p style="text-align:right"><i>(${n.date })</i></p>
							
						</div>
						</a>
					</li>
				</c:forEach>
			</ul>
			<a class="popular_more" href="all-news">MORE</a>
		</div>
	</div>
</div>
</div>