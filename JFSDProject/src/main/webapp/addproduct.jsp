
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
      <li><a href="addproduct">Add Products</a></li>
      <li><a href="viewMyProducts">My Products</a></li>
      <li><a href="updateprofile">Update</a></li>
      <li><a href="#">Feedback</a></li>
    </ul>
  </nav>
  <br> 
  <br>
   <h1>Add Product</h1>
    <br> <br>
    <form action="upload" method="post" enctype="multipart/form-data">
        <!-- Removed the Product ID input field -->
        
        <label for="producerId">Producer Id:</label>
        <input type="hidden" id="producerId" name="producerId" value="${pid}" required><br><br>
        
        <!-- Add a file input for image upload -->
        <label for="productImage">Product Image:</label>
        <input type="file" id="productImage" name="productImage" accept="image/*" required><br><br>
        
        <label for="productCost">Product Cost:</label>
        <input type="text" id="productCost" name="productCost" required><br><br>
        
        <label for="productType">Product Type:</label>
        <input type="text" id="productType" name="productType" required><br><br>
        
        <label for="productRating">Product Rating:</label>
        <input type="text" id="productRating" name="productRating" required><br><br>
        
         <label for="productQuantity">Product Quantity:</label>
        <input type="text" id="productQuantity" name="productQuantity" required><br><br>
        
        <label for="productDescription">Product Description:</label>
        <input type="text" id="productDescription" name="productDescription" required><br><br>
        
        
        <input type="submit" value="Add Product">
    </form>
</body>
</html>

  
 