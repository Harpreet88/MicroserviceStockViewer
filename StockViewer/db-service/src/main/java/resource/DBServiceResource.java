package resource;

import model.Quote;
import model.Quotes;
import org.springframework.web.bind.annotation.*;
import repository.QuotesRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {
    public DBServiceResource(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    private QuotesRepository quotesRepository;
    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") final String username) {

        return getQuotesByUserName(username);
    }
        private List<String> getQuotesByUserName(@PathVariable("username") final String username)
        {
            return quotesRepository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
               .collect(Collectors.toList());


    }

    @PostMapping("/add")
    public List<String >add(@RequestBody final Quotes quotes){
        quotes.getQuotes()
                .stream()
                .map(quote ->new Quote(quotes.getUserName(),quote))
                .forEach(quote->quotesRepository.save(quote));

        return getQuotesByUserName(quotes.getUserName());

    }

    @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username){
        List<Quote> quotes= quotesRepository.findByUserName(username);
        quotesRepository.delete(quotes);
        return getQuotesByUserName(username);
    }

    }


