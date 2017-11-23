<!-- Modal -->
<div class="modal fade" id="userModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
       <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">Edit User</h4>
        </div>
        	<div class="modal-body">
        	<div id="warningDiv" class="alert alert-info ajaxresult-info" style="display: none"></div>
			<div id="errorDiv" class="alert alert-danger ajaxresult-danger" style="display: none"></div>
			<form:form class="passwordReminder" modelAttribute="user" method="POST" action="${contextpath}/save">
						<div class="form-group">
	                        <form:hidden path="userId"/>
	                    </div>
	                    <div class="form-group">
	                        <form:label path="username">User Name</form:label>
	                        <form:input name="username" path="username"/>
	                        <form:errors path="username"/>
	                    </div>
	                    <div class="form-group">
	                       <form:label path="firstName">First Name</form:label>
	                        <form:input name="firstName" path="firstName"/>
	                        <form:errors path="firstName"/>
	                    </div>
	                    <div class="form-group">
	                       <form:label path="enabled">Enabled</form:label>
	                        <form:input name="enabled" path="enabled"/>
	                        <form:errors path="enabled"/>
	                    </div>
	                    <div class="form-group">
	                        <form:label path="lastName">Last Name</form:label>
	                        <form:input name="lastName" path="lastName"/>
	                        <form:errors path="lastName"/>
	                    </div>
	                    <div class="form-group">
	                       <form:label path="emailAddress">Email Address</form:label>
	                        <form:input name="emailAddress" path="emailAddress"/>
	                        <form:errors path="emailAddress"/>
	                    </div>
	                    <div class="form-group">
	                       <form:label path="password">Password</form:label>
	                        <form:input name="password" path="password"/>
	                        <form:errors path="password"/>
	                    </div>
	                    <div class="form-group">
	                      <form:label path="role">User Role</form:label>
	                        <form:input path="role" />
	                        <form:errors path="role"/>
	                    </div>
				<div class="modal-footer userModalFooter">
					<input type="button" id="save" value="Save" class="btn btn-primary">
			        <button type="button" id="close" class="btn btn-default delete" data-dismiss="modal">Close</button>
			    </div>
			</form:form>
		</div><!-- /.modal-body --> 
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->