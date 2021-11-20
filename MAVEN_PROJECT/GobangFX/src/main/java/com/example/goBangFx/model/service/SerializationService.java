package com.example.goBangFx.model.service;

import com.example.goBangFx.controller.UserSecureController;
import com.example.goBangFx.model.dao.Create;
import com.example.goBangFx.model.dao.Delete;
import com.example.goBangFx.model.dao.Retrieve;
import com.example.goBangFx.model.dao.Update;
import com.example.goBangFx.model.dao.impl.CreateSerializationImpl;
import com.example.goBangFx.model.dao.impl.DeleteSerializationImpl;
import com.example.goBangFx.model.dao.impl.RetrieveSerializationImpl;
import com.example.goBangFx.model.dao.impl.UpdateSerializationImpl;

import java.io.File;

/**
 * @author Freaver
 * @date 07/13/2021 15:44
 * @description
 */
public class SerializationService implements Service {

    private String path;

    private SerializationService() {
    }

    private static volatile SerializationService singleton;

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
