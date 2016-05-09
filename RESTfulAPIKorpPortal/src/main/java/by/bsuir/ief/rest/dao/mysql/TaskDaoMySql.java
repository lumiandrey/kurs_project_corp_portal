package by.bsuir.ief.rest.dao.mysql;

import by.bsuir.ief.rest.dao.TaskDAO;
import by.bsuir.ief.rest.model.entity.Task;
import by.bsuir.ief.rest.model.entity.TypeTask;
import by.bsuir.ief.rest.util.DateConvert;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by Darya on 07.05.16.
 */
@Component
public class TaskDaoMySql implements TaskDAO {

    @Qualifier("jdbcTemplate")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String SQL_LIST_TASKS_BY_ID_PERSON = "SELECT " +
            "task_p.id_person, " +
            "tr.id_type_task , " +
            "tr.id_task," +
            " tr.name_type_task, " +
            "tr.name as name_task, " +
            "tr.current, " +
            "tr.complication, " +
            "tr.complited, " +
            "tr.done, " +
            " tr.date_begin, " +
            "tr.date_end " +
            "FROM task_has_person as task_p " +
            "inner join (select type_task.id_type_task , task.id_task, type_task.name_type_task ,  task.name, task.current, type_task.complication, task.complited, task.done, task.date_begin, task.date_end from type_task inner join task on " +
            " task.id_type_task = type_task.id_type_task) as tr " +
            "on " +
            "tr.id_task = task_p.id_task " +
            "where  task_p.id_person = ?";

    private static String SQL_ADD_HASH_TASK_PERSON = "insert into `task_has_person` (`id_task`,`id_person`) values(?,?)";

    @Override
    public int createHasTaskPerson(int idTask, int idPerson) {
        return jdbcTemplate.update(SQL_ADD_HASH_TASK_PERSON, idTask, idPerson);
    }

    @Override
    public Task create(Task task) throws Exception {
        return null;
    }

    @Override
    public List<Task> read() throws Exception {
        return null;
    }

    @Override
    public List<Task> readTaskByIdPerson(int id) throws Exception {
        return jdbcTemplate.query(SQL_LIST_TASKS_BY_ID_PERSON,
                (rs, rowNum) -> {
                    Task task = new Task();
                    task.setId_task(rs.getInt("id_task"));
                    task.setName(rs.getString("name_task"));
                    Date date_begin = null;
                    Date date_end = null;
                    try {
                        date_begin = DateConvert.StringToUtilDateShortFormat(rs.getString("date_begin"));
                        date_end = DateConvert.StringToUtilDateShortFormat(rs.getString("date_end"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    assert date_begin != null;
                    task.setDate_begin(new DateTime(date_begin.getTime()));

                    assert date_end != null;
                    task.setDate_begin(new DateTime(date_end.getTime()));

                    task.setCurrent(rs.getBoolean("current"));
                    task.setComplited(rs.getInt("complited"));
                    task.setDone(rs.getBoolean("done"));
                    TypeTask typeTask = new TypeTask();
                    typeTask.setIdTypeTask(rs.getInt("id_type_task"));
                    typeTask.setComplication(rs.getDouble("complication"));
                    typeTask.setNameTypeTask(rs.getString("name_type_task"));
                    task.setType_pask(typeTask);

                    return task;
                },id);
    }

    @Override
    public Task read(int id) throws Exception {
        return null;
    }

    @Override
    public Task update(Task task) throws Exception {
        return null;
    }

    @Override
    public void delete(int id) throws Exception {

    }
}
