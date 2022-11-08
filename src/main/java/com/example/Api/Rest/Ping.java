package com.example.Api.Rest;

import com.example.Api.DAO.UserDAO;
import com.example.Api.DTO.UserReqDTO;
import com.example.Api.JMS.ActiveMQSender;
import com.example.Api.Service.FileGenerationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Slf4j
@RestController
public class Ping {
    
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ActiveMQSender sender;

    @Autowired
    private FileGenerationService fileGenerationService;


    //7private Date date;


    @ResponseBody
    @GetMapping(path = "/amq", produces = MediaType.APPLICATION_JSON_VALUE)
    public void queue() {
        //log.info("Got it");
        //
     sender.send("USER_IN","Garnacho");



//


    }

    @ResponseBody
    @GetMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
    public String ping(String a, String b, String c ) throws Exception{
        //log.info("Got it");
        System.out.println("ok");
        UserReqDTO userReqDTO = new UserReqDTO();
        //UserModel userModel = new UserModel();
        userReqDTO.setUsername(a);
        userReqDTO.setPhone(b);
        userReqDTO.setCountry(c);
        String ok = "Success";

        int insert = userDAO.insertUser(userReqDTO);
        if (insert > 0) {
            log.info("Inserted");
            return ok;
        } else {
            throw new Exception("Failed to insert Recovery Record");
        }
//
      //  return true;

    }

    @ResponseBody
    @GetMapping(path = "/read", produces = MediaType.APPLICATION_JSON_VALUE)
    public void read() {
        try {
            File file = new File("C:/CTRHLCF2022092190000");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                log.info(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            log.info("An error occurred"+ System.currentTimeMillis());
            e.printStackTrace();

        }
    }

    @ResponseBody
    @GetMapping(path = "/object", produces = MediaType.APPLICATION_JSON_VALUE)
    public String object() {
        //log.info("Got it");
        System.out.println("ok");
        UserReqDTO userReqDTO = new UserReqDTO();
        //UserModel userModel = new UserModel();
        userReqDTO.setUsername("Marcus");
        userReqDTO.setPhone("01319141");
        userReqDTO.setCountry("China");
        String ok = "Success";

        log.info("" + userReqDTO);

//
          return ok;

    }

    @ResponseBody
    @GetMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public String file() throws Exception {
        fileGenerationService.generateFile();
        return null;
    }
    /*
    try {
        File myObj = new File("filename.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    */
   /* @ResponseBody
    @GetMapping(path = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean take(){ 
        log.info("Got it");
        UserProvider userProvider = new UserProvider();
        
        userProvider.getUser();

        
        return true;

    }*/
    
    /*private static final Gson gson = new Gson();

    @GetMapping(path="/json", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> so() {
        return ResponseEntity.ok(gson.toJson("This is a String"));
    }
    
    @PostMapping("/hello")
    ResponseEntity<String> hello(HttpServletRequest request,@RequestParam int c) {
    	
    	if (c>2) {
    		//return new ResponseEntity<>(c+ "c is bigger than 2", HttpStatus.OK);
    		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("DONE DECRYPT"));
            
    	}else {
    		return new ResponseEntity<>("c is smaller than 2", HttpStatus.OK);
    	}
        
        
    }
    
    /*
     * public MasterFileResDTO getMasterFileList(MasterFileReqDTO masterFileReqDTO) {
		// TODO Auto-generated method stub
		try {
			MasterFileResDTO masterFileResDTO = new MasterFileResDTO();
			masterFileResDTO.setMasterFileList(masterFileDAO.getMasterFileList(masterFileReqDTO));
			
			return masterFileResDTO;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
     * 
     */
}
