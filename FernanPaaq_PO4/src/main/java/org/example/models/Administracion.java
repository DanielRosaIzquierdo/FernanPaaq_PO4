package org.example.models;

import org.example.coms.Comunicaciones;
import org.example.coms.Telegram;
import org.example.utils.PlantillaEmail;

import java.time.LocalDate;

public class Administracion {
    // Atributos
    private String nombre = "admin";
    private String clave = "1234";

    private Usuario usuario1;
    private Usuario usuario2;

    final private Conductor conductor1 = new Conductor("JoseConductor", "123", "Jaén", 600213245);
    final private Conductor conductor2 = new Conductor("MiguelConductor", "456", "Córdoba", 600785412);
    final private Conductor conductor3 = new Conductor("PacoConductor", "789", "Sevilla", 600986532);

    //Getters y Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    public Conductor getConductor1() {
        return conductor1;
    }

    public Conductor getConductor2() {
        return conductor2;
    }

    public Conductor getConductor3() {
        return conductor3;
    }

    //Otros métodos
    public String login(String nombre, String clave) {
        if (this.nombre.equals(nombre) && this.clave.equals(clave)) return "administrador";
        if (usuario1 != null && usuario1.getNombre().equals(nombre) && usuario1.getClave().equals(clave))
            return "usuario";
        if (usuario2 != null && usuario2.getNombre().equals(nombre) && usuario2.getClave().equals(clave))
            return "usuario";
        if (conductor1 != null && conductor1.getNombre().equals(nombre) && conductor1.getClave().equals(clave))
            return "conductor";
        if (conductor2 != null && conductor2.getNombre().equals(nombre) && conductor2.getClave().equals(clave))
            return "conductor";
        if (conductor3 != null && conductor3.getNombre().equals(nombre) && conductor3.getClave().equals(clave))
            return "conductor";
        return "";
    }

    public boolean addUsuario(String nombre, String clave, String direccion, String localidad, String provincia, int tlf, String email) {
        if (usuario1 == null) {
            usuario1 = new Usuario(nombre, clave, direccion, localidad, provincia, tlf, email);
            return true;
        } else if (usuario2 == null) {
            usuario2 = new Usuario(nombre, clave, direccion, localidad, provincia, tlf, email);
            return true;
        }
        return false;
    }

    public int numeroUsuarios() {
        int cont = 0;

        if (usuario1 != null) cont++;
        if (usuario2 != null) cont++;
        return cont;
    }


    public boolean addEnvio(int numeroSeguimiento, String destinatario) {
        if (usuario1 != null) {
            if (destinatario.equals(usuario1.getNombre()) && usuario1.getEnvio1() == null) {
                usuario1.addEnvioUsuario(numeroSeguimiento, destinatario);
                if (conductor1.getProvincia().equals(usuario1.getProvincia())) {
                    if (conductor1.getEnvio1() == null) {
                        usuario1.getEnvio1().setEstado("En reparto");
                        conductor1.setEnvio1(usuario1.getEnvio1());
                    } else if (conductor1.getEnvio2() == null) {
                        usuario1.getEnvio1().setEstado("En reparto");
                        conductor1.setEnvio2(usuario1.getEnvio1());
                    }

                } else if (conductor2.getProvincia().equals(usuario1.getProvincia())) {
                    if (conductor2.getEnvio1() == null) {
                        usuario1.getEnvio1().setEstado("En reparto");
                        conductor2.setEnvio1(usuario1.getEnvio1());
                    } else if (conductor2.getEnvio2() == null) {
                        usuario1.getEnvio1().setEstado("En reparto");
                        conductor2.setEnvio2(usuario1.getEnvio1());
                    }

                } else if (conductor3.getProvincia().equals(usuario1.getProvincia())) {
                    if (conductor3.getEnvio1() == null) {
                        usuario1.getEnvio1().setEstado("En reparto");
                        conductor3.setEnvio1(usuario1.getEnvio1());
                    } else if (conductor3.getEnvio2() == null) {
                        usuario1.getEnvio1().setEstado("En reparto");
                        conductor3.setEnvio2(usuario1.getEnvio1());
                    }
                }

                return true;
            }
            if (destinatario.equals(usuario1.getNombre()) && usuario1.getEnvio2() == null) {
                usuario1.addEnvioUsuario(numeroSeguimiento, destinatario);
                if (conductor1.getProvincia().equals(usuario1.getProvincia())) {
                    if (conductor1.getEnvio1() == null) {
                        usuario1.getEnvio2().setEstado("En reparto");
                        conductor1.setEnvio1(usuario1.getEnvio2());
                    } else if (conductor1.getEnvio2() == null) {
                        usuario1.getEnvio2().setEstado("En reparto");
                        conductor1.setEnvio2(usuario1.getEnvio2());
                    }
                } else if (conductor2.getProvincia().equals(usuario1.getProvincia())) {
                    if (conductor2.getEnvio1() == null) {
                        usuario1.getEnvio2().setEstado("En reparto");
                        conductor2.setEnvio1(usuario1.getEnvio2());
                    } else if (conductor2.getEnvio2() == null) {
                        usuario1.getEnvio2().setEstado("En reparto");
                        conductor2.setEnvio2(usuario1.getEnvio2());
                    }
                } else if (conductor3.getProvincia().equals(usuario1.getProvincia())) {
                    if (conductor3.getEnvio1() == null) {
                        usuario1.getEnvio2().setEstado("En reparto");
                        conductor3.setEnvio1(usuario1.getEnvio2());
                    } else if (conductor3.getEnvio2() == null) {
                        usuario1.getEnvio2().setEstado("En reparto");
                        conductor3.setEnvio2(usuario1.getEnvio2());
                    }
                }

                return true;
            }
        }

        if (usuario2 != null) {
            if (destinatario.equals(usuario2.getNombre()) && usuario2.getEnvio1() == null) {
                usuario2.addEnvioUsuario(numeroSeguimiento, destinatario);
                if (conductor1.getProvincia().equals(usuario2.getProvincia())) {
                    if (conductor1.getEnvio1() == null) {
                        usuario2.getEnvio1().setEstado("En reparto");
                        conductor1.setEnvio1(usuario2.getEnvio1());
                    } else if (conductor1.getEnvio2() == null) {
                        usuario2.getEnvio1().setEstado("En reparto");
                        conductor1.setEnvio2(usuario2.getEnvio1());
                    }
                } else if (conductor2.getProvincia().equals(usuario2.getProvincia())) {
                    if (conductor2.getEnvio1() == null) {
                        usuario2.getEnvio1().setEstado("En reparto");
                        conductor2.setEnvio1(usuario2.getEnvio1());
                    } else if (conductor2.getEnvio2() == null) {
                        usuario2.getEnvio1().setEstado("En reparto");
                        conductor2.setEnvio2(usuario2.getEnvio1());
                    }
                } else if (conductor3.getProvincia().equals(usuario2.getProvincia())) {
                    if (conductor3.getEnvio1() == null) {
                        usuario2.getEnvio1().setEstado("En reparto");
                        conductor3.setEnvio1(usuario2.getEnvio1());
                    } else if (conductor3.getEnvio2() == null) {
                        usuario2.getEnvio1().setEstado("En reparto");
                        conductor3.setEnvio2(usuario2.getEnvio1());
                    }
                }

                return true;
            }
            if (destinatario.equals(usuario2.getNombre()) && usuario2.getEnvio2() == null) {
                usuario2.addEnvioUsuario(numeroSeguimiento, destinatario);
                if (conductor1.getProvincia().equals(usuario2.getProvincia())) {
                    if (conductor1.getEnvio1() == null) {
                        usuario2.getEnvio2().setEstado("En reparto");
                        conductor1.setEnvio1(usuario2.getEnvio2());
                    } else if (conductor1.getEnvio2() == null) {
                        usuario2.getEnvio2().setEstado("En reparto");
                        conductor1.setEnvio2(usuario2.getEnvio2());
                    }
                } else if (conductor2.getProvincia().equals(usuario2.getProvincia())) {
                    if (conductor2.getEnvio1() == null) {
                        usuario2.getEnvio2().setEstado("En reparto");
                        conductor2.setEnvio1(usuario2.getEnvio2());
                    } else if (conductor2.getEnvio2() == null) {
                        usuario2.getEnvio2().setEstado("En reparto");
                        conductor2.setEnvio2(usuario2.getEnvio2());
                    }
                } else if (conductor3.getProvincia().equals(usuario2.getProvincia())) {
                    if (conductor3.getEnvio1() == null) {
                        usuario2.getEnvio2().setEstado("En reparto");
                        conductor3.setEnvio1(usuario2.getEnvio2());
                    } else if (conductor3.getEnvio2() == null) {
                        usuario2.getEnvio2().setEstado("En reparto");
                        conductor3.setEnvio2(usuario2.getEnvio2());
                    }
                }

                return true;
            }
        }
        return false;
    }

    public boolean comprobacionUsuario(String usuario) {
        if (usuario1 != null) {
            if (usuario.equals(usuario1.getNombre()) && usuario1.getEnvio1() == null) return true;
            if (usuario.equals(usuario1.getNombre()) && usuario1.getEnvio2() == null) return true;
        }

        if (usuario2 != null) {
            if (usuario.equals(usuario2.getNombre()) && usuario2.getEnvio1() == null) return true;
            if (usuario.equals(usuario2.getNombre()) && usuario2.getEnvio2() == null) return true;
        }
        return false;
    }

    public String pintaUsuarios() {
        String resultado = "";
        if (usuario1 != null) resultado += usuario1.toString();
        if (usuario2 != null) resultado += usuario2.toString();
        return resultado;
    }

    public String pintaEnvios() {
        String resultado = "";
        if (usuario1 != null) {
            if (usuario1.getEnvio1() != null) {
                resultado += usuario1.getEnvio1().toString();
                resultado += "- Nombre: " + usuario1.getNombre() + "\n" +
                        "- Dirección: " + usuario1.getDireccion() + "\n" +
                        "- Localidad: " + usuario1.getLocalidad() + "\n" +
                        "- Provincia: " + usuario1.getProvincia() + "\n";
            }
            if (usuario1.getEnvio2() != null) {
                resultado += usuario1.getEnvio2().toString();
                resultado += "- Nombre: " + usuario1.getNombre() + "\n" +
                        "- Dirección: " + usuario1.getDireccion() + "\n" +
                        "- Localidad: " + usuario1.getLocalidad() + "\n" +
                        "- Provincia: " + usuario1.getProvincia() + "\n";
            }
        }

        if (usuario2 != null) {
            if (usuario2.getEnvio1() != null) {
                resultado += usuario2.getEnvio1().toString();
                resultado += "- Nombre: " + usuario2.getNombre() + "\n" +
                        "- Dirección: " + usuario2.getDireccion() + "\n" +
                        "- Localidad: " + usuario2.getLocalidad() + "\n" +
                        "- Provincia: " + usuario2.getProvincia() + "\n";
            }
            if (usuario2.getEnvio2() != null) {
                resultado += usuario2.getEnvio2().toString();
                resultado += "- Nombre: " + usuario2.getNombre() + "\n" +
                        "- Dirección: " + usuario2.getDireccion() + "\n" +
                        "- Localidad: " + usuario2.getLocalidad() + "\n" +
                        "- Provincia: " + usuario2.getProvincia() + "\n";
            }
        }


        return resultado;
    }

    public String pintaEnviosSinRegistro() {
        String resultado = "";
        int cont = 1;
        if (usuario1 != null) {
            if (usuario1.getEnvio1() != null) {
                if (usuario1.getEnvio1().getEstado().equals("En oficina de origen")) {
                    resultado += cont + ". " + usuario1.getEnvio1().pintaEnviosSinRegistro();
                    cont++;
                }
            }
            if (usuario1.getEnvio2() != null) {
                if (usuario1.getEnvio2().getEstado().equals("En oficina de origen")) {
                    resultado += cont + ". " + usuario1.getEnvio2().pintaEnviosSinRegistro();
                    cont++;
                }
            }
        }
        if (usuario2 != null) {
            if (usuario2.getEnvio1() != null) {
                if (usuario2.getEnvio1().getEstado().equals("En oficina de origen")) {
                    resultado += cont + ". " + usuario2.getEnvio1().pintaEnviosSinRegistro();
                    cont++;
                }
            }
            if (usuario2.getEnvio2() != null) {
                if (usuario2.getEnvio2().getEstado().equals("En oficina de origen"))
                    resultado += cont + ". " + usuario2.getEnvio2().pintaEnviosSinRegistro();
            }
        }
        return resultado;
    }

    public int buscarNumero(int opcion) {
        int resultado = 0;
        int numero = 1;
        if (usuario1 != null) {
            if (usuario1.getEnvio1() != null) {
                if (opcion == numero) resultado = usuario1.getEnvio1().getNumeroSeguimiento();
                numero++;
            }
            if (usuario1.getEnvio2() != null) {
                if (opcion == numero) resultado = usuario1.getEnvio2().getNumeroSeguimiento();
                numero++;
            }
        }
        if (usuario2 != null) {
            if (usuario2.getEnvio1() != null) {
                if (opcion == numero) resultado = usuario2.getEnvio1().getNumeroSeguimiento();
                numero++;
            }
            if (usuario2.getEnvio2() != null) {
                if (opcion == numero) resultado = usuario2.getEnvio2().getNumeroSeguimiento();
            }
        }
        return resultado;
    }

    public String pintaConductores() {
        String resultado = conductor1.toString() + conductor2.toString() + conductor3.toString();
        return resultado;
    }

    public String buscarConductor(int opcion, Envio envio) {
        int numero = 1;
        String conductor = "";
        if (conductor1 != null) {
            if (opcion == numero) {
                if (conductor1.getEnvio1() == null) {
                    Telegram.enviaMensajeTelegram("Se te asigno un paquete " + conductor1.getNombre());
                    conductor1.setEnvio1(envio);
                    conductor = conductor1.getNombre();

                } else if (conductor1.getEnvio2() == null) {
                    Telegram.enviaMensajeTelegram("Se te asigno un paquete " + conductor1.getNombre());
                    conductor1.setEnvio2(envio);
                    conductor = conductor1.getNombre();
                }
            }
            numero++;
        }
        if (conductor2 != null) {
            if (opcion == numero) {
                if (conductor2.getEnvio1() == null) {
                    Telegram.enviaMensajeTelegram("Se te asigno un paquete " + conductor2.getNombre());
                    conductor2.setEnvio1(envio);
                    conductor = conductor2.getNombre();
                } else if (conductor2.getEnvio2() == null) {
                    Telegram.enviaMensajeTelegram("Se te asigno un paquete " + conductor2.getNombre());
                    conductor2.setEnvio2(envio);
                    conductor = conductor2.getNombre();
                }
            }
            numero++;
        }
        if (conductor3 != null) {
            if (opcion == numero) {
                if (conductor3.getEnvio1() == null) {
                    Telegram.enviaMensajeTelegram("Se te asigno un paquete " + conductor3.getNombre());
                    conductor3.setEnvio1(envio);
                    conductor = conductor3.getNombre();
                } else if (conductor3.getEnvio2() == null) {
                    Telegram.enviaMensajeTelegram("Se te asigno un paquete " + conductor3.getNombre());
                    conductor3.setEnvio2(envio);
                    conductor = conductor3.getNombre();
                }
            }
        }
        return conductor;
    }

    public Envio buscarEnvio(int opcion) {
        if (usuario1 != null) {
            if (usuario1.getEnvio1() != null) {
                if (buscarNumero(opcion) == usuario1.getEnvio1().getNumeroSeguimiento()) {
                    usuario1.getEnvio1().setEstado("En reparto");
                    return new Envio(buscarNumero(opcion), "En reparto", usuario1.getNombre(), usuario1.getLocalidad(), usuario1.getProvincia());
                }
            }
            if (usuario1.getEnvio2() != null) {
                if (buscarNumero(opcion) == usuario1.getEnvio2().getNumeroSeguimiento()) {
                    usuario1.getEnvio2().setEstado("En reparto");
                    return new Envio(buscarNumero(opcion), "En reparto", usuario1.getNombre(), usuario1.getLocalidad(), usuario1.getProvincia());
                }
            }
        }
        if (usuario2 != null) {
            if (usuario2.getEnvio1() != null) {
                if (buscarNumero(opcion) == usuario2.getEnvio1().getNumeroSeguimiento()) {
                    usuario2.getEnvio1().setEstado("En reparto");
                    return new Envio(buscarNumero(opcion), "En reparto", usuario2.getNombre(), usuario2.getLocalidad(), usuario2.getProvincia());
                }
            }
            if (usuario2.getEnvio2() != null) {
                if (buscarNumero(opcion) == usuario2.getEnvio2().getNumeroSeguimiento()) {
                    usuario2.getEnvio2().setEstado("En reparto");
                    return new Envio(buscarNumero(opcion), "En reparto", usuario2.getNombre(), usuario2.getLocalidad(), usuario2.getProvincia());
                }
            }
        }
        return null;
    }

    public String pintaInfoConductores() {
        String resultado = "";
        int cont = 1;
        if (conductor1 != null) {
            resultado += cont + ". " + conductor1.infoConductor();
            cont++;
        }

        if (conductor2 != null) {
            resultado += cont + ". " + conductor2.infoConductor();
            cont++;
        }

        if (conductor3 != null) {
            resultado += cont + ". " + conductor3.infoConductor();
        }

        return resultado;
    }

    public void modificarFechaEnvio(int dias, int numSeguimiento) {

        if (conductor1.getEnvio1() != null) {
            if (conductor1.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                conductor1.getEnvio1().setFechaEnvio(LocalDate.now());
                LocalDate fechaEntrega = conductor1.getEnvio1().getFechaEnvio().plusDays(dias);
                conductor1.getEnvio1().setFechaEntrega(fechaEntrega);
                if (usuario1 != null) {
                    if (usuario1.getEnvio1() != null) {
                        if (usuario1.getEnvio1().getNumeroSeguimiento() == numSeguimiento)
                            usuario1.getEnvio1().setFechaEntrega(fechaEntrega);
                    }
                    if (usuario1.getEnvio2() != null) {
                        if (usuario1.getEnvio2().getNumeroSeguimiento() == numSeguimiento)
                            usuario1.getEnvio2().setFechaEntrega(fechaEntrega);
                    }
                }

                if (usuario2 != null) {
                    if (usuario2.getEnvio1() != null) {
                        if (usuario2.getEnvio1().getNumeroSeguimiento() == numSeguimiento)
                            usuario2.getEnvio1().setFechaEntrega(fechaEntrega);
                    }
                    if (usuario2.getEnvio2() != null) {
                        if (usuario2.getEnvio2().getNumeroSeguimiento() == numSeguimiento)
                            usuario2.getEnvio2().setFechaEntrega(fechaEntrega);
                    }
                }
            }
        }

        if (conductor1.getEnvio2() != null) {
            if (conductor1.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                conductor1.getEnvio2().setFechaEnvio(LocalDate.now());
                LocalDate fechaEntrega = conductor1.getEnvio2().getFechaEnvio().plusDays(dias);
                conductor1.getEnvio2().setFechaEntrega(fechaEntrega);
                if (usuario1 != null) {
                    if (usuario1.getEnvio1() != null) {
                        if (usuario1.getEnvio1().getNumeroSeguimiento() == numSeguimiento)
                            usuario1.getEnvio1().setFechaEntrega(fechaEntrega);
                    }
                    if (usuario1.getEnvio2() != null) {
                        if (usuario1.getEnvio2().getNumeroSeguimiento() == numSeguimiento)
                            usuario1.getEnvio2().setFechaEntrega(fechaEntrega);
                    }
                }

                if (usuario2 != null) {
                    if (usuario2.getEnvio1() != null) {
                        if (usuario2.getEnvio1().getNumeroSeguimiento() == numSeguimiento)
                            usuario2.getEnvio1().setFechaEntrega(fechaEntrega);
                    }
                    if (usuario2.getEnvio2() != null) {
                        if (usuario2.getEnvio2().getNumeroSeguimiento() == numSeguimiento)
                            usuario2.getEnvio2().setFechaEntrega(fechaEntrega);
                    }
                }
            }
        }

        if (conductor2.getEnvio1() != null) {
            if (conductor2.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                conductor2.getEnvio1().setFechaEnvio(LocalDate.now());
                LocalDate fechaEntrega = conductor2.getEnvio1().getFechaEnvio().plusDays(dias);
                conductor2.getEnvio1().setFechaEntrega(fechaEntrega);
                if (usuario1 != null) {
                    if (usuario1.getEnvio1() != null) {
                        if (usuario1.getEnvio1().getNumeroSeguimiento() == numSeguimiento)
                            usuario1.getEnvio1().setFechaEntrega(fechaEntrega);
                    }
                    if (usuario1.getEnvio2() != null) {
                        if (usuario1.getEnvio2().getNumeroSeguimiento() == numSeguimiento)
                            usuario1.getEnvio2().setFechaEntrega(fechaEntrega);
                    }
                }

                if (usuario2 != null) {
                    if (usuario2.getEnvio1() != null) {
                        if (usuario2.getEnvio1().getNumeroSeguimiento() == numSeguimiento)
                            usuario2.getEnvio1().setFechaEntrega(fechaEntrega);
                    }
                    if (usuario2.getEnvio2() != null) {
                        if (usuario2.getEnvio2().getNumeroSeguimiento() == numSeguimiento)
                            usuario2.getEnvio2().setFechaEntrega(fechaEntrega);
                    }
                }
            }
        }

        if (conductor2.getEnvio2() != null) {
            if (conductor2.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                conductor2.getEnvio2().setFechaEnvio(LocalDate.now());
                LocalDate fechaEntrega = conductor2.getEnvio2().getFechaEnvio().plusDays(dias);
                conductor2.getEnvio2().setFechaEntrega(fechaEntrega);
                if (usuario1 != null) {
                    if (usuario1.getEnvio1() != null) {
                        if (usuario1.getEnvio1().getNumeroSeguimiento() == numSeguimiento)
                            usuario1.getEnvio1().setFechaEntrega(fechaEntrega);
                    }
                    if (usuario1.getEnvio2() != null) {
                        if (usuario1.getEnvio2().getNumeroSeguimiento() == numSeguimiento)
                            usuario1.getEnvio2().setFechaEntrega(fechaEntrega);
                    }
                }

                if (usuario2 != null) {
                    if (usuario2.getEnvio1() != null) {
                        if (usuario2.getEnvio1().getNumeroSeguimiento() == numSeguimiento)
                            usuario2.getEnvio1().setFechaEntrega(fechaEntrega);
                    }
                    if (usuario2.getEnvio2() != null) {
                        if (usuario2.getEnvio2().getNumeroSeguimiento() == numSeguimiento)
                            usuario2.getEnvio2().setFechaEntrega(fechaEntrega);
                    }

                }
            }
        }

        if (conductor3.getEnvio1() != null) {
            if (conductor3.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                conductor3.getEnvio1().setFechaEnvio(LocalDate.now());
                LocalDate fechaEntrega = conductor3.getEnvio1().getFechaEnvio().plusDays(dias);
                conductor3.getEnvio1().setFechaEntrega(fechaEntrega);
                if (usuario1 != null) {
                    if (usuario1.getEnvio1() != null) {
                        if (usuario1.getEnvio1().getNumeroSeguimiento() == numSeguimiento)
                            usuario1.getEnvio1().setFechaEntrega(fechaEntrega);
                    }
                    if (usuario1.getEnvio2() != null) {
                        if (usuario1.getEnvio2().getNumeroSeguimiento() == numSeguimiento)
                            usuario1.getEnvio2().setFechaEntrega(fechaEntrega);
                    }
                }

                if (usuario2 != null) {
                    if (usuario2.getEnvio1() != null) {
                        if (usuario2.getEnvio1().getNumeroSeguimiento() == numSeguimiento)
                            usuario2.getEnvio1().setFechaEntrega(fechaEntrega);
                    }
                    if (usuario2.getEnvio2() != null) {
                        if (usuario2.getEnvio2().getNumeroSeguimiento() == numSeguimiento)
                            usuario2.getEnvio2().setFechaEntrega(fechaEntrega);
                    }
                }
            }
        }

        if (conductor3.getEnvio2() != null) {
            if (conductor3.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                conductor3.getEnvio2().setFechaEnvio(LocalDate.now());
                LocalDate fechaEntrega = conductor3.getEnvio2().getFechaEnvio().plusDays(dias);
                conductor3.getEnvio2().setFechaEntrega(fechaEntrega);
                if (usuario1 != null) {
                    if (usuario1.getEnvio1() != null) {
                        if (usuario1.getEnvio1().getNumeroSeguimiento() == numSeguimiento)
                            usuario1.getEnvio1().setFechaEntrega(fechaEntrega);
                    }
                    if (usuario1.getEnvio2() != null) {
                        if (usuario1.getEnvio2().getNumeroSeguimiento() == numSeguimiento)
                            usuario1.getEnvio2().setFechaEntrega(fechaEntrega);
                    }
                }

                if (usuario2 != null) {
                    if (usuario2.getEnvio1() != null) {
                        if (usuario2.getEnvio1().getNumeroSeguimiento() == numSeguimiento)
                            usuario2.getEnvio1().setFechaEntrega(fechaEntrega);
                    }
                    if (usuario2.getEnvio2() != null) {
                        if (usuario2.getEnvio2().getNumeroSeguimiento() == numSeguimiento)
                            usuario2.getEnvio2().setFechaEntrega(fechaEntrega);
                    }
                }
            }
        }
    }

    public String pintaEnviosConductor(String nombre) {
        String resultado = "";
        if (nombre.equals(conductor1.getNombre())) {
            if (conductor1.getEnvio1() != null) {
                resultado += conductor1.getEnvio1().toString();

            }
            if (conductor1.getEnvio2() != null) {
                resultado += conductor1.getEnvio2().toString();
            }
        }

        if (nombre.equals(conductor2.getNombre())) {
            if (conductor2.getEnvio1() != null) {
                resultado += conductor2.getEnvio1().toString();

            }
            if (conductor2.getEnvio2() != null) {
                resultado += conductor2.getEnvio2().toString();
            }
        }

        if (nombre.equals(conductor3.getNombre())) {
            if (conductor3.getEnvio1() != null) {
                resultado += conductor3.getEnvio1().toString();

            }
            if (conductor3.getEnvio2() != null) {
                resultado += conductor3.getEnvio2().toString();
            }
        }

        return resultado;
    }

    public void cambioNombreConductor(String nuevoNombre, String nombreTeclado) {
        if (nombreTeclado.equals(conductor1.getNombre())) conductor1.setNombre(nuevoNombre);
        if (nombreTeclado.equals(conductor2.getNombre())) conductor2.setNombre(nuevoNombre);
        if (nombreTeclado.equals(conductor3.getNombre())) conductor3.setNombre(nuevoNombre);
    }

    public void cambioClaveConductor(String nuevaClave, String claveTeclado) {
        if (claveTeclado.equals(conductor1.getClave())) conductor1.setClave(nuevaClave);
        if (claveTeclado.equals(conductor2.getClave())) conductor2.setClave(nuevaClave);
        if (claveTeclado.equals(conductor3.getClave())) conductor3.setClave(nuevaClave);
    }

    public void cambioNombreUsuario(String nuevoNombre, String nombreTeclado) {
        if (usuario1 != null) {
            if (nombreTeclado.equals(usuario1.getNombre())) usuario1.setNombre(nuevoNombre);
        }

        if (usuario2 != null) {
            if (nombreTeclado.equals(usuario2.getNombre())) usuario2.setNombre(nuevoNombre);
        }
    }

    public void cambioClaveUsuario(String nuevaClave, String claveTeclado) {
        if (usuario1 != null) {
            if (claveTeclado.equals(usuario1.getClave())) usuario1.setClave(nuevaClave);
        }
        if (usuario2 != null) {
            if (claveTeclado.equals(usuario2.getClave())) usuario2.setClave(nuevaClave);
        }
    }

    public String pintaEnviosActualizacion() {
        String resultado = "";
        int cont = 1;
        if (usuario1 != null) {
            if (usuario1.getEnvio1() != null) {
                resultado += cont + ". " + usuario1.getEnvio1().pintaEnviosConRegistro();
                cont++;

            }
            if (usuario1.getEnvio2() != null) {
                resultado += cont + ". " + usuario1.getEnvio2().pintaEnviosConRegistro();
                cont++;

            }
        }
        if (usuario2 != null) {
            if (usuario2.getEnvio1() != null) {
                resultado += cont + ". " + usuario2.getEnvio1().pintaEnviosConRegistro();
                cont++;

            }
            if (usuario2.getEnvio2() != null) {
                resultado += cont + ". " + usuario2.getEnvio2().pintaEnviosConRegistro();
            }
        }
        return resultado;
    }

    public void cambiaEstado(int numSeguimiento, String respuesta, String nombreTeclado) {
        String contenido;
        if (usuario1 != null) {
            if (usuario1.getEnvio1() != null) {
                if (usuario1.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                    usuario1.getEnvio1().setEstado(respuesta);
                    usuario1.getEnvio1().fechaEntrega();
                    Comunicaciones.enviarMensaje(usuario1.getEmail(), "Cambio de estado del envío", PlantillaEmail.plantillaEmailPaquete(usuario1.getNombre(), usuario1.getEnvio1()));
                    if (conductor1.getEnvio1() != null) {
                        if (conductor1.validaConductor(nombreTeclado)) {
                            if (conductor1.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                                conductor1.getEnvio1().setEstado(respuesta);
                                conductor1.getEnvio1().fechaEntrega();
                            }
                        }
                    }

                    if (conductor1.getEnvio2() != null) {
                        if (conductor1.validaConductor(nombreTeclado)) {
                            if (conductor1.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                                conductor1.getEnvio2().setEstado(respuesta);
                                conductor1.getEnvio2().fechaEntrega();
                            }
                        }
                    }

                    if (conductor2.getEnvio1() != null) {
                        if (conductor2.validaConductor(nombreTeclado)) {
                            if (conductor2.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                                conductor2.getEnvio1().setEstado(respuesta);
                                conductor2.getEnvio1().fechaEntrega();
                            }
                        }
                    }

                    if (conductor2.getEnvio2() != null) {
                        if (conductor2.validaConductor(nombreTeclado)) {
                            if (conductor2.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                                conductor2.getEnvio2().setEstado(respuesta);
                                conductor2.getEnvio2().fechaEntrega();
                            }
                        }
                    }

                    if (conductor3.getEnvio1() != null) {
                        if (conductor3.validaConductor(nombreTeclado)) {
                            if (conductor3.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                                conductor3.getEnvio1().setEstado(respuesta);
                                conductor3.getEnvio1().fechaEntrega();
                            }
                        }
                    }
                    if (conductor3.getEnvio2() != null) {
                        if (conductor3.validaConductor(nombreTeclado)) {
                            if (conductor3.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                                conductor3.getEnvio2().setEstado(respuesta);
                                conductor3.getEnvio2().fechaEntrega();
                            }
                        }
                    }
                }
            }
            if (usuario1.getEnvio2() != null) {
                if (usuario1.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                    usuario1.getEnvio2().setEstado(respuesta);
                    usuario1.getEnvio2().fechaEntrega();
                    Comunicaciones.enviarMensaje(usuario1.getEmail(), "Cambio de estado del envío", PlantillaEmail.plantillaEmailPaquete(usuario1.getNombre(), usuario1.getEnvio2()));
                    if (conductor1.getEnvio1() != null) {
                        if (conductor1.validaConductor(nombreTeclado)) {
                            if (conductor1.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                                conductor1.getEnvio1().setEstado(respuesta);
                                conductor1.getEnvio1().fechaEntrega();
                            }
                        }
                    }

                    if (conductor1.getEnvio2() != null) {
                        if (conductor1.validaConductor(nombreTeclado)) {
                            if (conductor1.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                                conductor1.getEnvio2().setEstado(respuesta);
                                conductor1.getEnvio2().fechaEntrega();
                            }
                        }
                    }

                    if (conductor2.getEnvio1() != null) {
                        if (conductor2.validaConductor(nombreTeclado)) {
                            if (conductor2.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                                conductor2.getEnvio1().setEstado(respuesta);
                                conductor2.getEnvio1().fechaEntrega();
                            }
                        }
                    }

                    if (conductor2.getEnvio2() != null) {
                        if (conductor2.validaConductor(nombreTeclado)) {
                            if (conductor2.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                                conductor2.getEnvio2().setEstado(respuesta);
                                conductor2.getEnvio2().fechaEntrega();
                            }
                        }
                    }

                    if (conductor3.getEnvio1() != null) {
                        if (conductor3.validaConductor(nombreTeclado)) {
                            if (conductor3.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                                conductor3.getEnvio1().setEstado(respuesta);
                                conductor3.getEnvio1().fechaEntrega();
                            }
                        }
                    }
                    if (conductor3.getEnvio2() != null) {
                        if (conductor3.validaConductor(nombreTeclado)) {
                            if (conductor3.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                                conductor3.getEnvio2().setEstado(respuesta);
                                conductor3.getEnvio2().fechaEntrega();
                            }
                        }
                    }
                }
            }
        }
        if (usuario2 != null) {
            if (usuario2.getEnvio1() != null) {
                if (usuario2.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                    usuario2.getEnvio1().setEstado(respuesta);
                    usuario2.getEnvio1().fechaEntrega();
                    Comunicaciones.enviarMensaje(usuario2.getEmail(), "Cambio de estado del envío", PlantillaEmail.plantillaEmailPaquete(usuario2.getNombre(), usuario2.getEnvio1()));
                    if (conductor1.getEnvio1() != null) {
                        if (conductor1.validaConductor(nombreTeclado)) {
                            if (conductor1.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                                conductor1.getEnvio1().setEstado(respuesta);
                                conductor1.getEnvio1().fechaEntrega();
                            }
                        }
                    }

                    if (conductor1.getEnvio2() != null) {
                        if (conductor1.validaConductor(nombreTeclado)) {
                            if (conductor1.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                                conductor1.getEnvio2().setEstado(respuesta);
                                conductor1.getEnvio2().fechaEntrega();
                            }
                        }
                    }

                    if (conductor2.getEnvio1() != null) {
                        if (conductor2.validaConductor(nombreTeclado)) {
                            if (conductor2.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                                conductor2.getEnvio1().setEstado(respuesta);
                                conductor2.getEnvio1().fechaEntrega();
                            }
                        }
                    }

                    if (conductor2.getEnvio2() != null) {
                        if (conductor2.validaConductor(nombreTeclado)) {
                            if (conductor2.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                                conductor2.getEnvio2().setEstado(respuesta);
                                conductor2.getEnvio2().fechaEntrega();
                            }
                        }
                    }

                    if (conductor3.getEnvio1() != null) {
                        if (conductor3.validaConductor(nombreTeclado)) {
                            if (conductor3.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                                conductor3.getEnvio1().setEstado(respuesta);
                                conductor3.getEnvio1().fechaEntrega();
                            }
                        }
                    }
                    if (conductor3.getEnvio2() != null) {
                        if (conductor3.validaConductor(nombreTeclado)) {
                            if (conductor3.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                                conductor3.getEnvio2().setEstado(respuesta);
                                conductor3.getEnvio2().fechaEntrega();
                            }
                        }
                    }
                }
            }
            if (usuario2.getEnvio2() != null) {
                if (usuario2.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                    usuario2.getEnvio2().setEstado(respuesta);
                    usuario2.getEnvio2().fechaEntrega();
                    Comunicaciones.enviarMensaje(usuario2.getEmail(), "Cambio de estado del envío", PlantillaEmail.plantillaEmailPaquete(usuario2.getNombre(), usuario2.getEnvio2()));
                    if (conductor1.getEnvio1() != null) {
                        if (conductor1.validaConductor(nombreTeclado)) {
                            if (conductor1.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                                conductor1.getEnvio1().setEstado(respuesta);
                                conductor1.getEnvio1().fechaEntrega();
                            }
                        }
                    }

                    if (conductor1.getEnvio2() != null) {
                        if (conductor1.validaConductor(nombreTeclado)) {
                            if (conductor1.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                                conductor1.getEnvio2().setEstado(respuesta);
                                conductor1.getEnvio2().fechaEntrega();
                            }
                        }
                    }

                    if (conductor2.getEnvio1() != null) {
                        if (conductor2.validaConductor(nombreTeclado)) {
                            if (conductor2.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                                conductor2.getEnvio1().setEstado(respuesta);
                                conductor2.getEnvio1().fechaEntrega();
                            }
                        }
                    }

                    if (conductor2.getEnvio2() != null) {
                        if (conductor2.validaConductor(nombreTeclado)) {
                            if (conductor2.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                                conductor2.getEnvio2().setEstado(respuesta);
                                conductor2.getEnvio2().fechaEntrega();
                            }
                        }
                    }

                    if (conductor3.getEnvio1() != null) {
                        if (conductor3.validaConductor(nombreTeclado)) {
                            if (conductor3.getEnvio1().getNumeroSeguimiento() == numSeguimiento) {
                                conductor3.getEnvio1().setEstado(respuesta);
                                conductor3.getEnvio1().fechaEntrega();
                            }
                        }
                    }
                    if (conductor3.getEnvio2() != null) {
                        if (conductor3.validaConductor(nombreTeclado)) {
                            if (conductor3.getEnvio2().getNumeroSeguimiento() == numSeguimiento) {
                                conductor3.getEnvio2().setEstado(respuesta);
                                conductor3.getEnvio2().fechaEntrega();
                            }
                        }
                    }
                }
            }
        }
    }

    public int historicoPaquetes(String nombre) {
        if (conductor1.getNombre().equals(nombre)) return conductor1.historicoPaquetes();
        if (conductor2.getNombre().equals(nombre)) return conductor2.historicoPaquetes();
        if (conductor3.getNombre().equals(nombre)) return conductor3.historicoPaquetes();
        return -1;
    }

    public String enviosUsuario(String nombre) {
        String resultado = "";
        if (usuario1 != null) {
            if (nombre.equals(usuario1.getNombre())) {
                if (usuario1.getEnvio1() != null) {
                    resultado += usuario1.getEnvio1().toString();

                }
                if (usuario1.getEnvio2() != null) {
                    resultado += usuario1.getEnvio2().toString();
                }
            }
        }

        if (usuario2 != null) {
            if (nombre.equals(usuario2.getNombre())) {
                if (usuario2.getEnvio1() != null) {
                    resultado += usuario2.getEnvio1().toString();

                }
                if (usuario2.getEnvio2() != null) {
                    resultado += usuario2.getEnvio2().toString();
                }
            }
        }
        return resultado;
    }

    public void cambiarDireccion(String nueva, String nombre) {
        if (usuario1 != null) {
            if (usuario1.getNombre().equals(nombre)) usuario1.setDireccion(nueva);
        }

        if (usuario2 != null) {
            if (usuario2.getNombre().equals(nombre)) usuario2.setDireccion(nueva);
        }
    }

    public void cambiarLocalidad(String nueva, String nombre) {
        if (usuario1 != null) {
            if (usuario1.getNombre().equals(nombre)) usuario1.setLocalidad(nueva);
        }

        if (usuario2 != null) {
            if (usuario2.getNombre().equals(nombre)) usuario2.setLocalidad(nueva);
        }
    }

    public void cambiarProvincia(String nueva, String nombre) {
        if (usuario1 != null) {
            if (usuario1.getNombre().equals(nombre)) usuario1.setProvincia(nueva);
        }

        if (usuario2 != null) {
            if (usuario2.getNombre().equals(nombre)) usuario2.setProvincia(nueva);
        }
    }

    public String pintaDatosUsuario(String nombre) {
        if (usuario1 != null) {
            if (usuario1.getNombre().equals(nombre)) return usuario1.toString();
        }

        if (usuario2 != null) {
            if (usuario2.getNombre().equals(nombre)) return usuario2.toString();
        }

        return "";
    }

    public int cuentaPaquetes() {
        int cont = 0;
        if (usuario1 != null) {
            if (usuario1.getEnvio1() != null) cont++;
            if (usuario1.getEnvio2() != null) cont++;
        }

        if (usuario2 != null) {
            if (usuario2.getEnvio1() != null) cont++;
            if (usuario2.getEnvio2() != null) cont++;
        }
        return cont;
    }

    public int generaNumeroAleatorio() {
        return (int) (Math.random() * 100000);
    }

    public int generaIDAleatorio(int numAleatorio) {
        int id = 0;
        boolean repite = false;

        do {
            repite = false;
            id = generaNumeroAleatorio();
            if (usuario1 != null) {
                if (usuario1.getEnvio1() != null) {
                    if (id == usuario1.getEnvio1().getNumeroSeguimiento()) repite = true;
                }

                if (usuario1.getEnvio2() != null) {
                    if (id == usuario1.getEnvio2().getNumeroSeguimiento()) repite = true;
                }
            }

            if (usuario2 != null) {
                if (usuario2.getEnvio1() != null) {
                    if (id == usuario2.getEnvio1().getNumeroSeguimiento()) repite = true;
                }

                if (usuario2.getEnvio2() != null) {
                    if (id == usuario2.getEnvio2().getNumeroSeguimiento()) repite = true;
                }
            }
        } while (repite);

        return id;
    }
}
