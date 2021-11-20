package controller;

import com.alibaba.fastjson.JSONObject;
import model.bean.Estimator;
import model.bean.Staff;
import model.dao.Create;
import model.dao.Delete;
import model.dao.Read;
import model.dao.Update;
import model.service.Service;
import model.service.impl.EstimatorService;
import model.service.impl.StaffService;
import model.service.impl.UserSecureService;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Set;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @Time 07/12/2021 10:32
 * @Description Staff的controller类
 */
public class EstimatorController {

    private Service service = EstimatorService.getSingleton();

    private volatile static EstimatorController singleton;


    private EstimatorController() {
    }

    /**
     * 双重检查锁的单例模式
     *
     * @return UserSecureController
     */

    public static EstimatorController getSingleton() {
        if (singleton == null) {
            synchronized (EstimatorController.class) {
                if (singleton == null) {
                    singleton = new EstimatorController();
                }
            }
        }
        return singleton;
    }

    @Test
    void test() {
        EstimatorController.getSingleton().clear();

    }


    public boolean addEstimator(String name, String gender, String templateName, String templateType, Date date, String appraiser, String suggestion) {
        setPath();
        Estimator estimator = new Estimator(name, gender, templateName, templateType, date, appraiser, suggestion);
        Create create = service.getCreate();
        return create.add(estimator);
    }


    public boolean addEstimator(Estimator estimator) {

        setPath();
        return service.getCreate().add(estimator);
    }

    /**
     * 删除Staff
     *
     * @param name 为filter提供所需要的判断方式
     * @return 是否删除成功
     */
    public boolean removeEstimator(String name) {
        setPath();

        Predicate<Estimator> filter = e -> e.getName().equals(name);

        return service.getDelete().remove(name, filter);
    }

    /**
     * 获取Staff的Set集合
     *
     * @return Set<Staff>
     */
    public Set<Estimator> getEstimators() {
        setPath();

        Read read = service.getRead();
        return (Set<Estimator>) read.get();
    }



    public boolean modifyEstimator(String name, Estimator estimator) {
        setPath();
        Predicate<Estimator> filter = e -> e.getName().equals(name);
        Update update = service.getUpdate();
        return update.modify(estimator, filter);
    }

    /**
     * 清空Staff集合
     *
     * @return 是否清空成功
     */
    public boolean clear() {
        setPath();
        return service.getDelete().clear();
    }

    private void setPath() {
        EstimatorService.setPath();
    }

}
