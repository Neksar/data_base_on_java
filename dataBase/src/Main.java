import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные: ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                throw new Exception("Пустые строки вводить нельзя!");
            }

            String[] data = input.split(" ");

            if (data.length != 6) {
                throw new Exception("Неверное количество данных!");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            if (!isValidDate(birthDate)) {
                throw new Exception("Неверный формат даты рождения!");
            }
            if (!isValidPhoneNumber(phoneNumber)) {
                throw new Exception("Неверный формат номера телефона!");
            }
            if (!isValidGender(gender)) {
                throw new Exception("Неверный формат пола!");
            }
            String fileName = lastName + ".txt";

            FileWriter writer = new FileWriter(fileName, true);
            writer.write(lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender + "\n");
            writer.close();

            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    private static boolean isValidDate(String date) {
        // Проверка формата даты
        return date.matches("\\d{2}.\\d{2}.\\d{4}");
    }
    private static boolean isValidPhoneNumber(String phoneNumber) {
        // Проверка формата номера телефона
        return phoneNumber.matches("\\d+");
    }
    private static boolean isValidGender(String gender) {
        // Проверка формата пола
        return gender.equals("f") || gender.equals("m");
    }
}