package com.training.springuploadfile.errorhandling;

import java.util.List;

public interface SectionStore {
    List<Contrat> retrieveContrat(String filename);
}
