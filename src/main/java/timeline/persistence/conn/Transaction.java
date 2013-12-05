package timeline.persistence.conn;

import java.sql.Connection;

import timeline.persistence.PersistenceException;

public interface Transaction {
    
    public Connection getConnection() throws PersistenceException;
    
    public void begin() throws PersistenceException;

    public void commit() throws PersistenceException;

    public void rollback() throws PersistenceException;
    
}
