package by.bsuir.ief.rest.dao.views.impl;

import by.bsuir.ief.rest.dao.views.ShowUnreadedMessageDAO;
import by.bsuir.ief.rest.model.entity.views.ShowUnreadedMessage;
import by.bsuir.ief.rest.util.DateConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

/**
 * Created by andrey on 06.05.2016.
 */
@Component
public class ShowUnreadedMessageDAOMySQL implements ShowUnreadedMessageDAO {


    private static String SQL_GET_UNREADED_MESSAGE_BY_ID = "select * from `show_unreaded_message` where `user_rec` = ?";
    @Qualifier("jdbcTemplate")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ShowUnreadedMessage> readByUserId(int userId) throws Exception {
        return jdbcTemplate.query(SQL_GET_UNREADED_MESSAGE_BY_ID, (rs, rowNum) -> {
            ShowUnreadedMessage message = new ShowUnreadedMessage();
            try {
                message.setDate(DateConvert.StringToUtilDate(rs.getString("date")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            message.setContent(rs.getString("content"));
            message.setLogin(rs.getString("login"));
            return message;
        }, userId);
    }
}
