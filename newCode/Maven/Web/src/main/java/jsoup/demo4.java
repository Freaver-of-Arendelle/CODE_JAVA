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
public class demo4 {

    public static void main(String[] args) throws Exception{
        String path = ClassLoader.getSystemResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), StandardCharsets.UTF_8.name());

        Elements elements = document.getElementsByTag("name");
        System.out.println(elements);
        System.out.println("-------------");

        Elements elements1 = document.select("#itcast");
        System.out.println(elements1);
        System.out.println("-------------------");

        Elements elements2 = document.select("student[number=\"heima_000\"]");
        System.out.println(elements2);
        System.out.println("-------------------");

        Elements elements3 = document.select("student[number=\"heima_0001\"] > age");
        System.out.println(elements3);
    }
}
