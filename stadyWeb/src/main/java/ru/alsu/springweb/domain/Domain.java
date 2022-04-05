package ru.alsu.springweb.domain;

import org.hibernate.classic.Session;
import ru.alsu.springweb.bl.HibernateUtil;

public class Domain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }
}
