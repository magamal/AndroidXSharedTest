package net.orgiu.weightwatcher.storage

interface Storage<T> {

    fun save(input: List<T>)

    fun fetch() : List<T>
}