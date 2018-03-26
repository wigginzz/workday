package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ���ݿ��-�û���ɫ��
 */
@org.nutz.dao.entity.annotation.Table("s_user_role")
@org.nutz.dao.entity.annotation.PK({"user_id","role_id"})
@cn.mapway.document.annotation.Doc("s_user_role �û���ɫ��")
public final class S_USER_ROLEObj {
  /**
   * ���û���ɫ���������
   */
  public static final String TBL_S_USER_ROLE = "s_user_role";
  public S_USER_ROLEObj() {
  }
  /**
   * �ֶ������û�ID user_id
   */
  public static final String FLD_USER_ID = "user_id";

  /**
   * �ֶ� user_id �û�ID
   */
  @org.nutz.dao.entity.annotation.Column("user_id")
  @cn.mapway.document.annotation.ApiField(value = "�û�ID", example = "")
  public Long userId;
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
   * �����ֶ�user_id �û�ID
   */
  public Long getUserId() {
    return this.userId;
  }
  /**
   * �����ֶ�user_id �û�ID
   */
  public void setUserId(Long userId) {
    this.userId=userId;
  }
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
}
