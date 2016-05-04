package by.bsuir.pisl.controller;

import by.bsuir.pisl.model.data.PersonPislDAO;
import by.bsuir.pisl.model.entity.PersonPisl;
import by.bsuir.pisl.model.entity.enumeration.Cities;
import by.bsuir.pisl.model.entity.enumeration.Disability;
import by.bsuir.pisl.model.entity.enumeration.MaritalStatus;
import by.bsuir.pisl.model.entity.enumeration.Nationality;
import by.bsuir.pisl.model.service.PersonPislService;
import by.bsuir.pisl.model.util.DateUtil;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.Thread.sleep;

/**
 * Created by andrey on 19.04.2016.
 */
@Component
public class ApplicationController implements Controller{

    @Autowired
    private volatile PersonPislService service;

    @Autowired
    private volatile PersonPislDAO personPislDAO;

    private Stage primaryStage;

    @FXML
    private Label idPersonPislLabel;

    @FXML
    private TextField firstNameTF;

    @FXML
    private TextField nameTF;

    @FXML
    private TextField lastNameTF;

    @FXML
    private ChoiceBox<String> sex;

    @FXML
    private TextField passportNumberTF;

    @FXML
    private TextField hphoneTF;

    @FXML
    private DatePicker birthdayTF;

    @FXML
    private TextField serialPassportTF;

    @FXML
    private TextField organizationGivePassportTF;

    @FXML
    private DatePicker dateGivePassportTF;

    @FXML
    private TextField identifyNumberTF;

    @FXML
    private TextArea placeOfBirthTA;

    @FXML
    private ChoiceBox<Cities> addressLivingCB;

    @FXML
    private TextField mphoneTF;

    @FXML
    private TextField eMailTF;

    @FXML
    private TextArea workingPlaceTA;

    @FXML
    private TextField postTF;

    @FXML
    private ChoiceBox<Cities> cityResidenceCB;

    @FXML
    private TextArea adressResidenceTA;

    @FXML
    private ChoiceBox<MaritalStatus> maritalStatusCB;

    @FXML
    private ChoiceBox<Nationality> nationalityCB;

    @FXML
    private ChoiceBox<Disability> disabilityCB;

    @FXML
    private CheckBox pensionerCheck;

    @FXML
    private TextField monthlyIncomeTF;

    @FXML
    private CheckBox ReservistCheck;

    @FXML
    private TableView<PersonPisl> personPislTableView;

    @FXML
    private TableColumn<PersonPisl, String> firstNameTableColumn;

    @FXML
    private TableColumn<PersonPisl, String> nameTableColumn;

    @FXML
    private TableColumn<PersonPisl, Disability> disabilityTableColumn;

    @FXML
    private TableColumn<PersonPisl, Nationality> nationalityTableColumn;

    @FXML
    BorderPane rootLauotl;

    //---------BEGIN module status REST----------//

    @FXML
    private Text statusRESTServer;

    private boolean flagServer = false;
    private boolean makeUpdate = false;
    private boolean makeSynchronize = false;

    private Thread runn = null;

    //---------END module status REST----------//

    private ObservableList<PersonPisl> personPislObservableList = FXCollections.observableArrayList();

    private List<PersonPisl> personPislList = new ArrayList<>();

    @FXML
    void initialize() {
        sex.getItems().addAll("Мужской","Женский");
        addressLivingCB.getItems().clear();
        addressLivingCB.getItems().addAll(Cities.values());
        cityResidenceCB.getItems().clear();
        cityResidenceCB.getItems().addAll(Cities.values());
        maritalStatusCB.getItems().clear();
        maritalStatusCB.getItems().addAll(MaritalStatus.values());
        nationalityCB.getItems().clear();
        nationalityCB.getItems().addAll(Nationality.values());
        disabilityCB.getItems().clear();
        disabilityCB.getItems().addAll(Disability.values());

        String pattern = "yyyy-MM-dd";
        birthdayTF.setPromptText(pattern.toLowerCase());
        birthdayTF.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        dateGivePassportTF.setPromptText(pattern.toLowerCase());
        dateGivePassportTF.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        Runnable r = new NewThread();
        runn = new Thread(r);
        runn.start();
    }

    @FXML
    private void createPersonPisl()
    {
        showPersonPisl(null);
    }

    @FXML
    private void pullPersonPislFromServer()
    {
        DialogManager.showInfoDialog("Информационное сообщение","Данная функция пока не доступна." +
                "Она будет доступна в рамках 6-й лабораторной работы. Спасибо за понимание!");
    }

