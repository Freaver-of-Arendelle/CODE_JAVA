package controller;

import model.bean.Problem;
import model.bean.Template;
import model.service.Service;
import model.service.TemplateService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @Time 07/12/2021 10:32
 * @Description Template的Controller类
 */
public class TemplateController {

    private Service service = TemplateService.getSingleton();

    private volatile static TemplateController singleton;

    private TemplateController() {
    }

    /**
     * 双重检查锁的单例模式
     *
     * @return UserSecureController
     */

    public static TemplateController getSingleton() {
        if (singleton == null) {
            synchronized (TemplateController.class) {
                if (singleton == null) {
                    singleton = new TemplateController();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {

        ProblemController singleton = ProblemController.getSingleton();
        List<Problem> problems = new ArrayList<>(singleton.getProblems());

        TemplateController controller = TemplateController.getSingleton();


        controller.addTemplate(0, "谁知道呢", new TreeSet<>(problems.subList(0, 3)), "A");
        controller.addTemplate(1, "差不多得了", new TreeSet<>(problems.subList(3, 6)), "B");
        controller.addTemplate(2, "你在影射什么", new TreeSet<>(problems.subList(6, 9)), "C");

        Set<Template> set = controller.getTemplates();
        for (Template template : set) {
            Set<Problem> problems1 = template.getProblems();
            for (Problem problem : problems1) {
                problem.setReflect(template.getId());
            }
            System.out.println(template);
        }

        singleton.clear();
        for (Problem problem : problems) {
            singleton.addProblem(problem);
        }


//        controller.removeTemplate(1);

        System.out.println("-------------------");
        Set<Template> set1 = controller.getTemplates();
        for (Template template : set1) {
            System.out.println(template);
        }


    }

    /**
     * 增加Template集合
     *
     * @param template 需要增加的Problem
     * @return 是否增加成功
     */
    public boolean addTemplate(Template template) {

        setPath();
        return service.getCreate().add(template);
    }

    /**
     * 增加Template集合
     *
     * @param id
     * @param title
     * @param problems
     * @param type
     * @return 是否增加成功
     */
    public boolean addTemplate(int id, String title, Set<Problem> problems, String type) {
        setPath();
        return service.getCreate().add(new Template(id, title, problems, type));
    }

    /**
     * 获取Template的Set集合
     *
     * @return Set<Template>
     */
    public Set<Template> getTemplates() {
//        return ((Set<Template>) service.getRead().get());
//        Read read = service.getRead();
//        Set<JSONObject> set = (Set<JSONObject>) read.get();
//
//        Set<Template> templates = new HashSet<>();
//
//        for (JSONObject jsonObject : set) {
//            templates.add(new Template(jsonObject.getInteger("id"),
//                    jsonObject.getString("title"),
//                    ((Set<Problem>) jsonObject.get("problems")),
//                    jsonObject.getString("type")));
//        }
//        return templates;
        setPath();

        return ((Set<Template>) service.getRead().get());
    }

    /**
     * 删除Template
     *
     * @param id 为filter提供所需要的判断方式
     * @return 是否删除成功
     */
    public boolean removeTemplate(int id) {
        setPath();

        Predicate<Template> filter = e -> e.getId() == id;
//        Predicate<JSONObject> filter = jsonObject -> jsonObject.getInteger("id") == (id);
        return service.getDelete().remove(id, filter);
    }

    /**
     * 修改Template集合
     *
     * @param id       为filter提供所需要的判断方式
     * @param template 需要增加的Template
     * @return 是否修改成功
     */
    public boolean modifyTemplate(int id, Template template) {
        setPath();
        Predicate<Template> filter = e -> e.getId() == id;
//        Predicate<JSONObject> filter = jsonObject -> jsonObject.getInteger("id") == (id);
        return service.getUpdate().modify(template, filter);
    }

    /**
     * 清空Template集合
     *
     * @return 是否清空成功
     */
    public boolean clear() {
        setPath();
        return service.getDelete().clear();
    }

    private static void setPath() {
        TemplateService.setPath();
    }


}
