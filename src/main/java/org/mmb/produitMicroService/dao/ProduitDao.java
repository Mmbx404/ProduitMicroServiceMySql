package org.mmb.produitMicroService.dao;

import org.mmb.produitMicroService.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitDao extends JpaRepository<Produit, Long> {
    public Produit findByReference(String ref);
    public List<Produit> findByCommandeVoRef(String ref);
}
