<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript">
	$('.datatable').DataTable({
		"language": {
			"lengthMenu": '<fmt:message key="display" /> _MENU_ <fmt:message key="records.per.page" />',
			"zeroRecords": '<fmt:message key="none.records.found" />',
			"info": '<fmt:message key="showing.page" /> _PAGE_ <fmt:message key="of" /> _PAGES_',
			"infoEmpty": '<fmt:message key="none.records.available" />',
			"infoFiltered": '(<fmt:message key="filtering.of" /> _MAX_ <fmt:message key="records.in.total" />)',
		    "emptyTable":     '<fmt:message key="no.data.available.in.table" />',
		    "loadingRecords": '<fmt:message key="loading" />',
		    "processing":     '<fmt:message key="processing" />',
		    "search":         '<fmt:message key="search" />:',
		    "paginate": {
		        "first":      '<fmt:message key="first" />',
		        "last":       '<fmt:message key="last" />',
		        "next":       '<fmt:message key="next" />',
		        "previous":   '<fmt:message key="previous" />'
		    }
		}
	});
</script>