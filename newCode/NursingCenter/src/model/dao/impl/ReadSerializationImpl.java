package model.dao.impl;

import model.dao.Read;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

/**
 * @author Freaver
 * @Time 07/10/2021 14:40
 * @Description 用于序列化文件的Read实现类
 */
public class ReadSerializationImpl<S> implements Read {

    private File file;


    /**
     * 设置文件路径
     *
     * @param file
     */
    public void setFile(File file) {
        this.file = file;
    }




    private volatile static ReadSerializationImpl singleton;

    private ReadSerializationImpl() {
    }


    /**
     * 双重检查锁实现的单例模式
     */
    public static ReadSerializationImpl getSingleton() {
        if (singleton == null) {
            synchronized (ReadSerializationImpl.class) {
                if (singleton == null) {
                    singleton = new ReadSerializationImpl();
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
    public Set get(File file) {
        return init(file);
    }

    /**
     * 需要传递file的get，用于设置file的路径
     *
     * @return 查询是否成功
     */
    @Override
    public Set get() {
        return init(file);
    }

    /**
     * 由于存在两个只有签名不同get函数，为实现代码复用而生成的函数
     *
     * @param file 文件路径
     * @return 查询是否成功
     */
    private Set init(File file) {
        try {
            FileInputStream fis = FileUtils.openInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Set set = (Set) ois.readObject();
            return set;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }



}
