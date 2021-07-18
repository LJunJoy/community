package life.juny.community.provider;

import com.alibaba.fastjson.JSON;
import life.juny.community.dto.AccessTokenDTO;
import life.juny.community.dto.GithubUserDTO;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Description TODO
 * @Author Juny
 * @Date 2021/7/18 11:34
 * @Version 1.0
 */
@Component
public class GithubProvider {
  @Value("${github.token.url}")
  String tokenUrl;

  @Value("${github.userinfo.url}")
  String userUrl;

  private static final MediaType JSONType = MediaType.parse("application/json; charset=utf-8");
  private OkHttpClient client = new OkHttpClient();

  public String getAccessToken(AccessTokenDTO accessTokenDTO) {
    RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO), JSONType);
    Request request = new Request.Builder()
        .url(tokenUrl)
        .post(body)
        .build();
    final Call call = client.newCall(request);
    try (Response response = call.execute();) {
      String result = response.body().string();
      return parseAccessToken(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public String parseAccessToken(String token) {
    String[] kvs = token.split("&");
    for (String kv : kvs) {
      if (kv.contains("access_token=")) {
        return kv.split("=")[1];
      }
    }
    return null;
  }

  public GithubUserDTO getUser(String token) {
    Request request = new Request.Builder()
        .url(userUrl)
        .header("Authorization", "token " + token)
        .build();
    final Call call = client.newCall(request);
    try (Response response = call.execute();) {
      String result = response.body().string();
      return JSON.parseObject(result, GithubUserDTO.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
