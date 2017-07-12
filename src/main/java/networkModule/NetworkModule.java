package networkModule;

import moduleManager.ModuleManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;
import stateData.ClientState;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.InetSocketAddress;

@Component
public class NetworkModule implements NetworkModuleInterface {

    @Resource
    ModuleManagerInterface moduleManager;

    @Autowired
    private TaskExecutor taskExecutor;

    public void sendClientState(ClientState clientState) {

    }

    private void initialize()
    {
        ServerListeningTask serverListeningTask = new ServerListeningTask();
        try
        {
            serverListeningTask.setSocketAddress(new InetSocketAddress(InetAddress.getLocalHost(), 5000)); //тут нужно получать реальный адресс и порт
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        taskExecutor.execute(new ServerListeningTask());
    }


}
