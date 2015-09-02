/**
 * Esta clase maneja el dia actual en español
 */
package data;

import java.util.Date;

/**
 * Esta clase maneja la fehca actual, puedes obtener el dia (lunes, martes, etc), el mes, el año, el numero del dia del mes y una fecha "formal"
 * @version 1.0
 * @author easysoft
 */
public class HandlerDate {

    Date date = new Date();
    
    String dia() {
        String day = "";
        switch (date.getDay()) {
            case 0:
                day = "Domingo";
                break;
            case 1:
                day = "Lunes";
                break;
            case 2:
                day = "Martes";
                break;
            case 3:
                day = "Miercoles";
                break;
            case 4:
                day = "Jueves";
                break;
            case 5:
                day = "Viernes";
                break;
            case 6:
                day = "Sabado";
                break;
        }
        return day;
    }

    String mes() {
        String month = "";
        switch (date.getMonth()) {
            case 0:
                month = "Enero";
                break;
            case 1:
                month = "Febrero";
                break;
            case 2:
                month = "Marzo";
                break;
            case 3:
                month = "Abril";
                break;
            case 4:
                month = "Mayo";
                break;
            case 5:
                month = "Junio";
                break;
            case 6:
                month = "Julio";
                break;
            case 7:
                month = "Agosto";
                break;
            case 8:
                month = "Septiembre";
                break;
            case 9:
                month = "Octubre";
                break;
            case 10:
                month = "Noviembre";
                break;
            case 11:
                month = "Diciembre";
                break;

        }
        return month;
    }

    String año() {

        String year = String.valueOf(date.getYear() + 1900);

        return year;
    }
    
    String numero_dia()
    {
        return String.valueOf(date.getDate());
    }
    
    String fecha_formal()
    {
        return this.dia() + ", " + this.numero_dia() + " de " + this.mes() + " de " + this.año();
    }
}
