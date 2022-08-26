package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDAOImpl implements BookDAO{
	// 추가 - 선언
	private DataSource ds; // JNDI(Naming) 서비스로 찾아온다.
		
	// 싱글톤
	private static BookDAOImpl dao = new BookDAOImpl();
	private BookDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource Lookup Success...");
		} catch (NamingException e) {
			System.out.println("DataSource Lookup Fail...");
		}
	}
	public static BookDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("디비연결 성공....");
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}
	
	@Override
	public ArrayList<Book> showAllBook() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Book> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT * FROM book";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement...showAllBook()");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("catalogue"), rs.getString("nation"), rs.getString("publish_date"), rs.getString("publisher"), rs.getString("author"), rs.getInt("price"), rs.getString("description")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	@Override
	public void registerBook(Book vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=  getConnection();
			String query = "INSERT INTO book(isbn, title, catalogue, nation, publish_date, publisher, author, price, description) VALUES(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성됨...registerBook");

			ps.setString(1, vo.getIsbn());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getCatalogue());
			ps.setString(4, vo.getNation());
			ps.setString(5, vo.getPublish_date());
			ps.setString(6, vo.getPublisher());
			ps.setString(7, vo.getAuthor());
			ps.setInt(8, vo.getPrice());
			ps.setString(9, vo.getDescription());
			
			System.out.println(ps.executeUpdate()+" row INSERT!");
		} finally {
			closeAll(ps, conn);
		}
	}
}