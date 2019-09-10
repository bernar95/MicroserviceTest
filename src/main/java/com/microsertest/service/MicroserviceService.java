package com.microsertest.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.stereotype.Service;

@Service
public class MicroserviceService {
	
	public String getInstanceID() {
		String instanceID = "";
		File jsonInputFile = new File("config.json");
		InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            JsonReader reader = Json.createReader(is);
            JsonObject empObj = reader.readObject();
            reader.close();
            instanceID = empObj.getString("instance_id");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return instanceID;
	}

}
