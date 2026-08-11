package com.mario.backend;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final Map<Long, Order> orders = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@Valid @RequestBody Order order) {

        long id = idGenerator.getAndIncrement();

        order.setId(id);
        order.setStatus("CREATED");

        orders.put(id, order);

        return order;
    }

    @PutMapping("/{id}")
    public Order updateOrder(
            @PathVariable Long id,
            @Valid @RequestBody Order updatedOrder) {

        Order existingOrder = orders.get(id);

        if (existingOrder == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Order not found"
            );
        }

        existingOrder.setProduct(updatedOrder.getProduct());
        existingOrder.setQuantity(updatedOrder.getQuantity());

        return existingOrder;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {

        Order order = orders.get(id);

        if (order == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Order not found"
            );
        }

        orders.remove(id);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {

        Order order = orders.get(id);

        if (order == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Order not found"
            );
        }

        return order;
    }
}