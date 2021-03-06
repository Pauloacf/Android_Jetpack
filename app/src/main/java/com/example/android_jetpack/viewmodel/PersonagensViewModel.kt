package com.example.android_jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_jetpack.model.domain.Personagem
import java.util.*
import kotlin.concurrent.timerTask

class PersonagensViewModel : ViewModel() {
    val personagens = MutableLiveData<List<Personagem>>()

    init {
        val timer = Timer()

        timer.schedule(
            timerTask {
                // Simulando uma requisição na web que leva um tempo para acontecer

                val harryPotter = Personagem("Harry Potter", "https://hp-api.herokuapp.com/images/harry.jpg"
                )
                val hermione = Personagem("Hermione Granger", "https://hp-api.herokuapp.com/images/hermione.jpeg")

                personagens.postValue(listOf(harryPotter, hermione))
            }, 2000
        )
    }
}
