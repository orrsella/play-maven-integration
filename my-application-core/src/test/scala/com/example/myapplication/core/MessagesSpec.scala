package com.example.myapplication.core

import org.specs2.mutable.SpecificationWithJUnit

class MessagesSpec extends SpecificationWithJUnit {

  "Messages" should {
    "return hello world" in {
      Messages.helloWorld must_== "Hello world!"
    }
  }
}