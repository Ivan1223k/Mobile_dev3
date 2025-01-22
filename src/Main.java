import java.util.*;
import java.util.stream.Collectors;

// 1. Класс "Человек"
class Person {
    String name;
    int age;
    String gender;

    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    void printInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age + ", Пол: " + gender);
    }

    void increaseAge() {
        age++;
    }

    void changeName(String newName) {
        name = newName;
    }
}

// 2. Наследование: Класс "Работник" и "Менеджер"
class Worker extends Person {
    double salary;

    Worker(String name, int age, String gender, double salary) {
        super(name, age, gender);
        this.salary = salary;
    }

    void printSalary() {
        System.out.println("Зарплата: " + salary);
    }
}

class Manager extends Worker {
    String[] subordinates;

    Manager(String name, int age, String gender, double salary, String[] subordinates) {
        super(name, age, gender, salary);
        this.subordinates = subordinates;
    }

    void printSubordinates() {
        System.out.println("Подчиненные: ");
        for (String subordinate : subordinates) {
            System.out.println(subordinate);
        }
    }
}

// 3. Полиморфизм: Животные
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Вууф");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Мяу");
    }
}

class Cow implements Animal {
    public void makeSound() {
        System.out.println("Муу");
    }
}

// 4. Абстрактный класс "Транспорт"
abstract class Transport {
    abstract void move();
}

class Car extends Transport {
    void move() {
        System.out.println("Машина едет");
    }
}

class Bike extends Transport {
    void move() {
        System.out.println("Велосипед едет");
    }
}

// 5. Класс "Книга" и "Библиотека"
class Book {
    String title;
    String author;
    int year;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}

class Library {
    List<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    List<Book> searchByAuthor(String author) {
        return books.stream().filter(b -> b.author.equals(author)).collect(Collectors.toList());
    }

    List<Book> searchByYear(int year) {
        return books.stream().filter(b -> b.year == year).collect(Collectors.toList());
    }
}

// 6. Инкапсуляция: Банк
class BankAccount {
    private String accountNumber;
    private double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Недостаточно средств");
        }
    }

    public double getBalance() {
        return balance;
    }
}

// 7. Счетчик объектов
class Counter {
    private static int count = 0;

    Counter() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}

// 8. Площадь фигур
abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectanglel extends Shape {
    double length;
    double width;

    Rectanglel(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double getArea() {
        return length * width;
    }
}

// 9. Наследование: Животные и их движения
class AnimalMovement {
    void move() {}
}

class Fish extends AnimalMovement {
    @Override
    void move() {
        System.out.println("Рыба плавает");
    }
}

class Bird extends AnimalMovement {
    @Override
    void move() {
        System.out.println("Птица летит");
    }
}

class DogMovement extends AnimalMovement {
    @Override
    void move() {
        System.out.println("Собака бежит");
    }
}

// 10. Работа с коллекциями: Университет
class Student {
    String name;
    String group;
    double grade;

    Student(String name, String group, double grade) {
        this.name = name;
        this.group = group;
        this.grade = grade;
    }
}

class University {
    List<Student> students = new ArrayList<>();

    void addStudent(Student student) {
        students.add(student);
    }

    List<Student> sortByName() {
        return students.stream().sorted(Comparator.comparing(s -> s.name)).collect(Collectors.toList());
    }

    List<Student> filterByGrade(double minGrade) {
        return students.stream().filter(s -> s.grade >= minGrade).collect(Collectors.toList());
    }
}

// 11. Класс "Магазин"
class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class Store {
    List<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
    }

    void removeProduct(String name) {
        products.removeIf(p -> p.name.equals(name));
    }

    Product findProductByName(String name) {
        return products.stream().filter(p -> p.name.equals(name)).findFirst().orElse(null);
    }
}

// 12. Интерфейс "Платежная система"
interface PaymentSystem {
    void pay(double amount);
    void refund(double amount);
}

class CreditCard implements PaymentSystem {
    public void pay(double amount) {
        System.out.println("Оплачено " + amount + " с помощью кредитной карты");
    }

    public void refund(double amount) {
        System.out.println("Возвращено " + amount + " с помощью кредитной карты");
    }
}

class PayPal implements PaymentSystem {
    public void pay(double amount) {
        System.out.println("Оплачено " + amount + " с помощью карты");
    }

    public void refund(double amount) {
        System.out.println("Refunded " + amount + " с помощью карты");
    }
}

// 13. Генерация уникальных идентификаторов
class UniqueID {
    private static int idCounter = 0;

    public static String generateID() {
        idCounter++;
        return "ID-" + idCounter;
    }
}

// 14. Класс "Точка" и "Прямоугольник"
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle {
    Point topLeft, bottomRight;

    Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    int getArea() {
        return Math.abs(topLeft.x - bottomRight.x) * Math.abs(topLeft.y - bottomRight.y);
    }
}

