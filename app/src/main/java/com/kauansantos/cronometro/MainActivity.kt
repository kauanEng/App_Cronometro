package com.kauansantos.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.kauansantos.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var running = false    //COLOCANDO AQUI SE TORNA VARIAVEL GLOBAL
    var pausar: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iniciar.setOnClickListener {
            IniciarCronometro()   //metodo
        }

        binding.pausar.setOnClickListener {
            PausarCronometro()
        }

        binding.Zerar.setOnClickListener {
            ZerarCronometro()
        }
    }

    private fun IniciarCronometro() {
            if(!running) {
                binding.cronometro.base = SystemClock.elapsedRealtime() - pausar
                binding.cronometro.start()
                running = true
            }
    }

    private fun PausarCronometro() {
        if(running) {
            binding.cronometro.stop()
            pausar = SystemClock.elapsedRealtime() - binding.cronometro.base
            running = false
        }
    }

    private fun ZerarCronometro() {
        binding.cronometro.base = SystemClock.elapsedRealtime()
        pausar = 0
    }
}