    @FXML
    private void addPersonPislToServer()
    {
        if(isValidPerson())
        {
            try {
                PersonPisl personPisl = new PersonPisl();
                initialPersonPislData(personPisl);
                GregorianCalendar cal  = new GregorianCalendar();
                personPisl.setRecieveTime(cal);
                this.personPislList.add(service.save(personPisl,flagServer));
                showList();
            } catch (ParseException e) {
                DialogManager.showErrorDialog("Ошибка!!",e.getLocalizedMessage());
            } catch (Exception e) {
                DialogManager.showErrorDialog("Ошибка при добавлении!!!",e.getLocalizedMessage());
            }
        }


    }

    @FXML
    private void updatePersonPislToServer()
    {
        int id = personPislTableView.getSelectionModel().getSelectedIndex();
        if(id >=0 )
        {
            PersonPisl personPisl = personPislList.get(id);
            if(isValidPerson()) {
                try {
                    initialPersonPislData(personPisl);
                    GregorianCalendar cal  = new GregorianCalendar();
                    personPisl.setRecieveTime(cal);
                    service.update(personPisl,flagServer);
                    showList();
                }catch (ParseException e) {
                    DialogManager.showErrorDialog("Ошибка!!",e.getLocalizedMessage());
                } catch (Exception e) {
                    DialogManager.showErrorDialog("Ошибка при добавлении!!!",e.getLocalizedMessage());
                }
            }
        }
        else
            DialogManager.showWarningDialog("Внимание, вы не выбрали объект для обновления","Для обновления объекта, " +
                    "необходимо выбрать объект, внести изменения, и только после этого обновлять!!!");
    }

    @FXML
    private void deletePersonPislToServer()
    {
        int id = personPislTableView.getSelectionModel().getSelectedIndex();
        if(id >=0 )
        {
            int idPersonDelete = personPislTableView.getSelectionModel().getSelectedItem().getIdpersonPisl();
            personPislList.remove(id);
            if(isValidPerson()) {
                try {
                    service.deleteById(idPersonDelete,flagServer);
                    showList();
                }catch (ParseException e) {
                    DialogManager.showErrorDialog("Ошибка!!",e.getLocalizedMessage());
                } catch (Exception e) {
                    DialogManager.showErrorDialog("Ошибка при добавлении!!!",e.getLocalizedMessage());
                }
            }
        }
        else
            DialogManager.showWarningDialog("Внимание, вы не выбрали объект для удаления","Для удаления объекта, " +
                    "необходимо выбрать объект и только после этого удалять!!!");
    }

    @FXML
    private synchronized void clonePersonPislFromServer()
    {
        try {
            System.out.println("clonePersonPislFromServer");
            synchronizedServer();
            personPislList = service.getPersonPisls();
            showList();
        } catch (Exception e) {
            e.printStackTrace();
            DialogManager.showErrorDialog("Ошибка при обращении к серверу",e.getLocalizedMessage());
        }
    }

    private boolean isValidPerson()
    {
        String errorMessage = "";
        if (firstNameTF.getText() == null || firstNameTF.getText().length() < 2)
            errorMessage += "Фамилия не заполнена!\n";
        if (nameTF.getText() == null || nameTF.getText().length() < 2)
            errorMessage += "Имя не заполнено!\n";
        if (lastNameTF.getText() == null || lastNameTF.getText().length() < 2)
            errorMessage += "Отчество не заполнено!\n";
        if(sex.getValue() == null)
            errorMessage += "не выбран пол!\n";
        if (passportNumberTF.getText() == null || passportNumberTF.getText().length() < 2)
            errorMessage += "Не указан номер паспорта!\n";

        if (identifyNumberTF.getText() == null || identifyNumberTF.getText().length() < 2)
            errorMessage += "Не указан идентификационный номер паспорта!\n";
        if (placeOfBirthTA.getText() == null || placeOfBirthTA.getText().length() < 2)
            errorMessage += "Не указано место рождения!\n";
        if (addressLivingCB.getValue() == null)
            errorMessage += "Не выбран город рождения!\n";
        if (workingPlaceTA.getText() == null || workingPlaceTA.getText().length() < 2)
            errorMessage += "Не указано место работы!\n";
        if (postTF.getText() == null || postTF.getText().length() < 2)
            errorMessage += "Не указана должность!\n";
        if(cityResidenceCB.getValue() == null)
            errorMessage += "Не выбран город проживания!\n";
        if(maritalStatusCB.getValue() == null)
            errorMessage += "Не указано семейное положение!\n";
        if(disabilityCB.getValue() == null)
            errorMessage += "Не указана инвалидность!\n";
        if (errorMessage.length() == 0)
            return true;
        else
            DialogManager.showErrorDialog("Ошибка заполнения формы регистрации", errorMessage);
        return false;
    }


