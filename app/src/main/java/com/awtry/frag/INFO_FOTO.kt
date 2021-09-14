package com.awtry.frag

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize


class INFO_FOTO(
    var img: Int = R.drawable.rojo_y_flores,
    var descripcion: Fotografia = Fotografia.PRIMAVERA,
    var Mi_favorito: Boolean = false
): Parcelable {

    companion object{
        val Photos = arrayListOf(
            INFO_FOTO(R.drawable.puesta_de_sol, Fotografia.PUESTA_SOL, false),
            INFO_FOTO(R.drawable.estrella_primavera, Fotografia.PRIMAVERA, false),
            INFO_FOTO(R.drawable.resumen_aprox_1, Fotografia.RESUMEN, false),
            INFO_FOTO(R.drawable.rojo_y_flores, Fotografia.ROJO_FLOR, false),
            INFO_FOTO(R.drawable.venti, Fotografia.VENTI, false),

            INFO_FOTO(R.drawable.ic_prim, Fotografia.LAPISLAZULI, false),
            INFO_FOTO(R.drawable.ic_seg, Fotografia.RUBI, false),
            INFO_FOTO(R.drawable.ic_terc, Fotografia.TOPACIO, false),
            INFO_FOTO(R.drawable.ic_cuar, Fotografia.DIAMANTE, false),
            INFO_FOTO(R.drawable.ic_quin, Fotografia.PERIDOT, false)

        )
    }

    fun Es_Favorito(data: Int, Fav: Boolean){
        Photos[data].Mi_favorito = Fav
    }

    fun ConteoTotal() = Photos
}