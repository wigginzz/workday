package cn.mapway.workday.servlets;

import cn.mapway.document.helper.DocHelper;
import cn.mapway.document.helper.ParseType;
import cn.mapway.document.module.ApiDoc;
import cn.mapway.document.parser.GenContext;
import cn.mapway.workday.api.module.Resp;
import cn.mapway.workday.configure.SpringResourceLocation;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.lang.Streams;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.resource.Scans;
import org.springframework.context.ApplicationContext;


import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;

import static org.nutz.lang.Files.write;


/**
 * 应用程序提供Servlet
 *
 * @author zhangjianshe
 */
public class MapwayApplicationServlet extends HttpServlet {

    private ApplicationContext appContext;

    public void setAppContext(ApplicationContext context) {
        appContext = context;

        SpringResourceLocation springResourceLocation = new SpringResourceLocation();
        springResourceLocation.setApplicationContext(context);
        Scans.me().addResourceLocation(springResourceLocation);
    }

    /**
     * 日志记录器.
     */
    private static Log log = Logs.getLog("MapwayApplicationServlet");

    /**
     * 文档上下文环境.
     */
    private GenContext context;

    /**
     * 需要扫描的包名称.
     */
    private String packageNames;


    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor of the object.
     */
    public MapwayApplicationServlet() {
        super();
        log.info("*mapway application constructed!");
    }

    /**
     * Destruction of the servlet. <br>
     */
    @Override
    public void destroy() {
        super.destroy();
    }

