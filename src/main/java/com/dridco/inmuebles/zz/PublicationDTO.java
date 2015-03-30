package com.dridco.inmuebles.zz;

public class PublicationDTO {
    private Long idZP;
    private String idIGI;

    public PublicationDTO() {

    }

    public PublicationDTO(Long idZp, String idIGI) {
        this.idZP = idZp;
        this.idIGI = idIGI;
    }

    public Long getIdZP() {
        return this.idZP;
    }

    public void setIdZP(Long idZP) {
        this.idZP = idZP;
    }

    public String getIdIGI() {
        return this.idIGI;
    }

    public void setIdIGI(String idIGI) {
        this.idIGI = idIGI;
    }

}
