<%@ include file="header.jspf" %>
<div class="login">
<form:form action="saveUser" modelAttribute="user" method="post" class="login-form">
<h2>Registration</h2>
	<table>
		<tr>
			<td><label>Username: </label></td>
			</tr>
			<tr>
			<td><form:input type="text" path="username" name="username" placeholder=" username" class="logininput"/></td>
			</tr>
			<tr>
			<td><form:errors path="username" cssClass="error" style="color:red"/></td>
		</tr>
		<tr>
			<td><label>Email:</label></td>
			</tr>
			<tr>
			<td><form:input type="text" path="email" name="email" placeholder=" email" class="logininput"  /></td>
			</tr>
			<tr>
			<td><form:errors path="email" cssClass="error" style="color:red"/></td>
		</tr>
		<tr>
			<td><label>Password:</label></td>
			</tr>
			<tr>
			<td><form:input type="password" path="password" name="password" placeholder=" password" class="logininput"  /></td>
			</tr>
			<tr>
			<td><form:errors path="password" cssClass="error" style="color:red"/></td>
		</tr>
		<tr>
			<td>
			<button type="submit" style="float: right">Register</button>
			<a type="button"  href="/login/" class="buttons" style="float: left">Back</a>
			</td>
		</tr>

	</table>
</form:form>
</div>
<%@ include file="footer.jspf"%>