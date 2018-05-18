package cn.mapway.workday.ui.client.module.test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;

public class LogItem extends Composite {
    interface LogItemUiBinder extends UiBinder<HTMLPanel, LogItem> {
    }

    private static LogItemUiBinder ourUiBinder = GWT.create(LogItemUiBinder.class);

    public LogItem() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    public void setData(String channelId, String type,String d) {
        lbChannel.setText(channelId);
        data.setHTML(d);
        lbTYPE.setText(type);
    }

    @UiField
    HTML data;
    @UiField
    Label lbChannel;
    @UiField
    Label lbTYPE;

}