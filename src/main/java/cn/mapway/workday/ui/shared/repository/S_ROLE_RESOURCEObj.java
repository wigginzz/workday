package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 数据库表-角色资源ID
 */
@org.nutz.dao.entity.annotation.Table("s_role_resource")
@org.nutz.dao.entity.annotation.PK({"role_id","res_id"})
@cn.mapway.document.annotation.Doc("s_role_resource 角色资源ID")
public final class S_ROLE_RESOURCEObj
    implements com.google.gwt.user.client.rpc.IsSerializable, com.ksyzt.gwt.client.data.IFieldValue {
  /**
   * 表角色资源ID代码名称
   */
  public static final String TBL_S_ROLE_RESOURCE = "s_role_resource";
  public S_ROLE_RESOURCEObj() {
  }
  /**
   * 字段索引角色ID role_id
   */
  public static final String FLD_ROLE_ID = "role_id";

  /**
   * 字段 role_id 角色ID
   */
  @org.nutz.dao.entity.annotation.Column("role_id")
  @cn.mapway.document.annotation.ApiField(value = "角色ID", example = "")
  public Long roleId;
  /**
   * 字段索引资源ID res_id
   */
  public static final String FLD_RES_ID = "res_id";

  /**
   * 字段 res_id 资源ID
   */
  @org.nutz.dao.entity.annotation.Column("res_id")
  @cn.mapway.document.annotation.ApiField(value = "资源ID", example = "")
  public Long resId;
  /**
   * 返回字段role_id 角色ID
   */
  public Long getRoleId() {
    return this.roleId;
  }
  /**
   * 设置字段role_id 角色ID
   */
  public void setRoleId(Long roleId) {
    this.roleId=roleId;
  }
  /**
   * 返回字段res_id 资源ID
   */
  public Long getResId() {
    return this.resId;
  }
  /**
   * 设置字段res_id 资源ID
   */
  public void setResId(Long resId) {
    this.resId=resId;
  }
  /**
   * 获取字role_id索引
   */
  public static final Integer IDX_ROLE_ID = 0;
  /**
   * 获取字res_id索引
   */
  public static final Integer IDX_RES_ID = 1;
  /**
   * 根据字段名称获取字段的.
   */
  @Override
  public Object getFieldValue(String fieldName, Integer fieldIndex) {
    if (fieldName != null && fieldName.length() > 0) {
      if (FLD_ROLE_ID.equals(fieldName)) {
        return this.roleId;
      }
      if (FLD_RES_ID.equals(fieldName)) {
        return this.resId;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 2) {
      if (fieldIndex == 0) {
        return this.roleId;
      }
      if (fieldIndex == 1) {
        return this.resId;
      }
    } else {
      return null;
    }
    return null;
  }
}
