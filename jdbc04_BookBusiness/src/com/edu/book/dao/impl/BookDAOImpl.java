package com.edu.book.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.book.dao.BookDAO;
import com.edu.book.exception.BookNotFoundException;
import com.edu.book.exception.DuplicateISBNException;
import com.edu.book.exception.InvalidInputException;
import com.edu.book.vo.Book;

import config.ServerInfo;

public class BookDAOImpl implements BookDAO{

    private static BookDAOImpl dao = new BookDAOImpl();
    private BookDAOImpl() {}
    public static BookDAOImpl getInstance() {
        return dao;
    }
    
    @Override
    public Connection getConnect() throws SQLException {
    	Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB Server Connection...");
		return conn;
    }

    @Override
    public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
    	if(ps!=null) ps.close();
		if(conn!=null) conn.close();
    }

    @Override
    public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
    	if(rs!=null) rs.close();
		closeAll(conn, ps);
    }

    @Override
    public int isExists(String isbn, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        String query = "SELECT isbn FROM book WHERE isbn=?";
        ps = conn.prepareStatement(query);
        ps.setString(1, isbn);
        rs = ps.executeQuery();
        if(rs.next()) {
        	count+=1;
        }
        return count;
    }

    @Override
    public void registerBook(Book vo) throws SQLException, DuplicateISBNException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
        	conn = getConnect();
        	if(isExists(vo.getIsbn(), conn) == 0) {
        		String query = "INSERT INTO book(isbn, title, author, publisher, price) VALUES(?, ?, ?, ?, ?)";
        		ps = conn.prepareStatement(query);
        		ps.setString(1, vo.getIsbn());
        		ps.setString(2, vo.getTitle());
        		ps.setString(3, vo.getWriter());
        		ps.setString(4, vo.getPublisher());
        		ps.setInt(5, vo.getPrice());
        		int row = ps.executeUpdate();
        		System.out.println(row+"row Book Register Success!");
        	} else {
        		throw new DuplicateISBNException("이미 존재하는 ISBN입니다.");
        	}
        } finally {
        		closeAll(conn, ps);
        }
    }

    @Override
    public void deleteBook(String isbn) throws SQLException, BookNotFoundException {
    	Connection conn = null;
        PreparedStatement ps = null;
        try {
        	conn = getConnect();
        	if(isExists(isbn, conn) != 0) {
        		String query = "DELETE FROM book WHERE isbn=?";
        		ps = conn.prepareStatement(query);
        		ps.setString(1, isbn);
        		int row = ps.executeUpdate();
        		System.out.println(row+"row Book Delete Success!");
        	} else {
        		throw new BookNotFoundException("삭제할 도서가 존재하지 않습니다.");
        	}
        } finally {
        	closeAll(conn, ps);
        }
    }

    @Override
    public Book findByIsbn(String isbn) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Book bk = null;
        try {
        	conn = getConnect();
    		String query = "SELECT * FROM book WHERE isbn=?";
    		ps = conn.prepareStatement(query);
    		ps.setString(1, isbn);
    		rs = ps.executeQuery();
    		if(rs.next()) {
    			bk = new Book(isbn, rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getInt("price"));
    		}
        } finally {
    		closeAll(conn, ps, rs);
    	}
        return bk;
    }

    @Override
    public Book findByTitle(String title) throws SQLException, BookNotFoundException {
    	Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Book bk = null;
        try {
        	conn = getConnect();
    		String query = "SELECT * FROM book WHERE title LIKE '%'||?||'%'";
    		ps = conn.prepareStatement(query);
    		ps.setString(1, title);
    		rs = ps.executeQuery();
    		if(rs.next()) {
    			bk = new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getInt("price"));
    		} else {
        		throw new BookNotFoundException("찾을 수 없는 도서입니다.");
    		}
        } finally {
        	closeAll(conn, ps, rs);
        }
        return bk;
    }

    @Override
    public ArrayList<Book> findByWriter(String writer) throws SQLException, BookNotFoundException {
    	Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Book> list = new ArrayList<>();
        try {
        	conn = getConnect();
        	String query = "SELECT * FROM book WHERE author=?";
        	ps = conn.prepareStatement(query);
			ps.setString(1, writer);
			rs = ps.executeQuery();
			if(rs.next()) {
				list.add(new Book(rs.getString("isbn"), rs.getString("title"), writer, rs.getString("publisher"), rs.getInt("price")));
			} else {
        		throw new BookNotFoundException("해당 작가의 도서를 찾을 수 없습니다.");
    		}
        } finally {
        	closeAll(conn, ps, rs);
        }
        return list;
    }

    @Override
    public ArrayList<Book> findByPublisher(String publish) throws SQLException, BookNotFoundException {
    	Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Book> list = new ArrayList<>();
        try {
        	conn = getConnect();
        	String query = "SELECT * FROM book WHERE publisher=?";
        	ps = conn.prepareStatement(query);
			ps.setString(1, publish);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), publish, rs.getInt("price")));
			}
        } finally {
        	closeAll(conn, ps, rs);
        }
        return list;
    }

    @Override
    public ArrayList<Book> findByPrice(int min, int max) throws SQLException, InvalidInputException {
    	Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Book> list = new ArrayList<>();
        try {
        	conn = getConnect();
        	String query = "SELECT * FROM book WHERE price BETWEEN ? AND ?";
        	ps = conn.prepareStatement(query);
			ps.setInt(1, min);
			ps.setInt(2, max);
			rs = ps.executeQuery();
			if(min > max) {
				throw new InvalidInputException("입력한 값의 범위가 잘못되었습니다.");
			} else {
				while(rs.next()) {
					list.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getInt("price")));
				}
			}
        } finally {
        	closeAll(conn, ps, rs);
        }
        return list;
    }

    @Override
    public void discountBook(int per, String publish) throws SQLException {
    	Connection conn = null;
        PreparedStatement ps = null;
        try {
        	conn = getConnect();
        	String query = "UPDATE book SET price=price*((100-?)/100) WHERE publisher=?";
        	ps = conn.prepareStatement(query);
        	ps.setInt(1, per);
        	ps.setString(2, publish);
        	int row = ps.executeUpdate();
        	System.out.println(row+"row Book Price Update Success!");
        } finally {
        	closeAll(conn, ps);
        }
    }

    @Override
    public ArrayList<Book> findAllBook() throws SQLException {
    	Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Book> list = new ArrayList<>();
        try {
        	conn = getConnect();
        	String query = "SELECT * FROM book";
        	ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getInt("price")));
			}
        } finally {
        	closeAll(conn, ps, rs);
        }
        return list;
    }
}