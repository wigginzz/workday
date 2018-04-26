package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 数据库表-产品信息
 */
@org.nutz.dao.entity.annotation.Table("d_product_info")
@cn.mapway.document.annotation.Doc("d_product_info 产品信息")
public final class D_PRODUCT_INFOObj
    implements com.google.gwt.user.client.rpc.IsSerializable, com.ksyzt.gwt.client.data.IFieldValue {
  /**
   * 表产品信息代码名称
   */
  public static final String TBL_D_PRODUCT_INFO = "d_product_info";
  public D_PRODUCT_INFOObj() {
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
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 4) {
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
    } else {
      return null;
    }
    return null;
  }
}
