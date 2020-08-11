package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};

<#if cfg.customPageMaps>
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
</#if>

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

<#if cfg.customPageMaps>
	/**
     * 根据 Wrapper 条件，查询全部记录（并翻页）
     *
     * @param page         分页查询条件
     * @param queryWrapper 实体对象封装操作类
     */
	@Select("SELECT * FROM ${table.name?upper_case} <#noparse>${</#noparse>ew.customSqlSegment}")
    IPage<Map<String, Object>> customSelectMapsPage(IPage<${entity}> page, @Param(Constants.WRAPPER) Wrapper<${entity}> queryWrapper);
</#if>
}
</#if>
