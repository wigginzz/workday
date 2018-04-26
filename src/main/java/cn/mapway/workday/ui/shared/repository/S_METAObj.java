package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 数据库表-元数据信息
 */
@org.nutz.dao.entity.annotation.Table("s_meta")
@cn.mapway.document.annotation.Doc("s_meta 元数据信息")
public final class S_METAObj
    implements com.google.gwt.user.client.rpc.IsSerializable, com.ksyzt.gwt.client.data.IFieldValue {
  /**
   * 表元数据信息代码名称
   */
  public static final String TBL_S_META = "s_meta";
  public S_METAObj() {
  }
  /**
   * 字段索引元数据ID id
   */
  public static final String FLD_ID = "id";

  /**
   * 字段 id 元数据ID
   */
  @org.nutz.dao.entity.annotation.Id
  @cn.mapway.document.annotation.ApiField(value = "元数据ID", example = "")
  public Integer id;
  /**
   * 字段索引分类目录 catalog
   */
  public static final String FLD_CATALOG = "catalog";

  /**
   * 字段 catalog 分类目录
   */
  @org.nutz.dao.entity.annotation.Column("catalog")
  @cn.mapway.document.annotation.ApiField(value = "分类目录", example = "")
  public String catalog;
  /**
   * 字段索引名称 name
   */
  public static final String FLD_NAME = "name";

  /**
   * 字段 name 名称
   */
  @org.nutz.dao.entity.annotation.Column("name")
  @cn.mapway.document.annotation.ApiField(value = "名称", example = "")
  public String name;
  /**
   * 字段索引code code
   */
  public static final String FLD_CODE = "code";

  /**
   * 字段 code code
   */
  @org.nutz.dao.entity.annotation.Column("code")
  @cn.mapway.document.annotation.ApiField(value = "code", example = "")
  public String code;
  /**
   * 字段索引排序 rank
   */
  public static final String FLD_RANK = "rank";

  /**
   * 字段 rank 排序
   */
  @org.nutz.dao.entity.annotation.Column("rank")
  @cn.mapway.document.annotation.ApiField(value = "排序", example = "")
  public Integer rank;
  /**
   * 字段索引父ID pid
   */
  public static final String FLD_PID = "pid";

  /**
   * 字段 pid 父ID
   */
  @org.nutz.dao.entity.annotation.Column("pid")
  @cn.mapway.document.annotation.ApiField(value = "父ID", example = "")
  public Integer pid;
  /**
   * 字段索引描述信息 description
   */
  public static final String FLD_DESCRIPTION = "description";

  /**
   * 字段 description 描述信息
   */
  @org.nutz.dao.entity.annotation.Column("description")
  @cn.mapway.document.annotation.ApiField(value = "描述信息", example = "")
  public String description;
  /**
   * 字段索引图标 icon
   */
  public static final String FLD_ICON = "icon";

  /**
   * 字段 icon 图标
   */
  @org.nutz.dao.entity.annotation.Column("icon")
  @cn.mapway.document.annotation.ApiField(value = "图标", example = "")
  public String icon;
  /**
   * 字段索引跟ID root_id
   */
  public static final String FLD_ROOT_ID = "root_id";

  /**
   * 字段 root_id 跟ID
   */
  @org.nutz.dao.entity.annotation.Column("root_id")
  @cn.mapway.document.annotation.ApiField(value = "跟ID", example = "")
  public Integer rootId;
  /**
   * 返回字段id 元数据ID
   */
  public Integer getId() {
    return this.id;
  }
  /**
   * 设置字段id 元数据ID
   */
  public void setId(Integer id) {
    this.id=id;
  }
  /**
   * 返回字段catalog 分类目录
   */
  public String getCatalog() {
    return this.catalog;
  }
  /**
   * 设置字段catalog 分类目录
   */
  public void setCatalog(String catalog) {
    this.catalog=catalog;
  }
  /**
   * 返回字段name 名称
   */
  public String getName() {
    return this.name;
  }
  /**
   * 设置字段name 名称
   */
  public void setName(String name) {
    this.name=name;
  }
  /**
   * 返回字段code code
   */
  public String getCode() {
    return this.code;
  }
  /**
   * 设置字段code code
   */
  public void setCode(String code) {
    this.code=code;
  }
  /**
   * 返回字段rank 排序
   */
  public Integer getRank() {
    return this.rank;
  }
  /**
   * 设置字段rank 排序
   */
  public void setRank(Integer rank) {
    this.rank=rank;
  }
  /**
   * 返回字段pid 父ID
   */
  public Integer getPid() {
    return this.pid;
  }
  /**
   * 设置字段pid 父ID
   */
  public void setPid(Integer pid) {
    this.pid=pid;
  }
  /**
   * 返回字段description 描述信息
   */
  public String getDescription() {
    return this.description;
  }
  /**
   * 设置字段description 描述信息
   */
  public void setDescription(String description) {
    this.description=description;
  }
  /**
   * 返回字段icon 图标
   */
  public String getIcon() {
    return this.icon;
  }
  /**
   * 设置字段icon 图标
   */
  public void setIcon(String icon) {
    this.icon=icon;
  }
  /**
   * 返回字段root_id 跟ID
   */
  public Integer getRootId() {
    return this.rootId;
  }
  /**
   * 设置字段root_id 跟ID
   */
  public void setRootId(Integer rootId) {
    this.rootId=rootId;
  }
  /**
   * 获取字id索引
   */
  public static final Integer IDX_ID = 0;
  /**
   * 获取字catalog索引
   */
  public static final Integer IDX_CATALOG = 1;
  /**
   * 获取字name索引
   */
  public static final Integer IDX_NAME = 2;
  /**
   * 获取字code索引
   */
  public static final Integer IDX_CODE = 3;
  /**
   * 获取字rank索引
   */
  public static final Integer IDX_RANK = 4;
  /**
   * 获取字pid索引
   */
  public static final Integer IDX_PID = 5;
  /**
   * 获取字description索引
   */
  public static final Integer IDX_DESCRIPTION = 6;
  /**
   * 获取字icon索引
   */
  public static final Integer IDX_ICON = 7;
  /**
   * 获取字root_id索引
   */
  public static final Integer IDX_ROOT_ID = 8;
  /**
   * 根据字段名称获取字段的.
   */
  @Override
  public Object getFieldValue(String fieldName, Integer fieldIndex) {
    if (fieldName != null && fieldName.length() > 0) {
      if (FLD_ID.equals(fieldName)) {
        return this.id;
      }
      if (FLD_CATALOG.equals(fieldName)) {
        return this.catalog;
      }
      if (FLD_NAME.equals(fieldName)) {
        return this.name;
      }
      if (FLD_CODE.equals(fieldName)) {
        return this.code;
      }
      if (FLD_RANK.equals(fieldName)) {
        return this.rank;
      }
      if (FLD_PID.equals(fieldName)) {
        return this.pid;
      }
      if (FLD_DESCRIPTION.equals(fieldName)) {
        return this.description;
      }
      if (FLD_ICON.equals(fieldName)) {
        return this.icon;
      }
      if (FLD_ROOT_ID.equals(fieldName)) {
        return this.rootId;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 9) {
      if (fieldIndex == 0) {
        return this.id;
      }
      if (fieldIndex == 1) {
        return this.catalog;
      }
      if (fieldIndex == 2) {
        return this.name;
      }
      if (fieldIndex == 3) {
        return this.code;
      }
      if (fieldIndex == 4) {
        return this.rank;
      }
      if (fieldIndex == 5) {
        return this.pid;
      }
      if (fieldIndex == 6) {
        return this.description;
      }
      if (fieldIndex == 7) {
        return this.icon;
      }
      if (fieldIndex == 8) {
        return this.rootId;
      }
    } else {
      return null;
    }
    return null;
  }
}
