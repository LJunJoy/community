package life.juny.community.controller.auth;

import life.juny.community.dto.AccessTokenDTO;
import life.juny.community.dto.GithubUserDTO;
import life.juny.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 登录授权管理
 * @Author Juny
 * @Date 2021/7/18 11:11
 * @Version 1.0
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

  @Value("${github.client.id}")
  String client_id;

  @Value("${github.client.secret}")
  String client_secret;

  @Autowired
  GithubProvider githubProvider;

  @GetMapping("/callback")
  public String loginCallback(
      @RequestParam("code") String code,
      @RequestParam("state") String state) {
    AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
    accessTokenDTO.setClient_id(client_id);
    accessTokenDTO.setClient_secret(client_secret);
    accessTokenDTO.setCode(code);
    String accessToken = githubProvider.getAccessToken(accessTokenDTO);
    GithubUserDTO user = githubProvider.getUser(accessToken);
    System.out.println(user);
    return "index";
  }
}
