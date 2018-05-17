package cn.mapway.workday.ui.client.module.test;

import cn.ennwifi.webframe.ui.client.ClientContext;
import cn.ennwifi.webframe.ui.client.modules.AbstractModuleWithEvent;
import cn.mapway.ui.client.mvc.IModule;
import cn.mapway.ui.client.mvc.ModuleMarker;
import cn.mapway.ui.client.mvc.ModuleParameter;
import cn.mapway.workday.ui.client.module.device.ProductTree;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

/**
 * 测试设备和网关程序
 */
@ModuleMarker(name = "协议测试", value = DeviceTestModule.MODULE_CODE, group = "/workday")
public class DeviceTestModule extends AbstractModuleWithEvent {

    private String topic;
    public static final String MODULE_CODE = "MC_DEVICE_TEST";

    @Override
    public String getModuleCode() {
        return MODULE_CODE;
    }


    interface DeviceTestModuleUiBinder extends UiBinder<DockLayoutPanel, DeviceTestModule> {
    }

    private static DeviceTestModuleUiBinder ourUiBinder = GWT.create(DeviceTestModuleUiBinder.class);

    public DeviceTestModule() {
        initModuleWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiField
    ProductTree tree;

    @Override
    public boolean initialize(IModule parentModule, ModuleParameter parameters) {
        boolean b = super.initialize(parentModule, parameters);
        updateTools(tools);
        tree.load();
        return b;
    }

    @Override
    protected void onLoad() {
        topic = ClientContext.getContext().getMqttTopicPrefix() + "/arrive";
        GWT.log("sub " + topic);
        super.onLoad();
        registerEventHandler(topic);
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        unRegisterEventHandler(topic);
        GWT.log("unsub " + topic);
    }

    @Override
    public void onEvent(String topic, int type, Object event) {
        super.onEvent(topic, type, event);
        if (topic.equals(this.topic)) {
            JSONObject obj = (JSONObject) event;
            Label l = new Label(JsonUtils.stringify(obj.getJavaScriptObject()));
            out.insert(l, 0);
        }
    }

    @UiField
    VerticalPanel out;

    @UiField
    TextArea txtPAYLOAD;
    @UiField
    TextBox txtPUB;

    @UiField
    HorizontalPanel tools;

    @UiHandler("btnClear")
    void onClear(ClickEvent e) {
        out.clear();
    }

    @UiHandler("btnSender")
    void onSender(ClickEvent e) {
        if (txtPUB.getValue().length() == 0 || txtPAYLOAD.getValue().length() == 0) {
            return;
        }

        ClientContext.getContext().pub(txtPUB.getValue(), txtPAYLOAD.getValue());
    }
}