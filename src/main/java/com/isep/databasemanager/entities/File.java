package com.isep.databasemanager.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.IOException;
//import com.gcfa.beans.FileProperty;

@Entity
public class File implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String fileName;
    private String fileHash;
    private String filePath;

    public File() {
    }
    
    public File(String fileName, String filePath) throws IOException, NoSuchAlgorithmException{
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileHash = getFileHash(filePath);
       
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String setFileHash() {
        return fileHash;
    }

    private String getFileHash(String filePath) throws IOException, NoSuchAlgorithmException
    {
	Path path = Paths.get(filePath);
        byte[] data = Files.readAllBytes(path);
		
	try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(data);
            byte[] messageDigestMD5 = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte bytes : messageDigestMD5) {
                stringBuffer.append(String.format("%02x", bytes & 0xff));
            }

            System.out.println("data:" + data);
            System.out.println("digestedMD5(hex):" + stringBuffer.toString());
            
            return stringBuffer.toString();
            
        } catch (NoSuchAlgorithmException exception) {
           // TODO Auto-generated catch block
           exception.printStackTrace();
        }
        return null;
    }

}