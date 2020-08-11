package ${package.Service};

import com.fullsee.besp.fibreoptical.common.service.IBaseService;
import ${package.Entity}.${entity};

<#if cfg.customPageMaps>
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
</#if>
/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : IBaseService<${entity}>
<#else>
public interface ${table.serviceName} extends IBaseService<${entity}> {

<#if cfg.customPageMaps>
	/**
     * 自定义翻页查询
     *
     * @param page         翻页对象
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    IPage<Map<String, Object>> customPageMaps(IPage<${entity}> page, Wrapper<${entity}> queryWrapper);
</#if>

}
</#if>
