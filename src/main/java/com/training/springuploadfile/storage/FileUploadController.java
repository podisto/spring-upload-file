package com.training.springuploadfile.storage;

import org.springframework.stereotype.Controller;

@Controller
public class FileUploadController {

    private final StorageService storageService;

    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }
}
