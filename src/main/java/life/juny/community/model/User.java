package life.juny.community.model;

/**
 * @Description TODO
 * @Author Juny
 * @Date 2021/7/18 22:20
 * @Version 1.0
 */
public class User {
  private Long id;
  private String accountId;
  private String name;
  private String token;
  private String bio;
  private Long gmtCreate;
  private Long gmtModified;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public Long getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(Long gmtCreate) {
    this.gmtCreate = gmtCreate;
  }

  public Long getGmtModified() {
    return gmtModified;
  }

  public void setGmtModified(Long gmtModified) {
    this.gmtModified = gmtModified;
  }
}
