package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alexandra.Soare on 7/13/2017.
 */
public class EntityManagerImplTest {

    @Test
    public void testFindById() {
        EntityManagerImpl entityManager = new EntityManagerImpl();
        Department department = entityManager.findById(Department.class, 10L);
        assertEquals((Object) department.getId(),10L);
        assertEquals((Object) department.getDepartmentName(),"Administration");
        assertEquals((Object) department.getLocation(),1700L);
    }

    @Test
    public void testGetNextIdVal() {
        EntityManagerImpl entityManager = new EntityManagerImpl();
        Long val = entityManager.getNextIdVal("departments", "department_id");
        assertEquals((Object) val, 271L);
    }

    @Test
    public void testInsert() {
        EntityManagerImpl entityManager = new EntityManagerImpl();
        Department dept = new Department();
        dept.setDepartmentName("IT");
        dept.setLocation(1700L);
        Department department = (Department) entityManager.insert(dept);
        assertEquals((Object)department.getId(), 273L);
        assertEquals((Object)department.getDepartmentName(), "IT");
        assertEquals((Object)department.getLocation(), 1700L);
    }

    @Test
    public void testFindAll() {
        EntityManagerImpl entityManager = new EntityManagerImpl();
        List<Department> list = entityManager.findAll(Department.class);
        assertEquals(list.size(), 30L);
    }
}
