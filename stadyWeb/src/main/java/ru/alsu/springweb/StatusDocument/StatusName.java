package ru.alsu.springweb.StatusDocument;

public enum StatusName {
    PREPARATION ("Подготовка"),
    EXECUTION("Исполнение"),
    CONTROL("Контроль"),
    MODIFICATION("Доработка"),
    RECEPTION("Прием");

    private String statusName;

    StatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
