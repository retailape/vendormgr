<%@ include file="/common/taglibs.jsp"%>
<head>
    <title>Product Hints</title>
    <meta name="menu" content="MapMenu"/>
</head>
<div class="span10">
    <h2>Product Hints</h2>
    
    <form method="post" action="${ctx}/approveMatch" id="searchForm" class="form-search">
     <div id="actions" class="form-actions">
        <button id="button.map" class="btn" type="submit">
            <i class="icon-ok"></i> Save
        </button>
    </div>
	<s:set var="lstVendorProductMappings" value="lstVendorProductMappings" scope="request"></s:set>
    <display:table name="lstVendorProductMappings"  class="table table-condensed table-striped table-hover" requestURI="" id="lstProductMaping" export="false" pagesize="50">
    	<display:column property="vendorProducts.productCode" sortable="true" title="Vendor Product Code"/>
        <display:column property="vendorProducts.productName" sortable="true" title="Vendor Product Name" /> 
        <display:column title="Matching Products" >
        <display:table name="${lstProductMaping.lstCSProducts}"  class="table table-condensed table-striped table-hover" requestURI="" id="lstCSProducts" export="false" >
            <display:column style="width:50px">
            	<input type="radio" name="lstMatchingProductIds[${lstProductMaping_rowNum}]" value="${lstCSProducts.productId}"/>  
        	</display:column>
        	<display:column property="productCode" sortable="true" title="Vendor Product Code"/>
        <%--  	<s:iterator value="lstCSProducts.productDescriptions" id="names">
        	<c:if test="${names.key.langCode}==EN">teat</c:if>
        	<display:column property="names.product" sortable="true" title="Vendor Product Name" /> 
        	</s:iterator>--%>
        </display:table>
        </display:column>
        
  <%--       
       <display:column title="Is Valid Hint"
                        style="width: 16%; padding-left: 15px" media="html" paramId="sid" paramProperty="id">${lstProductMaping.id}
            <input type="checkbox" checked="checked" value="${lstProductMaping.id}"/>
        </display:column>--%>
    </display:table>
    
    </form>
</div>