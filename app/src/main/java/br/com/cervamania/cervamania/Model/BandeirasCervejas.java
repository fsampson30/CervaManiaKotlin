package br.com.cervamania.cervamania.Model;

import br.com.cervamania.cervamania.R;

public class BandeirasCervejas {

    public int retornaImagemBandeiraCerveja(String codigoPais){
        switch (codigoPais){
            case "0001":{
                return R.drawable.alemanha;
            }
            case "0002":{
                return R.drawable.argentina;
            }
            case "0003":{
                return R.drawable.australia;
            }
            case "0004":{
                return R.drawable.austria;
            }
            case "0005":{
                return R.drawable.belgica;
            }
            case "0006":{
                return R.drawable.brasil;
            }
            case "0007":{
                return R.drawable.dinamarca;
            }
            case "0008":{
                return R.drawable.espanha;
            }
            case "0009":{
                return R.drawable.estados_unidos;
            }
            case "0010":{
                return R.drawable.holanda;
            }
            case "0011":{
                return R.drawable.inglaterra;
            }
            case "0012":{
                return R.drawable.irlanda;
            }
            case "0013":{
                return R.drawable.italia;
            }
            case "0014":{
                return R.drawable.jamaica;
            }
            case "0015":{
                return R.drawable.libano;
            }
            case "0016":{
                return R.drawable.mexico;
            }
            case "0017":{
                return R.drawable.novazelandia;
            }
            case "0018":{
                return R.drawable.portugal;
            }
            case "0019":{
                return R.drawable.republicacheca;
            }
            case "0020":{
                return R.drawable.uruguai;
            }

            default: return R.drawable.brasil;
        }
    }

}
