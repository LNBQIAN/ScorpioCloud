package store.wangyan.web.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="登录")
@RestController
public class LoginController {

    @GetMapping("/login")
    public String Login(){
        return "aaaaaa";
    }
}
