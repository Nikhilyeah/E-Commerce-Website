<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${cp }/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
 <!-- Theme style -->
  <link rel="stylesheet" href="${cp }/dist/css/adminlte.min.css">
  </head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

  <!-- Preloader -->
  <%-- <div class="preloader flex-column justify-content-center align-items-center">
    <img class="animation__shake" src="${cp }/dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60">
  </div> --%>

  <!-- Navbar -->
  <jsp:include page="navbar.jsp"/>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <jsp:include page="aside.jsp"/>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Dashboard</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Product</a></li>
              <li class="breadcrumb-item active">Manage</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        
        <!-- page content goes here -->
        <div class="row">
        <div class="col col-lg-6">
        
        <c:choose>
        <c:when test="${edit eq true}">
        
         <div class="card card-primary">
	         <div class="card-header">
			 <h3 class="card-title">Edit Product Detail</h3>
			 </div>
			 <!-- /.card-header -->
			<!-- form start -->
		<form action="${cp}/admin/product/edit" method="post" enctype="multipart/form-data">

			<input type="hidden" name="${_csrf.parameterName }"value="${_csrf.token }">
			<div class="card-body">
			<div class="form-group">
				<label for="product_name">Product ID: </label>
				<input type="text" class="form-control" id="product_id"
					 name="id" value="${edit_product.id }" readonly>										 
			 </div>
			 <div class="form-group">
				<label for="product_name">Product Name: </label>
				<input type="text" class="form-control" id="product_name"
					 name="name" value="${edit_product.name }" required>										 
			 </div>
			 <div class="form-group">
			      <label for="product_quantity">Product Quantity: </label> 
			      <input type="text" class="form-control" id="product_quantity"
					name="quantity" value="${edit_product.quantity }" required>
			</div> 
			<div class="form-group">
				<label for="product_price">Product Price: </label>
				<input type="text" class="form-control" id="product_price"
				name="price" value="${edit_product.price }" required>
			</div>
			
			<div class="form-group">
			<label for="product_description">Product Description: </label>
			<textarea class="form-control" id="product_description"name="description"
			rows="3" required>${edit_product.description}</textarea>
			</div>
			<div class="form-group">
						<label for="product_image">Product Image: </label>
						<input type="file" class="form-control" id="product_image"
						name="image" placeholder ="Select product image" >
						<input type="text" class="form-control" name="orig_image"
						       value="${edit_product.image }" readonly>
												
			</div>
										
			<div class="form-group">
					 <label for="product_category">Product Category: </label>
					 <select class="form-control" id="product_category"name="category" required>
					  <c:forEach var="cat" items="${category_list }">
					  <option value="${cat.id }"
					  <c:if test="${cat.id eq edit_product.category.id }"> selected></c:if>
					  > ${cat.name } </option>
					  </c:forEach>
					  </select>
				</div>
			</div>
			<div class="card-footer">
				 <button type="submit" class="btn btn-primary">Update</button>
				 <button type="reset" class="btn btn-warning">Reset</button>
				</div>
				</div>
			</form>
			</div>
        
         </c:when>
        <c:otherwise>
        <div class="card card-primary">
	         <div class="card-header">
			 <h3 class="card-title">Add Product Detail</h3>
			 </div>
			 <!-- /.card-header -->
			<!-- form start -->
		<form action="${cp}/admin/product/add" method="post" enctype="multipart/form-data">

			<input type="hidden" name="${_csrf.parameterName }"value="${_csrf.token }">
			<div class="card-body">
			
			 <div class="form-group">
				<label for="product_name">Product Name: </label>
				<input type="text" class="form-control" id="product_name"
					 name="name" placeholder="Enter product name" required>										 
			 </div>
			 <div class="form-group">
			      <label for="product_quantity">Product Quantity: </label> 
			      <input type="text" class="form-control" id="product_quantity"
					name="quantity" placeholder="Enter product quantity"  required>
			</div> 
			<div class="form-group">
				<label for="product_price">Product Price: </label>
				<input type="text" class="form-control" id="product_price"
				name="price" placeholder="Enter product price"  required>
			</div>
			
			<div class="form-group">
			<label for="product_description">Product Description: </label>
			<textarea class="form-control" id="product_description"name="description"
			rows="3" placeholder="Enter product description"  required></textarea>
			</div>
			<div class="form-group">
						<label for="product_image">Product Image: </label>
						<input type="file" class="form-control" id="product_image"
						name="image" placeholder ="Select product image" required>									
			</div>
										
			<div class="form-group">
					 <label for="product_category">Product Category: </label>
					 <select class="form-control" id="product_category"name="category" required>
					  <c:forEach var="cat" items="${category_list }">
					  <option value="${cat.id }">${cat.name }
					   </option>
					  </c:forEach>
					  </select>
				</div>
			</div>
			<div class="card-footer">
				 <button type="submit" class="btn btn-primary">Update</button>
				 <button type="reset" class="btn btn-warning">Reset</button>
				 </div>
			</form>
			</div>
        </c:otherwise>
        </c:choose>
        </div>
        </div>
         
        <div class="row">
        <div class="col col-lg-12">
        <div class="card card-primary">
	         <div class="card-header">
			 <h3 class="card-title">Add Product Detail</h3>
			 </div>
			 <div class="card_body">
			 <table class="tbl tbl-responsive tbl-striped">
			 <thead>
			 <tr>
			 <th>Product Id</th>
			 <th>Name</th>
			 <th>Description</th>
			 <th>Quantity</th>
			 <th>Price</th>
			 <th>Category</th>
			 <th>Image</th>
			 <th>Action</th>
			 </tr>
			 </thead>
			 <tbody>
			 <c:forEach items="${product_list}" var="product">
			 <tr>
			    <td>${product.id }</td>
			    <td>${product.name }</td>
			    <td>${product.description }</td>
			    <td>${product.quantity }</td>
			    <td>${product.price }</td>
			    <td>${product.category.name }</td>
			    <td><img src="${cp}/product_image/${product.image}" 
			             alt="${product.image}"height="100px"/></td>
			    <td><a class="btn btn-warning" href="${cp }/admin/product/edit/${product.id}">Edit</a>
			        <a class="btn btn-danger" href="${cp }/admin/product/delete/${product.id}">Delete</a>
			        
			     </td>
			    </tr>
			    </c:forEach>
			 </tbody>
			 
			 </table>
			  </div>
			 </div>
			 </div>
			 </div>
        
        
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
 <jsp:include page="footer.jsp"/>
 
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="${cp }/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="${cp }/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="${cp }/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${cp }/dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${cp }/dist/js/demo.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="${cp }/dist/js/pages/dashboard.js"></script>
</body>
</html>