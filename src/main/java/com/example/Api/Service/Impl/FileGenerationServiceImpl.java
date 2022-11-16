package com.example.Api.Service.Impl;

import com.example.Api.Service.FileGenerationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;


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
}
