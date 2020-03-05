<%@page import="se.rezaul.PointOfSale.OrderRepository"%>
<%@page import="se.rezaul.PointOfSale.ShowFoodRepository"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="se.rezaul.PointOfSale.Order"%>
<!DOCTYPE html>
<html>
<title>Food House</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
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
.pay_btn {
	text-decoration: none;
	padding: 2px 5px;
	color: white;
	border-radius: 3px;
	background: #28D456;
}

.btn-show {
    text-decoration: none;
    padding: 2px 5px;
    color: white;
    border-radius: 3px;
    background: #28D456;
}
</style>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <span class="w3-bar-item w3-right">Point Of Sale</span>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
   
    <div class="w3-col s8 w3-bar">
     
      <a href="#" class="w3-bar-item w3-button"><i class="fa fa-envelope"></i></a>
      <a href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
      <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
    </div>
  </div>
  <hr>
  <div class="w3-container">
    <h5>Dashboard</h5>
  </div>
  <div class="w3-bar-block">
    <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
    <a href="addItem.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-plus fa-fw"></i>  Add Item</a>
    <a href="order.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-list fa-fw"></i> Orders List</a>
    <a href="about.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user fa-fw"></i>  About</a>
    
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
   <a href ="index.jsp"><b><i class="fa fa-dashboard"></i> My Dashboard</b></a>
  </header>

  <div class="w3-row-padding w3-margin-bottom">
    <div class="w3-quarter">
      <div class="w3-container w3-blue w3-padding-16">
        <div class="w3-left"><i class="fa fa-list w3-xxxlarge"></i></div>
        <div class="w3-right">
          <h3>0</h3>
        </div>
        <div class="w3-clear"></div>
        <a href="order.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-list fa-fw"></i> Orders List</a>
      </div>
    </div>
    
    <div class="w3-quarter">
      <div class="w3-container w3-orange w3-text-white w3-padding-16">
        <div class="w3-left"><i class="fa fa-user w3-xxxlarge"></i></div>
        <div class="w3-right">
          <h3>0</h3>
        </div>
        <div class="w3-clear"></div>
        <a href="itemList.jsp" ><h4>Food List</h4></a>
      </div>
    </div>
  </div>

		
<%

		String id= request.getParameter("id");
		ShowFoodRepository orderStatusUpdate = new ShowFoodRepository();
		orderStatusUpdate.orderStatus(id);
		
	%>
	
	<a href= "order.jsp" class="pay_btn" >Back to order Page</a>
  <hr>
  </div>
</body>
</html>

