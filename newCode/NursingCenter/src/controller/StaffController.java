package controller;

import model.bean.Staff;
import model.dao.Create;
import model.dao.Delete;
import model.dao.Read;
import model.dao.Update;
import model.service.Service;
import model.service.StaffService;

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

    public static void main(String[] args) {

        String username = "aaaaaaa";
        String name = "aaaaa11";
        Date birthday = new Date();
        String speciality = "go";
        String jobTitle = "nurse";
        String tel = "13359348294";
        String username1 = "bbbbbbb";
        String name1 = "aaadgf1";
        Date birthday1 = new Date(4);
        String speciality1 = "geo";
        String jobTitle1 = "nursed";
        String tel1 = "13359334294";
        String username2 = "bbbbbbb";
        String name2 = "aaaaat1";
        Date birthday2 = new Date(2);
        String speciality2 = "god";
        String jobTitle2 = "nurser";
        String tel2 = "13359348284";


        StaffController controller = new StaffController();

        controller.addStaff(username, name, birthday, speciality, jobTitle, tel);
        controller.addStaff(username1, name1, birthday1, speciality1, jobTitle1, tel1);
        controller.addStaff(username2, name2, birthday2, speciality2, jobTitle2, tel2);

        Set<Staff> set = controller.getStaffs();
        System.out.println(set.toString());

        System.out.println("------------");

        Set<Staff> set1 = controller.getStaffs();
        System.out.println(set1);
        System.out.println("---------------");


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

        Delete delete = service.getDelete();

        return delete.remove(username, filter);
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
        return service.getDelete().clear();
    }

    private void setPath() {
        StaffService.setPath();
    }

}
