<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>New book category</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/add.css">
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${pageContext.request.contextPath }/categoryList.jsp">
                        Book category management
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${sessionScope.existUser.getUserName()}!</h1>
                <p>Please be careful to add a new category, it would be bad if you built a wrong one...</p>
            </div>
            <div class="page-header">
                <h3><small>Add</small></h3>
            </div>
            <form class="form-horizontal" action="${pageContext.request.contextPath}/addCategory" method="post">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Category NO.:</label>
                    <div class="col-sm-8">
                        <input name="categoryId" class="form-control" id="categoryId">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Category Name:</label>
                    <div class="col-sm-8">
                        <input name="categoryName" class="form-control" id="categoryName">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">Save</button>&nbsp;&nbsp;&nbsp;
                    </div>
                </div>
            </form>
        </div>
        <footer class="text-center" >
            copy@Jianquan Wang
        </footer>
    </body>
</html>
