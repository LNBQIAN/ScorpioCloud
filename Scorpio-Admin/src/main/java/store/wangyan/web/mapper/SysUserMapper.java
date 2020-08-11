package store.wangyan.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import store.wangyan.web.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author GAOKUN
 * @since 2020-08-04
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select("select * from sys_user")
    List<SysUser> getList();
}
