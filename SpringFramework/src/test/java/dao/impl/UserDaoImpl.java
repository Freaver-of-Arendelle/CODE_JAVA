package dao.impl;

/**
 * @author Freaver
 * @date 5/14/2021
 */
public class UserDaoImpl implements UserDao{
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    @Override
    public void show() {
        System.out.println("UserDao " + userName  + " " + password);
    }
}
