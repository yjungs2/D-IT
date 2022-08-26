<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 
1. pom.xml에 라이브러리 추가...commons fileupload 라이브러리
2. method 방식을 POST로 지정 (GET 방식은 안 됨)
	-> POST 지정하므로 form 태그 사용 (a 태그 안 됨)
3. enctype 속성도 추가 -> 규칙임
4. input type="file" 폼을 사용함
5. MultipartFile빈을 빈 설정문서에 등록한다.
 -->
<body>
<h2 align="center">File Upload Form...</h2>
<form action="fileupload.do" method="post" enctype="multipart/form-data">
	사용자명<input type="text" name="userName">
	<input type="file" name="uploadFile">
	<input type="submit" value="파일업로드하기">
</form>
</body>
</html>
<!-- 
지금까지는 여기까지 로직을 작성한 후 요청을 처리하는 Controller를 작성했다면
파일 업로드만큼은 업로드한 파일 정보를 저장할 upload VO를 먼저 작성해야 한다.
 -->