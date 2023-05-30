
package com.example.busschedule.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*representa un registro de la tabla "Schedule" en la base de datos.
La clase tiene tres propiedades: id, stopName y arrivalTimeInMillis,
que se corresponden con las columnas de la tabla. Los campos están anotados
para definir sus propiedades, como la clave primaria y el nombre de la columna en la tabla.*/
@Entity(tableName = "Schedule")
data class BusSchedule(
    @PrimaryKey
    val id: Int,
    @NonNull
    @ColumnInfo(name = "stop_name")
    val stopName: String,
    @NonNull
    @ColumnInfo(name = "arrival_time")
    val arrivalTimeInMillis: Int
)
