package controller;

import com.alibaba.fastjson.JSONObject;
import model.bean.User;
import model.dao.Create;
import model.dao.Delete;
import model.dao.Read;
import model.dao.Update;
import model.service.Service;
import model.service.impl.UserService;
import org.junit.Test;

import java.util.Set;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @Time 07/10/2021 23:58
 * @Description
 */

@Deprecated public class UserController {

    private UserController() {

    }

    private static volatile UserController singleton;

    public static UserController getSingleton() {
        if (singleton == null) {
            synchronized (UserController.class) {
                if (singleton == null) {
                    singleton = new UserController();
                }
            }
        }

        return singleton;
    }

    private Service service = UserService.getSingleton();

    @Test void test() {

        String name1 = "aaaaaaa";
        String name2 = "bbbbbbb";
        String name3 = "ccccccc";
        String password = "dddddddd";

        UserController userController = new UserController();
        boolean b = userController.addUser(name1, password, true);
        boolean b1 = userController.addUser(name2, password, false);
        boolean b2 = userController.addUser(name3, password, false);
        System.out.println(b == b1 == b2);

        Set<JSONObject> userSet = userController.getUsers();
        System.out.println(userSet.toString());

        System.out.println("------------------");
        userController.removeUser("aaaaaaa");

        Set<JSONObject> userSet1 = userController.getUsers();
        System.out.println(userSet1.toString());
        System.out.println("------------------");

        User user1 = new User("aaaaaaa", "11111111", false);
        userController.modifyUser("bbbbbbb", user1);
        //        List<User> userList = userController.showUser();
        Set<JSONObject> userSet2 = userController.getUsers();

        System.out.println(userSet2);
    }

    public boolean addUser(String name, String password, boolean isAdministrator) {

        User user = new User(name, password, isAdministrator);
        Create create = service.getCreate();
        return create.add(user);
    }

    public boolean removeUser(String name) {

        Predicate<JSONObject> filter = jsonObject -> jsonObject.getString("username").equals(name);

        //        Predicate filter = s -> s.equals(name);
        Delete delete = service.getDelete();
        //        return delete.remove(name, e -> e.equals(name));
        return delete.remove(name, filter);
    }

    public Set<JSONObject> getUsers() {
        Read read = service.getRead();
        Set<JSONObject> set = (Set<JSONObject>)read.get();
        return set;
    }

    public boolean modifyUser(String name, User user) {
        //        Predicate<String> filter = s -> s.equals(name);
        Predicate<JSONObject> filter = jsonObject -> jsonObject.getString("username").equals(name);
        Update update2 = service.getUpdate();
        //        return update.modify(user, name, e -> e.equals(name));
        return update2.modify(name, filter);

    }

}
