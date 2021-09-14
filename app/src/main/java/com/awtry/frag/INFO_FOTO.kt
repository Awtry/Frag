package com.awtry.frag

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize


class INFO_FOTO(
    var img: Int = R.drawable.rojo_y_flores,
    var descripcion: Foto = Foto.PRIMAVERA,
    var sonidito: Sonido = Sonido.SONIDO_JET,
    var Mi_favorito: Boolean = false
): Parcelable {

    companion object{
        val Photos = arrayListOf(
            INFO_FOTO(R.drawable.puesta_de_sol, Foto.PUESTA_SOL, false),
            INFO_FOTO(R.drawable.estrella_primavera, Foto.PRIMAVERA, false),
            INFO_FOTO(R.drawable.resumen_aprox_1, Foto.RESUMEN, false),
            INFO_FOTO(R.drawable.rojo_y_flores, Foto.ROJO_FLOR, false),
            INFO_FOTO(R.drawable.venti, Foto.VENTI, false),

            INFO_FOTO(R.drawable.ic_prim, Foto.LAPISLAZULI, false),
            INFO_FOTO(R.drawable.ic_seg, Foto.RUBI, false),
            INFO_FOTO(R.drawable.ic_terc, Foto.TOPACIO, false),
            INFO_FOTO(R.drawable.ic_cuar, Foto.DIAMANTE, false),
            INFO_FOTO(R.drawable.ic_quin, Foto.PERIDOT, false)

        )
    }

    fun ConteoTotal() = Photos
}