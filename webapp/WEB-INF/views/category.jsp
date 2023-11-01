





<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Dashboard</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${cp }/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
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
		<jsp:include page="navbar.jsp" />
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<jsp:include page="aside.jsp" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">Dashboard</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Category</a></li>
								<li class="breadcrumb-item active">Manage</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">

					<!-- page content goes here -->

					<div class="row">
						<div class="col col-lg-9">
							<c:choose>
								<c:when test="${edit eq true }">

									<div class="card card-primary">
										<div class="card-header">
											<h3 class="card-title">Edit category detail</h3>
										</div>
										<!-- /.card-header -->
										<!-- form start -->
										<form action="${cp}/admin/category/edit" method="post">

											<input type="hidden" name="${_csrf.parameterName }"
												value="${_csrf.token }">

											<div class="card-body">
												<div class="form-group">
													<label for="cat_id">Category Id: </label> <input
														type="text" class="form-control" id="cat_id" name="cat_id"
														value="${cat_edit.id }" readonly>
												</div>
												<div class="form-group">
													<label for="cat_name">Category Name: </label> <input
														type="text" class="form-control" id="cat_name"
														name="cat_name" value="${cat_edit.name }">
												</div>
												<div class="form-group">
													<label for="cat_description">Category Name: </label>
													<textarea id="cat_description" class="form-control"
														name="cat_description">${cat_edit.description }</textarea>
												</div>
												<div class="form-group">
													<label for="cat_parent">Parent Category: </label> <select
														id="cat_parent" class="form-control" name="cat_parent">
														<option value="0">-- Main Category --</option>
														<c:forEach items="${category_list }" var="cat">
															<option value="${cat.id }"
																<c:if test="${cat.id eq cat_edit.parentCat }">selected </c:if>>--
																${ cat.name } --</option>
														</c:forEach>
													</select>
												</div>


											</div>
											<!-- /.card-body -->

											<div class="card-footer">
												<button type="submit" class="btn btn-primary">Submit</button>
												<button type="reset" class="btn btn-warning">Reset</button>
											</div>
										</form>
									</div>

								</c:when>
								<c:otherwise>
									<div class="card card-primary">
										<div class="card-header">
											<h3 class="card-title">Add category detail</h3>
										</div>
										<form action="${cp}/admin/category/add" method="post">
											<input type="hidden" name="${_csrf.parameterName }"
												value="${_csrf.token }">
											<div class="card-body">
												<div class="form-group">
													<label for="cat_name">Category Name: </label> <input
														type="text" class="form-control" id="cat_name"
														name="cat_name" placeholder="Enter category name">
												</div>
												<div class="form-group">
													<label for="cat_description">Category Description:
													</label>
													<textarea class="form-control" id="cat_description"
														name="cat_description" placeholder="Enter category name"></textarea>
												</div>
												<div class="form-group">
													<label for="cat_parent">Parent Category: </label> <select
														id="cat_parent" name="cat_parent">
														<option value="0">-- Main Category --</option>
														<c:forEach items="${category_list }" var="cat">
															<option value="${cat.id }">${ cat.name }</option>
														</c:forEach>
													</select>
												</div>
												<div class="card-footer">
													<button type="submit" class="btn btn-primary">Submit</button>
													<button type="reset" class="btn btn-warning">Reset</button>
												</div>
											</div>
										</form>
									</div>
								</c:otherwise>
							</c:choose>

						</div>
					</div>

					<div class="row">
						<div class="col col-lg-9">
							<div class="card card-info">
								<div class="card-header">
									<h3 class="card-title">Displaying all category data</h3>
								</div>
								<div class="card-body">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>Category Id</th>
												<th>Category Name</th>
												<th>Category Description</th>
												<th>Category Patent</th>
												<th>Update</th>
												<th>Delete</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${category_list }" var="category">
												<tr><td>${category.id }</td>
													<td>${category.name }</td>
													<td>${category.description }</td>
													<td>${category.parentCat }</td>
													<td><a href="${cp}/admin/category/edit/${category.id}">Edit</a></td>
													<td><a href="${cp}/admin/category/delete/${category.id}">Delete</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="footer.jsp" />

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










</div>

</body>
</html>