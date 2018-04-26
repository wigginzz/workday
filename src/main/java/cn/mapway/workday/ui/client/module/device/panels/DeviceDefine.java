package cn.mapway.workday.ui.client.module.device.panels;

import cn.mapway.workday.ui.client.rpc.WorkdayProxy;
import cn.mapway.workday.ui.shared.module.ProductInfo;
import cn.mapway.workday.ui.shared.repository.D_PRODUCT_INFOObj;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.ksyzt.gwt.client.common.MessageComposite;
import com.ksyzt.gwt.client.event.MessageEvent;

public class DeviceDefine extends MessageComposite {
    interface DeviceDefineUiBinder extends UiBinder<HTMLPanel, DeviceDefine> {
    }

    private static DeviceDefineUiBinder ourUiBinder = GWT.create(DeviceDefineUiBinder.class);

    public DeviceDefine() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }


    @UiHandler("btnSave")
    void onSave(ClickEvent e)
    {
        fromUI();
        WorkdayProxy.get().updateOrSaveProduct(mInfo, new AsyncCallback<D_PRODUCT_INFOObj>() {
            @Override
            public void onFailure(Throwable caught) {
                    Window.alert(caught.getMessage());
            }

            @Override
            public void onSuccess(D_PRODUCT_INFOObj result) {
                MessageEvent ev=new MessageEvent(MessageEvent.SAVE,null);
                fireEvent(ev);
            }
        });

    }

    D_PRODUCT_INFOObj mInfo;
    public void edit(D_PRODUCT_INFOObj pi)
    {
        if(pi==null)
        {
            pi=new D_PRODUCT_INFOObj();
        }

        mInfo=pi;
        toUI();
    }

    @UiField
    TextBox txtCODE;

    @UiField
    TextBox txtDESC;
    @UiField
    TextBox txtNAME;


    private void toUI() {
        txtCODE.setValue(mInfo.code);
        txtDESC.setValue(mInfo.description);
        txtNAME.setValue(mInfo.name);
    }

    private void fromUI()
    {
        mInfo.code=txtCODE.getValue();
        mInfo.description=txtDESC.getValue();
        mInfo.name=txtNAME.getValue();
    }
}