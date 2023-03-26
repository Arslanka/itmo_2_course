package com.example.arslanka.weblab4.exceptions

class DuplicateLoginException(val login: String, val code: String = "1") : RuntimeException("User with login $login is already exists")
class IncorrectLoginOrPassword(override val message: String?) : RuntimeException(message)