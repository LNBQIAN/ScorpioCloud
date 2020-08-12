package store.wangyan.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class DemoJob01 extends QuartzJobBean {

    //    Scheduler ：调度器
    //    Trigger ：触发器
    //    Job ：任务
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("[executeInternal][我开始的执行了]");
    }
}
