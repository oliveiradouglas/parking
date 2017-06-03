<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../_commom/header.jsp" />
	<div class="container">
		<div class="row row-actions">
			<div class="col-md-12">
				<a href="<c:url value="/vehicles/entry" />" class="btn btn-primary fa fa-plus">
					<fmt:message key="new.vehicle.entry" />
				</a>			
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered table-hover datatable">
					<thead>
						<tr>
							<th><fmt:message key="mark" /></th>
							<th><fmt:message key="model" /></th>
							<th><fmt:message key="color" /></th>
							<th><fmt:message key="plate" /></th>
							<th><fmt:message key="entry" /></th>
							<th><fmt:message key="actions" /></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Ford</td>
							<td>Fiesta</td>
							<td>Branco</td>
							<td>FWZ-1645</td>
							<td>02/06/2017 16:37</td>
							<td>-</td>
						</tr>
						
						<tr>
							<td>Volksvagem</td>
							<td>Gol</td>
							<td>Prata</td>
							<td>BUQ-7360</td>
							<td>02/06/2017 12:02</td>
							<td>-</td>
						</tr>
						
						<tr>
							<td>Chevrolet</td>
							<td>Meriva</td>
							<td>Preto</td>
							<td>DKW-8301</td>
							<td>02/06/2017 07:53</td>
							<td>-</td>
						</tr>
					</tbody>
				</table>			
			</div>
		</div>
	</div>
	
	<link href="<c:url value="/public/css/dataTables.bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<c:url value="/public/js/jquery.dataTables.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/public/js/dataTables.bootstrap.min.js" />"></script>
<c:import url="../_commom/footer.jsp" />
