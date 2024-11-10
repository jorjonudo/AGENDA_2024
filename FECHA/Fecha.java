import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Fecha {

    public static void main(String[] args) {
        // Formato de fecha para España
        DateTimeFormatter formatoEspañol = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // 1. La fecha actual local (hora local de España)
        LocalDateTime fechaLocal = LocalDateTime.now();
        System.out.println("Fecha actual local (España): " + fechaLocal.format(formatoEspañol));

        // 2. La fecha actual en Caracas (usando zona horaria de Caracas)
        ZonedDateTime fechaCaracas = ZonedDateTime.now(ZoneId.of("America/Caracas"));
        System.out.println("Fecha actual en Caracas: " + fechaCaracas.format(formatoEspañol));

        // 3. Los años transcurridos desde el descubrimiento de América (12 de octubre de 1492)
        LocalDate fechaDescubrimiento = LocalDate.of(1492, 10, 12);
        LocalDate fechaActual = LocalDate.now();
        long añosTranscurridos = ChronoUnit.YEARS.between(fechaDescubrimiento, fechaActual);
        System.out.println("Años transcurridos desde el descubrimiento de América: " + añosTranscurridos);

        // 4. La hora actual local
        LocalTime horaLocal = LocalTime.now();
        System.out.println("Hora actual local (España): " + horaLocal);

        // 5. La hora actual en Caracas
        LocalTime horaCaracas = LocalTime.now(ZoneId.of("America/Caracas"));
        System.out.println("Hora actual en Caracas: " + horaCaracas);

        // 6. Las horas de diferencia entre Madrid y Caracas
        ZonedDateTime zonaMadrid = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
        ZonedDateTime zonaCaracas2 = ZonedDateTime.now(ZoneId.of("America/Caracas"));
        long diferenciaHoras = Duration.between(zonaCaracas2, zonaMadrid).toHours();
        System.out.println("Diferencia horaria entre Madrid y Caracas: " + diferenciaHoras + " horas");

        // 7. La fecha y la hora cuando Neil Armstrong pisó la luna (21 de julio de 1969 a las 3:56 hora de Madrid)
        LocalDateTime fechaLuna = LocalDateTime.of(1969, 7, 21, 3, 56);
        ZonedDateTime fechaLunaMadrid = ZonedDateTime.of(fechaLuna, ZoneId.of("Europe/Madrid"));
        System.out.println("Fecha y hora cuando Neil Armstrong pisó la luna: " + fechaLunaMadrid.format(formatoEspañol));
    }
}
