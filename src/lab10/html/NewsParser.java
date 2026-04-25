package lab10.html;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class NewsParser {
    @SuppressWarnings("unchecked")
    static void main() {
        try {
            Document doc = connect("https://www.e1.ru/asdf/", 1);

            JSONArray news = new JSONArray();
            Elements titles = doc.select("a[data-announcement-title]");
            for (Element titleEl : titles) {
                String title = titleEl.attr("data-announcement-title");
                String url = titleEl.attr("href");

                Element parent = titleEl.parent();
                while (parent != null && parent.selectFirst("span[data-announcement-date]") == null) {
                    parent = parent.parent();
                }

                String date = "—";
                if (parent != null) {
                    Element dateEl = parent.selectFirst("span[data-announcement-date]");
                    if (dateEl != null) date = dateEl.attr("data-announcement-date");
                }

                JSONObject newsObj = new JSONObject();
                newsObj.put("Тема", title);
                newsObj.put("Дата", date);
                newsObj.put("URL", url);
                news.add(newsObj);
            }

            try (FileWriter fw = new FileWriter("src/lab10/html/news.json", StandardCharsets.UTF_8)) {
                fw.write(news.toJSONString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Document connect(String link, int attempt) throws IOException {
        Connection conn = Jsoup.connect(link).timeout(10000);
        try { conn.execute(); }
        catch (HttpStatusException e) {
            IO.println("Не удалось получить страницу. Попытка переподключиться");

            if(attempt >= 3) {
                IO.println("Не удалось подключиться. Сворачиваемся.");
                throw e;
            }
            return connect(link, attempt + 1);
        }
        return conn.get();
    }
}