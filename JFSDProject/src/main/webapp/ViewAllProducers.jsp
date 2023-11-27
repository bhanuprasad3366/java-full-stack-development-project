<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Agricultural Marketplace</title>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
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
      <li><a href="ViewAllProducers">ViewAllProducers</a></li>
      <li><a href="#">Feedback</a></li>
      
      
    </ul>
  </nav>
  <br><br>
<h3 align="center"><u>List of Employees</u></h3> 
 <br><br><br>
<table  class="table table-hover" style="margin: 0 auto;" border="2">  
<tr bgcolor="black" style="color:white"> 
<td>ID</td> 
<td>NAME</td> 
<td>EMAIL</td> 
<td>GENDER</td> 
<td>ADDRESS</td> 
<td>CONTACT NO</td> 
</tr> 
 
<c:forEach items="${producersdata}"  var="producer"> 
<tr> 
<td><c:out value="${producer.id}" /></td> 
<td><c:out value="${producer.name}" /></td> 
<td><c:out value="${producer.email}" /></td> 
<td><c:out value="${producer.gender}" /></td> 
<td><c:out value="${producer.address}" /></td> 
<td><c:out value="${producer.contactno}" /></td> 
<td>

</td>
 
</tr> 
</c:forEach> 
 
</table> 
 
</body> 
</html>