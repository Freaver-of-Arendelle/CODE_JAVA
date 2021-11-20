package com.example.goBangFx.model.service;


import com.example.goBangFx.model.dao.Create;
import com.example.goBangFx.model.dao.Delete;
import com.example.goBangFx.model.dao.Retrieve;
import com.example.goBangFx.model.dao.Update;
import com.example.goBangFx.model.dao.impl.CreateJsonImpl;
import com.example.goBangFx.model.dao.impl.DeleteJsonImpl;
import com.example.goBangFx.model.dao.impl.RetrieveJsonImpl;
import com.example.goBangFx.model.dao.impl.UpdateJsonImpl;

import java.io.File;

/**
 * @author Freaver
 * @date 07/13/2021 15:59
 * @description
 */
public  class JSONService implements Service {

    private CreateJsonImpl create;
    private RetrieveJsonImpl read;
    private UpdateJsonImpl update;
    private DeleteJsonImpl delete;

    private String path;

    public JSONService(String path) {
        this.path = path;
    }

    /**
     * 获取以序列化方式的Read类型的对象
     *
     * @return Read
     */
    @Override
    public Retrieve getRead() {
        read = RetrieveJsonImpl.getSingleton();
        read.setFile(new File(path));
        return read;
    }


    /**
     * 获取以序列化方式的Create类型的对象
     *
     * @return Create
     */
    @Override
    public Create getCreate() {
        create = CreateJsonImpl.getSingleton();
        create.setFile(new File(path));
        return create;
    }


    /**
     * 获取以序列化方式的Update类型的对象
     *
     * @return Update
     */
    @Override
    public Update getUpdate() {

        update = UpdateJsonImpl.getSingleton();
        update.setFile(new File(path));
        return update;
    }


    /**
     * 获取以序列化方式的Delete类型的对象
     *
     * @return Delete
     */
    @Override
    public Delete getDelete() {
        delete = DeleteJsonImpl.getSingleton();
        delete.setFile(new File(path));
        return delete;
    }
}