// 15. Комплексные числа
class ComplexNumber {
    double real, imaginary;

    ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }

    ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }

    ComplexNumber multiply(ComplexNumber other) {
        double realPart = real * other.real - imaginary * other.imaginary;
        double imaginaryPart = real * other.imaginary + imaginary * other.real;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double realPart = (real * other.real + imaginary * other.imaginary) / denominator;
        double imaginaryPart = (imaginary * other.real - real * other.imaginary) / denominator;
        return new ComplexNumber(realPart, imaginaryPart);
    }
}

// 16. Перегрузка операторов: Матрица
class Matrix {
    double[][] values;

    Matrix(int rows, int cols) {
        values = new double[rows][cols];
    }

    Matrix add(Matrix other) {
        int rows = values.length;
        int cols = values[0].length;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.values[i][j] = this.values[i][j] + other.values[i][j];
            }
        }
        return result;
    }

    Matrix multiply(Matrix other) {
        int rows = values.length;
        int cols = other.values[0].length;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.values[i][j] = 0;
                for (int k = 0; k < values[0].length; k++) {
                    result.values[i][j] += this.values[i][k] * other.values[k][j];
                }
            }
        }
        return result;
    }
}

// 17. Создание игры с использованием ООП
class Playerr {
    String name;

    Playerr(String name) {
        this.name = name;
    }

    void attack() {
        System.out.println(name + " атакует!");
    }
}

class Enemy {
    String name;

    Enemy(String name) {
        this.name = name;
    }

    void attack() {
        System.out.println(name + " атакует!");
    }
}

class Weapon {
    String name;

    Weapon(String name) {
        this.name = name;
    }

    void use() {
        System.out.println("Использует " + name);
    }
}

// 18. Автоматизированная система заказов
class Order {
    String product;
    int quantity;
    double totalAmount;

    Order(String product, int quantity, double totalAmount) {
        this.product = product;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    void printOrder() {
        System.out.println("Продукты: " + product + ", Кол-во: " + quantity + ", Общ. стоимомть: " + totalAmount);
    }
}

class Customer {
    String name;
    List<Order> orders = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    void addOrder(Order order) {
        orders.add(order);
    }

    void printOrders() {
        for (Order order : orders) {
            order.printOrder();
        }
    }
}

// 19. Наследование: Электроника
class Device {
    String brand;

    Device(String brand) {
        this.brand = brand;
    }

    void turnOn() {
        System.out.println(brand + " устройство включено");
    }

    void turnOff() {
        System.out.println(brand + " устройство выключено");
    }
}

class Smartphone extends Device {
    Smartphone(String brand) {
        super(brand);
    }

    void takePhoto() {
        System.out.println("Фотка с " + brand);
    }
}

class Laptop extends Device {
    Laptop(String brand) {
        super(brand);
    }

    void browseWeb() {
        System.out.println("Просмотр веб-страниц на ноутбуке" + brand);
    }
}

// 20. Игра "Крестики-нолики"
class Game {
    char[][] board = new char[3][3];
    Player player1, player2;

    Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    void makeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell == 0 ? "." : cell);
            }
            System.out.println();
        }
    }
}

class Player {
    String name;
    char symbol;

    Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}

public class Main {
    public static void main(String[] args) {

        // 1. Класс "Человек"
        Person person = new Person("Иван", 30, "Мужчина");
        person.printInfo();
        person.increaseAge();
        person.printInfo();
        person.changeName("Давид");
        person.printInfo();

        // 2. Наследование: Класс "Работник" и "Менеджер"
        Worker worker = new Worker("Маша", 25, "Женщина", 50000);
        worker.printInfo();
        worker.printSalary();

        String[] subordinates = {"Игорь", "Лера"};
        Manager manager = new Manager("Кирилл", 40, "Male", 80000, subordinates);
        manager.printInfo();
        manager.printSalary();
        manager.printSubordinates();

        // 3. Полиморфизм: Животные
        Animal[] animals = {new Dog(), new Cat(), new Cow()};
        for (Animal animal : animals) {
            animal.makeSound();
        }

        // 4. Абстрактный класс "Транспорт"
        Transport car = new Car();
        Transport bike = new Bike();
        car.move();
        bike.move();

        // 5. Класс "Книга" и "Библиотека"
        Library library = new Library();
        library.addBook(new Book("Книга1", "Автора1", 2000));
        library.addBook(new Book("Книга2", "Автора2", 2020));
        library.addBook(new Book("Книга3", "Автора1", 2015));

        System.out.println("Книга Автора1:");
        library.searchByAuthor("Автора1").forEach(b -> System.out.println(b.title));

        System.out.println("Книга 2020 года:");
        library.searchByYear(2020).forEach(b -> System.out.println(b.title));

        // 6. Инкапсуляция: Банк
        BankAccount account = new BankAccount("123456", 1000);
        account.deposit(500);
        account.withdraw(200);
        System.out.println("Баланс: " + account.getBalance());

        // 7. Счетчик объектов
        new Counter();
        new Counter();
        System.out.println("Общее количество созданных объектов: " + Counter.getCount());

        // 8. Площадь фигур
        Shape circle = new Circle(5);
        Shape rectangle = new Rectanglel(4, 6);
        System.out.println("Площадь круга: " + circle.getArea());
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());

