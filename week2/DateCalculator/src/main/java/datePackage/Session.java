package datePackage;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class Session {

	private int id;
	ArrayList<Operation> sessionOperationList;



	public ArrayList<Operation> getSessionOperationList() {
		return sessionOperationList;
	}

	public Session(int sessionId) {
		super();
		this.id = sessionId;
	}



	public void setSessionOperationList(ArrayList<Operation> sessionOperationList) {
		this.sessionOperationList = sessionOperationList;
	}

	public void addToDB() {
		String url = "jdbc:postgresql://localhost:5432/calculator";
		String user = "postgres";
		String password = "Abhimanyu180691#";


		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("CONNECTED");

			for (Operation operation : this.sessionOperationList) {
				String sql = "insert into operation "
						+ "(session_id, operation, operation_parameter, operation_date, operation_result, operation_type) "
						+ "values(?, ?, ?, ?, ?, ?)";
				stmt = conn.prepareStatement(sql);
				int sessionId = id;
				String currentOperation = operation.methodType;
				LocalDate localResultDate = operation.output;
				ZoneId defaultZoneId = ZoneId.systemDefault();
				Date operation_result = (Date) Date.from(localResultDate.atStartOfDay(defaultZoneId).toInstant());

				LocalDate localDate = operation.inputDateForOperation;

				Date operation_date = (Date) Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
				int operation_parameter = operation.paramValue;
				String operation_type = operation.methodParameter;

				stmt.setInt(1, id);
				stmt.setString(2, currentOperation);
				stmt.setInt(3, operation_parameter);
				stmt.setDate(4, operation_date);
				stmt.setDate(5, operation_result);
				stmt.setString(6, operation_type);

				stmt.execute();

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
