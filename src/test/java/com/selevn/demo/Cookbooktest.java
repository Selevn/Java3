package com.selevn.demo;


import com.selevn.demo.entities.CookbooksViewEntity;
import com.selevn.demo.entities.SingleCookbookViewEntity;
import com.selevn.demo.entities.UOF;
import com.selevn.demo.entities.repositories.CookBooksRepository;
import com.selevn.demo.entities.repositories.SingleCookBookRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class Cookbooktest {

    @Mock
    CookBooksRepository booksRepository;

    @Mock
    SingleCookBookRepository bookRepository;

    @InjectMocks
    UOF uofService;

    //unit (module)
    @Test
    void getTotalCookBooksCount_Positive(){
        long count = 15;
        when(booksRepository.getTotalCookBooksCount()).thenReturn(15);
        var actual = booksRepository.getTotalCookBooksCount();
        assertThat(count).isEqualTo(actual);
    }

    //integration
    @Test
    void getCookbook(){
        var bookMock = new SingleCookbookViewEntity();
        bookMock.setAuthor(1L);
        bookMock.setName("123");
        when(bookRepository.getSingleCookbookViewEntityById(15)).thenReturn(bookMock);
        var actual = uofService.getSingleCookBook(15);
        assertThat(bookMock).isEqualTo(actual);
    }


}