    /**
     * The doGet method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // |-------- Server-----|--app----|servlet| pathinfo
        // PathInfo http://www.ennwifi.cn/mapwaydoc/doc/demo/123
        String pathInfo = request.getPathInfo();
        dispatch(pathInfo, request, response);
    }

    /**
     * 调度文档命令
     * <p>
     * |-------- Server-----|--app----|servlet| pathinfo
     * PathInfo http://www.ennwifi.cn/mapwaydoc/doc     /demo/123
     *
     * @param request  the request
     * @param response the response
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void dispatch(String path, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        log.info("request path>" + path);
        byte[] data = cn.mapway.document.helper.Scans.readBinResource("static", path);
        if (data.length == 0) {
            Resp resp = new Resp();
            resp.fail(404, "没有找到资源" + path);
            json(response, resp);
        } else {
            String mime = getContentType(path);
            byteout(response, data, mime);
        }
    }

    public static String getContentType(String filename) {
        String type = "application/octet-stream";
        Path path = Paths.get(filename);
        try {
            type = Files.probeContentType(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return type;
    }


    /**
     * 输出文档HTML页面.
     *
     * @param request  the request
     * @param response the response
     */
    private void genhtml(HttpServletRequest request, HttpServletResponse response) {

        File htmlFile = getCacheFileName();

        if (!htmlFile.exists()) {
            writeToLocal(htmlFile);
        }

        try {
            response.setCharacterEncoding("UTF-8");
            Streams.writeAndClose(response.getWriter(), Streams.utf8r(Streams.fileIn(htmlFile)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToLocal(File htmlFile) {
        DocHelper helper = new DocHelper();


        ApiDoc api = helper.toDoc(ParseType.PT_SPRING, context, packageNames);


        // 设置下载目录

        String html = helper.genHTML(api);
        //save to local for reload

        org.nutz.lang.Files.write(htmlFile, Streams.utf8r(Lang.ins(html)));
    }

    /**
     * Gets the cache file name.
     *
     * @return the cache file name
     */
    private File getCacheFileName() {

        return new File(getTempFolder() + "/html.data");
    }



    /**
     * Byteout.
     *
     * @param response    the response
     * @param data        the data
     * @param contentType the content type
     */
    private void byteout(HttpServletResponse response, byte[] data, String contentType) {
        if (!Strings.isBlank(contentType)) {
            response.setContentType(contentType);

        }
        try {
            response.getOutputStream().write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Json.
     *
     * @param response the response
     * @param data     the data
     */
    private void json(HttpServletResponse response, Object data) {
        out(response, Json.toJson(data), "application/json");
    }

    /**
     * Html.
     *
     * @param response the response
     * @param data     the data
     */
    private void html(HttpServletResponse response, String data) {
        out(response, data, "text/html");
    }

    /**
     * Out.
     *
     * @param response    the response
     * @param data        the data
     * @param contentType the content type
     */
    private void out(HttpServletResponse response, String data, String contentType) {
        response.setContentType(contentType);
        response.setCharacterEncoding("UTF-8");
        try {
            Lang.writeAll(response.getWriter(), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the base path.
     *
     * @param request the request
     * @return the base path
     */
    public static String getBasePath(HttpServletRequest request) {
        String path = request.getContextPath();
        String port = request.getServerPort() == 80 ? "" : (":" + request.getServerPort());

        String basePath = request.getScheme() + "://" + request.getServerName() + port + path + "/";
        return basePath;
    }

    /**
     * The doPost method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * 作者.
     */
    public final static String PARAM_AUTHOR = "author";

    /**
     * 标题.
     */
    public final static String PARAM_TITLE = "title";

    /**
     * 子标题.
     */
    public final static String PARAM_SUB_TITLE = "subtitle";

    /**
     * 接口URL基路径.
     */
    public final static String PARAM_BASE_PATH = "basePath";

    /**
     * 域名.
     */
    public final static String PARAM_DOMAIN = "domain";

    /**
     * ANT hOME路径.
     */
    public final static String PARAM_ANT_HOME = "antHome";

    /**
     * 扫描的包名，支持，号隔开多个包名.
     */
    public final static String PARAM_SCAN_PACKAGES = "scanPackages";

    /**
     * 连接的包名.
     */
    public final static String PARAM_CONNECTOR_PACKAGE_NAME = "connectorPackageName";

    /**
     * 连接的类名.
     */
    public final static String PARAM_CONNECTOR_CLASS_NAME = "connectorClassName";

    /**
     * 连接的类名.
     */
    public final static String PARAM_COPY_RIGHT = "copyright";

    /**
     * 是否允许生成JavaConnector.
     */
    public final static String PARAM_ENABLE_JAVA_CONNECTOR = "enableJavaConnector";

    /**
     * 是否允许生成GwtConnector.
     */
    public final static String PARAM_ENABLE_GWT_CONNECTOR = "enableGwtConnector";

    /**
     * 文档API版本.
     */
    public final static String PARAM_API_VERSION = "apiVersion";

    /**
     * 返回的URL.
     */
    public static final String PARAM_HOME_URL = "homeUrl";

    /**
     * LOGO base64 data
     */
    public static final String PARAM_LOGO_BASE64 = "logoBase64";


    /**
     * 样式文件,可以是 网络的文件，也可以直接是 css样式.
     */
    public static final String PARAM_CSS_STYLE = "cssStyle";

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    @Override
    public void init() throws ServletException {
        log.info("模块初始化");
        Enumeration<String> keys;
        keys = this.getInitParameterNames();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            log(key + ">" + this.getInitParameter(key));
        }

        context = new GenContext();
        context.setAuthor(Strings.sBlank(this.getInitParameter(PARAM_AUTHOR)));
        context.setDocTitle(Strings.sBlank(this.getInitParameter(PARAM_TITLE)));
        context.setDomain(Strings.sBlank(this.getInitParameter(PARAM_DOMAIN)));
        context.setBasepath(Strings.sBlank(this.getInitParameter(PARAM_BASE_PATH)));
        context.setSubtitle(Strings.sBlank(this.getInitParameter(PARAM_SUB_TITLE)));
        packageNames = Strings.sBlank(this.getInitParameter(PARAM_SCAN_PACKAGES));

        context.setCopyright(Strings.sBlank(getInitParameter(PARAM_COPY_RIGHT)));
        context.setEnableJavaConnector(Strings.sBlank(getInitParameter(PARAM_ENABLE_JAVA_CONNECTOR)));
        context.setEnableGwtConnector(Strings.sBlank(getInitParameter(PARAM_ENABLE_GWT_CONNECTOR)));
        context.setLogobase64(Strings.sBlank(getInitParameter(PARAM_LOGO_BASE64)));
        context.setApiversion(Strings.sBlank(getInitParameter(PARAM_API_VERSION)));
        context.setHomeUrl(Strings.sBlank(getInitParameter(PARAM_HOME_URL)));
        context.setCssStyle(Strings.sBlank(getInitParameter(PARAM_CSS_STYLE)));

        // 删除临时文件
        File htmlCache = getCacheFileName();
        if (htmlCache.exists()) {
            htmlCache.delete();
        }
    }

    /**
     * Gets the temp folder.
     *
     * @return the temp folder
     */
    public String getTempFolder() {
        String folder = System.getProperty("java.io.tmpdir");
        System.out.println("temporary fold >" + folder);
        return folder;
    }
}
