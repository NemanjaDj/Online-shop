<%@ include file="header.jspf"%>
<%@ include file="navigation.jspf"%>


<div class="container">

	<!-- User's list of cart items -->

	<div class="user-list">
		<form:form action="/adminRoom/removeUser" method="POST" modelAttribute="userlist">
			<h3 style="text-align: center">List of all users</h3>
			<table class="tableofusers">
				<tr>
					<th>username</th>
					<th>email</th>
				</tr>
				<c:forEach var="users" items="${userlist}">
					<tr>
						<td>${users.username}</td>
						<td>${users.email}</td>
						<td><button type="submit" name="removeUser" value="${users.username}"
								class="cart_buttons">remove</button></td>
					</tr>
				</c:forEach>

			</table>
		</form:form>
	</div>

</div>

<%@ include file="footer.jspf"%>