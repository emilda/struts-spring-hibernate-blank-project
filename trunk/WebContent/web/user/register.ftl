<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Monash User Registration</title>
<#include "../template/header.ftl"/>
</head>
<body>
	<#include "../template/navsection.ftl"/>
	<!-- nav title -->
	<div class="nav_namebar_div nav_title_gray">
		Monash User Registration
	</div>
	<div style="clear:both"></div>
	<!-- main body -->
 	<div class="main_container">
 		<#include "../template/action_errors.ftl">
		<div class="reguser_div">
		
		<@s.form action="registerLdapUser.jspx" name="registeruser" namespace="/user" method="post">
			 <div class="input_field_div"> Monash Authcate ID: </div>
			 <div class="input_field_div">
			 	<@s.textfield name="user.uniqueId" cssClass="input_field_normal" />
			 </div>	
			 <div class="input_field_comment">
			 	* (<@s.text name="user.register.ldap.authcate.id.spec" />)
			 </div>
			 
			 <div class="input_field_div"> Password: </div>
			 <div class="input_field_div">
			 	<@s.password name="user.password" cssClass="input_field_normal" />
			 </div>	
			 <div class="input_field_comment">
			 	* (<@s.text name="user.register.ldap.authcate.password.spec" />)
			 </div>
			 
			 <br>
			 <div>
			 	<div class="button_div">
					<@s.submit value="Register" cssClass="input_button" /> &nbsp; <@s.reset value="Clear" cssClass="input_button" />
				</div>
				<div>
					<span class="line_span">If you already have an account, please <a href="${base}/user/showLogin.jspx">Sign in now </a></span>
				</div>
				<div style="clear:both"></div>
			</div>
		</@s.form>
		</div>
        <br/>
	 	<div style="clear:both"></div>
 	</div>
	<#include "../template/footer.ftl"/>
</body>
</html>


