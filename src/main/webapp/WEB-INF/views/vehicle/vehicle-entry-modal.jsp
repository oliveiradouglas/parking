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

			<form method="post" class="form-horizontal">
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

<script type="text/javascript" src="<c:url value="/public/js/vanilla-masker.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/public/js/select2.min.js" />"></script>
<script type="text/javascript">
	$('#new-vehicle-entry').click(function() {
		$('#vehicle-entry-modal').modal('show');
		findBrands();
	});

	VMasker(document.querySelector('[name="vehicle_plate"]')).maskPattern("AAA-9999");
	$('[name="vehicle_plate"]').blur(function() {
		if ($(this).val().length < 8) {
			$(this).addClass('input-error');
		} else {
			$(this).removeClass('input-error');
			findAndFillVehicleData();
		}
	});
	
	$('[name="type"]').click(function() {
		findBrands();
	});
	
	$('[name="brand"]').change(function() {
		findModels();
	});
	
	function findAndFillVehicleData() {
		console.log('chamou aqui');
	}
	
	function findBrands() {
		$.ajax({
			url: 'https://fipe-parallelum.rhcloud.com/api/v1/' + $('[name="type"]:checked').val() + '/marcas',
			type: 'GET',
			dataType: 'json',
			before: function() {
				$('[name="brand"]').html('<option>Aguarde...</option>');
			},
			success: function(data) {
				var options = '<option value="" class="hide"><fmt:message key="select.an.option"/></option>';
				data.forEach(function(brand) {
					options += '<option value="' + brand.codigo + '">' + brand.nome + '</option>';
				});
				
				$('[name="brand"]').html(options);
			}
		});
	}
	
	function findModels() {
		$.ajax({
			url: 'https://fipe-parallelum.rhcloud.com/api/v1/' + $('[name="type"]:checked').val() + '/marcas/' + $('[name="brand"]').val() + '/modelos',
			type: 'GET',
			dataType: 'json',
			before: function() {
				$('[name="model"]').html('<option>Aguarde...</option>');
			},
			success: function(data) {
				var options = '<option value="" class="hide"><fmt:message key="select.an.option"/></option>';
				data.modelos.forEach(function(model) {
					options += '<option value="' + model.codigo + '">' + model.nome + '</option>';
				});
				
				$('[name="model"]').html(options);
			}
		});
	}
</script>