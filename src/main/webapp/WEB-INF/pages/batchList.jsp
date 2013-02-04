<%@ include file="/common/taglibs.jsp"%>
<head>
    <title>New Batches</title>
    <meta name="menu" content="MapMenu"/>
</head>
<div class="span10">
    <h2>New Batches</h2>

    <display:table name="lstVendorProductUploadLogs" class="table table-condensed table-striped table-hover" requestURI="" id="batchList" export="false" pagesize="25">
        <display:column property="id" sortable="true" href="displayProducts" media="html"
            paramId="id" paramProperty="id" title="Batch Id" />
        <display:column property="uploadedOn" sortable="true" title="Uploaded On"/>
        <display:column property="csVendors.vendorName" sortable="true" title="Vendor"/>
       
    </display:table>
</div>