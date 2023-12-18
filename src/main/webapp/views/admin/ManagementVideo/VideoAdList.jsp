<%@ taglib prefix="c" uri="jakarta.tags.core"%>
		<table>
		<thead>
			<tr>
				<th>Youtube ID</th>
				<th>Video Title</th>
				<th>View Count</th>
				<th>Status</th>
				<th></th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="video" items="${videos}">
				<tr>
					<td>${video.id}</td>
					<td>${video.title}</td>
					<td>${video.views}</td>
					<td>${video.active}</td>
	<td> <a href="<%= request.getContextPath()%>/videodetail/adeditvideo/${video.id}">Edit</a></td>
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
</body>
</html>