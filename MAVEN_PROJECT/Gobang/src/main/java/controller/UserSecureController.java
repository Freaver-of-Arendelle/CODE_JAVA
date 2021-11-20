package controller;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import com.alibaba.fastjson.JSONObject;
import model.bean.User;
import model.bean.UserSecure;
import model.dao.Create;
import model.dao.Delete;
import model.dao.Retrieve;
import model.dao.Update;
import model.service.Service;
import model.service.UserSecureService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @date 07/10/2021 23:58
 * @description UserSecure的Controller层类
 */
public class UserSecureController {

    private UserSecureController() {

    }

    private static volatile UserSecureController singleton;


    /**
     * 双重检查锁的单例模式
     *
     * @return UserSecureController
     */
    public static UserSecureController getSingleton() {
        if (singleton == null) {
            synchronized (UserSecureController.class) {
                if (singleton == null) {
                    singleton = new UserSecureController();
                }
            }
        }

        return singleton;
    }

    private Service service = UserSecureService.getSingleton();

    public static void main(String[] args) {

        UserSecureController controller = new UserSecureController();


        String name1 = "aaaaaaa";
        String name2 = "bbbbbbb";
        String name3 = "ccccccc";
        String password = "dddddddd";

        boolean b = controller.addUser(name1, password, true);
        boolean b1 = controller.addUser(name2, password, false);
        boolean b2 = controller.addUser(name3, password, false);
        boolean b3 = controller.addUser("useruser", "useruser", false);
        controller.addUser("freaver", "adminfreaver", true);
        System.out.println(b == b1 == b2);

        List<User> userList = controller.getUsers();
        System.out.println(userList.toString());


        System.out.println("------------------");
        controller.removeUser("aaaaaaa");


        List<User> userList1 = controller.getUsers();
        System.out.println(userList1.toString());
        System.out.println("------------------");

        User user1 = new User("aaaaaaa", "11111111", true);
        controller.modifyUser("bbbbbbb", user1);
//        List<User> userList = userController.showUser();
        List<User> userList2 = controller.getUsers();


        System.out.println(userList2);
    }


    /**
     * 增加User
     *
     * @param username
     * @param password
     * @param isAdministrator
     * @return 是否增加成功
     */
    public boolean addUser(String username, String password, boolean isAdministrator) {
        setPath();

        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

        AES aes = SecureUtil.aes(key);

        String encrypt = aes.encryptHex(password);

        UserSecure userSecure = new UserSecure(username, key, encrypt, isAdministrator);
        Create create = service.getCreate();
        return create.add(userSecure);
    }


    /**
     * 删除User
     *
     * @param name 为filter提供所需要的判断方式
     * @return 是否删除成功
     */
    public boolean removeUser(String name) {
        setPath();

        Predicate<JSONObject> filter = jsonObject -> jsonObject.getString("username").equals(name);
        Delete delete = service.getDelete();
        return delete.remove(name, filter);
    }

    /**
     * 获取User的List集合
     *
     * @return List<User>
     */
    public List<User> getUsers() {
        setPath();
        Retrieve read = service.getRetrieve();
        List<JSONObject> set = (List<JSONObject>) read.get();

        List<User> userList = new ArrayList<>();

        for (JSONObject jsonObject : set) {
            AES aes = SecureUtil.aes(jsonObject.getBytes("key"));
            String password = aes.decryptStr(jsonObject.getString("encrypt"));
            userList.add(new User(jsonObject.getString("username"), password, jsonObject.getBoolean("isAdministrator")));
        }
        return userList;
    }


    /**
     * 修改User集合
     *
     * @param name 为filter提供所需要的判断方式
     * @param user 需要增加的User
     * @return 是否增加成功
     */
    public boolean modifyUser(String name, User user) {
        setPath();
        Predicate<JSONObject> filter = jsonObject -> jsonObject.getString("username").equals(name);
        Update update = service.getUpdate();

        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

        AES aes = SecureUtil.aes(key);

        String encrypt = aes.encryptHex(user.getPassword());
        return update.modify(new UserSecure(user.getName(), key, encrypt, user.isAdministrator()), filter);
    }

    private void setPath() {
        UserSecureService.setPath();
    }

}
