import com.amtsuper.tank.TankFrame;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        tf.setVisible(true);

        while (true) {
            Thread.sleep(100);
            tf.repaint();
        }
    }
}

