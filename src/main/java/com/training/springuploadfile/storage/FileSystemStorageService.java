package com.training.springuploadfile.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
@Slf4j
public class FileSystemStorageService implements StorageService {
     private final Path rootLocation;

     public FileSystemStorageService(StorageProperties properties) {
         this.rootLocation = Paths.get(properties.getLocation());
     }

    @Override
    public void init() {

    }

    @Override
    public void store(MultipartFile file) {
         String filename = StringUtils.cleanPath(file.getOriginalFilename());
         log.info("--- filename {} --- ", filename);
         try {
             if (file.isEmpty()) {
                 throw new StorageException("Failed to store empty file " + filename);
             }
             if (filename.contains("..")) {
                 throw new StorageException("Cannot store file with relative path outside current directory " + filename);
             }
             try (InputStream inputStream = file.getInputStream()) {
                 Files.copy(inputStream, this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
             }
         } catch (IOException e) {
             throw new StorageException("Failed to store file " + filename, e);
         }
    }

    @Override
    public Stream<Path> loadAll() throws IOException {
        return Files.walk(this.rootLocation, 1)
                .filter(path -> !path.equals(this.rootLocation))
                .map(this.rootLocation::relativize);
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
