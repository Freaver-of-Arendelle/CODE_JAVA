package controller;

import cn.hutool.system.oshi.OshiUtil;
import com.alibaba.fastjson.JSONObject;
import model.bean.Staff;
import model.bean.User;
import model.dao.Create;
import model.dao.Delete;
import model.dao.Read;
import model.dao.Update;
import model.service.Service;
import model.service.impl.StaffService;
import model.service.impl.UserSecureService;
import org.junit.jupiter.api.Test;

import java.lang.invoke.VarHandle;
import java.util.*;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @Time 07/12/2021 10:32
 * @Description Staff的controller类
 */
public class StaffController {

    private Service service = StaffService.getSingleton();

    private volatile static StaffController singleton;

    private Service userService = UserSecureService.getSingleton();

    private StaffController() {
    }

    /**
     * 双重检查锁的单例模式
     *
     * @return UserSecureController
     */

    public static StaffController getSingleton() {
        if (singleton == null) {
            synchronized (StaffController.class) {
                if (singleton == null) {
                    singleton = new StaffController();
                }
            }
        }
        return singleton;
    }

    @Test
    void test() {

        String username = "Freaver";
        String name = "FrName";
        Date birthday = new Date();
        String speciality = "go";
        String jobTitle = "nurse";
        String tel = "13359348294";
        String username1 = "Arendelle";
        String name1 = "ArName";
        Date birthday1 = new Date(4);
        String speciality1 = "geo";
        String jobTitle1 = "doctor";
        String tel1 = "13359334294";
        String username2 = "JetBrains";
        String name2 = "JetName";
        Date birthday2 = new Date(2);
        String speciality2 = "god";
        String jobTitle2 = "worker";
        String tel2 = "13359348284";
        String username3 = "oneName";
        String name3 = "oneName";
        Date birthday3 = new Date(3);
        String speciality3 = "yyds";
        String jobTitle3 = "cleaner";
        String tel3 = "13359340084";


        StaffController controller = new StaffController();

        boolean clear = controller.clear();
        System.out.println(clear);

        controller.addStaff(username, name, birthday, speciality, jobTitle, tel);
        controller.addStaff(username1, name1, birthday1, speciality1, jobTitle1, tel1);
        controller.addStaff(username2, name2, birthday2, speciality2, jobTitle2, tel2);
        controller.addStaff(username3, name3, birthday3, speciality3, jobTitle3, tel3);

        Set<Staff> set = controller.getStaffs();
        for (Staff staff : set) {
            System.out.println(staff);
        }

        System.out.println("------------------");

        boolean clear1 = controller.clear();
        System.out.println(clear1);


        controller.addStaff(username, name, birthday, speciality, jobTitle, tel);
        controller.addStaff(username1, name1, birthday1, speciality1, jobTitle1, tel1);
        controller.addStaff(username2, name2, birthday2, speciality2, jobTitle2, tel2);
        controller.addStaff(username3, name3, birthday3, speciality3, jobTitle3, tel3);

        Set<Staff> set1 = controller.getStaffs();
        for (Staff staff : set1) {
            System.out.println(staff);
        }



    }

    /**
     * 增加Staff集合
     *
     * @param username
     * @param name
     * @param birthday
     * @param speciality
     * @param jobTitle
     * @param tel
     * @return 是否增加成功
     */
    public boolean addStaff(String username, String name, Date birthday, String speciality, String jobTitle, String tel) {
        setPath();
        Staff staff = new Staff(username, name, birthday, speciality, jobTitle, tel);
        Create create = service.getCreate();
        return create.add(staff);
    }

    /**
     * 增加Staff集合
     *
     * @param staff 需要增加的Problem
     * @return 是否增加成功
     */
    public boolean addStaff(Staff staff) {

        setPath();
        return service.getCreate().add(staff);
    }

    /**
     * 删除Staff
     *
     * @param username 为filter提供所需要的判断方式
     * @return 是否删除成功
     */
    public boolean removeStaff(String username) {
        setPath();

        Predicate<Staff> filter = e -> e.getUsername().equals(username);
        Predicate<JSONObject> userFilter = e -> e.getString("username").equals(username);

        Delete delete = service.getDelete();

        if (delete.remove(username, filter) ) {
            return userService.getDelete().remove(username, userFilter);
        } else {
            return false;
        }
     }

    /**
     * 获取Staff的Set集合
     *
     * @return Set<Staff>
     */
    public Set<Staff> getStaffs() {
        setPath();

        Read read = service.getRead();
        return (Set<Staff>) read.get();
    }


    /**
     * 修改Staff集合
     *
     * @param name  为filter提供所需要的判断方式
     * @param staff 需要增加的Staff
     * @return 是否修改成功
     */
    public boolean modifyStaff(String name, Staff staff) {
        setPath();
        Predicate<Staff> filter = e -> e.getUsername().equals(name);
        Update update = service.getUpdate();
        return update.modify(staff, filter);
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
        StaffService.setPath();
    }

}
