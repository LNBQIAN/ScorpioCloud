package store.wangyan.web.service;


import store.wangyan.web.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author GAOKUN
 * @since 2020-08-04
 */
public interface ISysUserService  {

    List<SysUser> getList();
}
