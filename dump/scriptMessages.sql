select  distinct u1.login , rt.content, rt.date from user u1
inner join 
(select  u.id_user as user_rec, m.content, m.id_user_sender as sender_id, m.date from message_receiver as mr
inner join user as u on
u.id_user = mr.id_user_receiver
inner join message as m on
m.id_message = mr.id_message
where u.id_user = 3 and m.unreaded = 1
) as rt
on rt.sender_id = u1.id_user
order by rt.date;

