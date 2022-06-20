package controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doReturn;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.assignment.bookstore.BookStoreApplication;
import com.assignment.bookstore.entity.Book;
import com.assignment.bookstore.service.BooksService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = BookStoreApplication.class)
public class BooksControllerTest {

	@MockBean
	private BooksService booksSvc;

	@Autowired
	private static MockMvc mockMvc;
	
	private static List<Book> booksList;
	
	private static Book book1 = new Book("Book1", "This is book1", "AD", "COMIC", BigDecimal.valueOf(25), 1234567891L);
	

	@Test
	public void testGetAllBooks() throws Exception{
		booksList = Arrays.asList(book1);

		Mockito.when(booksSvc.getAllBooks()).thenReturn(booksList);
		
		assertFalse(booksList.isEmpty());
		
		/*
		 * mockMvc.perform(MockMvcRequestBuilders.get("/getAllBooks")).andExpect(
		 * MockMvcResultMatchers.status().isOk()).andExpect(
		 * MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(1)))
		 * .andExpect(MockMvcResultMatchers.jsonPath("$0.name").value("Book1"));
		 */
	}
	
	@Test
	public void testGetBookById() throws Exception{
		book1.setId(1L);
		
		Mockito.when(booksSvc.getBookById(1L)).thenReturn(book1);
		
		
		/*
		 * mockMvc.perform(MockMvcRequestBuilders.get("/getBook/1"))
		 * .andExpect(MockMvcResultMatchers.status().isOk())
		 * .andExpect(MockMvcResultMatchers.content().contentType(MediaType.
		 * APPLICATION_JSON_VALUE))
		 * .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
		 * .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Book1"));
		 */

	}
	
	@Test
	public void testAddBook() throws Exception{
		doReturn(book1).when(booksSvc).addBook(book1);
		
		/*
		 * mockMvc.perform(MockMvcRequestBuilders.post("/addBook")
		 * .contentType(MediaType.APPLICATION_JSON) .content(asJsonString(book1)))
		 * .andExpect(MockMvcResultMatchers.status().isCreated());
		 */
	}
	
	@Test
	public void testUpdateBook() throws Exception{
		doReturn(book1).when(booksSvc).updateBook(book1, 1L);
		
		/*
		 * mockMvc.perform(MockMvcRequestBuilders.put("/updateBook/1")
		 * .contentType(MediaType.APPLICATION_JSON) .content(asJsonString(book1)))
		 * .andExpect(MockMvcResultMatchers.status().isOk());
		 */
	}
	
	
	@Test
	public void testDeleteBook() throws Exception{
		/*
		 * mockMvc.perform(MockMvcRequestBuilders .delete("/deleteBook/1")
		 * .contentType(MediaType.APPLICATION_JSON))
		 * .andExpect(MockMvcResultMatchers.status().isOk());
		 */
	}
	
	
	static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw new RuntimeException("There is an error while writing JSON as String");
        }
    }
}
