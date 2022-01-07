package org.mmb.produitMicroService.ws.converter;

import org.mmb.produitMicroService.entities.Produit;
import org.mmb.produitMicroService.ws.vo.ProduitVo;

public class ProduitConverter implements Converter<ProduitVo, Produit> {
    @Override
    public Produit fromVoToEn(ProduitVo produitVo) {
        if (produitVo == null || produitVo.getId() == null) return null;
        Produit p = new Produit();
        p.setId(produitVo.getId()==null?null:produitVo.getId());
        p.setReference(produitVo.getReference()==null?null:produitVo.getReference());
        p.setQte(produitVo.getQte()==null?null:Integer.parseInt(produitVo.getQte()));
        p.setPrixUnitaire(produitVo.getPrixUnitaire()==null?null:Double.parseDouble(produitVo.getPrixUnitaire()));
        p.setCommandeVoRef(produitVo.getCommandeVoRef()==null?null:produitVo.getCommandeVoRef());
        return p;
    }

    @Override
    public ProduitVo fromEnToVo(Produit produit) {
        if (produit == null || produit.getId() == null) return null;
        ProduitVo pVo = new ProduitVo();
        pVo.setId(produit.getId());
        pVo.setReference(produit.getReference()==null?null:produit.getReference());
        pVo.setQte(produit.getQte()==null?null:produit.getQte().toString());
        pVo.setPrixUnitaire(produit.getPrixUnitaire()==null?null:produit.getPrixUnitaire().toString());
        pVo.setCommandeVoRef(produit.getCommandeVoRef()==null?null:produit.getCommandeVoRef());
        return pVo;
    }
}
