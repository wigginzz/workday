package cn.mapway.workday.ui.shared.module;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class KeyValue extends JavaScriptObject {
    protected KeyValue() {

    }


    public final native static JsArray<KeyValue> createArray()/*-{
        return "[]";
    }-*/;

    public final native static KeyValue create(String k, String v)/*-{
        return {"k": k, "v": v}
    }-*/;

    public final native static KeyValue create()/*-{
        return {"k": "", "v": ""}
    }-*/;

    public final native void setKey(String key)/*-{
        this.k=key;
    }-*/;

    public final native String getKey()/*-{
        return this.k;
    }-*/;


    public final native void setValue(String value)/*-{
        this.v=value ;
    }-*/;

    public final native String getValue()/*-{
        return this.v;
    }-*/;
}
