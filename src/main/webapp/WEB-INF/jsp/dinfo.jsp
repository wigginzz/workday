<%@ page import="cn.mapway.workday.ui.shared.module.ProductInfo" %>
<%@ page import="cn.mapway.workday.tools.Jsps" %>
<%@ page import="cn.mapway.workday.ui.shared.repository.D_PRODUCT_INFOObj" %>
<%@ page import="cn.mapway.workday.ui.shared.repository.D_PRODUCT_ATTRIBUTEObj" %>
<%@ page import="cn.mapway.workday.ui.shared.repository.D_ATTRIBUTE_OPERATORObj" %>
<%@ page import="cn.mapway.workday.ui.shared.repository.D_OPERATOR_PARAMETERObj" %>
<%@ page import="java.util.List" %>
<%@ page import="org.nutz.json.Json" %>
<%@ page import="cn.mapway.workday.api.module.KV" %>
<%@ page import="cn.mapway.workday.ui.shared.module.ZiroomCommand" %>
<%@ page import="org.nutz.lang.random.R" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ProductInfo pinfo=Jsps.getProductInfo();
%>
<html>
<head>
    <title>设备信息定义</title>
    <style>
        .desc{
            color: green;
            margin-bottom: 10px;
        }
        .summary{
            font-style: italic;
        }
        .cata{
            padding: 20px;
            border-left:solid 8px #005999;
            display: inline-block;
        }
        .cataname{
            font-weight: bold;
        }
        .up{
            color: #005999;
            text-decoration: none;
            padding-left: 30px;
        }
        .space{
            border-top: solid 1px #005999;
            margin-bottom: 10px;
        }
        .cmd{
            padding: 5px;
            font-weight: bold;
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
            for(D_PRODUCT_INFOObj p:pinfo.getAllProducts()){
        %>
        <li><a href="#p<%=p.id%>"><%=p.name%></a></li>
        <%}%>
    </div>
    <%
        for(D_PRODUCT_INFOObj p:pinfo.getAllProducts()){
    %>
    <a name="p<%=p.id%>" id="p<%=p.id%>" />
    <h2><%=p.name%>&nbsp;&nbsp;<span class="summary"><%=p.code%></span><a href="#catalog" class="up">^</a></h2>
        <div class="desc"><%=p.description%></div>

        <h3>属性</h3>
            <table cellpadding="4" border="1" borderCollapse="collapse">
                <tr>
                    <td>属性名称</td>
                    <td>属性代码</td>
                    <td>解释</td>
                </tr>
            <%
                    for(D_PRODUCT_ATTRIBUTEObj a:pinfo.getProductAttribute(p.id))
                    {
                        %>
                 <tr>
                     <td><%=a.name%></td>
                     <td><%=a.code%></td>
                     <td><%=a.description%></td>
                 </tr>
                 <% }
                %>
            </table>

    <h3>操作</h3>
    <table cellpadding="4" border="1" >
        <tr>
            <td>属性</td>
            <td>操作名称</td>
            <td>操作代码</td>
            <td>操作索引</td>
            <td>操作说明</td>
            <td>参数名称</td>
            <td>参数代码</td>
            <td>参数索引</td>
            <td>参数最大值</td>
            <td>参数最小值</td>
            <td>参数缺省值</td>
            <td>参数说明</td>
            <td>值列表</td>
        </tr>
        <%
            StringBuilder sb=new StringBuilder();
            StringBuilder pas;

            StringBuilder json=new StringBuilder();


            int opindex=1;
            for(D_ATTRIBUTE_OPERATORObj op:pinfo.getAllOperator(p.id,0)) {

                List<D_OPERATOR_PARAMETERObj> ps=pinfo.getOperatorParameters(op.id);

                ZiroomCommand command;
                if (op.direction.equals(0))
                {
                    command=ZiroomCommand.controlCommand();
                }
                else
                {
                    command=ZiroomCommand.controlResponseCommand();
                }
                command.sno(R.captchaNumber(6)).command(op.code).did("14223");

                sb.append("<tr>");
                int rowspan=ps.size()==0?1:ps.size();
                D_PRODUCT_ATTRIBUTEObj attr=pinfo.findAttribute(op.attributeId);
                command.attribute(attr.code);
                sb.append("<td rowspan='"+rowspan+"'>"+attr.code+"</td>");
                sb.append("<td rowspan='"+rowspan+"'>"+op.name+"</td>");
                sb.append("<td rowspan='"+rowspan+"'>"+op.code+"</td>");
                sb.append("<td rowspan='"+rowspan+"'>"+op.operatorIndex+"</td>");
                sb.append("<td rowspan='"+rowspan+"'>"+op.description+"</td>");

                pas=new StringBuilder();
                int index=0;
                for(D_OPERATOR_PARAMETERObj opp:ps) {
                    if(index>0)
                    {
                        pas.append("<tr>");
                    }
                    command.addParameter(opp.code,opp.defaultValue);

                    pas.append("<td>" +opp.name+"</td>");
                    pas.append("<td>" +opp.code+"</td>");
                    pas.append("<td>" +opp.parameterIndex+"</td>");
                    pas.append("<td>" +opp.maxValue+"</td>");
                    pas.append("<td>" +opp.minValue+"</td>");
                    pas.append("<td>" +opp.defaultValue+"</td>");
                    pas.append("<td>" +opp.description+"</td>");
                    List<KV> kv=Json.fromJsonAsList(KV.class,opp.options);

                    StringBuilder kvlist=new StringBuilder();
                    kvlist.append("<ul>");
                    for(KV v:kv)
                    {
                        kvlist.append("<li>"+v.k+"  "+v.v+"</li>");
                    }
                    kvlist.append("</ul>");
                    pas.append("<td>"+kvlist.toString()+"</td>");

                    pas.append("</tr>");
                    index++;
                }
                if(ps.size()==0)
                {
                        pas.append("<td align='center' colspan='8'>无参数</td>");
                        pas.append("</tr>");
                }


                sb.append(pas.toString());

                json.append("<div class='cmd'>"+(opindex++)+"."+op.description+"</div><pre ><code class='json'>"+command.toJSON()+"</code></pre>");

            }
        %>
        <%=sb.toString()%>
    </table>

    <div>

            <%=json.toString()%>

    </div>

    <h3>事件</h3>
    <table cellpadding="4" border="1" >
        <tr>
            <td>属性</td>
            <td>事件名称</td>
            <td>事件代码</td>
            <td>事件索引</td>
            <td>事件说明</td>
            <td>参数名称</td>
            <td>参数代码</td>
            <td>参数索引</td>
            <td>参数最大值</td>
            <td>参数最小值</td>
            <td>参数缺省值</td>
            <td>参数说明</td>
            <td>值列表</td>
        </tr>
        <%

            sb=new StringBuilder();
            json=new StringBuilder();

            for(D_ATTRIBUTE_OPERATORObj op:pinfo.getAllOperator(p.id,1)) {

                List<D_OPERATOR_PARAMETERObj> ps=pinfo.getOperatorParameters(op.id);
                ZiroomCommand command=ZiroomCommand.notifyCommand();
                command.sno("0").command(op.code).did("14223");

                sb.append("<tr>");
                int rowspan=ps.size()==0?1:ps.size();
                D_PRODUCT_ATTRIBUTEObj attr=pinfo.findAttribute(op.attributeId);
                command.attribute(attr.code);
                sb.append("<td rowspan='"+rowspan+"'>"+attr.code+"</td>");
                sb.append("<td rowspan='"+rowspan+"'>"+op.name+"</td>");
                sb.append("<td rowspan='"+rowspan+"'>"+op.code+"</td>");
                sb.append("<td rowspan='"+rowspan+"'>"+op.operatorIndex+"</td>");
                sb.append("<td rowspan='"+rowspan+"'>"+op.description+"</td>");

                pas=new StringBuilder();
                int index=0;
                for(D_OPERATOR_PARAMETERObj opp:ps) {
                    if(index>0)
                    {
                        pas.append("<tr>");
                    }

                    pas.append("<td>" +opp.name+"</td>");
                    pas.append("<td>" +opp.code+"</td>");
                    pas.append("<td>" +opp.parameterIndex+"</td>");
                    pas.append("<td>" +opp.maxValue+"</td>");
                    pas.append("<td>" +opp.minValue+"</td>");
                    pas.append("<td>" +opp.defaultValue+"</td>");
                    pas.append("<td>" +opp.description+"</td>");
                    List<KV> kv=Json.fromJsonAsList(KV.class,opp.options);

                    StringBuilder kvlist=new StringBuilder();
                    kvlist.append("<ul>");
                    for(KV v:kv)
                    {
                        kvlist.append("<li>"+v.k+"  "+v.v+"</li>");
                    }
                    kvlist.append("</ul>");
                    pas.append("<td>"+kvlist.toString()+"</td>");

                    command.addParameter(opp.code,opp.defaultValue);
                    pas.append("</tr>");
                    index++;
                }
                if(ps.size()==0)
                {
                    pas.append("<td align='center' colspan='8'>无参数</td>");
                    pas.append("</tr>");
                }

                json.append("<div class='cmd'>"+(opindex++)+"."+op.description+"</div><pre ><code class='json'>"+command.toJSON()+"</code></pre>");

                sb.append(pas.toString());

            }
        %>
        <%=sb.toString()%>
    </table>
    <div>
        <%=json.toString()%>
    </div>

    <%}%>

    <div style="padding: 30px;background-color: azure">
        &copy; 2018 ziroom.com
    </div>
</body>
</html>
