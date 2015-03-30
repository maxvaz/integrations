package com.dridco.inmuebles.ws.g7.model;

import static com.google.common.base.Throwables.propagate;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ppalazzi
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "adId", "toDate", "fromDate" })
@XmlRootElement(name = "getRealEstateContactsRequest", namespace = "http://service.g7.ws.inmuebles.dridco.com/")
public class GetRealEstateContactsRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    static final int TIME_MEASURE_UNIT_LOWER_BOUND = 0;
    static final int HOUR_OF_DAY_MAX_VALUE = 23;
    static final int MINUTE_MAX_VALUE = 59;
    static final int SECOND_MAX_VALUE = 59;
    static final int MILISECOND_MAX_VALUE = 999;

    @XmlElement(required = false, type = String.class, nillable = false)
    private String adId;
    private final DateFormat requestDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * El formato esperado para la fecha es dd/MM/yyyy (dia/mes/ano)
     */
    @XmlElement(required = false, type = String.class, nillable = false)
    private String toDate;

    /**
     * El formato esperado para la fecha es dd/MM/yyyy (dia/mes/ano)
     */
    @XmlElement(required = false, type = String.class, nillable = false)
    private String fromDate;

    public String getAdId() {
        return this.adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getToDate() {
        return this.toDate;
    }

    public Date getNormalizedToDate() {
        return this.parseToDate(getToDate());
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFromDate() {
        return this.fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public Date getNormalizedFromDate() {
        return this.parseDate(getFromDate());
    }

    private Date parseToDate(String stringToDate) {
        Date toDate = this.parseDate(stringToDate);

        if (toDate != null) {
            toDate = getFirstInstantOfFixedDate(toDate, 1);
        }

        return toDate;
    }

    private Date parseDate(String stringDate) {
        Date finalDate = null;
        if (StringUtils.isNotBlank(stringDate)) {
            finalDate = parse(stringDate);
        }
        return finalDate;
    }

    public Date parse(String dateString) {
        try {
            return this.requestDateFormat.parse(dateString);
        } catch (ParseException e) {
            throw propagate(e);
        }
    }

    /**
     * Devuelve el primer instante de día N a partir de la fecha de hoy Ejemplo: hoy 22/05/2010 + 5 días = 27/05/2010
     * 00:00:00 Ejemplo: hoy 22/05/2010 - 5 días = 22/05/2010 00:00:00
     *
     * @param cantidad
     *            de días a sumar a partir de la fecha especificada
     */
    public static Date getFirstInstantOfFixedDate(final Date fromWhenDate, final int days) {
        Calendar date = Calendar.getInstance();
        date.setTime(fromWhenDate);
        date.add(Calendar.DATE, days);
        date.set(Calendar.HOUR_OF_DAY, TIME_MEASURE_UNIT_LOWER_BOUND);
        date.set(Calendar.MINUTE, TIME_MEASURE_UNIT_LOWER_BOUND);
        date.set(Calendar.SECOND, TIME_MEASURE_UNIT_LOWER_BOUND);
        date.set(Calendar.MILLISECOND, TIME_MEASURE_UNIT_LOWER_BOUND);
        return date.getTime();
    }

}
