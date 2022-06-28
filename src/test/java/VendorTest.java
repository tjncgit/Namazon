import com.Account.Vendor;
import com.Exceptions.ProductNotAvailableException;
import com.Order.Address;
import com.Order.Order;
import com.Order.OrderStatus;
import com.Product.Product;
import com.Product.ProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendorTest {
    private Vendor vendor = new Vendor("New Vendor", "john", "doe", "johnd@gmail.com","1234");
    private HashMap<Product,Integer> inventory = new HashMap<>();
    private Product[] showCase = new Product[5];
    private List<Order> order = new ArrayList<>();


    @Test
    public void constructorTest() {
        String expected = "New Vendor" + " " + inventory + " [null, null, null, null, null] " + order;
        String actual = vendor.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addProductTest() {
        int expected = 1;
        Product product = new Product("ps5", ProductCategory.ELECTRONICS, 499.99);
        vendor.addProduct(product);
        int actual = vendor.getInventory().size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void modifyProductTest() {
        Product product = new Product("ps5", ProductCategory.ELECTRONICS, 499.99);
        vendor.addProduct(product);
        Boolean actual = vendor.modifyProduct("ps5", "Air Fryer");
        Assertions.assertTrue(actual);
    }

    @Test
    public void removeProductTest() {
        Product product = new Product("ps5", ProductCategory.ELECTRONICS, 499.99);
        vendor.addProduct(product);
        Boolean actual = vendor.removeProduct("ps5");
        int expected = 0;
        int actualSize = vendor.getInventory().size();
        Assertions.assertEquals(expected,actualSize);
        Assertions.assertTrue(actual);
    }

    @Test
    public void addProductToShowcaseTest() {
        Product product = new Product("ps5", ProductCategory.ELECTRONICS, 499.99);
        String expected = "Name: ps5, Category: Electronics, Price: $499.99";
        vendor.addProduct(product);
        vendor.addProductToShowcase("ps5", 0);
        String actual = vendor.getShowCase()[0].toString();
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void searchByCategoryTest() {
        Product product = new Product("ps5", ProductCategory.ELECTRONICS, 499.99);
        vendor.addProduct(product);
        vendor.addProductToShowcase("ps5", 0);
        List<Product> expected = new ArrayList<>();
        expected.add(product);
        List<Product> actual = vendor.searchByCategory(ProductCategory.ELECTRONICS);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchByNameTest() {
        Product product = new Product("ps5", ProductCategory.ELECTRONICS, 499.99);
        vendor.addProduct(product);
        vendor.addProductToShowcase("ps5", 0);
        List<Product> expected = new ArrayList<>();
        expected.add(product);
        List<Product> actual = vendor.searchByName("ps5");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void purchaseTest() throws ProductNotAvailableException {
        Product product = new Product("ps5", ProductCategory.ELECTRONICS, 499.99);
        Address address = new Address("Tree Rd", "22","Denver", "Colorado");
        Order order = new Order(product, address, OrderStatus.PENDING);
        int expected = 1;
        vendor.addProduct(product);
        vendor.addProductToShowcase("ps5", 0);
        vendor.purchase(product, address);
        int actual = vendor.getOrders().size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void displayAllOrderTest() throws ProductNotAvailableException {
        String expected = "Product: Name: ps5, Category: Electronics, Price: $499.99, Address: Tree Rd 22 Denver Colorado, Status: Pending\n";
        Product product = new Product("ps5", ProductCategory.ELECTRONICS, 499.99);
        Address address = new Address("Tree Rd", "22","Denver", "Colorado");
        Order order = new Order(product, address, OrderStatus.PENDING);
        vendor.addProduct(product);
        vendor.addProductToShowcase("ps5", 0);
        vendor.purchase(product, address);
        String actual = vendor.displayAllOrders();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void cancelOrderTest() throws ProductNotAvailableException {
        boolean expected = true;
        Product product = new Product("ps5", ProductCategory.ELECTRONICS, 499.99);
        Address address = new Address("Tree Rd", "22","Denver", "Colorado");
        vendor.addProduct(product);
        vendor.addProductToShowcase("ps5", 0);
        vendor.purchase(product, address);
        boolean actual = vendor.cancelOrder("ps5");
        Assertions.assertEquals(expected, actual);
    }
}
