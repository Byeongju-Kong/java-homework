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
@RequestMapping("/books/register")
public class BookController {

    private static final String INSERT_QUERY = "INSERT INTO BOOK (name, publisher, price, type, image_url) values (?, ?, ?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM BOOK";
    private static final RowMapper<Book> BOOK_ROW_MAPPER = (rs, rowNum) -> new Book(
            rs.getLong("book_id"),
            rs.getString("name"),
            rs.getString("publisher"),
            rs.getInt("price"),
            rs.getString("type"),
            rs.getString("image_url")
    );

    private final JdbcTemplate jdbcTemplate;

    public BookController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/page")
    public String getBookRegisterPage(Book book) {
        return "bookRegister";
    }

    @GetMapping
    public String book() {
        return "redirect:/";
    }

    @PostMapping
    public String registerBook(Model model, @Validated Book book, Errors errors) {
        if (errors.hasErrors()) {
            return "bookRegister";
        }
        jdbcTemplate.update(INSERT_QUERY, book.getBookName(), book.getPublisher(),
                book.getPrice(), book.getType(), book.getImageUrl());
        List<Book> books = jdbcTemplate.query(SELECT_QUERY, BOOK_ROW_MAPPER);
        model.addAttribute("books", books);
        return "books";
    }
}
