<%@ include file="header.jspf"%>
<%@ include file="navigation.jspf"%>


<div class="container">

	<!-- Welcome text -->

	<c:if test="${username ne 'anonymousUser'}">
		<h3>
			<c:out value="Welcome ${username}!" />
		</h3>
	</c:if>
	<h3>New collection!</h3>
	<p>New spring collection is available now</p>

	<!-- Slide show  -->

	<div class="w3-content w3-section" style="max-width: 500px">
		<img class="mySlides" src="images/lebronXVI-1.jpg" style="width: 100%">
		<img class="mySlides" src="images/lebron15-ashes.jpg"
			style="width: 100%">
	</div>
</div>

<script>
	var myIndex = 0;
	carousel();

	function carousel() {
		var i;
		var x = document.getElementsByClassName("mySlides");
		for (i = 0; i < x.length; i++) {
			x[i].style.display = "none";
		}
		myIndex++;
		if (myIndex > x.length) {
			myIndex = 1
		}
		x[myIndex - 1].style.display = "block";
		setTimeout(carousel, 2000); // Change image every 2 seconds
	}
</script>

<%@ include file="footer.jspf"%>