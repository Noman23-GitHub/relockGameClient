package loggerModule;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class LoggerModule implements LoggerModuleInterface{

    DateFormat df = new SimpleDateFormat("[HH:mm:ss] dd.MM.yyyy ");

    public void logMessage(String message) {

        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        String giveLog = (reportDate + message + "\r");
        try {
            FileWriter logWriter = new FileWriter("D:\\testlog.txt", true);
            logWriter.append('\n');
            logWriter.write(giveLog);
            logWriter.flush();
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }
    }
}
