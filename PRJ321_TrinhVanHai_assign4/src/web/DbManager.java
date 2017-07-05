package web;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {

    Connection con ;
    public DbManager(){
    }
    
    public int Register(User user) {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/datablog?useSSL=true","root","1101");

            PreparedStatement sql = con.prepareStatement("INSERT INTO Users(Username,Password) VALUES(?,?)");
            sql.setString(1, user.Username);
            sql.setString(2, user.Password);
            
            sql.execute();
            
            return 1;
        }catch(Exception ex){
           return 0;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
              }
        }
    }

    public int Login(String username, String password) {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/datablog?useSSL=true","root","1101");

            PreparedStatement sql = con.prepareStatement("SELECT COUNT(*) as Count FROM Users WHERE Username=? AND Password=?");
            sql.setString(1, username);
            sql.setString(2, password);
            
            ResultSet res=  sql.executeQuery();
            res.next();
            
            return res.getInt(1);
        }catch(Exception ex){
           return 0;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
              }
        }
    }
   
    public int InsertPost(Post post) {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/datablog?useSSL=true","root","1101");

            PreparedStatement sql = con.prepareStatement("INSERT INTO Posts(PostTitle,PostContent,PostDescription,PublishDate,PostAuthor) VALUES(?,?,?,?,?)");
            sql.setString(1, post.PostTitle);
            sql.setString(2, post.PostContent);
            sql.setString(3, post.PostDescription);
            sql.setString(4, post.PublishDate);
            sql.setString(5, post.PostAuthor);
            sql.execute();
            
            return 1;
        }catch(Exception ex){
           return 0;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
              }
        }
    }
    
//    public List<Post> GetAllPosts() {
//        try {
//        	Class.forName("com.mysql.jdbc.Driver");
//            con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/datablog?useSSL=true","root","1101");
//
//            Post post;
//            List<Post>  posts = new ArrayList<Post>();
//            PreparedStatement sql = con.prepareStatement("SELECT * FROM Posts");
//            
//            ResultSet res = sql.executeQuery();
//           while( res.next()){
//            post = new Post();
//            post.ID = res.getInt(1);
//            post.PostTitle = res.getString(2);
//            post.PostContent = res.getString(3);
//            post.PostDescription = res.getString(4);
//            post.PublishDate = res.getString(5);
//            post.PostAuthor = res.getString(6);
//            posts.add(post);
//           }
//            return posts;
//        }catch(Exception ex){
//           return null;
//        }finally{
//            try {
//                con.close();
//            } catch (SQLException ex) {
//              }
//        }
//    }
    
    public ArrayList<Post> GetPostByNav(int fist, int last){
    	  try {
    		  Class.forName("com.mysql.jdbc.Driver");
    	      con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/datablog?useSSL=true","root","1101");
    	       
    	      PreparedStatement sql = con.prepareStatement("SELECT * FROM Posts order by ID DESC limit ?,?");
    	      sql.setInt(1, fist);
    	      sql.setInt(2, last);
              
              ResultSet res = sql.executeQuery();
    	      
    	      ArrayList<Post> p=new ArrayList<>();
    	      Post post;
    	      while( res.next()){
    	            post = new Post();
    	            post.ID = res.getInt(1);
    	            post.PostTitle = res.getString(2);
    	            post.PostContent = res.getString(3);
    	            post.PostDescription = res.getString(4);
    	            post.PublishDate = res.getString(5);
    	            post.PostAuthor = res.getString(6);
    	            p.add(post);
    	           }
    	      return p;
    	  }catch(Exception ex){
              return null;
          }finally{
              try {
                  con.close();
              } catch (SQLException ex) {
                }
          }
    }
    
    public int GetPosts() {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/datablog?useSSL=true","root","1101");

            PreparedStatement sql = con.prepareStatement("SELECT COUNT(*) as Count FROM Posts");
            
            ResultSet res = sql.executeQuery();
            int count =0;
           while( res.next()){
             count = res.getInt("Count");
           }
           return count;
            
        }catch(Exception ex){
           return 0;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
              }
        }
    }
    
    public Post GetPost(int ID) {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/datablog?useSSL=true","root","1101");

            Post post = new Post();
             
            PreparedStatement sql = con.prepareStatement("SELECT * FROM Posts WHERE ID=?");
            sql.setInt(1, ID);

            ResultSet res = sql.executeQuery();
            res.next();
            
            post.ID = res.getInt(1);
            post.PostTitle = res.getString(2);
            post.PostContent = res.getString(3);
            post.PostDescription = res.getString(4);
            post.PublishDate = res.getString(5);
            post.PostAuthor = res.getString(6);
            
            return post;
        }catch(Exception ex){
           return null;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
              }
        }
    }
    
    public int EditPost(int id1,Post post) {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/datablog?useSSL=true","root","1101");
             
            PreparedStatement sql = con.prepareStatement("UPDATE Posts SET PostTitle=?,PostDescription=?,PostContent=? WHERE ID=?");
            
            sql.setString(1, post.PostTitle);
            sql.setString(2, post.PostDescription);
            sql.setString(3, post.PostContent);
            sql.setInt(4, id1);

            return sql.executeUpdate();
        }catch(Exception ex){
           return 0;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
              }
        }
   }
	

}