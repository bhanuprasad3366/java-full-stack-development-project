<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <style>
        /* Custom CSS class for card width */
        .custom-card {
            max-width: 400px; /* Adjust the maximum width as needed */
        }
        .demo {
    text-align: center; /* Horizontally center-align content */
    margin: 0 auto; /* Horizontally center the element within its container */
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
  .star-ratings {
    display: inline-block;
    font-size: 20px;
    color: gold; /* Change the color of the stars as needed */
  }



    </style>
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
  </nav><br><br>
<div class="container">
    <div class="row">
        <c:forEach items="${prodata}" var="pro">
    <div class="col-md-6">
        <div class="card custom-card mb-3">
            <img class="card-img-top" src="images/${pro.name}" alt="Card image cap" width="200" height="200">
            <div class="card-body">
               
                <h6 class="demo">${pro.name}</h6>
                <h4 class="demo">ID: ${pro.id}</h4>
                <h4 class="demo">$: ${pro.cost}</h4>
                <h6 class="demo"> ${pro.type}</h6>
                <h6 class="demo">Quantity:${pro.quantity}</h6>
                <h6 class="demo"> ${pro.description}</h6>
                <center><div class="star-ratings ">
                    <c:forEach begin="1" end="${pro.rating}">
                        <span>&#9733;</span>
                    </c:forEach>
                </div></center>
                <br>
                <a href="#" class="btn btn-primary demo">Add To Cart</a>
            </div>
        </div>
    </div>

</c:forEach>

    </div>
</div>






</body>
</html>
