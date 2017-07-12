package networkModule;

import stateData.GameState;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Student on 7/12/2017.
 */
public class ServerListeningTask implements  Runnable {

    private volatile boolean isRunning = true;
    private InetSocketAddress socketAddress;


    public void run() {
        try
        {

            Socket client = new Socket();
            client.connect(socketAddress);
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            GameState gameState;

            while(isRunning)
            {

                gameState = (GameState) in.readObject();
                //передать объект в метод менеджера

            }
            client.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setSocketAddress(InetSocketAddress socketAddress)
    {
        this.socketAddress = socketAddress;
    }

    public void kill()
    {
        isRunning = false;
    }
}
