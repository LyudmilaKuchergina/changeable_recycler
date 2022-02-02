package com.example.hangeablerecycler

import kotlin.random.Random

object Repository {
    private var listNum = mutableListOf<Int>()
    private var deletedNums = mutableListOf<Int>()
    var lastNum : Int = 0
    init {
        for (i in 1..3) {
            listNum.add(i)
        }
        lastNum = listNum.size+1
    }

    fun getList(): List<Int> {
        return listNum
    }

    fun addNum() {
        var position : Int = 0
        if (deletedNums.count()>0) { // берем добавляемое число из списка удаленных
            if (listNum.count() > 1)
                position = Random.nextInt(0, listNum.count() - 1)
                listNum.add(position, deletedNums.first())
                deletedNums.remove(deletedNums.first())
        } else  // наращиваем добавляемое число
        {
            if (listNum.count() > 0)
                position = Random.nextInt(0, listNum.count() - 1)
            listNum.add(position, lastNum)
            lastNum++
        }
    }

    fun delNum(num: Int){
        listNum.remove(num)
        deletedNums.add(num)
    }
}