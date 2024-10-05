package labs.yprsty.mobile.core.analytics

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform