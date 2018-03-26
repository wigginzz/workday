package cn.mapway.workday.ui.shared.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ���ݿ��-�û���
 */
@org.nutz.dao.entity.annotation.Table("s_user")
@cn.mapway.document.annotation.Doc("s_user �û���")
public final class S_USERObj {
  /**
   * ���û����������
   */
  public static final String TBL_S_USER = "s_user";
  public S_USERObj() {
  }
  /**
   * �ֶ������û�ID id
   */
  public static final String FLD_ID = "id";

  /**
   * �ֶ� id �û�ID
   */
  @org.nutz.dao.entity.annotation.Id
  @cn.mapway.document.annotation.ApiField(value = "�û�ID", example = "")
  public Long id;
  /**
   * �ֶ����� account_type
   */
  public static final String FLD_ACCOUNT_TYPE = "account_type";

  /**
   * �ֶ� account_type 
   */
  @org.nutz.dao.entity.annotation.Column("account_type")
  @cn.mapway.document.annotation.ApiField(value = "account_type", example = "")
  public String accountType;
  /**
   * �ֶ����� hash
   */
  public static final String FLD_HASH = "hash";

  /**
   * �ֶ� hash 
   */
  @org.nutz.dao.entity.annotation.Column("hash")
  @cn.mapway.document.annotation.ApiField(value = "hash", example = "")
  public String hash;
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
   * �ֶ����� pwd
   */
  public static final String FLD_PWD = "pwd";

  /**
   * �ֶ� pwd 
   */
  @org.nutz.dao.entity.annotation.Column("pwd")
  @cn.mapway.document.annotation.ApiField(value = "pwd", example = "")
  public String pwd;
  /**
   * �ֶ����� real_name
   */
  public static final String FLD_REAL_NAME = "real_name";

  /**
   * �ֶ� real_name 
   */
  @org.nutz.dao.entity.annotation.Column("real_name")
  @cn.mapway.document.annotation.ApiField(value = "real_name", example = "")
  public String realName;
  /**
   * �ֶ����� avator
   */
  public static final String FLD_AVATOR = "avator";

  /**
   * �ֶ� avator 
   */
  @org.nutz.dao.entity.annotation.Column("avator")
  @cn.mapway.document.annotation.ApiField(value = "avator", example = "")
  public String avator;
  /**
   * �ֶ������Ա� gender
   */
  public static final String FLD_GENDER = "gender";

  /**
   * �ֶ� gender �Ա�
   */
  @org.nutz.dao.entity.annotation.Column("gender")
  @cn.mapway.document.annotation.ApiField(value = "�Ա�", example = "")
  public String gender;
  /**
   * �ֶ����� email
   */
  public static final String FLD_EMAIL = "email";

  /**
   * �ֶ� email 
   */
  @org.nutz.dao.entity.annotation.Column("email")
  @cn.mapway.document.annotation.ApiField(value = "email", example = "")
  public String email;
  /**
   * �ֶ����� mobile
   */
  public static final String FLD_MOBILE = "mobile";

  /**
   * �ֶ� mobile 
   */
  @org.nutz.dao.entity.annotation.Column("mobile")
  @cn.mapway.document.annotation.ApiField(value = "mobile", example = "")
  public String mobile;
  /**
   * �ֶ����� title
   */
  public static final String FLD_TITLE = "title";

  /**
   * �ֶ� title 
   */
  @org.nutz.dao.entity.annotation.Column("title")
  @cn.mapway.document.annotation.ApiField(value = "title", example = "")
  public String title;
  /**
   * �ֶ����� token
   */
  public static final String FLD_TOKEN = "token";

  /**
   * �ֶ� token 
   */
  @org.nutz.dao.entity.annotation.Column("token")
  @cn.mapway.document.annotation.ApiField(value = "token", example = "")
  public String token;
  /**
   * �ֶ����� create_time
   */
  public static final String FLD_CREATE_TIME = "create_time";

