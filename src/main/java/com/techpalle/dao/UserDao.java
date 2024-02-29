package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techpalle.model.User;

public class UserDao {
	private static String url="jdbc:mysql://localhost:3306/palle";
	private static String dbUser="root";
	private static String dbPass="manager";
	private static String qry="insert into user(name,email,city) values(?,?,?)";
	private static String selQry="select *from user";
	
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static Statement stm=null;
	private static ResultSet rs=null;
	
	public static void insert(User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,dbUser,dbPass);
			
			ps=con.prepareStatement(qry);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCity());
			
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException  e) {
			e.printStackTrace();
		}
		finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps !=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	public static ArrayList<User> display() {
		ArrayList<User> al=new ArrayList<User>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,dbUser,dbPass);
			stm=con.createStatement();
			rs=stm.executeQuery(selQry);
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String city=rs.getString("city");
				User user=new User(id,name,email,city);
				al.add(user);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stm !=null) {
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return al;
		
	}
	
	public static User edit(int id1) {
		User u=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,dbUser,dbPass);
			
			ps=con.prepareStatement("select *from user where id=?");
			
			ps.setInt(1, id1);
			
			rs=ps.executeQuery();
			
			rs.next();
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String email=rs.getString("email");
			String city =rs.getString("city");
			
			u=new User(id,name,email,city);
			
		}catch(ClassNotFoundException | SQLException  e) {
			e.printStackTrace();
		}
		finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps !=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return u;
	}
	
	public static void delete(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,dbUser,dbPass);
			
			ps=con.prepareStatement("delete from user where id=?");
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException  e) {
			e.printStackTrace();
		}
		finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps !=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


	public static void update(User user) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,dbUser,dbPass);
			
			ps=con.prepareStatement("update user set name=?,email=?,city=? where id=?");
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCity());
			ps.setInt(4, user.getId());
			
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException  e) {
			e.printStackTrace();
		}
		finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps !=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
}
