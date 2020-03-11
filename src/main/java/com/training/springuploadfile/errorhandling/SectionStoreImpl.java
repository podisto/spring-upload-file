package com.training.springuploadfile.errorhandling;

import com.training.springuploadfile.storage.StorageException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SectionStoreImpl implements SectionStore {

    @Override
    public List<Contrat> retrieveContrat(String filename) {
        try {
            InputStream stream = new FileInputStream(filename);
            stream.close();
        } catch (Exception e) {
            throw new StorageException("File name is not correct " + filename, e);
        }
        return new ArrayList<>();
    }
}
