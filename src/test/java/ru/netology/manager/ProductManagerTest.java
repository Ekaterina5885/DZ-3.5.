package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager();
    private Book firstBook = new Book(101, "Ангелы и демоны (2000)", 100, "Дэн Браун");
    private Book secondBook = new Book(202, "Код да Винчи (2003)", 200, "Дэн Браун");
    private Book thirdBook = new Book(303, "Затерянный мир", 300, "Артур Конан Дойл");
    private Smartphone firstSmartphone = new Smartphone(404, "10X Lite 4/128GB", 300, "Honor");
    private Smartphone secondSmartphone = new Smartphone(505, "9S 32GB", 400, "Honor");
    private Smartphone thirdSmartphone = new Smartphone(606, "Y8p 128GB", 400, "Huawei");

    @BeforeEach
    public void setup() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        manager.add(thirdSmartphone);
    }

    // Поиск одной книги - по названию;
    @Test
    public void shouldFindBookByName() {

        Product[] expected = new Product[]{thirdBook};
        Product[] actual = manager.searchBy("Затерянный мир");
        assertArrayEquals(expected, actual);
    }

    // Поиск всех книг - по автору;
    @Test
    public void shouldFindBooksByName() {

        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy("Код да Винчи (2003)");
        assertArrayEquals(expected, actual);
    }

    // Поиск одного телефона - по названию;
    @Test
    public void shouldFindSmartphoneByName() {

        Product[] expected = new Product[]{thirdSmartphone};
        Product[] actual = manager.searchBy("Y8p 128GB");
        assertArrayEquals(expected, actual);

    }

    // Поиск телефонов - по наименованию производителя;
    @Test
    public void shouldFindSmartphonesByManufacturer() {

        Product[] expected = new Product[]{firstSmartphone, secondSmartphone};
        Product[] actual = manager.searchBy("Honor");
        assertArrayEquals(expected, actual);
    }

    // Поиск книги по несуществующему автору;
    @Test
    public void shouldNotFindBook() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Стивен Кинг");
        assertArrayEquals(expected, actual);
    }
}
