<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>


<div id="container">

	<div class="vertical-menu">
		<form:form action="filterSneakers" modelAttribute="filter" method="POST">
			<table>
				<th>Filter</th>

				<tr>
					<td>Brand:</td>
					<td><select path="brand">
							<option value="*" default>all</option>
							<option value="nike">Nike</option>
							<option value="adidas">Adidas</option>
							<option value="Puma">Puma</option>
							<option value="Reebok">Reebok</option>
					</select></td>
				</tr>
				<tr>
					<td>Type</td>
					<td><select path="type">
							<option value="*" default>all</option>
							<option value="sport">Sport</option>
							<option value="lifestyle">Lifestyle</option>
					</select></td>
				</tr>
				<tr>
					<td>Price</td>
				</tr>
				<tr>
					<td><input type="submit" value="Search" /></td>
				</tr>
			</table>
		</form:form>
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
