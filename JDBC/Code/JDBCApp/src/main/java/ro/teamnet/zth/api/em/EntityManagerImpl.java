package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandra.Soare on 7/13/2017.
 */
public class EntityManagerImpl {

    <T> T findById(Class<T> entityClass, Long id) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);
        List<Field> fields = EntityUtils.getFieldsByAnnotations(entityClass, Id.class);

        Condition condition = new Condition();

        for (ColumnInfo column : columns) {
            if (column.isId() == true) {
                condition.setColumnName(column.getDbColumnName());
                condition.setValue(id);
            }
        }

        QueryBuilder qb = new QueryBuilder();
        qb.setQueryType(QueryType.SELECT);
        qb.addQueryColumns(columns);
        qb.setTableName(tableName);
        qb.addCondition(condition);
        String str = qb.createQuery();

        try (Statement  stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(str);
            if (rs.next()) {
                T instance = entityClass.newInstance();
                for (ColumnInfo column : columns) {
                    Field field = instance.getClass().getDeclaredField(column.getColumnName());
                    field.setAccessible(true);
                    field.set(instance, EntityUtils.castFromSqlType(rs.getObject(column.getDbColumnName()), field.getType()));
                }
                return instance;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    Long getNextIdVal(String tableName, String columnIdName) {
        Connection connection = DBManager.getConnection();
        Long val = new Long(0);
        try (Statement  stmt = connection.createStatement( )){
            String query =  "SELECT MAX(" + columnIdName + ") from " + tableName;
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next())
                val = rs.getLong("MAX(" + columnIdName + ")") + 1;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    <T> Object insert(T entity) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());
        Long id = new Long(0);

        for (ColumnInfo column : columns) {
            if (column.isId()) {
                column.setValue(getNextIdVal(tableName, column.getDbColumnName()));
                id = (Long)column.getValue();
            } else {
                try {
                    Field field = entity.getClass().getDeclaredField(column.getColumnName());
                    field.setAccessible(true);
                    column.setValue(field.get(entity));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        QueryBuilder qb = new QueryBuilder();
        qb.setTableName(tableName);
        qb.addQueryColumns(columns);
        qb.setQueryType(QueryType.INSERT);
        String str = qb.createQuery();
        Object object = new Object();

        try (Statement  stmt = connection.createStatement( )){
            ResultSet rs = stmt.executeQuery(str);
            if (rs.next())
                object = findById(entity.getClass(), id);
        }
        catch (SQLException e) {
        }
        return object;
    }

    <T> List<T> findAll(Class<T> entityClass) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);
        List<T> list = new ArrayList<T>();

        QueryBuilder qb = new QueryBuilder();
        qb.setTableName(tableName);
        qb.addQueryColumns(columns);
        qb.setQueryType(QueryType.SELECT);
        String str = qb.createQuery();
        Object object = new Object();

        try (Statement  stmt = connection.createStatement( )){
            ResultSet rs = stmt.executeQuery(str);
            while (rs.next()) {
                T instance = entityClass.newInstance();
                for (ColumnInfo column : columns) {
                    Field field = instance.getClass().getDeclaredField(column.getColumnName());
                    field.setAccessible(true);
                    field.set(instance, EntityUtils.castFromSqlType(rs.getObject(column.getDbColumnName()), field.getType()));
                }
                list.add(instance);
            }
        }
        catch (SQLException e) {
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return list;
    }

}
