package by.bsuir.ief.rest.dao.hibernatedao.views;

import by.bsuir.ief.rest.model.entity.views.ShowUnreadedMessage;

import java.util.List;

/**
 * Created by andrey on 05.05.2016.
 */
public interface ShowUnreadedMessageDAO {
    List<ShowUnreadedMessage> read() throws Exception;
}
