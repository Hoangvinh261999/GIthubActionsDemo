<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
a{
text-decoration: none;
color:black;
font-weight: bold;
font-size:larger;
}
body {
	width: 100%;
	max-width: 1240px;
	margin: 0 auto;
}

.ndvideo {
	display: flex;
}

.poster {
	flex: 4;
	background: blue;
	padding: 10px; /* Thêm padding nếu cần thiết */
}

.vdinfor {
	flex: 8;
	background: yellow;
	padding: 10px; /* Thêm padding nếu cần thiết */
}
.vdinfor input{
width: 90%
}
.vdinfor div{
 margin-top: 20px;
}
</style>
</head>
<body>
	<div class="tabvideo" style="display: flex;">
		<div style="width: 13%; background-color: darkgray; border: solid 2px;" >
			<a href="useredition">USER EDITION</a>
		</div>

		<div style="width: 13%; background-color: darkgray; border: solid 2px;" >
			<a href="userlist">USER LIST</a>
		</div>
        <div style="margin-top: 10px">
        </div>
		
	</div>


</body>
</html>
