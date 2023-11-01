<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>User Profile</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <!-- Font Awesome CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
  <!-- Your Custom CSS (if any) -->
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

.wrapper {
    max-width: 800px;
    margin: 0 auto;
    background-color: #fff;
    padding: 20px;
    box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
    margin-top: 20px;
}

.profile-image {
    width: 100px;
    height: 100px;
    border-radius: 50%;
    object-fit: cover;
}

.profile-details {
    margin-top: 20px;
}

ul {
    list-style: none;
    padding: 0;
}

ul li {
    margin-bottom: 10px;
}

.cart-table {
    width: 100%;
    margin-top: 20px;
    border: 1px solid #ddd;
    border-collapse: collapse;
}

.cart-table th, .cart-table td {
    padding: 15px;
    text-align: center;
    border-bottom: 1px solid #ddd;
}

.cart-table th {
    background-color: #f2f2f2;
}

.cart-table tr:nth-child(even) {
    background-color: #f9f9f9;
}

.cart-actions {
    margin-top: 20px;
}

.cart-actions a {
    display: inline-block;
    margin-right: 10px;
    text-decoration: none;
    background-color: #007bff;
    color: #fff;
    padding: 10px 20px;
    border-radius: 5px;
}

.cart-actions a:hover {
    background-color: #0056b3;
}

.product-link {
    display: inline-block;
    margin-top: 20px;
    text-decoration: none;
    background-color: #28a745;
    color: #fff;
    padding: 10px 20px;
    border-radius: 5px;
}

.product-link:hover {
    background-color: #218838;
}

.order-history-link {
    display: inline-block;
    margin-top: 20px;
    text-decoration: none;
    background-color: #dc3545;
    color: #fff;
    padding: 10px 20px;
    border-radius: 5px;
}

.order-history-link:hover {
    background-color: #c82333;
}


</style>

 
  
  
  <!-- Bootstrap JS (optional, if you need JavaScript features) -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
  <!-- User Profile Details -->
  <img src="/user_image/${user_detail.image}" height="100px" width="100px" alt="${user_detail.image}">
  <div>
    <ul>
      <li>Name: ${user_detail.name}</li>
      <li>Address: ${user_detail.address}</li>
      <li>Email: ${user_detail.email}</li>
      <li>Phone: ${user_detail.phone}</li>
    </ul>
  </div>
  
  <!-- Displaying Cart Items -->
  <h3>Shopping Cart</h3>
  <div>
    <table class="cart-table">
  <thead>
    <tr>
      <th>Cart Id</th>
      <th>Product Name</th>
      <th>User</th>
      <th>Price</th>
      <th>Quantity</th>
      <th>Total</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${cart_list}" var="cart">
      <tr>
        <td>${cart.id}</td>
        <td>${cart.product.name}</td>
        <td>${cart.userDetail.name}</td>
        <td>${cart.product.price}</td>
        <td>${cart.quantity}</td>
        <td>${cart.product.price * cart.quantity}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
    
  </div>

  <!-- Links for User Actions -->
  <br>
<%--   <a href="${cp}/user/cart">View Cart</a><br>
  <a href="${cp}/user/cart/add/{pid}">Add to Cart</a><br>
  <a href="${cp}/user/cart/update">Update Cart</a><br>
  <a href="${cp}/user/cart/remove/{cartId}">Remove from Cart</a><br>
  <a href="${cp}/user/cart/clear">Clear Cart</a><br>
  <a href="${cp}/user/checkout">Proceed to Checkout</a><br> --%>

  <!-- View Product Details Link (example) -->
  <a href="${cp}/products">View All Product</a><br>

  <!-- View Order History Link -->
  <a href="${cp}/user/orders">View Order History</a><br>
</div>
</body>
</html>
