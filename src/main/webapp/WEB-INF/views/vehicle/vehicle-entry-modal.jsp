<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="vehicle-entry-modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">
					<fmt:message key="new.vehicle.entry" />
				</h4>
			</div>

			<form method="post" class="form-horizontal">
				<div class="modal-body">			
					<div class="form-group">
						<label class="control-label col-sm-4"> 
							<fmt:message key="vehicle" />
						</label>
						
						<div class="col-sm-7">
							<select class="form-control" name="vehicle_id" required>
								<option value="" selected="selected">
									<fmt:message key="select.an.option"/>
								</option>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-4"> 
							<fmt:message key="color" />
						</label>
						
						<div class="col-sm-7">
							<select class="form-control" name="color" required>
								<option value="" selected="selected">
									<fmt:message key="select.an.option"/>
								</option>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-4"> 
							<fmt:message key="plate" />
						</label>
						
						<div class="col-sm-7">
							<input type="text" class="form-control" maxlength="8" name="plate" placeholder="AAA-0000" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-4"> 
							<fmt:message key="notes" />
						</label>
						
						<div class="col-sm-7">
							<textarea class="form-control" maxlength="255" rows="4" name="notes"></textarea>
						</div>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">
						<fmt:message key="cancel" />
					</button>

					<button type="submit" class="btn btn-success">
						<fmt:message key="save" />
					</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
	$('#new-vehicle-entry').click(function() {
		$('#vehicle-entry-modal').modal('show');
	});
</script>