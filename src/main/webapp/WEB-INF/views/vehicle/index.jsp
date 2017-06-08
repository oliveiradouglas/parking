<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../commom/head.jsp" />
	<div class="container">
		<div class="row row-actions">
			<div class="col-md-12">
				<button type="button" class="btn btn-primary fa fa-plus" id="new-vehicle-entry">
					<fmt:message key="new.vehicle.entry" />
				</button>
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
						<c:forEach var="vehicle" items="${vehicles}">						
							<tr>
								<td>${vehicle.mark}</td>
								<td>${vehicle.model}</td>
								<td>${vehicle.color}</td>
								<td>${vehicle.plate}</td>
								<td>
									<fmt:formatDate value="${vehicle.entry}" type="both" dateStyle="short" timeStyle="short"/>
								</td>
								<td class="text-center">
									<button type="button" class="btn btn-default" title="<fmt:message key="view.details" />" data-item="${vehicle.id}">
										<i class="fa fa-eye"></i>
									</button>
									
									<button type="button" class="btn btn-danger btn-vehicle-exit" title="<fmt:message key="give.low" />" data-item="${vehicle.id}">
										<i class="fa fa-arrow-down"></i>
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>			
			</div>
		</div>
	</div>
	
	<link href="<c:url value="/public/css/dataTables.bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<c:url value="/public/js/jquery.dataTables.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/public/js/dataTables.bootstrap.min.js" />"></script>
	<c:import url="../components/start-datatable.jsp" />
	<c:import url="vehicle-entry-modal.jsp" />
	<c:import url="vehicle-exit-modal.jsp" />
<c:import url="../commom/foot.jsp" />
