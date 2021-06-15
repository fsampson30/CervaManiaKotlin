package br.com.cervamania.cervamania.Model;

import br.com.cervamania.cervamania.R;

public class NomesPaisesCervejas {

    public int retornaNomesEstilosCervejas(String codigo) {
        switch (codigo) {
            case "0001": {
                return R.string.txtAlemanha;
            }
            case "0002": {
                return R.string.txtArgentina;
            }
            case "0003": {
                return R.string.txtAustralia;
            }
            case "0004": {
                return R.string.txtAustria;
            }
            case "0005": {
                return R.string.txtBelgica;
            }
            case "0006": {
                return R.string.txtBrasil;
            }
            case "0007": {
                return R.string.txtDinamarca;
            }
            case "0008": {
                return R.string.txtEspanha;
            }
            case "0009": {
                return R.string.txtEstadosUnidos;
            }
            case "0010": {
                return R.string.txtHolanda;
            }
            case "0011": {
                return R.string.txtInglaterra;
            }
            case "0012": {
                return R.string.txtIrlanda;
            }
            case "0013": {
                return R.string.txtItalia;
            }
            case "0014": {
                return R.string.txtJamaica;
            }
            case "0015": {
                return R.string.txtLibano;
            }
            case "0016": {
                return R.string.txtMexico;
            }
            case "0017": {
                return R.string.txtNovaZelandia;
            }
            case "0018": {
                return R.string.txtPortugal;
            }
            case "0019": {
                return R.string.txtRepublicaTcheca;
            }
            case "0020": {
                return R.string.txtUruguai;
            }
            default:
                return R.string.txtNaoEncontrado;
        }
    }

}
