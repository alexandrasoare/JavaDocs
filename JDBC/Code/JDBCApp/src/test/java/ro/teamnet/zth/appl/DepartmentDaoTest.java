package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.domain.Department;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alexandra.Soare on 7/14/2017.
 */
public class DepartmentDaoTest {
    @Test
    public void testFindById() {
        DepartmentDao dept = new DepartmentDao();
        Department department = dept.findById(10L);
        assertEquals((Object) department.getId(),10L);
        assertEquals((Object) department.getDepartmentName(),"Administration3");
        assertEquals((Object) department.getLocation(),1700L);
    }

    @Test
    public void testGetNextIdVal() {
        DepartmentDao dept = new DepartmentDao();
        Long val = dept.getNextIdVal("departments", "department_id");
        assertEquals((Object) val, 273L);
    }

    @Test
    public void testInsert() {
        DepartmentDao departmentDao = new DepartmentDao();
        Department dept = new Department();
        dept.setDepartmentName("IT");
        dept.setLocation(1700L);
        Department department = (Department) departmentDao.insert(dept);
        assertEquals((Object)department.getId(), 273L);
        assertEquals((Object)department.getDepartmentName(), "IT");
        assertEquals((Object)department.getLocation(), 1700L);
    }

    @Test
    public void testFindAll() {
        DepartmentDao dept = new DepartmentDao();
        List<Department> list = dept.findAll();
        assertEquals(list.size(), 30L);
    }

    @Test
    public void testUpdate() {
        DepartmentDao dept = new DepartmentDao();
        Department department = new Department();
        department.setId(10L);
        department.setDepartmentName("Administration3");
        department.setLocation(1700L);
        Department d = dept.update(department);
        assertEquals((Object)d.getId(), 10L);
        assertEquals((Object)d.getDepartmentName(), "Administration3");
        assertEquals((Object)d.getLocation(), 1700L);
    }

    @Test
    public void testDelete() {
        DepartmentDao dept = new DepartmentDao();
        Department department = new Department();
        department.setId(273L);
        department.setDepartmentName("IT");
        department.setLocation(1700L);
        dept.delete(department);
    }

    @Test
    public void testFindByParams() {
        DepartmentDao dept = new DepartmentDao();
        Map<String, Object> map = new HashMap<>();
        map.put("location_id", 1700L);
        map.put("department_name", "Administration3");
        List<Department> list = dept.findByParams(map);
        assertEquals(list.size(), 1);
    }
}
