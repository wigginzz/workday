package cn.mapway.workday.ui.shared.module;

import cn.mapway.workday.api.module.KV;
import org.nutz.json.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * 自如通讯协议
 */
public class ZiroomCommand {

    // type DEVICE_CONTROL  DEVICE_CONTROL_RESP
    public String type;
     //控制序列值
     public String sno;

     //设备编号
     public String did;
    //命令
    public  String command;

    //属性
    public String attribute;

    //参数列表
    public List<KV> data;

    public ZiroomCommand()
    {
        data =new ArrayList<>();
    }

    public static ZiroomCommand controlCommand()
    {
        ZiroomCommand cmd=new ZiroomCommand();
        cmd.type="DEVICE_CONTROLLER";
        return cmd;
    }

    public static ZiroomCommand controlResponseCommand()
    {
        ZiroomCommand cmd=new ZiroomCommand();
        cmd.type="DEVICE_CONTROL_RESP";
        return cmd;
    }

    public static ZiroomCommand notifyCommand() {
        ZiroomCommand cmd=new ZiroomCommand();
        cmd.type="DEVICE_NOTIFY";
        return cmd;
    }

    /**
     * 命令
     * @param command
     * @return
     */
    public ZiroomCommand command(String command)
    {
        this.command=command;
        return this;
    }

    /**
     * 命令
     * @param command
     * @return
     */
    public ZiroomCommand attribute(String attribute)
    {
        this.attribute=attribute;
        return this;
    }


    /**
     * 命令
     * @param did
     * @return
     */
    public ZiroomCommand did(String did)
    {
        this.did=did;
        return this;
    }

    /**
     * 命令
     * @param command
     * @return
     */
    public ZiroomCommand sno(String sno)
    {
        this.sno=sno;
        return this;
    }
    /**
     * 命令
     * @param command
     * @return
     */
    public ZiroomCommand addParameter(String k,String v)
    {
        KV kv=new KV();
        kv.k=k;
        kv.v=v;
        this.data.add(kv);
        return this;
    }

    public String toJSON()
    {
        return Json.toJson(this);
    }

    public String toBinary()
    {
        return "";
    }
}
