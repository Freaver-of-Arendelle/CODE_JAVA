package com.yjz.impl.model;

import java.io.File;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.yjz.dao.model.PatientDAO;
import com.yjz.dao.tool.UtilTool;
import com.yjz.model.Patient;

public class PatientDAOImpl implements PatientDAO
{
	private static PatientDAOImpl instance = new PatientDAOImpl();
	
	Vector <Patient> patient = new Vector<Patient>();
	
	 	private PatientDAOImpl(){
	 		File f = new File("c://abc//Patient.txt");
	 		if(f.length()!=0){
	 			patient = (Vector<Patient>) UtilTool.getFileBySerialize("c://abc//Patient.txt");	 			
	 		}else{
	 			JOptionPane.showMessageDialog(null, "无法找到文件");
	 		}
	 		
	 	}
	 	public static PatientDAOImpl getinstance(){
	 		return instance;
	 	}
		@Override
		public Vector<Patient> query() //查询
		{
			return patient;
		}

		@Override
		public void register(Patient pat) //注册
		{
			patient.add(pat);
			writeFile("c://abc//Patient.txt");
		}

		@Override
		public void writeFile(String path) {

			UtilTool.saveFileBySerialize(path, patient);
		}

		@Override
		public void delete(Patient pat) {
			patient.remove(pat);
			writeFile("c://abc//Patient.txt");
		}
		
		@Override
		public Boolean save(Patient patient, int temp) {
			Boolean flag = false;
			try{
				this.patient.remove(temp);
				this.patient.add(temp,patient);
				writeFile("c://abc//Patient.txt");
				flag = true;
			}catch(Exception e){
				e.printStackTrace();
			}
			return flag;
		}
		
		int i=1;
		@Override
		public void add() {
			Patient pat = new Patient();
			pat.setName("待定"+i);
			pat.setBirth("待定"+i);
			pat.setGender("待定"+i);
			pat.setID("待定"+i);
			pat.setPhone("待定"+i);
			pat.setEmergency("待定"+i);
			pat.setEmergencyPhone("待定"+i);
			patient.add(pat);
			i++;
			
		}
//		public static void main(String[] args) {
//			PatientDAOImpl pdi = new PatientDAOImpl();
//			Patient pat1 = new Patient("ming","004","1","q","911","gala","119");
//			Patient pat2 = new Patient("wolf","005","1","w","110","bang","011");
//			Patient pat3 = new Patient("crisp","006","1","e","120","lwx","021");
//			pdi.register(pat1);
//			pdi.register(pat2);
//			pdi.register(pat3);
//			
//		}
}
