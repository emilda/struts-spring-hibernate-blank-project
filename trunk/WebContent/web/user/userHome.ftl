<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Welcome </title>
	<#include "../template/header.ftl"/>
	<script>
	 $(document).ready(function() {
		$('#merc').coinslider({ hoverPause: true, width: 400,height: 220, opacity: 0.3 });
	});
	</script>
</head>
<body>
	<#include "../template/navsection.ftl"/>
	<!-- nav title -->
	<div class="nav_namebar_div nav_title_gray">
		Contact Us
	</div>
	<div style="clear:both"></div>
	<div class="main_container">
		<div class="content_title">Welcome</div>
		<div class="content_div">Profile information</div>
		<div class="empty_div"></div>  	
		<div class="empty_div"></div>
 	</div>
	<#include "../template/footer.ftl"/>
 	<br/>
 	<br/>
</body>
</html>