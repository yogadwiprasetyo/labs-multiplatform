package labs.yprsty.mobile.core.network

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform