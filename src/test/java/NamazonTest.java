import com.Account.Account;
import com.Account.Vendor;
import com.Exceptions.AccountAuthenticationException;
import com.Exceptions.AccountCreationException;
import com.Namazon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class NamazonTest {
    @Test
    public void ConstructorTest() {
        String expected = "customers= [], vendors= [], accounts= []" ;
        Namazon app = new Namazon();
        String actual = app.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void signInTest() throws AccountAuthenticationException {
        String expected = "Gucci john doe johnd@gmail.com 1234 {} [null, null, null, null, null] []";
        Vendor vendor = new Vendor("Gucci", "john", "doe", "johnd@gmail.com", "1234");
        Namazon app = new Namazon();
        Map accounts = new TreeMap<>();
        accounts.put(vendor.getEmail(), vendor);
        app.setAccounts(accounts);
        String actual = app.signInTo("johnd@gmail.com","1234").toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void signUpAsVendorTest() throws AccountCreationException {
        String expected = "Gucci john doe johnd@gmail.com 1234 {} [null, null, null, null, null] []";
        Namazon app = new Namazon();
        String actual = app.signUpAsVendor("Gucci", "john", "doe", "johnd@gmail.com", "1234").toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void signUpAsCustomerTest() throws AccountCreationException {
        String expected = "john doe johnd@gmail.com 1234";
        Namazon app = new Namazon();
        String actual = app.signUpAsCustomer( "john", "doe", "johnd@gmail.com", "1234").toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void selectVendorTest() {
        String expected = "Gucci john doe johnd@gmail.com 1234 {} [null, null, null, null, null] []";
        Namazon app = new Namazon();
        Vendor vendor = new Vendor("Gucci", "john", "doe", "johnd@gmail.com", "1234");
        List<Vendor> vendors = new ArrayList<>();
        vendors.add(vendor);
        app.setVendors(vendors);
        String actual = app.selectVendor("Gucci").toString();
        Assertions.assertEquals(expected, actual);
    }
}
