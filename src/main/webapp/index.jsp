<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
  <jsp:include page="includes/head.html"></jsp:include>
</head>

<body>

  <h1>Registre seu e-mail em nossa lista</h1>
  
  <p>Para fazer parte de nossa lista de e-mails, informe seu nome e endereço de e-mail abaixo.</p>
  
  <form action="emailList" method="post">
    <input type="hidden" name="action" value="register">
    
    <label for="first-name">Primeiro nome: </label>
    <input type="text" name="first-name" placeholder="Primeiro Nome" required>
    
    <label for="last-name">Último nome: </label>
    <input type="text" name="last-name" placeholder="Último Nome" required>
    
    <label for="email">E-mail: </label>
    <input type="email" name="email" placeholder="email@mail.com" required>
    
    <input type="submit" value="Registrar">
    
  </form>
  
  <p><i>${message}</i></p>

  <footer>
    <jsp:include page="includes/footer.jsp"></jsp:include>
  </footer>
  
</body>
</html>