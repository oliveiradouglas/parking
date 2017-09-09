<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="vehicle-entry-modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">
					<fmt:message key="new.vehicle.entry" />
				</h4>
			</div>

			<form method="post" action="<c:url value="parkings" />" class="form-horizontal">
				<input type="hidden" name="vehicleId" />
			
				<div class="modal-body">
					<div class="form-group">
						<label class="control-label col-sm-4"> 
							<fmt:message key="vehicle.plate" />
						</label>
						
						<div class="col-sm-7">
							<input type="text" class="form-control uppercase" maxlength="8" name="vehicle_plate" placeholder="AAA-0000" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-4"> 
							<fmt:message key="type" />
						</label>
						
						<div class="col-sm-7">
							<input type="radio" name="type" value="<%= com.oliveiradouglas.parking.models.Vehicle.CAR %>" checked /> <fmt:message key="car" />
							<input type="radio" name="type" value="<%= com.oliveiradouglas.parking.models.Vehicle.MOTORCYCLE %>" /> <fmt:message key="motorcycle" /> 
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-4"> 
							<fmt:message key="brand" />
						</label>
						
						<div class="col-sm-7">
							<select class="form-control" name="brand" required>
								<option value="" selected="selected" class="hide">
									<fmt:message key="select.an.option"/>
								</option>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-4"> 
							<fmt:message key="model" />
						</label>
						
						<div class="col-sm-7">
							<select class="form-control" name="model" required>
								<option value="" selected="selected" class="hide">
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
								<option value="" selected="selected" class="hide">
									<fmt:message key="select.an.option"/>
								</option>
								
								<c:forEach var="color" items="${colors}">
									<option value="${color.id}">
										${color.name}
									</option>
								</c:forEach>
							</select>
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
					<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="clearForm();">
						<fmt:message key="cancel" />
					</button>

					<button type="submit" class="btn btn-success" id="btn-submit">
						<fmt:message key="save" />
					</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript" src="<c:url value="/public/js/vanilla-masker.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/public/js/select2.min.js" />"></script>
<script type="text/javascript">
	$('#new-vehicle-entry').click(function() {
		$('#vehicle-entry-modal').modal('show');
		findBrands();
	});

	VMasker(document.querySelector('[name="vehicle_plate"]')).maskPattern("AAA-9999");
	$('[name="vehicle_plate"]').blur(function() {
		clearForm();
		
		if ($(this).val().length < 8) {
			$(this).addClass('input-error');
		} else {
			$(this).removeClass('input-error');
			findVehicleAndFillForm();
		}
	});
	
	$('[name="type"]').click(function() {
		clearForm();
		findBrands();
	});
	
	$('[name="brand"]').change(function() {
		findModels();
	});

	function findVehicleAndFillForm() {
		$.ajax({
			url: '<c:url value="vehicles" />',
			type: 'GET',
			dataType: 'json',
			data: {
				vehiclePlate: $('[name="vehicle_plate"]').val()
			},
			before: function() {
				$('#btn-submit').text('<fmt:message key="wait"/>...');
			},
			success: function(data) {
				if (!data.hasOwnProperty('id')) {
					return;
				}
				
				$('[name="vehicleId"]').val(data.id);
				$('[name="type"]:checked').removeAttr('checked');
				$('[name="type"][value="' + data.type + '"]').attr('checked', 'checked');
				
				findBrands().then(function() {
					$('[name="brand"]').val(data.brand);

					findModels().then(function() {
						$('[name="model"]').val(data.model);
					});
				});
				
				$('[name="color"]').val(data.color.id);
				$('[name="notes"]').text(data.notes);
			},
			complete: function() {
				$('#btn-submit').text('<fmt:message key="save"/>');
			}
		});
	}
	
	function clearForm() {
		$('[name="brand"], [name="model"], [name="color"], [name="vehicleId"]').val('');
		$('[name="notes"]').text('');
	}
	
	var FIPE_API_ENDPOINT = 'https://fipe-parallelum.rhcloud.com/api/v1/';
	
	function findBrands() {
		return callFipeApi(
			FIPE_API_ENDPOINT + $('[name="type"]:checked').val() + '/marcas',
			function() {
				$('[name="brand"]').html('<option><fmt:message key="wait"/>...</option>');
			},
			function(data) {				
				fillSelectOptions($('[name="brand"]'), data);
			}
		);
	}
	
	function callFipeApi(url, callbackBefore, callbackSuccess) {
		return new Promise(function(resolve, reject) {			
			$.ajax({
				url: url,
				type: 'GET',
				dataType: 'json',
				before: callbackBefore,
				success: function(data) {
					callbackSuccess(data);
					resolve();
				},
				error: reject
			});
		});
	}
	
	function fillSelectOptions(target, optionsData) {
		var options = '<option value="" class="hide"><fmt:message key="select.an.option"/></option>';
		optionsData.forEach(function(option) {
			options += '<option value="' + option.codigo + '-' + option.nome + '">' + option.nome + '</option>';
		});
		
		target.html(options);
	}
	
	function findModels() {
		return callFipeApi(
			FIPE_API_ENDPOINT + $('[name="type"]:checked').val() + '/marcas/' + $('[name="brand"]').val().split('-')[0] + '/modelos',
			function() {
				$('[name="model"]').html('<option><fmt:message key="wait"/>...</option>');
			},
			function(data) {				
				fillSelectOptions($('[name="model"]'), data.modelos);
			}
		);
	}
</script>