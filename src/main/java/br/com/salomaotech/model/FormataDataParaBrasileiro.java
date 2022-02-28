package br.com.salomaotech.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataDataParaBrasileiro {

    /**
     * Formata uma data para brasileiro
     *
     * @param dataParametro yyyy-MM-dd
     * @return dd-MM-yyyy
     */
    public static String formatar(String dataParametro) {

        /* formato atual */
        SimpleDateFormat formatoOrigem = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;

        /* excessão */
        try {
            data = formatoOrigem.parse(dataParametro);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /* novo formato */
        SimpleDateFormat formatoDestino = new SimpleDateFormat("dd-MM-yyyy");

        /* retorno */
        return formatoDestino.format(data);

    }
}
