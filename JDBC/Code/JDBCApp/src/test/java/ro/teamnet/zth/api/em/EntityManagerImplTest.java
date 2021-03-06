package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testUpdate() {
        EntityManagerImpl entityManager = new EntityManagerImpl();
        Department department = new Department();
        department.setId(10L);
        department.setDepartmentName("Administration3");
        department.setLocation(1700L);
        Department d = entityManager.update(department);
        assertEquals((Object)d.getId(), 10L);
        assertEquals((Object)d.getDepartmentName(), "Administration3");
        assertEquals((Object)d.getLocation(), 1700L);
    }

    @Test
    public void testDelete() {
        EntityManagerImpl entityManager = new EntityManagerImpl();
        Department department = new Department();
        department.setId(273L);
        department.setDepartmentName("IT");
        department.setLocation(1700L);
        entityManager.delete(department);
    }

    @Test
    public void testFindByParams() {
        EntityManagerImpl entityManager = new EntityManagerImpl();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("location_id", 1700L);
        map.put("department_name", "Executive");
        List<Department> list = entityManager.findByParams(Department.class, map);
        assertEquals(list.size(), 1);
    }

    @Test
    public void testFindByDept() {
        EntityManagerImpl entityManager = new EntityManagerImpl();
        List<Employee> list = entityManager.findByDepartment("st");
        assertEquals(list.size(), 1);
    }
}
