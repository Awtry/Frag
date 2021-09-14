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
            INFO_FOTO(R.drawable.puesta_de_sol, Foto.PUESTA_SOL,Sonido.SONIDO_JET, false),
            INFO_FOTO(R.drawable.estrella_primavera, Foto.PRIMAVERA, Sonido.SONIDO_ESPACIAL,false),
            INFO_FOTO(R.drawable.resumen_aprox_1, Foto.RESUMEN,Sonido.SONIDO_ELECTRICO, false),
            INFO_FOTO(R.drawable.rojo_y_flores, Foto.ROJO_FLOR,Sonido.SONIDO_VIEJO, false),
            INFO_FOTO(R.drawable.venti, Foto.VENTI,Sonido.SONIDO_TROMPETA, false),

            INFO_FOTO(R.drawable.ic_prim, Foto.LAPISLAZULI,Sonido.SONIDO_MISTERIO, false),
            INFO_FOTO(R.drawable.ic_seg, Foto.RUBI, Sonido.SONIDO_ROBOT,false),
            INFO_FOTO(R.drawable.ic_terc, Foto.TOPACIO,Sonido.SONIDO_ROCK, false),
            INFO_FOTO(R.drawable.ic_cuar, Foto.DIAMANTE,Sonido.SONIDO_NOKIA, false),
            INFO_FOTO(R.drawable.ic_quin, Foto.PERIDOT,Sonido.SONIDO_CLICK, false)

        )
    }

    fun ConteoTotal() = Photos
}