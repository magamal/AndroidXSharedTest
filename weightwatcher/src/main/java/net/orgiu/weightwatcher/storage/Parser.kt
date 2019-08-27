package net.orgiu.weightwatcher.storage

interface Parser <in IN, out OUT> {

    fun map(input : IN) : OUT
}