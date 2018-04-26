package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 数据库表-产品信息
 */
@org.nutz.dao.entity.annotation.Table("d_operator_parameter")
@cn.mapway.document.annotation.Doc("d_operator_parameter 产品信息")
public final class D_OPERATOR_PARAMETERObj
    implements com.google.gwt.user.client.rpc.IsSerializable, com.ksyzt.gwt.client.data.IFieldValue {
  /**
   * 表产品信息代码名称
   */
  public static final String TBL_D_OPERATOR_PARAMETER = "d_operator_parameter";
  public D_OPERATOR_PARAMETERObj() {
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
   * 字段索引 operator_id
   */
  public static final String FLD_OPERATOR_ID = "operator_id";

  /**
   * 字段 operator_id 
   */
  @org.nutz.dao.entity.annotation.Column("operator_id")
  @cn.mapway.document.annotation.ApiField(value = "operator_id", example = "")
  public Integer operatorId;
  /**
   * 字段索引 parameter_index
   */
  public static final String FLD_PARAMETER_INDEX = "parameter_index";

  /**
   * 字段 parameter_index 
   */
  @org.nutz.dao.entity.annotation.Column("parameter_index")
  @cn.mapway.document.annotation.ApiField(value = "parameter_index", example = "")
  public Integer parameterIndex;
  /**
   * 字段索引数据类型0->字符串1->整数2->浮点数 data_type
   */
  public static final String FLD_DATA_TYPE = "data_type";

  /**
   * 字段 data_type 数据类型0->字符串1->整数2->浮点数
   */
  @org.nutz.dao.entity.annotation.Column("data_type")
  @cn.mapway.document.annotation.ApiField(value = "数据类型0-&gt;字符串1-&gt;整数2-&gt;浮点数", example = "")
  public Integer dataType;
  /**
   * 字段索引缺省值 default_value
   */
  public static final String FLD_DEFAULT_VALUE = "default_value";

  /**
   * 字段 default_value 缺省值
   */
  @org.nutz.dao.entity.annotation.Column("default_value")
  @cn.mapway.document.annotation.ApiField(value = "缺省值", example = "")
  public String defaultValue;
  /**
   * 字段索引可选项 options
   */
  public static final String FLD_OPTIONS = "options";

  /**
   * 字段 options 可选项
   */
  @org.nutz.dao.entity.annotation.Column("options")
  @cn.mapway.document.annotation.ApiField(value = "可选项", example = "")
  public String options;
  /**
   * 字段索引最小值 min_value
   */
  public static final String FLD_MIN_VALUE = "min_value";

  /**
   * 字段 min_value 最小值
   */
  @org.nutz.dao.entity.annotation.Column("min_value")
  @cn.mapway.document.annotation.ApiField(value = "最小值", example = "")
  public Float minValue;
  /**
   * 字段索引最大值 max_value
   */
  public static final String FLD_MAX_VALUE = "max_value";

  /**
   * 字段 max_value 最大值
   */
  @org.nutz.dao.entity.annotation.Column("max_value")
  @cn.mapway.document.annotation.ApiField(value = "最大值", example = "")
  public Float maxValue;
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
   * 返回字段operator_id 
   */
  public Integer getOperatorId() {
    return this.operatorId;
  }
  /**
   * 设置字段operator_id 
   */
  public void setOperatorId(Integer operatorId) {
    this.operatorId=operatorId;
  }
  /**
   * 返回字段parameter_index 
   */
  public Integer getParameterIndex() {
    return this.parameterIndex;
  }
  /**
   * 设置字段parameter_index 
   */
  public void setParameterIndex(Integer parameterIndex) {
    this.parameterIndex=parameterIndex;
  }
  /**
   * 返回字段data_type 数据类型0->字符串1->整数2->浮点数
   */
  public Integer getDataType() {
    return this.dataType;
  }
  /**
   * 设置字段data_type 数据类型0->字符串1->整数2->浮点数
   */
  public void setDataType(Integer dataType) {
    this.dataType=dataType;
  }
  /**
   * 返回字段default_value 缺省值
   */
  public String getDefaultValue() {
    return this.defaultValue;
  }
  /**
   * 设置字段default_value 缺省值
   */
  public void setDefaultValue(String defaultValue) {
    this.defaultValue=defaultValue;
  }
  /**
   * 返回字段options 可选项
   */
  public String getOptions() {
    return this.options;
  }
  /**
   * 设置字段options 可选项
   */
  public void setOptions(String options) {
    this.options=options;
  }
  /**
   * 返回字段min_value 最小值
   */
  public Float getMinValue() {
    return this.minValue;
  }
  /**
   * 设置字段min_value 最小值
   */
  public void setMinValue(Float minValue) {
    this.minValue=minValue;
  }
  /**
   * 返回字段max_value 最大值
   */
  public Float getMaxValue() {
    return this.maxValue;
  }
  /**
   * 设置字段max_value 最大值
   */
  public void setMaxValue(Float maxValue) {
    this.maxValue=maxValue;
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
   * 获取字operator_id索引
   */
  public static final Integer IDX_OPERATOR_ID = 4;
  /**
   * 获取字parameter_index索引
   */
  public static final Integer IDX_PARAMETER_INDEX = 5;
  /**
   * 获取字data_type索引
   */
  public static final Integer IDX_DATA_TYPE = 6;
  /**
   * 获取字default_value索引
   */
  public static final Integer IDX_DEFAULT_VALUE = 7;
  /**
   * 获取字options索引
   */
  public static final Integer IDX_OPTIONS = 8;
  /**
   * 获取字min_value索引
   */
  public static final Integer IDX_MIN_VALUE = 9;
  /**
   * 获取字max_value索引
   */
  public static final Integer IDX_MAX_VALUE = 10;
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
      if (FLD_OPERATOR_ID.equals(fieldName)) {
        return this.operatorId;
      }
      if (FLD_PARAMETER_INDEX.equals(fieldName)) {
        return this.parameterIndex;
      }
      if (FLD_DATA_TYPE.equals(fieldName)) {
        return this.dataType;
      }
      if (FLD_DEFAULT_VALUE.equals(fieldName)) {
        return this.defaultValue;
      }
      if (FLD_OPTIONS.equals(fieldName)) {
        return this.options;
      }
      if (FLD_MIN_VALUE.equals(fieldName)) {
        return this.minValue;
      }
      if (FLD_MAX_VALUE.equals(fieldName)) {
        return this.maxValue;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 11) {
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
        return this.operatorId;
      }
      if (fieldIndex == 5) {
        return this.parameterIndex;
      }
      if (fieldIndex == 6) {
        return this.dataType;
      }
      if (fieldIndex == 7) {
        return this.defaultValue;
      }
      if (fieldIndex == 8) {
        return this.options;
      }
      if (fieldIndex == 9) {
        return this.minValue;
      }
      if (fieldIndex == 10) {
        return this.maxValue;
      }
    } else {
      return null;
    }
    return null;
  }
}
