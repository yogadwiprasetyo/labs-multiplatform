package labs.yprsty.mobile.core.local_storage

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform