package store.wangyan;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import io.micrometer.core.instrument.util.StringUtils;

import java.io.File;
import java.util.*;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {


    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir")+"/Scorpio-Admin";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("GAOKUN");
        gc.setOpen(false);
        gc.setFileOverride(true);//生成文件会覆盖之前的文件，请谨慎操作
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();

        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/ry?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("store.wangyan");
        mpg.setPackageInfo(pc);


        boolean customPageMaps = "1".equals(scanner("是否自定义查询【是：1，否：0】")) ? true : false;
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("customPageMaps", customPageMaps);
                this.setMap(map);
                System.out.println("自定义map集合：" + this.getMap());
            }
        };

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();

        // 自定义controller的代码模板
        focList.add(new FileOutConfig("/template/controller.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/src/main/java/store/wangyan/" +pc.getModuleName() + "/controller";
                return String.format((expand + File.separator + "%s" + ".java"), tableInfo.getControllerName());
            }
        });

        // 自定义entity的代码模板
        focList.add(new FileOutConfig("/template/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/src/main/java/store/wangyan/" +pc.getModuleName() + "/entity";
                return String.format((expand + File.separator + "%s" + ".java"), tableInfo.getEntityName());
            }
        });

        // 自定义service.java的代码模板
        focList.add(new FileOutConfig("/template/service.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/src/main/java/store/wangyan/" +pc.getModuleName() + "/service";
                return String.format((expand + File.separator + "%s" + ".java"), tableInfo.getServiceName());
            }
        });

        // 自定义serviceImpl.java的代码模板
        focList.add(new FileOutConfig("/template/serviceImpl.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/src/main/java/store/wangyan/" +pc.getModuleName() + "/service/impl";
                return String.format((expand + File.separator + "%s" + ".java"), tableInfo.getServiceImplName());
            }
        });

        // 自定义mapper.java的代码模板
        focList.add(new FileOutConfig("/template/mapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/src/main/java/store/wangyan/" +pc.getModuleName() + "/mapper";
                return String.format((expand + File.separator + "%s" + ".java"), tableInfo.getMapperName());
            }
        });

        // 自定义mapper.xml配置
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 模版配置
        TemplateConfig template = new TemplateConfig();
        //禁用默认的模版配置
        template.setController(null).setEntity(null).setService(null).setServiceImpl(null).setMapper(null).setXml(null);
        mpg.setTemplate(template);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("store.wangyan.common.entity.BaseEntity");
        strategy.setSuperEntityColumns("id");
//		strategy.setEntityLombokModel(true);
        //strategy.setSuperControllerClass("cstore.wangyan.common.controller.BaseController");
        strategy.setInclude(scanner("表名"));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("sys_" + pc.getModuleName() + "_");//例：tb_system_
        //strategy.entityTableFieldAnnotationEnable(true);
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }


}
