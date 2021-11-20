package com.example.goBangFx.model.service;

import com.example.goBangFx.model.dao.Create;
import com.example.goBangFx.model.dao.Delete;
import com.example.goBangFx.model.dao.Retrieve;
import com.example.goBangFx.model.dao.Update;

/**
 * @author Freaver
 * @date 07/10/2021 23:14
 * @description Service接口
 */
public interface  Service {

    /**
     * 得到一个Read类型的对象
     * @return Read
     */
    Retrieve getRead();

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