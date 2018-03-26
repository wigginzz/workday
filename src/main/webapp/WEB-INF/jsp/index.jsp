<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>Workday</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            -ms-box-sizing: border-box;
            box-sizing: border-box;
        }

        .copy {
            text-align: left;
            font-size: large;
            padding: 20px;
        }

        .copy a {
            color: #e0e0e0;
            padding: 20px 20px 0px 0px;
            text-decoration: underline;
        }

        .copy a:HOVER {
            color: white;
        }

        body {
            background-color: #005999;
            text-align: center;
            position: relative;
        }

        .copright {
            padding: 20px;
            color: #e0e0e0;
            text-align: right;
        }

        .gallary {
            display: flex;
            justify-content: center;
        }

        .gallary .item {
            position: relative;
            display: inline;
            margin: 150px 15px 0px 15px;
            border: 10px solid #f0f0f0;
            float: left;
            width: 250px;
            height: 180px;
            overflow: hidden;
            -webkit-box-shadow: 5px 5px 5px #111;
            box-shadow: 5px 5px 5px #303030;
        }

        .gallary .item img {
            width: 250px;
            height: 180px;
            -webkit-transition: all 1s ease;
            -moz-transition: all 1s ease;
            -o-transition: all 1s ease;
            -ms-transition: all 1s ease;
            transition: all 1s ease;
            position: absolute;
            left: 0px;
            top: 0px;
        }

        .gallary .item img:HOVER {
            width: 300px;
            height: 216px;
            left: -25px;
            top: -18px;
        }

        .gallary span {
            color: white;
            padding: 5px 10px;
            display: block;
            position: absolute;
            background-color: #005999;
        }
    </style>
    <script type="application/javascript">

    </script>
</head>

<body >



<div>
    <a href="api/doc/index">文档</a>
</div>

</body>
</html>
                                                                                     