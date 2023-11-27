
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Agricultural Marketplace</title>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
  <nav>
    <div class="logo">AgroSource</div>
    <input type="checkbox" id="click">
    <label for="click" class="menu-btn">
      <i class="fas fa-bars"></i>
    </label>
    <ul>
      <li><a class="active" href="#">Home</a></li>
      <li><a href="viewallproducts">ViewAllProducts</a></li>
       <li><a href="addproduct">Add Products</a></li>
      <li><a href="ViewAllProducers	">ViewAllProducers</a></li>
      <li><a href="#">ViewAllConsumers</a></li>
    </ul>
  </nav>
  <h1>${message}</h1>
</body>
</html>