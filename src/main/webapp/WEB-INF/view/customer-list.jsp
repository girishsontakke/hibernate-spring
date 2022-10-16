<%--
  Created by IntelliJ IDEA.
  User: girishsontakke
  Date: 05/09/22
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div>
    <div id="wrapper">
        <div id="header">
            <h2>customers list </h2>
        </div>
    </div>

    <div id="container">

        <div id="content">
            <table>
                <button class="add-button" onclick="window.location.href='showFormToAdd'; return false">add customer
                </button>
                <tbody>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>

                <c:forEach var="customer" items="${customers}">
                    <c:url var="updateLink" value="${pageContext.request.contextPath}/customer/showFormForUpdate">
                        <c:param name="customerId" value="${customer.id}"/>
                    </c:url>
                    <c:url var="deleteLink" value="${pageContext.request.contextPath}/customer/delete">
                        <c:param name="customerId" value="${customer.id}"/>
                    </c:url>
                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                        <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="if(!confirm('Are you sure you want to delete')) return false;">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
    </div>
</div>
</body>
</html>
