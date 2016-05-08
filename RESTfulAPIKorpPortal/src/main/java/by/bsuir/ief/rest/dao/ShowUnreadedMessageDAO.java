package by.bsuir.ief.rest.dao;

import by.bsuir.ief.rest.model.entity.views.ShowUnreadedMessage;

import java.util.List;

/**
 * Created by andrey on 05.05.2016.
 */
public interface ShowUnreadedMessageDAO {
    List<ShowUnreadedMessage> readByUserId(int iduser) throws Exception;
    List<ShowUnreadedMessage> readMessagesByIdSender(int idSenser, int idReciver) throws Exception;
    int insertMessageReciverTable(int idMessage, int idReciver) throws Exception;
}
