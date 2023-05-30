
package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.AppDatabase
/* este código crea una instancia de la base de datos AppDatabase utilizando la clase BusScheduleApplication
como contexto. La instancia de la base de datos se crea de forma perezosa y estará disponible a través de la
propiedad database en toda la aplicación.*/
class BusScheduleApplication: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}
