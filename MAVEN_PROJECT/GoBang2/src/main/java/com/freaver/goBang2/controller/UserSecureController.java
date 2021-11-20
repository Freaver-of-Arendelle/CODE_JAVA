package com.freaver.goBang2.controller;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import com.alibaba.fastjson.JSONObject;
import com.freaver.goBang2.model.bean.User;
import com.freaver.goBang2.model.bean.UserSecure;
import com.freaver.goBang2.model.dao.Create;
import com.freaver.goBang2.model.dao.Delete;
import com.freaver.goBang2.model.dao.Update;
import com.freaver.goBang2.model.service.SerializationService;
import com.freaver.goBang2.model.service.Service;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @date 07/10/2021 23:58
 * @description UserSecure的Controller层类
 */
public class UserSecureController {

    private static String path = "src/main/resources/data/userSecure.dat";
//    private static String path;

    private Service service = SerializationService.getSingleton(path);

    public UserSecureController(String path) {
        UserSecureController.path = path;


    }

//    private void init() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
//        service = app.getBean("serializationService", SerializationService.class);
//        service = SerializationService.getSingleton(path);

//    }

        private static volatile UserSecureController singleton;

        public static UserSecureController getSingleton() {
            if (singleton == null) {
                synchronized (UserSecureController.class) {
                    if (singleton == null) {
                        singleton = new UserSecureController(path);
                    }
                }
            }

            return singleton;
        }


    private void setPath(String path) {
        UserSecureController.path = path;
    }

    /**
     * 增加User
     *
     * @param username
     * @param password
     * @return 是否增加成功
     */
    public boolean addUser(String username, String password) {
        setPath(path);
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

        AES aes = SecureUtil.aes(key);

        String encrypt = aes.encryptHex(password);

        UserSecure userSecure = new UserSecure(username, key, encrypt, "");
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
        Predicate<JSONObject> filter = jsonObject -> jsonObject.getString("username").equals(name);
        Delete delete = service.getDelete();
        return delete.remove(name, filter);
    }

    /**
     * 获取User的Set集合
     *
     * @return Set<User>
     */
    public List<User> getUsers() {
        File file = new File(path);
        List<UserSecure> userSecures = (List<UserSecure>)service.getRead().get();
        List<User> userList = new ArrayList<>();
        for (UserSecure userSecure : userSecures) {
            userList.add(new User(userSecure.getUsername(),
                SecureUtil.aes(userSecure.getKey()).decryptStr(userSecure.getEncrypt()), userSecure.getPhone()));
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
        Predicate<UserSecure> filter = e -> e.getUsername().equals(name);
        Update update = service.getUpdate();

        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

        AES aes = SecureUtil.aes(key);

        String encrypt = aes.encryptHex(user.getPassword());
        return update.modify(new UserSecure(user.getName(), key, encrypt, user.getPhone()), filter);
    }

}
