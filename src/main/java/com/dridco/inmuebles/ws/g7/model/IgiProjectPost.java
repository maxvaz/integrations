package com.dridco.inmuebles.ws.g7.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlType(name = "", propOrder = { "externalId", "id", "country", "realEstateType", "realEstateSubtype",
        "locationComments", "location", "contact", "name", "slogan", "websiteUrl", "notableAspects", "commercializes",
        "developer", "leadership", "financialManagers", "management", "financing", "additionalComments", "logoUrl",
        "postLabel", "stage", "availability", "deadlineMonth", "deadlineYear", "finishings", "imageUrls", "videoUrls",
        "properties", "multiProperties", "units" })
@XmlRootElement(name = "project", namespace = "http://service.g7.ws.inmuebles.dridco.com/")
public class IgiProjectPost extends IgiRealEstatePost {

    private static final long serialVersionUID = 1L;

    // ///////////////////////////////////
    // IgiRealEstatePost properties START
    // ///////////////////////////////////

    private static final long DESTAQUE_EMPRENDIMIENTO = 2L;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String externalId;
    @XmlElement(required = false, type = Long.class, nillable = false)
    private Long id;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String realEstateType;
    @XmlElement(required = true, type = IgiProjectLocation.class, nillable = false)
    private IgiProjectLocation location;
    @XmlElement(required = true, type = IgiProjectContact.class, nillable = false)
    private IgiProjectContact contact;
    @XmlElement(required = false, type = String.class, nillable = false, name = "image")
    private List<String> imageUrls = new ArrayList<String>();
    @XmlElement(required = false, type = String.class, nillable = false)
    private String country;

    // ///////////////////////////////////
    // IgiRealEstatePost properties END
    // ///////////////////////////////////

    @XmlElement(required = true, type = String.class, nillable = false)
    private String realEstateSubtype;

    @XmlElement(required = false, type = String.class, nillable = false)
    private String financing;

    @XmlElement(required = true, type = String.class, nillable = false)
    private String name;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String slogan;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String notableAspects;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String locationComments;

    @XmlElement(required = true, type = String.class, nillable = false)
    private String commercializes;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String developer;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String leadership;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String financialManagers;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String management;

    @XmlElement(required = false, type = IgiFinishing.class, nillable = false, name = "finishing")
    private List<IgiFinishing> finishings;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String additionalComments;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String logoUrl;

    @XmlElement(required = false, type = String.class, nillable = false, name = "website")
    private String websiteUrl;

    @XmlElement(required = false, type = Integer.class, nillable = false)
    private Integer deadlineMonth;
    @XmlElement(required = false, type = Integer.class, nillable = false)
    private Integer deadlineYear;

    @XmlElement(required = true, type = String.class, nillable = false)
    private String availability;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String stage;

    @XmlElement(required = false, type = Long.class, nillable = false)
    private Long postLabel;

    @XmlElement(required = false, type = String.class, nillable = false, name = "video")
    private List<String> videoUrls = new ArrayList<>();

    @XmlElement(required = false, type = IgiItemSpecificNormalProperty.class, nillable = false, name = "property")
    private List<IgiItemSpecificNormalProperty> properties = new ArrayList<>();

    @XmlElement(required = false, type = IgiItemSpecificMultiPropertyContainer.class, nillable = false, name = "multiProperty")
    private List<IgiItemSpecificMultiPropertyContainer> multiProperties = new ArrayList<>();

    @XmlElement(required = false, type = IgiProjectUnit.class, nillable = false, name = "unit")
    private List<IgiProjectUnit> units;

    @Override
    public String getIdAvisoProveedor() {
        return getExternalId();
    }

    @Override
    public void setIdAvisoProveedor(String idAvisoProveedor) {
        setExternalId(idAvisoProveedor);
    }

    @Override
    public IgiContact getIgiContact() {
        return getContact();
    }

    @Override
    public Long getIdAviso() {
        return getId();
    }

    @Override
    public String getTipoPropiedad() {
        return getRealEstateType();
    }

    @Override
    public List<String> getUrlImagenes() {
        return getImageUrls();
    }

    @Override
    public void setIdAviso(Long idAviso) {
        setId(idAviso);
    }

    @Override
    public void setTipoPropiedad(String tipoPropiedad) {
        setRealEstateType(tipoPropiedad);
    }

