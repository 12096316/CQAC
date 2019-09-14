import java.sql.Connection;
import java.sql.PreparedStatement;

public class InstallmentDao {
public static int save(String technician,String address,String hp,String zones,String outlet, String start, String end){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into installation(technician,address,hp,zones,outlet, start, end) values(?,?,?,?,?,?,?)");
		ps.setString(1,technician);
		ps.setString(2,address);
		ps.setString(3,hp);
		ps.setString(4,zones);
		ps.setString(5,outlet);
                ps.setString(6,start);
		ps.setString(7,end);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
