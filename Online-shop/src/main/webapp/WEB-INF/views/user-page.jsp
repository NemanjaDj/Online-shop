<%@ include file="header.jspf"%>
<%@ include file="navigation.jspf"%>


<div class="container">

	<!-- left vertical menu -->

	<div class="vertical_list">
		<table id="filter-table">
			<th><label>Your profile</label></th>
			<th><label>
				<a href="#">Edit</a></label></th>
			<tr>
				<td><label>Username</label></td>
				<td>${username}</td>
			</tr>
			<tr>
				<td><label>Email</label></td>
				<td>blank</td>
			</tr>
			<tr>
				<td>Remove all option</td>
			</tr>

		</table>

	</div>

	<!-- User's list of cart items -->

	<div class="card_sneakers">
	<form:form action="${pageContext.request.contextPath}/userpage" method="POST">
		<h3>Your cart items</h3>
		<table class="list-sneakers">
			<tr>
				<th>Brand</th>
				<th>Type</th>
				<th>name</th>
				<th>price</th>
			</tr>
			<c:forEach var="tempuserSneakers" items="${usercardsneakers}">
				<tr>
					<td>${tempuserSneakers.brand}</td>
					<td>${tempuserSneakers.type}</td>
					<td>${tempuserSneakers.name}</td>
					<td>${tempuserSneakers.price}</td>
					<td><button type="submit" name="sneakersname" value="${tempuserSneakers.name}" class="cart_buttons">remove</button></td>
				</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td>total price:</td>
					<td>x$</td>
					<td><input type="button" value="Order now"
						class="cart_buttons" /></td>
				</tr>
		</table>
		</form:form>
	</div>

</div>
<%@ include file="footer.jspf"%>