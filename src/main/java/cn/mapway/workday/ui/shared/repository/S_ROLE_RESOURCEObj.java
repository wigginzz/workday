package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ���ݿ��-��ɫ��ԴID
 */
@org.nutz.dao.entity.annotation.Table("s_role_resource")
@org.nutz.dao.entity.annotation.PK({"role_id","res_id"})
@cn.mapway.document.annotation.Doc("s_role_resource ��ɫ��ԴID")
public final class S_ROLE_RESOURCEObj {
  /**
   * ���ɫ��ԴID��������
   */
  public static final String TBL_S_ROLE_RESOURCE = "s_role_resource";
  public S_ROLE_RESOURCEObj() {
  }
  /**
   * �ֶ�������ɫID role_id
   */
  public static final String FLD_ROLE_ID = "role_id";

  /**
   * �ֶ� role_id ��ɫID
   */
  @org.nutz.dao.entity.annotation.Column("role_id")
  @cn.mapway.document.annotation.ApiField(value = "��ɫID", example = "")
  public Long roleId;
  /**
   * �ֶ�������ԴID res_id
   */
  public static final String FLD_RES_ID = "res_id";

  /**
   * �ֶ� res_id ��ԴID
   */
  @org.nutz.dao.entity.annotation.Column("res_id")
  @cn.mapway.document.annotation.ApiField(value = "��ԴID", example = "")
  public Long resId;
  /**
   * �����ֶ�role_id ��ɫID
   */
  public Long getRoleId() {
    return this.roleId;
  }
  /**
   * �����ֶ�role_id ��ɫID
   */
  public void setRoleId(Long roleId) {
    this.roleId=roleId;
  }
  /**
   * �����ֶ�res_id ��ԴID
   */
  public Long getResId() {
    return this.resId;
  }
  /**
   * �����ֶ�res_id ��ԴID
   */
  public void setResId(Long resId) {
    this.resId=resId;
  }
}
