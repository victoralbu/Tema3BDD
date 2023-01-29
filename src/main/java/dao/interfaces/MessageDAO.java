package dao.interfaces;

import entities.Message;
import enums.Level;

import java.util.List;

public interface MessageDAO extends GenericDAO<Message, Level> {
    @Override
    default void close() {

    }

    @Override
    default Message create(Message entity) {
        return null;
    }

    @Override
    default Message findByIdAndLevel(int id, Level level) {
        return null;
    }

    @Override
    default Message update(Message entity) {
        return null;
    }

    @Override
    default void delete(Message entity) {

    }

    @Override
    default void deleteAll() {

    }

    @Override
    default List<Message> getAll() {
        return null;
    }

    default List<Message> getErrors() {
        return null;
    }

    default List<Message> getInfo() {
        return null;
    }

    default List<Message> getWarnings() {
        return null;
    }
}
