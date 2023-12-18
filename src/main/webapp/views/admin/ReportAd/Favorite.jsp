<h1>Bài 5</h1>
			<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Favorite count</th>
				<th>Newest date</th>
				<th>Oldest date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${listRp}">
				<tr>
					<td>${report.title}</td>
					<td>${report.likes}</td>
					<td>${report.newest}</td>
					<td>${report.oldest}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	