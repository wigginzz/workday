package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 数据库表-用户表
 */
@org.nutz.dao.entity.annotation.Table("s_user")
@cn.mapway.document.annotation.Doc("s_user 用户表")
public final class S_USERObj
    implements com.google.gwt.user.client.rpc.IsSerializable, com.ksyzt.gwt.client.data.IFieldValue {
  /**
   * 表用户表代码名称
   */
  public static final String TBL_S_USER = "s_user";
  public S_USERObj() {
  }
  /**
   * 字段索引用户ID id
   */
  public static final String FLD_ID = "id";

  /**
   * 字段 id 用户ID
   */
  @org.nutz.dao.entity.annotation.Id
  @cn.mapway.document.annotation.ApiField(value = "用户ID", example = "")
  public Long id;
  /**
   * 字段索引 account_type
   */
  public static final String FLD_ACCOUNT_TYPE = "account_type";

  /**
   * 字段 account_type 
   */
  @org.nutz.dao.entity.annotation.Column("account_type")
  @cn.mapway.document.annotation.ApiField(value = "account_type", example = "")
  public String accountType;
  /**
   * 字段索引 hash
   */
  public static final String FLD_HASH = "hash";

  /**
   * 字段 hash 
   */
  @org.nutz.dao.entity.annotation.Column("hash")
  @cn.mapway.document.annotation.ApiField(value = "hash", example = "")
  public String hash;
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
   * 字段索引 pwd
   */
  public static final String FLD_PWD = "pwd";

  /**
   * 字段 pwd 
   */
  @org.nutz.dao.entity.annotation.Column("pwd")
  @cn.mapway.document.annotation.ApiField(value = "pwd", example = "")
  public String pwd;
  /**
   * 字段索引 real_name
   */
  public static final String FLD_REAL_NAME = "real_name";

  /**
   * 字段 real_name 
   */
  @org.nutz.dao.entity.annotation.Column("real_name")
  @cn.mapway.document.annotation.ApiField(value = "real_name", example = "")
  public String realName;
  /**
   * 字段索引 avator
   */
  public static final String FLD_AVATOR = "avator";

  /**
   * 字段 avator 
   */
  @org.nutz.dao.entity.annotation.Column("avator")
  @cn.mapway.document.annotation.ApiField(value = "avator", example = "")
  public String avator;
  /**
   * 字段索引性别 gender
   */
  public static final String FLD_GENDER = "gender";

  /**
   * 字段 gender 性别
   */
  @org.nutz.dao.entity.annotation.Column("gender")
  @cn.mapway.document.annotation.ApiField(value = "性别", example = "")
  public String gender;
  /**
   * 字段索引 email
   */
  public static final String FLD_EMAIL = "email";

  /**
   * 字段 email 
   */
  @org.nutz.dao.entity.annotation.Column("email")
  @cn.mapway.document.annotation.ApiField(value = "email", example = "")
  public String email;
  /**
   * 字段索引 mobile
   */
  public static final String FLD_MOBILE = "mobile";

  /**
   * 字段 mobile 
   */
  @org.nutz.dao.entity.annotation.Column("mobile")
  @cn.mapway.document.annotation.ApiField(value = "mobile", example = "")
  public String mobile;
  /**
   * 字段索引 title
   */
  public static final String FLD_TITLE = "title";

  /**
   * 字段 title 
   */
  @org.nutz.dao.entity.annotation.Column("title")
  @cn.mapway.document.annotation.ApiField(value = "title", example = "")
  public String title;
  /**
   * 字段索引 token
   */
  public static final String FLD_TOKEN = "token";

  /**
   * 字段 token 
   */
  @org.nutz.dao.entity.annotation.Column("token")
  @cn.mapway.document.annotation.ApiField(value = "token", example = "")
  public String token;
  /**
   * 字段索引 create_time
   */
  public static final String FLD_CREATE_TIME = "create_time";

  /**
   * 字段 create_time 
   */
  @org.nutz.dao.entity.annotation.Column("create_time")
  @cn.mapway.document.annotation.ApiField(value = "create_time", example = "")
  public Timestamp createTime;
  /**
   * 字段索引 update_time
   */
  public static final String FLD_UPDATE_TIME = "update_time";

  /**
   * 字段 update_time 
   */
  @org.nutz.dao.entity.annotation.Column("update_time")
  @cn.mapway.document.annotation.ApiField(value = "update_time", example = "")
  public Timestamp updateTime;
  /**
   * 字段索引 is_send_message
   */
  public static final String FLD_IS_SEND_MESSAGE = "is_send_message";

  /**
   * 字段 is_send_message 
   */
  @org.nutz.dao.entity.annotation.Column("is_send_message")
  @cn.mapway.document.annotation.ApiField(value = "is_send_message", example = "")
  public Integer isSendMessage;
  /**
   * 字段索引 enabled
   */
  public static final String FLD_ENABLED = "enabled";

  /**
   * 字段 enabled 
   */
  @org.nutz.dao.entity.annotation.Column("enabled")
  @cn.mapway.document.annotation.ApiField(value = "enabled", example = "")
  public Integer enabled;
  /**
   * 字段索引 disabled_msg
   */
  public static final String FLD_DISABLED_MSG = "disabled_msg";

  /**
   * 字段 disabled_msg 
   */
  @org.nutz.dao.entity.annotation.Column("disabled_msg")
  @cn.mapway.document.annotation.ApiField(value = "disabled_msg", example = "")
  public String disabledMsg;
  /**
   * 字段索引 recommend_code
   */
  public static final String FLD_RECOMMEND_CODE = "recommend_code";

  /**
   * 字段 recommend_code 
   */
  @org.nutz.dao.entity.annotation.Column("recommend_code")
  @cn.mapway.document.annotation.ApiField(value = "recommend_code", example = "")
  public String recommendCode;
  /**
   * 字段索引最后登录时间 last_time
   */
  public static final String FLD_LAST_TIME = "last_time";

  /**
   * 字段 last_time 最后登录时间
   */
  @org.nutz.dao.entity.annotation.Column("last_time")
  @cn.mapway.document.annotation.ApiField(value = "最后登录时间", example = "")
  public Timestamp lastTime;
  /**
   * 字段索引用户类型 user_type
   */
  public static final String FLD_USER_TYPE = "user_type";

  /**
   * 字段 user_type 用户类型
   */
  @org.nutz.dao.entity.annotation.Column("user_type")
  @cn.mapway.document.annotation.ApiField(value = "用户类型", example = "")
  public String userType;
  /**
   * 字段索引用户标识 user_identities
   */
  public static final String FLD_USER_IDENTITIES = "user_identities";

  /**
   * 字段 user_identities 用户标识
   */
  @org.nutz.dao.entity.annotation.Column("user_identities")
  @cn.mapway.document.annotation.ApiField(value = "用户标识", example = "")
  public String userIdentities;
  /**
   * 返回字段id 用户ID
   */
  public Long getId() {
    return this.id;
  }
  /**
   * 设置字段id 用户ID
   */
  public void setId(Long id) {
    this.id=id;
  }
  /**
   * 返回字段account_type 
   */
  public String getAccountType() {
    return this.accountType;
  }
  /**
   * 设置字段account_type 
   */
  public void setAccountType(String accountType) {
    this.accountType=accountType;
  }
  /**
   * 返回字段hash 
   */
  public String getHash() {
    return this.hash;
  }
  /**
   * 设置字段hash 
   */
  public void setHash(String hash) {
    this.hash=hash;
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
   * 返回字段pwd 
   */
  public String getPwd() {
    return this.pwd;
  }
  /**
   * 设置字段pwd 
   */
  public void setPwd(String pwd) {
    this.pwd=pwd;
  }
  /**
   * 返回字段real_name 
   */
  public String getRealName() {
    return this.realName;
  }
  /**
   * 设置字段real_name 
   */
  public void setRealName(String realName) {
    this.realName=realName;
  }
  /**
   * 返回字段avator 
   */
  public String getAvator() {
    return this.avator;
  }
  /**
   * 设置字段avator 
   */
  public void setAvator(String avator) {
    this.avator=avator;
  }
  /**
   * 返回字段gender 性别
   */
  public String getGender() {
    return this.gender;
  }
  /**
   * 设置字段gender 性别
   */
  public void setGender(String gender) {
    this.gender=gender;
  }
  /**
   * 返回字段email 
   */
  public String getEmail() {
    return this.email;
  }
  /**
   * 设置字段email 
   */
  public void setEmail(String email) {
    this.email=email;
  }
  /**
   * 返回字段mobile 
   */
  public String getMobile() {
    return this.mobile;
  }
  /**
   * 设置字段mobile 
   */
  public void setMobile(String mobile) {
    this.mobile=mobile;
  }
  /**
   * 返回字段title 
   */
  public String getTitle() {
    return this.title;
  }
  /**
   * 设置字段title 
   */
  public void setTitle(String title) {
    this.title=title;
  }
  /**
   * 返回字段token 
   */
  public String getToken() {
    return this.token;
  }
  /**
   * 设置字段token 
   */
  public void setToken(String token) {
    this.token=token;
  }
  /**
   * 返回字段create_time 
   */
  public Timestamp getCreateTime() {
    return this.createTime;
  }
  /**
   * 设置字段create_time 
   */
  public void setCreateTime(Timestamp createTime) {
    this.createTime=createTime;
  }
  /**
   * 返回字段update_time 
   */
  public Timestamp getUpdateTime() {
    return this.updateTime;
  }
  /**
   * 设置字段update_time 
   */
  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime=updateTime;
  }
  /**
   * 返回字段is_send_message 
   */
  public Integer getIsSendMessage() {
    return this.isSendMessage;
  }
  /**
   * 设置字段is_send_message 
   */
  public void setIsSendMessage(Integer isSendMessage) {
    this.isSendMessage=isSendMessage;
  }
  /**
   * 返回字段enabled 
   */
  public Integer getEnabled() {
    return this.enabled;
  }
  /**
   * 设置字段enabled 
   */
  public void setEnabled(Integer enabled) {
    this.enabled=enabled;
  }
  /**
   * 返回字段disabled_msg 
   */
  public String getDisabledMsg() {
    return this.disabledMsg;
  }
  /**
   * 设置字段disabled_msg 
   */
  public void setDisabledMsg(String disabledMsg) {
    this.disabledMsg=disabledMsg;
  }
  /**
   * 返回字段recommend_code 
   */
  public String getRecommendCode() {
    return this.recommendCode;
  }
  /**
   * 设置字段recommend_code 
   */
  public void setRecommendCode(String recommendCode) {
    this.recommendCode=recommendCode;
  }
  /**
   * 返回字段last_time 最后登录时间
   */
  public Timestamp getLastTime() {
    return this.lastTime;
  }
  /**
   * 设置字段last_time 最后登录时间
   */
  public void setLastTime(Timestamp lastTime) {
    this.lastTime=lastTime;
  }
  /**
   * 返回字段user_type 用户类型
   */
  public String getUserType() {
    return this.userType;
  }
  /**
   * 设置字段user_type 用户类型
   */
  public void setUserType(String userType) {
    this.userType=userType;
  }
  /**
   * 返回字段user_identities 用户标识
   */
  public String getUserIdentities() {
    return this.userIdentities;
  }
  /**
   * 设置字段user_identities 用户标识
   */
  public void setUserIdentities(String userIdentities) {
    this.userIdentities=userIdentities;
  }
  /**
   * 获取字id索引
   */
  public static final Integer IDX_ID = 0;
  /**
   * 获取字account_type索引
   */
  public static final Integer IDX_ACCOUNT_TYPE = 1;
  /**
   * 获取字hash索引
   */
  public static final Integer IDX_HASH = 2;
  /**
   * 获取字name索引
   */
  public static final Integer IDX_NAME = 3;
  /**
   * 获取字pwd索引
   */
  public static final Integer IDX_PWD = 4;
  /**
   * 获取字real_name索引
   */
  public static final Integer IDX_REAL_NAME = 5;
  /**
   * 获取字avator索引
   */
  public static final Integer IDX_AVATOR = 6;
  /**
   * 获取字gender索引
   */
  public static final Integer IDX_GENDER = 7;
  /**
   * 获取字email索引
   */
  public static final Integer IDX_EMAIL = 8;
  /**
   * 获取字mobile索引
   */
  public static final Integer IDX_MOBILE = 9;
  /**
   * 获取字title索引
   */
  public static final Integer IDX_TITLE = 10;
  /**
   * 获取字token索引
   */
  public static final Integer IDX_TOKEN = 11;
  /**
   * 获取字create_time索引
   */
  public static final Integer IDX_CREATE_TIME = 12;
  /**
   * 获取字update_time索引
   */
  public static final Integer IDX_UPDATE_TIME = 13;
  /**
   * 获取字is_send_message索引
   */
  public static final Integer IDX_IS_SEND_MESSAGE = 14;
  /**
   * 获取字enabled索引
   */
  public static final Integer IDX_ENABLED = 15;
  /**
   * 获取字disabled_msg索引
   */
  public static final Integer IDX_DISABLED_MSG = 16;
  /**
   * 获取字recommend_code索引
   */
  public static final Integer IDX_RECOMMEND_CODE = 17;
  /**
   * 获取字last_time索引
   */
  public static final Integer IDX_LAST_TIME = 18;
  /**
   * 获取字user_type索引
   */
  public static final Integer IDX_USER_TYPE = 19;
  /**
   * 获取字user_identities索引
   */
  public static final Integer IDX_USER_IDENTITIES = 20;
  /**
   * 根据字段名称获取字段的.
   */
  @Override
  public Object getFieldValue(String fieldName, Integer fieldIndex) {
    if (fieldName != null && fieldName.length() > 0) {
      if (FLD_ID.equals(fieldName)) {
        return this.id;
      }
      if (FLD_ACCOUNT_TYPE.equals(fieldName)) {
        return this.accountType;
      }
      if (FLD_HASH.equals(fieldName)) {
        return this.hash;
      }
      if (FLD_NAME.equals(fieldName)) {
        return this.name;
      }
      if (FLD_PWD.equals(fieldName)) {
        return this.pwd;
      }
      if (FLD_REAL_NAME.equals(fieldName)) {
        return this.realName;
      }
      if (FLD_AVATOR.equals(fieldName)) {
        return this.avator;
      }
      if (FLD_GENDER.equals(fieldName)) {
        return this.gender;
      }
      if (FLD_EMAIL.equals(fieldName)) {
        return this.email;
      }
      if (FLD_MOBILE.equals(fieldName)) {
        return this.mobile;
      }
      if (FLD_TITLE.equals(fieldName)) {
        return this.title;
      }
      if (FLD_TOKEN.equals(fieldName)) {
        return this.token;
      }
      if (FLD_CREATE_TIME.equals(fieldName)) {
        return this.createTime;
      }
      if (FLD_UPDATE_TIME.equals(fieldName)) {
        return this.updateTime;
      }
      if (FLD_IS_SEND_MESSAGE.equals(fieldName)) {
        return this.isSendMessage;
      }
      if (FLD_ENABLED.equals(fieldName)) {
        return this.enabled;
      }
      if (FLD_DISABLED_MSG.equals(fieldName)) {
        return this.disabledMsg;
      }
      if (FLD_RECOMMEND_CODE.equals(fieldName)) {
        return this.recommendCode;
      }
      if (FLD_LAST_TIME.equals(fieldName)) {
        return this.lastTime;
      }
      if (FLD_USER_TYPE.equals(fieldName)) {
        return this.userType;
      }
      if (FLD_USER_IDENTITIES.equals(fieldName)) {
        return this.userIdentities;
      }
    } else if (fieldIndex != null && fieldIndex >= 0 && fieldIndex < 21) {
      if (fieldIndex == 0) {
        return this.id;
      }
      if (fieldIndex == 1) {
        return this.accountType;
      }
      if (fieldIndex == 2) {
        return this.hash;
      }
      if (fieldIndex == 3) {
        return this.name;
      }
      if (fieldIndex == 4) {
        return this.pwd;
      }
      if (fieldIndex == 5) {
        return this.realName;
      }
      if (fieldIndex == 6) {
        return this.avator;
      }
      if (fieldIndex == 7) {
        return this.gender;
      }
      if (fieldIndex == 8) {
        return this.email;
      }
      if (fieldIndex == 9) {
        return this.mobile;
      }
      if (fieldIndex == 10) {
        return this.title;
      }
      if (fieldIndex == 11) {
        return this.token;
      }
      if (fieldIndex == 12) {
        return this.createTime;
      }
      if (fieldIndex == 13) {
        return this.updateTime;
      }
      if (fieldIndex == 14) {
        return this.isSendMessage;
      }
      if (fieldIndex == 15) {
        return this.enabled;
      }
      if (fieldIndex == 16) {
        return this.disabledMsg;
      }
      if (fieldIndex == 17) {
        return this.recommendCode;
      }
      if (fieldIndex == 18) {
        return this.lastTime;
      }
      if (fieldIndex == 19) {
        return this.userType;
      }
      if (fieldIndex == 20) {
        return this.userIdentities;
      }
    } else {
      return null;
    }
    return null;
  }
}
