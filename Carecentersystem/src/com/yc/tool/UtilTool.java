package com.yc.tool;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class UtilTool {
	/**
	 * 
	 * @param path
	 *            �ַ��� ���л��ļ���·�����ļ���
	 * @param obj
	 *            Object ���� ��������ʵ�����л��ӿڵĶ���
	 */
	public static void save(String path, Object obj) {

		try {
			OutputStream os = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(obj);
			oos.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object getObject(String path) {
		Object obj = null;
		try {
			InputStream is = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(is);
			obj = ois.readObject();
			ois.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
