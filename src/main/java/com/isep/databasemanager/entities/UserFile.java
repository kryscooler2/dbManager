package com.isep.databasemanager.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.io.IOException;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import org.apache.commons.codec.digest.DigestUtils;


@Entity
public class UserFile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fileName;
    private String fileHash;
    private long creationDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private GcfaUser author;
    private boolean validated;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private FileType type;

    public UserFile() {
    }

    public UserFile(String fileName, long creationDate, GcfaUser author, boolean validated, FileType type) {
        this.fileName = fileName;
        this.creationDate = creationDate;
        this.author = author;
        this.validated = validated;
        this.type = type;
    }

    public UserFile(String fileName) throws IOException, NoSuchAlgorithmException {
        this.fileName = fileName;

        this.fileHash = getFileHash(fileName);

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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public GcfaUser getAuthor() {
        return author;
    }

    public void setAuthor(GcfaUser author) {
        this.author = author;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public String setFileHash() {
        return fileHash;
    }

    private String getFileHash(String fileName) throws IOException, NoSuchAlgorithmException {
        Path path = Paths.get("../" + fileName);
        byte[] data = Files.readAllBytes(path);

        String hashValue = new String(DigestUtils.sha256(data));
        System.out.println("data:" + data);
        System.out.println("sha256:" + hashValue);

        return hashValue;

    }

}
