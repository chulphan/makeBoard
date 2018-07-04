<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>basic-글쓰기</title>
</head>
<body>
	<form name="basicForm" action="saveWrite">
		<table border="1" style="width:600px">
			<colgroup>
				<col width="15%" />
				<col width="*%" />
			</colgroup>
			<tbody>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="brdwriter" size="20" maxlength="20"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="brdtitle" size="70" maxlength="70"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="brdmemo" rows="5" cols="60"></textarea></td>
				</tr>
			</tbody>
		</table>
		<a href="#" onclick="basicForm.submit()">저장</a>
	</form>
</body>
</html>