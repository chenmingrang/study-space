package quartaDemos.demo4;

import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class ColorJob implements Job{
	private static Logger logger=LoggerFactory.getLogger(ColorJob.class);
	 // parameter names specific to this job
	public static final String FAVORITE_COLOR="favorite_color";
	public static final String EXECUTION_COUNT="count";
     // Since Quartz will re-instantiate a class every time it
    // gets executed, members non-static member variables can
    // not be used to maintain state!
	private int counter=1;
	
	/**
     * <p>
     * Called by the <code>{@link org.quartz.Scheduler}</code> when a
     * <code>{@link org.quartz.Trigger}</code> fires that is associated with
     * the <code>Job</code>.
     * </p>
     * 
     * @throws JobExecutionException
     *             if there is an exception while executing the job.
     */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobKey jobKey=context.getJobDetail().getKey();
		JobDataMap data=context.getJobDetail().getJobDataMap();
		String favoriteColor=data.getString(FAVORITE_COLOR);
		int count=data.getInt(EXECUTION_COUNT);
		logger.info("ColorJob:"+jobKey+" executing at "+new Date()+"\n"+
		           "favorite color is "+favoriteColor+"\n"+
		           "executing count (from job map) is "+count+"\n"+
		           "execution count (from job member variable) is "+counter);
		
	    // increment the count and store it back into the 
        // job map so that job state can be properly maintained
		count++;
		data.put(EXECUTION_COUNT,count);
		
		// Increment the local member variable 
        // This serves no real purpose since job state can not 
        // be maintained via member variables!
		counter++;
	}

}
