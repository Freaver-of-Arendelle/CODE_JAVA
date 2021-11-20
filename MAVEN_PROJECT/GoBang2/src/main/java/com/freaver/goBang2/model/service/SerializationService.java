package com.freaver.goBang2.model.service;

import com.freaver.goBang2.model.dao.Create;
import com.freaver.goBang2.model.dao.Delete;
import com.freaver.goBang2.model.dao.Retrieve;
import com.freaver.goBang2.model.dao.Update;
import com.freaver.goBang2.model.dao.impl.CreateSerializationImpl;
import com.freaver.goBang2.model.dao.impl.DeleteSerializationImpl;
import com.freaver.goBang2.model.dao.impl.RetrieveSerializationImpl;
import com.freaver.goBang2.model.dao.impl.UpdateSerializationImpl;

import java.io.File;

/**
 * @author Freaver
 * @date 07/13/2021 15:44
 * @description
 */
public class SerializationService implements Service {

    private String path;


    private static volatile SerializationService singleton;



    private SerializationService() {
    }

    public static SerializationService getSingleton(String path) {
        if (singleton == null) {
            synchronized (SerializationService.class) {
                if (singleton == null) {
                    singleton = new SerializationService();
                }
            }
        }
        singleton.path = path;
        return singleton;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private CreateSerializationImpl create;
    private RetrieveSerializationImpl read;
    private UpdateSerializationImpl update;
    private DeleteSerializationImpl delete;

    /**
     * 获取以序列化方式的Read类型的对象
     *
     * @return Read
     */
    @Override public Retrieve getRead() {
        read = RetrieveSerializationImpl.getSingleton();
        read.setFile(new File(path));
        return read;
    }

    /**
     * 获取以序列化方式的Create类型的对象
     *
     * @return Create
     */
    @Override public Create getCreate() {
        create = CreateSerializationImpl.getSingleton();
        create.setFile(new File(path));
        return create;
    }

    /**
     * 获取以序列化方式的Update类型的对象
     *
     * @return Update
     */
    @Override public Update getUpdate() {
        update = UpdateSerializationImpl.getSingleton();
        update.setFile(new File(path));
        return update;
    }

    /**
     * 获取以序列化方式的Delete类型的对象
     *
     * @return Delete
     */
    @Override public Delete getDelete() {
        delete = DeleteSerializationImpl.getSingleton();
        delete.setFile(new File(path));
        return delete;
    }

}
