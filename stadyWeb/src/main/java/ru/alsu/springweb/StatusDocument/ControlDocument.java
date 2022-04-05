package ru.alsu.springweb.StatusDocument;

import ru.alsu.springweb.entity.Document;

public class ControlDocument implements DocumentState{
    @Override
    public String getStatusName() {
        return StatusName.CONTROL.getStatusName();
    }

    @Override
    public void nextDocumStatus(Document document) {
        if (document.isErrorDocument())
        document.setDocumentState(new ModificationDocument());
        else document.setDocumentState(new ReceptionDocument());

    }


}
