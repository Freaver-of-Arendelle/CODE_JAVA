package controller;

import cn.hutool.core.date.DateUtil;
import model.bean.Patient;
import model.dao.Create;
import model.dao.Delete;
import model.dao.Read;
import model.dao.Update;
import model.service.impl.PatientService;
import model.service.Service;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Set;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @Time 07/13/2021 21:53
 * @Description Patient的Controller类
 */
public class PatientController {

    private Service service = PatientService.getSingleton();

    private PatientController() {
    }

    private volatile static PatientController singleton;

    /**
     * 双重检查锁的单例模式
     *
     * @return UserSecureController
     */

    public static PatientController getSingleton() {
        if (singleton == null) {
            synchronized (PatientController.class) {
                if (singleton == null) {
                    singleton = new PatientController();
                }
            }
        }

        return singleton;
    }

    @Test
    void test() {
        String name1 = "aaa111";
        String name2 = "aaa222";
        String name3 = "aaa333";
        Date birthday1 = DateUtil.parse("2001-01-01");
        Date birthday2 = DateUtil.parse("2002-01-01");
        Date birthday3 = DateUtil.parse("2003-01-01");
        String gender1 = "male";
        String gender2 = "female";
        String gender3 = "male";
        String id1 = "68240682034580435";
        String id2 = "40364603453496043";
        String id3 = "48204588534608034";
        String tel1 = "10248204320";
        String tel2 = "10204863064";
        String tel3 = "10248230454";
        String emergencyContact1 = "eee111";
        String emergencyContact2 = "eee222";
        String emergencyContact3 = "eee333";
        String emergencyTel1 = "3479174913";
        String emergencyTel2 = "3479563213";
        String emergencyTel3 = "3479532313";

        PatientController controller = PatientController.getSingleton();

//        controller.clear();
        controller.addPatient(new Patient(name1, birthday1, gender1, id1, tel1, emergencyContact1, emergencyTel1));
        controller.addPatient(new Patient(name2, birthday2, gender2, id2, tel2, emergencyContact2, emergencyTel2));
        controller.addPatient(new Patient(name3, birthday3, gender3, id3, tel3, emergencyContact3, emergencyTel3));

        Set<Patient> patients = controller.getPatients();
        for (Patient patient : patients) {
            System.out.println(patient);
        }

    }

    /**
     * 增加Patient集合
     *
     * @param name
     * @param birthday
     * @param gender
     * @param id
     * @param tel
     * @param emergencyContact
     * @param emergencyTel
     * @return 是否增加成功
     */
    public boolean addPatient(String name, Date birthday, String gender, String id, String tel, String emergencyContact, String emergencyTel) {
        setPath();
        Patient patient = new Patient(name, birthday, gender, id, tel, emergencyContact, emergencyTel);
        Create create = service.getCreate();
        return create.add(patient);
    }

    /**
     * 增加Patient集合
     *
     * @param patient 需要增加的Problem
     * @return 是否增加成功
     */
    public boolean addPatient(Patient patient) {
        setPath();
        return service.getCreate().add(patient);
    }

    /**
     * 删除Patient
     *
     * @param name 为filter提供所需要的判断方式
     * @return 是否删除成功
     */
    public boolean removePatient(String name) {
        setPath();

        Predicate<Patient> filter = e -> e.getName().equals(name);

        Delete delete = service.getDelete();

        return delete.remove(name, filter);
    }

    /**
     * 获取Patient的Set集合
     *
     * @return Set<Patient>
     */
    public Set<Patient> getPatients() {
        setPath();
        Read read = service.getRead();
        return (Set<Patient>) read.get();
    }

    /**
     * 修改Patient集合
     *
     * @param name    为filter提供所需要的判断方式
     * @param patient 需要增加的Patient
     * @return 是否修改成功
     */
    public boolean modifyPatient(String name, Patient patient) {
        setPath();
        Predicate<Patient> filter = e -> e.getName().equals(name);
        Update update = service.getUpdate();
        return update.modify(patient, filter);
    }

    /**
     * 清空Patient集合
     *
     * @return 是否清空成功
     */
    public boolean clear() {
        setPath();
        return service.getDelete().clear();
    }

    private static void setPath() {
        PatientService.setPath();
    }

}
