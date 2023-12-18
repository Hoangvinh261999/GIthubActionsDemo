
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<body>
	<div>
		<div style="display: flex;text-align: center;">
				<div
			style="width: 17%; background-color: darkgray; border: solid 2px;">
<a href="<%= request.getContextPath() %>/videodetail/videoedition?view123=videoedition">VIDEO EDITION</a>
		
		</div>
		<div
			style="width: 17%; background-color: darkgray; border: solid 2px;">
<a href="<%= request.getContextPath() %>/videodetail/videoedition?view123=videolist">VIDEO LIST</a>
		
		</div>
		
		</div>


		<div style="margin-top: 10px">
            <jsp:include page="${view123}"></jsp:include>

		</div>
		
	</div>
