package br.com.cervamania.cervamania.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log
import br.com.cervamania.cervamania.Model.PaisCerveja
import br.com.cervamania.cervamania.Model.PopulaCerveja
import br.com.cervamania.cervamania.Model.TipoCerveja


private const val SQL_CREATE_TABLE_TIPO_CERVEJA =
    "CREATE TABLE ${TablesStructure.TableTipoCerveja.TABLE_NAME} (" +
            "  ${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "  ${TablesStructure.TableTipoCerveja.COLUMN_CODIGO_TIPO_CERVEJA} TEXT ," +
            "  ${TablesStructure.TableTipoCerveja.COLUMN_NOME_TIPO_CERVEJA} TEXT, " +
            "  ${TablesStructure.TableTipoCerveja.COLUMN_DESCRICAO_TIPO_CERVEJA} TEXT )"

private const val SQL_CREATE_TABLE_PAIS_CERVEJA =
    "CREATE TABLE ${TablesStructure.TablePaisCerveja.TABLE_NAME} (" +
            "  ${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
            "  ${TablesStructure.TablePaisCerveja.COLUMN_CODIGO_PAIS_CERVEJA} TEXT," +
            "  ${TablesStructure.TablePaisCerveja.COLUMN_NOME_PAIS_CERVEJA} TEXT )"

private const val SQL_CREATE_TABLE_CERVEJA =
    "CREATE TABLE ${TablesStructure.TableCerveja.TABLE_NAME} (" +
            "  ${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
            "  ${TablesStructure.TableCerveja.COLUMN_CODIGO_CERVEJA} TEXT," +
            "  ${TablesStructure.TableCerveja.COLUMN_NOME_CERVEJA} TEXT, " +
            "  ${TablesStructure.TableCerveja.COLUMN_DESCRICAO_CERVEJA} TEXT, " +
            "  ${TablesStructure.TableCerveja.COLUMN_CERVEJARIA} TEXT, " +
            "  ${TablesStructure.TableCerveja.COLUMN_CODIGO_TIPO_CERVEJA} TEXT, " +
            "  ${TablesStructure.TableCerveja.COLUMN_TEOR} TEXT, " +
            "  ${TablesStructure.TableCerveja.COLUMN_INGREDIENTES} TEXT, " +
            "  ${TablesStructure.TableCerveja.COLUMN_TEMPERATURA} TEXT, " +
            "  ${TablesStructure.TableCerveja.COLUMN_COR} TEXT, " +
            "  ${TablesStructure.TableCerveja.COLUMN_CODIGO_PAIS_CERVEJA} TEXT)"

private const val SQL_DROP_TABLE_TIPO_CERVEJA = "DROP TABLE IF EXISTS ${TablesStructure.TableTipoCerveja.TABLE_NAME}"
private const val SQL_DROP_TABLE_PAIS_CERVEJA = "DROP TABLE IF EXISTS ${TablesStructure.TablePaisCerveja.TABLE_NAME}"
private const val SQL_DROP_TABLE_CERVEJA =      "DROP TABLE IF EXISTS ${TablesStructure.TableCerveja.TABLE_NAME}"

private const val TAG = "DataBaseHelper"


class DataBaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TABLE_TIPO_CERVEJA)
        db?.execSQL(SQL_CREATE_TABLE_PAIS_CERVEJA)
        db?.execSQL(SQL_CREATE_TABLE_CERVEJA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "cervamania.db"
    }

    fun populateTipoCerveja() {
        if (!selectCountCervejas()){
            val db = this.writableDatabase
            val tipo = TipoCerveja()
            val tipos = tipo.populateTipos()
            var newRows : Long = 0
            for (i in 0 until tipos.size) {
                val values = ContentValues().apply {
                    put(TablesStructure.TableTipoCerveja.COLUMN_CODIGO_TIPO_CERVEJA, tipos[i].codigo_tipo_cerveja)
                    put(TablesStructure.TableTipoCerveja.COLUMN_NOME_TIPO_CERVEJA, tipos[i].nome_tipo_cerveja)
                    put(TablesStructure.TableTipoCerveja.COLUMN_DESCRICAO_TIPO_CERVEJA, tipos[i].descricao_tipo_cerveja)
                }
                newRows = db.insert(TablesStructure.TableTipoCerveja.TABLE_NAME, null, values)
            }
            Log.i(TAG, "Tipos Inseridos: ${newRows.toString()}")
            db.close()
        } else {
            Log.i(TAG, "Tabela já preenchida")
        }
    }

    fun populatePaisCerveja() {
        if (!selectCountCervejas()) {
            val db = this.writableDatabase
            val pais = PaisCerveja()
            val paises = pais.populaPaises()
            var newRows: Long = 0
            for (i in 0 until paises.size) {
                val values = ContentValues().apply {
                    put(TablesStructure.TablePaisCerveja.COLUMN_CODIGO_PAIS_CERVEJA,paises[i].codigo_pais_cerveja)
                    put(TablesStructure.TablePaisCerveja.COLUMN_NOME_PAIS_CERVEJA,paises[i].nome_pais_cerveja)
                }
                newRows = db.insert(TablesStructure.TablePaisCerveja.TABLE_NAME, null, values)
            }
            Log.i(TAG, "Paises Inseridos: ${newRows.toString()}")
            db.close()
        } else {
            Log.i(TAG, "Tabela já preenchida")
        }
    }

    fun populateCerveja(){
        if (!selectCountCervejas()) {
            val db = this.writableDatabase
            val cervejas = PopulaCerveja().retornaCervejas()
            var newRows: Long = 0
            for (i in 0 until cervejas.size) {
                val values = ContentValues().apply {
                    put(TablesStructure.TableCerveja.COLUMN_CODIGO_CERVEJA,cervejas[i].codigo_cerveja)
                    put(TablesStructure.TableCerveja.COLUMN_NOME_CERVEJA, cervejas[i].nome_cerveja)
                    put(TablesStructure.TableCerveja.COLUMN_DESCRICAO_CERVEJA,cervejas[i].descricao_cerveja)
                    put(TablesStructure.TableCerveja.COLUMN_CERVEJARIA, cervejas[i].cervejaria)
                    put(TablesStructure.TableCerveja.COLUMN_CODIGO_TIPO_CERVEJA,cervejas[i].codigo_tipo_cerveja)
                    put(TablesStructure.TableCerveja.COLUMN_TEOR, cervejas[i].teor)
                    put(TablesStructure.TableCerveja.COLUMN_INGREDIENTES, cervejas[i].ingredientes)
                    put(TablesStructure.TableCerveja.COLUMN_TEMPERATURA, cervejas[i].temperatura)
                    put(TablesStructure.TableCerveja.COLUMN_COR, cervejas[i].cor)
                    put(TablesStructure.TableCerveja.COLUMN_CODIGO_PAIS_CERVEJA,cervejas[i].codigo_pais_cerveja)
                }
                newRows = db.insert(TablesStructure.TableCerveja.TABLE_NAME, null, values)
            }
            Log.i(TAG, "Cervejas inseridas: ${newRows.toString()} ")
            db.close()
        } else {
            Log.i(TAG, "Tabela já preenchida")
        }
    }

    fun selectTestsTipo() {
        val db = this.readableDatabase
        val tipos = mutableListOf<TipoCerveja>()
        val cursor = db.query(TablesStructure.TableTipoCerveja.TABLE_NAME,null,null,null,null,null,null )
        with(cursor) {
            while (moveToNext()) {
                val id = cursor.getInt(0)
                val codigo = cursor.getString(1)
                val nome = cursor.getString(2)
                val descricao = cursor.getString(3)
                val tipoAtual = TipoCerveja(id, codigo, nome, descricao)
                Log.i(TAG, "Tipo: ${tipoAtual.showInformation()}")
                tipos.add(tipoAtual)
            }
        }
        cursor.close()
        db.close()
    }

    fun selectTestsPais() {
        val db = this.readableDatabase
        val pais = mutableListOf<PaisCerveja>()
        val cursor = db.query(TablesStructure.TablePaisCerveja.TABLE_NAME,null,null,null,null,null,null )
        with(cursor) {
            while (moveToNext()) {
                val id = cursor.getInt(0)
                val codigo = cursor.getString(1)
                val nome = cursor.getString(2)
                val paisAtual = PaisCerveja(id, codigo, nome)
                Log.i(TAG, "Tipo: ${paisAtual.retornaInformacao()}")
                pais.add(paisAtual)
            }
        }
        cursor.close()
        db.close()
    }

    fun selectCountCervejas() : Boolean{
        val db = this.readableDatabase
        val sql = "SELECT COUNT(*) FROM CERVEJA WHERE CODIGO_CERVEJA = '0001'"
        var number = 0
        val cursor = db.rawQuery(sql,null,null)
        with(cursor){
            while (moveToNext()) {
                number = cursor.getInt(0)
                Log.i(TAG, "Retorno banco de dados ${number.toString()}")
            }
        }
        cursor.close()
        db.close()
        return (number > 0)
    }

    fun selectNomeCerveja(nome: String) : ArrayList<String>{
        val db = this.readableDatabase
        val names = arrayListOf<String>()
        val columns = arrayOf(TablesStructure.TableCerveja.COLUMN_NOME_CERVEJA)
        val condition = "${TablesStructure.TableCerveja.COLUMN_NOME_CERVEJA} LIKE ?"
        Log.i(TAG, "condition:  $condition")
        val parameters = arrayOf("%$nome%")
        Log.i(TAG, "Parameters: ${parameters.get(0)}")
        val cursor = db.query(TablesStructure.TableCerveja.TABLE_NAME,columns,condition,parameters,null,null, null)
        //Log.i(TAG, "Cursor ${cursor.getString(0)}")
        with(cursor){
            while (moveToNext()){
                names.add(cursor.getString(0))
                Log.i(TAG, "Cerveja: ${cursor.getString(0)}")
            }
        }
        return names
    }
}