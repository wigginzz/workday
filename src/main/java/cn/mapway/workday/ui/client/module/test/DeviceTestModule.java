package cn.mapway.workday.ui.client.module.test;

import cn.ennwifi.webframe.ui.client.ClientContext;
import cn.ennwifi.webframe.ui.client.modules.AbstractModuleWithEvent;
import cn.mapway.ui.client.mvc.IModule;
import cn.mapway.ui.client.mvc.ModuleMarker;
import cn.mapway.ui.client.mvc.ModuleParameter;
import cn.mapway.ui.client.tools.Clients;
import cn.mapway.workday.ui.client.common.JsonTools;
import cn.mapway.workday.ui.client.module.device.ProductTree;
import cn.mapway.workday.ui.client.rpc.WorkdayProxy;
import cn.mapway.workday.ui.shared.module.DataValue;
import cn.mapway.workday.ui.shared.module.DeviceInformation;
import cn.mapway.workday.ui.shared.module.ZiroomMessage;
import cn.mapway.workday.ui.shared.repository.D_ATTRIBUTE_OPERATORObj;
import cn.mapway.workday.ui.shared.repository.D_OPERATOR_PARAMETERObj;
import cn.mapway.workday.ui.shared.repository.D_PRODUCT_ATTRIBUTEObj;
import cn.mapway.workday.ui.shared.repository.D_PRODUCT_INFOObj;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试设备和网关程序
 */
@ModuleMarker(name = "协议测试", value = DeviceTestModule.MODULE_CODE, group = "/workday")
public class DeviceTestModule extends AbstractModuleWithEvent {

    private final SelectionHandler<TreeItem> commandClicked = new SelectionHandler<TreeItem>() {
        @Override
        public void onSelection(SelectionEvent<TreeItem> selectionEvent) {
            TreeItem item = selectionEvent.getSelectedItem();
            Object obj = item.getUserObject();
            if (obj == null) {
                return;
            }

            if (obj instanceof D_PRODUCT_INFOObj) {

            } else if (obj instanceof D_PRODUCT_ATTRIBUTEObj) {

            } else if (obj instanceof D_ATTRIBUTE_OPERATORObj) {
                D_ATTRIBUTE_OPERATORObj operator = (D_ATTRIBUTE_OPERATORObj) obj;
                D_PRODUCT_ATTRIBUTEObj attribute = (D_PRODUCT_ATTRIBUTEObj) item.getParentItem().getUserObject();
                D_PRODUCT_INFOObj product = (D_PRODUCT_INFOObj) item.getParentItem().getParentItem().getUserObject();
                List<D_OPERATOR_PARAMETERObj> ps = new ArrayList<>();
                for (int i = 0; i < item.getChildCount(); i++) {
                    TreeItem child = item.getChild(i);
                    D_OPERATOR_PARAMETERObj p = (D_OPERATOR_PARAMETERObj) child.getUserObject();
                    ps.add(p);

                }
                exportJsonCommand(product, attribute, operator, ps);
            } else if (obj instanceof D_OPERATOR_PARAMETERObj) {

            }
        }
    };

    private void exportJsonCommand(D_PRODUCT_INFOObj product, D_PRODUCT_ATTRIBUTEObj attribute, D_ATTRIBUTE_OPERATORObj operator, List<D_OPERATOR_PARAMETERObj> ps) {
        ZiroomMessage msg = new ZiroomMessage();
        msg.type = "DEVICE_CONTROL";
        msg.command = operator.code;
        msg.attribute = attribute.getCode();
        msg.did = ddlDevices.getSelectedValue();
        msg.model = "";
        msg.time = Clients.formatTime(Clients.now(), "yyyy-MM-dd HH:mm:ss");
        msg.sno = Clients.randomString(8);
        for (int i = 0; i < ps.size(); i++) {
            D_OPERATOR_PARAMETERObj p = ps.get(i);
            DataValue d = new DataValue();
            d.k = p.code;
            d.v = p.defaultValue;
            msg.data.add(d);
        }
        txtPAYLOAD.setValue(JsonTools.format(msg.toJSON()));
    }


    private String topicArrive;


    public static final String MODULE_CODE = "MC_DEVICE_TEST";

