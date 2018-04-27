package cn.mapway.workday.service;

import cn.mapway.workday.api.module.CatalogsReq;
import cn.mapway.workday.api.module.CatalogsResp;
import cn.mapway.workday.ui.shared.module.ProductInfo;
import cn.mapway.workday.ui.shared.repository.*;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.lang.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkdayService {

    @Autowired
    Dao dao;

    public Dao getDao() {
        return dao;
    }

    public CatalogsResp catalogs(CatalogsReq req) {
        CatalogsResp r=new CatalogsResp();
        Condition where= Cnd.orderBy().asc(CATALOGObj.FLD_ID);
        r.catalogs=dao.query(CATALOGObj.class,where);
        r.ok();
        return r;
    }

    public static void main(String[] args) {
        System.out.printf(Lang.md5("123456"));
    }

    public ProductInfo products() {
        ProductInfo r=new ProductInfo();
        r.attributes=getDao().query(D_PRODUCT_ATTRIBUTEObj.class,Cnd.orderBy().asc(D_PRODUCT_ATTRIBUTEObj.FLD_PRODUCT_ID).asc(D_PRODUCT_ATTRIBUTEObj.FLD_ATTRIBUTE_INDEX));
        r.operators=getDao().query(D_ATTRIBUTE_OPERATORObj.class,Cnd.orderBy().asc(D_ATTRIBUTE_OPERATORObj.FLD_ATTRIBUTE_ID).asc(D_ATTRIBUTE_OPERATORObj.FLD_OPERATOR_INDEX));
        r.parameters=getDao().query(D_OPERATOR_PARAMETERObj.class,Cnd.orderBy().asc(D_OPERATOR_PARAMETERObj.FLD_OPERATOR_ID).asc(D_OPERATOR_PARAMETERObj.FLD_PARAMETER_INDEX));
        r.products=getDao().query(D_PRODUCT_INFOObj.class,Cnd.orderBy().asc(D_PRODUCT_INFOObj.FLD_ID));
        return r;
    }
}
