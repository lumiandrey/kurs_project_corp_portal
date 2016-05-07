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


    private static String SQL_GET_UNREADED_MESSAGE_BY_ID = "SELECT  DISTINCT `u1`.`login` , `rt`.`content`, `rt`.`date`, `rt`.`user_rec`, `sender_id` FROM user `u1`" +
            "INNER JOIN " +
            "(SELECT  `u`.`id_user` AS `user_rec`, `m`.`content`, `m`.`id_user_sender` AS `sender_id`, `m`.`date` FROM `message_receiver` AS `mr`" +
            "INNER JOIN user AS `u` ON" +
            "`u`.`id_user` = `mr`.`id_user_receiver`" +
            "INNER JOIN `message` AS `m` ON" +
            "`m`.`id_message` = `mr`.`id_message`" +
            "WHERE `u`.`id_user` = ? AND `m`.`unreaded`" +
            ") AS `rt`\n" +
            "ON `rt`.`sender_id` = `u1`.`id_user`" +
            "ORDER BY `rt`.`date`";
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
            message.setUserRec(rs.getInt("user_rec"));
            message.setUserSender(rs.getInt("sender_id"));
            return message;
        }, userId);
    }
}