    @Override
    public String getModuleCode() {
        return MODULE_CODE;
    }


    interface DeviceTestModuleUiBinder extends UiBinder<DockLayoutPanel, DeviceTestModule> {
    }

    private static DeviceTestModuleUiBinder ourUiBinder = GWT.create(DeviceTestModuleUiBinder.class);

    public DeviceTestModule() {
        topicArrive = ClientContext.getContext().getMqttTopicPrefix() + "/arrive";
        initModuleWidget(ourUiBinder.createAndBindUi(this));
        tree.addSelectionHandler(commandClicked);
    }

    @UiField
    ProductTree tree;

    @Override
    public boolean initialize(IModule parentModule, ModuleParameter parameters) {
        boolean b = super.initialize(parentModule, parameters);
        updateTools(tools);
        tree.load();
        registerEventHandler(topicArrive);
        return b;
    }


    @Override
    protected void onLoad() {
        GWT.log("onLoad called reg " + topicArrive);
        super.onLoad();
        loadDevices();
        registerEventHandler(topicArrive);
    }

    private void loadDevices() {
        WorkdayProxy.get().getAllDevices(new AsyncCallback<List<DeviceInformation>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(List<DeviceInformation> deviceInformations) {
                renderDevives(deviceInformations);
            }
        });
    }

    private void renderDevives(List<DeviceInformation> deviceInformations) {
        ddlDevices.clear();
        for (DeviceInformation di : deviceInformations) {
            ddlDevices.addItem(di.channelId + "(" + di.mac + ")", di.channelId);
        }
        renderLabel();
    }

    private void renderLabel() {
        lbDevices.setText("选择设备(" + ddlDevices.getItemCount() + ")");
    }

    @Override
    protected void onUnload() {

        unRegisterEventHandler(topicArrive);

        super.onUnload();

    }

    public final static String DEVICE_INFO_QUERY = "DEVICE_INFO_QUERY";
    public final static String DEVICE_INFO_REPORT = "DEVICE_INFO_REPORT";
    public final static String DEVICE_CONTROL = "DEVICE_CONTROL";
    public final static String DEVICE_CONTROL_RESPONSE = "DEVICE_CONTROL_RESPONSE";
    public final static String DEVICE_STATE_NOTIFY = "DEVICE_STATE_NOTIFY";
    public final static String DEVICE_META = "DEVICE_META";
    public final static String DEVICE_CONNECT = "DEVICE_CONNECT";
    public final static String DEVICE_DISCONNECT = "DEVICE_DISCONNECT";
    public final static String DEVICE_UNKNOWN = "DEVICE_UNKNOWN";

    /**
     * 1
     * DEVICE_INFO_QUERY
     * 0x0001
     * 查询设备制造商信息
     * 2
     * DEVICE_INFO_REPORT
     * 0x0002
     * 设备报告自己的信息MAC地址
     * 3
     * DEVICE_CONTROL
     * 0x0003	设备控制指令
     * 4
     * DEVICE_CONTROL_RESPONSE
     * 0x0004
     * 控制响应指令
     * 5
     * DEVICE_STATE_NOTIFY
     * 0x0005
     * 设备状态发生变化通知消息
     * 6	DEVICE_META	0x0006	三设备报告自己的元数据 生产商和型号
     * 7	DEVICE_CONNECT	0x0007	socke建立连接
     * 8	DEVICE_DISCONNECT	0x0008	socke断开连接
     * 9	DEVICE_UNKNOWN	0x0009	不能解析的设备数据包
     *
     * @param topic
     * @param type1
     * @param event
     */
    @Override
    public void onEvent(String topic, int type1, Object event) {
        super.onEvent(topic, type1, event);
        GWT.log("page event >" + topic);
        if (topic.equals(topicArrive)) {
            JSONObject obj = (JSONObject) event;
            String type = obj.get("type").isString().stringValue();

            if (type.equals(DEVICE_META)) {
                String channelId = obj.get("attribute").isString().stringValue();
                String model = obj.get("model").isString().stringValue();
                String producer = obj.get("commmand").isString().stringValue();

                for (int i = 0; i < ddlDevices.getItemCount(); i++) {
                    String txt = ddlDevices.getItemText(i);
                    if (txt.equals(channelId)) {
                        ddlDevices.setItemText(i, channelId + "(" + model + ")");
                        break;
                    }
                }
                renderLabel();

                LogItem item = new LogItem();
                item.setData(channelId, DEVICE_META, producer + "," + model);
                out.insert(item, 0);

            } else if (type.equals(DEVICE_CONNECT)) {
                String channelId = obj.get("attribute").isString().stringValue();
                ddlDevices.addItem(channelId, channelId);
                renderLabel();
                LogItem item = new LogItem();
                item.setData(channelId, DEVICE_CONNECT, "");
                out.insert(item, 0);

            } else if (type.equals(DEVICE_DISCONNECT)) {
                String channelId = obj.get("attribute").isString().stringValue();

                for (int i = 0; i < ddlDevices.getItemCount(); i++) {
                    String idi = ddlDevices.getValue(i);
                    if (idi.startsWith(channelId)) {
                        ddlDevices.removeItem(i);
                        break;
                    }
                }
                renderLabel();
                LogItem item = new LogItem();
                item.setData(channelId, DEVICE_DISCONNECT, "");
                out.insert(item, 0);
            } else if (type.equals(DEVICE_UNKNOWN)) {
                String channelId = obj.get("attribute").isString().stringValue();
                String data = obj.get("command").isString().stringValue();
                LogItem item = new LogItem();

                item.setData(channelId, DEVICE_UNKNOWN, data);
                out.insert(item, 0);
            } else if (type.equals(DEVICE_CONTROL_RESPONSE)) {
                LogItem item = new LogItem();
                String chanelId = obj.get("did").isString().stringValue();
                item.setData(chanelId, DEVICE_CONTROL_RESPONSE, JsonUtils.stringify(obj.getJavaScriptObject()));
                out.insert(item, 0);
            } else if (type.equals(DEVICE_INFO_REPORT)) {
                String did = obj.get("did").isString().stringValue();
                String channelId = obj.get("attribute").isString().stringValue();

                for (int i = 0; i < ddlDevices.getItemCount(); i++) {
                    String txt = ddlDevices.getItemText(i);
                    if (txt.startsWith(channelId)) {
                        ddlDevices.setItemText(i, did + "(" + txt + ")");
                        break;
                    }
                }
                LogItem item = new LogItem();
                item.setData(did, DEVICE_INFO_REPORT, JsonUtils.stringify(obj.getJavaScriptObject()));
                out.insert(item, 0);
            } else if (type.equals(DEVICE_INFO_QUERY)) {
                LogItem item = new LogItem();
                String did = obj.get("did").isString().stringValue();
                item.setData(did, DEVICE_INFO_QUERY, JsonUtils.stringify(obj.getJavaScriptObject()));
                out.insert(item, 0);
            } else if (type.equals(DEVICE_CONTROL)) {
                LogItem item = new LogItem();
                String did = obj.get("did").isString().stringValue();
                item.setData(did, DEVICE_CONTROL, JsonUtils.stringify(obj.getJavaScriptObject()));
                out.insert(item, 0);
            }
        }
    }

    @UiField
    VerticalPanel out;

    @UiField
    TextArea txtPAYLOAD;


    @UiField
    HorizontalPanel tools;

    @UiHandler("btnClear")
    void onClear(ClickEvent e) {
        out.clear();
    }


    @UiHandler("btnSender")
    void onSender(ClickEvent e) {
        if (txtPAYLOAD.getValue().length() == 0) {
            ClientContext.getContext().confirm("输入要发送的内容,选择左边的命令");
            return;
        }
        String id = ddlDevices.getSelectedValue();
        if (id != null && id.length() > 0) {
            ZiroomMessage msg = new ZiroomMessage();
            msg.command = txtPAYLOAD.getValue();
            WorkdayProxy.get().sendMessage(id, msg, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable throwable) {

                }

                @Override
                public void onSuccess(Void aVoid) {

                }
            });
        } else {

            ClientContext.getContext().confirm("选择哟发送的设备");
        }
    }

    @UiField
    Label lbDevices;
    @UiField
    ListBox ddlDevices;
}