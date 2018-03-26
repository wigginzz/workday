package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ���ݿ��-Ԫ������Ϣ
 */
@org.nutz.dao.entity.annotation.Table("s_meta")
@cn.mapway.document.annotation.Doc("s_meta Ԫ������Ϣ")
public final class S_METAObj {
  /**
   * ��Ԫ������Ϣ��������
   */
  public static final String TBL_S_META = "s_meta";
  public S_METAObj() {
  }
  /**
   * �ֶ�����Ԫ����ID id
   */
  public static final String FLD_ID = "id";

  /**
   * �ֶ� id Ԫ����ID
   */
  @org.nutz.dao.entity.annotation.Id
  @cn.mapway.document.annotation.ApiField(value = "Ԫ����ID", example = "")
  public Integer id;
  /**
   * �ֶ���������Ŀ¼ catalog
   */
  public static final String FLD_CATALOG = "catalog";

  /**
   * �ֶ� catalog ����Ŀ¼
   */
  @org.nutz.dao.entity.annotation.Column("catalog")
  @cn.mapway.document.annotation.ApiField(value = "����Ŀ¼", example = "")
  public String catalog;
  /**
   * �ֶ��������� name
   */
  public static final String FLD_NAME = "name";

  /**
   * �ֶ� name ����
   */
  @org.nutz.dao.entity.annotation.Column("name")
  @cn.mapway.document.annotation.ApiField(value = "����", example = "")
  public String name;
  /**
   * �ֶ�����code code
   */
  public static final String FLD_CODE = "code";

  /**
   * �ֶ� code code
   */
  @org.nutz.dao.entity.annotation.Column("code")
  @cn.mapway.document.annotation.ApiField(value = "code", example = "")
  public String code;
  /**
   * �ֶ��������� rank
   */
  public static final String FLD_RANK = "rank";

  /**
   * �ֶ� rank ����
   */
  @org.nutz.dao.entity.annotation.Column("rank")
  @cn.mapway.document.annotation.ApiField(value = "����", example = "")
  public Integer rank;
  /**
   * �ֶ�������ID pid
   */
  public static final String FLD_PID = "pid";

  /**
   * �ֶ� pid ��ID
   */
  @org.nutz.dao.entity.annotation.Column("pid")
  @cn.mapway.document.annotation.ApiField(value = "��ID", example = "")
  public Integer pid;
  /**
   * �ֶ�����������Ϣ description
   */
  public static final String FLD_DESCRIPTION = "description";

  /**
   * �ֶ� description ������Ϣ
   */
  @org.nutz.dao.entity.annotation.Column("description")
  @cn.mapway.document.annotation.ApiField(value = "������Ϣ", example = "")
  public String description;
  /**
   * �ֶ�����ͼ�� icon
   */
  public static final String FLD_ICON = "icon";

  /**
   * �ֶ� icon ͼ��
   */
  @org.nutz.dao.entity.annotation.Column("icon")
  @cn.mapway.document.annotation.ApiField(value = "ͼ��", example = "")
  public String icon;
  /**
   * �ֶ�������ID root_id
   */
  public static final String FLD_ROOT_ID = "root_id";

  /**
   * �ֶ� root_id ��ID
   */
  @org.nutz.dao.entity.annotation.Column("root_id")
  @cn.mapway.document.annotation.ApiField(value = "��ID", example = "")
  public Integer rootId;
  /**
   * �����ֶ�id Ԫ����ID
   */
  public Integer getId() {
    return this.id;
  }
  /**
   * �����ֶ�id Ԫ����ID
   */
  public void setId(Integer id) {
    this.id=id;
  }
  /**
   * �����ֶ�catalog ����Ŀ¼
   */
  public String getCatalog() {
    return this.catalog;
  }
  /**
   * �����ֶ�catalog ����Ŀ¼
   */
  public void setCatalog(String catalog) {
    this.catalog=catalog;
  }
  /**
   * �����ֶ�name ����
   */
  public String getName() {
    return this.name;
  }
  /**
   * �����ֶ�name ����
   */
  public void setName(String name) {
    this.name=name;
  }
  /**
   * �����ֶ�code code
   */
  public String getCode() {
    return this.code;
  }
  /**
   * �����ֶ�code code
   */
  public void setCode(String code) {
    this.code=code;
  }
  /**
   * �����ֶ�rank ����
   */
  public Integer getRank() {
    return this.rank;
  }
  /**
   * �����ֶ�rank ����
   */
  public void setRank(Integer rank) {
    this.rank=rank;
  }
  /**
   * �����ֶ�pid ��ID
   */
  public Integer getPid() {
    return this.pid;
  }
  /**
   * �����ֶ�pid ��ID
   */
  public void setPid(Integer pid) {
    this.pid=pid;
  }
  /**
   * �����ֶ�description ������Ϣ
   */
  public String getDescription() {
    return this.description;
  }
  /**
   * �����ֶ�description ������Ϣ
   */
  public void setDescription(String description) {
    this.description=description;
  }
  /**
   * �����ֶ�icon ͼ��
   */
  public String getIcon() {
    return this.icon;
  }
  /**
   * �����ֶ�icon ͼ��
   */
  public void setIcon(String icon) {
    this.icon=icon;
  }
  /**
   * �����ֶ�root_id ��ID
   */
  public Integer getRootId() {
    return this.rootId;
  }
  /**
   * �����ֶ�root_id ��ID
   */
  public void setRootId(Integer rootId) {
    this.rootId=rootId;
  }
}
