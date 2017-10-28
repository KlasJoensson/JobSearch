<%@ page import="klasjoensson.jobsearch.AF" %>
<%@ page import="klasjoensson.jobsearch.HandleAds" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");
    String ad = AF.getAd( Integer.parseInt(id) );
    String keys = request.getParameter("keys");

    double rate = HandleAds.rateAd(ad, keys);

    out.print(rate);
%>