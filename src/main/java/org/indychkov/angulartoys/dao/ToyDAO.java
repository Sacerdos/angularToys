package org.indychkov.angulartoys.dao;
import org.indychkov.angulartoys.model.Toy;
import org.indychkov.angulartoys.model.ToyForm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;
@Repository
public class ToyDAO {
    private static final Map<Long, Toy> toyMap = new HashMap<Long, Toy>();

    static {
        initEmps();
    }

    private static void initEmps() {
        Toy toy1 = new Toy(1L, "E01", "Smith", "Clerk");
        Toy toy2 = new Toy(2L, "E02", "Allen", "Salesman");
        Toy toy3 = new Toy(3L, "E03", "Jones", "Manager");

        toyMap.put(toy1.getToyID(), toy1);
        toyMap.put(toy2.getToyID(), toy2);
        toyMap.put(toy3.getToyID(), toy3);
    }

    public Long getMaxToyId() {
        Set<Long> keys = toyMap.keySet();
        Long max = 0L;
        for (Long key : keys) {
            if (key > max) {
                max = key;
            }
        }
        return max;
    }

    public Toy getToy(Long toyId) {
        return toyMap.get(toyId);
    }

    public Toy addToy(ToyForm toyForm) {
        Long toyId= this.getMaxToyId()+ 1;
        toyForm.setToyID(toyId);
        Toy newEmp = new Toy(toyForm);

        toyMap.put(newEmp.getToyID(), newEmp);
        return newEmp;
    }

    public Toy updateToy(ToyForm empForm) {
        Toy emp = this.getToy(empForm.getToyID());
        if(emp!= null)  {
            emp.setToyName(empForm.getToyName());
            emp.setToySize(empForm.getToySize());
            emp.setToyDescription(empForm.getToyDescription());
        }
        return emp;
    }

    public void deleteToy(Long toyId) {
        toyMap.remove(toyId);
    }

    public List<Toy> getAllToys() {
        Collection<Toy> c = toyMap.values();
        List<Toy> list = new ArrayList<Toy>();
        list.addAll(c);
        return list;
    }
}
