package com.he.multi.quartz;

import com.he.multi.dao.GradesDao;
import com.he.multi.pojo.Grades;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class SampleJob implements Job {
    /**
     * <p>
     * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code>
     * fires that is associated with the <code>Job</code>.
     * </p>
     *
     * <p>
     * The implementation may wish to set a
     * {@link JobExecutionContext#setResult(Object) result} object on the
     * {@link JobExecutionContext} before this method exits.  The result itself
     * is meaningless to Quartz, but may be informative to
     * <code>{@link JobListener}s</code> or
     * <code>{@link TriggerListener}s</code> that are watching the job's
     * execution.
     * </p>
     *
     * @param context
     * @throws JobExecutionException if there is an exception while executing the job.
     */


    @Autowired
    private GradesDao gradesDao;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("===== "+new Date()+"  ====执行了任务============33333333333333333============");

                List<Grades> grades = gradesDao.selectList(null);

        if(grades!=null && grades.size()>0){
            System.out.println("查询成功");
            System.out.println("grades: "+ grades);
        }


    }
}
