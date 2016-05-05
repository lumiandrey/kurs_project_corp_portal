package by.bsuir.ief.rest.controller;

import by.bsuir.ief.rest.model.entity.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/**
 * Created by andrey on 01.05.2016.
 */
public class WriteXML {
    public static void write(User user) {
        try {
            JAXBContext context = JAXBContext.newInstance(User.class); //MyClass - имя класса твоего объекта
            Marshaller m = context.createMarshaller();
            m.marshal(user, new FileOutputStream("D:\\output.xml")); //вывод в output.xml
        } catch (FileNotFoundException e) {
            System.out.println("No such XML-file");
            e.printStackTrace();
        }
        catch (JAXBException e) {
            System.out.println("JAXB-exception");
            e.printStackTrace();
        }
    }
}


