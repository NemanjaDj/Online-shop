<%@ include file="header.jspf" %>
<%@ include file="navigation.jspf" %>


<div class="container">

<!-- left vertical menu -->

<div class="vertical_list">
			<table id="filter-table">
				<th><lable>Your profile</lable></th>
				<th><lable><a href="#">Edit</a></lable></th>
				<tr>
					<td><lable>Username</lable></td>
					<td> ${username} </td>
				</tr>
				<tr>
					<td><lable>Email</lable></td>
					<td> blank </td>
				</tr>
				<tr>
					<td>Remove all option</td>
				</tr>
				
			</table>
		
	</div>

<!-- User's list of card items -->

<div class="card_sneakers">
<h3>Your card items</h3>
	<table class="list-sneakers">
		<tr>
			<th>Brand</th>
			<th>Type</th>
			<th>name</th>
			<th>price</th>
		</tr>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><input type="button" value="Remove" class="card_buttons"/></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>total price:</td>
				<td>x$</td>
				<td><input type="button" value="Order now" class="card_buttons"/></td>
			</tr>
	</table>
	</div>







</div>
<%@ include file="footer.jspf" %>