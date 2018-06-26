package com.ufc.br.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static void salvarIMG(String caminho, MultipartFile image) {
		File file = new File(caminho);
		
		try {
			
			FileUtils.writeByteArrayToFile(file,image.getBytes());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
			}

}
