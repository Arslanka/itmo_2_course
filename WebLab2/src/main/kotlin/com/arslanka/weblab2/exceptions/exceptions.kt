package com.arslanka.weblab2.exceptions

class InvalidRequestException(override val message: String? = null) : Exception()

class JsonDeserializationException(override val message: String? = null) : Exception()

class JsonSerializationException(override val message: String? = null) : Exception()

class ForbiddenOperationException(override val message: String? = null) : Exception()
