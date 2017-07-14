package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.appl.dao.LocationDao;
import ro.teamnet.zth.appl.domain.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Alexandra.Soare on 7/14/2017.
 */
public class LocationDaoTest {
    @Test
    public void testFindById() {
        LocationDao loc = new LocationDao();
        Location location = loc.findById(1000L);
        assertEquals((Object) location.getId(),1000L);
        assertEquals((Object) location.getStreetAddress(),"1297 Via Cola di Rie");
        assertEquals((Object) location.getPostalCode(),"00989");
        assertEquals((Object) location.getCity(), "Roma");
    }

    @Test
    public void testGetNextIdVal() {
        LocationDao loc = new LocationDao();
        Long val = loc.getNextIdVal("departments", "department_id");
        assertEquals((Object) val, 273L);
    }

    @Test
    public void testInsert() {
        LocationDao loc = new LocationDao();
        Location location = new Location();
        location.setCity("Bucuresti");
        location.setPostalCode("1111");
        location.setStreetAddress("Bd TV");
        location.setStateProvince("CEVA");
        Location location2 = (Location) loc.insert(location);
        assertEquals((Object)location2.getId(), 3201L);
        assertEquals((Object)location2.getCity(), "Bucuresti");
        assertEquals((Object)location2.getPostalCode(), "1111");
        assertEquals((Object)location2.getStreetAddress(), "Bd TV");
    }

    @Test
    public void testFindAll() {
        LocationDao loc = new LocationDao();
        List<Location> list = loc.findAll();
        assertEquals(list.size(), 23L);
    }

    @Test
    public void testUpdate() {
        LocationDao loc = new LocationDao();
        Location location = new Location();
        location.setId(1000L);
        location.setCity("Bucuresti");
        location.setPostalCode("1111");
        location.setStreetAddress("Bd TV");
        location.setStateProvince("CEVA");
        Location l = loc.update(location);
        assertEquals((Object)l.getId(), 1000L);
        assertEquals((Object)l.getPostalCode(), "1111");
        assertEquals((Object)l.getCity(), "Bucuresti");
        assertEquals((Object)l.getStreetAddress(), "Bd TV");
    }

    @Test
    public void testDelete() {
        LocationDao loc = new LocationDao();
        Location location = new Location();
        location.setId(3201L);
        location.setCity("Bucuresti2");
        location.setPostalCode("1111");
        location.setStreetAddress("Bd TV");
        loc.delete(location);
    }

    @Test
    public void testFindByParams() {
        LocationDao loc = new LocationDao();
        Map<String, Object> map = new HashMap<>();
        map.put("postal_code", "00989");
        map.put("city", "Roma");
        List<Location> list = loc.findByParams(map);
        assertEquals(list.size(), 1);
    }
}
