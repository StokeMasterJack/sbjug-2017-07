package bj

import kotlin.js.Math.floor
import kotlin.js.Math.random


class Deck {

    private val _cards: MutableList<Card>

    init {
        val a = mutableListOf<Card>()
        for (s in 1..4) {
            for (v in 1..13) {
                a.add(Card(v, s))
            }
        }
        repeat(10000, {
            val i1 = floor(random() * 52)
            val i2 = floor(random() * 52)
            val c1 = a[i1]
            val c2 = a[i2]
            a[i1] = c2
            a[i2] = c1
        })
        _cards = a
    }

    fun take(): Card = _cards.removeAt(0)
    
    val cards: List<Card> = _cards
}