package by.bsuir.pisl.controller;

import by.bsuir.pisl.model.ConnectionServer;
import by.bsuir.pisl.model.entity.PersonPisl;
import by.bsuir.pisl.model.entity.enumeration.Cities;
import by.bsuir.pisl.model.entity.enumeration.Disability;
import by.bsuir.pisl.model.entity.enumeration.MaritalStatus;
import by.bsuir.pisl.model.entity.enumeration.Nationality;
import by.bsuir.pisl.model.service.PersonPislService;
import by.bsuir.pisl.model.util.DateConvert;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrey on 19.04.2016.
 */
@Component
public class ApplicationController implements Controller{

    @Autowired
    private PersonPislService personPislService;

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
    private TextField birthdayTF;

    @FXML
    private TextField serialPassportTF;

    @FXML
    private TextField organizationGivePassportTF;

    @FXML
    private TextField dateGivePassportTF;

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
    }

    @FXML
    private void createPersonPisl()
    {
        showPersonPisl(null);
    }

    @FXML
    private void addPersonPisl()
    {
        if(isValidPerson())
        {
            try {
                PersonPisl personPisl = new PersonPisl();
                initialPersonPislData(personPisl);
                this.personPislList.add(personPisl);
                showList();
            } catch (ParseException e) {
                System.out.println(e);
            }
        }
    }

    @FXML
    private void updatePersonPisl()
    {
        System.out.println("update");
        PersonPisl personPisl = personPislTableView.getSelectionModel().getSelectedItem();
        if(personPisl != null)
        {
            personPisl = personPislList.get(personPislList.indexOf(personPisl));
            if(isValidPerson()) {
                try {
                    initialPersonPislData(personPisl);
                    showList();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        else
            DialogManager.showWarningDialog("Внимание, вы не выбрали объект для обновления","Для обновления объекта, " +
                    "необходимо выбрать объект, внести изменения, и только после этого обновлять!!!");
    }

    @FXML
    private void deletePersonPisl()
    {
        PersonPisl personPisl = personPislTableView.getSelectionModel().getSelectedItem();
        if(personPisl!=null)
        {
            personPislList.remove(personPisl);
            showList();
        }
        else
            DialogManager.showWarningDialog("Внимание, вы не выбрали объект для Удаления","Для удаления объекта, " +
                    "необходимо выбрать объект и только после этого удалять!!!");

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
                this.personPislList.add(personPislService.saveOrUpdate(personPisl));
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
                    personPislService.saveOrUpdate(personPisl);
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
                    personPislService.deleteById(idPersonDelete);
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
    private void clonePersonPislFromServer()
    {
        try {
            System.out.println("clonePersonPislFromServer");
            personPislList = personPislService.getPersonPisls();
            showList();
        } catch (Exception e) {
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
        if (birthdayTF.getText() == null || birthdayTF.getText().length() < 2)
            errorMessage += "Дата рождения не указана!\n";
        else {
            if (!DateConvert.validDate(birthdayTF.getText()))
                errorMessage += "неверный формат ввода даты, введите дату в следующем формате дд.мм.гггг!\n";
        }
        if (serialPassportTF.getText() == null || serialPassportTF.getText().length() < 2)
            errorMessage += "Не указана серия паспорта!\n";
        if (dateGivePassportTF.getText() == null || dateGivePassportTF.getText().length() < 2)
            errorMessage += "Дата выдачи пасспорта не указана!\n";
        else {
        if (!DateConvert.validDate(dateGivePassportTF.getText()))
            errorMessage += "неверный формат ввода даты, введите дату в следующем формате дд.мм.гггг!\n";
        }
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
            try {
                personPisl.setFirstName(firstNameTF.getText());
                personPisl.setName(nameTF.getText());
                personPisl.setLastName(lastNameTF.getText());
                personPisl.setSex(sex.getValue());
                personPisl.setPasportNumber(passportNumberTF.getText());
                personPisl.setHphone(hphoneTF.getText());
                personPisl.setBirthday(DateConvert.StringToUtilDate(birthdayTF.getText()));
                personPisl.setSerialPasport(serialPassportTF.getText());
                personPisl.setOrganizationGivePassport(organizationGivePassportTF.getText());
                personPisl.setDateGivePasport(DateConvert.StringToUtilDate(dateGivePassportTF.getText()));
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
            } catch (ParseException e) {
                DialogManager.showErrorDialog("Ошибка при обработке данных!", e.getLocalizedMessage());
                throw e;
            }
        }
    }

    public void showPersonPisl(PersonPisl personPisl){
        System.out.println(personPisl);
        if(personPisl != null) {
                idPersonPislLabel.setText(String.valueOf(personPisl.getIdpersonPisl()));
                firstNameTF.setText(personPisl.getFirstName());
                nameTF.setText(personPisl.getName());
                lastNameTF.setText(personPisl.getLastName());
                sex.setValue(personPisl.getSex());
                passportNumberTF.setText(personPisl.getPasportNumber());
                hphoneTF.setText(personPisl.getHphone());
                birthdayTF.setText(personPisl.getBirthday().toLocaleString());
                serialPassportTF.setText(personPisl.getSerialPasport());
                organizationGivePassportTF.setText(personPisl.getOrganizationGivePassport());
                dateGivePassportTF.setText(personPisl.getDateGivePasport().toLocaleString());
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
            birthdayTF.setText("");
            serialPassportTF.setText("");
            organizationGivePassportTF.setText("");
            dateGivePassportTF.setText("");
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
}
