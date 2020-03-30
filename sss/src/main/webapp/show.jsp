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
          ${powerInfo}
      </div>
</body>
</html>
