/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Material;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author НР
 */
@Stateful
public class MaterialDaoImplem implements MaterialDAO {

    @PersistenceContext(unitName="LabJPA4-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Material> getAll()throws Exception {
        TypedQuery<Material> namedQuery=em.createNamedQuery("Material.findAll", Material.class);
        return namedQuery.getResultList();
  

    }

    @Override
    public Material selectMaterial(int id_material) {
        return em.find(Material.class, id_material);
    }

    @Override
    public void insertMaterial(Material material) {
        em.persist(material);
        em.flush();
    }

    @Override
    public void updateMaterial(Material material) {
        em.getTransaction().begin();
        em.merge(material);
        em.getTransaction().commit();
    }

    @Override
    public void deleteMaterial(int id) {
        em.remove(em.getReference(Material.class, id));
    }

   /* @Override
    public List<Object> getMaterialOperation(int id) {
        
    }*/
    
}
