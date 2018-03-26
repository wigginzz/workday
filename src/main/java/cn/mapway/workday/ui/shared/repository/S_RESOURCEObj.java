package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ���ݿ��-ϵͳ��Դ��
 */
@org.nutz.dao.entity.annotation.Table("s_resource")
@cn.mapway.document.annotation.Doc("s_resource ϵͳ��Դ��")
public final class S_RESOURCEObj {
  /**
   * ��ϵͳ��Դ���������
   */
  public static final String TBL_S_RESOURCE = "s_resource";
  public S_RESOURCEObj() {
  }
  /**
   * �ֶ�������ԴID id
   */
  public static final String FLD_ID = "id";

  /**
   * �ֶ� id ��ԴID
   */
  @org.nutz.dao.entity.annotation.Id
  @cn.mapway.document.annotation.ApiField(value = "��ԴID", example = "")
  public Long id;
  /**
   * �ֶ�������Դ���� name
   */
  public static final String FLD_NAME = "name";

  /**
   * �ֶ� name ��Դ����
   */
  @org.nutz.dao.entity.annotation.Column("name")
  @cn.mapway.document.annotation.ApiField(value = "��Դ����", example = "")
  public String name;
  /**
   * �ֶ�����ģ����� para
   */
  public static final String FLD_PARA = "para";

  /**
   * �ֶ� para ģ�����
   */
  @org.nutz.dao.entity.annotation.Column("para")
  @cn.mapway.document.annotation.ApiField(value = "ģ�����", example = "")
  public String para;
  /**
   * �ֶ�������ID pid
   */
  public static final String FLD_PID = "pid";

  /**
   * �ֶ� pid ��ID
   */
  @org.nutz.dao.entity.annotation.Column("pid")
  @cn.mapway.document.annotation.ApiField(value = "��ID", example = "")
  public Long pid;
  /**
   * �ֶ�����ͼ�����·�� icon
   */
  public static final String FLD_ICON = "icon";

  /**
   * �ֶ� icon ͼ�����·��
   */
  @org.nutz.dao.entity.annotation.Column("icon")
  @cn.mapway.document.annotation.ApiField(value = "ͼ�����·��", example = "")
  public String icon;
  /**
   * �ֶ�����·����Ϣ path
   */
  public static final String FLD_PATH = "path";

  /**
   * �ֶ� path ·����Ϣ
   */
  @org.nutz.dao.entity.annotation.Column("path")
  @cn.mapway.document.annotation.ApiField(value = "·����Ϣ", example = "")
  public String path;
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
   * �ֶ�������Դ˵�� summary
   */
  public static final String FLD_SUMMARY = "summary";

  /**
   * �ֶ� summary ��Դ˵��
   */
  @org.nutz.dao.entity.annotation.Column("summary")
  @cn.mapway.document.annotation.ApiField(value = "��Դ˵��", example = "")
  public String summary;
  /**
   * �ֶ�����ģ����� code
   */
  public static final String FLD_CODE = "code";

  /**
   * �ֶ� code ģ�����
   */
  @org.nutz.dao.entity.annotation.Column("code")
  @cn.mapway.document.annotation.ApiField(value = "ģ�����", example = "")
  public String code;
  /**
   * �ֶ�����CSS��ʽ style
   */
  public static final String FLD_STYLE = "style";

  /**
   * �ֶ� style CSS��ʽ
   */
  @org.nutz.dao.entity.annotation.Column("style")
  @cn.mapway.document.annotation.ApiField(value = "CSS��ʽ", example = "")
  public String style;
  /**
   * �ֶ������������ click
   */
  public static final String FLD_CLICK = "click";

  /**
   * �ֶ� click �������
   */
  @org.nutz.dao.entity.annotation.Column("click")
  @cn.mapway.document.annotation.ApiField(value = "�������", example = "")
  public Long click;
  /**
   * �ֶ�������ID rootid
   */
  public static final String FLD_ROOTID = "rootid";

  /**
   * �ֶ� rootid ��ID
   */
  @org.nutz.dao.entity.annotation.Column("rootid")
  @cn.mapway.document.annotation.ApiField(value = "��ID", example = "")
  public Long rootid;
  /**
   * �����ֶ�id ��ԴID
   */
  public Long getId() {
    return this.id;
  }
  /**
   * �����ֶ�id ��ԴID
   */
  public void setId(Long id) {
    this.id=id;
  }
  /**
   * �����ֶ�name ��Դ����
   */
  public String getName() {
    return this.name;
  }
  /**
   * �����ֶ�name ��Դ����
   */
  public void setName(String name) {
    this.name=name;
  }
  /**
   * �����ֶ�para ģ�����
   */
  public String getPara() {
    return this.para;
  }
  /**
   * �����ֶ�para ģ�����
   */
  public void setPara(String para) {
    this.para=para;
  }
  /**
   * �����ֶ�pid ��ID
   */
  public Long getPid() {
    return this.pid;
  }
  /**
   * �����ֶ�pid ��ID
   */
  public void setPid(Long pid) {
    this.pid=pid;
  }
  /**
   * �����ֶ�icon ͼ�����·��
   */
  public String getIcon() {
    return this.icon;
  }
  /**
   * �����ֶ�icon ͼ�����·��
   */
  public void setIcon(String icon) {
    this.icon=icon;
  }
  /**
   * �����ֶ�path ·����Ϣ
   */
  public String getPath() {
    return this.path;
  }
  /**
   * �����ֶ�path ·����Ϣ
   */
  public void setPath(String path) {
    this.path=path;
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
   * �����ֶ�summary ��Դ˵��
   */
  public String getSummary() {
    return this.summary;
  }
  /**
   * �����ֶ�summary ��Դ˵��
   */
  public void setSummary(String summary) {
    this.summary=summary;
  }
  /**
   * �����ֶ�code ģ�����
   */
  public String getCode() {
    return this.code;
  }
  /**
   * �����ֶ�code ģ�����
   */
  public void setCode(String code) {
    this.code=code;
  }
  /**
   * �����ֶ�style CSS��ʽ
   */
  public String getStyle() {
    return this.style;
  }
  /**
   * �����ֶ�style CSS��ʽ
   */
  public void setStyle(String style) {
    this.style=style;
  }
  /**
   * �����ֶ�click �������
   */
  public Long getClick() {
    return this.click;
  }
  /**
   * �����ֶ�click �������
   */
  public void setClick(Long click) {
    this.click=click;
  }
  /**
   * �����ֶ�rootid ��ID
   */
  public Long getRootid() {
    return this.rootid;
  }
  /**
   * �����ֶ�rootid ��ID
   */
  public void setRootid(Long rootid) {
    this.rootid=rootid;
  }
}
