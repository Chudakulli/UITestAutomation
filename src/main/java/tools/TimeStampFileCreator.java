package tools;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

    public class TimeStampFileCreator {


        //Create a new file
        public static String CreateFileWithTimeStamp(String filename) {
            //create a new file with Time Stamp
            File file = new File(filename+GetCurrentTimeStamp().replace(":","_").replace(".","_")+".html");

            try {
                if (!file.exists()) {
                    file.createNewFile();
                    System.out.println("File is created; file name is " + file.getName());
                } else {
                    System.out.println("File already exist");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return file.toString();
        }
        // Get current system time
        public static String GetCurrentTimeStamp() {
            SimpleDateFormat sdfDate = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
            Date now = new Date();
            String strDate = sdfDate.format(now);
            return strDate;
        }
    }

