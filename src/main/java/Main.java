import com.Account.Account;
import com.Account.Customer;
import com.Account.Vendor;
import com.Exceptions.AccountAuthenticationException;
import com.Exceptions.AccountCreationException;
import com.Exceptions.ProductNotAvailableException;
import com.Namazon;
import com.Order.Address;
import com.Order.Order;
import com.Product.Product;
import com.Product.ProductCategory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private Scanner scanner;
    private Namazon app;
    private Account account;
    private Vendor vendor;
    private String email;
    private String password;
    private String brandName;
    private String firstName;
    private String lastName;
    public Main() {
        this.scanner = new Scanner(System.in);
        this.app = new Namazon();
    }
    public void start() {
        boolean flag = true;
        while(flag) {
            if (account == null) {
                flag = welcomeScreen();
            } else {
                if( account instanceof Vendor) {
                    vendorAccountOperations();
                } else if (account instanceof  Customer) {
                }
            }
        }
    }


    public boolean welcomeScreen() {
        boolean flag = true;
        System.out.println("Welcome To Namazon \n===================== \n 0: Exit \n 1: Log In \n 2: Sign Up as Vendor \n 3: Sign Up as Customer ");
        int option = scanner.nextInt();
        switch (option) {
            case 0:
                System.out.println("Come Back Soon");
                flag = false;
                break;
            case 1:
                attemptSignIn();
                break;
            case 2:
                attemptSignUpAsVendor();
                break;
            case 3:
                attemptSignUpAsCustomer();
                break;
        }
        return flag;
    }

    public void attemptSignIn() {
        System.out.println("\n Enter Email:");
        email = scanner.next();
        System.out.println("\n Enter password:");
        password = scanner.next();
        try {
            account = app.signInTo(email, password);
        } catch (AccountAuthenticationException e) {
            System.out.println(e.getMessage());
        }
    }

    public void attemptSignUpAsVendor() {
        System.out.println("\n Enter brand name:");
        brandName = scanner.next();
        System.out.println("\n Enter first name:");
        firstName = scanner.next();
        System.out.println("\n Enter last name:");
        lastName = scanner.next();
        System.out.println("\n Enter Email:");
        email = scanner.next();
        System.out.println("\n Enter password:");
        password = scanner.next();
        try {
            account = app.signUpAsVendor(brandName, firstName, lastName, email, password);
        } catch (AccountCreationException e) {
            System.out.println( e.getMessage());
        }
    }

    public void attemptSignUpAsCustomer() {
        System.out.println("\n Enter first name:");
        firstName = scanner.next();
        System.out.println("\n Enter last name:");
        lastName = scanner.next();
        System.out.println("\n Enter Email:");
        email = scanner.next();
        System.out.println("\n Enter password:");
        password = scanner.next();
        try {
            account = app.signUpAsCustomer(firstName, lastName, email, password);
        } catch (AccountCreationException e) {
            System.out.println( e.getMessage());
        }
    }
    public void vendorAddProduct() {
        System.out.println("Enter product name:");
        String productName = scanner.next();
        System.out.println("Choose Product Category: \n1: Electronics \n2: Athletics \n3: Clothing \n4: Home Appliances");
        int categoryOption = scanner.nextInt();
        ProductCategory productCategory = selectCategory(categoryOption);
        System.out.println("Enter Price of Product:");
        Double productPrice = scanner.nextDouble();
        Product product = vendor.createProduct(productName, productCategory, productPrice);
        vendor.addProduct(product);
    }

    public void vendorModifyProduct() {
        System.out.println("Choose product to modify");
        for(String name: vendor.getInventory().keySet()) {
            System.out.println(name);
        }
        String name = scanner.next();
        System.out.println("Enter modified name:");
        String newName = scanner.next();
        boolean isModified =  vendor.modifyProduct(name, newName);
        if(isModified) {
            System.out.println("product has been modified");
        } else {
            System.out.println("could not modify product");
        }
    }

    public void vendorRemoveProduct(){
        System.out.println("Choose product to remove");
        String removeName = scanner.next();
        vendor.removeProduct(removeName);
    }

    public void vendorCancelOrder() {
        System.out.println("All current Orders");
        System.out.println(vendor.displayAllOrders());
        System.out.println("Enter Name of product to cancel order");
        String name = scanner.next();
        vendor.cancelOrder(name);
    }

    public void vendorAddToShowcase() {
        System.out.println("Enter product name of to add to showcase:");
        String showcaseName = scanner.next();
        System.out.println("choose index:");
        int index = scanner.nextInt();
        vendor.addProductToShowcase(showcaseName, index);
    }

    public void vendorSearchByCategory() {
        System.out.println("Choose Product Category: \n1: Electronics \n2: Athletics \n3: Clothing \n4: Home Appliances");
        int category = scanner.nextInt();
        ProductCategory searchCategory = selectCategory(category);
        System.out.println("Search Results");
        List<Product> categoryProducts = vendor.searchByCategory(searchCategory);
        displayProducts(categoryProducts);
    }

    public void vendorSearchByName() {
        System.out.println("Enter Name of Product to Search");
        String searchName = scanner.next();
        System.out.println("Search Results");
        List<Product> nameProducts =  vendor.searchByName(searchName);
        displayProducts(nameProducts);
    }

    public void vendorPurchaseOrder() {
        System.out.println("Enter Name of Product to Purchase");
        String purchaseName = scanner.next();
        Product purchaseProduct = vendor.getProductFromInventory(purchaseName);
        System.out.println("Enter Street");
        String street = scanner.next();
        System.out.println("Enter Unit");
        String unit = scanner.next();
        System.out.println("Enter City");
        String city = scanner.next();
        System.out.println("Enter State");
        String state = scanner.next();
        Address address =  vendor.setNewAddress(street, unit, city, state);
        try {
            vendor.purchase(purchaseProduct, address);
        } catch (ProductNotAvailableException e) {
            System.out.println(e.getMessage());;
        }
    }


    public void vendorAccountOperations() {
        vendor = (Vendor) account;
        System.out.println("0: Log Out \n1: Add Product \n2: Modify Product \n3: Remove Product \n4: Cancel Order  \n5: Add Product To Showcase \n6: Search By Category \n7: Search By Name \n8: Purchase \n9: displayAllOrders\n");
        int operation = scanner.nextInt();
        switch (operation) {
            case 0:
                account = null;
                vendor = null;
                break;
            case 1:
                vendorAddProduct();
                break;
            case 2:
                vendorModifyProduct();
                break;
            case 3:
                break;
            case 4:
                vendorCancelOrder();
                break;
            case 5:
                vendorAddToShowcase();
                break;
            case 6:
                vendorSearchByCategory();
                break;
            case 7:
                vendorSearchByName();
                break;
            case 8:
                vendorPurchaseOrder();
                break;
            case 9:
                System.out.println(vendor.displayAllOrders());
                break;
        }
    }

    public void displayProducts(List<Product> products) {
        for(Product product: products) {
            System.out.println(product.toString());
        }
    }

    public ProductCategory selectCategory(int category) {
        return switch (category) {
            case 1 -> ProductCategory.ELECTRONICS;
            case 2 -> ProductCategory.ATHLETICS;
            case 3 -> ProductCategory.CLOTHING;
            case 4 -> ProductCategory.HOME_APPLIANCES;
            default -> null;
        };
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("new", "value");
        map.put("new1", "value");
        System.out.println(map.toString());
        Main main = new Main();
        main.start();
    }
}
