package loggerModule;

import org.springframework.stereotype.Component;


@Component
public class LoggerSettings {
    private String dateFormat;
    private String fileName;

    public String getDateFormat(){return dateFormat;}
    public void setdateFormat(String dateFormat){ this.dateFormat = dateFormat;}

    public String getFileName(){return fileName;}
    public void setFileName(String fileName){ this.fileName = fileName; }

    public LoggerSettings(String dateFormat, String fileName){
        this.dateFormat = dateFormat;
        this.fileName = fileName;
    }

}
