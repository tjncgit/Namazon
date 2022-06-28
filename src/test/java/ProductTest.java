import com.Product.Product;
import com.Product.ProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

public class ProductTest {
    @Test
    @DisplayName("Card constructor test")
    public void ConstructorTest01() {
        //Given
        Product product = new Product("Shirt", ProductCategory.CLOTHING, 20.00);
        // When
        String expected = "Name: Shirt, Category: Clothing, Price: $20.00";
        String actual = product.toString();
        // Then
        Assertions.assertEquals(expected, actual);
    }
}
