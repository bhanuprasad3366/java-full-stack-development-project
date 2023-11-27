<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
    
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
      <li><a class="active" href="prohome">Home</a></li>
      <li><a href="addproduct">Add Products</a></li>
      <li><a href="viewMyProducts">My Products</a></li>
      <li><a href="updateprofile">Update</a></li>
      <li><a href="#">Feedback</a></li>
    </ul>
  </nav>
  <br> <br> <br>
  
  <h1 style="color:green;text-align:center;" >Welcome:${pname}</h1>
    <h1 style="color:green;text-align:center;" >Your ID is:${pid}</h1>
  
</body>
</html>