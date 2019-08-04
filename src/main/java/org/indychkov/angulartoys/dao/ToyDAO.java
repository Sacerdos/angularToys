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
        Toy toy1 = new Toy(1L, "Chicco Robochicco", "Middle", "The first tranformable remote control for pre-school kids.");
        Toy toy2 = new Toy(2L, "Disney Princess Petite Princess N Pony Ariel", "Small", "Royal Fun with your Favorite Petite Princess and Pony;Princess and Pony can share their Hair and Accessories");
        Toy toy3 = new Toy(3L, "Real Workin' Buddy Mr. Hosey Super Spray Fire Truck Vehicle Toy", "Middle", "Blast water up to 30 feet! Help mom water the garden or spray your friends! Real Workin Buddies: Mr. Hosey is the farthest water blasting firetruck in the market. Fill Mr. Hosey up with water, pump his bumper to pressurize the tank then spray! There are two ways to use the fire hose; spray with the hose attached to the firetruck or detach the 2 foot hose to free spray.");

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
