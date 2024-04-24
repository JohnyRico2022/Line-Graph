package ru.nikita.linegraph.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import ru.nikita.linegraph.data.DataSource
import ru.nikita.linegraph.utils.AndroidUtils

class CustomView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(
    context,
    attributeSet,
    defStyleAttr,
    defStyleRes
) {

    private val dataFromSource = DataSource().listWithData()
    private val lineWidth = AndroidUtils.dp(context, 5)
    private val dotWidth = AndroidUtils.dp(context, 15)
    private val lineHelperWidth = AndroidUtils.dp(context, 2)
    private val textWidth = AndroidUtils.dp(context, 15)

    private val linePaint = Paint().apply {
        strokeCap = Paint.Cap.ROUND
        strokeWidth = lineWidth.toFloat()
        color = Color.RED
    }

    private val lineHelperPaint = Paint().apply {
        strokeWidth = lineHelperWidth.toFloat()
        color = Color.LTGRAY
    }

    private val paintDot = Paint().apply {
        strokeCap = Paint.Cap.ROUND
        strokeWidth = dotWidth.toFloat()
        color = Color.DKGRAY
    }

    private val paintText = Paint().apply {
        strokeCap = Paint.Cap.ROUND
        strokeWidth = textWidth.toFloat()
        color = Color.DKGRAY
        textSize = 30f
    }

    private fun myText(number: Int): String {  //Для отображения шкалы снизу вверх
        return when (number) {
            100 -> "700"
            200 -> "600"
            300 -> "500"
            400 -> "400"
            500 -> "300"
            600 -> "200"
            700 -> "100"
            else -> "0"
        }
    }

    private fun myTime(time: String): Float {  // перевод часов в значения по оси Y
        return when (time) {
            "12:00" -> 0f
            "12:30" -> 100f
            "13:00" -> 200f
            "13:30" -> 300f
            "14:00" -> 400f
            "14:30" -> 500f
            "15:00" -> 600f
            "15:30" -> 700f
            else -> 1000f
        }
    }


    override fun onDraw(canvas: Canvas) {
        val topMargin = 20                           // отступ от верхнего края canvas
        val ourAxisY = (800 + topMargin).toFloat()   // опускаем  ось вниз
        val ourAxisX = 80f                          // сдвигаем ось  вправо
        val stopAxisX = 950f                         // крайний правый край
        val startAxisY = 10                          //старт по оси Y

        // Рисуем вспомогательные линии
        var axis = topMargin
        while (axis < 800) {
            axis += 100
            canvas.drawLine(ourAxisX, axis.toFloat(), stopAxisX, axis.toFloat(), lineHelperPaint)
        }

        // рисуем значения по оси Y
        var axisY = topMargin + startAxisY
        while (axisY < 800) {
            axisY += 100
            val number = axisY - 30
            canvas.drawText(myText(number), startAxisY.toFloat(), axisY.toFloat(), paintText)
        }

        // рисуем линии на графике
        val size = dataFromSource.size - 2

        for (i in 0..size) {
            canvas.drawLine(
                ourAxisX + myTime(dataFromSource[i].time),      // time start
                ourAxisY - dataFromSource[i].value,             // value start
                ourAxisX + myTime(dataFromSource[i + 1].time),  //time stop
                ourAxisY - dataFromSource[i + 1].value,         //value stop
                linePaint
            )
        }

        // рисуем точки      координата У = значение; Координата Х = время  (1час = 200dp)
        dataFromSource.forEach { element ->
            canvas.drawPoint(
                ourAxisX + myTime(element.time),
                ourAxisY - element.value,
                paintDot
            )
        }
    }
}