<%@ page import="klasjoensson.jobsearch.AF" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String input = request.getParameter("keyWords");
    response.setContentType("application/json");

    String[] keywords = input.split(" ");
    for(String word:keywords) {
        System.out.println("Will search for: " + word);
    }
    String res = AF.searchForAds(null, null, null, keywords, 1, 10);
    System.out.println(res);
    out.print(res);
%>
