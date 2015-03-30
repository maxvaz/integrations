package com.dridco.inmuebles.ws.g7.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author pfenoglio
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlType(name = "", propOrder = { "idAvisoProveedor", "idAviso", "expositionMethodType", "subtitulo", "tipoPropiedad",
        "tipoOperacion", "tipoMoneda", "precio", "descripcion", "urlVideo", "condicionesPago", "requisitosPago",
        "financiacion", "ubicacion", "contacto", "urlImagenes", "especificaciones", "medidas",
        "periodosAlquilerTemporal", "pais", "postLabel" })
@XmlRootElement(name = "aviso", namespace = "http://service.g7.ws.inmuebles.dridco.com/")
public class Aviso extends IgiRealEstatePost {

    private static final long serialVersionUID = 2L;

    // ///////////////////////////////////
    // IgiRealEstatePost properties START
    // ///////////////////////////////////

    @XmlElement(required = false, type = String.class, nillable = false)
    private String idAvisoProveedor;
    @XmlElement(required = false, type = Long.class, nillable = false)
    private Long idAviso;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String tipoPropiedad;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String descripcion;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String condicionesPago;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String requisitosPago;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String financiacion;
    @XmlElement(required = true, type = Ubicacion.class, nillable = false)
    private Ubicacion ubicacion;
    @XmlElement(required = true, type = Contacto.class, nillable = false)
    private Contacto contacto;
    @XmlElement(required = false, type = String.class, nillable = false)
    private List<String> urlImagenes;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String pais;
    @XmlElement(required = false, type = Long.class, nillable = false)
    private Long postLabel;
    // ///////////////////////////////////
    // IgiRealEstatePost properties END
    // ///////////////////////////////////

    @XmlElement(required = true, type = String.class, nillable = false)
    private String tipoOperacion;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String subtitulo;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String tipoMoneda;
    @XmlElement(required = false, type = Long.class, nillable = false)
    private Long precio;
    @XmlElement(required = false, type = Medida.class, nillable = false)
    private List<Medida> medidas;
    @XmlElement(required = false, type = PeriodoAlquilerTemporal.class, nillable = false)
    private List<PeriodoAlquilerTemporal> periodosAlquilerTemporal;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String urlVideo;
    @XmlElement(required = false, type = Especificacion.class, nillable = false)
    private List<Especificacion> especificaciones;
    @XmlElement(required = false, type = Long.class, nillable = false)
    private Long expositionMethodType;

    public Aviso() {
        this.urlImagenes = new ArrayList<>();

        this.especificaciones = new ArrayList<>();
        this.medidas = new ArrayList<>();
    }

    @Override
    public String getIdAvisoProveedor() {
        return this.idAvisoProveedor;
    }

    @Override
    public void setIdAvisoProveedor(String idAvisoProveedor) {
        this.idAvisoProveedor = idAvisoProveedor;
    }

    public String getCondicionesPago() {
        return this.condicionesPago;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getFinanciacion() {
        return this.financiacion;
    }

    @Override
    public Long getIdAviso() {
        return this.idAviso;
    }

    public String getRequisitosPago() {
        return this.requisitosPago;
    }

    @Override
    public String getTipoPropiedad() {
        return this.tipoPropiedad;
    }

    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }

    @Override
    public List<String> getUrlImagenes() {
        return this.urlImagenes;
    }

    public void setCondicionesPago(String condicionesPago) {
        this.condicionesPago = condicionesPago;
    }

    public Contacto getContacto() {
        return this.contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFinanciacion(String financiacion) {
        this.financiacion = financiacion;
    }

    @Override
    public void setIdAviso(Long idAviso) {
        this.idAviso = idAviso;
    }

    public void setRequisitosPago(String requisitosPago) {
        this.requisitosPago = requisitosPago;
    }

    @Override
    public void setTipoPropiedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public void setUrlImagenes(List<String> urlImagenes) {
        this.urlImagenes = urlImagenes;
    }

    @Override
    public String getPais() {
        return this.pais;
    }

    @Override
    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getPrecio() {
        return this.precio;
    }

    public String getSubtitulo() {
        return this.subtitulo;
    }

    public String getTipoMoneda() {
        return this.tipoMoneda;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public List<Medida> getMedidas() {
        return this.medidas;
    }

    public void setMedidas(List<Medida> medidas) {
        this.medidas = medidas;
    }

    public List<PeriodoAlquilerTemporal> getPeriodosAlquilerTemporal() {
        return this.periodosAlquilerTemporal;
    }

    public void setPeriodosAlquilerTemporal(List<PeriodoAlquilerTemporal> periodosAlquilerTemporal) {
        this.periodosAlquilerTemporal = periodosAlquilerTemporal;
    }

    public String getTipoOperacion() {
        return this.tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getUrlVideo() {
        return this.urlVideo;
    }

    public List<Especificacion> getEspecificaciones() {
        return this.especificaciones;
    }

    public void addEspecificacion(Especificacion esp) {
        this.especificaciones.add(esp);
    }

    public void setEspecificaciones(List<Especificacion> especificaciones) {
        this.especificaciones = especificaciones;
    }

    @Override
    public IgiLocation getIgiLocation() {
        return getUbicacion();
    }

    @Override
    public IgiContact getIgiContact() {
        return getContacto();
    }

    public void setNormalizedDescription(String description) {
        if (description.length() > MAX_DESCRIPTION_LENGTH) {
            setDescripcion(description.substring(0, MAX_DESCRIPTION_LENGTH));
        } else {
            setDescripcion(description);
        }
    }

    @Override
    public List<String> getIgiAdditionalContactEmails() {
        return getContacto().getEmailAdicionales();
    }

    @Override
    public Long getExpositionMethodType() {
        return this.expositionMethodType;
    }

    public void setExpositionMethodType(Long expositionMethodType) {
        this.expositionMethodType = expositionMethodType;
    }

    @Override
    public Long getPostLabel() {
        return this.postLabel;
    }

    public void setPostLabel(Long postLabel) {
        this.postLabel = postLabel;
    }
}
