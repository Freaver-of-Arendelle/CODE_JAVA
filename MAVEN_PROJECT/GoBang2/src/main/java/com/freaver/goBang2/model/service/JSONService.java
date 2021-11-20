package com.freaver.goBang2.model.service;



import com.freaver.goBang2.model.dao.Create;
import com.freaver.goBang2.model.dao.Delete;
import com.freaver.goBang2.model.dao.Retrieve;
import com.freaver.goBang2.model.dao.Update;
import com.freaver.goBang2.model.dao.impl.CreateJsonImpl;
import com.freaver.goBang2.model.dao.impl.DeleteJsonImpl;
import com.freaver.goBang2.model.dao.impl.RetrieveJsonImpl;
import com.freaver.goBang2.model.dao.impl.UpdateJsonImpl;

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

    public JSONService() {

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
