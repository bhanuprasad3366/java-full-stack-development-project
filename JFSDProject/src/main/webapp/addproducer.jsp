<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
</head>
<body>
<center>
<nav>
    <div class="logo">AgroSource</div>
    <input type="checkbox" id="click">
    <label for="click" class="menu-btn">
      <i class="fas fa-bars"></i>
    </label>
    <ul>
      <li><a class="active" href="#">Home</a></li>
      <li><a href="viewallproducts">About</a></li>
      <li><a href="Register">Registration</a></li>
      <li><a href="Login">Login</a></li>
      <li><a href="#">Feedback</a></li>
    </ul>
  </nav>
    <h1 style="color:green;">Registration</h1>
    <form action="insertproducer" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required maxlength="50"><br><br>
        
        <label for="gender">Gender:</label>
        <input type="text" id="gender" name="gender" required maxlength="10"><br><br>
        
<label for="role">Role:</label>
<select id="role" name="role" required>
  <option type="text" value="" disabled selected>Select Role</option>
  <option type="text" value="seller">Seller</option>
  <option type="text" value="buyer">Buyer</option>
</select>
	

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required maxlength="30"><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required maxlength="30"><br><br>
        
        <label for="address">Address:</label>
        <textarea id="address" name="address" required></textarea><br><br>
        
        <label for="contactno">Contact Number:</label>
        <input type="tel" id="contactno" name="contactno" required><br><br>
        
        <input type="submit" value="Add Producer">
      </form>
      
    </center>
</body>
</html>