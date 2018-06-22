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
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form autocomplete="off" action="#" th:action="@{/register}"
                  th:object="${account}" method="post" class="form-horizontal"
                  role="form">
                <h2>Registration Form</h2>
                <div class="form-group">
                    <div class="col-sm-9">
                        <%--<label th:if="${#fields.hasErrors('name')}" th:errors="*{name}"--%>
                               <%--class="validation-message"></label>--%>
                        <input type="text" th:field="*{name}" placeholder="Name"
                               class="form-control"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-9">
                        <%--<label th:if="${#fields.hasErrors('surname')}" th:errors="*{surname}"--%>
                               <%--class="validation-message"></label>--%>
                        <input type="text" th:field="*{surname}"
                               placeholder="Last Name" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
                        <%--<label--%>
                                <%--th:if="${#fields.hasErrors('email')}" th:errors="*{email}"--%>
                                <%--class="validation-message"></label>--%>
                        <input type="text" th:field="*{email}" placeholder="Email"
                               class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9">
                        <%--<label--%>
                                <%--th:if="${#fields.hasErrors('password')}" th:errors="*{password}"--%>
                                <%--class="validation-message"></label>--%>
                        <input type="password" th:field="*{password}"
                               placeholder="Password" class="form-control"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-9">
                        <button type="submit" class="btn btn-primary btn-block">Register User</button>
                    </div>
                </div>

                <span th:utext="${successMessage}"></span>


            </form>
        </div>
    </div>
</div>

</body>
</html>




<!--<!DOCTYPE html>-->
<!--<html lang="en" xmlns="http://www.w3.org/1999/xhtml"-->
      <!--xmlns:th="http://www.thymeleaf.org">-->
<!--<head>-->
    <!--<title>Registration Form</title>-->
    <!--&lt;!&ndash;<link rel="stylesheet" type="text/css" th:href="@{/css/registration.css}"/>&ndash;&gt;-->
    <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">-->
    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>-->
    <!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>-->
<!--</head>-->



<!--<body>-->

<!--<div class="container">-->
    <!--&lt;!&ndash;ndash;&gt;-->
    <!--<div class="form-group form">-->

        <!--<form action="/register" th:action="@{/seedstartermngc}" th:objecd="post">-->

            <!--<div>-->
                <!--<label>Twój nick:</label>-->
                <!--<input type="text" th:field="*{userNick}" th:cldError" />-->
            <!--</div>-->

            <!--<div>-->
                <!--<label>Twój e-mail:</label>-->
                <!--<input type="email" th:field="*{userEmail}" />-->
            <!--</div>-->

            <!--<div>-->
                <!--<label>Hasło:</label>-->
                <!--<input type="password" th:field="*{userPassword}"/>-->
            <!--</div>-->



            <!--<button id="registerButton" class="form-control">Zarejestruj się</button>-->

        <!--</form>-->

    <!--</div>-->
<!--</div>-->
<!--</body>-->
<!--</html>-->