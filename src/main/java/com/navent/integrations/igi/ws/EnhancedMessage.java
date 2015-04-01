package com.navent.integrations.igi.ws;

import static org.apache.cxf.headers.Header.HEADER_LIST;

import java.util.List;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.message.Message;
import org.w3c.dom.Element;

public class EnhancedMessage {

    private final List<SoapHeader> headers;

    @SuppressWarnings("unchecked")
    public EnhancedMessage(Message message) {
        headers = (List<SoapHeader>) message.get(HEADER_LIST);
    }

    public String getHeader(String... headerNames) {
        for (String headerName : headerNames) {
            String headerValue = this.readHeader(headerName);
            if (headerValue != null) {
                return headerValue;
            }
        }
        return null;
    }

    private String readHeader(String headerName) {
        try {
            for (SoapHeader soapHeader : headers) {
                if (soapHeader.getName().getLocalPart().equals(headerName)) {
                    return ((Element) soapHeader.getObject()).getFirstChild().getTextContent();
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Invalid header" + headerName, e);
        }
    }

}
