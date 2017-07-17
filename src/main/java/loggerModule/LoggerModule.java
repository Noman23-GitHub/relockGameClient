package loggerModule;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    LoggerSettings loggerSettings;

    DateFormat df = new SimpleDateFormat(loggerSettings.getDateFormat());

    public void logMessage(String message) {

        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        String giveLog = (reportDate + message + "\r");
        try {
            FileWriter logWriter = new FileWriter(loggerSettings.getFileName(), true);
            logWriter.append('\n');
            logWriter.write(giveLog);
            logWriter.flush();
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }
    }
}
