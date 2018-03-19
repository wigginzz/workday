package cn.mapway.workday.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页面跳转 controller
 */
@Controller
public class MainController {

    /**
     * 首页面.
     *
     * @return
     */
    @RequestMapping(value = "/")
    public String index() {
        return "jsp/index";
    }
}
