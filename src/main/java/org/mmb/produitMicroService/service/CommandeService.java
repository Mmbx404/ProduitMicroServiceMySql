package org.mmb.produitMicroService.service;

import org.mmb.produitMicroService.ws.vo.CommandeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "commandeMicroService", url = "http://localhost:8050/api")
public interface CommandeService {
    @GetMapping("/ref/{ref}")
    public CommandeVo findCommandeByRef(@PathVariable("ref") String ref);
}
