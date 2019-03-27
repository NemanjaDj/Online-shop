<%@ include file="header.jspf"%>
<div class="login">
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		class="login-form" method="POST">
		<h2>Login</h2>

		<c:if test="${param.error != null}">
			<i style="color: red">Sorry! You entered invalid username or
				password.</i>
		</c:if>

		<c:if test="${param.logout != null}">
			<i style="color: green">You have been logged out.</i>
		</c:if>

		<table>
			<tr>
				<td>Username</td>
			</tr>
			<tr>
				<td><input type="text" name="username"
					placeholder=" enter username" class="logininput"/></td>
			</tr>
			<tr>
				<td>Password</td>
			</tr>
			<tr>
				<td><input type="password" name="password"
					placeholder=" enter password" class="logininput"/></td>
			</tr>
			<tr>
				<td>
				<a type="button"  href="/" style="float: left" class="buttons">Back</a>
				<button style="float: right">Login</button>
				</td>
			</tr>

		</table>
		You don't have an account, make one <a href="/login/registration">now</a>.
	</form:form>
	
</div>
<%@ include file="footer.jspf"%>