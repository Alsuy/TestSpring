package ru.alsu.springweb.StatusDocument;

import ru.alsu.springweb.entity.Document;

public class ExecutionDocument implements DocumentState{
    @Override
    public String getStatusName() {
        return StatusName.EXECUTION.getStatusName();
    }
    @Override
    public void nextDocumStatus(Document document) {
        document.setDocumentState(new ControlDocument());
    }
}
