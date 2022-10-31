package multithreading.prog.util;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utility {
    private static String getDate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss");
        return localDateTime.format(dateTimeFormatter);
    }

    public static void printDetailData(String str){
        System.out.println("Thread " + Thread.currentThread().getName() + " response time: " + getDate() + " " + str);
    }

    public static void threadSleep(long yourSecond){
        try {
            Thread.sleep(1000 * yourSecond);
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }
}
