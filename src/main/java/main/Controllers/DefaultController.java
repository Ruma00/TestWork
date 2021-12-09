package main.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @RequestMapping("/")
    public String index() {
        /*Iterable<Book> bookIterable = bookRepository.findAll();
        ArrayList<Book> books = new ArrayList<>();

        for (Book book : bookIterable) {
            books.add(book);
        }

        model.addAttribute("books", books)
                .addAttribute("booksCount", books.size())
                .addAttribute("someParameter", someParameter);*/
        return "index";
    }
}
