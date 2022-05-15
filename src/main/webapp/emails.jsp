<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
  <jsp:include page="includes/head.html"></jsp:include>
</head>

<body>

  <h1>E-mails registrados</h1>
  
  <p>${message}</p>
  
  <table>
    
    <thead>
      <th>Primeiro nome</th>
      <th>Último nome</th>
      <th>E-mail</th>
      <th>Excluir</th>
      <th>Editar</th>
    </thead>
    
    <tbody>
      
      <c:forEach var="email" items="${emails}">
      
        <tr>
          <td><c:out value="${email.getFirstName()}"/></td>
          <td><c:out value="${email.getLastName()}"/></td>
          <td><c:out value="${email.getEmailAddress()}"/></td>
          <td>
            <form action="emailList" method="post">
              <input type="hidden" name="action" value="delete-email">
              <input type="hidden" name="email-address" value="${email.getEmailAddress()}">
              <input type="submit" value="&#128465;" class=delete>
            </form>
          </td>
          <td>
            <form action="emailList" method="post">
              <input type="hidden" name="action" value="update-email">
              <input type="hidden" name="email-address" value="${email.getEmailAddress()}">
              <input type="submit" value="&#9998;" class="delete">
            </form>
          </td>
        </tr>
      
      </c:forEach>
      
    </tbody>
  
  </table>
  
  <a href="emailList?action=join">Retornar a página de cadastro</a>

  <footer>
    <jsp:include page="includes/footer.jsp"></jsp:include>
  </footer>
</body>
</html>