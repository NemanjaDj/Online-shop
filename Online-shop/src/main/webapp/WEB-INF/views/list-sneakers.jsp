<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>


<div id="container">

	<form action="<spring:url value="/sneakers/sneakers_search" />" >
		<input type="text" name="freeText" placeholder="Search by name">
			<button>Find</button>
			</form>

	<div class="vertical-menu">
		<form action="<spring:url value="/sneakers/filterSearch" />">
			<table>
				<th>Filter</th>

				<tr>
					<td>Brand:</td>
					<td><select name="brand">
							<option value="" default>all</option>
							<option value="nike">nike</option>
							<option value="adidas">adidas</option>
							<option value="Puma">puma</option>
							<option value="Reebok">reebok</option>
					</select></td>
				</tr>
				<tr>
					<td>Type</td>
					<td><select name="type">
							<option value="" default>all</option>
							<option value="sport">sport</option>
							<option value="lifestyle">lifestyle</option>
					</select></td>
				</tr>
				<tr>
					<td>Price</td>
				</tr>
				<tr>
					<td><button>Search</button></td>
				</tr>
			</table>
		</form>
	</div>


	<table class="w3-table w3-striped">
		<tr>
			<th>Brand</th>
			<th>Type</th>
			<th>name</th>
			<th>price</th>
		</tr>

		<c:forEach var="tempSneakers" items="${sneakers}">

			<tr>
				<td>${tempSneakers.brand}</td>
				<td>${tempSneakers.type}</td>
				<td>${tempSneakers.name}</td>
				<td>${tempSneakers.price}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>
