<h1>Bài 3</h1>
	<form action="/Lab6/videolike" method="get">
		<input type="text" name="videoid" placeholder="Nhập từ khóa" value="${param.videoId}">
		<button type="submit">Tìm kiếm</button>
	</form>
		<table>
		<thead>
			<tr>
				<th>Username</th>
				<th>Fullname</th>
				<th>Email</th>
				<th>Role</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.id}</td>
					<td>${user.fullname}</td>
					<td>${user.email}</td>
					<td>${user.admin}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>