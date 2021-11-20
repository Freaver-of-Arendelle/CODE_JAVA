package model.service;

import model.dao.*;

/**
 * @author Freaver
 * @Time 07/10/2021 23:14
 * @Description Service接口
 */
public interface  Service {

    /**
     * 得到一个Read类型的对象
     * @return Read
     */
    Read getRead();

    /**
     * 得到一个Create类型的对象
     * @return Create
     */
    Create getCreate();


    /**
     * 得到一个Update类型的对象
     * @return Update
     */
    Update getUpdate();


    /**
     * 得到一个Delete类型的对象
     * @return Delete
     */
    Delete getDelete();


}