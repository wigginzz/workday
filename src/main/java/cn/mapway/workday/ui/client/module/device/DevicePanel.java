package cn.mapway.workday.ui.client.module.device;

import cn.mapway.ui.client.frames.AbstractModule;
import cn.mapway.ui.client.mvc.IModule;
import cn.mapway.ui.client.mvc.ModuleMarker;
import cn.mapway.ui.client.mvc.ModuleParameter;
import cn.mapway.ui.client.widget.common.PrimaryButton;
import cn.mapway.workday.ui.client.module.device.panels.*;
import cn.mapway.workday.ui.shared.repository.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.ksyzt.gwt.client.event.MessageEvent;
import com.ksyzt.gwt.client.event.MessageHandler;


@ModuleMarker(value = DevicePanel.MODULE_CODE, group = "/Workday", name = "设备参数")
public class DevicePanel extends AbstractModule implements SelectionHandler<TreeItem> {

    public final static String MODULE_CODE = "MC_DEVICE_PANEL";

    @Override
    public String getModuleCode() {
        return MODULE_CODE;
    }

    @Override
    public boolean initialize(IModule parentModule, ModuleParameter parameters) {
        boolean b = super.initialize(parentModule, parameters);
        tree.load();
        updateTools(tools);
        return b;
    }

    private MessageHandler messageHandler = new MessageHandler() {
        @Override
        public void onMessage(Object o, Integer integer, Object o1) {
            if (integer.equals(MessageEvent.SAVE) || integer.equals(MessageEvent.DELETE)) {
                tree.load();
                current=null;
                body.clear();
            }
        }
    };

    D_PRODUCT_INFOObj product;
    D_PRODUCT_ATTRIBUTEObj attribute;
    D_ATTRIBUTE_OPERATORObj operator;
    D_OPERATOR_PARAMETERObj parameter;
    @Override
    public void onSelection(SelectionEvent<TreeItem> event1) {
        TreeItem item = event1.getSelectedItem();
        Object obj = item.getUserObject();
        if (obj == null) {
            return;
        }

        if (obj instanceof D_PRODUCT_INFOObj) {
            product = (D_PRODUCT_INFOObj) obj;
            editProductInfo(product);
        } else if (obj instanceof D_PRODUCT_ATTRIBUTEObj) {
            attribute = (D_PRODUCT_ATTRIBUTEObj) obj;

            product= (D_PRODUCT_INFOObj) item.getParentItem().getUserObject();

            editProductAttribute(attribute);
        } else if (obj instanceof D_ATTRIBUTE_OPERATORObj) {
            operator = (D_ATTRIBUTE_OPERATORObj) obj;
            attribute= (D_PRODUCT_ATTRIBUTEObj) item.getParentItem().getUserObject();
            product= (D_PRODUCT_INFOObj) item.getParentItem().getParentItem().getUserObject();
            editAttributeOperator(operator);
        }else if (obj instanceof D_OPERATOR_PARAMETERObj) {
            parameter = (D_OPERATOR_PARAMETERObj) obj;
            operator=(D_ATTRIBUTE_OPERATORObj) item.getParentItem().getUserObject();
            attribute= (D_PRODUCT_ATTRIBUTEObj) item.getParentItem().getParentItem().getUserObject();
            product= (D_PRODUCT_INFOObj) item.getParentItem().getParentItem().getParentItem().getUserObject();

            editOperatorParameter(parameter);
        }
    }

    private void editOperatorParameter(D_OPERATOR_PARAMETERObj para) {
        sureParameter().edit(operator.id,para);
        btnAddAttribute.setEnabled(true);
        btnAddEvent.setEnabled(false);
        btnAddOperation.setEnabled(false);
        btnAddParameter.setEnabled(false);
    }



    private DeviceDefine panelDevice;
    private AttrDefine panelAttr;

    private AttrDefine sureAttrDefine() {
        if (panelAttr == null) {
            panelAttr = new AttrDefine();
            panelAttr.addMessageHandler(messageHandler);
        }

        if (current != null) {
            if (current == panelAttr) {
                return panelAttr;
            } else {
                body.clear();
                body.add(panelAttr);
                current = panelAttr;
            }
        } else {
            body.clear();
            body.add(panelAttr);
            current = panelAttr;
        }
        return panelAttr;
    }


