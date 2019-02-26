<%@ include file="header.jspf"%>
<%@ include file="navigation.jspf"%>


<div id="container">
	<div class="vertical-list">
		<form action="<spring:url value="/sneakers/sneakers_search" />">
			<input type="text" name="freeText" placeholder="Search by name" class="freeText">
			<button>Find</button>
		</form>


		<form action="<spring:url value="/sneakers/filterSearch" />">
			<table id="filter-table">
				<th><lable>Filter</lable></th>
				<tr>
					<td><lable>Brand</lable></td>
					<td><select name="brand">
							<option value="%" default>all</option>
							<option value="nike">nike</option>
							<option value="adidas">adidas</option>
							<option value="Puma">puma</option>
							<option value="Reebok">reebok</option>
					</select></td>
				</tr>
				<tr>
					<td><lable>Type</lable></td>
					<td><select name="type">
							<option value="%" default>all</option>
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

	<div class="sneakers-div">
	<table class="list-sneakers">
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
</div>
<%@ include file="footer.jspf"%>
