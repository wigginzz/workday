package cn.mapway.workday.ui.client.rpc;

import cn.mapway.workday.ui.shared.module.ProductInfo;
import cn.mapway.workday.ui.shared.repository.*;
import com.google.gwt.user.client.rpc.AsyncCallback;


import java.util.List;

public interface IWorkdayServerAsync {


    void getProducts(AsyncCallback<List<D_PRODUCT_INFOObj>> async);

    void deleteProduct(Integer id, AsyncCallback<Boolean> async);

    void updateOrSaveProduct(D_PRODUCT_INFOObj product, AsyncCallback<D_PRODUCT_INFOObj> async);

    void deleteProductAttribute(Integer attributeId, AsyncCallback<Boolean> async);

    void updateOrSaveProductAttribute(D_PRODUCT_ATTRIBUTEObj productAttribute, AsyncCallback<D_PRODUCT_ATTRIBUTEObj> async);

    void deleteAttributeOperator(Integer operatorId, AsyncCallback<Boolean> async);

    void updateOrSaveAttributeOperator(D_ATTRIBUTE_OPERATORObj attributeOperatorObj, AsyncCallback<D_ATTRIBUTE_OPERATORObj> async);

    void getAttributeOperators(Integer attributeId, AsyncCallback<List<D_ATTRIBUTE_OPERATORObj>> async);

    void getOperatorParameters(Integer operatorId, AsyncCallback<List<D_OPERATOR_PARAMETERObj>> async);

    void deleteOperatorParameter(Integer parameterId, AsyncCallback<Boolean> async);

    void updateOrSaveOperatorParameters(D_OPERATOR_PARAMETERObj operatorParameterObj, AsyncCallback<D_OPERATOR_PARAMETERObj> async);

    void getProductAttributes(Integer productId, AsyncCallback<List<D_PRODUCT_ATTRIBUTEObj>> async);

    void products(AsyncCallback<ProductInfo> async);
}
