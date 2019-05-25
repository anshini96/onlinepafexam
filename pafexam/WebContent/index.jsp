<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script name="viewport" content="width=device-width,initial-scale=1"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src= "js/jquery-3.4.1.min.js" type="text/javascript"></script>
<title>Add Order</title>
</head>
<body>
<div class="container">
 <h2>Add Order</h2>
 <form action="">
 <div class="form-group">
 <label for="customerid">CustomerID:</label>
 <input type="text" class="form-control" id="customerid" placeholder="Enter CustomerID"
name="customerid">
 </div>
 <div class="form-group">
 <label for="totalprice">TotalPrice:</label>
 <input type="text" class="form-control" id="totalprice" placeholder="Enter TotalPrice"
name="totalprice">
 </div>
  <div class="form-group">
 <label for="productname"> ProductName</label>
 <input type="text" class="form-control" id="productname" placeholder="Enter productname"
name="productname">
 </div>
  <div class="form-group">
 <label for="price">Price:</label>
 <input type="text" class="form-control" id="price" placeholder="Enter price"
name="price">
 </div>
 <div class="form-group">
 <label for="quantity">Quantity</label>
 <input type="text" class="form-control" id="quantity" placeholder="Enter quantity"
name="quantity">
 </div>
 <input type="submit" class="add" value="Add Order">
 </form>
</div>
<hr> 

</body>
</html>