package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author Freaver
 * @date 07/10/2021 01:19
 * @description
 */
public class demo2 {

    public static void main(String[] args) throws Exception{
        String path = ClassLoader.getSystemResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), StandardCharsets.UTF_8.name());

        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);

        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);
        System.out.println("----------------");

        Elements elements2 = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(elements2);

        System.out.println("---------------");

        Element itcast = document.getElementById("itcast");
        System.out.println(itcast);

    }
}
