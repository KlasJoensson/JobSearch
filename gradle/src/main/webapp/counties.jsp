<%@ page import="klasjoensson.jobsearch.AF" %><%--
  Created by IntelliJ IDEA.
  User: klas
  Date: 2017-10-12
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%
    System.out.println("on page counties.jsp");

    String res = AF.getCounties();

    System.out.println(res);
%>
