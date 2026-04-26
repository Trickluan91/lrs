package lab11;

import java.util.List;
import java.util.stream.Collectors;

public class par7 {
    static void main() {
        String string = "Напишите функцию, которая принимает на вход список строк и возвращает " +
                "новый список, содержащий только те строки, которые имеют длину больше заданного значения.";

        string = string.replace(",", "");
        string = string.replace(".", "");
        List<String> strings = List.of(string.split(" "));
        List<String> stringsAfter = filterCapitalizedStrings(strings);

        IO.println("Найденные строки : " + "\n");
        for (String e : stringsAfter) {
            IO.println(e);
        }
    }

    public static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream().filter(s -> s.length() > 7).collect(Collectors.toList());
    }
}
