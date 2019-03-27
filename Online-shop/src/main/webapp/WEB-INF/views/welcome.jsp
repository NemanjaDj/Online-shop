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
	<table id="welcomeTable">
	<tr>
	<td>
	<div class="slideshow">
		<img class="mySlides" src="images/nike_lebronXVI.jpg" >
		<img class="mySlides" src="images/nike_lebronXVAshes.jpg" >
	</div>
	</td>
	<td class="SneakersType">
		<a href="/sneakers/filterSearch?brand=all&type=lifestyle&price=300"><img class="welcomeImg" src="images/lifestyle.jpg"></a>
		<a href="/sneakers/filterSearch?brand=all&type=sport&price=300"><img class="welcomeImg" src="images/sport.jpg"></a>
	</td>
	</tr>
	</table>
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