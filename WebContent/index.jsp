<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>

	table td{	
		text-align: center;
	}
</style>

<table style="border: 1px solid;">
	<th>UserId</th>
	<th>CurrencyFrom</th>
	<th>CurrencyTo</th>
	<th>AmountSell</th>
	<th>AmountBuy</th>
	<th>Rate</th>	
	<th>Originating<br> Country</th>
	<th>Time</th>
	
  <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.userId}" /></td>
      <td><c:out value="${item.currencyFrom}" /></td>
      <td><c:out value="${item.currencyTo}" /></td>
      <td><c:out value="${item.amountSell}" /></td>
      <td><c:out value="${item.amountBuy}" /></td>
      <td><c:out value="${item.rate}" /></td> 
      <td><c:out value="${item.originatingCountry}" /></td>
      <td><c:out value="${item.timePlaced}" /></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>