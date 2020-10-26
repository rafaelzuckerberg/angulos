
import java.util.Scanner;
import java.util.GregorianCalendar;

import java.time.Instant;
import java.time.ZoneOffset;

public class Angulo {
    
    public static void main(String args[]) {
        
        Teste minhaClasse = new Teste();
        Scanner entrada = new Scanner(System.in);
        
        Instant instant = Instant.now();
        
        System.out.println("Deseja inserir mamualmente o horário, ou de forma automática?");
        
        System.out.println("0 - Manual");
        System.out.println("1 - Automático");
        int resposta = entrada.nextInt();
        
        if(resposta == 0) {
            // Manul
            System.out.println("Favor informar a hora entre 0 e 12:00");
        
            int hora = 0;
            int minuto = 0;
            
            do {
                System.out.println("Digite a hora:");
                hora = entrada.nextInt();
            } while(hora < 0 || hora > 12);
            
            
            do {
                System.out.println("Digite o minuto:");
                minuto = entrada.nextInt();
            } while(minuto < 0 || minuto > 60);
            
            GregorianCalendar horario = new GregorianCalendar(2020, 10, 26, hora, minuto);
            System.out.println("Horário " + (instant.atZone(ZoneOffset.UTC).getHour() - 3) + ":" + instant.atZone(ZoneOffset.UTC).getMinute());
            System.out.println("O ângulo é de " + minhaClasse.retornarAnguloRelogio(horario) + "°");
        } else {
            // Automático
            int hora = instant.atZone(ZoneOffset.UTC).getHour() - 3;
            int minuto = instant.atZone(ZoneOffset.UTC).getMinute();
            System.out.println("Horário " + (instant.atZone(ZoneOffset.UTC).getHour() - 3) + ":" + instant.atZone(ZoneOffset.UTC).getMinute());
            GregorianCalendar horario = new GregorianCalendar(2020, 10, 26, hora, minuto);
            System.out.println("O ângulo é de " + minhaClasse.retornarAnguloRelogio(horario) + "°");
        }
    }
    
    
    public long retornarAnguloRelogio(GregorianCalendar horario) {
        int hora = horario.get(GregorianCalendar.HOUR);
        int minuto = horario.get(GregorianCalendar.MINUTE);
        long resultado = (hora * 60 - minuto * 11)/2;
        return Math.abs(resultado);
    }
}
