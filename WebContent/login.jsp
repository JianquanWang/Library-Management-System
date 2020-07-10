<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css">
        <script type="text/javascript">
        	function changeImg(){
        		var codeImg = document.getElementById("captcha");
        		codeImg.src="${pageContext.request.contextPath }/KaptchaServlet?time="+new Date().getTime();
        	}
        </script>
    </head>
    <body>
        <div class="login">
            <div class="header">
                <h1>
                    <a href="${pageContext.request.contextPath}/login.jsp">Login</a>
                </h1>
                <button></button>
            </div>
            <form action="${pageContext.request.contextPath}/loginServlet" method="post">
                <div class="name">
                    <input type="text" id="name" name="username">
                    <p></p>
                </div>
                <div class="pwd">
                    <input type="password" id="pwd" name="password">
                    <p></p>
                </div>
                <div class="code">
                    <input type="text" id="code" name="verifyCode" style="width: 150px">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <img id="captcha" onclick="changeImg()" src="${pageContext.request.contextPath }/KaptchaServlet" style="width: 150px;height: 42px;vertical-align: middle;">
                    <p></p>
                </div>
                <% 
                String msg = (String)request.getAttribute("msg");
                if(msg == null){
                	msg = "";
                }
                %>
                <div>
                	<%=msg %>
                </div>
                <div class="btn-red">
                    <input type="submit" value="login" id="login-btn">
                </div>
            </form>
        </div>
    </body>
</html>