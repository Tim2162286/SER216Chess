
package Game;
/**
 * Created by Tim on 4/10/2017.
 */
public class ChessTimer {
    private long length;
    private long startTime;
    private boolean isRunning;

    public ChessTimer(long seconds){
        length = seconds*1000;
        isRunning = false;
    }

    /**
     * Method to start/resume timer countdown. Time remaining must be greater than 0 to start.
     */
    public void start(){
        if (!isRunning && length>0) {
            startTime = System.currentTimeMillis();
            isRunning = true;
        }
    }

    /**
     * Method to pause timer countdown
     */
    public void pause(){
        if(isRunning) {
            length -= (System.currentTimeMillis() - startTime);
            isRunning = false;
        }
    }

    /**
     * Method to return the remaining time on the timer. will automatically stop timer if time would go negative.
     * @return Returns time remaining on the timer, will not go negative.
     */
    public long getTime(){
        long time;
        if(isRunning)
            time = (length-(System.currentTimeMillis()-startTime));
        else
            time = (length);
        if(time<=0){
            this.pause();
            length = 0;
            time = 0;
        }
        return time;
    }

    public String getTimeString(){
        long time;
        if(isRunning)
            time = (length-(System.currentTimeMillis()-startTime));
        else
            time = (length);
        if(time<=0){
            this.pause();
            length = 0;
            time = 0;
        }
        return ((time/1000)/60)+":"+((time/1000)%60);
    }
}

