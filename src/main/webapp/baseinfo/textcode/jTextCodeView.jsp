<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
%>

<html>
<head>
    <title></title>

	<link rel="stylesheet" rev="stylesheet" type="text/css" href="<%=path %>/skin/default/css/default.css" media="all" />
	<script type="text/javascript" src="<%=path %>/js/common.js"></script>
	
</head>
<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div>
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
浏览代码名称
    </div> 
    </div>
    </div>

    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">分类：</td>
	            <td class="tableContent">${classCode.name}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle">名称：</td>
	            <td class="tableContent">${name}</td>
	        </tr>
		</table>
	</div>
</div>
 
</form>
</body>
</html>

