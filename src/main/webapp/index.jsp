<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
  <jsp:include page="includes/head.html"></jsp:include>
</head>

<body>

  <h1>Registre seu e-mail em nossa lista</h1>
  
  <p>Para fazer parte de nossa lista de e-mails, informe seu nome e endereço de e-mail abaixo.</p>
  
  <form action="emailList" method="post">
    <c:if test="${origin == 'update-email'}">
      <input type="hidden" name="action" value="update">
      <input type="hidden" name="registered-email" value="${email.emailAddress}">
    </c:if>
    <input type="hidden" name="action" value="register">
    
    <label for="first-name">Primeiro nome: </label>
    <input type="text" name="first-name" placeholder="Primeiro Nome" value="${email.firstName}" required>
    
    <label for="last-name">Último nome: </label>
    <input type="text" name="last-name" placeholder="Último Nome" value="${email.lastName}" required>
    
    <label for="email">E-mail: </label>
    <input type="email" name="email" placeholder="email@mail.com" value="${email.emailAddress}" required>
    
    <input type="submit" value="Registrar">
    
  </form>
  
  <form action="emailList" method="post">
    <input type="hidden" name="action" value="see-registered">
    <input type="submit" value="Ver todos os e-mails">
  </form>
  
  <p><i>${message}</i></p>

  <footer>
    <jsp:include page="includes/footer.jsp"></jsp:include>
  </footer>
  
</body>
</html>