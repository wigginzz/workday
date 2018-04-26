package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 数据库表-产品属性信息
 */
@org.nutz.dao.entity.annotation.Table("d_product_attribute")
@cn.mapway.document.annotation.Doc("d_product_attribute 产品属性信息")
public final class D_PRODUCT_ATTRIBUTEObj
    implements com.google.gwt.user.client.rpc.IsSerializable, com.ksyzt.gwt.client.data.IFieldValue {
  /**
   * 表产品属性信息代码名称
   */
  public static final String TBL_D_PRODUCT_ATTRIBUTE = "d_product_attribute";
  public D_PRODUCT_ATTRIBUTEObj() {
  }
  /**
   * 字段索引 id
   */
  public static final String FLD_ID = "id";

  /**
   * 字段 id 
   */
  @org.nutz.dao.entity.annotation.Id
  @cn.mapway.document.annotation.ApiField(value = "id", example = "")
  public Integer id;
  /**
   * 字段索引 name
   */
  public static final String FLD_NAME = "name";

  /**
   * 字段 name 
   */
  @org.nutz.dao.entity.annotation.Column("name")
  @cn.mapway.document.annotation.ApiField(value = "name", example = "")
  public String name;
  /**
   * 字段索引 code
   */
  public static final String FLD_CODE = "code";

  /**
   * 字段 code 
   */
  @org.nutz.dao.entity.annotation.Column("code")
  @cn.mapway.document.annotation.ApiField(value = "code", example = "")
  public String code;
  /**
   * 字段索引 description
   */
  public static final String FLD_DESCRIPTION = "description";

  /**
   * 字段 description 
   */
  @org.nutz.dao.entity.annotation.Column("description")
  @cn.mapway.document.annotation.ApiField(value = "description", example = "")
  public String description;
  /**
   * 字段索引product_id product_id
   */
  public static final String FLD_PRODUCT_ID = "product_id";

  /**
   * 字段 product_id product_id
   */
  @org.nutz.dao.entity.annotation.Column("product_id")
  @cn.mapway.document.annotation.ApiField(value = "product_id", example = "")
  public Integer productId;
  /**
   * 返回字段id 
   */
  public Integer getId() {
    return this.id;
  }
  /**
   * 设置字段id 
   */
  public void setId(Integer id) {
    this.id=id;
  }
  /**
   * 返回字段name 
   */
  public String getName() {
    return this.name;
  }
  /**
   * 设置字段name 
   */
  public void setName(String name) {
    this.name=name;
  }
  /**
   * 返回字段code 
   */
  public String getCode() {
    return this.code;
  }
  /**
   * 设置字段code 
   */
  public void setCode(String code) {
    this.code=code;
  }
  /**
   * 返回字段description 
   */
  public String getDescription() {
    return this.description;
  }
  /**
   * 设置字段description 
   */
  public void setDescription(String description) {
    this.description=description;
  }
  /**
   * 返回字段product_id product_id
   */
  public Integer getProductId() {
    return this.productId;
  }
  /**
   * 设置字段product_id product_id
   */
  public void setProductId(Integer productId) {
    this.productId=productId;
  }
  /**
   * 获取字id索引
   */
  public static final Integer IDX_ID = 0;
  /**
   * 获取字name索引
   */
  public static final Integer IDX_NAME = 1;
  /**
   * 获取字code索引
   */
  public static final Integer IDX_CODE = 2;
  /**
   * 获取字description索引
   */
  public static final Integer IDX_DESCRIPTION = 3;
  /**
   * 获取字product_id索引
   */
  public static final Integer IDX_PRODUCT_ID = 4;
  /**
   * 根据字段名称获取字段的.
   */
  @Override
  public Object getFieldValue(String fieldName, Integer fieldIndex) {
    if (fieldName != null && fieldName.length() > 0) {
      if (FLD_ID.equals(fieldName)) {
        return this.id;
      }
      if (FLD_NAME.equals(fieldName)) {
        return this.name;
      }
      if (FLD_CODE.equals(fieldName)) {
        return this.code;
      }
      if (FLD_DESCRIPTION.equals(fieldName)) {
        return this.description;
      }
      if (FLD_PRODUCT_ID.equals(fieldName)) {
        return this.productId;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 5) {
      if (fieldIndex == 0) {
        return this.id;
      }
      if (fieldIndex == 1) {
        return this.name;
      }
      if (fieldIndex == 2) {
        return this.code;
      }
      if (fieldIndex == 3) {
        return this.description;
      }
      if (fieldIndex == 4) {
        return this.productId;
      }
    } else {
      return null;
    }
    return null;
  }
}
