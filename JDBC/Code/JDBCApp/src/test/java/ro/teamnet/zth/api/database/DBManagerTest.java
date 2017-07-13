package ro.teamnet.zth.api.database;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.sql.Connection;

/**
 * Created by Alexandra.Soare on 7/13/2017.
 */
public class DBManagerTest {

    @Test
    public void testGetConnection() {
        Connection c = null;
        c = DBManager.getConnection();
        assertFalse(c == null);
    }

    @Test
    public void testCheckConnection() {
        Boolean b = DBManager.checkConnection(DBManager.getConnection());
        assertEquals(b, true);
    }
}
