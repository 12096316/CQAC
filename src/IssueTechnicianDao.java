import java.sql.*;
public class IssueTechnicianDao {
	
public static boolean checkTechnician(String id){
	boolean status=false;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from technician where id=?");
		ps.setString(1,id);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static boolean checkInstallment(int id){
	boolean status=false;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from installation where id=?");
		ps.setInt(1,id);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static int save(String id,int installmentID,String installmentName,String installmentContact){
	int status=0;
	try{
		Connection con=DB.getConnection();
		
		status=updateTechnician(id);//updating installment and issue
		
		if(status>0){
		PreparedStatement ps=con.prepareStatement("insert into issuetechnician(technicianID,installmentID,installmentName,installmentContact) values(?,?,?,?)");
		ps.setString(1,id);
		ps.setInt(2,installmentID);
		ps.setString(3,installmentName);
		ps.setString(4,installmentContact);
		status=ps.executeUpdate();
		}
		
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int updateTechnician(String id){
	int status=0;
	int issued=0;
	try{
		Connection con=DB.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select issued from technician where id=?");
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			issued=rs.getInt("issued");
		}
		
		if(issued == 0){
		PreparedStatement ps2=con.prepareStatement("update technician set issued=? where id=?");
		ps2.setInt(1,issued);
		ps2.setString(2,id);
		
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
