package ${package.Controller};
 
 
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
<#if cfg.customPageMaps>
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

</#if>
 
/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 * @version v1.0
 */
<#if restControllerStyle>
@Api(tags = {"${table.comment!}"})
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass}<${entity}> {
    <#else>
public class ${table.controllerName} {
    </#if>
    
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};
 
<#if cfg.customPageMaps>
    /**
	 * 自定义查询方法
	 */
	public ResponseEntity<Result> query(@RequestParam Map<String,Object> params,${entity} entity) {
		try {
			//优先使用自定义查询条件构造器
			Wrapper<${entity}> queryWrapper = ${(table.serviceName?substring(1))?uncap_first}.getQueryWrapper(params);
			if (queryWrapper == null) {
				queryWrapper = Wrappers.<${entity}>query(entity);//仅支持单表查询条件
			}
			Object currentPage = params.get("current");
			Object limit = params.get("size");
			if (currentPage != null) {//含分页参数时，使用分页
				IPage<${entity}> page = new Page<${entity}>(Integer.parseInt(currentPage.toString()),limit == null ? 30 : Integer.parseInt(limit.toString()));
				IPage<Map<String, Object>> _page = ${(table.serviceName?substring(1))?uncap_first}.customPageMaps(page, queryWrapper);
				if (_page.getTotal() == 0) {
					return getResult("未查询到数据",HttpStatus.NO_CONTENT);
				}
				return getResult(_page,HttpStatus.OK);
			} else {//无分页参数获取所有数据，数据量大时，慎用
				List<Map<String,Object>> resultList = service.listMaps(queryWrapper);
				if (resultList.size() == 0) {
					return getResult("未查询到数据",HttpStatus.NO_CONTENT);
				}
				return getResult(resultList,HttpStatus.OK);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return getResult("查询失败，未知异常！",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
</#if>

}
</#if>