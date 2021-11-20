package com.freaver.goBang2.model.service;

import com.freaver.goBang2.model.dao.Create;
import com.freaver.goBang2.model.dao.Delete;
import com.freaver.goBang2.model.dao.Retrieve;
import com.freaver.goBang2.model.dao.Update;

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