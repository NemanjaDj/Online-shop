<%@ include file="header.jspf"%>
<%@ include file="navigation.jspf"%>


<div class="container">

	<div class="cart_sneakers">
		<form:form action="${pageContext.request.contextPath}/userpage">
			<h3 style="text-align: center">Your cart items</h3>
			<h3 style="text-align: center">Your credit: ${userCredit}$</h3>
			<table class="cart-sneakers" id="table">
				<tr>
					<th></th>
					<th>Brand</th>
					<th>Type</th>
					<th>name</th>
					<th>price</th>
				</tr>
				<c:forEach var="tempuserSneakers" items="${usercardsneakers}">
					<tr>
						<td><img src="/images/${tempuserSneakers.image}"
							class="sneakersimages" /></td>
						<td>${tempuserSneakers.brand}</td>
						<td>${tempuserSneakers.type}</td>
						<td>${tempuserSneakers.name}</td>
						<td>${tempuserSneakers.price}</td>
						<td><a type="button" href="/removeUserSneakers?name=${tempuserSneakers.name}"
						 class="cart_buttons">remove</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>total price:</td>
					<td id="sum">${sumItems}</td>
					<td><button value="${username}"
						class="cart_buttons" name="order" onclick="alert('Order is sent!')">Order</button></td>
				</tr>
				
			</table>
		</form:form>
	</div>

</div>
<%@ include file="footer.jspf"%>