    private void showList()
    {
        if(personPislObservableList.size() >0) {
            personPislObservableList.clear();
            personPislObservableList = FXCollections.observableArrayList();
        }
        personPislObservableList.addAll(this.personPislList);
        personPislTableView.getItems().clear();
        firstNameTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstName()));
        nameTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        disabilityTableColumn.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getDisability()));
        nationalityTableColumn.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getNationality()));
        personPislTableView.setItems(personPislObservableList);
        showPersonPisl(null);
        personPislTableView.getSelectionModel().selectedItemProperty().
                addListener(((observable, oldValue, newValue) -> showPersonPisl(newValue)));
    }

    public void initialPersonPislData(PersonPisl personPisl) throws ParseException {
        if(personPisl !=null) {
                personPisl.setFirstName(firstNameTF.getText());
                personPisl.setName(nameTF.getText());
                personPisl.setLastName(lastNameTF.getText());
                personPisl.setSex(sex.getValue());
                personPisl.setPasportNumber(passportNumberTF.getText());
                personPisl.setHphone(hphoneTF.getText());

                LocalDate birthdayTFValue = birthdayTF.getValue();
                Date docDate = Date.from(birthdayTFValue.atStartOfDay(ZoneId.systemDefault()).toInstant());
                personPisl.setBirthday(docDate);

                personPisl.setSerialPasport(serialPassportTF.getText());
                personPisl.setOrganizationGivePassport(organizationGivePassportTF.getText());

                LocalDate dateGivePassportTFValue = dateGivePassportTF.getValue();
                Date from = Date.from(dateGivePassportTFValue.atStartOfDay(ZoneId.systemDefault()).toInstant());
                personPisl.setBirthday(from);

                personPisl.setIdentifyNumber(identifyNumberTF.getText());
                personPisl.setPlaceOfBirth(placeOfBirthTA.getText());
                personPisl.setAdressLiving(addressLivingCB.getValue());
                personPisl.setMphone(mphoneTF.getText());
                personPisl.seteMail(eMailTF.getText());
                personPisl.setWorkingPlace(workingPlaceTA.getText());
                personPisl.setPost(postTF.getText());
                personPisl.setCityResidence(cityResidenceCB.getValue());
                personPisl.setAddressResidence(adressResidenceTA.getText());
                personPisl.setMaritalStatus(maritalStatusCB.getValue());
                personPisl.setNationality(nationalityCB.getValue());
                personPisl.setDisability(disabilityCB.getValue());
                personPisl.setPensioner(pensionerCheck.isSelected());
                personPisl.setMonthlyIncome(Double.valueOf(monthlyIncomeTF.getText()));
                personPisl.setReservist(ReservistCheck.isSelected());

        }
    }

    public void showPersonPisl(PersonPisl personPisl){
        if(personPisl != null) {
                idPersonPislLabel.setText(String.valueOf(personPisl.getIdpersonPisl()));
                firstNameTF.setText(personPisl.getFirstName());
                nameTF.setText(personPisl.getName());
                lastNameTF.setText(personPisl.getLastName());
                sex.setValue(personPisl.getSex());
                passportNumberTF.setText(personPisl.getPasportNumber());
                hphoneTF.setText(personPisl.getHphone());

                if(personPisl.getBirthday()!=null)
                    birthdayTF.setValue(DateUtil.parse(DateUtil.format(personPisl.getBirthday())));
                serialPassportTF.setText(personPisl.getSerialPasport());
                organizationGivePassportTF.setText(personPisl.getOrganizationGivePassport());

                if(personPisl.getDateGivePasport()!=null)
                    dateGivePassportTF.setValue(DateUtil.parse(DateUtil.format(personPisl.getDateGivePasport())));

                identifyNumberTF.setText(personPisl.getIdentifyNumber());
                placeOfBirthTA.setText(personPisl.getPlaceOfBirth());
                addressLivingCB.setValue(personPisl.getAdressLiving());
                mphoneTF.setText(personPisl.getMphone());
                eMailTF.setText(personPisl.geteMail());
                workingPlaceTA.setText(personPisl.getWorkingPlace());
                postTF.setText(personPisl.getPost());
                cityResidenceCB.setValue(personPisl.getCityResidence());
                adressResidenceTA.setText(personPisl.getAddressResidence());
                maritalStatusCB.setValue(personPisl.getMaritalStatus());
                nationalityCB.setValue(personPisl.getNationality());
                disabilityCB.setValue(personPisl.getDisability());
                pensionerCheck.setSelected(personPisl.isPensioner());
                monthlyIncomeTF.setText(String.valueOf(personPisl.getMonthlyIncome()));
                ReservistCheck.setSelected(personPisl.isReservist());

        }
        else
        {
            idPersonPislLabel.setText("");
            firstNameTF.setText("");
            nameTF.setText("");
            lastNameTF.setText("");
            sex.setValue("");
            passportNumberTF.setText("");
            hphoneTF.setText("");
            serialPassportTF.setText("");
            organizationGivePassportTF.setText("");
            identifyNumberTF.setText("");
            placeOfBirthTA.setText("");
            mphoneTF.setText("");
            eMailTF.setText("");
            workingPlaceTA.setText("");
            postTF.setText("");
            adressResidenceTA.setText("");
            pensionerCheck.setSelected(false);
            monthlyIncomeTF.setText("");
            ReservistCheck.setSelected(false);
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public BorderPane getRootLauotl() {
        return rootLauotl;
    }

    public void setRootLauotl(BorderPane rootLauotl) {
        this.rootLauotl = rootLauotl;
    }


    //---------------MODULE LAB 6 ---------------//
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    class NewThread implements Runnable {

        public NewThread() {

        }

        public void run() {

            while(true) {
                try {
                    sleep(1000);
                    service.getStstusServer();
                    if(!flagServer) {
                        flagServer = true;
                        sleep(4000);
                        makeSynchronize = true;
                    }
                    statusRESTServer.setFill(Color.GREEN);
                    statusRESTServer.setText("Соединение активно");
                } catch (RuntimeException e) {
                    if(flagServer) {
                        flagServer = false;
                        makeUpdate = true;
                    }
                    statusRESTServer.setFill(Color.ORANGERED);
                    statusRESTServer.setText("Соединение пассивно");
                }  catch (InterruptedException e) {
                    statusRESTServer.setFill(Color.ORANGERED);
                    statusRESTServer.setText("Соединение пассивно");
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    public Thread getRunn() {
        return runn;
    }

    public void synchronizedServer()
    {
        try {
            synchronized(ApplicationController.class) {
                if (flagServer && makeSynchronize) {
                    //runn.wait();
                    makeSynchronize = false;
                    List<PersonPisl> usersFromRest = service.getPersonPislsToServer();
                    List<PersonPisl> usersFromDB = service.getPersonPisls();
                    List<PersonPisl> resultList = new ArrayList<>();
                    service.alldelete(flagServer);
                    for (PersonPisl user : usersFromRest) {
                        user.setIdpersonPisl(0);
                        resultList.add(user);
                    }

                    for (PersonPisl user1 : usersFromDB) {
                        int flg = 0;
                        for (PersonPisl user : usersFromRest) {
                            if (user1.getPasportNumber().equals(user.getPasportNumber()))
                                flg = 1;
                        }
                        if (flg == 0) {
                            user1.setIdpersonPisl(0);
                            resultList.add(user1);
                        }
                    }

                    for (PersonPisl user : resultList) {
                        System.out.println(user.getPasportNumber() + " " + user.getRecieveTime().getTimeInMillis());
                    }

                    Collections.sort(resultList, (o1, o2) -> {
                        if (o1.getRecieveTime().getTimeInMillis() > o2.getRecieveTime().getTimeInMillis())
                            return 0;
                        return 1;
                    });

                    for (PersonPisl user : resultList) {
                        System.out.println(user.getPasportNumber() + " " + user.getRecieveTime().getTimeInMillis());
                    }
                    for (PersonPisl o : resultList)
                        service.save(o, flagServer);
                    makeUpdate = true;
                    //runn.notify();
                }
            }
        } catch (Exception e) {
            DialogManager.showErrorDialog("Ошибка при синхронизации",e.getLocalizedMessage());
        }

    }
}
