package cn.mapway.workday.ui.client.rpc;

import cn.ennwifi.webframe.ui.shared.module.ServerException;
import cn.mapway.workday.ui.server.WorkdayServlet;
import cn.mapway.workday.ui.shared.module.ProductInfo;
import cn.mapway.workday.ui.shared.repository.*;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath(WorkdayServlet.DEFAULT_SERVER_PATH)
public interface IWorkdayServer extends RemoteService {


    ProductInfo  products() throws ServerException;

    List<D_PRODUCT_INFOObj>  getProducts() throws ServerException;
    boolean deleteProduct(Integer id) throws ServerException;
    D_PRODUCT_INFOObj updateOrSaveProduct(D_PRODUCT_INFOObj product) throws ServerException;

    List<D_PRODUCT_ATTRIBUTEObj>  getProductAttributes(Integer productId) throws ServerException;
    boolean deleteProductAttribute(Integer attributeId) throws ServerException;
    D_PRODUCT_ATTRIBUTEObj updateOrSaveProductAttribute(D_PRODUCT_ATTRIBUTEObj productAttribute) throws ServerException;


    List<D_ATTRIBUTE_OPERATORObj>  getAttributeOperators(Integer attributeId) throws ServerException;
    boolean deleteAttributeOperator(Integer operatorId) throws ServerException;
    D_ATTRIBUTE_OPERATORObj updateOrSaveAttributeOperator(D_ATTRIBUTE_OPERATORObj attributeOperatorObj) throws ServerException;


    List<D_OPERATOR_PARAMETERObj>  getOperatorParameters(Integer operatorId) throws ServerException;
    boolean deleteOperatorParameter(Integer parameterId) throws ServerException;
    D_OPERATOR_PARAMETERObj updateOrSaveOperatorParameters(D_OPERATOR_PARAMETERObj operatorParameterObj) throws ServerException;

}
