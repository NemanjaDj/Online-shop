<%@ include file="header.jspf"%>
<%@ include file="navigation.jspf"%>


<div class="container">

	<div class="cart_sneakers">
		<form:form action="${pageContext.request.contextPath}/userpage"
			method="POST">
			<h3 style="text-align: center">Your cart items</h3>
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
						<td><button type="submit" name="sneakersname"
								value="${tempuserSneakers.name}" class="cart_buttons">remove</button></td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>total price:</td>
					<td id="sum"></td>
					<td><input type="button" value="Order now"
						class="cart_buttons" onclick="alert('Order is sent!')"/></td>
				</tr>
				
			</table>
		</form:form>
	</div>

</div>
<script type="text/javascript">
// count total sum of cart items
let rows = document.querySelectorAll("table tr td:nth-child(5)");
let sum = 0;
for (let i = 0; i < rows.length-1; i++) {
    sum += Number(rows[i].textContent);
}

document.getElementById("sum").textContent = sum;
</script>
<%@ include file="footer.jspf"%>