package mx.leo.asynk

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import mx.leo.async.Asynk

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Asynk<String>(createTask = { it -> "message $it" },
                success = { it -> Toast.makeText(this,it,Toast.LENGTH_LONG).show()},
                error = {Toast.makeText(this,"Something was wrong",Toast.LENGTH_LONG).show()})
                .execute("Hello Asynk")
    }

}
