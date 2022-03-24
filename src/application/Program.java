package application;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        String date = sc.next();

        // Novo cliente instanciado.
        Client client = new Client(name, email, sdf.parse(date));

        System.out.println("Enter order data: ");

        System.out.print("Status: ");
        String status = sc.next();

        Date moment = new Date();
        Order order = new Order(moment, OrderStatus.valueOf(status), client);

        System.out.print("How many item to this order? ");
        int n = sc.nextInt();


        for(int i = 1; i <= n; i++){
            sc.nextLine();

            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.next();

            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();

            System.out.print("Product quantity: ");
            Integer quantity = sc.nextInt();


            // produto instanciado
            Product product = new Product(productName, productPrice);

            // OrdemItem instanciado
            OrderItem orderItem = new OrderItem(quantity, productPrice, product);

            order.addItem(orderItem);

        }
        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println("Order moment : " +  sdf2.format(order.getMoment()));
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + order.getClient().getName() + " (" + sdf.format(order.getClient().getBrithDate()) + ") - " + order.getClient().getEmail());
        System.out.println("ORDER ITEMS: ");
        for(OrderItem item : order.getOrderItemList()){
            System.out.println(item.getProduct().getName() + ", $ " + item.getProduct().getPrice() + " Quantity: " + item.getQuantity()  + ", Subtotal: $ " + item.subTotal());
        }
        System.out.println("Total price: $ " + order.total());




    }
}
