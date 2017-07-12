package networkModule;

import org.springframework.stereotype.Component;
import java.net.InetSocketAddress;

/**
 * Created by Student on 7/12/2017.
 */
@Component
public class NetworkSettings {

    private InetSocketAddress socketAddress;

    public NetworkSettings(String hostName, int port) {

        socketAddress = new InetSocketAddress(hostName,port);
    }

    public InetSocketAddress getSocketAddress() {
        return socketAddress;
    }

    public void setSocketAddress(InetSocketAddress socketAddress) {
        this.socketAddress = socketAddress;
    }
}
