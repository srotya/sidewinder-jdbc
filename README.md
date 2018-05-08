# Sidewinder-JDBC Driver [Experimental]
Sidewinder now supports JDBC with SQL powered by [Apache Calcite](https://calcite.apache.org/) and JDBC powered by [Avatica Server](https://calcite.apache.org/avatica/). 


## Sidewinder JDBC configuration

### Server Side
Sidewinder JDBC server is disabled by default, it can be enabled and configured using the following properties

|Config         |Description                                            |
|---------------|------------------------------------------------------ |
|jdbc.enabled   |Enable/disable JDBC server. Default: false             |
|jdbc.port      |Port number to run JDBC server on. Default: 1099       |

```
Note: minimum version 0.2.2 is needed for JDBC functionality
```

### Client Side
Sidewinder JDBC driver currently supports standard Avatica JDBC configuration can be found here: [https://calcite.apache.org/avatica/docs/client_reference.html](https://calcite.apache.org/avatica/docs/client_reference.html)

## How to connect?
Simply make the JDBC driver jar in classpath of your client application including applications like Tableau and configure connection using instructions above. 

Sidewinder SQL is purely read-only and can be used only for select type statements, no DDL or DML operations can be executed via JDBC.

```
Note: Currently there is no support for authentication
``` 


## Sample code

```
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class App {
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:avatica:remote:url=http://localhost:1099");
		DatabaseMetaData md = connection.getMetaData();
		ResultSet rs = md.getTables(null, null, "%", null);
		while (rs.next()) {
			System.out.println(rs.getString(2) + "  " + rs.getString(3));
		}
		connection.close();
	}
}
```