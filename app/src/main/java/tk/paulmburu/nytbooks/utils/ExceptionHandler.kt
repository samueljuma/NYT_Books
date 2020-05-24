package tk.paulmburu.moviesreview.utils

import android.content.Context
import tk.paulmburu.nytbooks.R
import java.net.ConnectException
import java.net.UnknownHostException

class ExceptionHandler(val context: Context) {

    fun parse(exception: Exception): String {
        return when (exception) {
            is ConnectException -> context.getString(R.string.no_network_connection)
            is UnknownHostException -> context.getString(R.string.no_network_connection)
            else -> exception.message!!
        }
    }
}