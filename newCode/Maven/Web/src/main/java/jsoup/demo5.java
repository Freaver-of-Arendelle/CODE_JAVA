package jsoup;


import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.File;
import java.util.List;


/**
 * @author Freaver
 * @date 07/09/2021 17:42
 * @description
 */
public class demo5 {
    public static void main(String[] args) throws Exception {
        String path = ClassLoader.getSystemResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        JXDocument jxDocument = new JXDocument(document);

        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }

        System.out.println("-----------");

        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes1) {
            System.out.println(jxNode);
        }

        System.out.println("--------------------");

        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }

        System.out.println("---------------");

        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id='itcast']");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }

    }
}
