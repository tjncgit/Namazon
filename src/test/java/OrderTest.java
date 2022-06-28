import com.Order.Address;
import com.Order.Order;
import com.Order.OrderStatus;
import com.Product.Product;
import com.Product.ProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    @DisplayName("Order Constructor Test")
    public void ConstructorTest01(){
        //Given
        Product shirt = new Product("Shirt", ProductCategory.CLOTHING, 20.00);
        Address address = new Address("Bubble", "23", "Trenton","NJ");
        Order order = new Order(shirt, address, OrderStatus.PENDING );
        String expected = "Product: Name: Shirt, Category: Clothing, Price: $20.00, Address: Bubble 23 Trenton NJ, Status: Pending";
        //When
        String actual = order.toString();
        //Then
        Assertions.assertEquals(expected, actual);
    }
}
