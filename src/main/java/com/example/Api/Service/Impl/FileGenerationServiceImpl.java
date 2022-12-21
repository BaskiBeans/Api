package com.example.Api.Service.Impl;

import com.example.Api.Service.FileGenerationService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


@Slf4j
@Service
public class FileGenerationServiceImpl implements FileGenerationService {

    @Override
    public String generateFile() throws Exception {
      /*File file = new File();

        file.setName(name);

        file.setFileType(fileType);
       */
       File file = new File("D:/test.txt");

     if(file.createNewFile()){
         log.info("ok");
     } else {
         log.info("Not ok");
     }


        return null;
    }
    
    @Scheduled(cron = "0/5 * * * * *")
	public void readTxtFile() throws IOException
	{
    	//created a file object and specified the file path to read
		 File file = new File("C:\\Users\\wenhu\\Downloads\\Hi.txt");
		 
		 try {
			BufferedReader bufferRead
			 = new BufferedReader(new FileReader(file));
			
			String txt;
	        while ((txt = bufferRead.readLine()) != null)
	            System.out.println(txt);
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	        
	}
	
}
