<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="tech.oldwang.domain.Category" %>
<%@ page import="tech.oldwang.service.impl.CategoryServiceImpl" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Books Management</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    </head>

    <body>
       <header>
            <div class="container">
                    <nav>
                            <a href="${pageContext.request.contextPath}/bookList.jsp" >Book information management</a>
                    </nav>
                    <nav>
                            <a href="${pageContext.request.contextPath}/categoryList.jsp" >Category management</a>
                    </nav>
                   
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>Library Management System</h1>
                    <p>Category management</p>
                </div>
            </div>
        </section>
        <section class="main">
            <div class="container">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Num.</th>
                        <th>Category NO.</th>
                        <th>Category Name</th>
                        <th>Operation</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${applicationScope.categoryDb}" var="category" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td>${category.getId()}</td>
                                <td>${category.getName()}</td>
                                <td><a href="${pageContext.request.contextPath}/deleteCategory?categoryId=${category.getId()}">Delete</a></td>
                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
        <section class="page">
            <div class="container">
                <div id="fatie">
                    <a href="addCategory.jsp"><button>Add</button></a>
                </div>
            </div>
        </section>
        <footer>
            copy@Jianquan Wang
        </footer>
    </body>
</html>