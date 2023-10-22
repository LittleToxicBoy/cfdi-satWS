package com.main

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import cfdi.satws.complements.{Complements, ComplementsImpl}
import cfdi.satws.descargaCDFI.{CfdiRecuperacion, CfdiRecuperacionImpl}
import cfdi.satws.messages.{MessagesImpl, MessagesSAT}
import com.google.inject.AbstractModule

import scala.concurrent.ExecutionContext
import net.codingwell.scalaguice.ScalaModule

import javax.inject.Singleton

class AppModuleGuice extends AbstractModule with ScalaModule {
  override def configure(): Unit = {
    bind[CfdiRecuperacion].to[CfdiRecuperacionImpl].in(classOf[Singleton])
    bind[MessagesSAT].to[MessagesImpl].in(classOf[Singleton])
    bind[Complements].to[ComplementsImpl].in(classOf[Singleton])
  }
}
