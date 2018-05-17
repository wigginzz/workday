package cn.mapway.workday.ui.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * 服务代理工厂类.
 *
 * @author zhangjianshe
 */
public class WorkdayProxy {

    /**
     * The proxy.
     */
    private static IWorkdayServerAsync PROXY;

    /**
     * Gets the.
     *
     * @return the i ui server async
     */
    public static IWorkdayServerAsync get() {
        if (PROXY == null) {
            PROXY = GWT.create(IWorkdayServer.class);

            ServiceDefTarget t = (ServiceDefTarget) PROXY;
            t.setServiceEntryPoint("/workdayServer");
        }
        return PROXY;
    }
}