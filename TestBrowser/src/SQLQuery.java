import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLQuery
{

	private static boolean		isConnected	= false;
	private static Connection	connection;
	private static Statement	sql;
	private static ResultSet	queryResult;

	public static void startjdbc()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static boolean isConnected()
	{
		return isConnected;
	}

	public static boolean dbconnect(String database_name, String dbHost, String dbPass)
	{
		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://mysql.cs.jmu.edu:3306/" + database_name, dbHost,
					dbPass);
			isConnected = true;
			sql = connection.createStatement();
			System.out.println(database_name + " Connection Established.");
			return true;
		} catch (SQLException e)
		{
			e.printStackTrace();
			isConnected = false;
			return false;
		}
	}

	public static ResultSet executeQuery(String query)
	{
		try
		{
			return queryResult = sql.executeQuery(query);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static int getRowLengthOfQueryResult(ResultSet queryResult)
	{
		int num_rows = -1;
		try
		{
			queryResult.last();
			num_rows = queryResult.getRow();
			queryResult.beforeFirst();

		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return num_rows;
	}

}
