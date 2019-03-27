<%@ include file="header.jspf" %>
<div class="login">
<form:form modelAttribute="newSneakers" method="post" class="login-form">
<h2>Add new sneakers</h2>
	<table>
	<tr>
	<!-- This hidden id is added for update, doesn't makes copy sneakers objects -->
	<td><form:input type="hidden" path="id"/></td>
	</tr>
	<tr>
			<td><label>Brand:</label></td>
			<td><form:input type="text" path="brand" name="brand" placeholder=" brand" class="logininput" /></td>
		</tr>
		<tr>
			<td><label>Name: </label></td>
			<td><form:input type="text" path="name" name="name" placeholder=" name" class="logininput" /></td>
		</tr>
		<tr>
			<td><label>Type:</label></td>
			<td><form:input type="text" path="type" name="type" placeholder=" type" class="logininput"/></td>
		</tr>
		<tr>
			<td><label>Price:</label></td>
			<td><form:input type="text" path="price" name="price" placeholder=" price" class="logininput" /></td>
		</tr>
		<tr>
			<td><label>image:</label></td>
			<td><form:input type="text" path="image" name="image" placeholder=" image" class="logininput" /></td>
		</tr>
		<tr>
			<td>
			<a type="button"  href="/adminRoom/" class="buttons" style="float: left">Back</a>
			</td>
			<td>
			<button style="float: right">Confirm</button>
			</td>
		</tr>

	</table>
</form:form>
</div>
<%@ include file="footer.jspf"%>