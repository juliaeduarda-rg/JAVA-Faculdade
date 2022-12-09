import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class AV1 {
    public static void main(String[] args) {
        sensorTemperatura();
        sensorUmidade();
        sensorCarbonico();
    }

    public static void sensorTemperatura() {
        Calendar agora = Calendar.getInstance();
        Scanner inserir = new Scanner(System.in);
        int linha = 5;
        int coluna = 2;
        int l, c, x, y, aux;
        int[][] matriz = new int[linha][coluna];
        System.out.println("--------------------------------------");
        System.out.println("INICIANDO CAPTURA DADOS - -TEMPERATURA");
        System.out.println("--------------------------------------");
        for (l = 0; l < linha; l++) {
            for (c = 0; c < coluna; c++) {
                Format formato = new SimpleDateFormat("HH:mm");
                agora.add(Calendar.MINUTE, 30);
                formato = new SimpleDateFormat("HH:mm");
                System.out.println(" ");
                System.out.println("-> Hora Medição: " + formato.format(agora.getTime()));
                System.out.printf("-> Temperatura atual: ");
                matriz[l][c] = inserir.nextInt();
            }
        }
        for (l = 0; l < linha; l++) {
            for (c = 0; c < coluna; c++) {
                for (x = 0; x < linha; x++) {
                    for (y = 0; y < coluna; y++) {
                        if (matriz[l][c] < matriz[x][y]) {
                            aux = matriz[l][c];
                            matriz[l][c] = matriz[x][y];
                            matriz[x][y] = aux;
                        }
                    }
                }
            }
        }
        System.out.println("---------- RELATÓRIO DA MEDIÇÃO ----------");
        for (l = 0; l < linha; l++) {
            for (c = 0; c < coluna; c++) {
                System.out.printf("[Temperatura: " + matriz[l][c] + "°C]");
                System.out.println("");
            }
        }
    }

    public static void sensorUmidade() {
        Calendar agora = Calendar.getInstance();
        Scanner inserir = new Scanner(System.in);
        int linha = 5;
        int coluna = 2;
        int l, c, x, y;
        float aux;
        float[][] matriz = new float[linha][coluna];
        System.out.println("---------------------------------");
        System.out.println("INICIANDO CAPTURA DADOS - UMIDADE");
        System.out.println("---------------------------------");
        for (l = 0; l < linha; l++) {
            for (c = 0; c < coluna; c++) {
                Format formato = new SimpleDateFormat("HH:mm");
                agora.add(Calendar.MINUTE, 30);
                formato = new SimpleDateFormat("HH:mm");
                System.out.println(" ");
                System.out.println("-> Hora Medição: " + formato.format(agora.getTime()));
                System.out.printf("-> Umidade atuasl: ");
                inserir.useLocale(Locale.US);
                matriz[l][c] = inserir.nextFloat();
            }
        }
        for (l = 0; l < linha; l++) {
            for (c = 0; c < coluna; c++) {
                for (x = 0; x < linha; x++) {
                    for (y = 0; y < coluna; y++) {
                        if (matriz[l][c] > matriz[x][y]) {
                            aux = matriz[l][c];
                            matriz[l][c] = matriz[x][y];
                            matriz[x][y] = aux;
                        }
                    }
                }
            }
        }
        System.out.println("---------- RELATÓRIO DA MEDIÇÃO ----------");
        for (l = 0; l < linha; l++) {
            for (c = 0; c < coluna; c++) {
                System.out.printf("[Umidade: " + matriz[l][c] + "%%]");
                System.out.println("");
            }
        }
    }

    public static void sensorCarbonico() {
        Calendar agora = Calendar.getInstance();
        Scanner inserir = new Scanner(System.in);
        int linha = 5;
        int coluna = 2;
        int l, c, x, y, aux;
        int[][] matriz = new int[linha][coluna];
        System.out.println("---------------------------------------");
        System.out.println("INICIANDO CAPTURA DADOS - GÁS CARBÔNICO");
        System.out.println("---------------------------------------");
        for (l = 0; l < linha; l++) {
            for (c = 0; c < coluna; c++) {
                Format formato = new SimpleDateFormat("HH:mm");
                agora.add(Calendar.MINUTE, 30);
                formato = new SimpleDateFormat("HH:mm");
                System.out.println(" ");
                System.out.println("-> Hora Medição: " + formato.format(agora.getTime()));
                System.out.printf("-> Gás Carbônico atual: ");
                matriz[l][c] = inserir.nextInt();
            }
        }
        for (l = 0; l < linha; l++) {
            for (c = 0; c < coluna; c++) {
                for (x = 0; x < linha; x++) {
                    for (y = 0; y < coluna; y++) {
                        if (matriz[l][c] < matriz[x][y]) {
                            aux = matriz[l][c];
                            matriz[l][c] = matriz[x][y];
                            matriz[x][y] = aux;
                        }
                    }
                }
            }
        }
        System.out.println("---------- RELATÓRIO DA MEDIÇÃO ----------");
        for (l = 0; l < linha; l++) {
            for (c = 0; c < coluna; c++) {
                System.out.printf("[Gás Carbônico: " + matriz[l][c] + " CO²]");
                System.out.println("");
            }
        }
    }
}
