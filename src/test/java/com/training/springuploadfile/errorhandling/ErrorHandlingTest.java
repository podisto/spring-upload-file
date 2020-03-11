package com.training.springuploadfile.errorhandling;

import com.training.springuploadfile.storage.StorageException;
import com.training.springuploadfile.storage.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("ErrorHandling Test")
@Slf4j
public class ErrorHandlingTest {

    private SectionStore sectionStore;

    @BeforeEach
    void init() {
        log.info("--- beforeEach test method ---");
        sectionStore = new SectionStoreImpl();
    }

    @Test()
    @DisplayName("Throw Exception on parse String to Integer")
    public void checkException() {
        String valeur = null;
        assertThrows(NumberFormatException.class, () -> Integer.valueOf(valeur));
    }

    @Test
    @DisplayName("Throw StorageException when file name is invalid")
    public void retrieveSectionShouldThrowOnInvalidFileName() {
        assertThrows(IOException.class, () -> sectionStore.retrieveContrat("invalid - file"));
    }
}
