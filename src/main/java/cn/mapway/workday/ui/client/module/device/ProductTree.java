package cn.mapway.workday.ui.client.module.device;

import cn.ennwifi.webframe.ui.client.common.LocalTree;
import cn.mapway.ui.client.widget.common.IconItem;
import cn.mapway.workday.ui.client.resource.WorkdayResource;
import cn.mapway.workday.ui.client.rpc.WorkdayProxy;
import cn.mapway.workday.ui.shared.module.ProductInfo;
import cn.mapway.workday.ui.shared.repository.*;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.TreeItem;

import java.util.List;

public class ProductTree extends LocalTree implements OpenHandler<TreeItem>, CloseHandler<TreeItem> {

    public ProductTree() {
        this.addOpenHandler(this);
        this.addCloseHandler(this);
    }

    public void load() {
        this.clear();
        TreeItem item =new TreeItem();
        item.setText("加载中....");
        this.addItem(item);
        WorkdayProxy.get().products(new AsyncCallback<ProductInfo>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            @Override
            public void onSuccess(ProductInfo result) {
                renderTree(result);
            }
        });
    }

    ProductInfo mData;

    private void renderTree(ProductInfo result) {

        this.clear();
        mData = result;

        List<D_PRODUCT_INFOObj> products = mData.getAllProducts();

        int index=1;
        for (D_PRODUCT_INFOObj p : products) {
            renderProduct(index++,p);
        }
    }

    private TreeItem renderProduct(int index,D_PRODUCT_INFOObj p) {
        TreeItem item = new TreeItem();
        IconItem ri = new IconItem();
        ri.setIcon(WorkdayResource.get().device(),16,16);
        ri.setText(index+"."+ p.name + "[" + p.code + "]");
        item.setWidget(ri);
        item.setUserObject(p);
        this.addItem(item);

        for(D_PRODUCT_ATTRIBUTEObj a:mData.getProductAttribute(p.id))
        {
            renderAttribute(item,a);
        }
        item.setState(isOpen("p_" + p.getId()));
        return item;
    }

    private void renderAttribute(TreeItem itemParent, D_PRODUCT_ATTRIBUTEObj a) {
        TreeItem item = new TreeItem();
        IconItem ri = new IconItem();
        ri.setIcon(WorkdayResource.get().attribute(),16,16);
        ri.setText(a.attributeIndex+"."+a.name + "[" + a.code + "]");
        item.setWidget(ri);
        item.setUserObject(a);

        itemParent.addItem(item);

        for(D_ATTRIBUTE_OPERATORObj op:mData.getAttributeOperator(a.id, 0))
        {
            renderOpearator(item,op);
        }
        for(D_ATTRIBUTE_OPERATORObj op:mData.getAttributeOperator(a.id, 1))
        {
            renderOpearator(item,op);
        }

        item.setState(isOpen("a_" + a.getId()));
    }



    private void renderOpearator(TreeItem itemParent, D_ATTRIBUTE_OPERATORObj op) {
        TreeItem item = new TreeItem();
        IconItem ri = new IconItem();
        if(op.type==0) {
            ri.setIcon(WorkdayResource.get().method(), 16, 16);
        }
        else
        {
            ri.setIcon(WorkdayResource.get().event(), 16, 16);
        }
        ri.setText(op.operatorIndex+"."+op.name + "[" + op.code + "]");
        item.setWidget(ri);
        item.setUserObject(op);
        itemParent.addItem(item);
        for(D_OPERATOR_PARAMETERObj p:mData.getOperatorParameters(op.id))
        {
            renderParameter(item,p);
        }
        item.setState(isOpen("op_" + op.getId()));

    }

    private void renderParameter(TreeItem itemParent, D_OPERATOR_PARAMETERObj p) {
        TreeItem item = new TreeItem();
        IconItem ri = new IconItem();
        ri.setIcon(WorkdayResource.get().parameter(),16,16);
        ri.setText(p.parameterIndex+"."+ p.name + "[" + p.code + "]");
        item.setWidget(ri);
        item.setUserObject(p);
        item.setState(isOpen("pa_" + p.getId()));
        itemParent.addItem(item);

    }


    @Override
    public void onOpen(OpenEvent<TreeItem> event) {
        Object userObject = event.getTarget().getUserObject();
        recordOpenCloseInformation(userObject, true);
    }

    @Override
    public void onClose(CloseEvent<TreeItem> event) {
        Object userObject = event.getTarget().getUserObject();
        recordOpenCloseInformation(userObject, false);
    }

    private void recordOpenCloseInformation(Object userObject, boolean openOrClose) {
        if (userObject != null) {
            if (userObject instanceof D_PRODUCT_INFOObj) {
                D_PRODUCT_INFOObj p = (D_PRODUCT_INFOObj) userObject;
                setOpen("p_" + p.getId(), openOrClose);
            } else if (userObject instanceof D_PRODUCT_ATTRIBUTEObj) {
                D_PRODUCT_ATTRIBUTEObj p = (D_PRODUCT_ATTRIBUTEObj) userObject;
                setOpen("a_" + p.getId(), openOrClose);
            } else if (userObject instanceof D_ATTRIBUTE_OPERATORObj) {
                D_ATTRIBUTE_OPERATORObj p = (D_ATTRIBUTE_OPERATORObj) userObject;
                setOpen("op_" + p.getId(), openOrClose);
            }
            else if (userObject instanceof D_OPERATOR_PARAMETERObj) {
                D_OPERATOR_PARAMETERObj p = (D_OPERATOR_PARAMETERObj) userObject;
                setOpen("pa_" + p.getId(), openOrClose);
            }
        }
    }
}
