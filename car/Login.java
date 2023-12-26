package car;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;
public class Login {
	private static final Logger LOGGER = Logger.getLogger(Login.class.getName());
    public static final String ADMIN_ROLE = "admin";
    private static final String ERROR_PREFIX = "An error occurred: ";

	private static boolean flaglogin=false;
	private static boolean flagemail=false;
	private static boolean flagpass=false;
	private static Connection con=null;
	private static PreparedStatement stm=null;
	private static ResultSet rs=null;
    private static boolean isLoginPage=false;
    private static  boolean flagname=false;
    private static boolean flagconfpass=false;
    Installer installer=new Installer();
	public Login() { 
		setIsLoginPage(true);
	}
	public static void checkEmail(String email,String usertype) {
		try {
		 connection();
			String sql="Select email from users where email='" +email+"'and user_type='"+usertype+"' ";
			stm=con.prepareStatement(sql);
			rs=stm.executeQuery();
			setFlagemail(rs.next() ? true : false);
			stm.close();
			rs.close();

		}
		catch(Exception e) {
	        LOGGER.severe(ERROR_PREFIX + e.getMessage());
		}

	}

	public void checkpassword(String email,String pass,String usertype) {

		try {
			connection();
			String sql="Select email from users where email='" +email+"'and password='" +pass+"' and user_type='"+usertype+"' ";
			stm=con.prepareStatement(sql);
			rs=stm.executeQuery();
			setFlagPass(rs.next());

       stm.close();
      rs.close();

		}
		catch(Exception e) {
	        LOGGER.severe(ERROR_PREFIX + e.getMessage());
		}

	}
	public static void connection() throws ClassNotFoundException, SQLException {
		String password = System.getProperty("database.password");
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost/caracc";
		con=DriverManager.getConnection(url,"root",password);
	}
	
	

	

	

	
	public static Boolean getFlaglogin() {
        return flaglogin;
    }

 
    public static void setFlaglogin(Boolean value) {
    	flaglogin = value;
    }
    public static Boolean getFlagemail() {
        return flagemail;
    }

 
    public static void setFlagemail(Boolean value) {
    	flagemail = value;
    }
    public static Boolean getFlagPass() {
        return flagpass;
    }

 
    public static void setFlagPass(Boolean value) {
    	flagpass = value;
    }
    public static Boolean getFlagConfPass() {
        return flagconfpass;
    }

 
    public static void setFlagConfPass(Boolean value) {
    	flagconfpass = value;
    }
    public static Boolean getIsLoginPage() {
        return isLoginPage;
    }

 
    public static void setIsLoginPage(Boolean value) {
    	isLoginPage = value;
    }
    public static Boolean getFlagName() {
        return flagname;
    }

 
    public static void setFlagName(Boolean value) {
    	flagname = value;
    }
	

}