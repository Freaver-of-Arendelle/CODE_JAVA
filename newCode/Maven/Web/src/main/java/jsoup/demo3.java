package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * @author Freaver
 * @date 07/10/2021 01:19
 * @description
 */
public class demo3 {

    public static void main(String[] args) throws Exception{
        String path = ClassLoader.getSystemResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), StandardCharsets.UTF_8.name());

        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        System.out.println("-------------");

        Element student = document.getElementsByTag("student").get(0);
        Elements name = student.getElementsByTag("name");
        System.out.println(name.size());

        String number = student.attr("NUMBER");
        System.out.println(number);
        System.out.println("-----------");

        String text = name.text();
        String html = name.html();
        System.out.println(text);
        System.out.println(html);
    }
}
