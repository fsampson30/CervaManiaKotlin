package br.com.cervamania.cervamania.sqlite

import android.provider.BaseColumns

object TablesStructure {

    object TableTipoCerveja : BaseColumns {
        const val TABLE_NAME = "tipo_cerveja"
        const val COLUMN_CODIGO_TIPO_CERVEJA = "codigo_tipo_cerveja"
        const val COLUMN_NOME_TIPO_CERVEJA = "nome_tipo_cerveja"
        const val COLUMN_DESCRICAO_TIPO_CERVEJA = "descricao_tipo_cerveja"
    }

    object TablePaisCerveja : BaseColumns {
        const val TABLE_NAME = "pais_cerveja"
        const val COLUMN_CODIGO_PAIS_CERVEJA = "codigo_pais_cerveja"
        const val COLUMN_NOME_PAIS_CERVEJA = "nome_pais_cerveja"
    }

    object TableCerveja : BaseColumns {
        const val TABLE_NAME = "cerveja"
        const val COLUMN_CODIGO_CERVEJA = "codigo_cerveja"
        const val COLUMN_NOME_CERVEJA = "nome_cerveja"
        const val COLUMN_DESCRICAO_CERVEJA = "descricao_cerveja"
        const val COLUMN_CERVEJARIA = "cervejaria"
        const val COLUMN_CODIGO_TIPO_CERVEJA = "codigo_tipo_cerveja"
        const val COLUMN_TEOR = "teor"
        const val COLUMN_INGREDIENTES = "ingredientes"
        const val COLUMN_TEMPERATURA = "temperatura"
        const val COLUMN_COR = "cor"
        const val COLUMN_CODIGO_PAIS_CERVEJA = "codigo_pais_cerveja"
    }

}