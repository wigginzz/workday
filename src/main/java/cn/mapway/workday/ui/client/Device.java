package cn.mapway.workday.ui.client;

import cn.ennwifi.webframe.ui.client.WebFrameEntry;
import cn.mapway.workday.ui.client.module.dashboard.Dashboard;
import cn.mapway.workday.ui.client.module.device.DevicePanel;
import cn.mapway.workday.ui.client.resource.WorkdayResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

/**
 * main page entry.
 */
public class Device extends WebFrameEntry {

    public String getDashBoardModuleCode() {
        return Dashboard.MODULE_CODE;
    }

    public Integer getResourceRootId() {
        return 1;
    }

    @Override
    public void onModuleLoad() {

        super.onModuleLoad();
    }
}
