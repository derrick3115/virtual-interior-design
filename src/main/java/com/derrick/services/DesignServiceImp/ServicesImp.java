package com.derrick.services.DesignServiceImp;

import com.derrick.model.Desing;
import com.derrick.repository.DesignRepository;
import com.derrick.services.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesImp implements DesignService {
    @Autowired
    DesignRepository designrepo;
    @Override
    public Desing saveDesign(Desing desing) {
        return designrepo.save(desing);
    }

    @Override
    public Desing updateDesign(Desing desing) {
      return designrepo.save(desing);
    }

    @Override
    public Desing findDesign(String id) {

        return designrepo.findById(id).get();
    }

    @Override
    public List<Desing> getAllDesigns() {
        return designrepo.findAll();
    }

    @Override
    public void deleteDesign(String desing) {
        designrepo.deleteById(desing);
    }
}
