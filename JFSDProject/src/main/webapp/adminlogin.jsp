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
      <li><a href="#">ViewAllProducts</a></li>
       <li><a href="login">Add Products</a></li>
      <li><a href="ViewAllProducers">ViewAllProducers</a></li>
      <li><a href="#">ViewAllConsumers</a></li>
    </ul>
  </nav>
  <br> <br> <br>
   <h2>Admin Login</h2>
   <br> <br>
    <form action="adminloginaction" method="post">
        <label for="username">Username:</label>
        <input type="text" name="name" id="username" required><br><br>

        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required><br><br>

        <input type="submit" value="Login">
    </form>      
    </center>
</body>
</html>