/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Material;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author НР
 */
@Local
public interface MaterialDAO {
    List<Material> getAll()throws Exception;
    Material selectMaterial(int id_material);
    void insertMaterial(Material material);
    void updateMaterial(Material material);
    void deleteMaterial(int id);
    //List<Object> getMaterialOperation(int id);
}
