package model.service;

import model.dao.Create;
import model.dao.Delete;
import model.dao.Retrieve;
import model.dao.Update;

/**
 * @author Freaver
 * @date 10/12/2021
 * @time 19:26
 */
public interface Service {


    Create getCreate();

    Retrieve getRetrieve();

    Update getUpdate();

    Delete getDelete();


}
