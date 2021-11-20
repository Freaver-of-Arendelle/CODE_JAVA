package model.dao.impl;

import com.alibaba.fastjson.JSONArray;
import model.dao.Read;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * @author Freaver
 * @Time 07/12/2021 13:58
 * @Description 用于Json文件的Read实现类
 */
public class ReadJsonImpl<S> implements Read {

    private File file;

    /**
     * 设置文件路径
     *
     * @param file
     */
    public void setFile(File file) {
        this.file = file;
    }


    private volatile static ReadJsonImpl singleton;

    private ReadJsonImpl() {
    }

    /**
     * 双重检查锁实现的单例模式
     */

    public static ReadJsonImpl getSingleton() {
        if (singleton == null) {
            synchronized (ReadJsonImpl.class) {
                if (singleton == null) {
                    singleton = new ReadJsonImpl();
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
        if (!file.exists() || file.length() == 0) {
            return null;
        }
        try {
            String s = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            Set set = JSONArray.parseObject(s, Set.class);
            return set;
        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }
    }

}
