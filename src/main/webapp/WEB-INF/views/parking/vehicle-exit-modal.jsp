<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="vehicle-exit-modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">
					<fmt:message key="register.vehicle.exit" />
				</h4>
			</div>

			<form method="post" action="<c:url value="parked-vehicle" />" class="form-horizontal">
				<input type="hidden" id="ve-parking-id" name="id" />
				
				<div class="modal-body">			
					<div class="form-group">
						<div class="col-sm-6">
							<label class="col-sm-12"> 
								<fmt:message key="vehicle" />
							</label>
							
							<div class="col-sm-12">
								<input type="text" class="form-control" disabled="disabled" id="ve-vehicle" />
							</div>
						</div>
						
						<div class="col-sm-6">
							<label class="col-sm-12"> 
								<fmt:message key="vehicle.plate" />
							</label>
							
							<div class="col-sm-12">
								<input type="text" class="form-control" disabled="disabled" id="ve-vehicle-plate" />
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-6">
							<label class="col-sm-12"> 
								<fmt:message key="entry" />
							</label>
							
							<div class="col-sm-12">
								<input type="text" class="form-control" disabled="disabled" id="ve-entry" />
							</div>
						</div>
						
						<div class="col-sm-6">
							<label class="col-sm-12"> 
								<fmt:message key="permanence" />
							</label>
							
							<div class="col-sm-12">
								<input type="text" class="form-control" disabled="disabled" id="ve-permanence" />
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-6">
							<label class="col-sm-12">
								<fmt:message key="notes" />
							</label>
							
							<div class="col-sm-12">
								<textarea class="form-control" maxlength="255" rows="3" id="ve-notes" disabled></textarea>
							</div>
						</div>

						<div class="col-sm-6">
							<label class="col-sm-12"> 
								<fmt:message key="total" />
							</label>
							
							<div class="col-sm-12" id="ve-total-box">
								<span id="ve-total">0,00</span>
							</div>
						</div>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="clearData();">
						<fmt:message key="cancel" />
					</button>

					<button type="submit" id="btn-submit" class="btn btn-success">
						<fmt:message key="register" />
					</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
	$('.btn-vehicle-exit').click(function() {
		$('#vehicle-exit-modal').modal('show');
		clearData();
		findParkedVehicleData($(this).attr('data-parking'));
	});
	
	function findParkedVehicleData(parkingId) {
		$.ajax({
			url: '<c:url value="parked-vehicle" />',
			type: 'GET',
			dataType: 'json',
			data: {
				id: parkingId
			},
			success: function(data) {
				if (!data) return;
				
				$('#ve-parking-id').val(data.id);
				$('#ve-vehicle').val(data.vehicle.model.split('-')[1]);
				$('#ve-vehicle-plate').val(data.vehicle.plate);
				$('#ve-entry').val(new Date(data.entry).toLocaleString());
				$('#ve-permanence').val(data.permanence + ' hora(s)');
				$('#ve-notes').text(data.notes);
				$('#ve-total').text(data.total);
			}
		});
	}
	
	function clearData() {
		$('#ve-parking-id, #ve-vehicle, #ve-vehicle-plate, #ve-entry, #ve-permanence').val('');
		$('#ve-notes, #ve-total').text('');
	}
</script>