  /**
   * �ֶ� create_time 
   */
  @org.nutz.dao.entity.annotation.Column("create_time")
  @cn.mapway.document.annotation.ApiField(value = "create_time", example = "")
  public Timestamp createTime;
  /**
   * �ֶ����� update_time
   */
  public static final String FLD_UPDATE_TIME = "update_time";

  /**
   * �ֶ� update_time 
   */
  @org.nutz.dao.entity.annotation.Column("update_time")
  @cn.mapway.document.annotation.ApiField(value = "update_time", example = "")
  public Timestamp updateTime;
  /**
   * �ֶ����� is_send_message
   */
  public static final String FLD_IS_SEND_MESSAGE = "is_send_message";

  /**
   * �ֶ� is_send_message 
   */
  @org.nutz.dao.entity.annotation.Column("is_send_message")
  @cn.mapway.document.annotation.ApiField(value = "is_send_message", example = "")
  public Integer isSendMessage;
  /**
   * �ֶ����� enabled
   */
  public static final String FLD_ENABLED = "enabled";

  /**
   * �ֶ� enabled 
   */
  @org.nutz.dao.entity.annotation.Column("enabled")
  @cn.mapway.document.annotation.ApiField(value = "enabled", example = "")
  public Integer enabled;
  /**
   * �ֶ����� disabled_msg
   */
  public static final String FLD_DISABLED_MSG = "disabled_msg";

  /**
   * �ֶ� disabled_msg 
   */
  @org.nutz.dao.entity.annotation.Column("disabled_msg")
  @cn.mapway.document.annotation.ApiField(value = "disabled_msg", example = "")
  public String disabledMsg;
  /**
   * �ֶ����� recommend_code
   */
  public static final String FLD_RECOMMEND_CODE = "recommend_code";

  /**
   * �ֶ� recommend_code 
   */
  @org.nutz.dao.entity.annotation.Column("recommend_code")
  @cn.mapway.document.annotation.ApiField(value = "recommend_code", example = "")
  public String recommendCode;
  /**
   * �ֶ���������¼ʱ�� last_time
   */
  public static final String FLD_LAST_TIME = "last_time";

  /**
   * �ֶ� last_time ����¼ʱ��
   */
  @org.nutz.dao.entity.annotation.Column("last_time")
  @cn.mapway.document.annotation.ApiField(value = "����¼ʱ��", example = "")
  public Timestamp lastTime;
  /**
   * �ֶ������û����� user_type
   */
  public static final String FLD_USER_TYPE = "user_type";

  /**
   * �ֶ� user_type �û�����
   */
  @org.nutz.dao.entity.annotation.Column("user_type")
  @cn.mapway.document.annotation.ApiField(value = "�û�����", example = "")
  public String userType;
  /**
   * �ֶ������û���ʶ user_identities
   */
  public static final String FLD_USER_IDENTITIES = "user_identities";

