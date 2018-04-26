package cn.mapway.workday.ui.shared.module;

import cn.mapway.workday.ui.shared.repository.*;
import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品信息
 */
public class ProductInfo implements IsSerializable {
    public List<D_PRODUCT_INFOObj> products;
    public List<D_PRODUCT_ATTRIBUTEObj> attributes;
    public List<D_ATTRIBUTE_OPERATORObj> operators;
    public List<D_OPERATOR_PARAMETERObj> parameters;


    /**
     * @return
     */
    public List<D_PRODUCT_INFOObj> getAllProducts() {
        return products;
    }

    /**
     * @param productId
     * @return
     */
    public List<D_PRODUCT_ATTRIBUTEObj> getProductAttribute(Integer productId) {
        List<D_PRODUCT_ATTRIBUTEObj> r = new ArrayList<>();
        for (D_PRODUCT_ATTRIBUTEObj a : attributes) {
            if (a.productId.equals(productId)) {
                r.add(a);
            }
        }
        return r;
    }

    /**
     * @param attributeId
     * @param id
     * @return
     */
    public List<D_ATTRIBUTE_OPERATORObj> getAllOperator( Integer productId,Integer type) {
        List<D_ATTRIBUTE_OPERATORObj> r=new ArrayList<>();
            List<D_PRODUCT_ATTRIBUTEObj> ats=getProductAttribute(productId);
            for(D_PRODUCT_ATTRIBUTEObj a:ats)
            {
                List<D_ATTRIBUTE_OPERATORObj> os=getAttributeOperator(a.id,type);
                r.addAll(os);
            }
        return r;
    }

    /**
     *
     * @param attributeId
     * @return
     */
    public D_PRODUCT_ATTRIBUTEObj findAttribute(Integer attributeId)
    {
        for(D_PRODUCT_ATTRIBUTEObj a:attributes)
        {
            if(a.id.equals(attributeId))
            {
                return a;
            }
        }
        return null;
    }

    /**
     * @param attributeId
     * @param type
     * @return
     */
    public List<D_ATTRIBUTE_OPERATORObj> getAttributeOperator(Integer attributeId, Integer type) {
        List<D_ATTRIBUTE_OPERATORObj> r = new ArrayList<>();
        for (D_ATTRIBUTE_OPERATORObj a : operators) {
            if (a.attributeId.equals(attributeId) && a.type.equals(type)) {
                r.add(a);
            }
        }
        return r;
    }

    public List<D_OPERATOR_PARAMETERObj> getOperatorParameters(Integer operatorId) {
        List<D_OPERATOR_PARAMETERObj> r = new ArrayList<>();
        for (D_OPERATOR_PARAMETERObj a : parameters) {
            if (a.operatorId.equals(operatorId)) {
                r.add(a);
            }
        }
        return r;
    }


}
