package com.zjm.dao.tool;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class UtilTool {
	/**
	 * 
	 * @param path
	 *            �ַ��� ���л��ļ���·�������ļ���
	 * @param obj
	 *            Object���� Ԥ������Ѿ�ʵ�����л��ӿڵĶ���
	 */
	public static void saveFileBySerialize(String path, Object obj) {
		try {
			OutputStream os = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(obj);
			oos.close();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param path
	 *            �ַ��� ·�����ļ���
	 * @return Object����
	 */
	public static Object getObjectBySerialize(String path) {
		Object obj = null;
		try {
			InputStream is = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(is);
			obj = ois.readObject();// ����ȡ�ļ������ݣ����ض���
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
