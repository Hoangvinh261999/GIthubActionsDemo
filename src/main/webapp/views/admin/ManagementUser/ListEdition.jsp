	<div>
		<div style="display: flex; text-align: center;">
			<div
				style="width: 17%; background-color: darkgray; border: solid 2px;">
				<a
					href="<%=request.getContextPath()%>/userdetail/Useredition?viewuser=useredition">USER
					EDITION</a>
			</div>
			<div
				style="width: 17%; background-color: darkgray; border: solid 2px;">
				<a
					href="<%=request.getContextPath()%>/userdetail/Useredition?viewuser=userlist">USER
					LIST</a>
			</div>
		</div>
		<div style="margin-top: 10px">
			<jsp:include page="${viewUser}"></jsp:include>
		</div>
	</div>