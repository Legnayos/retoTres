package com.desaextremo.retotres.Controllers;

import com.desaextremo.retotres.Entities.Order;
import com.desaextremo.retotres.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id)
    {
        return orderService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }

    //Reto 3
    @GetMapping("/zona/{zona}")
    public List<Order> findOrderByZoneV1(@PathVariable("zona") String zona){
        return orderService.findOrderByZoneV1(zona);
    }

    @GetMapping("/zonav2/{zona}")
    public List<Order> findOrderByZoneV2(@PathVariable("zona") String zona){
        return orderService.findOrderByZoneV2(zona);
    }
}
