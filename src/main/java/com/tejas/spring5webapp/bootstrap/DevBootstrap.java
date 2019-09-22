package com.tejas.spring5webapp.bootstrap;

import com.tejas.spring5webapp.model.Author;
import com.tejas.spring5webapp.model.Book;
import com.tejas.spring5webapp.model.Publisher;
import com.tejas.spring5webapp.repositories.AuthorRepository;
import com.tejas.spring5webapp.repositories.BookRepository;
import com.tejas.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        //Tejas
        Author kalidas = new Author("Kavi", "Kalidas");
        Publisher tejasPublication=new Publisher();
        tejasPublication.setName("Tejas Publication");
        tejasPublication.setAddress("Kamadar Street, Bahelapara, Nr. Chabutara, Limbdi, 363421");
        Book ramayana = new Book("Ramayana", "123456",tejasPublication);
        kalidas.getBooks().add(ramayana);
        ramayana.getAuthors().add(kalidas);

        publisherRepository.save(tejasPublication);
        authorRepository.save(kalidas);
        bookRepository.save(ramayana);

        Author vedvyas = new Author("Kavi", "Vedvyas");
        Publisher radhikaPublication = new Publisher();
        radhikaPublication.setName("Radhika Publication");
        radhikaPublication.setAddress("D-510, Surel Appartment, Nr. Devashish School AMTS Stop, Bodakdev, Ahmedabad, 380052");
        Book mahabharat = new Book("Mahabharat", "654321", radhikaPublication);
        vedvyas.getBooks().add(mahabharat);
        mahabharat.getAuthors().add(vedvyas);

        publisherRepository.save(radhikaPublication);
        authorRepository.save(vedvyas);
        bookRepository.save(mahabharat);

    }
}

