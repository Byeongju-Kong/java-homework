package hw.hello.tmp;

import java.time.LocalDate;
import javax.validation.constraints.Min;

public class Order {

    private long id;
    @Min(value = 1)
    private int bookId;
    @Min(value = 1)
    private int customerId;
    private LocalDate orderDate;

    public Order() {
    }

    public Order(long id, int bookId, int customerId, LocalDate orderDate) {
        this.id = id;
        this.bookId = bookId;
        this.customerId = customerId;
        this.orderDate = orderDate;
    }

    public long getId() {
        return id;
    }

    public int getBookId() {
        return bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
