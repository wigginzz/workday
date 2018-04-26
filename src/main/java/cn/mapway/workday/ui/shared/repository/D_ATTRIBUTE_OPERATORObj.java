package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 数据库表-产品信息
 */
@org.nutz.dao.entity.annotation.Table("d_attribute_operator")
@cn.mapway.document.annotation.Doc("d_attribute_operator 产品信息")
public final class D_ATTRIBUTE_OPERATORObj
    implements com.google.gwt.user.client.rpc.IsSerializable, com.ksyzt.gwt.client.data.IFieldValue {
  /**
   * 表产品信息代码名称
   */
  public static final String TBL_D_ATTRIBUTE_OPERATOR = "d_attribute_operator";
  public D_ATTRIBUTE_OPERATORObj() {
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
   * 字段索引属性ID attribute_id
   */
  public static final String FLD_ATTRIBUTE_ID = "attribute_id";

  /**
   * 字段 attribute_id 属性ID
   */
  @org.nutz.dao.entity.annotation.Column("attribute_id")
  @cn.mapway.document.annotation.ApiField(value = "属性ID", example = "")
  public Integer attributeId;
  /**
   * 字段索引索引序列 operator_index
   */
  public static final String FLD_OPERATOR_INDEX = "operator_index";

  /**
   * 字段 operator_index 索引序列
   */
  @org.nutz.dao.entity.annotation.Column("operator_index")
  @cn.mapway.document.annotation.ApiField(value = "索引序列", example = "")
  public Integer operatorIndex;
  /**
   * 字段索引操作0事件1 type
   */
  public static final String FLD_TYPE = "type";

  /**
   * 字段 type 操作0事件1
   */
  @org.nutz.dao.entity.annotation.Column("type")
  @cn.mapway.document.annotation.ApiField(value = "操作0事件1", example = "")
  public Integer type;
  /**
   * 字段索引命令的方向0下发命令1命令响应 direction
   */
  public static final String FLD_DIRECTION = "direction";

  /**
   * 字段 direction 命令的方向0下发命令1命令响应
   */
  @org.nutz.dao.entity.annotation.Column("direction")
  @cn.mapway.document.annotation.ApiField(value = "命令的方向0下发命令1命令响应", example = "")
  public Integer direction;
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
   * 返回字段attribute_id 属性ID
   */
  public Integer getAttributeId() {
    return this.attributeId;
  }
  /**
   * 设置字段attribute_id 属性ID
   */
  public void setAttributeId(Integer attributeId) {
    this.attributeId=attributeId;
  }
  /**
   * 返回字段operator_index 索引序列
   */
  public Integer getOperatorIndex() {
    return this.operatorIndex;
  }
  /**
   * 设置字段operator_index 索引序列
   */
  public void setOperatorIndex(Integer operatorIndex) {
    this.operatorIndex=operatorIndex;
  }
  /**
   * 返回字段type 操作0事件1
   */
  public Integer getType() {
    return this.type;
  }
  /**
   * 设置字段type 操作0事件1
   */
  public void setType(Integer type) {
    this.type=type;
  }
  /**
   * 返回字段direction 命令的方向0下发命令1命令响应
   */
  public Integer getDirection() {
    return this.direction;
  }
  /**
   * 设置字段direction 命令的方向0下发命令1命令响应
   */
  public void setDirection(Integer direction) {
    this.direction=direction;
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
   * 获取字attribute_id索引
   */
  public static final Integer IDX_ATTRIBUTE_ID = 4;
  /**
   * 获取字operator_index索引
   */
  public static final Integer IDX_OPERATOR_INDEX = 5;
  /**
   * 获取字type索引
   */
  public static final Integer IDX_TYPE = 6;
  /**
   * 获取字direction索引
   */
  public static final Integer IDX_DIRECTION = 7;
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
      if (FLD_ATTRIBUTE_ID.equals(fieldName)) {
        return this.attributeId;
      }
      if (FLD_OPERATOR_INDEX.equals(fieldName)) {
        return this.operatorIndex;
      }
      if (FLD_TYPE.equals(fieldName)) {
        return this.type;
      }
      if (FLD_DIRECTION.equals(fieldName)) {
        return this.direction;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 8) {
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
        return this.attributeId;
      }
      if (fieldIndex == 5) {
        return this.operatorIndex;
      }
      if (fieldIndex == 6) {
        return this.type;
      }
      if (fieldIndex == 7) {
        return this.direction;
      }
    } else {
      return null;
    }
    return null;
  }
}
