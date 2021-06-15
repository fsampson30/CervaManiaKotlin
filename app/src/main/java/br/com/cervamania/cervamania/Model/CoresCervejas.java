package br.com.cervamania.cervamania.Model;

import br.com.cervamania.cervamania.R;

public class CoresCervejas {

    public int retornaCoresCervejasHeaderCard(String codigo) {
        switch (codigo) {
            case "0001": {
                return R.color.colorAmarelo;
            }
            case "0002": {
                return R.color.colorAmbar;
            }
            case "0003": {
                return R.color.colorCobreClaro;
            }
            case "0004": {
                return R.color.colorAmarelhoPalha;
            }
            case "0005": {
                return R.color.colorAmarelo;
            }
            case "0006": {
                return R.color.colorAmbar;
            }
            case "0007": {
                return R.color.colorMarromClaro;
            }
            case "0008": {
                return R.color.colorMarromEscuro;
            }
            case "0009": {
                return R.color.colorPretoOpaco;
            }
            case "0010": {
                return R.color.colorMarromClaro;
            }
            case "0011": {
                return R.color.colorMarromClaro;
            }
            case "0012": {
                return R.color.colorAmbar;
            }
            case "0013": {
                return R.color.colorAmbar;
            }
            case "0014": {
                return R.color.colorAmbar;
            }
            case "0015": {
                return R.color.colorAmarelo;
            }
            case "0016": {
                return R.color.colorMarromClaro;
            }
            case "0017": {
                return R.color.colorAmbar;
            }
            case "0018": {
                return R.color.colorMarromClaro;
            }
            case "0019": {
                return R.color.colorMarrom;
            }
            case "0020": {
                return R.color.colorMarrom;
            }
            case "0021": {
                return R.color.colorDourado;
            }
            case "0022": {
                return R.color.colorMarromEscuro;
            }
            case "0023": {
                return R.color.colorAmarelo;
            }
            case "0024": {
                return R.color.colorMarromClaro;
            }
            case "0025": {
                return R.color.colorDourado;
            }
            case "0026": {
                return R.color.colorCobre;
            }
            case "0027": {
                return R.color.colorMarromClaro;
            }
            case "0028": {
                return R.color.colorAmarelhoPalha;
            }
            case "0029": {
                return R.color.colorPretoOpaco;
            }
            case "0030": {
                return R.color.colorPreto;
            }
            default:
                return R.color.colorFontLight;
        }
    }

    public int retornaCoresHexaDecimal(String codigoCor) {

        switch (codigoCor) {
            case "#F5F360": {
                return R.color.colorAmarelhoPalha;
            }
            case "#ECE523": {
                return R.color.colorAmarelo;
            }
            case "#E8C219": {
                return R.color.colorDourado;
            }
            case "#DE9606": {
                return R.color.colorAmbar;
            }
            case "#CA610E": {
                return R.color.colorCobreClaro;
            }
            case "#8D300E": {
                return R.color.colorCobre;
            }
            case "#8C170D": {
                return R.color.colorMarromClaro;
            }
            case "#6B120E": {
                return R.color.colorMarrom;
            }
            case "#5B100D": {
                return R.color.colorMarromEscuro;
            }
            case "#3E0E0C": {
                return R.color.colorMarromMuitoEscuro;
            }
            case "#1E0B07": {
                return R.color.colorPreto;
            }
            case "#090909": {
                return R.color.colorPretoOpaco;
            }
            default:
                return R.color.colorAmarelhoPalha;
        }
    }

    public int retornaImagemCores(String codigoCor) {

        switch (codigoCor) {
            case "#F5F360": {
                return R.drawable.amarelo_palha;
            }
            case "#ECE523": {
                return R.drawable.amarelo;
            }
            case "#E8C219": {
                return R.drawable.dourado;
            }
            case "#DE9606": {
                return R.drawable.ambar;
            }
            case "#CA610E": {
                return R.drawable.cobreclaro;
            }
            case "#8D300E": {
                return R.drawable.cobre;
            }
            case "#8C170D": {
                return R.drawable.marrom_claro;
            }
            case "#6B120E": {
                return R.drawable.marrom;
            }
            case "#5B100D": {
                return R.drawable.marrom_escuro;
            }
            case "#3E0E0C": {
                return R.drawable.marrom_muito_escuro;
            }
            case "#1E0B07": {
                return R.drawable.preto;
            }
            case "#090909": {
                return R.drawable.preto_opaco;
            }
            default:
                return R.drawable.brasil;
        }
    }

    public int retornaNomesCores(String codigoCor) {

        switch (codigoCor) {
            case "#F5F360": {
                return R.string.txtAmarelhoPalha;
            }
            case "#ECE523": {
                return R.string.txtAmarelo;
            }
            case "#E8C219": {
                return R.string.txtDourado;
            }
            case "#DE9606": {
                return R.string.txtAmbar;
            }
            case "#CA610E": {
                return R.string.txtCobreClaro;
            }
            case "#8D300E": {
                return R.string.txtCobre;
            }
            case "#8C170D": {
                return R.string.txtMarromClaro;
            }
            case "#6B120E": {
                return R.string.txtMarrom;
            }
            case "#5B100D": {
                return R.string.txtMarromEscuro;
            }
            case "#3E0E0C": {
                return R.string.txtMarromMuitoEscuro;
            }
            case "#1E0B07": {
                return R.string.txtPreto;
            }
            case "#090909": {
                return R.string.txtPretoOpaco;
            }
            default:
                return R.drawable.brasil;
        }
    }


}
