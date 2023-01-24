public class nonPoliceSchedulerBusinessDelegate{

InitialContext ic = new InitialContext();
 TimerManager tm = (TimerManager)ic.lookup("java:comp/env/tm/default");
              tm.schedule (new MyTimerListener(), 0, 10*1000);
 System.out.println("<h4>Timer scheduled!</h4>");

private static class MyTimerListener implements TimerListener {
 public void timerExpired(Timer timer) {
    System.out.println("timer expired called on " + timer);
    timer.cancel();
 }
}

}

#https://docs.oracle.com/cd/E24329_01/web.1211/e24413.pdf
InitialContext ic = new InitialContext();
commonj.timers.TimerManager jobScheduler =(common.timers.TimerManager)ic.lookup
 ("weblogic.JobScheduler");
commonj.timers.TimerListener timerListener = new MySerializableTimerListener();
jobScheduler.schedule(timerListener, 0, 30*1000);
// execute this job every 30 seconds


<resource-ref>
 <res-ref-name>wm/MyWorkManager</res-ref-name>
 <res-type>commonj.work.WorkManager</res-type>
 <res-auth>Container</res-auth>
 <res-sharing-scope>Shareable</res-sharing-scope>
</resource-ref>


