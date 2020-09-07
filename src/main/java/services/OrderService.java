package services;

import entities.Customer;
import entities.Order;
import entities.Product;
import entities.Seller;

import java.util.ArrayList;

public final class OrderService {

    private final ProductService productService;
    private final CustomerService customerService;
    private ArrayList<Order> orders;

    public OrderService(ProductService productService, CustomerService customerService) {
        this.productService = productService;
        this.customerService = customerService;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Seller seller, Customer customer){
        System.out.println("Trying to create new order");
        ArrayList<Product> toOrderList = customer.getProductBucket();

        long orderId = (long) ((Math.random() * 31)
                % (seller.getId() + customer.getId()))*31;
        for(Product p: toOrderList){
            if(p.getForAdult() && customer.getAge() < 18)
                System.out.println("Customer(" + customer.getFirstName() + " " + customer.getLastName()
                        + ") age is " + customer.getAge() + ". \n He can't buy " + p.getName());
            else{
                productService.deleteProduct(p);
                Order order = new Order(orderId, p, seller, customer);
                System.out.println("New order has created: " + order);
                orders.add(order);
                customerService.addCustomer(customer);
            }
        }
        customerService.clearCustomerBucket(customer);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("___________________________________________").append("\nOrders: ");
        for(Order o: orders){
            stringBuilder.append("\nid: ").append(o.getId()).append("\t inOrder: ")
                    .append(o.getProductsInOrder()).append("\n seller: ")
                    .append(o.getSeller()).append("\t customer: ").append(o.getCustomer())
                    .append("\n price: ").append(o.getPrice()).append("\t orderDate: ")
                    .append(o.getOrderDate());
        }
        stringBuilder.append("\n___________________________________________");

        return stringBuilder.toString();
    }
}
