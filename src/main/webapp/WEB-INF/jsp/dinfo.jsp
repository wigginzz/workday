<%@ page import="cn.mapway.workday.api.module.KV" %>
<%@ page import="cn.mapway.workday.tools.Jsps" %>
<%@ page import="cn.mapway.workday.ui.shared.module.ProductInfo" %>
<%@ page import="cn.mapway.workday.ui.shared.module.ZiroomCommand" %>
<%@ page import="cn.mapway.workday.ui.shared.repository.D_ATTRIBUTE_OPERATORObj" %>
<%@ page import="cn.mapway.workday.ui.shared.repository.D_OPERATOR_PARAMETERObj" %>
<%@ page import="cn.mapway.workday.ui.shared.repository.D_PRODUCT_ATTRIBUTEObj" %>
<%@ page import="cn.mapway.workday.ui.shared.repository.D_PRODUCT_INFOObj" %>
<%@ page import="org.nutz.json.Json" %>
<%@ page import="org.nutz.lang.Lang" %>
<%@ page import="org.nutz.lang.random.R" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ProductInfo pinfo = Jsps.getProductInfo();
%>

<!-- 函数定义 -->
<%!
    String[] toHTML(ProductInfo pinfo, List<D_ATTRIBUTE_OPERATORObj> ops) {
        StringBuilder sb = new StringBuilder();
        StringBuilder pas = new StringBuilder();
        StringBuilder json = new StringBuilder();

        int opindex = 1;
        for (D_ATTRIBUTE_OPERATORObj op : ops) {
            List<D_OPERATOR_PARAMETERObj> ps = pinfo.getOperatorParameters(op.id);

            ZiroomCommand command;
            if (op.direction.equals(0)) {
                command = ZiroomCommand.controlCommand();
            } else {
                command = ZiroomCommand.controlResponseCommand();
            }
            command.sno(R.captchaNumber(6)).command(op.code).did("14223");

            sb.append("<tr>");
            int rowspan = ps.size() == 0 ? 1 : ps.size();
            D_PRODUCT_ATTRIBUTEObj attr = pinfo.findAttribute(op.attributeId);
            command.attribute(attr.code);
            sb.append("<td rowspan='" + rowspan + "' class='attr'>" + attr.code + "</td>");
            sb.append("<td rowspan='" + rowspan + "'>" + String.format("<span class='hex'>0x</span>%02X", op.operatorIndex) + "</td>");
            sb.append("<td rowspan='" + rowspan + "'>" + op.code + "</td>");
            sb.append("<td rowspan='" + rowspan + "'>" + op.name + "</td>");

            pas = new StringBuilder();
            int index = 0;
            for (D_OPERATOR_PARAMETERObj opp : ps) {
                if (index > 0) {
                    pas.append("<tr>");
                }
                command.addParameter(opp.code, opp.defaultValue);

                pas.append("<td>" + String.format("<span class='hex'>0x</span>%02X", opp.parameterIndex) + "</td>");
                pas.append("<td>" + opp.code + "</td>");
                pas.append("<td>" + opp.name + "</td>");
                pas.append("<td>" + opp.maxValue + "</td>");
                pas.append("<td>" + opp.minValue + "</td>");
                pas.append("<td>" + opp.defaultValue + "</td>");
                pas.append("<td>" + opp.description + "</td>");
                List<KV> kv = Json.fromJsonAsList(KV.class, opp.options);

                StringBuilder kvlist = new StringBuilder();
                kvlist.append("<ul>");
                for (KV v : kv) {
                    kvlist.append("<li>" + v.k + "  " + v.v + "</li>");
                }
                kvlist.append("</ul>");
                pas.append("<td>" + kvlist.toString() + "</td>");

                pas.append("</tr>");
                index++;
            }
            if (ps.size() == 0) {
                pas.append("<td align='center' colspan='8'>无参数</td>");
                pas.append("</tr>");
            }


            sb.append(pas.toString());

            json.append("<div class='cmd'>" + (opindex++) + "." + op.name + "  " + op.code + "[" + op.operatorIndex + "]</div>" +
                    "<div class='desc'>" + op.description + "</div>" +
                    "<pre ><code class='json'>" + command.toJSON() + "</code></pre>");
        }
        return Lang.array(sb.toString(), json.toString());
    }
