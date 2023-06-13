package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите данный через пробел: ");
        System.out.println("Фамилия Имя Отчество Дата Рождения Номер Телефона Пол");
        Scanner sc = new Scanner(System.in);
        String[] userInfo = sc.nextLine().split(" ");
        Validator vl = new Validator();
        try {
           if(vl.validate(userInfo)){
               Repository wr = new Repository();
               wr.write(userInfo);
           }
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e);
        }
    }
}