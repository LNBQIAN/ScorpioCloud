package ${package.ServiceImpl};

import com.fullsee.besp.fibreoptical.common.service.ValidateRule;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
<#if cfg.customPageMaps>
import com.baomidou.mybatisplus.core.metadata.IPage;
</#if>

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
	
	@Autowired
    protected ${entity}Mapper ${entity?uncap_first}Mapper;
<#if cfg.customPageMaps>

	@Override
	public IPage<Map<String, Object>> customPageMaps(IPage<${entity}> page, Wrapper<${entity}> queryWrapper) {
		return ${entity?uncap_first}Mapper.customSelectMapsPage(page, queryWrapper);
	}
</#if>

	/**
	 * 自定义获取查询条件构造器
	 */
	public Wrapper<${entity}> getQueryWrapper(Map<String, Object> params) {
		return null;
	}
	
	@Override
	public Map<String, List<ValidateRule>> getInsertValidateRules()  {
		return null;
	}

	@Override
	public Map<String, List<ValidateRule>> getUpdateValidateRules() {
		return null;
	}

}
</#if>
