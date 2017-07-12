package networkModule;

import moduleManager.ModuleManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;
import stateData.ClientState;
import stateData.GameState;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


@Component
public class NetworkModule implements NetworkModuleInterface {

    @Resource
    private ModuleManagerInterface moduleManager;
    @Autowired
    private NetworkSettings networkSettings;
    private TaskExecutor taskExecutor;
    private Socket socket;
    private volatile boolean isRunning = true;
    private boolean isListening = false;

    @PostConstruct
    public void init()
    {
        taskExecutor = new SimpleAsyncTaskExecutor();
        socket = new Socket();
        startListening();
    }
    public void sendClientState(ClientState clientState) {

        try
        {
            socket.connect(networkSettings.getSocketAddress());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(clientState);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void startListening()
    {
        if(isListening)
            return;
        else
            {
            isListening = true;
            taskExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        Socket socket = new Socket();
                        socket.connect(networkSettings.getSocketAddress());
                        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                        GameState gameState;
                        while (isRunning) {
                            gameState = (GameState) in.readObject();
                            moduleManager.transferGameState(gameState);
                        }
                        socket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    public void killListening()
    {
        isRunning = false;
    }


}
