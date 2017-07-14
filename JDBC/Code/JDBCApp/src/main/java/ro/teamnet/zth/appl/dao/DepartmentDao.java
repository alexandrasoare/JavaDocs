package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;

import java.util.List;
import java.util.Map;

/**
 * Created by Alexandra.Soare on 7/14/2017.
 */
public class DepartmentDao {
    EntityManagerImpl entityManager = new EntityManagerImpl();

    public Department findById(Long id) {
        return entityManager.findById(Department.class, id);
    }

    public Long getNextIdVal(String tableName, String columnIdName) {
        return entityManager.getNextIdVal(tableName, columnIdName);
    }

    public Department insert(Department entity) {
        return (Department) entityManager.insert(entity);
    }

    public List<Department> findAll() {
        return entityManager.findAll(Department.class);
    }

    public Department update(Department entity) {
        return entityManager.update(entity);
    }

    public void delete(Department entity) {
        entityManager.delete(entity);
    }

    public List<Department> findByParams(Map<String, Object> params) {
        return entityManager.findByParams(Department.class, params);
    }
}
