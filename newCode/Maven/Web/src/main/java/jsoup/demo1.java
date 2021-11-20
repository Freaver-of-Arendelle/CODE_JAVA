package jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author Freaver
 * @date 07/09/2021 17:42
 * @description
 */
public class demo1 {
    public static void main(String[] args) throws IOException {
        String path = ClassLoader.getSystemResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        Elements elements = document.getElementsByTag("name");

        System.out.println(elements.size());

        Element element = elements.get(0);
        String name = element.text();
        System.out.println(name);

    }
}
