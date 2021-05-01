package com.adote.me.service;

import net.bytebuddy.utility.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorage {

    private Path path;

    private byte[] bytes;

    Logger log = LoggerFactory.getLogger(this.getClass());

    public void saveImageInFolder() {
        try {
            Files.write(path, bytes);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public String storeFile(MultipartFile file) {
        if(!file.isEmpty()) {
            var folder = "/images/";
            byte[] bytes;
            try {
                bytes = file.getBytes();
                var randomString = RandomString.make();
                var path = Paths.get(folder.concat(randomString.concat(".jpeg")));

                setValues(bytes, path);

                return path.toAbsolutePath().toString();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return null;
    }

    private void setValues(byte[] bytes, Path path) {
        this.path = path;
        this.bytes = bytes;
    }
}
