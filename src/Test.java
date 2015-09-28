import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Vector;

import com.lms.zx.entity.Product;
import com.lms.zx.entity.User;
import com.lms.zx.util.DBConnection;


public class Test {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		String date = "2012-3-12";
		System.out.println(date);
		try {
			int[] arr = {7369 ,7902,7499,7521,7566};
			con = DBConnection.getConnection();
			ps = con.prepareStatement("update emp set sal=500 where empno=?");
			for(int i=0;i<arr.length;i++) {
				
				ps.setInt(1, arr[i]);
				ps.addBatch();
				//ps.executeUpdate();
			}
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.close(con, ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/*User u = new User();
		if(u.getName() == null) 
			System.out.println(false);
		else
			System.out.println(true);*/
	}
}
