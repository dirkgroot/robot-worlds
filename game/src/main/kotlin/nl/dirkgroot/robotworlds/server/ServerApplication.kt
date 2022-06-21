package nl.dirkgroot.robotworlds.server

fun startServerApplication() = SocketListener(MessageReceiver(World())).port
