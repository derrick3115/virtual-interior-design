package com.derrick.services;



import com.derrick.model.Desing;

import java.util.List;

public interface DesignService {
    public Desing saveDesign(Desing desing);
    public Desing updateDesign(Desing desing);
    public Desing findDesign(String id);
    public List<Desing> getAllDesigns();
    public void deleteDesign(String id);
}
