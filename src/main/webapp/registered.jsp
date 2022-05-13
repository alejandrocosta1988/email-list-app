<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <jsp:include page="includes/head.html"></jsp:include>
</head>

<body>

  <h1>Seus dados foram registrados!</h1>
  <p>Os dados informados foram registrados com sucesso. Obrigado pelo seu interesse!</p>
  <h3>Dados registrados:</h6>
  <ul>
    <li>${email.firstName}</li>
    <li>${email.lastName}</li>
    <li>${email.emailAddress}</li>
  </ul>
  
  <footer>
    <jsp:include page="includes/footer.jsp"></jsp:include>
  </footer>

</body>
</html>