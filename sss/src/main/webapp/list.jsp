<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <!--在当前页所有的链接前面加上basePath的值-->
    <base href="<%=basePath %>" />
    <title>主页面</title>

</head>
<body>
      <div align="center">
          <ul>
              <c:forEach var="p" items="${listPower}">
              <li><a href="${p.powerUri}">${p.powerName}</a> </li>
              </c:forEach>
          </ul>
      </div>
</body>
</html>
