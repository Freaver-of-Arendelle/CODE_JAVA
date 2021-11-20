package dao.impl;

import dao.DiskIO;
import models.bean.CoffeeSummary;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Freaver
 * @Date: 3/25/2021  09:38
 */
public class DiskIOImpl implements DiskIO {

    static PrintWriter out;
    static Scanner in;

    static {
        try {
            in = new Scanner(new FileInputStream("ProductList.dat"), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            out = new PrintWriter("ProductList.dat", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void add(CoffeeSummary object) {
        out.println(object);
    }

    @Override public void delete(String name, String code) {
        CoffeeSummary objectToDelete = find(name, code);
        var deleteFields = objectToDelete.getClass().getFields();
        CoffeeSummary[] objects = readData(in, (CoffeeSummary o) -> {
            if (name.contentEquals(o.getName()) && code.contentEquals(o.getCode())) {
                return 0;
            } else {
                return 1;
            }
        });

        try {
            Files.delete(Path.of("ProductList.dat"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            PrintWriter newOut = new PrintWriter("ProductList.dat", StandardCharsets.UTF_8);
            for (var v : objects) {
                var vFields = v.getClass().getFields();
                if (Arrays.equals(vFields, deleteFields)) {
                    newOut.println(v);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override public void modify() {

    }

    @Override public CoffeeSummary find(String name, String code) {
        CoffeeSummary[] objects = readData(in, (CoffeeSummary o) -> {
            if (name.contentEquals(o.getName()) && code.contentEquals(o.getCode())) {
                return 1;
            } else {
                return 0;
            }
        });
        return objects[0];
    }

    public static CoffeeSummary[] readData(Scanner in, Comparable<CoffeeSummary> c) {
        int n = in.nextInt();
        in.nextLine();
        var objects = new CoffeeSummary[n];
        if (c == null) {
            for (int i = 0; i < n; i++) {
                objects[i] = readCoffee(in);
            }
        } else {
            CoffeeSummary coffeeSummary;
            for (int i = 0; i < n; i++) {
                coffeeSummary = readCoffee(in);
                if (c.compareTo(coffeeSummary) > 0) {
                    objects[i] = coffeeSummary;
                }
            }
        }

        return objects;
    }

    public static CoffeeSummary readCoffee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        String code = tokens[1];
        float price = Float.parseFloat(tokens[2]);
        int num = Integer.parseInt(tokens[3]);

        return new CoffeeSummary(name, code, price, num);
    }

}
