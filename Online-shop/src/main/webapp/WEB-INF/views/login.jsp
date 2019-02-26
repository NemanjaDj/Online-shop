<%@ include file="header.jspf" %>
<%@ include file="navigation.jspf" %>
<div class="login">
<form class="login-form">
<h2>Login</h2>
	<table>
		<tr>
			<td>Email:</td>
			<td><input type="text" placeholder=" enter email"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" placeholder=" enter password"/></td>
		</tr>
		<tr>
			<td><button>Log in</button></td>
		</tr>

	</table>
</form>
<a href="/login/registration">Registration</a>
</div>

<%@ include file="footer.jspf"%>