package ru.alsu.springweb.StatusDocument;

import ru.alsu.springweb.entity.Document;

public class ModificationDocument implements DocumentState {
    @Override
    public String getStatusName() {
        return StatusName.MODIFICATION.getStatusName();
    }

    @Override
    public void nextDocumStatus(Document document) {
        document.setDocumentState(new ControlDocument());

    }
}
