<%@ include file="header.jspf" %>
<%@ include file="navigation.jspf" %>
<div class="login">
<form action="saveUser" modelAttribute="user" method="post" class="login-form">
<h2>Registration</h2>
	<table>
		<tr>
			<td><lable>Name: </lable></td>
			<td><input type="text" name="name" placeholder=" name"/></td>
		</tr>
		<tr>
			<td><label>Email:</label></td>
			<td><input type="text" name="email" placeholder=" email"/></td>
		</tr>
		<tr>
			<td><label>Password:</label></td>
			<td><input type="text" name="password" placeholder=" password"/></td>
		</tr>
		<tr>
			<td><button>Register</button></td>
		</tr>

	</table>
</form>
</div>
<%@ include file="footer.jspf"%>