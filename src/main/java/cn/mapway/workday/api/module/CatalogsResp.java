package cn.mapway.workday.api.module;

import cn.mapway.document.annotation.Doc;
import cn.mapway.workday.ui.shared.repository.CATALOGObj;

import java.util.List;

@Doc("所有的分类目录")
public class CatalogsResp extends Resp {
        public List<CATALOGObj> catalogs;
}
