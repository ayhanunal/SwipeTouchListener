<h1 align="center"> AndroidCameraX </h1>
<p align="center"> You can control swipe action and touch events on views with SwipeTouchListener </p>

## OnSwipeTouchListener.kt
<p align="center"> After the threshold and velocity definitions are made in the Listener class, the GestureListener class should be extended to an inner class. </p>
<p align="center"> We make calculations under the onFling method to calculate right, left, up and down swipes. </p>


```kotlin
override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
    var result = false
    try {
        val diffY = e2.y - e1.y
        val diffX = e2.x - e1.x
        if (Math.abs(diffX) > Math.abs(diffY)) {
            if (Math.abs(diffX) > SWIPE_THRESHOLD && abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffX > 0) {
                    onSwipeRight()
                } else {
                    onSwipeLeft()
                }
                result = true
            }
        } else if (Math.abs(diffY) > SWIPE_THRESHOLD && abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
            if (diffY > 0) {
                onSwipeBottom()
            } else {
                onSwipeTop()
            }
            result = true
        }
    } catch (exception: Exception) {
        exception.printStackTrace()
    }
    return result
}
```
<p align="center"> In addition, the functions that the listener will override are listed below as open fun. Code blocks that you want to add specifically can be added to the relevant method. </p>

```kotlin
open fun onDoubleTap(){}
open fun onSwipeRight() {}
open fun onSwipeLeft() {}
open fun onSwipeTop() {}
open fun onSwipeBottom() {}
```
<p align="center"> we can simply watch listeners on an imageview. </p>
<p align="center">
  <img src='https://github.com/ayhanunal/SwipeTouchListener/blob/main/source/SwipeTouchListenerApp.gif' width=400 heihgt=500> 
</p>

## MainActivity.kt
<p align="center"> The imageView application is like this. </p>

```kotlin
imageView.setOnTouchListener(object : OnSwipeTouchListener(applicationContext){

    override fun onDoubleTap() {
        Toast.makeText(applicationContext, "Double Tap", Toast.LENGTH_SHORT).show()
        super.onDoubleTap()
    }

    override fun onSwipeBottom() {
        Toast.makeText(applicationContext, "Swipe Bottom", Toast.LENGTH_SHORT).show()
        super.onSwipeBottom()
    }

    override fun onSwipeLeft() {
        Toast.makeText(applicationContext, "Swipe Left", Toast.LENGTH_SHORT).show()
        super.onSwipeLeft()
    }

    override fun onSwipeRight() {
        Toast.makeText(applicationContext, "Swipe Right", Toast.LENGTH_SHORT).show()
        super.onSwipeRight()
    }

    override fun onSwipeTop() {
        Toast.makeText(applicationContext, "Swipe Top", Toast.LENGTH_SHORT).show()
        super.onSwipeTop()
    }

})
```

