<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>

<h1>Displaying All Products </h1>

<div>
<c:forEach items="${products}" var="product" >
	<div>
	<hr>
		<p>${product.name }/ ${product.id}</p>
		<div>
		<img src="${cp}/product_image/${product.image}" alt="${product_image}" height="200px">
		</div>
		
		<ul>
			<li>Price : ${product.price }</li>
			<li>Quantity : ${product.quantity }</li>
			<li>${product.description }</li>
			<li>${product.category.name }</li>
		</ul>
		
		<p>
		 <!-- <a href="${cp}/user/cart/add/${product.id}"> Add to Cart</a>  -->
		 <form action="${cp}/user/cart/add/${product.id}">
		 	<label>Quantity : </label>
		 	<input type="number" name="quantity" value="1">
		 	<input type="submit" value="Add To Cart">
		 </form>
		</p>
		
		<hr>
	</div>
</c:forEach>
</div>

</body>
</html>