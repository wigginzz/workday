package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ���ݿ��-��ɫ��
 */
@org.nutz.dao.entity.annotation.Table("s_role")
@cn.mapway.document.annotation.Doc("s_role ��ɫ��")
public final class S_ROLEObj {
  /**
   * ���ɫ���������
   */
  public static final String TBL_S_ROLE = "s_role";
  public S_ROLEObj() {
  }
  /**
   * �ֶ�������ɫID id
   */
  public static final String FLD_ID = "id";

  /**
   * �ֶ� id ��ɫID
   */
  @org.nutz.dao.entity.annotation.Id
  @cn.mapway.document.annotation.ApiField(value = "��ɫID", example = "")
  public Long id;
  /**
   * �ֶ�������ɫ���� name
   */
  public static final String FLD_NAME = "name";

  /**
   * �ֶ� name ��ɫ����
   */
  @org.nutz.dao.entity.annotation.Column("name")
  @cn.mapway.document.annotation.ApiField(value = "��ɫ����", example = "")
  public String name;
  /**
   * �ֶ�������ɫ˵�� summary
   */
  public static final String FLD_SUMMARY = "summary";

  /**
   * �ֶ� summary ��ɫ˵��
   */
  @org.nutz.dao.entity.annotation.Column("summary")
  @cn.mapway.document.annotation.ApiField(value = "��ɫ˵��", example = "")
  public String summary;
  /**
   * �����ֶ�id ��ɫID
   */
  public Long getId() {
    return this.id;
  }
  /**
   * �����ֶ�id ��ɫID
   */
  public void setId(Long id) {
    this.id=id;
  }
  /**
   * �����ֶ�name ��ɫ����
   */
  public String getName() {
    return this.name;
  }
  /**
   * �����ֶ�name ��ɫ����
   */
  public void setName(String name) {
    this.name=name;
  }
  /**
   * �����ֶ�summary ��ɫ˵��
   */
  public String getSummary() {
    return this.summary;
  }
  /**
   * �����ֶ�summary ��ɫ˵��
   */
  public void setSummary(String summary) {
    this.summary=summary;
  }
}
