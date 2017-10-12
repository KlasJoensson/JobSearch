<%@ page import="klasjoensson.jobsearch.AF" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%
    System.out.println("on page counties.jsp");

    String res = AF.getCounties();

    System.out.println(res);
%>
