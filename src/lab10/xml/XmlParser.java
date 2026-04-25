package lab10.xml;

import java.io.File;
import java.util.List;
import java.util.stream.IntStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XmlParser {
    static void main() {
        try {
            File inputFile = new File("src/lab10/xml/example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            print(doc);

            addBook(doc);
            save(doc);

            search(doc);

            removeBook(doc);
            save(doc);
            print(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void print(Document doc){
        IO.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName("book");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            IO.println("\nТекущий элемент: " + node.getNodeName());
            printBook(node);
        }
    }

    private static void printBook(Node node){
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            IO.println("Название книги: " + element.getElementsByTagName("title").item(0).getTextContent());
            IO.println("Автор: " + element.getElementsByTagName("author").item(0).getTextContent());
            IO.println("Год издания: " + element.getElementsByTagName("year").item(0).getTextContent());
            IO.println("\n");
        }
    }

    private static void addBook(Document doc) {
        Element rootElement = ((Element) doc.getElementsByTagName("library").item(0));

        Element book = doc.createElement("book");
        rootElement.appendChild(book);

        Element title = doc.createElement("title");
        title.appendChild(doc.createTextNode(IO.readln("Введите название книги\n")));
        book.appendChild(title);

        Element author = doc.createElement("author");
        author.appendChild(doc.createTextNode(IO.readln("Введите автора\n")));
        book.appendChild(author);

        Element year = doc.createElement("year");
        year.appendChild(doc.createTextNode(IO.readln("Введите год написания книги\n")));
        book.appendChild(year);
    }

    private static void removeBook(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("book");
        String searchStr = IO.readln("Введите автора для удаления\n");
        List<Element> books = IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item)
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> (Element) node)
                .filter(element -> element
                        .getElementsByTagName("author")
                        .item(0)
                        .getTextContent()
                        .equalsIgnoreCase(searchStr))
                .toList();

        Element rootElement = ((Element) doc.getElementsByTagName("library").item(0));
        books.forEach(rootElement::removeChild);
    }

    private static void save(Document doc) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/lab10/xml/example.xml"));
        transformer.transform(source, result);
    }

    private static void search(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("book");
        String searchStr = IO.readln("Введите автора или год для поиска\n");
        List<Element> books = IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item)
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> (Element) node)
                .filter(element -> {
                    String author = element.getElementsByTagName("author").item(0).getTextContent();
                    String year = element.getElementsByTagName("year").item(0).getTextContent();
                    return author.equalsIgnoreCase(searchStr) || year.equals(searchStr);
                })
                .toList();

        books.forEach(XmlParser::printBook);
    }
}
