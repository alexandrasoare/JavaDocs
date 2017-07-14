package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Location;

import java.util.List;
import java.util.Map;

/**
 * Created by Alexandra.Soare on 7/14/2017.
 */
public class LocationDao {
    EntityManagerImpl entityManager = new EntityManagerImpl();

    public Location findById(Long id) {
        return entityManager.findById(Location.class, id);
    }

    public Long getNextIdVal(String tableName, String columnIdName) {
        return entityManager.getNextIdVal(tableName, columnIdName);
    }

    public Location insert(Location entity) {
        return (Location) entityManager.insert(entity);
    }

    public List<Location> findAll() {
        return entityManager.findAll(Location.class);
    }

    public Location update(Location entity) {
        return entityManager.update(entity);
    }

    public void delete(Location entity) {
        entityManager.delete(entity);
    }

    public List<Location> findByParams(Map<String, Object> params) {
        return entityManager.findByParams(Location.class, params);
    }
}
