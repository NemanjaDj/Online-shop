<%@ include file="header.jspf"%>
<%@ include file="navigation.jspf"%>

<!-- left vertical menu -->
<!-- left vertical menu - search by name-->
<div class="container">
	<div class="vertical_list">
		<form action="<spring:url value="/sneakers/sneakers_search" />">
			<input type="text" name="freeText" placeholder="Search by name"
				class="freeText">
			<button class="light-button">Find</button>
		</form>

		<!-- left vertical menu - filter select -->
		<form action="<spring:url value="/sneakers/filterSearch" />">
			<table id="filter-table">
				<th><label>Filter</label></th>
				<tr>
					<td><label>Brand</label></td>
					<td><select name="brand">
							<option value="all">all</option>
							<option value="nike">nike</option>
							<option value="adidas">adidas</option>
							<option value="Puma">puma</option>
							<option value="Reebok">reebok</option>
					</select></td>
				</tr>
				<tr>
					<td><label>Type</label></td>
					<td><select name="type">
							<option value="all">all</option>
							<option value="sport">sport</option>
							<option value="lifestyle">lifestyle</option>
					</select></td>
				</tr>
				<tr>
					<td>Price (up to)</td>
					<td><input type="range" name="price" min="125" max="300"
						value="300" class="slider" id="myRange"></td>
					<td><span id="demo"></span></td>
				</tr>
				<tr>
					<td><button class="light-button">Search</button></td>
				</tr>
			</table>
		</form>
	</div>

	<!-- List of sneakers - table -->

	<div class="sneakers-div">
	<form:form action="${pageContext.request.contextPath}/sneakers/" method="POST">
		<table class="list-sneakers">
			<tr>
				<th></th>
				<th>Brand</th>
				<th>Type</th>
				<th>name</th>
				<th>price</th>
			</tr>

			<c:forEach var="tempSneakers" items="${sneakers}">

				<tr>
					<td><img src="/images/${tempSneakers.image}" class="sneakersimages"/></td>
					<td>${tempSneakers.brand}</td>
					<td>${tempSneakers.type}</td>
					<td>${tempSneakers.name}</td>
					<td>${tempSneakers.price}$</td>
					
					<c:if test="${username ne 'anonymousUser'}">
					<td><button type="submit" name="sneakersname" value="${tempSneakers.name}" 
					class="cart_buttons">add to cart</button></td>
					</c:if>
					
					<c:if test="${username == 'admin'}">
					<td><a type="button" href="/sneakers/update?id=${tempSneakers.id}" class="cart_buttons">update</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		</form:form>
	</div>
	
</div>

<script>
	// slide show code
	var slider = document.getElementById("myRange");
	var output = document.getElementById("demo");
	output.innerHTML = slider.value; // Display the default slider value

	// Update the current slider value (each time you drag the slider handle)
	slider.oninput = function() {
		output.innerHTML = this.value;
	}
</script>

<%@ include file="footer.jspf"%>
