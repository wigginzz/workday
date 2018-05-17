<%@ page import="org.nutz.lang.random.R" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    long r=System.nanoTime();
%>
<!doctype html>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <link href="css/ui.css" rel="stylesheet" type="text/css">
    <script src="mapway/product/product.nocache.js?r=<%=r%>" language="JavaScript"></script>

</head>
<body>

</body>
</html>
