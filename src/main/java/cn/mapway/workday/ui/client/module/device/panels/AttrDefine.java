package cn.mapway.workday.ui.client.module.device.panels;

import cn.mapway.workday.ui.client.rpc.WorkdayProxy;
import cn.mapway.workday.ui.shared.module.ProductInfo;
import cn.mapway.workday.ui.shared.repository.D_PRODUCT_ATTRIBUTEObj;
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

public class AttrDefine extends MessageComposite {
    interface AttrDefineUiBinder extends UiBinder<HTMLPanel, AttrDefine> {
    }

    private static AttrDefineUiBinder ourUiBinder = GWT.create(AttrDefineUiBinder.class);

    public AttrDefine() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }


    @UiHandler("btnSave")
    void onSave(ClickEvent e)
    {
        fromUI();

        WorkdayProxy.get().updateOrSaveProductAttribute(attr, new AsyncCallback<D_PRODUCT_ATTRIBUTEObj>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            @Override
            public void onSuccess(D_PRODUCT_ATTRIBUTEObj result) {
                MessageEvent ev=new MessageEvent(MessageEvent.SAVE,null);
                fireEvent(ev);
            }
        });
    }

    @UiHandler("btnDelete")
    void onDelete(ClickEvent e)
    {
        if(attr.id!=null)
        {
            WorkdayProxy.get().deleteProductAttribute(attr.id, new AsyncCallback<Boolean>() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert(caught.getMessage());
                }

                @Override
                public void onSuccess(Boolean result) {
                    MessageEvent ev=new MessageEvent(MessageEvent.DELETE,null);
                    fireEvent(ev);
                }
            });
        }


    }


    D_PRODUCT_ATTRIBUTEObj attr;

    boolean isEdit=false;

    public void edit(Integer productId, D_PRODUCT_ATTRIBUTEObj fld)
    {

        if(fld==null)
        {
            fld=new D_PRODUCT_ATTRIBUTEObj();
            fld.productId=productId;
            isEdit=false;
        }
        else
        {
            isEdit=true;
        }

        attr=fld;

        toUI();
    }

    @UiField
    TextBox txtCODE;

    @UiField
    TextBox txtDESC;
    @UiField
    TextBox txtNAME;


    private void toUI() {
        txtCODE.setValue(attr.code);
        txtDESC.setValue(attr.description);
        txtNAME.setValue(attr.name);
    }

    private void fromUI()
    {
        attr.code=txtCODE.getValue();
        attr.description=txtDESC.getValue();
        attr.name=txtNAME.getValue();
    }
}