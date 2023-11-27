<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style1.css"> <!-- Link to the external CSS file -->

</head>
<body>
<br>
<h3 align="center"><u>Products for Sale</u></h3>
<form action="checkout.jsp" method="post"> <!-- Assuming you have a checkout page -->
<div class="shopping-cart">
<c:forEach items="${prodata}" var="pro">
  <div class="cart-item">
    <img src="images/${pro.name}" alt="${pro.name}" />
    <h4>${pro.name}</h4>
    <p>ID: ${pro.id}</p>
    <p>Cost: ${pro.cost}</p>
    <p>Type: ${pro.type}</p>
    <label for="quantity_${pro.id}">Quantity:</label>
    <input type="number" id="quantity_${pro.id}" name="quantity_${pro.id}" value="1" min="1" max="10" class="quantity-input" />
    <p>Total: $<span class="total-price">0.00</span></p>
    <button type="button" class="buy-button" onclick="calculateTotal(this)">Buy</button>
  </div>
</c:forEach>
</div>
<button type="submit" class="checkout-button">Checkout</button>
</form>

<script>
function calculateTotal(button) {
  // Get the parent cart-item div
  var cartItem = button.parentElement;
  
  // Get the price and quantity input elements within the cart-item
  var cost = parseFloat(cartItem.querySelector("p[Id='cost']").textContent.replace('Cost: ', ''));
  var quantityInput = cartItem.querySelector(".quantity-input");
  
  // Calculate the total price for this item
  var total = cost * parseInt(quantityInput.value);
  
  // Update the total price span
  cartItem.querySelector(".total-price").textContent = total.toFixed(2);
}
</script>
</body>
</html>
