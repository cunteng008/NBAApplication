package util;

public class Split {
	
	// 将字符一逗号为界限串分割成多个字符，设置长度，若达不到长度用空串填充
	public static String[] splitByComma(String str,int len ){
		String[] words;
		words = str.split(",");
		
		if(words.length<len){
			
			String[] temp = new String[len];
			int i = 0;
			for(;i<words.length;i++){
				temp[i] = words[i].trim();  //trim()将字符串的首尾的空格去掉
			}
			for(;i<len;i++){
				temp[i] = "";
			}
			words = temp;
		}	
		
		return words;
	}
}
