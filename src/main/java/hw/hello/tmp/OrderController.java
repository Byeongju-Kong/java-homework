package hw.hello.tmp;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders/register")
public class OrderController {

    private static final String INSERT_QUERY = "INSERT INTO ORDERS (customer_id, book_id) values (?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM ORDERS";
    private static final RowMapper<Order> ORDER_ROW_MAPPER = (rs, rowNum) -> new Order(
            rs.getLong("orders_id"),
            rs.getInt("book_id"),
            rs.getInt("customer_id"),
            rs.getDate("order_date").toLocalDate()
    );

    private final JdbcTemplate jdbcTemplate;

    public OrderController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/page")
    public String getOrderPage(Order order) {
        return "orderRegister";
    }

    @GetMapping
    public String orders() {
        return "redirect:/";
    }

    @PostMapping
    public String registerOrder(Model model, @Validated Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "orderRegister";
        }
        jdbcTemplate.update(INSERT_QUERY, order.getCustomerId(), order.getBookId());
        List<Order> orders = jdbcTemplate.query(SELECT_QUERY, ORDER_ROW_MAPPER);
        model.addAttribute("orders", orders);
        return "orders";
    }
}
