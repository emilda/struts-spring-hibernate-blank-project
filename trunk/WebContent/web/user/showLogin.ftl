<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>User Login</title>
<#include "../template/header.ftl"/>
</head>
<body>
	<#include "../template/navsection.ftl"/>
	<!-- nav title -->
	<div class="nav_namebar_div nav_title_gray">
		Login
	</div>
	<div style="clear:both"></div>
 	<div class="main_container">
 		<#include "../template/action_errors.ftl">
		<div class="reguser_div">
			
 			<@s.form action="userLogin.jspx" namespace="/user" method="post">
				<div class="input_field_div"><@s.text name="user.unique.id" />: </div>
 				<div class="input_field_div">
			 		<@s.textfield name="user.uniqueId" cssClass="input_field_normal" />
			 	</div>	
				<div class="input_field_comment">
					* (<@s.text name="user.login.unique.id.spec" />)
				</div>
				
				<div class="input_field_div"><@s.text name="user.password" />: </div>
 				<div class="input_field_div">
			 		<@s.password name="user.password" cssClass="input_field_normal" />
			 	</div>	
				<div class="input_field_comment">
					* (<@s.text name="user.login.password.spec" />)
				</div>
			 	<div style="clear:both"></div>
			 	<br>
			 	<div>
					<div class="button_div"><@s.submit value="Login" cssClass="input_button" /> &nbsp; <@s.reset value="Reset" cssClass="input_button" /></div>
					<div>
						<span class="line_span">Don't have an Account, <a href="${base}/user/register.jspx">Register an account now </a></span>
						<br/><span class="line_span"><a href="${base}/user/user_resetpwd.jspx">Forgot your password?</a></span>
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

