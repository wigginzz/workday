package cn.mapway.workday.ui.server;

import cn.ennwifi.webframe.ui.shared.module.ServerException;
import cn.mapway.workday.service.WorkdayService;
import cn.mapway.workday.tools.Springs;
import cn.mapway.workday.ui.client.rpc.IWorkdayServer;
import cn.mapway.workday.ui.shared.module.ProductInfo;
import cn.mapway.workday.ui.shared.repository.*;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import jdk.nashorn.internal.runtime.WithObject;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;

import java.util.List;

public class WorkdayServlet extends RemoteServiceServlet implements IWorkdayServer {

    public final static  String DEFAULT_SERVER_PATH = "/workdayServer";

    Dao dao;

    WorkdayService workdayService;
    private synchronized WorkdayService getWorkdayService(){
        if(workdayService==null)
        {
            workdayService=Springs.get(WorkdayService.class);
        }
        return workdayService;
    }
    private synchronized  Dao getDao()
    {
        if(dao==null)
        {
            dao= Springs.getDao();
        }
        return dao;
    }


    @Override
    public ProductInfo products() throws ServerException {
        return getWorkdayService().products();
    }

    @Override
    public List<D_PRODUCT_INFOObj> getProducts() throws ServerException {
        return getDao().query(D_PRODUCT_INFOObj.class, Cnd.orderBy().asc(D_PRODUCT_INFOObj.FLD_ID));
    }

    @Override
    public boolean deleteProduct(Integer id) throws ServerException {
        int count=getDao().count(D_PRODUCT_ATTRIBUTEObj.class,Cnd.where(D_PRODUCT_ATTRIBUTEObj.FLD_PRODUCT_ID,"=",id));
        if(count>0)
        {
            throw  new ServerException("该产品下有属性信息，不能删除");
        }
        getDao().delete(D_PRODUCT_INFOObj.class,id);
        return true;
    }

    @Override
    public D_PRODUCT_INFOObj updateOrSaveProduct(D_PRODUCT_INFOObj product) throws ServerException {

        if(product.getId()==null)
        {
            getDao().insert(product);
        }
        else
        {
            getDao().updateIgnoreNull(product);
        }

        return product;
    }

    @Override
    public List<D_PRODUCT_ATTRIBUTEObj> getProductAttributes(Integer productId) throws ServerException {
        return getDao().query(D_PRODUCT_ATTRIBUTEObj.class,Cnd.where(D_PRODUCT_ATTRIBUTEObj.FLD_PRODUCT_ID,"=",productId));
    }

    @Override
    public boolean deleteProductAttribute(Integer attributeId) throws ServerException {
        int count=getDao().count(D_ATTRIBUTE_OPERATORObj.class,Cnd.where(D_ATTRIBUTE_OPERATORObj.FLD_ATTRIBUTE_ID,"=",attributeId));
        if(count>0)
        {
            throw  new ServerException("该产品下有操作信息，不能删除");
        }

        getDao().delete(D_PRODUCT_ATTRIBUTEObj.class,attributeId);
        return true;
    }

    @Override
    public D_PRODUCT_ATTRIBUTEObj updateOrSaveProductAttribute(D_PRODUCT_ATTRIBUTEObj productAttribute) throws ServerException {

        if(productAttribute.getId()==null)
        {
            getDao().insert(productAttribute);
        }
        else
        {
            getDao().updateIgnoreNull(productAttribute);
        }

        return productAttribute;
    }



    @Override
    public List<D_ATTRIBUTE_OPERATORObj> getAttributeOperators(Integer attributeId) throws ServerException {
        return getDao().query(D_ATTRIBUTE_OPERATORObj.class,Cnd.where(D_ATTRIBUTE_OPERATORObj.FLD_ATTRIBUTE_ID,"=",attributeId));
    }

    @Override
    public boolean deleteAttributeOperator(Integer operatorId) throws ServerException {
        getDao().delete(D_ATTRIBUTE_OPERATORObj.class,operatorId);
        return true;
    }

    @Override
    public D_ATTRIBUTE_OPERATORObj updateOrSaveAttributeOperator(D_ATTRIBUTE_OPERATORObj attributeOperatorObj) throws ServerException {
        if(attributeOperatorObj.getId()==null)
        {
            getDao().insert(attributeOperatorObj);
        }
        else
        {
            getDao().updateIgnoreNull(attributeOperatorObj);
        }

        return attributeOperatorObj;
    }

    @Override
    public List<D_OPERATOR_PARAMETERObj> getOperatorParameters(Integer operatorId) throws ServerException {
        return getDao().query(D_OPERATOR_PARAMETERObj.class,Cnd.where(D_OPERATOR_PARAMETERObj.FLD_OPERATOR_ID,"=",operatorId));
    }

    @Override
    public boolean deleteOperatorParameter(Integer parameterId) throws ServerException {
        getDao().delete(D_OPERATOR_PARAMETERObj.class,parameterId);
        return true;
    }

    @Override
    public D_OPERATOR_PARAMETERObj updateOrSaveOperatorParameters(D_OPERATOR_PARAMETERObj operatorParameterObj) throws ServerException {
        if(operatorParameterObj.getId()==null)
        {
            getDao().insert(operatorParameterObj);
        }
        else
        {
            getDao().updateIgnoreNull(operatorParameterObj);
        }

        return operatorParameterObj;
    }

}
