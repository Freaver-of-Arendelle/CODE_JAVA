package model.service;

import model.dao.Create;
import model.dao.Delete;
import model.dao.Retrieve;
import model.dao.Update;
import model.dao.impl.CreateJsonImpl;
import model.dao.impl.DeleteJsonImpl;
import model.dao.impl.RetrieveJsonImpl;
import model.dao.impl.UpdateJsonImpl;

import java.io.File;

/**
 * @author Freaver
 * @date 07/13/2021 15:59
 * @description
 */
public abstract class JSONService implements Service {

    private CreateJsonImpl create;
    private RetrieveJsonImpl read;
    private UpdateJsonImpl update;
    private DeleteJsonImpl delete;

    private static String path;


    /**
     * 以字符串方式设置文件路径
     *
     * @param path 文件路径的字符串形式
     */
    public static void setPath(String path) {
        JSONService.path = path;
    }

    public static String getPath() {
        return path;
    }

    protected JSONService() {
    }


    /**
     * 获取以序列化方式的Read类型的对象
     *
     * @return Read
     */
    @Override
    public Retrieve getRetrieve() {
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
