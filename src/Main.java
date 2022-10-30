import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Product> products;


    public static void main(String[] args) {
        products.add(new Product(1L, "TV", 500, 5, "Electronic"));
        products.add(new Product(2L, "Snack", 700, 2, "Appliances"));
        products.add(new Product(3L, "Fan", 900, 3, "Electronic"));
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        do {
            System.out.println("MENU");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product By Id");
            System.out.println("3. Delete Product By Id");
            System.out.println("4. Display Product By Id");
            System.out.println("5. Display Product");
            System.out.println("6. Display Product By Category");
            System.out.println("7. Sum Price All Product");
            System.out.println("8. Display Product have price > 100000");
            System.out.println("9. Display Product have price > 200000 & have category 'electronic'");
            System.out.println("0. Exit");
            System.out.println("Input your choice: ");
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Please choose again:");
            }
            switch (choice) {
                case 1:
                    productManager.addProduct(scanner);
                    break;
                case 2:
                    productManager.updateProduct(scanner);
                    break;
                case 3:
                    productManager.deleteProductById(scanner);
                    break;
                case 4:
                    productManager.displayProductById(scanner);
                    break;
                case 5:
                    productManager.displayProduct();
                    break;
                case 6:
                    productManager.displayProductByCategory(scanner);
                    break;
                case 7:
                    productManager.sumPriceAllProduct();
                    break;
                case 8:
                    productManager.displayProductHasPriceHigher100();
                    break;
                case 9:
                    productManager.displayProductHasPriceHigher200AndCategoryElectronic();
                    break;
                case 0:
                    System.exit(0);
            }
        } while (true);
    }
}