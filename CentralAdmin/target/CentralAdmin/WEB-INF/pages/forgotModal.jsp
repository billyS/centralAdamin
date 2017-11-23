<!-- Modal -->
<div class="modal fade" id="forgotModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Enter email address to have password reminder sent to</h4>
      </div>
      <form class="createUser" modelAttribute="user" method="POST" action="${contextpath}/forgot">
        <div class="form-group">
				<div id="emailError" class="alert alert-danger" style="display:none;"></div> 
				<label for="email">Email
					<input  class="form-control" id="email" type="email" name="username" placeholder="Email">
				</label> 
		</div>
	  </form>
      <div class="modal-footer">
        <button id="cancelPasswordReminder" type="button" class="btn btn-default delete" data-dismiss="modal">Cancel</button>
        <button id="confirmPasswordReminder" type="button" class="btn btn-primary" data-dismiss="modal" >Send Reminder</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



