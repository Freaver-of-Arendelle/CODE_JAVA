package controller;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import com.alibaba.fastjson.JSONObject;
import model.bean.User;
import model.bean.UserSecure;
import model.dao.*;
import model.service.Service;
import model.service.impl.UserSecureService;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @Time 07/10/2021 23:58
 * @Description UserSecure的Controller层类
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

        String name1 = "Freaver";
        String name2 = "Arendelle";
        String name3 = "JetBrains";
        String name4 = "oneNote";
        String password1 = "Freaveradmin";
        String password2 = "Arendelle";
        String password3 = "JetBrains";
        String password4 = "WoneNote";

        System.out.println(controller.clear());
        boolean b = controller.addUser(name1, password1, true);
        boolean b1 = controller.addUser(name2, password2, false);
        boolean b2 = controller.addUser(name3, password3, false);
        boolean b3 = controller.addUser(name4, password4, false);
        System.out.println(b == b1 == b2 == b3);

        Set<User> userSet = controller.getUsers();
        for (User user : userSet) {
            System.out.println(user);
        }

        System.out.println("---------------------------");

        System.out.println(controller.clear());
        controller.addUser(name1, password1, true);
        controller.addUser(name2, password2, false);
        controller.addUser(name3, password3, false);
        controller.addUser(name4, password4, false);

        Set<User> userSet1 = controller.getUsers();
        for (User user : userSet1) {
            System.out.println(user);
        }

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
        BigInteger a;
//        a.add()

        Predicate<JSONObject> filter = jsonObject -> jsonObject.getString("username").equals(name);
        Delete delete = service.getDelete();
        return delete.remove(name, filter);
    }

    /**
     * 获取User的Set集合
     *
     * @return Set<User>
     */
    public Set<User> getUsers() {
        setPath();
        Read read = service.getRead();
        Set<JSONObject> set = (Set<JSONObject>)read.get();

        Set<User> userSet = new HashSet<>();

        for (JSONObject jsonObject : set) {
            AES aes = SecureUtil.aes(jsonObject.getBytes("key"));
            String password = aes.decryptStr(jsonObject.getString("encrypt"));
            userSet.add(new User(jsonObject.getString("username"), password, jsonObject.getBoolean("isAdministrator")));
        }
        return userSet;
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
        return update.modify(new UserSecure(user.getUserName(), key, encrypt, user.getIsAdministrator()), filter);
    }

    public boolean clear() {
        setPath();
        return service.getDelete().clear();
    }

    private void setPath() {
        UserSecureService.setPath();
    }

}
