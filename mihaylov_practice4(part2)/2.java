import java.util.ArrayList;
import java.util.List;

class Car {
    private String licensePlate;
    private String model;
    private boolean isRented;

    // Конструктор для инициализации полей
    public Car(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.isRented = false; // автомобиль доступен по умолчанию
    }

    // Метод для аренды автомобиля
    public void rent() {
        this.isRented = true;
    }

    // Метод для возврата автомобиля
    public void returnCar() {
        this.isRented = false;
    }

    // Метод для вывода информации о автомобиле
    public void displayInfo() {
        System.out.println("Модель: " + model);
        System.out.println("Номерной знак: " + licensePlate);
        System.out.println("Доступен: " + (isRented ? "Нет" : "Да"));
    }

    // Геттер для статуса аренды
    public boolean isRented() {
        return isRented;
    }

    // Геттер для модели автомобиля
    public String getModel() {
        return model;
    }

    // Геттер для номерного знака
    public String getLicensePlate() {
        return licensePlate;
    }
}

class Driver {
    private String name;
    private Car rentedCar;

    // Конструктор для инициализации полей
    public Driver(String name) {
        this.name = name;
        this.rentedCar = null; // по умолчанию у водителя нет арендованного автомобиля
    }

    // Метод для аренды автомобиля
    public void rentCar(Car car) {
        if (!car.isRented()) {
            this.rentedCar = car;
            car.rent();  // меняем статус аренды на "арендован"
        } else {
            System.out.println("Автомобиль \"" + car.getModel() + "\" с номером " + car.getLicensePlate() + " уже арендован.");
        }
    }

    // Метод для возврата арендованного автомобиля
    public void returnCar() {
        if (rentedCar != null) {
            rentedCar.returnCar();
            rentedCar = null; // сбрасываем арендованный автомобиль
        } else {
            System.out.println("У вас нет арендованного автомобиля.");
        }
    }

    // Метод для вывода информации о водителе
    public void displayInfo() {
        System.out.println("Водитель: " + name);
        if (rentedCar != null) {
            System.out.println("Арендованный автомобиль:");
            rentedCar.displayInfo();
        } else {
            System.out.println("У водителя нет арендованного автомобиля.");
        }
    }
}

class CarPark {
    private List<Car> cars;

    // Конструктор для инициализации списка автомобилей
    public CarPark() {
        this.cars = new ArrayList<>();
    }

    // Метод для добавления автомобиля в автопарк
    public void addCar(Car car) {
        cars.add(car);
    }

    // Метод для отображения доступных автомобилей
    public void displayAvailableCars() {
        System.out.println("Доступные автомобили:");
        for (Car car : cars) {
            if (!car.isRented()) {
                car.displayInfo();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание объекта автопарка
        CarPark carPark = new CarPark();

        // Создание объекта автомобилей
        Car car1 = new Car("747ABC", "Toyota Camry");
        Car car2 = new Car("668AID", "Honda Accord");

        // Добавление автомобилей в автопарк
        carPark.addCar(car1);
        carPark.addCar(car2);

        // Создание объекта водителя
        Driver driver = new Driver("Махмет");

        // Отображение доступных автомобилей
        carPark.displayAvailableCars();

        // Водитель арендует автомобиль
        driver.rentCar(car1);
        driver.displayInfo();

        // Отображение доступных автомобилей после того, как водитель арендовал один
        carPark.displayAvailableCars();

        // Водитель возвращает арендованный автомобиль
        driver.returnCar();
        driver.displayInfo();

        // Отображение доступных автомобилей после возврата
        carPark.displayAvailableCars();
    }
}