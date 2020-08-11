package store.wangyan.web.controller;
 

import com.baomidou.mybatisplus.extension.api.ApiController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import store.wangyan.web.entity.SysUser;
import store.wangyan.web.service.ISysUserService;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author GAOKUN
 * @since 2020-08-04
 * @version v1.0
 */
@Api(tags="用户管理")
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends ApiController {

    @Autowired
    private ISysUserService sysUserService;

    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping("/getList")
    public List<SysUser> getList(){
        List<SysUser> list =   sysUserService.getList();
        return list;
    }
}
