import java.sql.Connection;

Connection connection=dataSource.getConnection(); // (1)

        try(connection){
        connection.setAutoCommit(false); // (2)
        // выполнить несколько SQL-запросов...
        connection.commit(); // (3)

        }catch(SQLException e){
        connection.rollback(); // (4)
        }

        // isolation=TransactionDefinition.ISOLATION_READ_UNCOMMITTED

        connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED); // (1)

// propagation=TransactionDefinition.NESTED

        Savepoint savePoint = connection.setSavepoint(); // (2)
        ...
        connection.rollback(savePoint);