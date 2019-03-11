<%@ include file="header.jspf" %>
<div class="login">
<form:form action="saveUser" modelAttribute="user" method="post" class="login-form">
<h2>Registration</h2>
	<table>
		<tr>
			<td><lable>Username: </lable></td>
			</tr>
			<tr>
			<td><input type="text" name="username" placeholder=" username" class="logininput"/></td>
		</tr>
		<tr>
			<td><label>Email:</label></td>
			</tr>
			<tr>
			<td><input type="text" name="email" placeholder=" email" class="logininput"/></td>
		</tr>
		<tr>
			<td><label>Password:</label></td>
			</tr>
			<tr>
			<td><input type="text" name="password" placeholder=" password" class="logininput"/></td>
		</tr>
		<tr>
			<td>
			<button style="float: right">Register</button>
			<input type="button" value="Back" onclick="history.go(-1)" class="buttons">
			</td>
		</tr>

	</table>
</form:form>
</div>
<%@ include file="footer.jspf"%>