package nl.dirkgroot.robotworlds.server

fun startServerApplication() = SocketListener(MessageHandler(World())).port
