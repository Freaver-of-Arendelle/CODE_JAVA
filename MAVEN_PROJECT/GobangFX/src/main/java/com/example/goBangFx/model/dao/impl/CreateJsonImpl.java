package com.example.goBangFx.model.dao.impl;

import com.alibaba.fastjson.JSON;
import com.example.goBangFx.model.dao.Create;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Freaver
 * @date 07/12/2021 13:57
 * @description 用于json文件的Create实现类
 */
public class CreateJsonImpl implements Create {

    private volatile static CreateJsonImpl singleton;

    private CreateJsonImpl() {
    }

    /**
     * 双重检查锁实现的单例模式
     */

    public static CreateJsonImpl getSingleton() {
        if (singleton == null) {
            synchronized (CreateJsonImpl.class) {
                if (singleton == null) {
                    singleton = new CreateJsonImpl();

                }
            }
        }
        return singleton;
    }

    private File file;

    /**
     * 设置文件路径
     *
     * @param file
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * 需要传递file的add，用于设置file的路径
     *
     * @param o 待增加对象
     * @param file 文件路径
     * @return 增加是否成功
     */
    @Override public boolean add(Object o, File file) {

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
            String s = null;
            List<Object> list = new ArrayList<>();
            if (file.length() == 0 || !file.exists()) {
                list.add(o);
            } else if (o instanceof Set) {
                list = (List<Object>)o;
            } else {
                RetrieveJsonImpl read = RetrieveJsonImpl.getSingleton();
                list = read.get(file);
                list.add(o);
            }
            s = JSON.toJSONString(list, true);
            FileUtils.writeStringToFile(file, s, StandardCharsets.UTF_8, false);
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
    @Override public boolean add(Object o) {

        return init(o, file);
    }
}
