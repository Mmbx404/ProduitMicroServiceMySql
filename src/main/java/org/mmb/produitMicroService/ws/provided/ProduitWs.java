package org.mmb.produitMicroService.ws.provided;

import org.mmb.produitMicroService.entities.Produit;
import org.mmb.produitMicroService.service.CommandeService;
import org.mmb.produitMicroService.service.ProduitService;
import org.mmb.produitMicroService.ws.converter.ProduitConverter;
import org.mmb.produitMicroService.ws.vo.CommandeVo;
import org.mmb.produitMicroService.ws.vo.ProduitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProduitWs {

    private ProduitService produitService;

    private ProduitConverter produitConverter;

    private CommandeService commandeService;

    @Autowired
    public ProduitWs(ProduitService produitService,CommandeService commandeService) {
        this.produitService = produitService;
        this.commandeService = commandeService;
        this.produitConverter = new ProduitConverter();
    }

    @GetMapping("/productwithcommande/ref/{ref}")
    public ProduitVo findProductWithCommande(@PathVariable("ref") String ref) {
        ProduitVo produitVo = produitConverter.fromEnToVo(produitService.findByReference(ref));
        if (produitVo == null) return null;
        if (produitVo.getCommandeVoRef() == null) return produitVo;
        CommandeVo commandeVo = commandeService.findCommandeByRef(produitVo.getCommandeVoRef());
        if (commandeVo != null) produitVo.setCommandeVoRef(commandeVo.getReference());
        return produitVo;
    }

    @GetMapping("/ref/{ref}")
    public ProduitVo findByReference(@PathVariable("ref") String ref) {
        return produitConverter.fromEnToVo(produitService.findByReference(ref));
    }
    @GetMapping("/")
    public List<ProduitVo> findAll() {
        List<ProduitVo> result = new ArrayList<ProduitVo>();
        for (Produit p : produitService.findAll()) {
            result.add(produitConverter.fromEnToVo(p));
        }
        return result;
    }
    @PostMapping("/")
    public Produit save(@RequestBody Produit entity) {
        return produitService.save(entity);
    }
    @GetMapping("/id/{aLong}")
    public ProduitVo findById(@PathVariable("aLong") Long aLong) {
        return produitConverter.fromEnToVo(produitService.findById(aLong));
    }

    @DeleteMapping("/id/{aLong}")
    public void deleteById(@PathVariable("aLong") Long aLong) {
        produitService.deleteById(aLong);
    }

    @GetMapping("/products/commandeRef/{ref}")
    public List<Produit> findByCommandeVoRef(@PathVariable("ref")  String ref) {
        return produitService.findByCommandeVoRef(ref);
    }
}
