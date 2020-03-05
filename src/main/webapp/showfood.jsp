<%@page import="se.rezaul.PointOfSale.ShowFoodRepository"%>
<%@page import="se.rezaul.PointOfSale.OrderRepository"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="se.rezaul.PointOfSale.ShowFood"%>
<%@page import="se.rezaul.PointOfSale.Order"%>
<!DOCTYPE html>
<html>
<title>Food House</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}

html, body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
</style>
<style>
table, th, td {
	border: 1px solid black;
}

.edit_btn {
	text-decoration: none;
	padding: 2px 5px;
	background: #2E8B57;
	color: white;
	border-radius: 3px;
}

.btn-show {
	text-decoration: none;
	padding: 2px 5px;
	color: white;
	border-radius: 3px;
	background: #28D456;
}

.del_btn {
	text-decoration: none;
	padding: 2px 5px;
	color: white;
	border-radius: 3px;
	background: #800000;
}
.pay_btn {
	text-decoration: none;
	padding: 2px 5px;
	color: white;
	border-radius: 3px;
	background: #28D456;
}
</style>
<body class="w3-light-grey">

	<!-- Top container -->
	<div class="w3-bar w3-top w3-black w3-large" style="z-index: 4">
		<span class="w3-bar-item w3-right">Point Of Sale</span>
	</div>

	<!-- Sidebar/menu -->
	<nav class="w3-sidebar w3-collapse w3-white w3-animate-left"
		style="z-index: 3; width: 300px;" id="mySidebar">
		<br>
		<div class="w3-container w3-row">

			<div class="w3-col s8 w3-bar">

				<a href="#" class="w3-bar-item w3-button"><i
					class="fa fa-envelope"></i></a> <a href="#"
					class="w3-bar-item w3-button"><i class="fa fa-user"></i></a> <a
					href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
			</div>
		</div>
		<hr>
		<div class="w3-container">
			<h5>Dashboard</h5>
		</div>
		<div class="w3-bar-block">
			<a href="#"
				class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black"
				onclick="w3_close()" title="close menu"><i
				class="fa fa-remove fa-fw"></i>  Close Menu</a> <a href="addItem.jsp"
				class="w3-bar-item w3-button w3-padding"><i
				class="fa fa-plus fa-fw"></i>  Add Item</a> <a href="order.jsp"
				class="w3-bar-item w3-button w3-padding"><i
				class="fa fa-list fa-fw"></i> Orders List</a> <a href="about.jsp"
				class="w3-bar-item w3-button w3-padding"><i
				class="fa fa-user fa-fw"></i>  About</a>

		</div>
	</nav>


	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" title="close side menu"
		id="myOverlay"></div>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">

		<!-- Header -->
		<header class="w3-container" style="padding-top: 22px">
			<a href="index.jsp"><b><i class="fa fa-dashboard"></i> My
					Dashboard</b></a>
		</header>

		<div class="w3-row-padding w3-margin-bottom">
			<div class="w3-quarter">
				<div class="w3-container w3-blue w3-padding-16">
					<div class="w3-left">
						<i class="fa fa-list w3-xxxlarge"></i>
					</div>
					<div class="w3-right">
						<h3>0</h3>
					</div>
					<div class="w3-clear"></div>
					<a href="order.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-list fa-fw"></i> Orders List</a>
				</div>
			</div>

			<div class="w3-quarter">
				<div class="w3-container w3-orange w3-text-white w3-padding-16">
					<div class="w3-left">
						<i class="fa fa-user w3-xxxlarge"></i>
					</div>
					<div class="w3-right">
						<h3>0</h3>
					</div>
					<div class="w3-clear"></div>
					<a href="itemList.jsp"><h4>Food List</h4></a>
				</div>
			</div>
		</div>
		<%
			ShowFoodRepository getFood = new ShowFoodRepository();
		ShowFoodRepository orderStatusUpdate = new ShowFoodRepository();
			
			Order order = new Order();
			String id = request.getParameter("id");
			List<ShowFood> foodList = getFood.getShowFood(id);

			Iterator<ShowFood> it_foodList = foodList.iterator();
		%>

		<table style="width: 100%" align="center">
			<h2 align="center">Food List:</h2>
			<tr>
				<th>SL No</th>
				<th>Name</th>
				<th>Category Name</th>
				<th>Table No</th>
				<th>Price(Per Item)</th>
				<th>Quantity</th>
				<th>Total Price</th>
			</tr>

			<%
				ShowFood food = new ShowFood();

				//OrderRepository order = new OrderRepository();
				int sum = 0;
				while (it_foodList.hasNext()) {
					// ShowFood food = new ShowFood();
					food = it_foodList.next();
			%>

			<tr>
				<td align="center"><%=food.getId()%></td>
				<td align="center"><%=food.getItem_name()%></td>
				<td align="center"><%=food.getItem_category()%></td>
				<td align="center"><%=food.getTable_name()%></td>
				<td align="center"><%=food.getItem_price()%></td>
				<td align="center"><%=food.getItem_quantity()%></td>
				<td align="center"><%=food.getItem_price() * food.getItem_quantity()%></td>

			</tr>

			<%
				sum = sum + (int) (food.getItem_price() * food.getItem_quantity());
				}
			%>
			<tr>
				<td colspan="6" align="right">Total Cost=</td>
				<td align="center"><%=sum%></td>
			</tr>
			
		</table>
	 	<a href= "order.jsp" class="pay_btn" >Back</a>
<%-- 	 <%out.println(order.getId()); %> --%>
		<hr>
	</div>
</body>
</html>
