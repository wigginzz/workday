package cn.mapway.workday.tools;

import cn.mapway.document.helper.Scans;
import cn.mapway.workday.service.WorkdayService;
import cn.mapway.workday.ui.shared.module.ProductInfo;

public class Jsps {
    public static ProductInfo getProductInfo() {
        WorkdayService workdayService = Springs.get(WorkdayService.class);
        return workdayService.products();
    }

    /**
     * 版本信息.
     * @return
     */
    public static String version() {
        return Scans.readResource("cn.mapway.workday","compile.txt");
    }
}
