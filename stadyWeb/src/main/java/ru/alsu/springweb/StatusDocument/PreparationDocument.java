package ru.alsu.springweb.StatusDocument;

import ru.alsu.springweb.entity.Document;

public class PreparationDocument implements DocumentState{
    @Override
    public String getStatusName() {
        return StatusName.PREPARATION.getStatusName();
    }

    @Override
    public void nextDocumStatus(Document document) {
        document.setDocumentState(new ExecutionDocument());
    }
}
