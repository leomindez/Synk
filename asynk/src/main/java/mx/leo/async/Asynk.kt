package mx.leo.async

import android.os.AsyncTask

/**
 * @author Leonel Méndez
 * Simple class to wrap AsyncTask class by using lambdas as callbacks
 */

open class Asynk<Result>(private var createTask: (param: String?) -> Result, private var success: (result: Result) -> Unit, private  var error: () -> Unit, private  var preExecute: () -> Unit = {}, private var loading: (progress: Int?) -> Unit = {}, private var cancel: (result: Result?) -> Unit = {}) : AsyncTask<String, Int, Result>() {

    final override fun onProgressUpdate(vararg values: Int?) = loading(values[0]);

    final override fun doInBackground(vararg params: String?): Result? = createTask(params[0])

    final override fun onCancelled(result: Result) {
        cancel(result)
    }

    final override fun onPostExecute(result: Result?) {
        if (!isCancelled)
            if (result != null)
                success(result)
            else
                error
        else
            cancel(result)
    }

   final override fun onPreExecute() {
        preExecute
    }

}