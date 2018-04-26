package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 数据库表-用户角色表
 */
@org.nutz.dao.entity.annotation.Table("s_user_role")
@org.nutz.dao.entity.annotation.PK({"user_id","role_id"})
@cn.mapway.document.annotation.Doc("s_user_role 用户角色表")
public final class S_USER_ROLEObj
    implements com.google.gwt.user.client.rpc.IsSerializable, com.ksyzt.gwt.client.data.IFieldValue {
  /**
   * 表用户角色表代码名称
   */
  public static final String TBL_S_USER_ROLE = "s_user_role";
  public S_USER_ROLEObj() {
  }
  /**
   * 字段索引用户ID user_id
   */
  public static final String FLD_USER_ID = "user_id";

  /**
   * 字段 user_id 用户ID
   */
  @org.nutz.dao.entity.annotation.Column("user_id")
  @cn.mapway.document.annotation.ApiField(value = "用户ID", example = "")
  public Long userId;
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
   * 返回字段user_id 用户ID
   */
  public Long getUserId() {
    return this.userId;
  }
  /**
   * 设置字段user_id 用户ID
   */
  public void setUserId(Long userId) {
    this.userId=userId;
  }
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
   * 获取字user_id索引
   */
  public static final Integer IDX_USER_ID = 0;
  /**
   * 获取字role_id索引
   */
  public static final Integer IDX_ROLE_ID = 1;
  /**
   * 根据字段名称获取字段的.
   */
  @Override
  public Object getFieldValue(String fieldName, Integer fieldIndex) {
    if (fieldName != null && fieldName.length() > 0) {
      if (FLD_USER_ID.equals(fieldName)) {
        return this.userId;
      }
      if (FLD_ROLE_ID.equals(fieldName)) {
        return this.roleId;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 2) {
      if (fieldIndex == 0) {
        return this.userId;
      }
      if (fieldIndex == 1) {
        return this.roleId;
      }
    } else {
      return null;
    }
    return null;
  }
}
