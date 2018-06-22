<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->


</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header"></div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/users2">All</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <div class="starter-template">


        <table class="table table-striped table-dark">
            <thead>
            <tr>
                <th scope="id">id</th>
                <th scope="Nazwa">Nazwa</th>
                <th scope="Wiek">Cena</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.age}"/></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>