%>
<html>
<head>
    <title>设备信息定义</title>
    <style>
        .attr {
            color: blue;
        }

        .desc {
            color: green;
            margin-bottom: 10px;
        }

        .summary {
            font-style: italic;
        }

        .cata {
            padding: 20px;
            border-left: solid 8px #005999;
            display: inline-block;
        }

        .cataname {
            font-weight: bold;
        }

        .up {
            color: #005999;
            text-decoration: none;
            padding-left: 30px;
        }

        .space {
            border-top: solid 1px #005999;
            margin-bottom: 10px;
        }

        .cmd {
            padding: 5px;
            font-weight: bold;
        }

        .tbl {
            background-color: #555555;
            border-bottom: solid 1px #c0c0c0;
            margin-bottom: 10px;

        }

        .tbl tr {
            background-color: white;
        }

        .tbl tr:nth-child(odd) {
            background-color: #f0f0f0;
        }

        .tbl .h > td {
            background-color: darkcyan;
            color: white;
            font-weight: bold;
        }

        .hex {
            color: red;
        }
    </style>
    <link rel="stylesheet" href="https://www.iteblog.com/wp-content/monokai_sublime.min.css"/>
    <script src="https://www.iteblog.com/wp-content/highlight.min.js"></script>
    <script>function load() {
        hljs.initHighlightingOnLoad();
    }</script>
</head>
<body onload="load()">
<table valign="middle" cellpadding="5px">
    <tr>
        <td>
            <img src="http://www.ziroom.com/static/ziroom_2016/images/common/logo.png"/>
        </td>
        <td valign="bottom">
            <h1>设备信息定义</h1>
        </td>
    </tr>
</table>
<div class="space"></div>
<a name="catalog"></a>
<div class="cata">
    <div class="cataname">目录</div>
    <%
        for (D_PRODUCT_INFOObj p : pinfo.getAllProducts()) {
    %>
    <li><a href="#p<%=p.id%>"><%=p.name%>
    </a></li>
    <%}%>
</div>
<%
    for (D_PRODUCT_INFOObj p : pinfo.getAllProducts()) {
%>
<a name="p<%=p.id%>" id="p<%=p.id%>"/>
<h2><%=p.name%>&nbsp;&nbsp;<span class="summary"><%=p.code%></span><a href="#catalog" class="up">^</a></h2>
<div class="desc"><%=p.description%>
</div>

<h3>属性</h3>
<table cellspacing="1" rules="rows" cellpadding="5px" class="tbl">
    <tr class="h">
        <td>属性索引</td>
        <td>属性代码</td>
        <td>属性名称</td>
        <td>解释</td>
    </tr>
    <%
        for (D_PRODUCT_ATTRIBUTEObj a : pinfo.getProductAttribute(p.id)) {
    %>
    <tr>
        <td><%=String.format("<span class='hex'>0x</span>%02X", a.attributeIndex)%>
        </td>
        <td class="attr"><%=a.code%>
        </td>
        <td><%=a.name%>
        </td>
        <td class="desc"><%=a.description%>
        </td>
    </tr>
    <% }
    %>
</table>

<%
    StringBuilder sb = new StringBuilder();
    StringBuilder pas = new StringBuilder();
    StringBuilder json = new StringBuilder();

%>

<h3>操作</h3>
<table width="100%" cellpadding="5" rules="rows" cellspacing="1" class="tbl">
    <tr class="h">
        <td>属性</td>
        <td>索引</td>
        <td>代码</td>
        <td>名称</td>
        <td>参数索引</td>
        <td>参数代码</td>
        <td>参数名称</td>
        <td>参数最大值</td>
        <td>参数最小值</td>
        <td>参数缺省值</td>
        <td>参数说明</td>
        <td>值列表</td>
        </th>
            <%
            String[] htmls=toHTML(pinfo,pinfo.getAllOperator(p.id,0));
            %>
            <%=htmls[0]%>
</table>
<div><%=htmls[1]%>
</div>

<h3>事件</h3>
<table width="100%" cellpadding="5" rules="rows" cellspacing="1" class="tbl">
    <tr class="h">
        <td>属性</td>
        <td>索引</td>
        <td>代码</td>
        <td>名称</td>
        <td>参数索引</td>
        <td>参数代码</td>
        <td>参数名称</td>
        <td>参数最大值</td>
        <td>参数最小值</td>
        <td>参数缺省值</td>
        <td>参数说明</td>
        <td>值列表</td>
        </th>
            <%

            htmls=toHTML(pinfo,pinfo.getAllOperator(p.id,1));
         %>
            <%=htmls[0]%>
</table>
<div><%=htmls[1]%>
</div>

<%}%>

<div style="padding: 30px;background-color: azure">
    &copy; 2018 ziroom.com
</div>
</body>
</html>
