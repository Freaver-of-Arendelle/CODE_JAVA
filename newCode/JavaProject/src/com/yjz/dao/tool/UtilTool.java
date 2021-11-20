package com.yjz.dao.tool;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class UtilTool {

	public static void saveFileBySerialize (String path,Object object)
	{
		try{
			OutputStream os = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(object);
			oos.close();
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Object getFileBySerialize (String path)
	{
		Object object = null;
		try{
			InputStream is = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(is);
			object = ois.readObject();
			ois.close();
			is.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return object;
	}
}
