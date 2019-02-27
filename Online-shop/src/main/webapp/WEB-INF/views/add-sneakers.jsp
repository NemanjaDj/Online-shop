<%@ include file="header.jspf" %>
<%@ include file="navigation.jspf" %>
<div>
<form action="addSneakers" modelAttribute="newSneakers" method="post" >
<h2>Add new sneakers</h2>
	<table>
	<tr>
			<td><label>Brand:</label></td>
			<td><input type="text" name="brand" placeholder=" brand"/></td>
		</tr>
		<tr>
			<td><lable>Name: </lable></td>
			<td><input type="text" name="name" placeholder=" name"/></td>
		</tr>
		<tr>
			<td><label>Type:</label></td>
			<td><input type="text" name="type" placeholder=" type"/></td>
		</tr>
		<tr>
			<td><label>Price:</label></td>
			<td><input type="text" name="price" placeholder=" price"/></td>
		</tr>
		<tr>
			<td><button>Confirm</button></td>
		</tr>

	</table>
</form>
</div>
<%@ include file="footer.jspf"%>