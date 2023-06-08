package hw.hello.tmp;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Book {

    private Long id;

    @NotEmpty
    private String bookName;

    @NotEmpty
    private String publisher;

    @Min(value = 1000, message = "최소 가격은 1000원")
    @Max(value = 100000, message = "최대 가격은 100000원")
    private int price;

    @NotEmpty
    private String type;
    @NotEmpty
    private String imageUrl;

    public Book() {
    }

    public Book(Long id, String bookName, String publisher, int price, String type, String imageUrl) {
        this.id = id;
        this.bookName = bookName;
        this.publisher = publisher;
        this.price = price;
        this.type = type;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
