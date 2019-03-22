<%@ include file="header.jspf" %>
<div class="login">
<form:form action="addSneakers" modelAttribute="newSneakers" method="post" class="login-form">
<h2>Add new sneakers</h2>
	<table>
	<tr>
			<td><label>Brand:</label></td>
			<td><input type="text" name="brand" placeholder=" brand" class="logininput" required /></td>
		</tr>
		<tr>
			<td><label>Name: </label></td>
			<td><input type="text" name="name" placeholder=" name" class="logininput" required /></td>
		</tr>
		<tr>
			<td><label>Type:</label></td>
			<td><input type="text" name="type" placeholder=" type" class="logininput" required /></td>
		</tr>
		<tr>
			<td><label>Price:</label></td>
			<td><input type="text" name="price" placeholder=" price" class="logininput" required /></td>
		</tr>
		<tr>
			<td><label>image:</label></td>
			<td><input type="text" name="image" placeholder=" image" class="logininput" required /></td>
		</tr>
		<tr>
			<td>
			<a type="button"  href="/adminRoom/" class="buttons" style="float: left">Back</a>
			<button style="float: right">Confirm</button>
			</td>
		</tr>

	</table>
</form:form>
</div>
<%@ include file="footer.jspf"%>