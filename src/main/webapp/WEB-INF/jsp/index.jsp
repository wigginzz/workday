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


        body {
            background-color: #005999;
            text-align: center;
            position: relative;
        }

    .doc_link{
        color: wheat;
        font-size: 14px;
        text-align: left;
        position: absolute;

        left: 30px;
        bottom: 30px;
    }
    </style>
    <script type="application/javascript" src="js/jquery.js"></script>
    <script type="application/javascript" src="js/jquery.json.js"></script>
    <script type="application/javascript" src="doc/javascript"></script>
    <script type="application/javascript">
            function page_load() {
                API.catalogs({},ondata(d){
                    var html="<ul>";
                    for(item in d.catalogs)
                    {
                       html+="<li><a href=''>"+item.Name+"</a></li>";
                    }
                    html+="</ul>";
                   $("#catalog_panel").html(html);
                });
            }
    </script>
</head>

<body onload="page_load()" >

<div id="catalog_panel">

</div>


<div>
    <a href="doc/index" class="doc_link">文档</a>
</div>

</body>
</html>