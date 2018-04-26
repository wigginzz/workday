package cn.mapway.workday.ui.client.module.device.panels;

import cn.ennwifi.webframe.ui.client.common.MetaBox;
import cn.mapway.ui.client.widget.common.PrimaryButton;
import cn.mapway.workday.ui.client.common.KeyValueEditor;
import cn.mapway.workday.ui.client.rpc.WorkdayProxy;
import cn.mapway.workday.ui.shared.repository.D_ATTRIBUTE_OPERATORObj;
import cn.mapway.workday.ui.shared.repository.D_OPERATOR_PARAMETERObj;
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
import com.ksyzt.gwt.client.event.MessageHandler;

public class ParameterDefine extends MessageComposite {

    private final MessageHandler keyValueHandler =new MessageHandler() {
        @Override
        public void onMessage(Object sender, Integer message, Object value) {
            if(message==MessageEvent.SAVE)
            {
                String data= (String) value;
                if(parameter!=null)
                {
                    parameter.setOptions(data);
                }
            }
        }
    };

    interface ParameterDefineUiBinder extends UiBinder<HTMLPanel, ParameterDefine> {
    }

    private static ParameterDefineUiBinder ourUiBinder = GWT.create(ParameterDefineUiBinder.class);

    public ParameterDefine() {
        initWidget(ourUiBinder.createAndBindUi(this));
        editor.addMessageHandler(keyValueHandler);
    }

    @UiField
    KeyValueEditor editor;

    D_OPERATOR_PARAMETERObj parameter;

    @UiField
    PrimaryButton btnDelete;
    @UiField
    PrimaryButton btnSave;


    @UiHandler("btnSave")
    void onSave(ClickEvent e) {
        fromUI();
        WorkdayProxy.get().updateOrSaveOperatorParameters(parameter, new AsyncCallback<D_OPERATOR_PARAMETERObj>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            @Override
            public void onSuccess(D_OPERATOR_PARAMETERObj result) {
                MessageEvent ev = new MessageEvent(MessageEvent.SAVE, null);
                fireEvent(ev);
            }
        });
    }

   @UiHandler("btnDelete")
    void onDelete(ClickEvent e) {
        if (parameter!=null && parameter.id != null) {
            WorkdayProxy.get().deleteOperatorParameter(parameter.id, new AsyncCallback<Boolean>() {
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


    public void edit(Integer operatorId, D_OPERATOR_PARAMETERObj para) {

        if (para == null) {
            para = new D_OPERATOR_PARAMETERObj();
            para.operatorId = operatorId;
            para.minValue=0f;
            para.maxValue=100f;
            para.dataType=0;
            para.options="[]";
            para.parameterIndex=0;

        }
        parameter = para;

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
    TextBox txtMAX;

    @UiField
    TextBox txtMIN;


    @UiField
    TextBox txtDEFAULT;


    @UiField
    MetaBox dataType;

    private void toUI() {
        txtCODE.setValue(parameter.code);
        txtDESC.setValue(parameter.description);
        txtNAME.setValue(parameter.name);
        txtBIN.setValue(parameter.parameterIndex + "");
        txtMAX.setValue(parameter.maxValue+"");
        txtMIN.setValue(parameter.minValue+"");
        dataType.setValue(parameter.dataType+"");
        txtDEFAULT.setValue(parameter.defaultValue);
        if(parameter.getId()==null)
        {
            btnDelete.setEnabled(false);
        }
        else
        {
            btnDelete.setEnabled(true);
        }

        editor.edit(parameter.options);


    }

    private void fromUI() {
        parameter.code = txtCODE.getValue();
        parameter.description = txtDESC.getValue();
        parameter.name = txtNAME.getValue();
        parameter.maxValue=Float.parseFloat(txtMAX.getValue());
        parameter.minValue=Float.parseFloat(txtMIN.getValue());
        parameter.parameterIndex = Integer.parseInt(txtBIN.getValue());
        parameter.defaultValue=txtDEFAULT.getValue();
        parameter.setDataType(Integer.parseInt(dataType.getValue()));
    }

}