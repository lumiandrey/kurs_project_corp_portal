SELECT sum(person.reiting), department.name_department  FROM person 
inner join department  on
department.id_department = person.id_division
group by department.name_department;