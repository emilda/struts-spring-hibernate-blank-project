<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Welcome</title>
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
		<div class="content_title">Researcher</div>
		<div class="content_div">Dr. Claire Palermo - +61 3 9594 5652</div>
		<br/>
		
		<div class="content_title">Project Manager</div>
		<div class="content_div">Anitha Kannan - +61 3 9905 4670</div>
		<br/>
		
		<div class="content_title">Business Analyst</div>
		<div class="content_div">Dharani Perera-Schulz - +61 3 9902 0534</div>
		<br/>
		
		<div class="content_title">Developer</div>
		<div class="content_div">Sindhu Emilda - +61 3 9902 0795</div>
		<br/>
		
		<div class="content_title">Business Statistics</div>
		<div class="content_div">Dr.Kompal Sinha - +61 3 9905 2457</div>
		
 	</div>
	<#include "../template/footer.ftl"/>
 	<br/>
 	<br/>
</body>
</html>