<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BasicBoard</title>
</head>
<body>
	<a href="writeBoardForm">글쓰기</a>
	
	<table border="1" style="width:600px">
		<caption>게시판</caption>
		<colgroup>
			<col width="8%"/>
			<col width="*%"/>
			<col width="15%"/>
			<col width="15%"/>
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>등록자</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listView" items="${ listView }" varStatus="status">
				<c:url var="link" value="basicBoardRead">
					<c:param name="brdno" value="${ listView.brdno }" />
				</c:url>
				<tr>
					<td><c:out value="${ listView.brdno }"/></td>
					<td><a href="${ link }"><c:out value="${ listView.brdtitle }" /></a></td>
					<td><c:out value="${ listView.brdwriter }"/></td>
					<td><c:out value="${ listView.brddate }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>