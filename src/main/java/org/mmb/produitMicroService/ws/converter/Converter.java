package org.mmb.produitMicroService.ws.converter;

public interface Converter<Vo, En> {
    public En fromVoToEn(Vo vo);
    public Vo fromEnToVo(En en);
}
