SELECT task_p.id_person, tr.id_type_task , tr.id_task, tr.name_type_task, tr.name as name_task, tr.current, tr.complication, tr.complited, tr.done,  tr.date_begin, tr.date_end FROM task_has_person as task_p
inner join (select type_task.id_type_task , task.id_task, type_task.name_type_task ,  task.name, task.current, type_task.complication, task.complited, task.done, task.date_begin, task.date_end from type_task inner join task on
 task.id_type_task = type_task.id_type_task) as tr
on 
tr.id_task = task_p.id_task 
where  task_p.id_person = 3 and tr.current;