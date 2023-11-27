
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
      <li><a class="active" href="prohome">Home</a></li>
      <li><a href="addproduct">Add Products</a></li>
      <li><a href="viewMyProducts">My Products</a></li>
      <li><a href="updateprofile">Update</a></li>
      <li><a href="#">Feedback</a></li>
    </ul>
  </nav>


<h3 align=right>Hi, ${pname}</h3>

<h3 align=center><u>Update Profile</u></h3><br><br>

<form method="post" action="update">

<table align=center>

<tr>
<td><label>Name</label></td>
<td>
<input type="text" name="name" required="required" value="${pro.name}"/>
</td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Email</label></td>
<td>
<input type="text" name="name" required="required" value="${pro.email}"/>
</td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Address</label></td>
<td>
<input type="text" name="name" required="required" value="${pro.address}"/>
</td>
</tr>

<tr><td></td></tr>


<tr><td></td></tr>
<tr>
<td><label>Contactno</label></td>
<td>
<input type="text" name="name" required="required" value="${pro.contactno}"/>
</td>
</tr>


<tr><td></td></tr>







<tr align=center>
<td colspan=2><input type="submit" value="Update" class="button"></td>
</tr>

</table>

</form>

</body>
</html>