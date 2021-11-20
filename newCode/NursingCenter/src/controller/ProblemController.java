package controller;


import model.bean.Problem;
import model.service.ProblemService;
import model.service.Service;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @Time 07/12/2021 10:32
 * @Description Problem的Controller层类
 */
public class ProblemController {

    private Service service = ProblemService.getSingleton();

    private volatile static ProblemController singleton;

    private ProblemController() {
    }

    /**
     * 双重检查锁的单例模式
     *
     * @return UserSecureController
     */

    public static ProblemController getSingleton() {
        if (singleton == null) {
            synchronized (ProblemController.class) {
                if (singleton == null) {
                    singleton = new ProblemController();
                }
            }
        }
        return singleton;
    }

    public static void setPath() {
        ProblemService.setPath();
    }


    @Test
    void test() {

        String question1 = "东北最强大学是哪一所";
        String question2 = "什么族人的地位最高";
        String question3 = "为什么学生会抱怨不装空调";
        String question4 = "宁波工程学院事件中的主要责任人在谁";
        String question5 = "世界上最好用的软件是啥";
        String question6 = "最好用的编写JAVA的IDE是啥";
        String question7 = "谁是当今世界上的顶瘤";
        String question8 = "谁是当今最强的篮球队";
        String question9 = "以下谁可以称得上是人生导师";

        String[] answer1 = {"东北大学", "哈尔滨工业大学", "大连理工大学"};
        String[] answer2 = {"非中华民族人", "少数名族", "汉族人"};
        String[] answer3 = {"收了登子的钱", "收到了校外势力的蛊惑", "天气炎热受不了"};
        String[] answer4 = {"受害女生", "学院领导", "尼哥外教"};
        String[] answer5 = {"2345", "金山系", "腾讯系"};
        String[] answer6 = {"IDEA", "VS Code", "Eclipse"};
        String[] answer7 = {"割割", "顶针", "马嘉祺"};
        String[] answer8 = {"北大", "雄鹿", "篮网"};
        String[] answer9 = {"古德莉莉安", "E哥", "孙笑川"};


        Problem problem1 = new Problem(0, question1, answer1, "A", 0);
        Problem problem2 = new Problem(1, question2, answer2, "B", 0);
        Problem problem3 = new Problem(2, question3, answer3, "C", 0);
        Problem problem4 = new Problem(3, question4, answer4, "A", 1);
        Problem problem5 = new Problem(4, question5, answer5, "B", 1);
        Problem problem6 = new Problem(5, question6, answer6, "C", 1);
        Problem problem7 = new Problem(6, question7, answer7, "A", 2);
        Problem problem8 = new Problem(7, question8, answer8, "B", 2);
        Problem problem9 = new Problem(8, question9, answer9, "C", 2);
        ProblemController controller = ProblemController.getSingleton();

//        controller.addProblem(problem1);
//        controller.addProblem(problem2);
//        controller.addProblem(problem3);
//        controller.addProblem(problem4);
//        controller.addProblem(problem5);
//        controller.addProblem(problem6);
//        controller.addProblem(problem7);
//        controller.addProblem(problem8);
//        controller.addProblem(problem9);


        Set<Problem> problems = controller.getProblems();
        for (Problem problem : problems) {
            System.out.println(problem);
        }
    }

    /**
     * 增加Problem集合
     *
     * @param problem 需要增加的Problem
     * @return 是否增加成功
     */
    public boolean addProblem(Problem problem) {
        setPath();
        return service.getCreate().add(problem);
    }

    /**
     * 增加Problem集合
     *
     * @param id
     * @param question
     * @param answers
     * @param type
     * @return 是否增加成功
     */
    public boolean addProblem(int id, String question, String[] answers, String type, Integer templateId) {
        setPath();
        return service.getCreate().add(new Problem(id, question, answers, type, templateId));
    }

    /**
     * 获取Problem的Set集合
     *
     * @return Set<Problem>
     */
    public Set<Problem> getProblems() {
//        return ((Set<Problem>) service.getRead().get());

//        Read read = service.getRead();
//        Set<JSONObject> set = (Set<JSONObject>) read.get();
//
//        Set<Problem> problems = new HashSet<>();
//
//        for (JSONObject jsonObject : set) {
//            problems.add(new Problem(jsonObject.getInteger("id"),
//                    jsonObject.getString("question"),
//                    ((String[]) jsonObject.get("answer")),
//                    jsonObject.getObject("map", new TypeReference<Map<String, Integer>>() {
//                    }),
//                    jsonObject.getObject("reflect", new TypeReference<Map<Integer, Set<Integer>>>() {
//                    }),
//                    jsonObject.getString("type")));
//        }
//        return problems;
        setPath();
        return (Set<Problem>) service.getRead().get();
    }

    /**
     * 删除Problem
     *
     * @param id 为filter提供所需要的判断方式
     * @return 是否删除成功
     */
    public boolean removeProblem(int id) {
        setPath();
//        Predicate<JSONObject> filter = jsonObject -> jsonObject.getInteger("id") == (id);
        Predicate<Problem> filter = e -> e.getId() == id;
        return service.getDelete().remove(id, filter);
    }

    /**
     * 修改Problem集合
     *
     * @param id      为filter提供所需要的判断方式
     * @param problem 需要增加的Problem
     * @return 是否修改成功
     */
    public boolean modifyProblem(int id, Problem problem) {
        setPath();
        Predicate<Problem> filter = e -> e.getId() == id;
//        Predicate<JSONObject> filter = jsonObject -> jsonObject.get("id").equals(id);
        return service.getUpdate().modify(problem, filter);
    }

    /**
     * 清空Problem集合
     *
     * @return 是否清空成功
     */
    public boolean clear() {
        setPath();
        return service.getDelete().clear();
    }


}
