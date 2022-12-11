package com.arslanka.weblab2.utils

import com.arslanka.weblab2.exceptions.JsonDeserializationException
import com.arslanka.weblab2.exceptions.JsonSerializationException
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.InputStream

class Jackson(private val objectMapper: ObjectMapper) {

    fun <T> readValue(objClass: Class<T>, stream: InputStream): T =
        try {
            objectMapper.readValue(stream, objClass)
        } catch (ex: Exception) {
            throw JsonDeserializationException(message = ex.message)
        }

    fun <T> readValue(objClass: Class<T>, string: String): T =
        try {
            objectMapper.readValue(string, objClass)
        } catch (ex: Exception) {
            throw JsonDeserializationException(message = ex.message)
        }


    fun <T> writeAsString(obj: T): String =
        try {
            objectMapper.writeValueAsString(obj)
        } catch (ex: Exception) {
            throw JsonSerializationException(message = ex.message)
        }
}