<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title>New Products</title>
    <meta name="menu" content="MapMenu"/>
</head>
<div class="span10">
    <h2>New Products</h2>
    
    <form method="post" action="${ctx}/findMatches" id="searchForm" class="form-search">
     <div id="actions" class="form-actions">
        <button id="button.search" class="btn" type="submit">
            <i class="icon-search"></i> Find Matching Products
        </button>
    </div>

	<c:set var="lstVendorProducts" value="${lstVendorProducts}" scope="request" />
    <display:table name="lstVendorProducts" class="table table-condensed table-striped table-hover"    requestURI="" id="batchList" export="true" pagesize="25">
        <display:column property="id" sortable="true" title="Product Id" />
        <display:column property="productCode" sortable="true" title="Product Code"/>
        <display:column property="productName" sortable="true" title="Product Name"/>
       
    </display:table>
    </form>
</div>