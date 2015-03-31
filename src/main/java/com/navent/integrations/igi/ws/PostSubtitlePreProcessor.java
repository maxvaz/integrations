package com.navent.integrations.igi.ws;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.dridco.inmuebles.ws.g7.model.Aviso;
import com.navent.integrations.igi.ws.security.ProviderPost;

/**
 *
 * @author rrodriguez
 *
 *         Esta clase elimina patrones de texto que podrian ser URLs, EMAILs o telefonos del subtitulo, solo para Tique
 *
 */
@Component
public class PostSubtitlePreProcessor {

    private final static String PATTERNS[] = { "\\(?[0-9]{2,3}?\\)?[ ]?[. -:]?[ ]?[0-9]{4}[. -:]?[0-9]{4}",
        "[0-9]{4}[ ]?[. -:]?[ ]?[0-9]{4}", "(?i)www.", "(?i).com.br", "(?i)http:\\/\\/", "@",
        "(?i)ponto com ponto br", "(?i)arroba", "(?i)nextel", "(?i)\\.com" };

    private final Pattern[] patterns;

    public PostSubtitlePreProcessor() {
        this.patterns = new Pattern[PATTERNS.length];
        int idx = 0;
        for (String stringPattern : PATTERNS) {
            this.patterns[idx++] = Pattern.compile(stringPattern);
        }
    }

    public void preProcess(Aviso aviso, Long postProviderId) {
        if (ProviderPost.TIQUE_IMOVEIS_PROVIDER_ID.equals(postProviderId)) {
            aviso.setSubtitulo(stripPatterns(aviso.getSubtitulo()));
        }
    }

    private String stripPatterns(String subtitle) {
        String result = subtitle;
        for (Pattern pattern : this.patterns) {
            result = pattern.matcher(result).replaceAll("");
        }
        return result;
    }

}
