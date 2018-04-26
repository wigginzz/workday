package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 数据库表-系统资源表
 */
@org.nutz.dao.entity.annotation.Table("s_resource")
@cn.mapway.document.annotation.Doc("s_resource 系统资源表")
public final class S_RESOURCEObj
    implements com.google.gwt.user.client.rpc.IsSerializable, com.ksyzt.gwt.client.data.IFieldValue {
  /**
   * 表系统资源表代码名称
   */
  public static final String TBL_S_RESOURCE = "s_resource";
  public S_RESOURCEObj() {
  }
  /**
   * 字段索引资源ID id
   */
  public static final String FLD_ID = "id";

  /**
   * 字段 id 资源ID
   */
  @org.nutz.dao.entity.annotation.Id
  @cn.mapway.document.annotation.ApiField(value = "资源ID", example = "")
  public Long id;
  /**
   * 字段索引资源名称 name
   */
  public static final String FLD_NAME = "name";

  /**
   * 字段 name 资源名称
   */
  @org.nutz.dao.entity.annotation.Column("name")
  @cn.mapway.document.annotation.ApiField(value = "资源名称", example = "")
  public String name;
  /**
   * 字段索引模块参数 para
   */
  public static final String FLD_PARA = "para";

  /**
   * 字段 para 模块参数
   */
  @org.nutz.dao.entity.annotation.Column("para")
  @cn.mapway.document.annotation.ApiField(value = "模块参数", example = "")
  public String para;
  /**
   * 字段索引父ID pid
   */
  public static final String FLD_PID = "pid";

  /**
   * 字段 pid 父ID
   */
  @org.nutz.dao.entity.annotation.Column("pid")
  @cn.mapway.document.annotation.ApiField(value = "父ID", example = "")
  public Long pid;
  /**
   * 字段索引图标相对路径 icon
   */
  public static final String FLD_ICON = "icon";

  /**
   * 字段 icon 图标相对路径
   */
  @org.nutz.dao.entity.annotation.Column("icon")
  @cn.mapway.document.annotation.ApiField(value = "图标相对路径", example = "")
  public String icon;
  /**
   * 字段索引路径信息 path
   */
  public static final String FLD_PATH = "path";

  /**
   * 字段 path 路径信息
   */
  @org.nutz.dao.entity.annotation.Column("path")
  @cn.mapway.document.annotation.ApiField(value = "路径信息", example = "")
  public String path;
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
   * 字段索引资源说明 summary
   */
  public static final String FLD_SUMMARY = "summary";

  /**
   * 字段 summary 资源说明
   */
  @org.nutz.dao.entity.annotation.Column("summary")
  @cn.mapway.document.annotation.ApiField(value = "资源说明", example = "")
  public String summary;
  /**
   * 字段索引模块代码 code
   */
  public static final String FLD_CODE = "code";

  /**
   * 字段 code 模块代码
   */
  @org.nutz.dao.entity.annotation.Column("code")
  @cn.mapway.document.annotation.ApiField(value = "模块代码", example = "")
  public String code;
  /**
   * 字段索引CSS样式 style
   */
  public static final String FLD_STYLE = "style";

  /**
   * 字段 style CSS样式
   */
  @org.nutz.dao.entity.annotation.Column("style")
  @cn.mapway.document.annotation.ApiField(value = "CSS样式", example = "")
  public String style;
  /**
   * 字段索引点击次数 click
   */
  public static final String FLD_CLICK = "click";

  /**
   * 字段 click 点击次数
   */
  @org.nutz.dao.entity.annotation.Column("click")
  @cn.mapway.document.annotation.ApiField(value = "点击次数", example = "")
  public Long click;
  /**
   * 字段索引根ID rootid
   */
  public static final String FLD_ROOTID = "rootid";

  /**
   * 字段 rootid 根ID
   */
  @org.nutz.dao.entity.annotation.Column("rootid")
  @cn.mapway.document.annotation.ApiField(value = "根ID", example = "")
  public Long rootid;
  /**
   * 返回字段id 资源ID
   */
  public Long getId() {
    return this.id;
  }
  /**
   * 设置字段id 资源ID
   */
  public void setId(Long id) {
    this.id=id;
  }
  /**
   * 返回字段name 资源名称
   */
  public String getName() {
    return this.name;
  }
  /**
   * 设置字段name 资源名称
   */
  public void setName(String name) {
    this.name=name;
  }
  /**
   * 返回字段para 模块参数
   */
  public String getPara() {
    return this.para;
  }
  /**
   * 设置字段para 模块参数
   */
  public void setPara(String para) {
    this.para=para;
  }
  /**
   * 返回字段pid 父ID
   */
  public Long getPid() {
    return this.pid;
  }
  /**
   * 设置字段pid 父ID
   */
  public void setPid(Long pid) {
    this.pid=pid;
  }
  /**
   * 返回字段icon 图标相对路径
   */
  public String getIcon() {
    return this.icon;
  }
  /**
   * 设置字段icon 图标相对路径
   */
  public void setIcon(String icon) {
    this.icon=icon;
  }
  /**
   * 返回字段path 路径信息
   */
  public String getPath() {
    return this.path;
  }
  /**
   * 设置字段path 路径信息
   */
  public void setPath(String path) {
    this.path=path;
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
   * 返回字段summary 资源说明
   */
  public String getSummary() {
    return this.summary;
  }
  /**
   * 设置字段summary 资源说明
   */
  public void setSummary(String summary) {
    this.summary=summary;
  }
  /**
   * 返回字段code 模块代码
   */
  public String getCode() {
    return this.code;
  }
  /**
   * 设置字段code 模块代码
   */
  public void setCode(String code) {
    this.code=code;
  }
  /**
   * 返回字段style CSS样式
   */
  public String getStyle() {
    return this.style;
  }
  /**
   * 设置字段style CSS样式
   */
  public void setStyle(String style) {
    this.style=style;
  }
  /**
   * 返回字段click 点击次数
   */
  public Long getClick() {
    return this.click;
  }
  /**
   * 设置字段click 点击次数
   */
  public void setClick(Long click) {
    this.click=click;
  }
  /**
   * 返回字段rootid 根ID
   */
  public Long getRootid() {
    return this.rootid;
  }
  /**
   * 设置字段rootid 根ID
   */
  public void setRootid(Long rootid) {
    this.rootid=rootid;
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
   * 获取字para索引
   */
  public static final Integer IDX_PARA = 2;
  /**
   * 获取字pid索引
   */
  public static final Integer IDX_PID = 3;
  /**
   * 获取字icon索引
   */
  public static final Integer IDX_ICON = 4;
  /**
   * 获取字path索引
   */
  public static final Integer IDX_PATH = 5;
  /**
   * 获取字rank索引
   */
  public static final Integer IDX_RANK = 6;
  /**
   * 获取字summary索引
   */
  public static final Integer IDX_SUMMARY = 7;
  /**
   * 获取字code索引
   */
  public static final Integer IDX_CODE = 8;
  /**
   * 获取字style索引
   */
  public static final Integer IDX_STYLE = 9;
  /**
   * 获取字click索引
   */
  public static final Integer IDX_CLICK = 10;
  /**
   * 获取字rootid索引
   */
  public static final Integer IDX_ROOTID = 11;
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
      if (FLD_PARA.equals(fieldName)) {
        return this.para;
      }
      if (FLD_PID.equals(fieldName)) {
        return this.pid;
      }
      if (FLD_ICON.equals(fieldName)) {
        return this.icon;
      }
      if (FLD_PATH.equals(fieldName)) {
        return this.path;
      }
      if (FLD_RANK.equals(fieldName)) {
        return this.rank;
      }
      if (FLD_SUMMARY.equals(fieldName)) {
        return this.summary;
      }
      if (FLD_CODE.equals(fieldName)) {
        return this.code;
      }
      if (FLD_STYLE.equals(fieldName)) {
        return this.style;
      }
      if (FLD_CLICK.equals(fieldName)) {
        return this.click;
      }
      if (FLD_ROOTID.equals(fieldName)) {
        return this.rootid;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 12) {
      if (fieldIndex == 0) {
        return this.id;
      }
      if (fieldIndex == 1) {
        return this.name;
      }
      if (fieldIndex == 2) {
        return this.para;
      }
      if (fieldIndex == 3) {
        return this.pid;
      }
      if (fieldIndex == 4) {
        return this.icon;
      }
      if (fieldIndex == 5) {
        return this.path;
      }
      if (fieldIndex == 6) {
        return this.rank;
      }
      if (fieldIndex == 7) {
        return this.summary;
      }
      if (fieldIndex == 8) {
        return this.code;
      }
      if (fieldIndex == 9) {
        return this.style;
      }
      if (fieldIndex == 10) {
        return this.click;
      }
      if (fieldIndex == 11) {
        return this.rootid;
      }
    } else {
      return null;
    }
    return null;
  }
}
