package org.example.view;

import org.example.coms.Comunicaciones;
import org.example.coms.Telegram;
import org.example.models.Administracion;
import org.example.models.Envio;
import org.example.utils.PlantillaEmail;
import org.example.utils.Utils;

import java.util.Scanner;

//Comunicaciones.enviarMensaje("daniel.rosa.0204@fernando3martos.com","pruebaCorreoFernanPaaq", PlantillaEmail.plantillaEmail("asdf", "12345"));
public class Main {
    public static final Scanner S = new Scanner(System.in);

    public static Administracion administracion = new Administracion();
    public static Envio envioCopia = new Envio();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op, op2, op3, op5, seleccionarEnvio;
        boolean apagado = false, cierraSesion = false, salirModificar = false;
        String nombreTeclado, claveTeclado, nuevoNombre, nuevaClave, respuestaEstado;

        if (datosprueba()) {
            administracion.addUsuario("Usuario1", "1234", "c/ madrid 20", "Martos", "J", 600000000, "daniel.rosa.0204@fernando3martos.com");
            System.out.println("Se ha introducido un usuario con nombre 'Usuario1' y contraseña '1234', que tiene añadido un envío con número de seguimiento '111'");
        }

        do {
            op = menuPrincipal();
            switch (op) {
                case 1:
                    //Aquí se reseta la variable que controla en encendido del menú
                    cierraSesion = false;
                    //Aquí se resetean el nombre y la clave introducidos
                    nombreTeclado = "";
                    claveTeclado = "";
                    System.out.print("Introduzca el nombre de usuario: ");
                    nombreTeclado = scanner.nextLine();
                    System.out.print("Introduzca la clave de usuario: ");
                    claveTeclado = scanner.nextLine();

                    //En los siguientes if se compruebe si es el administrador, conductor o usuario
                    if (administracion.login(nombreTeclado, claveTeclado).equals("administrador")) {
                        do {
                            op2 = menuAdmin();
                            switch (op2) {
                                case 1:
                                    registraEnvio();
                                    break;
                                case 2:
                                    asignaEnvio();
                                    break;
                                case 3:
                                    System.out.println(administracion.pintaUsuarios());
                                    Utils.pulsaParaCuntinuar();
                                    break;
                                case 4:
                                    System.out.println(administracion.pintaEnvios());
                                    Utils.pulsaParaCuntinuar();
                                    break;
                                case 5:
                                    System.out.println(administracion.pintaConductores());
                                    Utils.pulsaParaCuntinuar();
                                    break;
                                case 6:
                                    //Se resetea la bandera que controla el menú por si se entra varias veces
                                    salirModificar = false;
                                    do {
                                        op5 = menuModificarDatos("administrador");
                                        switch (op5) {
                                            case 1:
                                                nombreTeclado = cambiaNombre();
                                                break;
                                            case 2:
                                                claveTeclado = cambiaClave();
                                                break;
                                            case 3:
                                                Utils.saliendo();
                                                salirModificar = true;
                                                break;

                                            default:
                                                System.out.println("Opción incorrecta");
                                                Utils.pulsaParaCuntinuar();
                                                break;
                                        }
                                    } while (!salirModificar);

                                    break;
                                case 7:
                                    cierraSesion = cierraSesion();
                                    break;

                                default:
                                    break;
                            }

                        } while (!cierraSesion);

                    }
                    if (administracion.login(nombreTeclado, claveTeclado).equals("conductor")) {
                        do {
                            op3 = menuConductor();
                            switch (op3) {
                                case 1:
                                    System.out.println(administracion.pintaEnviosConductor(nombreTeclado));
                                    Utils.pulsaParaCuntinuar();
                                    break;
                                case 2:
                                    actualizaEstadoEnvio(nombreTeclado);
                                    break;
                                case 3:
                                    System.out.println(administracion.historicoPaquetes(nombreTeclado));
                                    Utils.pulsaParaCuntinuar();
                                    break;
                                case 4:
                                    salirModificar = false;
                                    do {
                                        op5 = menuModificarDatos("conductor");
                                        switch (op5) {
                                            case 1:
                                                nombreTeclado = cambiaNombreConductor(nombreTeclado);
                                                break;
                                            case 2:
                                                claveTeclado = cambiaClaveConductor(claveTeclado);
                                                break;
                                            case 3:
                                                Utils.saliendo();
                                                salirModificar = true;
                                                break;

                                            default:
                                                System.out.println("Opción incorrecta");
                                                Utils.pulsaParaCuntinuar();
                                                break;
                                        }
                                    } while (!salirModificar);
                                    break;
                                case 5:
                                    //Se pregunta si se está seguro de cerrar sesión por si le ha dado por error
                                    cierraSesion = cierraSesion();
                                    break;

                                default:
                                    break;
                            }
                        } while (!cierraSesion);

                    }
                    if (administracion.login(nombreTeclado, claveTeclado).equals("usuario")) {
                        do {
                            op3 = menuUsuario();
                            switch (op3) {
                                case 1:
                                    System.out.println(administracion.enviosUsuario(nombreTeclado));
                                    break;
                                case 2:
                                    cambiaDatosEnvio(nombreTeclado);
                                    break;
                                case 3:
                                    System.out.println(administracion.pintaDatosUsuario(nombreTeclado));
                                    break;
                                case 4:
                                    //Se resetea la bandera que controla el menú por si se entra varias veces
                                    salirModificar = false;
                                    do {
                                        op5 = menuModificarDatos("usuario");
                                        switch (op5) {
                                            case 1:
                                                nombreTeclado = cambiaNombreUsuario(nombreTeclado);
                                                break;
                                            case 2:
                                                claveTeclado = cambiaClaveUsuario(claveTeclado);
                                                break;
                                            case 3:
                                                Utils.saliendo();
                                                salirModificar = true;
                                                break;

                                            default:
                                                System.out.println("Opción incorrecta");
                                                Utils.pulsaParaCuntinuar();
                                                break;
                                        }
                                    } while (!salirModificar);
                                    break;
                                case 5:
                                    cierraSesion = cierraSesion();
                                    break;

                                default:
                                    break;
                            }
                        } while (!cierraSesion);

                    }
                    if (administracion.login(nombreTeclado, claveTeclado).equals("")) {
                        System.out.println("Nombre o clave incorrectos");
                        Utils.pulsaParaCuntinuar();
                    }
                    break;
                case 2:
                    registraUsuario();
                    Utils.pulsaParaCuntinuar();
                    break;
                case 3:
                    apagado = opcionApagar();
                    break;

                default:
                    System.out.println("Opción introducida incorrecta");
                    Utils.pulsaParaCuntinuar();
                    break;
            }
        } while (!apagado);
    }

    public static void validaToken(String email, String nombre) {
        int codigoValidar = -1;
        int codigo = administracion.generaNumeroAleatorio();
        boolean datoCorrecto;


        if (Comunicaciones.enviarMensaje(email, "Verificación de email", PlantillaEmail.plantillaEmail(nombre.toUpperCase(), codigo)))
            System.out.println("Correo enviado");
        else System.out.println("Error al enviar correo");

        do {
            do {
                datoCorrecto = true;
                try {
                    System.out.print("Introduce el código que hemos enviado a tu email: ");
                    codigoValidar = Integer.parseInt(S.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Debes introducir un número");
                    datoCorrecto = false;
                    Utils.pulsaParaCuntinuar();
                }
            } while (!datoCorrecto);
        } while (codigo != codigoValidar);

        System.out.println("Correo validado");
    }

    public static int menuModificarDatos(String tipoUsuario) {
        boolean datoCorrecto;
        do {
            datoCorrecto = true;
            try {
                System.out.print(" === Modificar datos de " + tipoUsuario + "  ===" + "\n" +
                        "1. Cambiar nombre de " + tipoUsuario + "\n" +
                        "2. Cambiar clave de " + tipoUsuario + "\n" +
                        "3. Salir" + "\n" +
                        "Elige la opción deseada: ");
                return Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número");
                datoCorrecto = false;
                Utils.pulsaParaCuntinuar();
            }
        } while (!datoCorrecto);
        return -1;
    }

    public static int menuPrincipal() {
        boolean datoCorrecto;
        do {
            datoCorrecto = true;
            try {
                System.out.print("""
                        Bienvenido a FernanPaaq
                        1. Iniciar sesión
                        2. Registrarse
                        3. Salir
                        Elija una opción: """);
                return Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número");
                datoCorrecto = false;
                Utils.pulsaParaCuntinuar();
            }
        } while (!datoCorrecto);
        return -1;
    }

    public static int menuAdmin() {
        boolean datoCorrecto;
        do {
            datoCorrecto = true;
            try {
                System.out.print("""
                        Bienvenido. Menú de administrador
                        1. Registrar un nuevo envío
                        2. Asignar un envío a un conductor
                        3. Ver los datos de todos los usuarios registrados
                        4. Ver los datos de todos los envíos
                        5. Ver los datos de todos los conductores
                        6. Modificar mi perfil
                        7. Cerrar sesión
                        Elija una opción: """);
                return Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número");
                datoCorrecto = false;
                Utils.pulsaParaCuntinuar();
            }
        } while (!datoCorrecto);
        return -1;
    }

    public static int menuConductor() {
        boolean datoCorrecto;
        do {
            datoCorrecto = true;
            try {
                System.out.print("""
                        Bienvenido. Menú de conductor
                        1. Ver la infomación de mis envíos
                        2. Cambiar el estado de un envío
                        3. Ver el histórico de paquetes entregados
                        4. Modificar mi perfil
                        5. Cerrar sesión
                        Elija una opción: """);
                return Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número");
                datoCorrecto = false;
                Utils.pulsaParaCuntinuar();
            }
        } while (!datoCorrecto);
        return -1;

    }

    public static int menuUsuario() {
        boolean datoCorrecto;
        do {
            datoCorrecto = true;
            try {
                System.out.print("""
                        Bienvenido. Menú de usuario
                        1. Seguir mis envíos
                        2. Modificar mis datos de entrega para un envío
                        3. Ver mi perfil
                        4. Modificar mi perfil
                        5. Cerrar sesión
                        Elija una opción: """);
                return Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número");
                datoCorrecto = false;
                Utils.pulsaParaCuntinuar();
            }
        } while (!datoCorrecto);
        return -1;

    }

    public static void registraUsuario() {
        String nombreTeclado;
        String claveTeclado;
        String direccionTeclado;
        String localidadTeclado;
        String provinciaTeclado;
        String emailTeclado = "";
        int tlfTeclado = 0;
        if (administracion.numeroUsuarios() < 2) {
            boolean correcto = true;
            do {
                if (!correcto) System.out.println("Error al introducir el email");
                System.out.print("Introduzca el email del usuario: ");
                emailTeclado = S.nextLine();
                correcto = false;
            } while (!emailTeclado.contains("@"));
            System.out.print("Introduzca el nombre de usuario: ");
            nombreTeclado = S.nextLine();
            System.out.print("Introduzca la clave de usuario: ");
            claveTeclado = S.nextLine();
            System.out.print("Introduzca la dirección del usuario: ");
            direccionTeclado = S.nextLine();
            System.out.print("Introduzca la localidad del usuario: ");
            localidadTeclado = S.nextLine();
            System.out.print("Introduzca la provincia del usuario: ");
            provinciaTeclado = S.nextLine();
            boolean datoCorrecto;
            do {
                datoCorrecto = true;
                try {
                    System.out.print("Introduzca el teléfono del usuario: ");
                    tlfTeclado = Integer.parseInt(S.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Debes introducir un número");
                    datoCorrecto = false;
                    Utils.pulsaParaCuntinuar();
                }
            } while (!datoCorrecto);

            System.out.println("Enviando correo, te avisaremos cuando esté enviado");

            validaToken(emailTeclado, nombreTeclado);

            //Aquí se añade un nuevo usuario, con el método utilizado también se comprueba si ya hay 2 usuarios registrados
            if (administracion.addUsuario(nombreTeclado, claveTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, tlfTeclado, emailTeclado))
                System.out.println("Usuario registrado correctamente");
        } else {
            System.out.println("No quedan usuarios disponibles");
        }
    }

    public static boolean opcionApagar() {
        char respuesta;
        System.out.println("¿Está seguro de cerrar la sesión? (Y/N)");
        respuesta = S.nextLine().toUpperCase().charAt(0);
        if (respuesta == 'Y') {
            Utils.apagando();
            return true;
        } else {
            System.out.println("El programa sigue en ejecución");
            Utils.pulsaParaCuntinuar();
        }
        return false;
    }

    public static boolean cierraSesion() {
        char respuesta;
        System.out.println("¿Está seguro de cerrar la sesión? (Y/N)");
        respuesta = S.nextLine().toUpperCase().charAt(0);
        if (respuesta == 'Y') {
            Utils.cierraSesion();
            return true;
        } else {
            System.out.println("El programa sigue en ejecución");
            Utils.pulsaParaCuntinuar();
        }
        return false;
    }

    public static void registraEnvio() {
        String usuario;
        System.out.print("¿A qué usuario le quieres asignar el envío?: ");
        usuario = S.nextLine();
        if (administracion.comprobacionUsuario(usuario)) {
            if (administracion.addEnvio(administracion.generaIDAleatorio(administracion.generaNumeroAleatorio()), usuario))
                System.out.println("Envío registrado correctamente");
            else System.out.println("No se pueden registrar más envíos");
        } else System.out.println("Usuario incorrecto o no es posible realizar envíos");
    }

    public static void asignaEnvio() {
        int seleccionarEnvio = -1;
        int seleccionarConductor = -1;
        int diasEntrega = -1;
        String conductor;

        System.out.println("""
                === Asignación de envíos sin conductor ===""");
        System.out.println(administracion.pintaEnviosSinRegistro());
        boolean datoCorrecto;

        do {
            datoCorrecto = true;
            try {
                System.out.print("Seleccione el envío a asignar: ");
                seleccionarEnvio = Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número");
                datoCorrecto = false;
                Utils.pulsaParaCuntinuar();
            }
        } while (!datoCorrecto);

        envioCopia = administracion.buscarEnvio(seleccionarEnvio);

        if (seleccionarEnvio > administracion.cuentaPaquetes()) {
            System.out.println("Número introducido incorrecto");
        } else {
            System.out.println("=== Asignación del paquete " + administracion.buscarNumero(seleccionarEnvio) + " ===");
            System.out.println(administracion.pintaInfoConductores());
            do {
                datoCorrecto = true;
                try {
                    System.out.println("Seleccione el conductor: ");
                    seleccionarConductor = Integer.parseInt(S.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Debes introducir un número");
                    datoCorrecto = false;
                    Utils.pulsaParaCuntinuar();
                }
            } while (!datoCorrecto);

            conductor = administracion.buscarConductor(seleccionarConductor, envioCopia);
            if (conductor.equals(""))
                System.out.println("No se pueden asignar más paquetes");
            else {

                do {
                    datoCorrecto = true;
                    try {
                        System.out.print("Asignado a " + conductor + ", indique los días aproximados para realizar la entrega: ");
                        diasEntrega = Integer.parseInt(S.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Debes introducir un número");
                        datoCorrecto = false;
                        Utils.pulsaParaCuntinuar();
                    }
                } while (!datoCorrecto);
                administracion.modificarFechaEnvio(diasEntrega, administracion.buscarNumero(seleccionarEnvio));
            }
        }
    }

    public static String cambiaNombre() {
        System.out.print("Introduce el nuevo nombre: ");
        String nuevoNombre = S.nextLine();
        administracion.setNombre(nuevoNombre);
        return nuevoNombre;
    }

    public static String cambiaClave() {
        System.out.print("Introduce la nueva clave: ");
        String nuevaClave = S.nextLine();
        administracion.setClave(nuevaClave);
        return nuevaClave;
    }

    public static String cambiaNombreConductor(String nombreTeclado) {
        System.out.print("Introduce el nuevo nombre: ");
        String nuevoNombre = S.nextLine();
        administracion.cambioNombreConductor(nuevoNombre, nombreTeclado);
        return nuevoNombre;
    }

    public static String cambiaClaveConductor(String claveTeclado) {
        System.out.print("Introduce la nueva clave: ");
        String nuevaClave = S.nextLine();
        administracion.cambioClaveConductor(nuevaClave, claveTeclado);
        return nuevaClave;
    }

    public static void cambiaDatosEnvio(String nombreTeclado) {
        boolean salirModificar = false;
        int op5 = -1;
        String nueva;

        do {
            boolean datoCorrecto;
            do {
                datoCorrecto = true;
                try {
                    System.out.print("""
                            === Modificar datos de entrega ===
                            1. Cambiar dirección
                            2. Cambiar localidad
                            3. Cambiar provincia
                            4. Salir
                            Elige la opción deseada: """);
                    op5 = Integer.parseInt(S.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Debes introducir un número");
                    datoCorrecto = false;
                    Utils.pulsaParaCuntinuar();
                }
            } while (!datoCorrecto);

            switch (op5) {
                case 1:
                    System.out.print("Introduce la nueva dirección: ");
                    nueva = S.nextLine();
                    administracion.cambiarDireccion(nueva, nombreTeclado);
                    break;
                case 2:
                    System.out.print("Introduce la nueva localidad: ");
                    nueva = S.nextLine();
                    administracion.cambiarLocalidad(nueva, nombreTeclado);
                    break;
                case 3:
                    System.out.print("Introduce la nueva provincia: ");
                    nueva = S.nextLine();
                    administracion.cambiarProvincia(nueva, nombreTeclado);
                    break;

                case 4:
                    Utils.saliendo();
                    salirModificar = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    Utils.pulsaParaCuntinuar();
                    break;
            }
        } while (!salirModificar);
    }

    public static String cambiaNombreUsuario(String nombreTeclado) {
        System.out.print("Introduce el nuevo nombre: ");
        String nuevoNombre = S.nextLine();
        administracion.cambioNombreUsuario(nuevoNombre, nombreTeclado);
        return nuevoNombre;
    }

    public static String cambiaClaveUsuario(String claveTeclado) {
        System.out.print("Introduce la nueva clave: ");
        String nuevaClave = S.nextLine();
        administracion.cambioClaveUsuario(nuevaClave, claveTeclado);
        return nuevaClave;
    }

    public static void actualizaEstadoEnvio(String nombreTeclado) {
        int seleccionarEnvio = -1;
        String respuestaEstado;

        System.out.println("""
                === Actualización del estado de envíos ===""");
        System.out.println(administracion.pintaEnviosActualizacion());
        boolean datoCorrecto;
        do {
            datoCorrecto = true;
            try {
                System.out.print("Seleccione el envío a modificar: ");
                seleccionarEnvio = Integer.parseInt(S.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número");
                datoCorrecto = false;
                Utils.pulsaParaCuntinuar();
            }
        } while (!datoCorrecto);

        System.out.println("=== Estado del pedido " + administracion.buscarNumero(seleccionarEnvio) + " ===");
        System.out.println("""
                1. En oficina de origen
                2. En almacén
                3. En reparto
                4. Entregado""");
        System.out.println("Seleccione el estado: ");
        respuestaEstado = S.nextLine();
        if (respuestaEstado.equals("1")) respuestaEstado = "En oficina de origen";
        if (respuestaEstado.equals("2")) respuestaEstado = "En almacén";
        if (respuestaEstado.equals("3")) respuestaEstado = "En reparto";
        if (respuestaEstado.equals("4")) respuestaEstado = "Entregado";
        administracion.cambiaEstado(administracion.buscarNumero(seleccionarEnvio), respuestaEstado, nombreTeclado);

        System.out.println("Envío " + administracion.buscarNumero(seleccionarEnvio) + ": " + respuestaEstado);

    }

    public static boolean datosprueba() {
        System.out.println("¿Introducir datos de prueba? (s/n)");
        return (S.nextLine().equals("s")) ? true : false;
    }
}

