package model.dao.impl;


import model.dao.Create;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Freaver
 * @Time 07/10/2021 14:19
 * @Description 用于序列化文件的增加实现类
 */
public class CreateSerializationImpl implements Create {

    private File file;

    /**
     * 设置文件路径
     *
     * @param file
     */
    public void setFile(File file) {
        this.file = file;
    }


    private volatile static CreateSerializationImpl singleton;

    private CreateSerializationImpl() {
    }

    /**
     * 双重检查锁实现的单例模式
     */

    public static CreateSerializationImpl getSingleton() {
        if (singleton == null) {
            synchronized (CreateSerializationImpl.class) {
                if (singleton == null) {
                    singleton = new CreateSerializationImpl();
                }
            }

        }
        return singleton;
    }

    /**
     * 需要传递file的add，用于设置file的路径
     *
     * @param o 待增加对象
     * @param file 文件路径
     * @return 增加是否成功
     */
    @Override
    public boolean add(Object o, File file) {
        return init(o, file);
    }

    /**
     * 由于存在两个只有签名不同add函数，为实现代码复用而生成的函数
     *
     * @param o 待增加对象
     * @param file 文件路径
     * @return 增加是否成功
     */
    private boolean init(Object o, File file) {
        try {
            Set<Object> set = new HashSet<>();
            long length = file.length();
            if (length == 0 || !file.exists()) {
                set.add(o);
            } else if (o instanceof Set) {
                set = (Set<Object>) o;
            } else {
                ReadSerializationImpl read = ReadSerializationImpl.getSingleton();
                set = read.get(file);
                set.add(o);
            }
            FileOutputStream fos = FileUtils.openOutputStream(file, false);
            ObjectOutput oop = new ObjectOutputStream(fos);
            oop.writeObject(set);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 无需传递文件版的add，用在内部传递用
     *
     * @param o 待增加对象
     * @return 增加是否成功
     */
    @Override
    public boolean add(Object o) {
        return init(o, file);
    }

}
