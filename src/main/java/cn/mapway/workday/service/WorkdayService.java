package cn.mapway.workday.service;

import cn.mapway.workday.api.module.CatalogsReq;
import cn.mapway.workday.api.module.CatalogsResp;
import cn.mapway.workday.ui.shared.repository.CATALOGObj;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkdayService {

    @Autowired
    Dao dao;

    public CatalogsResp catalogs(CatalogsReq req) {
        CatalogsResp r=new CatalogsResp();
        Condition where= Cnd.orderBy().asc(CATALOGObj.FLD_ID);
        r.catalogs=dao.query(CATALOGObj.class,where);
        r.ok();
        return r;
    }
}
