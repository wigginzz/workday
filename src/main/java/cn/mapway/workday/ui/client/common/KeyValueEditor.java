package cn.mapway.workday.ui.client.common;

import cn.mapway.ui.client.widget.common.IconItem;
import cn.mapway.ui.client.widget.common.PrimaryButton;
import cn.mapway.workday.ui.shared.module.KeyValue;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.LocalizableResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.ksyzt.gwt.client.common.MessageComposite;
import com.ksyzt.gwt.client.event.MessageEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * key value pair 编辑器
 */
public class KeyValueEditor extends MessageComposite {
    interface KeyValueEditorUiBinder extends UiBinder<HTMLPanel, KeyValueEditor> {
    }

    private static KeyValueEditorUiBinder ourUiBinder = GWT.create(KeyValueEditorUiBinder.class);

    public KeyValueEditor() {
        initWidget(ourUiBinder.createAndBindUi(this));
        edit(null);
    }

    @UiField
    PrimaryButton btnSave;

    @UiField
    TextBox txtKEY;
    @UiField
    TextBox txtValue;

    @UiField
    FlexTable tbl;

    JsArray<KeyValue> mData;

    public void edit(String data) {
        if (data == null || data.length()==0) {
            mData=KeyValue.createArray();
        }
        else {
            mData = JsonUtils.safeEval(data);
        }

        renderData();
    }

    ClickHandler deleteItemHandler = new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
            IconItem item = (IconItem) event
                    .getSource();
            KeyValue kv = (KeyValue) item.getData();
            mData.unshift(kv);
            renderData();

            MessageEvent ev=new MessageEvent(MessageEvent.SAVE,toJSON());
            fireEvent(ev);
        }
    };


    private void renderData() {
        tbl.removeAllRows();

        int row = 0;
        for (int i=0;i<mData.length();i++) {
            KeyValue kv=mData.get(i);
            IconItem delete = new IconItem();
            delete.setText("删除");
            delete.setData(kv);
            delete.addClickHandler(deleteItemHandler);
            tbl.setText(row, 0, kv.getKey());
            tbl.setText(row, 1, kv.getValue());
            tbl.setWidget(row, 2, delete);
            row++;
        }
    }

    @UiHandler("btnSave")
    void onSave(ClickEvent e) {
        if (txtKEY.getValue().length() > 0 && txtValue.getValue().length() > 0) {
            KeyValue kv=KeyValue.create(txtKEY.getValue(),txtValue.getValue());
            mData.push(kv);
        }
        renderData();

        MessageEvent ev=new MessageEvent(MessageEvent.SAVE,toJSON());
        fireEvent(ev);
    }


    public String toJSON()
    {
        return JsonUtils.stringify(mData);
    }
}