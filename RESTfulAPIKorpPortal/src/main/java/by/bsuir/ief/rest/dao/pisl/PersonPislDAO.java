package by.bsuir.ief.rest.dao.pisl;

import by.bsuir.ief.rest.model.pisl.PersonPisl;

import java.util.List;

/**
 * Created by andrey on 12.04.2016.
 */
public interface PersonPislDAO {
    public PersonPisl addEntity(PersonPisl PersonPisl) throws Exception;
    public List<PersonPisl> addEntitys(List<PersonPisl> personPisls) throws Exception;
    public PersonPisl updateEntity(PersonPisl personPisl) throws Exception;
    public List<PersonPisl> updateEntitys(List<PersonPisl> personPisls) throws Exception;
    public PersonPisl getEntityById(int id) throws Exception;
    public List getEntityList() throws Exception;
    public List<PersonPisl> saveOrUpdates(List<PersonPisl> personPisls) throws Exception;
    public PersonPisl saveOrUpdates(PersonPisl personPisl) throws Exception;
    public boolean deleteEntity(PersonPisl personPisl) throws Exception;
    public boolean deleteEntity(int id) throws Exception;
    public boolean deleteAllEntity() throws Exception;
}
