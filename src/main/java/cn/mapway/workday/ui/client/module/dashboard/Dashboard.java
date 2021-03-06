package cn.mapway.workday.ui.client.module.dashboard;

import cn.ennwifi.webframe.ui.client.modules.AbstractModuleWithEvent;
import cn.mapway.ui.client.frames.AbstractModule;
import cn.mapway.ui.client.mvc.IModule;
import cn.mapway.ui.client.mvc.ModuleMarker;
import cn.mapway.ui.client.mvc.ModuleParameter;
import cn.mapway.workday.ui.client.rpc.WorkdayProxy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;

import java.util.Map;

@ModuleMarker(value = Dashboard.MODULE_CODE, group = "/Workday", name = "面版")
public class Dashboard extends AbstractModule {

    public final static String MODULE_CODE="MC_WD_DASHBOARD";

    interface DashboardUiBinder extends UiBinder<HTMLPanel, Dashboard> {
    }

    private static DashboardUiBinder ourUiBinder = GWT.create(DashboardUiBinder.class);

    public Dashboard() {
        initModuleWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    public boolean initialize(IModule parentModule, ModuleParameter parameters) {
        boolean b = super.initialize(parentModule, parameters);
        initPage();
        return b;
    }

    @Override
    public String getModuleCode() {
        return MODULE_CODE;
    }

    private void initPage() {
        body.clear();

        WorkdayProxy.get().versions(new AsyncCallback<Map<String, String>>() {
            @Override
            public void onFailure(Throwable caught) {

                body.add(new Label(caught.getMessage()));
            }

            @Override
            public void onSuccess(Map<String, String> result) {
                    for (String key:result.keySet())
                    {
                        Label l=new Label(key+":"+result.get(key));
                        body.add(l);
                    }
            }
        });
    }

    @UiField
    HTMLPanel body;
}