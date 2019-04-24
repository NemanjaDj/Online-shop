<%@ include file="header.jspf"%>
<%@ include file="navigation.jspf"%>


<div class="container">

	<div class="addCredit">
		<form:form
			action="${pageContext.request.contextPath}/adminRoom/listOfUsers"
			method="POST" modelAttribute="userlist">
			<table>
				<tr>
					<td><p style="font-style: italic">Add credit to user</p></td>
				</tr>
				<tr>
				<td><label>Select user</label></td>
				</tr>
				<tr>
					<td><select name="user" id="selectUser">
							<c:forEach var="users" items="${userlist}">
								<option>${users.username}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
				<td><label>Add credit</label></td>
				</tr>
				<tr>
					<td><input type="text" size="10" name="credit" value="0" id="addCredit" /></td>
				</tr>
				<tr>
					<td><button type="submit" name="update"
							value="${users.username}" class="cart_buttons"> Confirm </button></td>
				</tr>
			</table>
		</form:form>
	</div>

	<!-- User's list of cart items -->

	<div class="user-list">
		<form:form>
			<h3 style="text-align: center">List of all users</h3>
			<table class="tableofusers">
				<tr>
					<th>username</th>
					<th>email</th>
					<th>credit</th>
				</tr>
				<c:forEach var="users" items="${userlist}">
					<tr>
						<td>${users.username}</td>
						<td>${users.email}</td>
						<td>${users.credit}</td>
						<td><a type="button"
							href="removeUser/?username=${users.username}"
							class="cart_buttons">remove</a></td>
					</tr>
				</c:forEach>

			</table>
		</form:form>
	</div>

</div>

<%@ include file="footer.jspf"%>