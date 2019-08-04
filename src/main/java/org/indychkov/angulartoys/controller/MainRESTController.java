package org.indychkov.angulartoys.controller;

import java.util.List;

import org.indychkov.angulartoys.dao.ToyDAO;
import org.indychkov.angulartoys.model.Toy;
import org.indychkov.angulartoys.model.ToyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRESTController {

    @Autowired
    private ToyDAO toyDAO;



    @RequestMapping(value = "/toys", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Toy> getToys() {
        List<Toy> list = toyDAO.getAllToys();
        return list;
    }


    @RequestMapping(value = "/toy/{toyID}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Toy getToy(@PathVariable("toyID") Long toyId) {
        return toyDAO.getToy(toyId);
    }



    @RequestMapping(value = "/toy", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Toy addToy(@RequestBody ToyForm toyForm) {

        System.out.println("(Service Side) Creating toy with toy Name: " + toyForm.getToyName());

        return toyDAO.addToy(toyForm);
    }

    @RequestMapping(value = "/toy", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Toy updateToy(@RequestBody ToyForm toyForm) {

        System.out.println("(Service Side) Editing toy with Id: " + toyForm.getToyID());

        return toyDAO.updateToy(toyForm);
    }


    @RequestMapping(value = "/toy/{toyID}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteToy(@PathVariable("toyID") Long toyId) {

        System.out.println("(Service Side) Deleting toy with Id: " + toyId);

        toyDAO.deleteToy(toyId);
    }

}