        // 9. Наследование: Животные и их движения
        AnimalMovement fish = new Fish();
        AnimalMovement bird = new Bird();
        AnimalMovement dog = new DogMovement();
        fish.move();
        bird.move();
        dog.move();

        // 10. Работа с коллекциями: Университет
        University university = new University();
        university.addStudent(new Student("Света", "Группа1", 4.5));
        university.addStudent(new Student("Настя", "Группа1", 3.2));
        university.addStudent(new Student("Коля", "Группа2", 4.0));

        System.out.println("Сортировка по имени:");
        university.sortByName().forEach(s -> System.out.println(s.name));

        System.out.println("Учащиеся с оценкой >= 4.0:");
        university.filterByGrade(4.0).forEach(s -> System.out.println(s.name));

        // 11. Класс "Магазин"
        Store store = new Store();
        store.addProduct(new Product("Продукт1", 10.0, 5));
        store.addProduct(new Product("Продукт2", 15.0, 3));

        Product foundProduct = store.findProductByName("Продукт1");
        if (foundProduct != null) {
            System.out.println("Найденный продукт: " + foundProduct.name + " Цена: " + foundProduct.price);
        }

        // 12. Интерфейс "Платежная система"
        PaymentSystem creditCard = new CreditCard();
        PaymentSystem paypal = new PayPal();
        creditCard.pay(100);
        paypal.refund(50);

        // 13. Генерация уникальных идентификаторов
        System.out.println("Уникальный ID: " + UniqueID.generateID());
        System.out.println("Уникальный ID: " + UniqueID.generateID());

        // 14. Класс "Точка" и "Прямоугольник"
        Point p1 = new Point(0, 0);
        Point p2 = new Point(5, 5);
        Rectangle rectangle2 = new Rectangle(p1, p2);
        System.out.println("Площадь прямоугольника: " + rectangle2.getArea());

        // 15. Комплексные числа
        ComplexNumber num1 = new ComplexNumber(2, 3);
        ComplexNumber num2 = new ComplexNumber(4, 5);

        ComplexNumber sum = num1.add(num2);
        System.out.println("Сумма: " + sum.real + " + " + sum.imaginary + "i");

        ComplexNumber difference = num1.subtract(num2);
        System.out.println("Разница: " + difference.real + " + " + difference.imaginary + "i");

        ComplexNumber product = num1.multiply(num2);
        System.out.println("Умножение: " + product.real + " + " + product.imaginary + "i");

        ComplexNumber quotient = num1.divide(num2);
        System.out.println("Деление: " + quotient.real + " + " + quotient.imaginary + "i");

        // 16. Перегрузка операторов: Матрица
        Matrix matrix1 = new Matrix(2, 2);
        matrix1.values[0][0] = 1;
        matrix1.values[0][1] = 2;
        matrix1.values[1][0] = 3;
        matrix1.values[1][1] = 4;

        Matrix matrix2 = new Matrix(2, 2);
        matrix2.values[0][0] = 5;
        matrix2.values[0][1] = 6;
        matrix2.values[1][0] = 7;
        matrix2.values[1][1] = 8;

        Matrix sumMatrix = matrix1.add(matrix2);
        System.out.println("Сумма матриц:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(sumMatrix.values[i][j] + " ");
            }
            System.out.println();
        }

        // 17. Создание игры с использованием ООП
        Playerr player = new Playerr("Игрок1");
        Enemy enemy = new Enemy("Враг1");
        Weapon weapon = new Weapon("Меч");

        player.attack();
        enemy.attack();
        weapon.use();

        // 18. Автоматизированная система заказов
        Order order1 = new Order("Продукт1", 2, 30.0);
        Order order2 = new Order("Продукт2", 1, 15.0);
        Customer customer = new Customer("Клиент1");
        customer.addOrder(order1);
        customer.addOrder(order2);

        customer.printOrders();

        // 19. Наследование: Электроника
        Device device = new Device("Sony");
        Smartphone smartphone = new Smartphone("Apple");
        Laptop laptop = new Laptop("Dell");

        device.turnOn();
        smartphone.takePhoto();
        laptop.browseWeb();

        // 20. Игра "Крестики-нолики"
        Player player1 = new Player("Игрок1", 'X');
        Player player2 = new Player("Игрок2", 'O');
        Game game = new Game(player1, player2);

        game.makeMove(0, 0, 'X');
        game.makeMove(1, 1, 'O');
        game.printBoard();
    }
}

