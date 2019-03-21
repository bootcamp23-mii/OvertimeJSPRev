/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;

/**
 *
 * @author Pandu
 */
public interface DAOInterface<T> {

    public boolean saveOrDelete(T entity, boolean isSave);

    public List<T> getData(Object keyword);

    public List<T> getByMang(Object keyword);

    public T getById(Object id);

    public List<T> login(Object username);

    public List<T> empOvertime(Object keyword);

    public Long salCount(Object keyword);

    public List<T> history(Object keyword);
}
