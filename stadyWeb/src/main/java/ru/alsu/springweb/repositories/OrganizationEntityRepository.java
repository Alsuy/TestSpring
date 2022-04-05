package ru.alsu.springweb.repositories;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.alsu.springweb.bl.SessionUtil;
import ru.alsu.springweb.entity.Organization;

import java.util.List;
@Component
public class OrganizationEntityRepository extends SessionUtil implements OrganizationRepository{
    @Override
    public List<Organization> getList() {
        openTransactionSession();
        String sql = "SELECT * FROM organization";
        Session session = getSession();
        Query query = session.createSQLQuery(sql).addEntity(Organization.class);
        List<Organization> organizationList = query.list();
        closeTransactionSession();
        return organizationList;
    }
}
