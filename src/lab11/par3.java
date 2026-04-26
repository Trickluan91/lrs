package lab11;

import java.util.List;
import java.util.stream.Collectors;

public class par3 {
    static void main() {
        String string = "Напишите функцию, Которая принимает на вход список " +
                "строк и возвращает новый список, Содержащий только те строки, " +
                "которые Начинаются с большой буквы. Еще текст для Примера.";

        List<String> strings = List.of(string.split(" "));
        IO.println("\n" + "Строка после сплитования : " + "\n");
        for (String e : strings) {
            IO.println(e);
        }

        List<String> stringsAfter = filterCapitalizedStrings(strings);

        IO.println("\n" + "Строка после преобразования : " + "\n");
        for (String e : stringsAfter) {
            IO.println(e);
        }
    }

    public static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}
