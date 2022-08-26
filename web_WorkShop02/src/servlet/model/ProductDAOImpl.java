package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAOImpl implements ProductDAO{
	// 추가 - 선언
	private DataSource ds; // JNDI(Naming) 서비스로 찾아온다.
	
	// 싱글톤
	private static ProductDAOImpl dao = new ProductDAOImpl();
	private ProductDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource Lookup Success...");
		} catch (NamingException e) {
			System.out.println("DataSource Lookup Fail...");
		}
	}
	public static ProductDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("디비연결 성공....");
		return ds.getConnection(); //Connection 하나씩 Pool에서 받아온다..
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
	public void registerProduct(ProductVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "INSERT INTO product VALUES(seq.NEXTVAL, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성됨...registerProduct");
			
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getPrice());
			ps.setString(3, vo.getExpl());
			
			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<ProductVO> showAllProduct() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProductVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT name, price, expl FROM product";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement....showAllProduct()..");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ProductVO(
						rs.getString("name"),
						rs.getString("price"),
						rs.getString("expl")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
//	public ProductVO findSeq() throws SQLException {
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		ProductVO pd = null;
//		try {
//			conn = getConnection();
//			String query = "SELECT seq.CURRVAL, name, price, expl FROM product";
//			ps = conn.prepareStatement(query);
//			System.out.println("PreparedStatement....showSeqNumber()..");
//			
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				pd = new ProductVO(rs.getInt("seq"), rs.getString("name"), rs.getString("price"), rs.getString("expl"));
//			}
//		}finally {
//			closeAll(rs, ps, conn);
//		}
//		return pd;
//	}
}