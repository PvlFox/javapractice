import java.util.ArrayList;
import java.util.List;

// Перечисление для типов питомцев
enum PetType {
    DOG,
    CAT
}

// Перечисление для статуса здоровья питомцев
enum HealthStatus {
    HEALTHY,
    SICK
}

class Pet {
    private String name;
    private int age;
    private PetType type;
    private HealthStatus healthStatus;

    public Pet(String name, int age, PetType type) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.healthStatus = HealthStatus.HEALTHY; // По умолчанию питомец здоров
    }

    public String getName() {
        return name;
    }

    public PetType getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    // Метод для вывода информации о питомце
    public void displayInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age + ", Тип: " + type);
        System.out.println("Статус здоровья: " + healthStatus);
    }
}

class Dog extends Pet {
    private String breed; // Порода собаки

    public Dog(String name, int age, String breed) {
        super(name, age, PetType.DOG);
        this.breed = breed;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Порода: " + breed);
    }
}

class Cat extends Pet {
    private String color; // Цвет кошки

    public Cat(String name, int age, String color) {
        super(name, age, PetType.CAT);
        this.color = color;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Цвет: " + color);
    }
}

class PetClinic {
    private List<Pet> pets; // Список питомцев

    public PetClinic() {
        pets = new ArrayList<>();
    }

    // Метод для добавления питомца в клинику
    public void addPet(Pet pet) throws Exception {
        for (Pet existingPet : pets) {
            if (existingPet.getName().equals(pet.getName())) {
                // Если питомец с таким именем уже есть
                throw new Exception("Питомец с таким именем уже есть в клинике!");
            }
        }
        pets.add(pet);
        System.out.println("Питомец " + pet.getName() + " успешно добавлен!");
    }

    // Метод для отображения информации о всех питомцах
    public void displayPets() {
        if (pets.isEmpty()) {
            System.out.println("Клиника пуста. Нет питомцев.");
        } else {
            for (Pet pet : pets) {
                pet.displayInfo();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PetClinic clinic = new PetClinic();
        try {
            // Создаем питомцев
            Dog dog1 = new Dog("Бобик", 3, "Шершавая");
            Cat cat1 = new Cat("Мурка", 2, "Черный");

            // Добавляем питомцев в клинику
            clinic.addPet(dog1);
            clinic.addPet(cat1);

            // Попытка добавить питомца с уже существующим именем
            Dog dog2 = new Dog("Бобик", 5, "Лабрадор");
            clinic.addPet(dog2); // вызовет исключение, так как питомец с таким именем уже существует

            // Добавляем другого питомца
            Cat cat2 = new Cat("Гарри", 2, "Рыжий");
            clinic.addPet(cat2);

            // Отображаем информацию о питомцах
            clinic.displayPets();

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}