import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class ProductManager {
     private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void addProduct(Scanner scanner) {
         try {
             System.out.println("Input id: ");
             Long id = Long.parseLong(scanner.nextLine());
             System.out.println("Input name: ");
             String name = scanner.nextLine();
             System.out.println("Input price: ");
             Double price = Double.parseDouble(scanner.nextLine());
             System.out.println("Input quantity: ");
             int quantity = Integer.parseInt(scanner.nextLine());
             System.out.println("Input category: ");
             String category = scanner.nextLine();
             products.add(new Product(id, name, price, quantity, category));
         } catch (InputMismatchException | NumberFormatException e) {
             System.err.println("Your information is not exactly! Please choose again: ");
         }
    }

    public void updateProduct(Scanner scanner) {
        try {
            System.out.println("Input id product: ");
            Long idUpdate = Long.parseLong(scanner.nextLine());
            int index;
            if ((index = checkExist(idUpdate)) != -1) {
                System.out.println("Input new name:");
                String name = scanner.nextLine();
                if (!name.equals("")) {
                    products.get(index).setName(name);
                }
                System.out.println("Input new price:");
                String price = scanner.nextLine();
                if (!price.equals("")) {
                    products.get(index).setPrice(Double.parseDouble(price));
                }
                System.out.println("Input new quantity:");
                String quantity = scanner.nextLine();
                if (!quantity.equals("")) {
                    products.get(index).setQuantity(Integer.parseInt(quantity));
                }
                System.out.println("Input new category:");
                String category = scanner.nextLine();
                if (!category.equals("")) {
                    products.get(index).setCategory(category);
                }
            } else {
                System.out.println("Your product that want update is not exist!");
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Your information is not exactly! Please choose again!");
        }
    }
    
    public int checkExist(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return products.indexOf(product);
            }
        }
        return -1;
    }

    public void displayProduct() {
        if (products.isEmpty()) {
            System.out.println("Product is not available!");
        } else {
            for (Product product: products) {
                System.out.println(product);
            }
        }
    }

    public void deleteProductById(Scanner scanner) {
        try {
            System.out.println("Input id product:");
            Long idUpdate = Long.parseLong(scanner.nextLine());
            int index;
            if ((index = checkExist(idUpdate)) != -1) {
                products.remove(index);
            } else {
                System.out.println("Product is not available!");
            }
        } catch (NumberFormatException e) {
            System.err.println("Your information is not exactly! Please choose again!");
        }
    }

    public void displayProductById(Scanner scanner) {
        try {
            System.out.println("Input id product:");
            Long idUpdate = Long.parseLong(scanner.nextLine());
            int index;
            if ((index = checkExist(idUpdate)) != -1) {
                System.out.println(products.get(index));
            } else {
                System.out.println("Id is not found!");
            }
        }catch (NumberFormatException e) {
            System.err.println("Your information is not exactly! Please choose again!");
        }
    }

    public void displayProductByCategory(Scanner scanner) {
        try {
            System.out.println("Input category: ");
            String category = scanner.nextLine();
            for (int i = 0; i < products.size(); i++) {
                if (category.equals(products.get(i).getCategory())) {
                    System.out.println(products.get(i).getCategory());
                }
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Category not found!");
        }
    }

    public void sumPriceAllProduct() {
        double sum = 0;
        for (int i = 0; i < products.size(); i++) {
            sum += products.get(i).getPrice();
        }
        System.out.println();
        System.out.println("All Price of Product is: " + sum);
    }

    public void displayProductHasPriceHigher100() {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() > 100000) {
                System.out.println(products.get(i));
            }
        }
    }

    public void displayProductHasPriceHigher200AndCategoryElectronic() {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCategory().equals("Electronic")) {
                System.out.println(products.get(i));
            }
        }
    }












}
