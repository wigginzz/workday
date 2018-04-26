package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 数据库表-
 */
@org.nutz.dao.entity.annotation.Table("catalog")
@cn.mapway.document.annotation.Doc("catalog ")
public final class CATALOGObj
    implements com.google.gwt.user.client.rpc.IsSerializable, com.ksyzt.gwt.client.data.IFieldValue {
  /**
   * 表代码名称
   */
  public static final String TBL_CATALOG = "catalog";
  public CATALOGObj() {
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
   * 字段索引 desc
   */
  public static final String FLD_DESC = "desc";

  /**
   * 字段 desc 
   */
  @org.nutz.dao.entity.annotation.Column("desc")
  @cn.mapway.document.annotation.ApiField(value = "desc", example = "")
  public String desc;
  /**
   * 字段索引 icon
   */
  public static final String FLD_ICON = "icon";

  /**
   * 字段 icon 
   */
  @org.nutz.dao.entity.annotation.Column("icon")
  @cn.mapway.document.annotation.ApiField(value = "icon", example = "")
  public String icon;
  /**
   * 字段索引 rank
   */
  public static final String FLD_RANK = "rank";

  /**
   * 字段 rank 
   */
  @org.nutz.dao.entity.annotation.Column("rank")
  @cn.mapway.document.annotation.ApiField(value = "rank", example = "")
  public String rank;
  /**
   * 字段索引 userid
   */
  public static final String FLD_USERID = "userid";

  /**
   * 字段 userid 
   */
  @org.nutz.dao.entity.annotation.Column("userid")
  @cn.mapway.document.annotation.ApiField(value = "userid", example = "")
  public Integer userid;
  /**
   * 字段索引 pid
   */
  public static final String FLD_PID = "pid";

  /**
   * 字段 pid 
   */
  @org.nutz.dao.entity.annotation.Column("pid")
  @cn.mapway.document.annotation.ApiField(value = "pid", example = "")
  public Integer pid;
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
   * 返回字段desc 
   */
  public String getDesc() {
    return this.desc;
  }
  /**
   * 设置字段desc 
   */
  public void setDesc(String desc) {
    this.desc=desc;
  }
  /**
   * 返回字段icon 
   */
  public String getIcon() {
    return this.icon;
  }
  /**
   * 设置字段icon 
   */
  public void setIcon(String icon) {
    this.icon=icon;
  }
  /**
   * 返回字段rank 
   */
  public String getRank() {
    return this.rank;
  }
  /**
   * 设置字段rank 
   */
  public void setRank(String rank) {
    this.rank=rank;
  }
  /**
   * 返回字段userid 
   */
  public Integer getUserid() {
    return this.userid;
  }
  /**
   * 设置字段userid 
   */
  public void setUserid(Integer userid) {
    this.userid=userid;
  }
  /**
   * 返回字段pid 
   */
  public Integer getPid() {
    return this.pid;
  }
  /**
   * 设置字段pid 
   */
  public void setPid(Integer pid) {
    this.pid=pid;
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
   * 获取字desc索引
   */
  public static final Integer IDX_DESC = 2;
  /**
   * 获取字icon索引
   */
  public static final Integer IDX_ICON = 3;
  /**
   * 获取字rank索引
   */
  public static final Integer IDX_RANK = 4;
  /**
   * 获取字userid索引
   */
  public static final Integer IDX_USERID = 5;
  /**
   * 获取字pid索引
   */
  public static final Integer IDX_PID = 6;
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
      if (FLD_DESC.equals(fieldName)) {
        return this.desc;
      }
      if (FLD_ICON.equals(fieldName)) {
        return this.icon;
      }
      if (FLD_RANK.equals(fieldName)) {
        return this.rank;
      }
      if (FLD_USERID.equals(fieldName)) {
        return this.userid;
      }
      if (FLD_PID.equals(fieldName)) {
        return this.pid;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 7) {
      if (fieldIndex == 0) {
        return this.id;
      }
      if (fieldIndex == 1) {
        return this.name;
      }
      if (fieldIndex == 2) {
        return this.desc;
      }
      if (fieldIndex == 3) {
        return this.icon;
      }
      if (fieldIndex == 4) {
        return this.rank;
      }
      if (fieldIndex == 5) {
        return this.userid;
      }
      if (fieldIndex == 6) {
        return this.pid;
      }
    } else {
      return null;
    }
    return null;
  }
}
