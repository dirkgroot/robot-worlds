package nl.dirkgroot.robotworlds

fun startServerApplication() = SocketListener(MessageReceiver(World())).port