    private DeviceDefine sureDeviceDefine() {
        if (panelDevice == null) {
            panelDevice = new DeviceDefine();
            panelDevice.addMessageHandler(messageHandler);
        }

        if (current != null) {
            if (current == panelDevice) {
                return panelDevice;
            } else {
                body.clear();
                body.add(panelDevice);
                current = panelDevice;
            }
        } else {
            body.clear();
            body.add(panelDevice);
            current = panelDevice;
        }
        return panelDevice;
    }


    private void editProductInfo(D_PRODUCT_INFOObj productInfo) {

        sureDeviceDefine().edit(productInfo);
        btnAddAttribute.setEnabled(true);
        btnAddEvent.setEnabled(false);
        btnAddOperation.setEnabled(false);
        btnAddParameter.setEnabled(false);

    }

    private void editProductAttribute(D_PRODUCT_ATTRIBUTEObj fld) {
        sureAttrDefine().edit(0, fld);
        btnAddAttribute.setEnabled(false);
        btnAddEvent.setEnabled(true);
        btnAddOperation.setEnabled(true);
        btnAddParameter.setEnabled(false);

    }

    private void editAttributeOperator(D_ATTRIBUTE_OPERATORObj operator) {

        sureOperator().edit(attribute.id, operator,0);
        btnAddAttribute.setEnabled(false);
        btnAddEvent.setEnabled(false);
        btnAddOperation.setEnabled(false);
        btnAddParameter.setEnabled(true);
    }



    interface DevicePanelUiBinder extends UiBinder<DockLayoutPanel, DevicePanel> {
    }

    private static DevicePanelUiBinder ourUiBinder = GWT.create(DevicePanelUiBinder.class);

    public DevicePanel() {
        initModuleWidget(ourUiBinder.createAndBindUi(this));

        tree.addSelectionHandler(this);

    }

    Widget current;

    @UiField
    ScrollPanel body;

    @UiField
    ProductTree tree;

    @UiField
    PrimaryButton btnAddAttribute;

    @UiField
    PrimaryButton btnAddDevice;

    @UiField
    PrimaryButton btnAddEvent;

    @UiField
    PrimaryButton btnAddOperation;


    @UiField
    PrimaryButton btnAddParameter;

    @UiField
    HorizontalPanel tools;

    @UiHandler("btnAddDevice")
    void onAddDevice(ClickEvent e) {
        sureDeviceDefine().edit(null);
    }

    @UiHandler("btnAddAttribute")
    void onAddAttr(ClickEvent e) {
        sureAttrDefine().edit(product.id, null);
    }


    @UiHandler("btnAddOperation")
    void onAddOperator(ClickEvent e) {

        if (attribute == null || attribute.id == null) {
            Window.alert("选择属性进行操作");
            return;
        }
        sureOperator().edit(attribute.id, null,0);
    }
    @UiHandler("btnAddParameter")
    void onAddParameter(ClickEvent e) {

            if (operator == null || operator.id == null) {
            Window.alert("选择操作进行操作");
            return;
        }
        sureParameter().edit(operator.id, null);
    }

    @UiHandler("btnAddEvent")
    void onAddEvent(ClickEvent e) {

        if (attribute == null || attribute.id == null) {
            Window.alert("选择属性进行操作");
            return;
        }
        sureOperator().edit(attribute.id, null,1);
    }

    OpDefine panelOperator;

    private OpDefine sureOperator() {
        if (panelOperator == null) {
            panelOperator = new OpDefine();
            panelOperator.addMessageHandler(messageHandler);
        }

        if (current != null) {
            if (current == panelOperator) {
                return panelOperator;
            } else {
                body.clear();
                body.add(panelOperator);
                current = panelOperator;
            }
        } else {
            body.clear();
            body.add(panelOperator);
            current = panelOperator;
        }
        return panelOperator;
    }

    ParameterDefine panelParameter;

    private ParameterDefine sureParameter() {
        if (panelParameter == null) {
            panelParameter = new ParameterDefine();
            panelParameter.addMessageHandler(messageHandler);
        }

        if (current != null) {
            if (current == panelParameter) {
                return panelParameter;
            } else {
                body.clear();
                body.add(panelParameter);
                current = panelParameter;
            }
        } else {
            body.clear();
            body.add(panelParameter);
            current = panelParameter;
        }
        return panelParameter;
    }

}