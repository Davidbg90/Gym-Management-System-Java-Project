package gymsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * Sistema de Gestión de Gimnasio (Gym Management System).
 *
 * <p>Aplicación de consola para gestionar los miembros, entrenadores,
 * máquinas y reservas de un gimnasio. Permite al administrador realizar
 * operaciones CRUD sobre cada entidad y gestionar las reservas de máquinas.</p>
 *
 * <p>Proyecto basado en el fork de:
 * <a href="https://github.com/KaShiekzmi/Gym-Management-System-Java-Project">
 * KaShiekzmi/Gym-Management-System-Java-Project</a></p>
 *
 * @author Davidbg90
 * @version 1.0
 */sed -i 's/public class Gym_Management_System {/public class Gym_Management_System {\n\n    \/** Constructor por defecto. *\/\n    public Gym_Management_System() {\n        \/\/ Constructor vacío requerido por JavaDoc\n    }/' src/main/java/gymsystem/Gym_Management_System.java
public class Gym_Management_System {

    /**
     * Número máximo de miembros que puede gestionar el sistema.
     */
    private static final int MAX_MEMBERS = 200;

    /**
     * Número máximo de entrenadores que puede gestionar el sistema.
     */
    private static final int MAX_TRAINERS = 20;

    /**
     * Número máximo de máquinas que puede gestionar el sistema.
     */
    private static final int MAX_MACHINES = 15;

    /**
     * Número de campos por miembro almacenados en el array bidimensional.
     */
    private static final int MEMBER_FIELDS = 12;

    /**
     * Número de campos por entrenador almacenados en el array bidimensional.
     */
    private static final int TRAINER_FIELDS = 4;

    /**
     * Número de campos por máquina almacenados en el array bidimensional.
     */
    private static final int MACHINE_FIELDS = 12;

    /**
     * Punto de entrada principal de la aplicación.
     *
     * <p>Inicializa los arrays de datos, carga la información desde los
     * ficheros de persistencia y lanza el menú de login.</p>
     *
     * @param args argumentos de línea de comandos (no utilizados)
     * @throws IOException si ocurre un error de entrada/salida con los ficheros
     */
sed -i 's/public class Gym_Management_System {/public class Gym_Management_System {\n\n    \/** Constructor por defecto. *\/\n    public Gym_Management_System() {\n        \/\/ Constructor vacío requerido por JavaDoc\n    }/' src/main/java/gymsystem/Gym_Management_System.java

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[][] Members  = new String[MAX_MEMBERS][MEMBER_FIELDS];
        String[][] trainer  = new String[MAX_TRAINERS][TRAINER_FIELDS];
        String[][] Machines = new String[MAX_MACHINES][MACHINE_FIELDS];
        String[]   AdminInfo = new String[2];

        System.out.println("____________________________________________________________________________");
        System.out.println(" WELCOME TO SYSTEM");
        System.out.println("____________________________________________________________________________");

