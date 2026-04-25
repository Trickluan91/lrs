package lab10.json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParser {
    static void main() {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/lab10/json/example-json.json"));
            JSONObject jsonObject = (JSONObject) obj;

            print(jsonObject);
            search((JSONArray) jsonObject.get("books"));
            addBook((JSONArray) jsonObject.get("books"));
            removeBook((JSONArray) jsonObject.get("books"));

            print(jsonObject);
            save(jsonObject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void print(JSONObject jsonObject) {
        IO.println("Корневой элемент: " + jsonObject.keySet().iterator().next());
        JSONArray jsonArray = (JSONArray) jsonObject.get("books");

        for (Object o : jsonArray) {
            JSONObject book = (JSONObject) o;
            IO.println("Название книги: " + book.get("title"));
            IO.println("Автор: " + book.get("author"));
            IO.println("Год издания: " + book.get("year"));
        }
    }

    @SuppressWarnings("unchecked")
    private static void addBook(JSONArray jsonArray) {
        JSONObject newBook = new JSONObject();
        newBook.put("title", IO.readln("Введите название новой книги\n"));
        newBook.put("author", IO.readln("Введите автора новой книги\n"));
        newBook.put("year", 2023);
        jsonArray.add(newBook);
    }

    private static void removeBook(JSONArray books) {
        String title = IO.readln("Введите название книги для удаления\n");
        Iterator<?> iterator = books.iterator();
        while (iterator.hasNext()) {
            JSONObject book = (JSONObject) iterator.next();
            if (title.equals(book.get("title"))) {
                iterator.remove();
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void search(JSONArray jsonArray) {
        String author = IO.readln("Введите фамилию автора для поиска\n");
        jsonArray.stream()
                .filter(book -> author.equals(((JSONObject) book).get("author")))
                .forEach(book -> {
                    IO.println("Название книги: " + ((JSONObject) book).get("title"));
                    IO.println("Автор: " + ((JSONObject) book).get("author"));
                    IO.println("Год издания: " + ((JSONObject) book).get("year"));
                    IO.println("\n");
                });
    }

    private static void save(JSONObject jsonObject) throws IOException {
        try (FileWriter fw = new FileWriter("src/lab10/json/example-json.json", StandardCharsets.UTF_8)) {
            fw.write(jsonObject.toJSONString());
        }
    }
}
