package org.example;
import org.example.MyExeptions.DataSizeExceptions;
import org.example.MyExeptions.DateExceptions;
public class Validator {
    public boolean validate(String[] data) throws Exception{
        return validateSizeData(data) && validateYearOfBirth(data[3]) && validateTelNumber(data[4]) && validateGender(data[5]);
    }

    private boolean validateSizeData (String[] data) throws DataSizeExceptions {
        String message;
        if (data.length < 6){
            message = "Введено кол-во данным меньше требуемых!";
            throw new DataSizeExceptions(message);
        }
        if (data.length > 6){
            message = "Введено кол-во данным больше требуемых!";
            throw new DataSizeExceptions(message);
        }
        return true;
    }
    private boolean validateYearOfBirth(String yearOfBirth) throws Exception{
        String[] date = yearOfBirth.split("\\.");
        if (date.length < 3){
            throw new DateExceptions("Неверный формат даты! Дата должна быть в формате dd.mm.yyyy!");
        }
        try {
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            if ((day < 1 || day > 31) || (month < 1 || month > 12) || year < 1900)
                throw new DateExceptions("Неверный формат даты! Введенное значение не является числом!");
            return true;
        } catch (NumberFormatException | DateExceptions e){
            throw new DateExceptions(e.getMessage());
        }
    }

    private  boolean validateTelNumber(String telNumber) throws NumberFormatException{
        try {
            int tel = Integer.parseInt(telNumber);
            return tel > 0;
        } catch (NumberFormatException e){
            throw new NumberFormatException("Введен некорректный номер телефона!");
        }
    }

    public static boolean validateGender(String gender) throws RuntimeException {
        if (!(gender.equals("f") || gender.equals("m")))
            throw new RuntimeException("Введено не коректное значение! Пол может быть только m или f");
        return true;
    }
}
