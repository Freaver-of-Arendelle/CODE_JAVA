package com.freaver.goBang2.view.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Freaver
 * @date 10/17/2021
 * @time 01:44
 */
public class Tools {

    public static String millsToString(long mills) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZoneId.systemDefault()));
    }

    public static boolean insert(Connection connection, String table, Object object) {
        try {

            StringBuilder sb = new StringBuilder();
            Class<?> clazz = object.getClass();

            Field[] fields = clazz.getDeclaredFields();
            Map<String, Object> map = new HashMap<>();
            for (Field field : fields) {
                field.setAccessible(true);
                String key = field.getName();
                Object value = field.get(object);
                if (value != null) {
                    map.put(key, value);
                }
                sb.append("INSERT INTO").append(table).append("(");
                List<String> keys = new ArrayList<>();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    keys.add(entry.getKey());
                }

                for (int i = 0; i < keys.size() - 1; i++) {
                    sb.append(keys.get(i)).append(",");
                }
                sb.append(keys.get(keys.size() - 1)).append(") VALUES(");

                sb.append("? , ".repeat(keys.size() - 1));
                sb.append("? )");
                PreparedStatement ps = connection.prepareStatement(sb.toString());
                for (int i = 0; i < keys.size(); i++) {
                    ps.setObject(i + 1, keys.get(i));
                }
                int result = ps.executeUpdate();
                return result > 0;

            }
        } catch (IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void addListener(TextField textField, Label label) {
        textField.focusedProperty().addListener((observableValue, aBoolean, t1) -> {
            String text = textField.getText();
            String pattern = "^\\w{6}$";
            if (Pattern.matches(pattern, text)) {
                label.setText("");
            } else {
                label.setText("密码格式错误");
            }
        });
    }

    public static void popAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.titleProperty().set("错误");
        alert.headerTextProperty().set(s);
        alert.showAndWait();
    }
}
