package cn.mapway.workday.api;

import cn.mapway.document.annotation.Doc;
import cn.mapway.workday.api.module.CatalogsReq;
import cn.mapway.workday.api.module.CatalogsResp;
import cn.mapway.workday.service.WorkdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * zjs.
 */
@Doc("workday link api")
@RestController
@RequestMapping(value = "/api/v1")
public class WorkdayController {

    @Autowired
    WorkdayService workdayService;

    @Doc(value = "所有目录")
    @RequestMapping(value = "/catalogs", method = {RequestMethod.POST})
    public CatalogsResp catalogs(@RequestBody CatalogsReq req, HttpServletRequest request) {

        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String v = request.getHeader(key);

            System.out.printf("%s:%s\r\n", key, v);
        }

        CatalogsResp r = workdayService.catalogs(req);
        return r;
    }
}
