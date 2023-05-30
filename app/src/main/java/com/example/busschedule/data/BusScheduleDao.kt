
package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {
   /*me da ell tiempo de llegada en orden ascendente*/
    @Query(
        """
        SELECT * FROM schedule 
        ORDER BY arrival_time ASC    
        """
    )
   /*obtener todos los registros de la tabla schedule*/
    fun getAll(): Flow<List<BusSchedule>>

    @Query(
        """
        SELECT * FROM schedule 
        WHERE stop_name = :stopName 
        ORDER BY arrival_time ASC 
        """
    )

    /*realiza una consulta a la base de datos para obtener los registros
    de la tabla schedule que coinciden con el nombre de parada stopName.
    y los ordena ascendentemente dependiendo su hora*/

    fun getByStopName(stopName: String): Flow<List<BusSchedule>>
}
