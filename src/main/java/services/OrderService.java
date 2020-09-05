package services;

import entities.Customer;
import entities.Order;
import entities.Product;
import entities.Seller;

import java.util.ArrayList;

public class OrderService {

    private ProductService productService;
    private CustomerService customerService;
    private ArrayList<Order> orders;

    public OrderService(ProductService productService, CustomerService customerService) {
        this.productService = productService;
        this.customerService = customerService;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Seller seller, Customer customer){
        System.out.println("Trying to create new order");
        ArrayList<Product> toOrderList = customer.getProductBucket();
        for(Product p: toOrderList){
            if(p.getForAdult() && customer.getAge() < 18)
                System.out.println("Customer(" + customer.getFirstName() + " " + customer.getLastName()
                        + ") age is " + customer.getAge() + ". \n He can't buy " + p.getName());
            else{
                productService.deleteProduct(p);
                Order order = new Order((long)p.hashCode(), p, seller, customer);
                System.out.println("New order has created: " + order);
                orders.add(order);
                customerService.addCustomer(customer);
            }
        }
        customerService.clearCustomerBucket(customer);
    }

    public void showAllOrders(){
        System.out.println("___________________________________________");
        System.out.println("Orders: ");
        for(Order o: orders){
            System.out.println("id: " + o.getId() + "\t inOrder: " + o.getProductsInOrder() + "\n seller: " + o.getSeller()
                    + "\t customer: " + o.getCustomer() + "\n price: " + o.getPrice() + "\t orderDate: " + o.getOrderDate());
        }
        System.out.println("___________________________________________");
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
