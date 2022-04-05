package ru.alsu.springweb.StatusDocument;

import ru.alsu.springweb.entity.Document;

import java.sql.Date;

public class ReceptionDocument implements DocumentState {
    @Override
    public String getStatusName() {
        return StatusName.RECEPTION.getStatusName();
    }

    @Override
    public void nextDocumStatus(Document document) {
//        Date date = new Date();
//        document.setDayEnd(date);
    }
}
