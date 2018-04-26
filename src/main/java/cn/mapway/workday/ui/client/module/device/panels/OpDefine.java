package cn.mapway.workday.ui.client.module.device.panels;

import cn.ennwifi.webframe.ui.client.common.MetaBox;
import cn.mapway.ui.client.widget.common.PrimaryButton;
import cn.mapway.workday.ui.client.rpc.WorkdayProxy;
import cn.mapway.workday.ui.shared.repository.D_ATTRIBUTE_OPERATORObj;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.ksyzt.gwt.client.common.MessageComposite;
import com.ksyzt.gwt.client.event.MessageEvent;

public class OpDefine extends MessageComposite {

    interface OpDefineUiBinder extends UiBinder<HTMLPanel, OpDefine> {
    }

    private static OpDefineUiBinder ourUiBinder = GWT.create(OpDefineUiBinder.class);

    public OpDefine() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }


    D_ATTRIBUTE_OPERATORObj operator;

    @UiField
    PrimaryButton btnDelete;
    @UiField
    PrimaryButton btnSave;


    @UiHandler("btnSave")
    void onSave(ClickEvent e) {
        fromUI();

        WorkdayProxy.get().updateOrSaveAttributeOperator(operator, new AsyncCallback<D_ATTRIBUTE_OPERATORObj>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            @Override
            public void onSuccess(D_ATTRIBUTE_OPERATORObj result) {
                MessageEvent ev = new MessageEvent(MessageEvent.SAVE, null);
                fireEvent(ev);
            }
        });
    }

   @UiHandler("btnDelete")
    void onDelete(ClickEvent e) {
        if (operator.id != null) {
            WorkdayProxy.get().deleteAttributeOperator(operator.id, new AsyncCallback<Boolean>() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert(caught.getMessage());
                }

                @Override
                public void onSuccess(Boolean result) {
                    MessageEvent ev = new MessageEvent(MessageEvent.DELETE, null);
                    fireEvent(ev);
                }
            });
        }
    }


    /**
     *
     * @param attributeId
     * @param op
     * @param type 0 operator 1 event
     */
    public void edit(Integer attributeId, D_ATTRIBUTE_OPERATORObj op,int type) {

        if (op == null) {
            op = new D_ATTRIBUTE_OPERATORObj();
            op.attributeId = attributeId;
            op.type=type;
            op.operatorIndex = 0;

        }
        operator = op;

        toUI();
    }

    @UiField
    TextBox txtCODE;

    @UiField
    TextBox txtDESC;
    @UiField
    TextBox txtNAME;

    @UiField
    TextBox txtBIN;

    @UiField
    Label lbTitle;

    @UiField
    MetaBox metaDirection;

    private void toUI() {
        if(operator.type==0)
        {
            lbTitle.setText("操作定义");
            metaDirection.setVisible(true);
            metaDirection.setValue(operator.direction+"");
        }
        else
        {
            lbTitle.setText("事件定义");
            metaDirection.setEnabled(false);
            metaDirection.setValue("1");
        }
        txtCODE.setValue(operator.code);
        txtDESC.setValue(operator.description);
        txtNAME.setValue(operator.name);
        txtBIN.setValue(operator.operatorIndex + "");
    }

    private void fromUI() {
        operator.code = txtCODE.getValue();
        operator.description = txtDESC.getValue();
        operator.name = txtNAME.getValue();
        operator.operatorIndex = Integer.parseInt(txtBIN.getValue());

        operator.direction=Integer.parseInt(metaDirection.getValue());


    }

}