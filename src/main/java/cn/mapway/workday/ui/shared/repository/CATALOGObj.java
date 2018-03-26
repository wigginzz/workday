package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ���ݿ��-
 */
@org.nutz.dao.entity.annotation.Table("catalog")
@cn.mapway.document.annotation.Doc("catalog ")
public final class CATALOGObj {
  /**
   * ���������
   */
  public static final String TBL_CATALOG = "catalog";
  public CATALOGObj() {
  }
  /**
   * �ֶ����� id
   */
  public static final String FLD_ID = "id";

  /**
   * �ֶ� id 
   */
  @org.nutz.dao.entity.annotation.Id
  @cn.mapway.document.annotation.ApiField(value = "id", example = "")
  public Integer id;
  /**
   * �ֶ����� name
   */
  public static final String FLD_NAME = "name";

  /**
   * �ֶ� name 
   */
  @org.nutz.dao.entity.annotation.Column("name")
  @cn.mapway.document.annotation.ApiField(value = "name", example = "")
  public String name;
  /**
   * �ֶ����� desc
   */
  public static final String FLD_DESC = "desc";

  /**
   * �ֶ� desc 
   */
  @org.nutz.dao.entity.annotation.Column("desc")
  @cn.mapway.document.annotation.ApiField(value = "desc", example = "")
  public String desc;
  /**
   * �ֶ����� icon
   */
  public static final String FLD_ICON = "icon";

  /**
   * �ֶ� icon 
   */
  @org.nutz.dao.entity.annotation.Column("icon")
  @cn.mapway.document.annotation.ApiField(value = "icon", example = "")
  public String icon;
  /**
   * �ֶ����� rank
   */
  public static final String FLD_RANK = "rank";

  /**
   * �ֶ� rank 
   */
  @org.nutz.dao.entity.annotation.Column("rank")
  @cn.mapway.document.annotation.ApiField(value = "rank", example = "")
  public String rank;
  /**
   * �ֶ����� userid
   */
  public static final String FLD_USERID = "userid";

  /**
   * �ֶ� userid 
   */
  @org.nutz.dao.entity.annotation.Column("userid")
  @cn.mapway.document.annotation.ApiField(value = "userid", example = "")
  public Integer userid;
  /**
   * �ֶ����� pid
   */
  public static final String FLD_PID = "pid";

  /**
   * �ֶ� pid 
   */
  @org.nutz.dao.entity.annotation.Column("pid")
  @cn.mapway.document.annotation.ApiField(value = "pid", example = "")
  public Integer pid;
  /**
   * �����ֶ�id 
   */
  public Integer getId() {
    return this.id;
  }
  /**
   * �����ֶ�id 
   */
  public void setId(Integer id) {
    this.id=id;
  }
  /**
   * �����ֶ�name 
   */
  public String getName() {
    return this.name;
  }
  /**
   * �����ֶ�name 
   */
  public void setName(String name) {
    this.name=name;
  }
  /**
   * �����ֶ�desc 
   */
  public String getDesc() {
    return this.desc;
  }
  /**
   * �����ֶ�desc 
   */
  public void setDesc(String desc) {
    this.desc=desc;
  }
  /**
   * �����ֶ�icon 
   */
  public String getIcon() {
    return this.icon;
  }
  /**
   * �����ֶ�icon 
   */
  public void setIcon(String icon) {
    this.icon=icon;
  }
  /**
   * �����ֶ�rank 
   */
  public String getRank() {
    return this.rank;
  }
  /**
   * �����ֶ�rank 
   */
  public void setRank(String rank) {
    this.rank=rank;
  }
  /**
   * �����ֶ�userid 
   */
  public Integer getUserid() {
    return this.userid;
  }
  /**
   * �����ֶ�userid 
   */
  public void setUserid(Integer userid) {
    this.userid=userid;
  }
  /**
   * �����ֶ�pid 
   */
  public Integer getPid() {
    return this.pid;
  }
  /**
   * �����ֶ�pid 
   */
  public void setPid(Integer pid) {
    this.pid=pid;
  }
}
