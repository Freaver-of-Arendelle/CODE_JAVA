package com.example.goBangFx.controller;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import com.alibaba.fastjson.JSONObject;
import com.example.goBangFx.model.bean.User;
import com.example.goBangFx.model.bean.UserSecure;
import com.example.goBangFx.model.dao.Create;
import com.example.goBangFx.model.dao.Delete;
import com.example.goBangFx.model.dao.Update;
import com.example.goBangFx.model.service.Service;

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

    private static String path;

    private final Service SERVICE;
    public UserSecureController(Service service) {
        this.SERVICE = service;
    }

//    private static volatile UserSecureController singleton;

//    /**
//     * 双重检查锁的单例模式
//     *
//     * @return UserSecureController
//     */
//    public static UserSecureController getSingleton() {
//        if (singleton == null) {
//            synchronized (UserSecureController.class) {
//                if (singleton == null) {
//                    singleton = new UserSecureController();
//                }
//            }
//        }

//        return singleton;
//    }


    private void setPath(String path) {
        UserSecureController.path = path;
    }

    public boolean addUser(String username, String password, boolean isAdministrator) {
//        setPath(path);
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

        AES aes = SecureUtil.aes(key);

        String encrypt = aes.encryptHex(password);

        UserSecure userSecure = new UserSecure(username, key, encrypt, isAdministrator);
        Create create = SERVICE.getCreate();
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
        Delete delete = SERVICE.getDelete();
        return delete.remove(name, filter);
    }

    /**
     * 获取User的Set集合
     *
     * @return Set<User>
     */
    public List<User> getUsers() {
//        File file = new File(path);
        List<UserSecure> userSecures = (List<UserSecure>)SERVICE.getRead().get();
        List<User> userList = new ArrayList<>();
        for (UserSecure userSecure : userSecures) {
            userList.add(new User(userSecure.getUsername(),
                SecureUtil.aes(userSecure.getKey()).decryptStr(userSecure.getEncrypt()), false));
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
        Predicate<JSONObject> filter = jsonObject -> jsonObject.getString("username").equals(name);
        Update update = SERVICE.getUpdate();

        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

        AES aes = SecureUtil.aes(key);

        String encrypt = aes.encryptHex(user.getPassword());
        return update.modify(new UserSecure(user.getName(), key, encrypt, user.getIsAdministrator()), filter);
    }
}
