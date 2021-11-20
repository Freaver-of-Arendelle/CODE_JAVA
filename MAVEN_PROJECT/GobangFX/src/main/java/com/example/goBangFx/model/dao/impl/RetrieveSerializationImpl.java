package com.example.goBangFx.model.dao.impl;

import com.example.goBangFx.model.dao.Retrieve;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Set;

/**
 * @author Freaver
 * @date 07/10/2021 14:40
 * @description 用于序列化文件的Read实现类
 */
public class RetrieveSerializationImpl<S> implements Retrieve {

    private File file;


    /**
     * 设置文件路径
     *
     * @param file
     */
    public void setFile(File file) {
        this.file = file;
    }




    private volatile static RetrieveSerializationImpl singleton;

    private RetrieveSerializationImpl() {
    }


    /**
     * 双重检查锁实现的单例模式
     */
    public static RetrieveSerializationImpl getSingleton() {
        if (singleton == null) {
            synchronized (RetrieveSerializationImpl.class) {
                if (singleton == null) {
                    singleton = new RetrieveSerializationImpl();
                }
            }

        }
        return singleton;
    }


    /**
     * 需要传递file的get，用于设置file的路径
     *
     * @param file 文件路径
     * @return 查询是否成功
     */
    @Override
    public List get(File file) {
        return init(file);
    }

    /**
     * 需要传递file的get，用于设置file的路径
     *
     * @return 查询是否成功
     */
    @Override
    public List get() {
        return init(file);
    }

    /**
     * 由于存在两个只有签名不同get函数，为实现代码复用而生成的函数
     *
     * @param file 文件路径
     * @return 查询是否成功
     */
    private List init(File file) {
        try {
            FileInputStream fis = FileUtils.openInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List list = (List) ois.readObject();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }



}
