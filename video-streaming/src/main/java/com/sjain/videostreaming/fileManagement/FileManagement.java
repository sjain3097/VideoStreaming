package com.sjain.videostreaming.fileManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;


/**
 * @author sankalp_jain
 *
 */
/**
 * @author sankalp_jain
 *
 */
@Component
public class FileManagement {

	public void createVideoNamesFile() throws IOException{
		try{
			File file = new File("src/main/resources/videoFileNames.txt");
			if(file.createNewFile()){
				System.out.println("File "+file.getName()+" is created");
			}else{
				System.out.println("File "+file.getName()+" already exists");
			}
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public Map<File, Map<File, List<File>>> getVideoNameList() throws IOException{
		//path to the tutorial folder which contains all the tutorials
		Map<File, Map<File, List<File>>> tutorials = new HashMap<File, Map<File, List<File>>>();
//		Map<File, List<File>> folders =  new HashMap <File, List<File>>();
//		List<File> files = new ArrayList<File>();
		File folder = new File("D:/tutorial/");
		File file = new File("src/main/resources/videoFileNames.txt");
		if(file.createNewFile()){
			System.out.println("File "+file.getName()+" is created");
		}else{
			System.out.println("File "+file.getName()+" already exists");
		}
		FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
		File[] flist = folder.listFiles();
		for(File f: flist){
			
			Map<File, List<File>> folders =  new HashMap <File, List<File>>();
			
			List<File> files = new ArrayList<File>();
			
			tutorials.put(f, folders);
			//fileWriter.append("tutorialName: "+f+",\n");
			for(File f1: f.listFiles()){
				folders.put(f1, files);
				//fileWriter.append("folderName: "+f1.getName()+",\n");
				for(File f2: f1.listFiles()){
					files.add(f2);
					//fileWriter.append("FileName: "+f2.getName()+",\n");
				}
			}
		}
		fileWriter.close();
		System.out.println(tutorials);
		return tutorials;
	}
	public void writeToFile(File file) throws IOException{
		try{
			FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
			
			fileWriter.write("fsfjkls");
			fileWriter.append("\nsomething");
			fileWriter.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public static void main(String [] args) throws IOException{
		FileManagement fileManagement = new FileManagement();

		//File file = new File("src/main/resources/videoFileNames.txt");
		//fileManagement.createVideoNamesFile();
		//fileManagement.writeToFile(file);
		fileManagement.getVideoNameList();
	}
}
