<!-- Modal -->
<!-- <script type="text/javascript">
    var csrfParameter = '${_csrf.parameterName}';
    var csrfToken = '${_csrf.token}';
</script>-->

<div class="modal fade" id="confirmDeleteUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Delete User?</h4>
      </div>
      <div class="alert alert-warning break-word">Are you sure you want to remove this user?</div>
      <div class="modal-footer">
        <button id="cancelDeltetUser" type="button" class="btn btn-default delete" data-dismiss="modal">Cancel</button>
        <button id="confirmDeleteUser" type="button" class="btn btn-danger" data-dismiss="modal" >Confirm</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

