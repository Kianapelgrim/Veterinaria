package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // write your code here
        int resp=0;
        int resp1=0;
        int resp2=0;
        int resp3=0;
        int i=0;
        int k = 0;
        int respCita=0;
        int respModificar=0;
        int modifdiag=0;
        int cancelardiag=0;
        String[] nombre= new String[2];
        String[] nombreDiag= new String[2];
        String[] nombreMas= new String[2];
        String[] masDiag = new String[2];
        String[] diagnostico= new String[2];
        LocalDate [] date = new LocalDate[2];
        LocalTime [] time = new LocalTime[2];
        Boolean [] cancelacion = new Boolean[2];
        Boolean [] cancelDiag = new Boolean[2];
        do {
            System.out.println("VETERINARIA\n\n1.-Citas\n2.-Diagnósticos\n3.-Reportes\n4.-Salir");
            Scanner lc = new Scanner(System.in);

            boolean valorValido = true;
            do {
                try {
                    System.out.println("¿Qué desea realizar?");
                    resp = Integer.parseInt(lc.nextLine());
                    valorValido = true;
                } catch (Exception ex) {
                    System.out.println("Introduzca un valor valido");
                    valorValido = false;
                }
            } while (valorValido != true);
            switch (resp) {
                case 1:
                    do{
                    System.out.println("¿Qué desea realizar?\n1.-Agendar Cita \n2.-Re-agendar cita\n3.-Cancelar cita\n4.-Regresar a menú principal");
                    valorValido = true;
                    do {
                        try {
                            System.out.println("¿Qué desea realizar?");
                            resp1 = Integer.parseInt(lc.nextLine());
                            valorValido = true;
                        } catch (Exception ex) {
                            System.out.println("Introduzca un valor valido");
                            valorValido = false;
                        }
                    } while (valorValido != true);
            switch (resp1){
                case 1:
                    System.out.println("Introduzca su nombre");
                    i++;
                    if(i>1) {
                       Boolean[] temp= new Boolean[i+1];
                       temp[i]=false;
                        for (int j = 0; j < i; j++) {
                            temp[j] = cancelacion[j];
                        }
                        cancelacion = new Boolean[i+1];
                        for (int j = 0; j < i+1; j++) {
                            cancelacion[j] = temp[j];
                        }
                    }else{cancelacion[i]=false;}

                    if(i>1) {
                        String[] temp= new String[i+1];
                        temp[i]=lc.nextLine();
                        for (int j = 0; j < i; j++) {
                            temp[j] = nombre[j];
                        }
                        nombre = new String[i+1];
                        for (int j = 0; j < i+1; j++) {
                            nombre[j] = temp[j];
                        }
                    }else{nombre[i] = lc.nextLine();}

                    System.out.println("Introduzca el nombre de su mascota");
                    if(i>1) {
                        String[] temp= new String[i+1];
                        temp[i]=lc.nextLine();
                        for (int j = 1; j < i; j++) {
                            temp[j] = nombreMas[j];
                        }
                        nombreMas = new String[i+1];
                        for (int j = 0; j < i+1; j++) {
                            nombreMas[j] = temp[j];
                        }
                    }else{nombreMas[i] = lc.nextLine();}
                    System.out.println("Introduzca la fecha de su cita (Año-Mes-Día, ejm 2001-05-25)");

                    valorValido= true;
                    do {
                        try {
                            String entrada = lc.next();
                            if(i>1) {
                                LocalDate[] temp= new LocalDate[i+1];
                                temp[i]= LocalDate.parse(entrada);
                                for (int j = 1; j < i; j++) {
                                    temp[j] = date[j];
                                }
                                date = new LocalDate[i+1];
                                for (int j = 1; j < i+1; j++) {
                                    date[j] = temp[j];
                                }
                            }else{date[i] = LocalDate.parse(entrada);;}
                            valorValido=true;

                        } catch (Exception e) {
                            System.out.println("Introduzca una fecha valida");
                            valorValido=false;

                        }
                    }while(!valorValido);

                    System.out.println("Introduzca la hora que desea su cita (hh:mm)");

                    valorValido= true;
                    do {
                        try {
                            String entrada = lc.next();
                            if(i>1) {
                                LocalTime[] temp= new LocalTime[i+1];
                                temp[i]= LocalTime.parse(entrada);
                                for (int j = 1; j < i; j++) {
                                    temp[j] = time[j];
                                }
                               time = new LocalTime[i+1];
                                for (int j = 1; j < i+1; j++) {
                                    time[j] = temp[j];
                                }
                            }else{time[i] = LocalTime.parse(entrada);;}
                            valorValido=true;

                        } catch (Exception e) {
                            System.out.println("Introduzca un hora válida");
                            valorValido=false;

                        }
                    }while(!valorValido);
                    break;
                case 2:
                    for (int j = 1; j < i+1; j++) {
                        if(cancelacion[j]==false)
                        System.out.println(j+".-\t"+nombre[j]+"\t"+nombreMas[j]+"\t"+date[j]+"\t"+time[j]);
                    }
                    System.out.println("\n\nIntroduzca el número de cita que gustaría modificar");
                    valorValido = true;
                    do {
                        try {
                            respCita = Integer.parseInt(lc.nextLine());
                            valorValido = true;
                        } catch (Exception ex) {
                            System.out.println("Introduzca un valor valido");
                            valorValido = false;
                        }
                    } while (valorValido != true);
                    System.out.println("¿Qué le gustaría modificar?\n\n1.-Nombre\n2.-Nombre de mascota\n3.-Fecha\n4.-Hora");
                    valorValido = true;
                    do {
                        try {
                            respModificar = Integer.parseInt(lc.nextLine());
                            valorValido = true;
                        } catch (Exception ex) {
                            System.out.println("Introduzca un valor valido");
                            valorValido = false;
                        }
                    } while (valorValido != true);
                    switch (respModificar){
                        case 1:
                            System.out.println("Introduzca el NOMBRE correcto");
                            nombre[respCita]=lc.nextLine();
                            break;
                        case 2:
                            System.out.println("Introduzca el NOMBRE DE MASCOTA correcto");
                            nombreMas[respCita]=lc.nextLine();
                            break;
                        case 3:
                            System.out.println("Introduzca la FECHA deseada (Año-Mes-Día, ejm 2001-05-25)");
                            do {
                                try {
                                    String entrada = lc.nextLine();
                                   date[respCita] = LocalDate.parse(entrada);;
                                    valorValido=true;
                                } catch (Exception e) {
                                    System.out.println("Introduzca una fecha valida");
                                    valorValido=false;
                                }
                            }while(!valorValido);
                            break;
                        case 4:
                            System.out.println("Introduzca la HORA deseada");
                            do {
                                try {
                                    String entrada = lc.next();
                                    time[respCita] = LocalTime.parse(entrada);
                                    valorValido=true;
                                } catch (Exception e) {
                                    System.out.println("Introduzca un hora válida");
                                    valorValido=false;
                                }
                            }while(!valorValido);
                            break;
                    }
                    break;
                case 3:
                    for (int j = 1; j < i+1; j++) {
                        if(cancelacion[j]==false)
                            System.out.println(j+".-\t"+nombre[j]+"\t"+nombreMas[j]+"\t"+date[j]+"\t"+time[j]);
                    }
                    System.out.println("Introduzca el numero de cita que desea cancelar");
                    do {
                        try {
                            respCita = Integer.parseInt(lc.nextLine());
                            valorValido = true;
                        } catch (Exception ex) {
                            System.out.println("Introduzca un valor valido");
                            valorValido = false;
                        }
                    } while (valorValido != true);
                    cancelacion[respCita]=true;
                    break;
                case 4: break;
                default:
                    System.out.println("Introduzca un número dentro de las opciones");break;
            }}while (resp1!=4);
            break;

            case 2:
                do{
                System.out.println("¿Qué desea realizar?\n\n1.-Registrar diagnostico\n2.-Modificar diagnostico\n3.-Cancelar diagnostico\n4.-Regresar al menu principal");
                valorValido = true;
                do {
                    try {
                        System.out.println("¿Qué desea realizar?");
                        resp2 = Integer.parseInt(lc.nextLine());
                        valorValido = true;
                    } catch (Exception ex) {
                        System.out.println("Introduzca un valor valido");
                        valorValido = false;
                    }
                } while (valorValido != true);
                switch (resp2) {
                    case 1:
                        k++;
                        if (k > 1) {
                            Boolean[] temp = new Boolean[k + 1];
                            temp[k] = false;
                            for (int j = 0; j < k; j++) {
                                temp[j] = cancelDiag[j];
                            }
                            cancelDiag = new Boolean[k + 1];
                            for (int j = 0; j < k + 1; j++) {
                                cancelDiag[j] = temp[j];
                            }
                        } else {
                            cancelDiag[k] = false;
                        }
                        System.out.println("Introduzca el nombre");
                        if (k > 1) {
                            String[] temp = new String[k + 1];
                            temp[k] = lc.nextLine();
                            for (int j = 0; j < k; j++) {
                                temp[j] = nombreDiag[j];
                            }
                            nombreDiag = new String[k + 1];
                            for (int j = 0; j < k + 1; j++) {
                                nombreDiag[j] = temp[j];
                            }
                        } else {
                            nombreDiag[k] = lc.nextLine();
                        }
                        System.out.println("Introduzca el nombre de la mascota");
                        if (k > 1) {
                            String[] temp = new String[k + 1];
                            temp[k] = lc.nextLine();
                            for (int j = 1; j < k; j++) {
                                temp[j] = masDiag[j];
                            }
                            masDiag = new String[k + 1];
                            for (int j = 0; j < k + 1; j++) {
                                masDiag[j] = temp[j];
                            }
                        } else {
                            masDiag[k] = lc.nextLine();
                        }
                        System.out.println("Introduzca el diagnostico");
                        if (k > 1) {
                            String[] temp = new String[k + 1];
                            temp[k] = lc.nextLine();
                            for (int j = 1; j < k; j++) {
                                temp[j] = diagnostico[j];
                            }
                            diagnostico = new String[k + 1];
                            for (int j = 0; j < k + 1; j++) {
                                diagnostico[j] = temp[j];
                            }
                        } else {
                            diagnostico[k] = lc.nextLine();
                        }
                        break;
                    case 2:
                        for (int j = 1; j < k + 1; j++) {
                            if (cancelDiag[j] == false) {
                                System.out.println(j + ".-\t" + nombreDiag[j] + "\t" + masDiag[j] + "\t" + diagnostico[j]);
                            }
                        }
                        System.out.println("Introduzca el número de diagnostico que desearía modificar");
                        valorValido = true;
                        do {
                            try {
                                modifdiag = Integer.parseInt(lc.nextLine());
                                valorValido = true;
                            } catch (Exception ex) {
                                System.out.println("Introduzca un valor valido");
                                valorValido = false;
                            }
                        } while (valorValido != true);
                        System.out.println("¿Qué le gustaría modificar?\n\n1.-Nombre\n2.-Nombre de mascota\n3.-Diagnostico");
                        valorValido = true;
                        do {
                            try {
                                respModificar = Integer.parseInt(lc.nextLine());
                                valorValido = true;
                            } catch (Exception ex) {
                                System.out.println("Introduzca un valor valido");
                                valorValido = false;
                            }
                        } while (valorValido != true);
                        switch (respModificar) {
                            case 1:
                                System.out.println("Introduzca el nombre correcto");
                                nombreDiag[modifdiag] = lc.nextLine();
                                break;
                            case 2:
                                System.out.println("Introduzca el nombre correcto de la mascota");
                                masDiag[modifdiag] = lc.nextLine();
                                break;
                            case 3:
                                System.out.println("Introduzca el diagnostico correcto");
                                diagnostico[modifdiag] = lc.nextLine();
                                break;
                            default:
                                System.out.println("Introduzca una opción válida");
                                break;
                        }
                        break;
                    case 3:
                        for (int j = 1; j < k + 1; j++) {
                            if (cancelDiag[j] == false) {
                                System.out.println(j + ".-\t" + nombreDiag[j] + "\t" + masDiag[j] + "\t" + diagnostico[j]);
                            }
                        }
                        System.out.println("Introduzca el diagnostico que desea cancelar");
                        valorValido = true;
                        do {
                            try {
                                System.out.println("¿Qué desea realizar?");
                                cancelardiag = Integer.parseInt(lc.nextLine());
                                valorValido = true;
                            } catch (Exception ex) {
                                System.out.println("Introduzca un valor valido");
                                valorValido = false;
                            }
                        } while (valorValido != true);
                        cancelDiag[cancelardiag] = true;
                        break;

                }
                }while (resp2!=4);
                break;
                case 3:
                    do {
                        System.out.println("Introduzca el reporte que gustaría ver\n1.-Reporte de citas\n2.-Reportes de diagnosticos\n3.-Salir");
                        valorValido = true;
                        do {
                            try {
                                resp3 = Integer.parseInt(lc.nextLine());
                                valorValido = true;
                            } catch (Exception ex) {
                                System.out.println("Introduzca un valor valido");
                                valorValido = false;
                            }
                        } while (valorValido != true);
                        switch (resp3){
                            case 1:
                                System.out.println("\t\t\tREPORTE DE CITAS");
                                for (int j = 1; j < i+1; j++) {

                                    System.out.println("\n\n"+j+".-\t"+nombre[j]+"\t"+nombreMas[j]+"\t"+date[j]+"\t"+time[j]);
                                if(cancelacion[j]==true)
                                    System.out.println("CITA CANCELADA");
                            } System.out.println("\n\n");break;
                            case 2:System.out.println("\t\t\tREPORTE DE DIAGNÓSTICOS");
                            for (int j = 1; j < k+1 ; j++) {
                                    System.out.println("\n\n"+j+".-\t"+nombreDiag[j]+"\t"+masDiag[j]+"\t"+diagnostico[j]);
                                if(cancelDiag[j]==true)
                                    System.out.println("DIAGNOSTICO CANCELADO");}
                                System.out.println("\n\n");break;
                            case 3: break;
                            default:
                                System.out.println("Introduzca un valor válido" );
                        }
                    }while(resp3!=3);
                    break;
                default:
                    System.out.println("Introduzca un número dentro de las opciones");break;

            }
        }while(resp!=4);

    }

}
