            <%@ include file="indexMnUs.jsp" %>

	<div class="ndvideo">
		<div class="poster">
			<div >
					<img alt="" src="/asmGd1_java4/img/${form.poster}" style="height: 60%; width: 60%;">
			</div>
		</div>
		<div class="vdinfor" style="display: grid;">
			<div>
				<label>YOUTUBE ID?</label> <br> </a><input type="text" value="${form.id}">
			</div>
			<div>
				<label>VIDEO TITLE?</label> <br>  <input type="text" value="${form.title}">
			</div>
			<div>
				<label>VIEW COUNT?</label> <br>  <input type="number" ${form.views}>
			</div>
			
			<div>
				 <div style="display: flex; "><label> Active </label> <input type="radio" name="acin" class="radio1" style="    margin-left: 13px;"></div>
				<div style="display: flex;"><label> Inactive </label> <input type="radio"name="acin" class="radio1"></div>
			</div>
		
		</div>
	</div>
	<h5>DESCRIPTION?</h5>
	<textarea rows="5" cols="167"></textarea>
	<div>
		<button>Create</button>
		<button>Update</button>
		<button>Delete</button>
		<button>Reset</button>
	</div>

