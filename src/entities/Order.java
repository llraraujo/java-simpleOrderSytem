package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;

    private Client client;

    private List<OrderItem> orderItemList = new ArrayList<>();

    public Order(){

    }

    public Order(Date moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void addItem(OrderItem item){
        orderItemList.add(item);
    }

    public void remove(OrderItem item){
        orderItemList.remove(item);
    }

    public Double total(){
        double sum = 0;
        for(OrderItem item: orderItemList){
            sum += item.subTotal();
        }

        return sum;
    }



}
