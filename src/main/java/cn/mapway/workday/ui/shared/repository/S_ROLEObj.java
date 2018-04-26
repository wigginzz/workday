package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 数据库表-角色表
 */
@org.nutz.dao.entity.annotation.Table("s_role")
@cn.mapway.document.annotation.Doc("s_role 角色表")
public final class S_ROLEObj
    implements com.google.gwt.user.client.rpc.IsSerializable, com.ksyzt.gwt.client.data.IFieldValue {
  /**
   * 表角色表代码名称
   */
  public static final String TBL_S_ROLE = "s_role";
  public S_ROLEObj() {
  }
  /**
   * 字段索引角色ID id
   */
  public static final String FLD_ID = "id";

  /**
   * 字段 id 角色ID
   */
  @org.nutz.dao.entity.annotation.Id
  @cn.mapway.document.annotation.ApiField(value = "角色ID", example = "")
  public Long id;
  /**
   * 字段索引角色名称 name
   */
  public static final String FLD_NAME = "name";

  /**
   * 字段 name 角色名称
   */
  @org.nutz.dao.entity.annotation.Column("name")
  @cn.mapway.document.annotation.ApiField(value = "角色名称", example = "")
  public String name;
  /**
   * 字段索引角色说明 summary
   */
  public static final String FLD_SUMMARY = "summary";

  /**
   * 字段 summary 角色说明
   */
  @org.nutz.dao.entity.annotation.Column("summary")
  @cn.mapway.document.annotation.ApiField(value = "角色说明", example = "")
  public String summary;
  /**
   * 返回字段id 角色ID
   */
  public Long getId() {
    return this.id;
  }
  /**
   * 设置字段id 角色ID
   */
  public void setId(Long id) {
    this.id=id;
  }
  /**
   * 返回字段name 角色名称
   */
  public String getName() {
    return this.name;
  }
  /**
   * 设置字段name 角色名称
   */
  public void setName(String name) {
    this.name=name;
  }
  /**
   * 返回字段summary 角色说明
   */
  public String getSummary() {
    return this.summary;
  }
  /**
   * 设置字段summary 角色说明
   */
  public void setSummary(String summary) {
    this.summary=summary;
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
   * 获取字summary索引
   */
  public static final Integer IDX_SUMMARY = 2;
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
      if (FLD_SUMMARY.equals(fieldName)) {
        return this.summary;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 3) {
      if (fieldIndex == 0) {
        return this.id;
      }
      if (fieldIndex == 1) {
        return this.name;
      }
      if (fieldIndex == 2) {
        return this.summary;
      }
    } else {
      return null;
    }
    return null;
  }
}
