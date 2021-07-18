package life.juny.community.dto;

/**
 * @Description TODO
 * @Author Juny
 * @Date 2021/7/18 18:32
 * @Version 1.0
 */
public class GithubUserDTO {
  private Long id;
  private String url;
  private String name;
  private String bio;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  @Override
  public String toString() {
    return "GithubUserDTO{" +
        "id='" + id + '\'' +
        ", url='" + url + '\'' +
        ", name='" + name + '\'' +
        ", bio='" + bio + '\'' +
        '}';
  }
}
