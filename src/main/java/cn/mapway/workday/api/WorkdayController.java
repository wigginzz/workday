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
    public CatalogsResp catalogs(@RequestBody CatalogsReq req) {
        CatalogsResp r = workdayService.catalogs(req);
        return r;
    }
}
