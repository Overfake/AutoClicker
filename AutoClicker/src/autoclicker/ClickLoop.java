package autoclicker;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 *
 * @author Max
 */
public class ClickLoop extends Thread{
    private boolean stop;
    private long lasttick;
    private int x, y, interval, nbclicks,nbclickstostop;
    private Robot bot = null;
    //define mask for input
    private final int mask = InputEvent.BUTTON1_DOWN_MASK;
    {
        nbclicks = 0;
        nbclickstostop = 10;
    }
    public ClickLoop(int x, int y, int interval){
        //Setting up the boolean stop to false to keep the "AutoClick bot" running until "arreter()" is called;
        this.stop = false;
        
        this.x = x;
        this.y = y;
        
        this.interval = interval;
        
        this.lasttick = System.currentTimeMillis();
        
        try{
           this.bot = new Robot();
        }catch(Exception E){
            System.out.println(E.toString());
        }
        System.out.println("x = " + x + " y = " + y + " interval = " + interval);
    }
    public void run(){
        long now;
        while(!stop){
            if( (this.lasttick + interval) < System.currentTimeMillis()){
                this.lasttick = System.currentTimeMillis(); // Update lasttick
                //move mouse where it needs to be to click
                this.bot.mouseMove(x,y);
                //bot press
                this.bot.mousePress(mask);
                //bot release
                this.bot.mouseRelease(mask);
                System.out.println("Clicked" + nbclicks);
                nbclicks++;
                if(nbclicks > nbclickstostop){
                    this.arreter();
                }
            }
        
        }
    }
    public void resetClickBot(int x, int y, int interval){
        this.x = x;
        this.y = y;
        this.interval = interval;
    }
    public void arreter(){
        this.stop = true;
    }
}
