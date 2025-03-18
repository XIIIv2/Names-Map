package app;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {

    Map<Integer, String> map = new DataRepository().getData();

    // Метод формує виведення нумерованого переліку імен
    public String getAll() {
        //на всякий случай добавим валидацию
        if (map.isEmpty()) {
            return "Map is empty!";
        }

        StringBuilder sb = new StringBuilder();
        // оставляем AtomicInteger для масштабируемости приложения
        AtomicInteger count = new AtomicInteger(0);
        map.forEach((id, name) ->
                sb.append(String.format("%d) %d, %s%n",
                        count.incrementAndGet(),id, name)
        ));
        return "\nALL NAMES:\n" + sb;
    }

    // Метод формує виведення імені за певним id
    public String getById(int id) {
        if (map.containsKey(id)) {
            return "\nNAME: id " + id + ", " +
                    map.get(id);
        } else return "No data!";
    }
}
