package by.bsuir.ief.rest.model.service;

import by.bsuir.ief.rest.dao.views.ShowUnreadedMessageDAO;
import by.bsuir.ief.rest.dao.views.impl.ShowUnreadedMessageDAOMySQL;
import by.bsuir.ief.rest.model.entity.views.ShowUnreadedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by andrey on 05.05.2016.
 */
@Component
public class ShowUnreadedMessageService {


    @Qualifier("showUnreadedMessageDAOMySQL")
    @Autowired
    private ShowUnreadedMessageDAO messageDAO;

    public List<ShowUnreadedMessage> read(int idUser) throws Exception {
        return messageDAO.readByUserId(idUser);
    }
}
