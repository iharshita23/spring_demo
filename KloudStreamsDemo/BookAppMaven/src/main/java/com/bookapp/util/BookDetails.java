package com.bookapp.util;

import java.time.LocalDate;
import java.util.*;

import com.bookapp.model.Book;

public class BookDetails {
	public static List<Book> showBooks(){
        return Arrays.asList(
                new Book("Java in Action","John David","Technology",1,670,LocalDate.of(2007,07,06)),
                new Book("Rich Dad Poor Dad","Robin Sharma","Selfhelp",2,556,LocalDate.of(2023,04,23)),
                new Book("HTML","Ben John","Technology",3,900,LocalDate.of(2002,06,02)),
                new Book("Manorama year book","SN Tiwari","Current Affairs",4,456,LocalDate.of(2019,02,11)),
                new Book("Parikatha","Mishra","Fiction",5,1400,LocalDate.of(2000,03,05))	                    );

    }

}
