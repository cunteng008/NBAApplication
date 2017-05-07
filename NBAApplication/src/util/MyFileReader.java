package util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MyFileReader {
	
	 File file;
	 BufferedReader reader = null;
	 String aLineData ; // 暂存一条数据
	 
	 public MyFileReader(String fileName){
		 SetFile(fileName);
	 }
	 
	 // 想要获取之前先判断是否还有数据
	 public boolean hasNext(){
		try{
			if( (aLineData = reader.readLine()) == null){
				reader.close();
				return false;
			}
		}catch (IOException e) {
            return false;
        }
		return true;
	}
	public String getALineData() {
		return aLineData.trim();
	}
   
	// 设置数据文件
	public void SetFile(String fileName){
		File file = new File(fileName);
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
