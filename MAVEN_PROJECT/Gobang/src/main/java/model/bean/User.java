package model.bean;

import java.util.ArrayList;
import java.util.List;

public  class User {
    private String name;
    private String password;
    private Boolean administrator;
    private List<Board> boardList;

    public User(String name, String password, boolean authority) {
        this.name = name;
        this.password = password;
        this.administrator = authority;
        boardList = new ArrayList<>();
    }

    private String authority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addBoard(Board board) {
        boardList.add(board);
    }

    public List<Board> getBoardList() {
        return boardList;
    }


}
