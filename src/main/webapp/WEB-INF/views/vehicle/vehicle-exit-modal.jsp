<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="vehicle-exit-modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">
					<fmt:message key="register.vehicle.exit" />
				</h4>
			</div>

			<form method="post" class="form-horizontal">
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
								<fmt:message key="plate" />
							</label>
							
							<div class="col-sm-12">
								<input type="text" class="form-control" disabled="disabled" id="ve-plate" />
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-6">
							<label class="col-sm-12"> 
								<fmt:message key="entry" />
							</label>
							
							<div class="col-sm-12">
								<input type="text" class="form-control" disabled="disabled" id="ve-entry-time" />
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
								<fmt:message key="form.of.payment" />
							</label>
							
							<div class="col-sm-12">
								<select class="form-control" name="form_payment_id" required>
									<option value="" selected="selected">
										<fmt:message key="select.an.option"/>
									</option>
								</select>
							</div>
						</div>
						
						<div class="col-sm-6">
							<label class="col-sm-12"> 
								<fmt:message key="paid.value" />
							</label>
							
							<div class="col-sm-12">
								<input type="text" class="form-control" name="paid_value" maxlength="12" required />
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-6">
							<label class="col-sm-12">
								<fmt:message key="notes" />
							</label>
							
							<div class="col-sm-12">
								<textarea class="form-control" maxlength="255" rows="4" name="notes"></textarea>
							</div>
						</div>
						
						<div class="col-sm-6">
							<label class="col-sm-12"> 
								<fmt:message key="total" />
							</label>
							
							<div class="col-sm-12" id="ve-total-box">
								<fmt:message key="monetary.symbol" />
								<span>0,00</span>
							</div>
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
	$('.btn-vehicle-exit').click(function() {
		$('#vehicle-exit-modal').modal('show');
	});
</script>