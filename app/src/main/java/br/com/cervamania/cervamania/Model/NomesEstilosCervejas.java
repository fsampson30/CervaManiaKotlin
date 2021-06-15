package br.com.cervamania.cervamania.Model;

import br.com.cervamania.cervamania.R;

public class NomesEstilosCervejas {

    public int retornaNomesEstilosCervejas(String codigo) {
        switch (codigo) {
            case "0001": {
                return R.string.txtStardartAmericanLager;
            }
            case "0002": {
                return R.string.txtAmberLager;
            }
            case "0003": {
                return R.string.txtViennaLager;
            }
            case "0004": {
                return R.string.txtPilsener;
            }
            case "0005": {
                return R.string.txtPremium;
            }
            case "0006": {
                return R.string.txtHelles;
            }
            case "0007": {
                return R.string.txtMunchnerDunkel;
            }
            case "0008": {
                return R.string.txtDarkAmericanLager;
            }
            case "0009": {
                return R.string.txtSchwarzbier;
            }
            case "0010": {
                return R.string.txtBock;
            }
            case "0011": {
                return R.string.txtDoppelbock;
            }
            case "0012": {
                return R.string.txtAmericanPaleAle;
            }
            case "0013": {
                return R.string.txtExtraSpecialBitter;
            }
            case "0014": {
                return R.string.txtBelgianPaleAle;
            }
            case "0015": {
                return R.string.txtBelgianBlondAle;
            }
            case "0016": {
                return R.string.txtBelgianSpecialtyAle;
            }
            case "0017": {
                return R.string.txtIndiaPaleAle;
            }
            case "0018": {
                return R.string.txtRedAle;
            }
            case "0019": {
                return R.string.txtBrownAle;
            }
            case "0020": {
                return R.string.txtDubbel;
            }
            case "0021": {
                return R.string.txtTripel;
            }
            case "0022": {
                return R.string.txtQuadrupel;
            }
            case "0023": {
                return R.string.txtGoldenStrongAle;
            }
            case "0024": {
                return R.string.txtDarkStrongAle;
            }
            case "0025": {
                return R.string.txtWeissbier;
            }
            case "0026": {
                return R.string.txtWeizenbock;
            }
            case "0027": {
                return R.string.txtDunkelweizen;
            }
            case "0028": {
                return R.string.txtWitbier;
            }
            case "0029": {
                return R.string.txtStout;
            }
            case "0030": {
                return R.string.txtPorter;
            }
            default:
                return R.string.txtNaoEncontrado;
        }
    }

}
