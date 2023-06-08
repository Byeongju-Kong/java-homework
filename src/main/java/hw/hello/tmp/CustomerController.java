package hw.hello.tmp;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers/register")
public class CustomerController {

    private static final String INSERT_QUERY =
            "INSERT INTO CUSTOMER (username, password, name, phone_number, address) values (?, ?, ?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM CUSTOMER";
    private static final RowMapper<Customer> CUSTOMER_ROW_MAPPER = (rs, rowNum) -> new Customer(
            rs.getLong("customer_id"),
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("name"),
            rs.getString("phone_number"),
            rs.getString("address")
    );

    private final JdbcTemplate jdbcTemplate;

    public CustomerController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/page")
    public String getCustomerRegisterPage(Customer customer) {
        return "customerRegister";
    }

    @GetMapping
    public String customer() {
        return "redirect:/";
    }

    @PostMapping
    public String registerCustomer(Model model, @Validated @ModelAttribute("customer") Customer customer,
                                   Errors errors) {
        if (errors.hasErrors()) {
            return "customerRegister";
        }
        jdbcTemplate.update(INSERT_QUERY, customer.getUsername(), customer.getPassword(),
                customer.getName(), customer.getPhoneNumber(), customer.getAddress());
        List<Customer> customers = jdbcTemplate.query(SELECT_QUERY, CUSTOMER_ROW_MAPPER);
        model.addAttribute("customers", customers);
        return "customers";
    }
}
