package com.desaextremo.retotres.Services;

import com.desaextremo.retotres.Entities.Order;
import com.desaextremo.retotres.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.findById(id);
    }

    public Order create(Order order) {
        if (order.getId() == null) {
            return order;
        } else {
            return orderRepository.save(order);
        }
    }

    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepository.findById(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepository.save(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        Order orderDelete;
        Optional<Order> optional = orderRepository.findById(id);

        if (optional.isPresent()){
            orderDelete = optional.get();
            orderRepository.delete(orderDelete);
            return true;
        }else{
            return false;
        }
    }

    //Reto 3
    public List<Order> findOrderByZoneV1(String zona){
        return orderRepository.findByZona(zona);
    }
    public List<Order> findOrderByZoneV2(String zona){
        return orderRepository.findAllBySalesMan_Zone(zona);
    }



}
