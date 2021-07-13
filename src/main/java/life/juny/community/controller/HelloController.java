package life.juny.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description TODO
 * @Author Juny
 * @Date 2021/7/11 18:52
 * @Version 1.0
 */
@Controller
public class HelloController {

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/greeting")
  public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    model.addAttribute("name", name);
    return "greeting";
  }
}
