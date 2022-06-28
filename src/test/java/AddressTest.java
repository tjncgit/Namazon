import com.Order.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddressTest {
    @Test
    @DisplayName("address constructor test")
    public void addressConstructorTest01() {
        Address address = new Address("Mockingbird", "23", "Atlanta", "GA");
        String expected = "Mockingbird 23 Atlanta GA";
        String actual = address.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("get street test")
    public void getStreetTest01() {
        Address address = new Address("Mockingbird", "23", "Atlanta", "GA");
        String expected = "Mockingbird";
        String actual = address.getStreet();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("set street test")
    public void setStreetTest01() {
        Address address = new Address("Mockingbird", "23", "Atlanta", "GA");
        String expected = "Hummingbird";
        address.setStreet("Hummingbird");
        String actual = address.getStreet();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("get unit test")
    public void getUnitTest01() {
        Address address = new Address("Mockingbird", "23", "Atlanta", "GA");
        String expected = "23";
        String actual = address.getUnit();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("set unit test")
    public void setUnitTest01() {
        Address address = new Address("Mockingbird", "23", "Atlanta", "GA");
        String expected = "36";
        address.setUnit("36");
        String actual = address.getUnit();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("get city test")
    public void getCityTest01() {
        Address address = new Address("Mockingbird", "23", "Atlanta", "GA");
        String expected = "Atlanta";
        String actual = address.getCity();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("set city test")
    public void setCityTest01() {
        Address address = new Address("Mockingbird", "23", "Atlanta", "GA");
        String expected = "Savannah";
        address.setCity("Savannah");
        String actual = address.getCity();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("get state test")
    public void getStateTest01() {
        Address address = new Address("Mockingbird", "23", "Atlanta", "GA");
        String expected = "GA";
        String actual = address.getState();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("set state test")
    public void setStateTest01() {
        Address address = new Address("Mockingbird", "23", "Atlanta", "GA");
        String expected = "VA";
        address.setState("VA");
        String actual = address.getState();
        Assertions.assertEquals(expected, actual);
    }
}
