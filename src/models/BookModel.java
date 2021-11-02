package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Account;
import entities.Book;

public class BookModel {
	
	public List<Book> findAll(){
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from book where quantity > 0");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setTitle(rs.getString("title"));
				book.setAuthor_name(rs.getString("author_name"));
				book.setDescription(rs.getString("description"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPrice(rs.getDouble("price"));
				book.setId_category(rs.getInt("id_category"));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
			books = null;
		}finally {
			ConnectDB.disconnect();
		}
		return books;
	}
	public List<Book> findAll(String name){
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from book,category where book.id_category = category.id AND category.name like ? ");
			ps.setString(1,"%"+ name + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setTitle(rs.getString("title"));
				book.setAuthor_name(rs.getString("author_name"));
				book.setDescription(rs.getString("description"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPrice(rs.getDouble("price"));
				book.setId_category(rs.getInt("id_category"));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
			books = null;
		}finally {
			ConnectDB.disconnect();
		}
		return books;
	}
	
	public Book searchBookByName(String name){
		Book book = null;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from book where name like ?");
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setTitle(rs.getString("title"));
				book.setAuthor_name(rs.getString("author_name"));
				book.setDescription(rs.getString("description"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPrice(rs.getDouble("price"));
				book.setId_category(rs.getInt("id_category"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			book = null;
		}finally {
			ConnectDB.disconnect();
		}
		return book;
	}
	
	public Book searchBookId(int id){
		Book book = null;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from book where id = ?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setTitle(rs.getString("title"));
				book.setAuthor_name(rs.getString("author_name"));
				book.setDescription(rs.getString("description"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPrice(rs.getDouble("price"));
				book.setId_category(rs.getInt("id_category"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			book = null;
		}finally {
			ConnectDB.disconnect();
		}
		return book;
	}
	
	
	public List<Book> searchByName(String name){
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from book where name like ?");
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setTitle(rs.getString("title"));
				book.setAuthor_name(rs.getString("author_name"));
				book.setDescription(rs.getString("description"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPrice(rs.getDouble("Price"));
				book.setId_category(rs.getInt("id_category"));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
			books = null;
		}finally {
			ConnectDB.disconnect();
		}
		return books;
	}
	
	public List<Book> searchByAuthor(String author){
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from book where author_name like ?");
			ps.setString(1, "%" + author + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setTitle(rs.getString("title"));
				book.setAuthor_name(rs.getString("author_name"));
				book.setDescription(rs.getString("description"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPrice(rs.getDouble("price"));
				book.setId_category(rs.getInt("id_category"));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
			books = null;
		}finally {
			ConnectDB.disconnect();
		}
		return books;
	}
	
	public List<Book> searchByIdCategory(int id){
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from book where id_category = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setTitle(rs.getString("title"));
				book.setAuthor_name(rs.getString("author_name"));
				book.setDescription(rs.getString("description"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPrice(rs.getDouble("price"));
				book.setId_category(rs.getInt("id_category"));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
			books = null;
		}finally {
			ConnectDB.disconnect();
		}
		return books;
	}
	
	
	public int countBook(){
		int i = 0;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select count(*) from book");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				i = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			i = 0;
		}finally {
			ConnectDB.disconnect();
		}
		return i;
	}
	
	public int countAuthor(){
		int i = 0;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select count(DISTINCT author_name) as author from book");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				i = rs.getInt("author");
			}
		} catch (Exception e) {
			e.printStackTrace();
			i = 0;
		}finally {
			ConnectDB.disconnect();
		}
		return i;
	}
	
	public boolean insert(Book book) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("insert into "
					+ "book(name,title,author_name,description,quantity,price,id_category)"
					+ "values (?,?,?,?,?,?,?)");
			ps.setString(1,book.getName());
			ps.setString(2, book.getTitle());
			ps.setString(3,book.getAuthor_name());
			ps.setString(4, book.getDescription());
			ps.setInt(5, book.getQuantity());
			ps.setDouble(6, book.getPrice());
			ps.setInt(7, book.getId_category());
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean update(Book book) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("update book "
							+ "set name = ? , title = ?, author_name = ? , description = ? , quantity = ?, price = ?, id_category = ? where id = ?");//sql query ( truy van )
			ps.setString(1, book.getName());
			ps.setString(2, book.getTitle());
			ps.setString(3,book.getAuthor_name());
			ps.setString(4, book.getDescription());
			ps.setInt(5, book.getQuantity());
			ps.setDouble(6, book.getPrice());
			ps.setInt(7, book.getId_category());
			ps.setInt(8, book.getId());
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean delete(int id) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("delete from book where id = ?");//sql query ( truy van )
			ps.setInt(1, id);
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}

}
