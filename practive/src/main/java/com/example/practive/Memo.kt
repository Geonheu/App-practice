package com.example.practive

class Memo {
}

interface Instrument {
    fun play()
    val line: Int
    var playtime: Int
    fun showOff() = println("I'm Clicked.")
}

class Wind: Instrument {
    override fun play(){
        playtime++
        println("Wind.play()")
    }

    override val line: Int = 0
    override var playtime: Int = 0
}

fun main(){

}