<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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
	    <ul class="pagination">
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
    </ul>