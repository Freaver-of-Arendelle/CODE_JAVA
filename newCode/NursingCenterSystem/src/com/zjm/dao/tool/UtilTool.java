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
	 *            字符串 序列化文件的路径，带文件名
	 * @param obj
	 *            Object类型 预存入的已经实现序列化接口的对象
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
	 *            字符串 路径带文件名
	 * @return Object对象
	 */
	public static Object getObjectBySerialize(String path) {
		Object obj = null;
		try {
			InputStream is = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(is);
			obj = ois.readObject();// 读或取文件中数据，返回对象
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
