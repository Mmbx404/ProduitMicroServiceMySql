package org.mmb.produitMicroService.service;

import org.mmb.produitMicroService.dao.ProduitDao;
import org.mmb.produitMicroService.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private ProduitDao produitDao;

    @Autowired
    public ProduitService(ProduitDao produitDao) {
        this.produitDao = produitDao;
    }

    public Produit findByReference(String ref) {
        return produitDao.findByReference(ref);
    }

    public List<Produit> findAll() {
        return produitDao.findAll();
    }

    public Produit save(Produit entity) {
        return produitDao.save(entity);
    }

    public Produit findById(Long aLong) {
        return produitDao.findById(aLong).get();
    }

    public void deleteById(Long aLong) {
        produitDao.deleteById(aLong);
    }

    public List<Produit> findByCommandeVoRef(String ref) {
        return produitDao.findByCommandeVoRef(ref);
    }
}
