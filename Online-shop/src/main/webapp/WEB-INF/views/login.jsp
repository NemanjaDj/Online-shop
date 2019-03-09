<%@ include file="header.jspf" %>
<%@ include file="navigation.jspf" %>
<div class="login">
<form:form action="${pageContext.request.contextPath}/authenticateTheUser" class="login-form" method="POST">
<h2>Login</h2>
<c:if test="${param.error != null}">
	<i style="color: red">Sorry! You entered invalid username or password.
	Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</i>
</c:if>
	<table>
		<tr>
			<td>Username:</td>
			<td><input type="text" name="username" placeholder=" enter username"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" placeholder=" enter password"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login"></td>
		</tr>

	</table>
</form:form>
<a href="/login/registration">Registration</a>
</div>

<%@ include file="footer.jspf"%>