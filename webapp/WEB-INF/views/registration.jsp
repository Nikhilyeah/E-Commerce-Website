<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>

<h2>User Registration</h2>

<form action="${cp}/register" method="post" enctype="multipart/form-data">

	<input type="hidden" name="${_csrf.parameterName }"value="${_csrf.token }">
	
    <label>Name: <input type="text" name="name" /></label><br/>
    <label>Email: <input type="email" name="email" /></label><br/>
    <label>Phone: <input type="text" name="phone" /></label><br/>
    <label>Address: <input type="text" name="address" /></label><br/>
    <label>Image: <input type="file" name="image" /></label><br/>
    <label>DOB: <input type="date" name="dob" /></label><br/>
    <label>Username: <input type="text" name="username" /></label><br/>
    <label>Password: <input type="password" name="password" /></label><br/>
    <label>Confirm Password: <input type="password" name="confirmPassword" /></label><br/>
    <label>Role: 
        <select name="role">
            <option value="User">User</option>
            <option value="Admin">Admin</option>
        </select>
    </label><br/>
    <button type="submit">Save</button>
    <button type="reset">Reset</button>
</form>

</body>
</html>
