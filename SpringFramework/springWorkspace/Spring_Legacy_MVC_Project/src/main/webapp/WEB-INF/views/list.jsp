<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
	table, th, td {
		border : 1px solid black;
	}
</style>
</head>
<body>
	<div>
		<table>
			<thead>
				<tr>
					<th>부서번호</th>
					<th>부서명</th>
					<th>매니저번호</th>
					<th>위치번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${depts}" var="dept">
					<tr>
						<td>${dept.department_id}</td>
						<td>${dept.department_name}</td>
						<td>${dept.manager_id}</td>
						<td>${dept.location_id}</td>
					</tr>
				</c:forEach>		
			</tbody>
		</table>
	</div>
</body>
</html>