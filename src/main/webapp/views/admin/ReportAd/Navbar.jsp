	<div>
		<div style="display: flex; text-align: center;">
			<div
				style="width: 17%; background-color: darkgray; border: solid 2px;">
				<a
					href="<%=request.getContextPath()%>/reportdetail/favorite?viewreport=favorite">FAVORITES</a>
			</div>
			<div
				style="width: 17%; background-color: darkgray; border: solid 2px;">
				<a
					href="<%=request.getContextPath()%>/reportdetail/favoriteuser?viewreport=favoriteuser">FAVORITES USER</a>
			</div>
<div
				style="width: 17%; background-color: darkgray; border: solid 2px;">
				<a
					href="<%=request.getContextPath()%>/reportdetail/sharefriend?viewreport=sharefriend">SHARE FRIEND</a>
			</div>
		</div>
		<div style="margin-top: 10px">
			<jsp:include page="${viewReport}"></jsp:include>
		</div>
	</div>