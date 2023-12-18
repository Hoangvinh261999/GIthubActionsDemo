
<form method="POST">
<div class="ndvideo">

	<div class="poster">
		<div>
		<img alt="" src="">
			<iframe src="https://www.youtube.com/embed/${form.id}" style="border: none;height: 300px;width: 550px;"> </iframe>
		</div>
	</div>
	<div class="vdinfor" style="display: grid;">
		<div>
			<label>YOUTUBE ID?</label> <br> </a><input name="id" type="text"
				value="${form.id}">
		</div>
		<div>
			<label>VIDEO TITLE?</label> <br> <input name="title" type="text"
				value="${form.title}">
		</div>
		<div>
			<label>VIEW COUNT?</label> <br> <input name="views" type="number"
				value="${form.views}">
		</div>

		<div>
			<div style="display: flex;">
				<label> Active </label> <input type="radio" name="active"
					class="radio1" style="margin-left: 15px;"
					${form.active ? 'checked' : ''}>
			</div>
			<div style="display: flex;">
				<label> Inactive </label> <input type="radio" name="active"
					class="radio1" ${!form.active ? 'checked' : ''}>
			</div>
		</div>
	</div>
</div>
<h5>DESCRIPTION?</h5>
<input type="text"  name="description" value="${form.description}">
   <div style="margin-top: 20px; gap:20px">
   		 <button formaction="<%= request.getContextPath() %>/videodetail/adeditvideo/createvd/${form.id}">Create</button>
    <button formaction="<%= request.getContextPath() %>/videodetail/adeditvideo/updatevd/${form.id}">Update</button>
    <button formaction="<%= request.getContextPath() %>/videodetail/adeditvideo/deletevd/${form.id}">Delete</button>
    <button formaction="<%= request.getContextPath() %>/videodetail/adeditvideo/">Reset</button>
   </div>
</form>



