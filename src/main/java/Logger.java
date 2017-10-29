import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Реализует логгер
 */
class Logger {

    private PrintWriter log = null;
    private String path;
    private Desktop desktop = null;

    /**
     * Инициализация логгера
     * @param pathLog файл для логгера
     */
    void init(String pathLog){
        try {
            path = pathLog;
            desktop = Desktop.getDesktop();
            log  = new PrintWriter(pathLog);
            writeLog("Создан лог-файл.");
            writeComment();
        } catch (FileNotFoundException e) {
            System.out.println(getDate() +"     Не удалось создать лог-файл.");
        }
    }

    /**
     * Возвращает дату
     * @return возвращает дату в формате yyyy.MM.dd-HH.mm.ss
     */
    String getDate(){
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss");
        Date date=new Date();
        return format.format(date);
    }

    /**
     * Запись в лог-файл
     * @param s данные для записи
     */
     void writeLog(String s){
        log.println(getDate() + "       " + s);
    }

    /**
     * Завершить работу логгера
     */
    void finishLog(){
        try {
            Driver.log.desktop.open(new File(Driver.log.path));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        log.close();
    }

    /**
     * Запись Примечаний к проекту в лог-файл из resources проекта
     */
    private void writeComment() {
        BufferedReader in;
        String s;
        try {
            in = new BufferedReader
                    (new FileReader("src\\main\\resources\\Примечания к проекту.txt"));
            while ((s = in.readLine()) != null)
                log.println(s);
        } catch (FileNotFoundException e) {
            Driver.log.writeLog("Не удалось записать примечания к проекту");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
