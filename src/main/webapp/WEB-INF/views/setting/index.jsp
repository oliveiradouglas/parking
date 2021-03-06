<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../commom/head.jsp" />
<div class="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-cog"></i>
					<fmt:message key="settings" />
				</div>

				<div class="panel-body">
					<form class="form-horizontal" id="settings-form" method="POST">
						<div class="form-group">
							<label class="control-label col-sm-4">
								<fmt:message key="parking.name" />
							</label>
							<div class="col-sm-7">
								<input type="text" class="form-control"
								 placeholder="<fmt:message key="parking.name" />" 
								 name="parking_name" 
								 value="${ setting != null ? setting.parkingName : '' }" 
								 maxlength="30" 
								 required />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-4">
								<fmt:message key="first.hour.value" />
							</label>
							<div class="col-sm-7">
								<input type="text" class="form-control money" 
								placeholder="<fmt:message key="type.value" />" 
								name="first_hour_value" 
								value="<fmt:formatNumber value="${setting != null ? setting.firstHourValue : ''}" type="currency" currencySymbol="" />"" 
								maxlength="6"
								required />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-4">
								<fmt:message key="other.hours.value" />
							</label>
							<div class="col-sm-7">
								<input type="text" class="form-control money" 
								placeholder="<fmt:message key="type.value" />" 
								name="other_hours_value" 
								value="<fmt:formatNumber value="${setting != null ? setting.otherHoursValue : ''}" type="currency" currencySymbol="" />" 
								maxlength="6"
								required />
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-11 text-right">
								<button type="submit" class="btn btn-primary">Salvar</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<c:import url="../commom/foot.jsp" />

<script type="text/javascript" src="<c:url value="/public/js/jquery.maskMoney.min.js" />"></script>
<script type="text/javascript">
	$('.money').maskMoney({
		thousands: '.',
		decimal: ','
	});
</script>