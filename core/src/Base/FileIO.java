package Base;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileIO {

	public class LoadOP{
		String dir = "res/";
		String fmt = ".crm";
		String fileName = "default";
		
		public ArrayList<String> readFromFile(){
			File file = new File(dir+fileName+fmt);
			
			ArrayList<String> data = new ArrayList<String>();
			
			if(!file.exists()){
				System.out.println("File not Found.");
			}else{
				try{
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line = "";
					
					while((line = reader.readLine())!=null){
						System.out.println("<line:" + data.size()+">\""+line+"\"");
						data.add(line);
					}
					reader.close();
					reader = null;
				}catch(Exception e){
					
				}
			}
			
			return data;
			
		}
		
		public ArrayList<String> readFromFile(String filePos){
			File file = new File(filePos);
			
			ArrayList<String> data = new ArrayList<String>();
			
			if(!file.exists()){
				System.out.println("File not Found.");
			}else{
				try{
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line = "";
					
					while((line = reader.readLine())!=null){
						System.out.println("<line:" + data.size()+">\""+line+"\"");
						data.add(line);
					}
					reader.close();
					reader = null;
				}catch(Exception e){
					
				}
			}
			
			return data;
			
		}
		
	}
	
	public class SaveOP{
		String dir = "res/";
		String fmt = ".crm";
		String fileName = "default";
		
		public void writeToFile(ArrayList<String> ALs, boolean overWrite){
			
			File file = new File(dir+fileName+fmt);
			
			try{
				if(!file.exists()){
					file.createNewFile();
					System.out.println("File not Found");
					System.out.println("File Created: "+ file.getName());
				}else{
					System.out.println("Found File");
					System.out.println("File name: "+ file.getName());
				}
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(file, !overWrite));
				
				for(int i = 0; i < ALs.size(); i++){
					writer.write(ALs.get(i));
					writer.newLine();
				}
				
				writer.close();
				writer = null;
				
			}catch(Exception e){
				
			}
			
			
			
		}
		
		public void writeToFile(String filePos, ArrayList<String> ALs, boolean overWrite){
			
			File file = new File(filePos);
			
			try{
				if(!file.exists()){
					file.createNewFile();
					System.out.println("File not Found");
					System.out.println("File Created: "+ file.getName());
				}else{
					System.out.println("Found File");
					System.out.println("File name: "+ file.getName());
				}
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(file, !overWrite));
				
				for(int i = 0; i < ALs.size(); i++){
					writer.write(ALs.get(i));
					writer.newLine();
				}
				
				writer.close();
				writer = null;
				
			}catch(Exception e){
				
			}
			
			
			
		}
		
	}
	
	LoadOP Loader = new LoadOP();
	SaveOP Saver = new SaveOP();
	
	public ArrayList<String> getData(String filePos){
		return Loader.readFromFile(filePos);
		
	}
	
	public void saveData(String filePos, ArrayList<String> ALs){
		//True overwrites the data
		//false appends the data
		Saver.writeToFile(filePos, ALs, true);
	}
	
	
}
