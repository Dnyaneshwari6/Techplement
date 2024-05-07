package com.app;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class QuoteController {
	
	private List<Quote> quotes = Arrays.asList(
            new Quote("Be yourself; everyone else is already taken."),
            new Quote("Nothing is impossible...."),
            new Quote("So many books, so little time."),
            new Quote("Belive yourself")
            // Add more quotes as needed
    );

    @GetMapping("/quote")
    public Quote getRandomQuote() {
        Random random = new Random();
        return quotes.get(random.nextInt(quotes.size()));
    }

	@GetMapping("/getData")
	public String getMessage()
	{
		return "https successfully used";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(QuoteController.class, args);
	}

	@Bean // equivalent to <bean id ..../> in xml file
	public ModelMapper mapper() {
		ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration()
			.setMatchingStrategy(MatchingStrategies.STRICT)
	.setPropertyCondition(Conditions.isNotNull());
		return modelMapper;
	}

}