    @Override
    public void setUrlImagenes(List<String> urlImagenes) {
        setImageUrls(urlImagenes);
    }

    @Override
    public String getPais() {
        return getCountry();
    }

    @Override
    public void setPais(String pais) {
        setCountry(pais);
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealEstateType() {
        return this.realEstateType;
    }

    public void setRealEstateType(String realEstateType) {
        this.realEstateType = realEstateType;
    }

    public String getLocationComments() {
        return this.locationComments;
    }

    public void setLocationComments(String description) {
        this.locationComments = description;
    }

    public String getFinancing() {
        return this.financing;
    }

    public void setFinancing(String financing) {
        this.financing = financing;
    }

    public IgiProjectLocation getIgiProjectLocation() {
        return this.location;
    }

    public void setIgiProjectLocation(IgiProjectLocation location) {
        this.location = location;
    }

    public IgiProjectContact getContact() {
        return this.contact;
    }

    public void setContact(IgiProjectContact contact) {
        this.contact = contact;
    }

    public List<String> getImageUrls() {
        return this.imageUrls;
    }

    public void setImageUrls(List<String> images) {
        this.imageUrls = images;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String projectName) {
        this.name = projectName;
    }

    public String getSlogan() {
        return this.slogan;
    }

    public void setSlogan(String projectSlogan) {
        this.slogan = projectSlogan;
    }

    public String getNotableAspects() {
        return this.notableAspects;
    }

    public void setNotableAspects(String projectNotableAspects) {
        this.notableAspects = projectNotableAspects;
    }

    public String getCommercializes() {
        return this.commercializes;
    }

    public void setCommercializes(String commercializes) {
        this.commercializes = commercializes;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getLeadership() {
        return this.leadership;
    }

    public void setLeadership(String leadership) {
        this.leadership = leadership;
    }

    public String getFinancialManagers() {
        return this.financialManagers;
    }

    public void setFinancialManagers(String financialManagers) {
        this.financialManagers = financialManagers;
    }

    public String getManagement() {
        return this.management;
    }

    public void setManagement(String management) {
        this.management = management;
    }

    public String getAdditionalComments() {
        return this.additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getDeadlineMonth() {
        return this.deadlineMonth;
    }

    public void setDeadlineMonth(Integer monthDeadline) {
        this.deadlineMonth = monthDeadline;
    }

    public Integer getDeadlineYear() {
        return this.deadlineYear;
    }

    public void setDeadlineYear(Integer yearDeadline) {
        this.deadlineYear = yearDeadline;
    }

    public String getAvailability() {
        return this.availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getStage() {
        return this.stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getRealEstateSubtype() {
        return this.realEstateSubtype;
    }

    public void setRealEstateSubtype(String subtipoPropiedad) {
        this.realEstateSubtype = subtipoPropiedad;
    }

    public List<String> getVideoUrls() {
        return this.videoUrls;
    }

    public void setVideoUrls(List<String> videoUrls) {
        this.videoUrls = videoUrls;
    }

    public List<IgiItemSpecificNormalProperty> getProperties() {
        return this.properties;
    }

    public void setProperties(List<IgiItemSpecificNormalProperty> properties) {
        this.properties = properties;
    }

    public String getWebsiteUrl() {
        return this.websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public List<IgiFinishing> getFinishings() {
        return this.finishings;
    }

    public void setFinishings(List<IgiFinishing> finishings) {
        this.finishings = finishings;
    }

    @Override
    public IgiLocation getIgiLocation() {
        return this.location;
    }

    public List<IgiProjectUnit> getUnits() {
        return this.units;
    }

    public void setUnits(List<IgiProjectUnit> units) {
        this.units = units;
    }

    public List<IgiItemSpecificMultiPropertyContainer> getMultiProperties() {
        return this.multiProperties;
    }

    public void setMultiProperties(List<IgiItemSpecificMultiPropertyContainer> multiProperties) {
        this.multiProperties = multiProperties;
    }

    @Override
    public Long getPostLabel() {
        return this.postLabel;
    }

    public void setPostLabel(Long postLabel) {
        this.postLabel = postLabel;
    }

    @Override
    public List<String> getIgiAdditionalContactEmails() {
        return null;
    }

    @Override
    public Long getExpositionMethodType() {
        return DESTAQUE_EMPRENDIMIENTO;
    }
}
