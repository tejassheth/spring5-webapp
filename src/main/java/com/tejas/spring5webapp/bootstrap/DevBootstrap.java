package com.tejas.spring5webapp.bootstrap;

import com.tejas.spring5webapp.model.Author;
import com.tejas.spring5webapp.model.Book;
import com.tejas.spring5webapp.repositories.AuthorRepository;
import com.tejas.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
    private void initData(){
        //Tejas
        Author  kalidas=new Author("Kavi","Kalidas");
        Book ramayana= new Book("Ramayana","123456","Tejas Publication");
        kalidas.getBooks().add(ramayana);
        ramayana.getAuthors().add(kalidas);

        authorRepository.save(kalidas);
        bookRepository.save(ramayana);

        Author vedvyas=new Author("Kavi","Vedvyas");
        Book mahabharat= new Book("Mahabharat","654321","Radhika Publication");
        vedvyas.getBooks().add(mahabharat);
        mahabharat.getAuthors().add(vedvyas);

        authorRepository.save(vedvyas);
        bookRepository.save(mahabharat);

    }
}

