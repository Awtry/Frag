package com.awtry.frag

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class Frag_Menu : Fragment(R.layout.fragment_frag__menu) {

    private lateinit var Le_Foto: INFO_FOTO
    private var centinela = 1

    override fun onResume() {
        super.onResume()
        Le_Foto = INFO_FOTO()

        initviews()
        Rotacion_IMG()
        Disparador_Boton()
    }

    //region iniciador

    private lateinit var ViewPrincipal: ConstraintLayout

    private lateinit var btnIZQ: Button
    private lateinit var btnDER: Button
    private lateinit var btnDetalle: Button

    private lateinit var IMG_Principal: ImageView

    private lateinit var mis_imagenes: ArrayList<INFO_FOTO>

    //endregion

    private fun initviews(){

        ViewPrincipal = requireView().findViewById(R.id.Vista_Principal)

        btnIZQ = requireView().findViewById(R.id.btnIZQ)
        btnDER = requireView().findViewById(R.id.btnDER)
        btnDetalle = requireView().findViewById(R.id.btnAl_Detalle)

        IMG_Principal = requireView().findViewById(R.id.IMG_PRINCIPAL)

        //Agregar el conteo de las fotos
       // mis_imagenes = Le_Foto.ConteoTotal()

    }

    private fun Rotacion_IMG(){
        IMG_Principal.setImageResource(mis_imagenes[centinela].img)
    }

    private fun Disparador_Boton(){
        btnDER.setOnClickListener{
            if (centinela == mis_imagenes.size - 1){
                centinela = 0
            }else{
                centinela ++
            }

            Rotacion_IMG()
        }

        btnIZQ.setOnClickListener{
            if (centinela == 0){
                centinela = mis_imagenes.size -1
            }else{
                centinela --
            }
            Rotacion_IMG()
        }

        btnDetalle.setOnClickListener{
            (requireActivity() as MainActivity).replaceFragment(Frag_Detalle().apply {
                arguments = Bundle().apply {
                    //putParcelable("Fotito", ropa[index])
                }

            })
        }


    }

}