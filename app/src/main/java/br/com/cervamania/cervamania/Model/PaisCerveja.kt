package br.com.cervamania.cervamania.Model

data class PaisCerveja(
    var id: Int = 0,
    var codigo_pais_cerveja: String = "",
    var nome_pais_cerveja: String = ""

) {

    fun populaPaises() : MutableList<PaisCerveja>{
        val paises = mutableListOf<PaisCerveja>()

        paises.add( PaisCerveja(0,"0001","Alemanha"))
        paises.add( PaisCerveja(0,"0002","Argentina"))
        paises.add( PaisCerveja(0,"0003","Austrália"))
        paises.add( PaisCerveja(0,"0004","Áustria"))
        paises.add( PaisCerveja(0,"0005","Bélgica"))
        paises.add( PaisCerveja(0,"0006","Brasil"))
        paises.add( PaisCerveja(0,"0007","Dinamarca"))
        paises.add( PaisCerveja(0,"0008","Espanha"))
        paises.add( PaisCerveja(0,"0009","Estados Unidos"))
        paises.add( PaisCerveja(0,"0010","Holanda"))
        paises.add( PaisCerveja(0,"0011","Inglaterra"))
        paises.add( PaisCerveja(0,"0012","Irlanda"))
        paises.add( PaisCerveja(0,"0013","Itália"))
        paises.add( PaisCerveja(0,"0014","Jamaica"))
        paises.add( PaisCerveja(0,"0015","Líbano"))
        paises.add( PaisCerveja(0,"0016","México"))
        paises.add( PaisCerveja(0,"0017","Nova Zelândia"))
        paises.add( PaisCerveja(0,"0018","Portugal"))
        paises.add( PaisCerveja(0,"0019","República Tcheca"))
        paises.add( PaisCerveja(0,"0020","Uruguai"))
        return paises
    }

    fun retornaInformacao() : String{
        return "Pais ID: ${id}, Codigo: ${codigo_pais_cerveja}, Nome: ${nome_pais_cerveja} "
    }
}