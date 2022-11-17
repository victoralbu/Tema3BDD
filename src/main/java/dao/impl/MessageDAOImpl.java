package dao.impl;

import entities.Message;
import enums.Level;
import dao.interfaces.MessageDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class MessageDAOImpl implements MessageDAO {

    private final EntityManager mysqlEm;

    private final EntityManager postgresEm;

    public MessageDAOImpl() {
        this.mysqlEm = Persistence.createEntityManagerFactory("mysql").createEntityManager();
        this.postgresEm = Persistence.createEntityManagerFactory("postgres").createEntityManager();
    }

    @Override
    public void close() {
        this.mysqlEm.close();
        this.postgresEm.close();
    }

    @Override
    public Message create(Message entity) {

        EntityManager em = getEm(entity.getLevel());

        em.getTransaction().begin();

        em.persist(entity);

        em.getTransaction().commit();

        return entity;
    }

    @Override
    public Message findByIdAndLevel(int id, Level level) {
        return getEm(level).find(Message.class, id);
    }

    @Override
    public Message update(Message entity) {

        EntityManager em = getEm(entity.getLevel());

        em.getTransaction().begin();

        em.merge(entity);

        em.getTransaction().commit();

        return entity;
    }

    @Override
    public void delete(Message entity) {
        EntityManager em = getEm(entity.getLevel());
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public void deleteAll() {

        // Delete all from MySQL
        mysqlEm.getTransaction().begin();
        this.mysqlEm.createNativeQuery("DELETE FROM error.message").executeUpdate();
        mysqlEm.getTransaction().commit();

        // Delete all from postgres
        postgresEm.getTransaction().begin();
        this.postgresEm.createNativeQuery("DELETE FROM info_warn.message").executeUpdate();
        postgresEm.getTransaction().commit();

    }

    @Override
    public List<Message> getAll() {

        List<Message> allErrors = this.mysqlEm.createNativeQuery("Select * from error.message", Message.class).getResultList();

        List<Message> allInfoAndWarnings = this.postgresEm.createNativeQuery("Select * from info_warn.message", Message.class).getResultList();

        List<Message> allMessages = new ArrayList<>(allErrors);

        allMessages.addAll(allInfoAndWarnings);

        return allMessages;

    }
    @Override
    public List<Message> getErrors() {
        return this.mysqlEm.createNativeQuery("SELECT * from error.message",Message.class).getResultList();
    }

    @Override
    public List<Message> getWarnings() {
        return this.postgresEm.createNativeQuery("SELECT * from info_warn.message where level = 'WARNING'", Message.class).getResultList();
    }

    @Override
    public List<Message> getInfo() {
        return this.postgresEm.createNativeQuery("SELECT * from info_warn.message where level = 'INFO'", Message.class).getResultList();
    }

    protected EntityManager getEm(Level level) {
        return level == Level.ERROR ? this.mysqlEm : this.postgresEm;
    }

}
