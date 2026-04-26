package lab11;

import java.util.List;
import java.util.stream.Collectors;

public class par9 {
    static void main() {
        String string = "Напишите функцию2, которая принимает на вход список стр0к и возвраща3т " +
                "новый список, содержащий только те строки7, которые имеют длину больше заданного значения.";

        List<String> strings = List.of(string.split(" "));
        List<String> stringsAfter = filterCapitalizedStrings(strings);

        IO.println("Найденные строки : " + "\n");
        for (String e : stringsAfter) {
            IO.println(e);
        }
    }

    public static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream()
                .filter(s -> s.matches("[a-zA-Zа-яА-Я\\s]+"))
                .collect(Collectors.toList());
    }
}