        boolean loaded = true;
        while (loaded) {
            try {
                File a1 = new File("Members.txt");
                Scanner input = new Scanner(a1);
                for (int i = 0; i < Members.length; i++) {
                    String ab = input.nextLine();
                    String[] data = ab.split("#");
                    for (int j = 0; j <sed -i 's/public class Gym_Management_System {/public class Gym_Management_System {\n\n    \/** Constructor por defecto. *\/\n    public Gym_Management_System() {\n        \/\/ Constructor vacío requerido por JavaDoc\n    }/' src/main/java/gymsystem/Gym_Management_System.java Members[0].length; j++) {
                        Members[i][j] = data[j];
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("\n\t\tNo Previous File Exists. Creating 'Members' File\n");
                OutputStream os = new FileOutputStream("Members.txt");
                PrintWriter put = new PrintWriter(os);
                for (int i = 0; i < MAX_MEMBERS; i++) {
                    for (int j = 0; j < MEMBER_FIELDS; j++) put.print("null#");
                    put.println();
                }
                put.close();
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\n\t\tIndex out of bound exception. Closing.\n");
                System.exit(1);
            }

            try {
                File a2 = new File("trainers.txt");
                Scanner cs = new Scanner(a2);
                for (int k = 0; k < trainer.length; k++) {
                    String bc = cs.nextLine();
                    String[] info = bc.split("#");
                    for (int s = 0; s < trainer[0].length; s++) {
                        trainer[k][s] = info[s];
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("\n\t\tNo Previous File Exists. Creating 'trainers' File\n");
                OutputStream os = new FileOutputStream("trainers.txt");
                PrintWriter put = new PrintWriter(os);
                for (int i = 0; i < MAX_TRAINERS; i++) {
                    for (int j = 0; j < TRAINER_FIELDS; j++) put.print("null#");
                    put.println();
                }
                put.close();
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.exit(1);
            }

            try {
                File a3 = new File("Machines.txt");
                Scanner inp = new Scanner(a3);
                for (int k = 0; k < Machines.length; k++) {
                    String cd = inp.nextLine();
                    String[] Mach = cd.split("#");
                    for (int s = 0; s < Machines[0].length; s++) {
                        Machines[k][s] = Mach[s];
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("\n\t\tNo Previous File Exists. Creating 'Machines' File\n");
                OutputStream os = new FileOutputStream("Machines.txt");
                PrintWriter put = new PrintWriter(os);
                for (int i = 0; i < MAX_MACHINES; i++) {
                    for (int j = 0; j < MACHINE_FIELDS; j++) put.print("null#");
                    put.println();
                }
                put.close();
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.exit(1);
            }

            try {
                File a4 = new File("AdminInfo.txt");
                Scanner in = new Scanner(a4);
                String de = in.nextLine();
                String[] adInfo = de.split("#");
                for (int i = 0; i < AdminInfo.length; i++) AdminInfo[i] = adInfo[i];
            } catch (FileNotFoundException e) {
                System.out.println("\n\t\tCreating AdminInfo File. Default: admin/anything\n");
                OutputStream os = new FileOutputStream("AdminInfo.txt");
                PrintWriter put = new PrintWriter(os);
                put.print("admin#");
                put.print("anything#");
                put.close();
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.exit(1);
            }
            loaded = false;
        }
        login(Members, trainer, AdminInfo, Machines);
    }

    /**
     * Muestra el menú de inicio de sesión y gestiona la autenticación.
     *
     * <p>Permite al usuario iniciar sesión con sus credenciales o
     * actualizar el nombre de usuario y contraseña del administrador.</p>
     *
     * @param Members   array bidimensional con los datos de los miembros
     * @param trainer   array bidimensional con los datos de los entrenadores
     * @param AdminInfo array con el usuario y contraseña del administrador
     * @param Machines  array bidimensional con los datos de las máquinas
     * @throws IOException si ocurre un error al guardar las credenciales
     */
    public static void login(String[][] Members, String[][] trainer,
                             String[] AdminInfo, String[][] Machines)
            throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n1. Login");
        System.out.println("2. Change Login Credentials");
        System.out.println("0. Quit Program");
        System.out.print("Enter Your Choice: ");
        String cho = sc.next();

        while (true) {
            if (cho.equals("1") || cho.equals("2") || cho.equals("0")) break;
            else {
                System.out.println("\n\n\t\tInvalid Choice.");
                System.out.print("Enter Your Choice: ");
                cho = sc.next();
            }
        }

        if (cho.equals("1")) {
            System.out.print("\nEnter UserName: ");
            String U_name = sc.next();
            while (!U_name.equals(AdminInfo[0])) {
                System.out.println("\n\tInvalid User Name!");
                System.out.print("Enter UserName: ");
                U_name = sc.next();
                if (U_name.equals("0")) System.exit(1);
            }
            System.out.print("\nEnter Password: ");
            String password = sc.next();
            while (!password.equals(AdminInfo[1])) {
                System.out.println("\n\tInvalid Password!");
                System.out.print("Enter Password: ");
                password = sc.next();
                if (password.equals("0")) System.exit(1);
            }
        } else if (cho.equals("2")) {
            // Actualizar credenciales
            System.out.print("\nEnter Existing UserName: ");
            String U_name = sc.nextLine();
            while (!U_name.equals(AdminInfo[0])) {
                System.out.print("\nEnter Existing UserName: ");
                U_name = sc.nextLine();
                if (U_name.equals("0")) System.exit(1);
            }
            System.out.print("Enter Existing Password: ");
            String password = sc.nextLine();
            while (!password.equals(AdminInfo[1])) {
                System.out.print("\nEnter Existing Password: ");
                password = sc.nextLine();
                if (password.equals("0")) System.exit(1);
            }
            System.out.print("\nEnter new Username: ");
            AdminInfo[0] = sc.nextLine();
            System.out.print("\nEnter new Password: ");
            AdminInfo[1] = sc.nextLine();
            PrintWriter myFile = new PrintWriter("./AdminInfo.txt");
            for (String s : AdminInfo) myFile.print(s + "#");
            myFile.close();
            login(Members, trainer, AdminInfo, Machines);
        } else {
            System.exit(1);
        }
        mainmenu(Members, trainer, AdminInfo, Machines);
    }

    /**
     * Muestra el menú principal y redirige a cada módulo del sistema.
     *
     * <p>Opciones disponibles: gestión de miembros, entrenadores,
     * máquinas, reservas, cierre de sesión y salida del programa.</p>
     *
     * @param Members   array bidimensional con los datos de los miembros
     * @param trainer   array bidimensional con los datos de los entrenadores
     * @param AdminInfo array con las credenciales del administrador
     * @param Machines  array bidimensional con los datos de las máquinas
     * @throws IOException si ocurre un error de entrada/salida
     */
    public static void mainmenu(String[][] Members, String[][] trainer,
                                String[] AdminInfo, String[][] Machines)
            throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n\t\t\t** MAIN MENU **\n");
            System.out.println("1. Member");
            System.out.println("2. Trainer");
            System.out.println("3. Machines");
            System.out.println("4. Machine Booking");
            System.out.println("0. Logout");
            System.out.println("00. Exit");
            System.out.print("\nEnter Your Choice: ");
            String cho = sc.next();
            if (cho.equals("00")) System.exit(1);
            else if (cho.equals("0")) {
                login(Members, trainer, AdminInfo, Machines);
                break;
            }
        }
    }

    /**
     * Valida que un nombre contenga únicamente letras del alfabeto.
     *
     * @param name nombre a validar
     * @return el nombre validado (solicita reintento si contiene caracteres inválidos)
     */
    public static String validate_name(String name) {
        Scanner sc = new Scanner(System.in);
        while (!name.matches("[a-zA-Z]+")) {
            System.out.println("\n\t\tInvalid name. Only letters allowed.");
            System.out.print("Enter name: ");
            name = sc.next();
        }
        return name;
    }

    /**
     * Valida que un número de teléfono cumpla el formato 03XX-XXXXXXX.
     *
     * @param phone número de teléfono a validar
     * @return el teléfono validado
     */
    public static String validate_phone(String phone) {
        Scanner sc = new Scanner(System.in);
        while (!phone.matches("03\\d{2}-\\d{7}")) {
            System.out.println("\n\t\tInvalid phone. Format: 03XX-XXXXXXX");
            System.out.print("Enter phone: ");
            phone = sc.next();
        }
        return phone;
    }

    /**
     * Valida que un número de registro sea numérico.
     *
     * @param regNo     número de registro a validar
     * @param Members   array de miembros (para navegación al menú principal)
     * @param trainer   array de entrenadores
     * @param AdminInfo credenciales del administrador
     * @param Machines  array de máquinas
     * @return el número de registro validado
     * @throws IOException si ocurre un error de entrada/salida
     */
    public static String validate_regNo(String regNo, String[][] Members,
                                        String[][] trainer, String[] AdminInfo,
                                        String[][] Machines) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (!regNo.matches("\\d+") && !regNo.equalsIgnoreCase("Y")) {
            System.out.println("\n\t\tInvalid registration number.");
            System.out.print("Enter registration number: ");
            regNo = sc.next();
        }
        if (regNo.equalsIgnoreCase("Y")) {
            mainmenu(Members, trainer, AdminInfo, Machines);
        }
        return regNo;
    }

    /**
     * Valida y solicita el peso o la altura de un miembro.
     *
     * @param list   array de miembros
     * @param choice opción seleccionada (3 = peso, 4 = altura)
     * @param index  índice del miembro en el array
     * @param column columna del array donde almacenar el valor
     */
    public static void InputforHeightAndWeight(String[][] list, String choice,
                                               int index, int column) {
        Scanner sc = new Scanner(System.in);
        String label = choice.equals("3") ? "Weight (kg)" : "Height (ft)";
        System.out.print("\nEnter " + label + ": ");
        String value = sc.next();
        while (!value.matches("\\d+(\\.\\d+)?")) {
            System.out.println("\n\t\tInvalid value. Enter a number.");
            System.out.print("Enter " + label + ": ");
            value = sc.next();
        }
        list[index][column] = value;
    }
}
