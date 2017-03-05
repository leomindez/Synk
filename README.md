# Asynk
Simple library to wrap an Async Task android class. 
Asynk uses lambdas to wrap async task callbacks. 
It includes, createTask, success, error callbacks


# Usage 
### Added Asynk class into your project then use it

``` 
Asynk<String>(createTask = { it -> "message $it" },
                success = { it -> Toast.makeText(this,it,Toast.LENGTH_LONG).show()},
                error = {Toast.makeText(this,"Something was wrong",Toast.LENGTH_LONG).show()})
                .execute("Hello Asynk")
```
