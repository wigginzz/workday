package cn.mapway.workday.ui.shared.module;

import cn.mapway.document.annotation.ApiField;
import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.ArrayList;
import java.util.List;

public class ZiroomMessage implements IsSerializable {

    public static ZiroomMessage deviceReportMessage(String channelid, String mac) {
        ZiroomMessage msg = new ZiroomMessage();
        msg.type = "DEVICE_INFO_REPORT";
        msg.did = mac;
        msg.attribute = channelid;
        return msg;
    }

    public static ZiroomMessage deviceMetaMessage( int product, int model) {
        ZiroomMessage msg = new ZiroomMessage();
        msg.type = "DEVICE_META";
        msg.model = String.valueOf(model);
        msg.command = String.valueOf(product);
        return msg;
    }

    public static ZiroomMessage deviceConnectMessage(String channelid, String ip) {
        ZiroomMessage msg = new ZiroomMessage();
        msg.type = "DEVICE_CONNECT";
        msg.did = ip;
        msg.attribute = channelid;
        return msg;
    }

    public static ZiroomMessage deviceDisconnectMessage(String chanelId) {
        ZiroomMessage msg = new ZiroomMessage();
        msg.type = "DEVICE_DISCONNECT";
        msg.attribute = chanelId;
        return msg;
    }
    public static ZiroomMessage deviceUnknownMessage(String data) {
        ZiroomMessage msg = new ZiroomMessage();
        msg.type = "DEVICE_UNKNOWNdfsdsf";
        msg.command=data;
        return msg;
    }

    public static ZiroomMessage deviceQueryMessage() {
        ZiroomMessage msg = new ZiroomMessage();
        msg.type = "DEVICE_INFO_QUERY";
        return msg;
    }

    public ZiroomMessage() {
        data = new ArrayList<>();
    }

    @ApiField(value = "消息类型 " +
            "DEVICE_NOTIFY:设备通知 ", example = "DEVICE_NOTIFY")
    public String type;

    @ApiField(value = "设备MAC", example = "DC330DFF4C3B")
    public String did;

    @ApiField(value = "产品型号", example = "海尔洗衣机M11")
    public String model;

    @ApiField(value = "时间", example = "2018-05-14 10:10:10")
    public String time;

    @ApiField(value = "消息体唯一标识", example = "123")
    public String sno;

    @ApiField(value = "属性", example = "light-colour")
    public String attribute;

    @ApiField(value = "命令动作", example = "set-colour")
    public String command;

    @ApiField(value = "具体属性值")
    public List<DataValue> data;


    public String toJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("{")
                .append("\"type\":\"").append(type).append("\",")
                .append("\"did\":\"").append(did).append("\",")
                .append("\"model\":\"").append(model).append("\",")
                .append("\"time\":\"").append(time).append("\",")
                .append("\"sno\":\"").append(sno).append("\",")
                .append("\"attribute\":\"").append(attribute).append("\",")
                .append("\"command\":\"").append(command).append("\",")
                .append("\"data\":[");
        for (int i = 0; i < data.size(); i++) {
            DataValue d = data.get(i);
            sb.append("{\"k\":").append(d.k).append("\",");
            sb.append("\"v\":").append(d.v).append("\"}");
        }
        sb.append("]")
                .append("}");
        return sb.toString();
    }
}
