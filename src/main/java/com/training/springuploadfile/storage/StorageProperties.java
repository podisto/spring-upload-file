package com.training.springuploadfile.storage;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("com/training/springuploadfile/storage")
@Getter
@Setter
public class StorageProperties {
    private String location = "upload-dir";
}
