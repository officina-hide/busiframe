<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン Lv.01</title>
<link rel="stylesheet" href="./css/skyblue_k.css">

<body>
	<header>
		<div class="container bg-dark padding-y-10">
			<h1>ログイン Lv.01</h1>
		</div>
	</header>
	<%-- リクエストスコープに alerts があれば --%>
	<div class="padding-y-5 text-center">
		<c:forEach var="alert" items="${alerts}">
			<div class="row color-error padding-y-5">
				<div class="col">${alert}</div>
			</div>
		</c:forEach>
	</div>
	<form action="./login01" method="post">
		<div class="padding-x-100 padding-y-50">
			<div class="row">
				<label class="md-4 text-right  padding-x-10 padding-y-5">ログインID</label>
			</div>
		</div>
	</form>
</body>
</html>