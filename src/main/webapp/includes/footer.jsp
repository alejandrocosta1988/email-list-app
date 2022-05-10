<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.time.LocalDate" %>

<%
  int currentYear = LocalDate.now().getYear();
%>

<p>&Copy; Alejandro Costa <%= currentYear %></p>
