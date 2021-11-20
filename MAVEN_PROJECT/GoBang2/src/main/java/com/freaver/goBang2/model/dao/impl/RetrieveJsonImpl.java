package com.freaver.goBang2.model.dao.impl;

import com.alibaba.fastjson.JSONArray;
import com.freaver.goBang2.model.dao.Retrieve;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Freaver
 * @date 07/12/2021 13:58
 * @description 用于Json文件的Read实现类
 */
public class RetrieveJsonImpl<S> implements Retrieve {

    private File file;

    /**
     * 设置文件路径
     *
     * @param file
     */
    public void setFile(File file) {
        this.file = file;
    }


    private volatile static RetrieveJsonImpl singleton;

    private RetrieveJsonImpl() {
    }

    /**
     * 双重检查锁实现的单例模式
     */

    public static RetrieveJsonImpl getSingleton() {
        if (singleton == null) {
            synchronized (RetrieveJsonImpl.class) {
                if (singleton == null) {
                    singleton = new RetrieveJsonImpl();
                }
            }
        }

        return singleton;
    }

    /**
     * 需要传递file的get，用于设置file的路径
     *
     * @return 查询是否成功
     */
    @Override
    public List get() {
        try {
            String s = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            List list = JSONArray.parseObject(s, List.class);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }
    }
}