  /**
   * �ֶ� user_identities �û���ʶ
   */
  @org.nutz.dao.entity.annotation.Column("user_identities")
  @cn.mapway.document.annotation.ApiField(value = "�û���ʶ", example = "")
  public String userIdentities;
  /**
   * �����ֶ�id �û�ID
   */
  public Long getId() {
    return this.id;
  }
  /**
   * �����ֶ�id �û�ID
   */
  public void setId(Long id) {
    this.id=id;
  }
  /**
   * �����ֶ�account_type 
   */
  public String getAccountType() {
    return this.accountType;
  }
  /**
   * �����ֶ�account_type 
   */
  public void setAccountType(String accountType) {
    this.accountType=accountType;
  }
  /**
   * �����ֶ�hash 
   */
  public String getHash() {
    return this.hash;
  }
  /**
   * �����ֶ�hash 
   */
  public void setHash(String hash) {
    this.hash=hash;
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
   * �����ֶ�pwd 
   */
  public String getPwd() {
    return this.pwd;
  }
  /**
   * �����ֶ�pwd 
   */
  public void setPwd(String pwd) {
    this.pwd=pwd;
  }
  /**
   * �����ֶ�real_name 
   */
  public String getRealName() {
    return this.realName;
  }
  /**
   * �����ֶ�real_name 
   */
  public void setRealName(String realName) {
    this.realName=realName;
  }
  /**
   * �����ֶ�avator 
   */
  public String getAvator() {
    return this.avator;
  }
  /**
   * �����ֶ�avator 
   */
  public void setAvator(String avator) {
    this.avator=avator;
  }
  /**
   * �����ֶ�gender �Ա�
   */
  public String getGender() {
    return this.gender;
  }
  /**
   * �����ֶ�gender �Ա�
   */
  public void setGender(String gender) {
    this.gender=gender;
  }
  /**
   * �����ֶ�email 
   */
  public String getEmail() {
    return this.email;
  }
  /**
   * �����ֶ�email 
   */
  public void setEmail(String email) {
    this.email=email;
  }
  /**
   * �����ֶ�mobile 
   */
  public String getMobile() {
    return this.mobile;
  }
  /**
   * �����ֶ�mobile 
   */
  public void setMobile(String mobile) {
    this.mobile=mobile;
  }
  /**
   * �����ֶ�title 
   */
  public String getTitle() {
    return this.title;
  }
  /**
   * �����ֶ�title 
   */
  public void setTitle(String title) {
    this.title=title;
  }
  /**
   * �����ֶ�token 
   */
  public String getToken() {
    return this.token;
  }
  /**
   * �����ֶ�token 
   */
  public void setToken(String token) {
    this.token=token;
  }
  /**
   * �����ֶ�create_time 
   */
  public Timestamp getCreateTime() {
    return this.createTime;
  }
  /**
   * �����ֶ�create_time 
   */
  public void setCreateTime(Timestamp createTime) {
    this.createTime=createTime;
  }
  /**
   * �����ֶ�update_time 
   */
  public Timestamp getUpdateTime() {
    return this.updateTime;
  }
  /**
   * �����ֶ�update_time 
   */
  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime=updateTime;
  }
  /**
   * �����ֶ�is_send_message 
   */
  public Integer getIsSendMessage() {
    return this.isSendMessage;
  }
  /**
   * �����ֶ�is_send_message 
   */
  public void setIsSendMessage(Integer isSendMessage) {
    this.isSendMessage=isSendMessage;
  }
  /**
   * �����ֶ�enabled 
   */
  public Integer getEnabled() {
    return this.enabled;
  }
  /**
   * �����ֶ�enabled 
   */
  public void setEnabled(Integer enabled) {
    this.enabled=enabled;
  }
  /**
   * �����ֶ�disabled_msg 
   */
  public String getDisabledMsg() {
    return this.disabledMsg;
  }
  /**
   * �����ֶ�disabled_msg 
   */
  public void setDisabledMsg(String disabledMsg) {
    this.disabledMsg=disabledMsg;
  }
  /**
   * �����ֶ�recommend_code 
   */
  public String getRecommendCode() {
    return this.recommendCode;
  }
  /**
   * �����ֶ�recommend_code 
   */
  public void setRecommendCode(String recommendCode) {
    this.recommendCode=recommendCode;
  }
  /**
   * �����ֶ�last_time ����¼ʱ��
   */
  public Timestamp getLastTime() {
    return this.lastTime;
  }
  /**
   * �����ֶ�last_time ����¼ʱ��
   */
  public void setLastTime(Timestamp lastTime) {
    this.lastTime=lastTime;
  }
  /**
   * �����ֶ�user_type �û�����
   */
  public String getUserType() {
    return this.userType;
  }
  /**
   * �����ֶ�user_type �û�����
   */
  public void setUserType(String userType) {
    this.userType=userType;
  }
  /**
   * �����ֶ�user_identities �û���ʶ
   */
  public String getUserIdentities() {
    return this.userIdentities;
  }
  /**
   * �����ֶ�user_identities �û���ʶ
   */
  public void setUserIdentities(String userIdentities) {
    this.userIdentities=userIdentities;
  }
}
