package com.hfad.myapplication

import org.jetbrains.annotations.TestOnly

object NetworkClient {
    var requestCount: Int = 0
    fun sendNetworkRequest(): String {
        requestCount++
        return "Request #$requestCount"
    }
}

fun main() {
    val instance1 = NetworkClient
    instance1.requestCount++
    val instance2 = NetworkClient
    assert(instance2.requestCount == 1)
    instance2.requestCount += 2
    assert(instance1.requestCount == 3)
}