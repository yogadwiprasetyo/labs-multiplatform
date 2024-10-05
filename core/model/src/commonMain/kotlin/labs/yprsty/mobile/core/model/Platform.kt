package labs.yprsty.mobile.core.model

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform