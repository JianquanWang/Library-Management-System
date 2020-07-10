<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Books Management</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
      	<script type="text/javascript">
      	function query(){
      		var searchContent = $("#searchContent").val();
      		$.ajax({
          		"url": "${pageContext.request.contextPath}/searchBook",
          		"type": "get",
          		"data": {"searchContent": searchContent},
          		"dataType": "json",
          		"success": function(json){
          			var content = "";
          			for(var i = 0; i < json.length; i++){
          				var book = json[i];
          				content = content + "<tr><td>" + (i+1)
          					+"</td><td>" + json[i].id
          					+"</td><td>" + json[i].name
          					+"</td><td>" + json[i].category.name
          					+"</td><td>¥" + json[i].price
          					+"</td><td><img src='" + json[i].cover + "' width='60'>"
          					+"</td><td><a href='${pageContext.request.contextPath}/updateBook.jsp?bookId="+json[i].id+"'>修改</a><a href='${pageContext.request.contextPath}/deleteBook?bookId="+json[i].id+"'>删除</a>"
                        	+"</td></tr>";
          				$("cont>tr").remove();
          			}
          			$("#cont").html(content);
          		}
          	})
      	}	
  
      	
      	</script>
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
                    <p>Book information management</p>
                </div>
            </div>
        </section>
        <section class="main">


            <div class="container">
               <!-- <form class="form-horizontal" action="" method=""> --> 
                <div class="form-group"  style="float: right;">
                    <div class="col-sm-offset-2 col-sm-10">
                        
                        <button type="button" id="searchbtn" class="btn btn-primary" onclick="query()">Query</button>
                        &nbsp;&nbsp;&nbsp;
                    </div>
                </div>
                <div class="form-group" style="float: right;width: 300px;">
                    <div class="col-sm-8">
                        <input name="searchContent" class="form-control" id="searchContent"
                        placeholder="Enter the category to query" style="width: 250px">
                    </div>
                </div>

                
            <!-- </form> -->
            </div>
            <div class="container">

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Num.</th>
                        <th>Book NO.</th>
                        <th>Book Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Cover</th>
                        <th>Operation</th>

                    </tr>
                    </thead>
                    <tbody id="cont">
                    	
                        <c:forEach items="${books}" var="book" varStatus="status">
                            <tr id="tr1">
                                <td>${status.index + 1 }</td>
                                <td>${book.getId() }</td>
                                <td>${book.getName() }</td>
                                <td>${book.getCategory().getName() }</td>
                                <td>￥${book.getPrice() }</td>
                                <td><img src="${book.getCover()} " width="60"></td>
                                <td>
                                <a href="${pageContext.request.contextPath}/updateBook.jsp?bookId=${book.getId()}">Update</a>
                                <a href="${pageContext.request.contextPath}/deleteBook?bookId=${book.getId()}">Delete</a>

                                </td>
                                

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
        <section class="page">
            <div class="container">
                <div id="fatie">
                    <a href="addBook.jsp"><button>Add</button></a>
                </div>
            </div>
        </section>
        <footer>
            copy@Jianquan Wang
        </footer>
    </body>
</html>